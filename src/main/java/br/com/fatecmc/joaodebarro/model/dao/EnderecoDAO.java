package br.com.fatecmc.joaodebarro.model.dao;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO implements IDAO {
    private Connection conn;

    @Override
    public EntidadeDominio salvar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO ENDERECOS VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Endereco){
            try {
                conn.setAutoCommit(false);
                
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, 0);
                stmt.setInt(2, ((Endereco) entidade).getCliente_id());
                stmt.setString(3, ((Endereco) entidade).getApelido());
                stmt.setInt(4, ((Endereco) entidade).getTipo().getId());
                stmt.setInt(5, ((Endereco) entidade).getTipo_res().getId());
                stmt.setInt(6, ((Endereco) entidade).getTipo_log().getId());
                stmt.setString(7, ((Endereco) entidade).getLogradouro());
                stmt.setString(8, ((Endereco) entidade).getNumero());
                stmt.setString(9, ((Endereco) entidade).getBairro());
                stmt.setString(10, ((Endereco) entidade).getCep());
                stmt.setString(11, ((Endereco) entidade).getCidade());
                stmt.setString(12, ((Endereco) entidade).getEstado());
                stmt.setString(13, ((Endereco) entidade).getPais());
                stmt.setString(14, ((Endereco) entidade).getObservacao());
                stmt.setBoolean(15, ((Endereco) entidade).getCobranca());
                stmt.setBoolean(16, ((Endereco) entidade).getEntrega());
                stmt.setString(17, null);

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
        String sql = "UPDATE ENDERECOS SET end_nome=?, end_ten_id=?, end_tre_id=?, end_tlo_id=?, end_logradouro=?, end_numero=?, end_bairro=?, end_cep=?, end_cidade=?, end_estado=?, end_pais=?, end_observacao=?, end_cobranca=?, end_entrega=? WHERE end_id=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Endereco){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Endereco) entidade).getApelido());
                stmt.setInt(2, ((Endereco) entidade).getTipo().getId());
                stmt.setInt(3, ((Endereco) entidade).getTipo_res().getId());
                stmt.setInt(4, ((Endereco) entidade).getTipo_log().getId());
                stmt.setString(5, ((Endereco) entidade).getLogradouro());
                stmt.setString(6, ((Endereco) entidade).getNumero());
                stmt.setString(7, ((Endereco) entidade).getBairro());
                stmt.setString(8, ((Endereco) entidade).getCep());
                stmt.setString(9, ((Endereco) entidade).getCidade());
                stmt.setString(10, ((Endereco) entidade).getEstado());
                stmt.setString(11, ((Endereco) entidade).getPais());
                stmt.setString(12, ((Endereco) entidade).getObservacao());
                stmt.setBoolean(13, ((Endereco) entidade).getCobranca());
                stmt.setBoolean(14, ((Endereco) entidade).getEntrega());
                stmt.setInt(15, entidade.getId());
                
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
        String sql = "DELETE FROM ENDERECOS WHERE end_id=?";

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
        String sql = "SELECT * FROM ENDERECOS";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Endereco> enderecos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Endereco endereco = new Endereco();
                
                endereco.setId(rs.getInt("end_id"));
                endereco.setCliente_id(rs.getInt("end_cli_id"));
                endereco.setApelido(rs.getString("end_nome"));
                endereco.setTipo(TipoEndereco.idToEnum(rs.getInt("end_ten_id")));
                endereco.setTipo_res(TipoResidencia.idToEnum(rs.getInt("end_tre_id")));
                endereco.setTipo_log(TipoLogradouro.idToEnum(rs.getInt("end_tlo_id")));
                endereco.setLogradouro(rs.getString("end_logradouro"));
                endereco.setNumero(rs.getString("end_numero"));
                endereco.setBairro(rs.getString("end_bairro"));
                endereco.setCep(rs.getString("end_cep"));
                endereco.setCidade(rs.getString("end_cidade"));
                endereco.setEstado(rs.getString("end_estado"));
                endereco.setPais(rs.getString("end_pais"));
                endereco.setObservacao(rs.getString("end_observacao"));
                endereco.setCobranca(rs.getBoolean("end_cobranca"));
                endereco.setEntrega(rs.getBoolean("end_entrega"));
                endereco.setDt_cadastro(rs.getDate("end_dt_inclusao"));
                
                enderecos.add(endereco);
            }
                
            return enderecos;
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
        String sql = "SELECT * FROM ENDERECOS WHERE end_id=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Endereco endereco = new Endereco();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, entidade.getId());
                
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                endereco.setId(rs.getInt("end_id"));
                endereco.setCliente_id(rs.getInt("end_cli_id"));
                endereco.setApelido(rs.getString("end_nome"));
                endereco.setTipo(TipoEndereco.idToEnum(rs.getInt("end_ten_id")));
                endereco.setTipo_res(TipoResidencia.idToEnum(rs.getInt("end_tre_id")));
                endereco.setTipo_log(TipoLogradouro.idToEnum(rs.getInt("end_tlo_id")));
                endereco.setLogradouro(rs.getString("end_logradouro"));
                endereco.setNumero(rs.getString("end_numero"));
                endereco.setBairro(rs.getString("end_bairro"));
                endereco.setCep(rs.getString("end_cep"));
                endereco.setCidade(rs.getString("end_cidade"));
                endereco.setEstado(rs.getString("end_estado"));
                endereco.setPais(rs.getString("end_pais"));
                endereco.setObservacao(rs.getString("end_observacao"));
                endereco.setCobranca(rs.getBoolean("end_cobranca"));
                endereco.setEntrega(rs.getBoolean("end_entrega"));
                endereco.setDt_cadastro(rs.getDate("end_dt_inclusao"));
            }
                
            return endereco;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
    public EntidadeDominio consultarPorCliente(Cliente cliente) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM ENDERECOS WHERE end_cli_id=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
                
            rs = stmt.executeQuery();
            
            cliente.setEnderecos(new ArrayList<Endereco>());
            while(rs.next()) {
                Endereco endereco = new Endereco();
                
                endereco.setId(rs.getInt("end_id"));
                endereco.setCliente_id(rs.getInt("end_cli_id"));
                endereco.setApelido(rs.getString("end_nome"));
                endereco.setTipo(TipoEndereco.idToEnum(rs.getInt("end_ten_id")));
                endereco.setTipo_res(TipoResidencia.idToEnum(rs.getInt("end_tre_id")));
                endereco.setTipo_log(TipoLogradouro.idToEnum(rs.getInt("end_tlo_id")));
                endereco.setLogradouro(rs.getString("end_logradouro"));
                endereco.setNumero(rs.getString("end_numero"));
                endereco.setBairro(rs.getString("end_bairro"));
                endereco.setCep(rs.getString("end_cep"));
                endereco.setCidade(rs.getString("end_cidade"));
                endereco.setEstado(rs.getString("end_estado"));
                endereco.setPais(rs.getString("end_pais"));
                endereco.setObservacao(rs.getString("end_observacao"));
                endereco.setCobranca(rs.getBoolean("end_cobranca"));
                endereco.setEntrega(rs.getBoolean("end_entrega"));
                endereco.setDt_cadastro(rs.getDate("end_dt_inclusao"));
                
                cliente.getEnderecos().add(endereco);
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
