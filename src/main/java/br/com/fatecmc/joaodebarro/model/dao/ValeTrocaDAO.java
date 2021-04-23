package br.com.fatecmc.joaodebarro.model.dao;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValeTrocaDAO implements IDAO {
    private Connection conn;

    @Override
    public EntidadeDominio salvar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO VALES_TROCAS VALUES(?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Cliente){
            try {                
                conn.setAutoCommit(false);
                
                ValeTroca vt = (ValeTroca) ((Cliente) entidade).getVales().toArray()[0];
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, 0);
                stmt.setInt(2, ((Cliente) entidade).getId());
                stmt.setNull(3, Types.INTEGER);
                stmt.setString(4, null);
                stmt.setDouble(5, vt.getValor());
                stmt.setDate(6, null);

                stmt.executeUpdate();
                
                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next()) entidade.setId(rs.getInt(1));
                
                conn.commit();	
            } catch (SQLException ex) {
                System.out.println("Não foi possível salvar os dados no banco de dados.\nErro: " + ex.getMessage());
            } finally {
                ConnectionFactory.closeConnection(conn, stmt);
            }
        }
        return entidade;
    }

    @Override
    public boolean alterar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "UPDATE VALES_TROCAS SET vlt_ped_id=?, vlt_valor=? WHERE vlt_id=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Pedido){
            try {
                ValeTroca vt = (ValeTroca) ((Pedido) entidade).getVales().toArray()[0];
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, ((Pedido) entidade).getId());
                stmt.setDouble(2, vt.getValor());
                stmt.setInt(3, vt.getId());
                
                if(stmt.executeUpdate() == 1) return true;
            } catch (SQLException ex) {
                System.out.println("Não foi possível alterar os dados no banco de dados.\nErro: " + ex.getMessage());
            } finally {
                ConnectionFactory.closeConnection(conn, stmt);
            }
        }
        return false;
    }

    @Override
    public boolean excluir(int id) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM VALES_TROCAS WHERE vlt_id=?";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            if(stmt.executeUpdate() == 1) return true;
        } catch (SQLException ex) {
            System.out.println("Não foi possível excluir os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
        return false;
    }
    
    @Override
    public List consultar() {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM VALES_TROCAS";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pedido> pedidos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Pedido pedido = new Pedido();
                Cliente cliente = new Cliente();
                ValeTroca vale = new ValeTroca();
                
                vale.setId(rs.getInt("vlt_id"));
                cliente.setId(rs.getInt("vlt_cli_id"));
                pedido.setId(rs.getInt("vlt_ped_id"));
                vale.setCodigo(rs.getString("vlt_codigo"));
                vale.setValor(rs.getDouble("vlt_valor"));
                vale.setDt_cadastro(rs.getDate("vlt_dt_inclusao"));
                cliente.setVales(Arrays.asList(vale));
                pedido.setCliente(cliente);
                
                pedidos.add(pedido);
            }
                
            return pedidos;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
    @Override
    public EntidadeDominio consultar(int id) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM VALES_TROCAS WHERE vlt_id=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Pedido pedido = new Pedido();
        Cliente cliente = new Cliente();
        ValeTroca vale = new ValeTroca();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
                
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                vale.setId(rs.getInt("vlt_id"));
                cliente.setId(rs.getInt("vlt_cli_id"));
                pedido.setId(rs.getInt("vlt_ped_id"));
                vale.setCodigo(rs.getString("vlt_codigo"));
                vale.setValor(rs.getDouble("vlt_valor"));
                vale.setDt_cadastro(rs.getDate("vlt_dt_inclusao"));
                cliente.setVales(Arrays.asList(vale));
                pedido.setCliente(cliente);
            }
            
            return pedido;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
    public EntidadeDominio consultarPorCliente(Cliente cliente) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM VALES_TROCAS WHERE vlt_cli_id=? AND vlt_ped_id IS NULL";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
                
            rs = stmt.executeQuery();
            
            cliente.setVales(new ArrayList<ValeTroca>());
            while(rs.next()) {
                ValeTroca vale = new ValeTroca();
                
                vale.setId(rs.getInt("vlt_id"));
                cliente.setId(rs.getInt("vlt_cli_id"));
                vale.setCodigo(rs.getString("vlt_codigo"));
                vale.setValor(rs.getDouble("vlt_valor"));
                vale.setDt_cadastro(rs.getDate("vlt_dt_inclusao"));
                
                cliente.getVales().add(vale);
            }
                
            return cliente;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
}
