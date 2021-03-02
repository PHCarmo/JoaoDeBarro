package br.com.fatecmc.joaodebarro.model.dao;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IDAO {
    private Connection conn;

    @Override
    public int salvar(EntidadeDominio entidade) {
        int id = 0;
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO CLIENTES VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Cliente){
            try {
                conn.setAutoCommit(false);
                
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, 0);
                stmt.setInt(2, ((Cliente) entidade).getUsuario().getId());
                stmt.setString(3, ((Cliente) entidade).getNome());
                stmt.setInt(4, ((Cliente) entidade).getGenero().getId());
                stmt.setString(5, ((Cliente) entidade).getCpf());
                stmt.setInt(6, ((Cliente) entidade).getTel_tipo().getId());
                stmt.setString(7, ((Cliente) entidade).getTel_ddd());
                stmt.setString(8, ((Cliente) entidade).getTel_numero());
                stmt.setDate(9, new Date(((Cliente) entidade).getDt_nascimento().getTime()));
                stmt.setBoolean(10, true);
                stmt.setDate(11, null);

                stmt.executeUpdate();
                
                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next()) id = rs.getInt(1);
                
                conn.commit();	
            } catch (SQLException ex) {
                System.out.println("Não foi possível salvar os dados no banco de dados.\nErro: " + ex.getMessage());
            } finally {
                ConnectionFactory.closeConnection(conn, stmt);
            }
        }
        return id;
    }

    @Override
    public boolean alterar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "UPDATE CLIENTES SET cli_nome=?, cli_gen_id=?, cli_cpf=?, cli_tel_tte_id=?, cli_tel_ddd=?, cli_tel_numero=?, cli_dt_nascimento=? WHERE cli_id=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Cliente){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Cliente) entidade).getNome());
                stmt.setInt(2, ((Cliente) entidade).getGenero().getId());
                stmt.setString(3, ((Cliente) entidade).getCpf());
                stmt.setInt(4, ((Cliente) entidade).getTel_tipo().getId());
                stmt.setString(5, ((Cliente) entidade).getTel_ddd());
                stmt.setString(6, ((Cliente) entidade).getTel_numero());
                stmt.setDate(7, new Date(((Cliente) entidade).getDt_nascimento().getTime()));
                stmt.setInt(8, entidade.getId());
                
                if(stmt.executeUpdate() == 1) return true;
            } catch (SQLException ex) {
                System.out.println("Não foi possível alterar os dados no banco de dados.\nErro: " + ex.getMessage());
            } finally {
                ConnectionFactory.closeConnection(conn, stmt);
            }
        }
        return false;
    }
    
    public boolean alterarStatus(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "UPDATE CLIENTES SET cli_status=? WHERE cli_id=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Cliente){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setBoolean(1, !((Cliente) entidade).getStatus());
                stmt.setInt(2, entidade.getId());
                
                if(stmt.executeUpdate() == 1) return true;
            } catch (SQLException ex) {
                System.out.println("Não foi possível alterar o status no banco de dados.\nErro: " + ex.getMessage());
            } finally {
                ConnectionFactory.closeConnection(conn, stmt);
            }
        }
        return false;
    }

    @Override
    public boolean excluir(int id) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM CLIENTES WHERE cli_id=?";

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
        String sql = "SELECT * FROM CLIENTES";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Cliente cliente = new Cliente();
                Usuario usuario = new Usuario();
                Genero genero = new Genero();
                TipoTelefone tel_tipo = new TipoTelefone();
                
                cliente.setId(rs.getInt("cli_id"));
                usuario.setId(rs.getInt("cli_usu_id"));
                cliente.setNome(rs.getString("cli_nome"));
                genero.setId(rs.getInt("cli_gen_id"));
                cliente.setCpf(rs.getString("cli_cpf"));
                tel_tipo.setId(rs.getInt("cli_tel_tte_id"));
                cliente.setTel_ddd(rs.getString("cli_tel_ddd"));
                cliente.setTel_numero(rs.getString("cli_tel_numero"));
                cliente.setDt_nascimento(rs.getDate("cli_dt_nascimento"));
                cliente.setStatus(rs.getBoolean("cli_status"));
                cliente.setDt_cadastro(rs.getDate("cli_dt_inclusao"));
                
                cliente.setUsuario(usuario);
                cliente.setGenero(genero);
                cliente.setTel_tipo(tel_tipo);
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
    public EntidadeDominio consultar(int id) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM CLIENTES WHERE cli_id=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Cliente cliente = new Cliente();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
                
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                Usuario usuario = new Usuario();
                Genero genero = new Genero();
                TipoTelefone tel_tipo = new TipoTelefone();
                
                cliente.setId(rs.getInt("cli_id"));
                usuario.setId(rs.getInt("cli_usu_id"));
                cliente.setNome(rs.getString("cli_nome"));
                genero.setId(rs.getInt("cli_gen_id"));
                cliente.setCpf(rs.getString("cli_cpf"));
                tel_tipo.setId(rs.getInt("cli_tel_tte_id"));
                cliente.setTel_ddd(rs.getString("cli_tel_ddd"));
                cliente.setTel_numero(rs.getString("cli_tel_numero"));
                cliente.setDt_nascimento(rs.getDate("cli_dt_nascimento"));
                cliente.setStatus(rs.getBoolean("cli_status"));
                cliente.setDt_cadastro(rs.getDate("cli_dt_inclusao"));
                
                cliente.setUsuario(usuario);
                cliente.setGenero(genero);
                cliente.setTel_tipo(tel_tipo);
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
