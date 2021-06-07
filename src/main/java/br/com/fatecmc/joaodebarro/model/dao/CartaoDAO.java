package br.com.fatecmc.joaodebarro.model.dao;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartaoDAO implements IDAO {
    private Connection conn;

    @Override
    public EntidadeDominio salvar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO CARTOES VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Cliente){
            try {                
                conn.setAutoCommit(false);
                
                Cartao crt = (Cartao) ((Cliente) entidade).getCartoes().toArray()[0];
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, 0);
                stmt.setInt(2, ((Cliente) entidade).getId());
                stmt.setInt(3, crt.getBandeira().getId());
                stmt.setString(4, crt.getNumero());
                stmt.setString(5, crt.getNome());
                stmt.setString(6, crt.getCvv());
                stmt.setDate(7, new Date(crt.getValidade().getTime()));
                stmt.setDate(8, null);

                stmt.executeUpdate();
                
                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next()) crt.setId(rs.getInt(1));
                
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
        String sql = "UPDATE CARTOES SET crt_bnd_id=?, crt_numero=?, crt_nome=?, crt_cvv=?, crt_dt_validade=? WHERE crt_id=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Cartao){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, ((Cartao) entidade).getBandeira().getId());
                stmt.setString(2, ((Cartao) entidade).getNumero());
                stmt.setString(3, ((Cartao) entidade).getNome());
                stmt.setString(4, ((Cartao) entidade).getCvv());
                stmt.setDate(5, new Date(((Cartao) entidade).getValidade().getTime()));
                stmt.setInt(6, entidade.getId());
                
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
        String sql = "DELETE FROM CARTOES WHERE crt_id=?";

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
        String sql = "SELECT * FROM CARTOES";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Cliente cliente = new Cliente();
                Cartao cartao = new Cartao();
                
                cartao.setId(rs.getInt("crt_id"));
                cliente.setId(rs.getInt("crt_cli_id"));
                cartao.setBandeira(BandeiraCartao.idToEnum(rs.getInt("crt_bnd_id")));
                cartao.setNumero(rs.getString("crt_numero"));
                cartao.setNome(rs.getString("crt_nome"));
                cartao.setCvv(rs.getString("crt_cvv"));
                cartao.setValidade(rs.getDate("crt_dt_validade"));
                cartao.setDt_cadastro(rs.getDate("crt_dt_inclusao"));
                cliente.setCartoes(Arrays.asList(cartao));
                
                clientes.add(cliente);
            }
                
            return clientes;
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
        String sql = "SELECT * FROM CARTOES WHERE crt_id=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Cliente cliente = new Cliente();
        Cartao cartao = new Cartao();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, entidade.getId());
                
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                cartao.setId(rs.getInt("crt_id"));
                cliente.setId(rs.getInt("crt_cli_id"));
                cartao.setBandeira(BandeiraCartao.idToEnum(rs.getInt("crt_bnd_id")));
                cartao.setNumero(rs.getString("crt_numero"));
                cartao.setNome(rs.getString("crt_nome"));
                cartao.setCvv(rs.getString("crt_cvv"));
                cartao.setValidade(rs.getDate("crt_dt_validade"));
                cartao.setDt_cadastro(rs.getDate("crt_dt_inclusao"));
                cliente.setCartoes(Arrays.asList(cartao));
            }
            
            return cliente;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
    public EntidadeDominio consultarPorCliente(Cliente cliente) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM CARTOES WHERE crt_cli_id=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
                
            rs = stmt.executeQuery();
            
            cliente.setCartoes(new ArrayList<Cartao>());
            while(rs.next()) {
                Cartao cartao = new Cartao();
                
                cartao.setId(rs.getInt("crt_id"));
                cartao.setBandeira(BandeiraCartao.idToEnum(rs.getInt("crt_bnd_id")));
                cartao.setNumero(rs.getString("crt_numero"));
                cartao.setNome(rs.getString("crt_nome"));
                cartao.setCvv(rs.getString("crt_cvv"));
                cartao.setValidade(rs.getDate("crt_dt_validade"));
                cartao.setDt_cadastro(rs.getDate("crt_dt_inclusao"));
                
                cliente.getCartoes().add(cartao);
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
