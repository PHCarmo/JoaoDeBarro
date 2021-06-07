package br.com.fatecmc.joaodebarro.model.dao;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDAO implements IDAO {
    private Connection conn;

    @Override
    public EntidadeDominio salvar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO CARRINHOS VALUES(?, ?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Carrinho){
            try {                
                conn.setAutoCommit(false);
                
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, 0);
                stmt.setString(2, ((Carrinho) entidade).getSession().getId());
                stmt.setDate(3, new Date(((Carrinho) entidade).getSession().getDt_criacao().getTime()));
                stmt.setDate(4, null);

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
        return false;
    }

    @Override
    public boolean excluir(int id) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM CARRINHOS WHERE car_id=?";

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
        String sql = "SELECT * FROM CARRINHOS";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Carrinho> carrinhos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Carrinho carrinho = new Carrinho();
                Session session = new Session();
                
                carrinho.setId(rs.getInt("car_id"));
                session.setId(rs.getString("car_session_id"));
                session.setDt_criacao(rs.getDate("car_session_criacao"));
                carrinho.setDt_cadastro(rs.getDate("car_dt_inclusao"));
                carrinho.setSession(session);
                
                carrinhos.add(carrinho);
            }
                
            return carrinhos;
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
        String sql = "SELECT * FROM CARRINHOS WHERE car_id=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Carrinho carrinho = new Carrinho();
        Session session = new Session();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, entidade.getId());
                
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                carrinho.setId(rs.getInt("car_id"));
                session.setId(rs.getString("car_session_id"));
                session.setDt_criacao(rs.getDate("car_session_criacao"));
                carrinho.setDt_cadastro(rs.getDate("car_dt_inclusao"));
                carrinho.setSession(session);
            }
            
            return carrinho;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
}
