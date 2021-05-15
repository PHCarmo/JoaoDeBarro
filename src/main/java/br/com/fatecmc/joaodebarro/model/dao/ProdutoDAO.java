package br.com.fatecmc.joaodebarro.model.dao;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ProdutoDAO implements IDAO {
    private Connection conn;

    @Override
    public EntidadeDominio salvar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO PRODUTOS VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Produto){
            try {
                conn.setAutoCommit(false);
                
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, 0);
                stmt.setString(2, ((Produto) entidade).getCodigo());
                stmt.setInt(3, ((Produto) entidade).getTipo().getId());
                stmt.setInt(4, ((Produto) entidade).getGrupo().getId());
                stmt.setInt(5, 0);
                stmt.setString(6, ((Produto) entidade).getDescricao());
                stmt.setString(7, ((Produto) entidade).getMarca());
                stmt.setString(8, ((Produto) entidade).getCor_tonalidade());
                stmt.setString(9, ((Produto) entidade).getMaterial());
                stmt.setInt(10, ((Produto) entidade).getComprimento());
                stmt.setInt(11, ((Produto) entidade).getLargura());
                stmt.setString(12, ((Produto) entidade).getCodigo_barra());
                stmt.setInt(13, ((Produto) entidade).getPei());
                stmt.setInt(14, ((Produto) entidade).getQtd_estoque());
                stmt.setDouble(15, ((Produto) entidade).getValor_venda());
                stmt.setString(16, ((Produto) entidade).getImg_nome());
                stmt.setDate(17, null);

                stmt.executeUpdate();
                
                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next()) entidade.setId(rs.getInt(1));
                
                conn.commit();	
                
                Collection<Categoria> ctgs = ((Produto) entidade).getCategorias();
                for(Categoria ctg: ctgs){
                    ((Produto) entidade).setCategorias(Arrays.asList(ctg));
                    salvarCategoria(entidade);
                }
            } catch (SQLException ex) {
                System.out.println("Não foi possível salvar os dados no banco de dados.\nErro: " + ex.getMessage());
            } finally {
                ConnectionFactory.closeConnection(conn, stmt);
            }
        }
        return entidade;
    }
    
    public EntidadeDominio salvarCategoria(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO CATEGORIAS_PRODUTOS VALUES(?, ?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Produto){
            try {
                conn.setAutoCommit(false);
                
                Categoria ctg = (Categoria) ((Produto) entidade).getCategorias().toArray()[0];
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, 0);
                stmt.setInt(2, ((Produto) entidade).getId());
                stmt.setInt(3, ctg.getId());
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
        this.conn = ConnectionFactory.getConnection();
        String sql = "UPDATE PRODUTOS SET prd_tpd_id=?, prd_gpp_id=?, prd_spr_id=?, prd_descricao=?, prd_marca=?, prd_cor_tonalidade=?,"
                + "prd_material=?, prd_comprimento=?, prd_largura=?, prd_codigo_barra=?, prd_pei=?, prd_qtd_estoque=?, prd_valor_venda=?, prd_img_nome=? WHERE prd_id=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Produto){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, ((Produto) entidade).getTipo().getId());
                stmt.setInt(2, ((Produto) entidade).getGrupo().getId());
                stmt.setInt(3, ((Produto) entidade).getStatus().getId());
                stmt.setString(4, ((Produto) entidade).getDescricao());
                stmt.setString(5, ((Produto) entidade).getMarca());
                stmt.setString(6, ((Produto) entidade).getCor_tonalidade());
                stmt.setString(7, ((Produto) entidade).getMaterial());
                stmt.setInt(8, ((Produto) entidade).getComprimento());
                stmt.setInt(9, ((Produto) entidade).getLargura());
                stmt.setString(10, ((Produto) entidade).getCodigo_barra());
                stmt.setInt(11, ((Produto) entidade).getPei());
                stmt.setInt(12, ((Produto) entidade).getQtd_estoque());
                stmt.setDouble(13, ((Produto) entidade).getValor_venda());
                stmt.setString(14, ((Produto) entidade).getImg_nome());
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
    
    public boolean alterarQtdEstoque(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "UPDATE PRODUTOS SET prd_qtd_estoque=? WHERE prd_id=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Produto){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, ((Produto) entidade).getQtd_estoque());
                stmt.setInt(2, entidade.getId());
                
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
        String sql = "DELETE FROM PRODUTOS WHERE prd_id=?";

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
        String sql = "SELECT * FROM PRODUTOS JOIN GRUPOS_PRECIFICACOES ON prd_gpp_id=gpp_id";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("prd_id"));
                produto.setCodigo(rs.getString("prd_codigo"));
                produto.setTipo(TipoProduto.idToEnum(rs.getInt("prd_tpd_id")));
                produto.setGrupo(GrupoPrecificacao.idToEnum(rs.getInt("prd_gpp_id")));
                produto.setStatus(StatusProduto.idToEnum(rs.getInt("prd_spr_id")));
                produto.setDescricao(rs.getString("prd_descricao"));
                produto.setMarca(rs.getString("prd_marca"));
                produto.setCor_tonalidade(rs.getString("prd_cor_tonalidade"));
                produto.setMaterial(rs.getString("prd_material"));
                produto.setComprimento(rs.getInt("prd_comprimento"));
                produto.setLargura(rs.getInt("prd_largura"));
                produto.setCodigo_barra(rs.getString("prd_codigo_barra"));
                produto.setPei(rs.getInt("prd_pei"));
                produto.setQtd_estoque(rs.getInt("prd_qtd_estoque"));
                produto.setValor_venda(rs.getDouble("prd_valor_venda"));
                produto.setMargem_lucro(rs.getInt("gpp_margem_lucro"));
                produto.setImg_nome(rs.getString("prd_img_nome"));
                produto.setDt_cadastro(rs.getDate("prd_dt_inclusao"));
                
                produtos.add(produto);
            }
                
            return produtos;
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
        String sql = "SELECT * FROM PRODUTOS JOIN GRUPOS_PRECIFICACOES ON prd_gpp_id=gpp_id WHERE prd_id=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Produto produto = new Produto();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
                
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                produto.setId(rs.getInt("prd_id"));
                produto.setCodigo(rs.getString("prd_codigo"));
                produto.setTipo(TipoProduto.idToEnum(rs.getInt("prd_tpd_id")));
                produto.setGrupo(GrupoPrecificacao.idToEnum(rs.getInt("prd_gpp_id")));
                produto.setStatus(StatusProduto.idToEnum(rs.getInt("prd_spr_id")));
                produto.setDescricao(rs.getString("prd_descricao"));
                produto.setMarca(rs.getString("prd_marca"));
                produto.setCor_tonalidade(rs.getString("prd_cor_tonalidade"));
                produto.setMaterial(rs.getString("prd_material"));
                produto.setComprimento(rs.getInt("prd_comprimento"));
                produto.setLargura(rs.getInt("prd_largura"));
                produto.setCodigo_barra(rs.getString("prd_codigo_barra"));
                produto.setPei(rs.getInt("prd_pei"));
                produto.setQtd_estoque(rs.getInt("prd_qtd_estoque"));
                produto.setValor_venda(rs.getDouble("prd_valor_venda"));
                produto.setMargem_lucro(rs.getInt("gpp_margem_lucro"));
                produto.setImg_nome(rs.getString("prd_img_nome"));
                produto.setDt_cadastro(rs.getDate("prd_dt_inclusao"));
            }
                
            return produto;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
}
