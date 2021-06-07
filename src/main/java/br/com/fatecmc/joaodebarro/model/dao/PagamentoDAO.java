package br.com.fatecmc.joaodebarro.model.dao;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO implements IDAO {
    private Connection conn;

    @Override
    public EntidadeDominio salvar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO PAGAMENTOS VALUES(?, ?, ?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Pedido){
            try {                
                conn.setAutoCommit(false);
                
                Pagamento pgm = (Pagamento) ((Pedido) entidade).getPagamentos().toArray()[0];
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, 0);
                stmt.setInt(2, entidade.getId());
                stmt.setInt(3, pgm.getCartao().getId());
                stmt.setDouble(4, pgm.getValor());
                stmt.setDate(5, null);

                stmt.executeUpdate();
                
                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next()) pgm.setId(rs.getInt(1));
                
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
        String sql = "DELETE FROM PAGAMENTOS WHERE pgm_id=?";

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
        String sql = "SELECT * FROM PAGAMENTOS";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pedido> pedidos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Pedido pedido = new Pedido();
                Pagamento pagamento = new Pagamento();
                Cartao cartao = new Cartao();
                
                pagamento.setId(rs.getInt("pgm_id"));
                pedido.setId(rs.getInt("pgm_ped_id"));
                cartao.setId(rs.getInt("pgm_crt_id"));
                pagamento.setValor(rs.getDouble("pgm_valor"));
                pagamento.setDt_cadastro(rs.getDate("pgm_dt_inclusao"));
                pagamento.setCartao(cartao);
                
                pedido.getPagamentos().add(pagamento);
                
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
    public EntidadeDominio consultar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM PAGAMENTOS WHERE crt_id=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Pedido pedido = new Pedido();
        Pagamento pagamento = new Pagamento();
        Cartao cartao = new Cartao();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, entidade.getId());
                
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                pagamento.setId(rs.getInt("pgm_id"));
                pedido.setId(rs.getInt("pgm_ped_id"));
                cartao.setId(rs.getInt("pgm_crt_id"));
                pagamento.setValor(rs.getDouble("pgm_valor"));
                pagamento.setDt_cadastro(rs.getDate("pgm_dt_inclusao"));
                pagamento.setCartao(cartao);
                
                pedido.getPagamentos().add(pagamento);
            }
            
            return pedido;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
}
