package br.com.fatecmc.joaodebarro.model.dao;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CupomDAO implements IDAO {
    private Connection conn;

    @Override
    public EntidadeDominio salvar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO CUPONS VALUES(?, ?, ?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Cupom){
            try {                
                conn.setAutoCommit(false);
                
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, 0);
                stmt.setString(2, ((Cupom) entidade).getNome());
                stmt.setDouble(3, ((Cupom) entidade).getValor());
                stmt.setNull(4, Types.BOOLEAN);
                stmt.setDate(5, null);

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
        String sql = "UPDATE CUPONS SET cpm_nome=?, cpm_valor=?, cpm_status=? WHERE cpm_id=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Cupom){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Cupom) entidade).getNome());
                stmt.setDouble(2, ((Cupom) entidade).getValor());
                stmt.setBoolean(3, ((Cupom) entidade).getStatus());
                stmt.setInt(4, entidade.getId());
                
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
        String sql = "DELETE FROM CUPONS WHERE cpm_id=?";

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
        String sql = "SELECT * FROM CUPONS";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cupom> cupons = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Cupom cupom = new Cupom();
                
                cupom.setId(rs.getInt("cpm_id"));
                cupom.setNome(rs.getString("cpm_nome"));
                cupom.setValor(rs.getDouble("cpm_valor"));
                cupom.setStatus(rs.getBoolean("cpm_status"));
                cupom.setDt_cadastro(rs.getDate("cpm_dt_inclusao"));
                
                cupons.add(cupom);
            }
                
            return cupons;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
    @Override
    public EntidadeDominio consultar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM CUPONS WHERE cpm_id=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Cupom cupom = new Cupom ();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, entidade.getId());
                
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                cupom.setId(rs.getInt("cpm_id"));
                cupom.setNome(rs.getString("cpm_nome"));
                cupom.setValor(rs.getDouble("cpm_valor"));
                cupom.setStatus(rs.getBoolean("cpm_status"));
                cupom.setDt_cadastro(rs.getDate("cpm_dt_inclusao"));
            }
            
            return cupom;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
}
