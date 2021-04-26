package br.com.fatecmc.joaodebarro.model.dao;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemDAO implements IDAO {
    private Connection conn;

    @Override
    public EntidadeDominio salvar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO PRODUTOS_CARRINHOS VALUES(?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = null;

        if (entidade instanceof Carrinho) {
            if(entidade.getId() == 0)
                entidade = new CarrinhoDAO().salvar(entidade);
            
            try {
                conn.setAutoCommit(false);

                for (Item item : ((Carrinho) entidade).getItens()) {
                    if (item.getId() == 0) {
                        stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        stmt.setInt(1, 0);
                        stmt.setInt(2, item.getProduto().getId());
                        stmt.setInt(3, entidade.getId());
                        stmt.setInt(4, item.getQtd());
                        stmt.setNull(5, Types.BOOLEAN);
                        stmt.setDate(6, null);

                        stmt.executeUpdate();

                        ResultSet rs = stmt.getGeneratedKeys();
                        if (rs.next()) {
                            item.setId(rs.getInt(1));
                        }
                    }
                }

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
        String sql = "UPDATE PRODUTOS_CARRINHOS SET pcr_qtd=?, pcr_status=? WHERE pcr_id=?";

        PreparedStatement stmt = null;

        if (entidade instanceof Carrinho) {
            try {
                for (Item item : ((Carrinho) entidade).getItens()) {
                    if (item.getId() != 0) {
                        stmt = conn.prepareStatement(sql);
                        stmt.setInt(1, item.getQtd());
                        stmt.setBoolean(2, item.getStatus());
                        stmt.setInt(3, item.getId());

                        if (stmt.executeUpdate() != 1) {
                            return false;
                        }
                    }
                }
            } catch (SQLException ex) {
                System.out.println("Não foi possível alterar os dados no banco de dados.\nErro: " + ex.getMessage());
                return false;
            } finally {
                ConnectionFactory.closeConnection(conn, stmt);
            }
        }
        return true;
    }

    @Override
    public boolean excluir(int id) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM PRODUTOS_CARRINHOS WHERE pcr_id=?";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            if (stmt.executeUpdate() == 1) {
                return true;
            }
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
        String sql = "SELECT * FROM PRODUTOS_CARRINHOS";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Carrinho> carrinhos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Carrinho carrinho = new Carrinho();
                Item item = new Item();

                item.setId(rs.getInt("pcr_id"));
                carrinho.setId(rs.getInt("pcr_car_id"));
                item.setQtd(rs.getInt("pcr_qtd"));
                item.setStatus(rs.getBoolean("pcr_status"));
                item.setDt_cadastro(rs.getDate("pcr_dt_inclusao"));
                item.setProduto((Produto) new ProdutoDAO().consultar(rs.getInt("pcr_prd_id")));
                carrinho.setItens(Arrays.asList(item));
                
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
    public EntidadeDominio consultar(int id) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM PRODUTOS_CARRINHOS WHERE pcr_car_id=?";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Carrinho carrinho = new Carrinho();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            carrinho.setItens(new ArrayList<Item>());
            while (rs.next()) {
                Item item = new Item();
                
                item.setId(rs.getInt("pcr_id"));
                carrinho.setId(rs.getInt("pcr_car_id"));
                item.setQtd(rs.getInt("pcr_qtd"));
                item.setStatus(rs.getBoolean("pcr_status"));
                item.setDt_cadastro(rs.getDate("pcr_dt_inclusao"));
                item.setProduto((Produto) new ProdutoDAO().consultar(rs.getInt("pcr_prd_id")));
                
                carrinho.getItens().add(item);
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
