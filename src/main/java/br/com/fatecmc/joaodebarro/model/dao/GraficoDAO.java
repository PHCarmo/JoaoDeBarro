package br.com.fatecmc.joaodebarro.model.dao;

import br.com.fatecmc.joaodebarro.control.data.ConsultaGrafico;
import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GraficoDAO implements IDAO {
    private Connection conn;

    @Override
    public EntidadeDominio salvar(EntidadeDominio entidade) {
        return entidade;
    }

    @Override
    public boolean alterar(EntidadeDominio entidade) {
        return false;
    }

    @Override
    public boolean excluir(int id) {
        return false;
    }

    @Override
    public List consultar() {
        return null;
    }
    
    @Override
    public EntidadeDominio consultar(EntidadeDominio entidade) {
        if(entidade instanceof ConsultaGrafico){
            ConsultaGrafico cg = (ConsultaGrafico) entidade;
            switch(cg.getGrafico()){
                case "VendaStatus": cg.setData(consultarVendaStatus(cg)); break;
                case "VendaValor": cg.setData(consultarVendaValor(cg)); break;
                case "CadastroNovo": cg.setData(consultarCadastroNovo(cg)); break;
            }
            return cg;
        }else{
            return entidade;
        }
    }
    
    public List<Object[]> consultarVendaStatus(ConsultaGrafico consulta) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT spd_nome, COUNT(ped_id) FROM (SELECT spd_nome, spd_id FROM STATUS_PEDIDOS) A "
                + "LEFT JOIN (SELECT ped_id, ped_spd_id FROM PEDIDOS WHERE ped_dt_inclusao BETWEEN ? AND ?) B ON ped_spd_id=spd_id GROUP BY spd_nome ORDER BY 1;";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Object[]> data = new ArrayList<>();
        String[] titles = {"Status","Quantidade"};
        data.add(titles);
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new Date(consulta.getDt_inicio().getTime()));
            stmt.setDate(2, new Date(consulta.getDt_fim().getTime()));
                
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                String status = rs.getString("spd_nome");
                int qtd = rs.getInt("COUNT(ped_id)");
                
                Object[] row = {status, qtd};
                data.add(row);
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return data;
    }
    
    public List<Object[]> consultarVendaValor(ConsultaGrafico consulta) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT CONCAT(MONTHNAME(ped_dt_inclusao), '/', YEAR(ped_dt_inclusao)) AS 'Periodo', "
            + "SUM(ped_valor_produtos) AS 'Vendido', SUM(ped_valor_desconto) AS 'Descontado', "
            + "(SUM(ped_valor_produtos) + SUM(ped_valor_frete) - SUM(ped_valor_desconto)) AS 'Faturado' "
            + "FROM PEDIDOS WHERE ped_dt_inclusao BETWEEN ? AND ? GROUP BY 1;";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Object[]> data = new ArrayList<>();
        String[] titles = {"Mês/Ano","Vendido","Descontado","Faturado"};
        data.add(titles);
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new Date(consulta.getDt_inicio().getTime()));
            stmt.setDate(2, new Date(consulta.getDt_fim().getTime()));
                
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                String periodo = rs.getString("Periodo");
                double vend = rs.getDouble("Vendido");
                double desc = rs.getDouble("Descontado");
                double fatu = rs.getDouble("Faturado");
                
                Object[] row = {periodo, vend, desc, fatu};
                data.add(row);
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return data;
    }
    
    public List<Object[]> consultarCadastroNovo(ConsultaGrafico consulta) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT Periodo, Vendas, Clientes, Produtos FROM "
            + "(SELECT CONCAT(MONTHNAME(ped_dt_inclusao), '/', YEAR(ped_dt_inclusao)) AS Periodo FROM PEDIDOS WHERE ped_dt_inclusao BETWEEN ? AND ? "
            + "UNION SELECT CONCAT(MONTHNAME(cli_dt_inclusao), '/', YEAR(cli_dt_inclusao)) FROM CLIENTES WHERE cli_dt_inclusao BETWEEN ? AND ? "
            + "UNION SELECT CONCAT(MONTHNAME(prd_dt_inclusao), '/', YEAR(prd_dt_inclusao)) FROM PRODUTOS WHERE prd_dt_inclusao BETWEEN ? AND ?) X "
            + "LEFT JOIN (SELECT CONCAT(MONTHNAME(ped_dt_inclusao), '/', YEAR(ped_dt_inclusao)) AS PeriodoV, COUNT(ped_id) AS Vendas FROM PEDIDOS WHERE ped_dt_inclusao BETWEEN ? AND ? GROUP BY 1) V ON PeriodoV=Periodo "
            + "LEFT JOIN (SELECT CONCAT(MONTHNAME(cli_dt_inclusao), '/', YEAR(cli_dt_inclusao)) AS PeriodoC, COUNT(cli_id) AS Clientes FROM CLIENTES WHERE cli_dt_inclusao BETWEEN ? AND ? GROUP BY 1) C ON PeriodoC=Periodo "
            + "LEFT JOIN (SELECT CONCAT(MONTHNAME(prd_dt_inclusao), '/', YEAR(prd_dt_inclusao)) AS PeriodoP, COUNT(prd_id) AS Produtos FROM PRODUTOS WHERE prd_dt_inclusao BETWEEN ? AND ? GROUP BY 1) P ON PeriodoP=Periodo;";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Object[]> data = new ArrayList<>();
        String[] titles = {"Mês/Ano","Clientes","Produtos","Vendas"};
        data.add(titles);
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new Date(consulta.getDt_inicio().getTime()));
            stmt.setDate(2, new Date(consulta.getDt_fim().getTime()));
            stmt.setDate(3, new Date(consulta.getDt_inicio().getTime()));
            stmt.setDate(4, new Date(consulta.getDt_fim().getTime()));
            stmt.setDate(5, new Date(consulta.getDt_inicio().getTime()));
            stmt.setDate(6, new Date(consulta.getDt_fim().getTime()));
            stmt.setDate(7, new Date(consulta.getDt_inicio().getTime()));
            stmt.setDate(8, new Date(consulta.getDt_fim().getTime()));
            stmt.setDate(9, new Date(consulta.getDt_inicio().getTime()));
            stmt.setDate(10, new Date(consulta.getDt_fim().getTime()));
            stmt.setDate(11, new Date(consulta.getDt_inicio().getTime()));
            stmt.setDate(12, new Date(consulta.getDt_fim().getTime()));
                
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                String periodo = rs.getString("Periodo");
                int clie = rs.getInt("Clientes");
                int prod = rs.getInt("Produtos");
                int vend = rs.getInt("Vendas");
                
                Object[] row = {periodo, clie, prod, vend};
                data.add(row);
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return data;
    }
    
}
