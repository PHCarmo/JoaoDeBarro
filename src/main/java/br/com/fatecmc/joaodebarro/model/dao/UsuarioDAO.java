package br.com.fatecmc.joaodebarro.model.dao;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IDAO {
    private Connection conn;

    @Override
    public int salvar(EntidadeDominio entidade) {
        int id = 0;
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO USUARIOS VALUES(?, ?, ?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Usuario){
            try {
                conn.setAutoCommit(false);
                
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, 0);
                stmt.setInt(2, ((Usuario) entidade).getTipo().getId());
                stmt.setString(3, ((Usuario) entidade).getEmail());
                stmt.setString(4, ((Usuario) entidade).getSenha());
                stmt.setDate(5, null);

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
        String sql = "UPDATE USUARIOS SET usu_tus_id=?, usu_email=?, usu_senha=? WHERE usu_id=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Usuario){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, ((Usuario) entidade).getTipo().getId());
                stmt.setString(2, ((Usuario) entidade).getEmail());
                stmt.setString(3, ((Usuario) entidade).getSenha());
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
        String sql = "DELETE FROM USUARIOS WHERE usu_id=?";

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
        String sql = "SELECT * FROM USUARIOS";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Usuario usuario = new Usuario();
                TipoUsuario tipo = new TipoUsuario();
                
                usuario.setId(rs.getInt("id_pessoa"));
                tipo.setId(rs.getInt("usu_tus_id"));
                usuario.setEmail(rs.getString("usu_email"));
                usuario.setSenha(rs.getString("usu_senha"));
                usuario.setDt_cadastro(rs.getDate("usu_dt_inclusao"));
                
                usuario.setTipo(tipo);
                usuarios.add(usuario);
            }
                
            return usuarios;
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
        String sql = "SELECT * FROM pessoas WHERE id_pessoa=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Usuario usuario = new Usuario();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
                
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                TipoUsuario tipo = new TipoUsuario();
                
                usuario.setId(rs.getInt("id_pessoa"));
                tipo.setId(rs.getInt("usu_tus_id"));
                usuario.setEmail(rs.getString("usu_email"));
                usuario.setSenha(rs.getString("usu_senha"));
                usuario.setDt_cadastro(rs.getDate("usu_dt_inclusao"));
                
                usuario.setTipo(tipo);
            }
                
            return usuario;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
}
