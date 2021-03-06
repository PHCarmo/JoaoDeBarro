package br.com.fatecmc.joaodebarro.model.dao;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PedidoDAO implements IDAO {
    private Connection conn;

    @Override
    public EntidadeDominio salvar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO PEDIDOS VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Pedido){
            try {                
                conn.setAutoCommit(false);
                
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, 0);
                stmt.setString(2, null);
                stmt.setInt(3, ((Pedido) entidade).getCarrinho().getId());
                stmt.setInt(4, ((Pedido) entidade).getCliente().getId());
                stmt.setInt(5, 0);
                stmt.setInt(6, ((Pedido) entidade).getEnd_entrega().getId());
                stmt.setInt(7, ((Pedido) entidade).getEnd_cobranca().getId());
                if(((Pedido) entidade).getCupom().getId() == 0)
                    stmt.setNull(8, Types.INTEGER);
                else
                    stmt.setInt(8, ((Pedido) entidade).getCupom().getId());
                stmt.setDouble(9, ((Pedido) entidade).getValor_frete());
                stmt.setDouble(10, ((Pedido) entidade).getValor_desconto());
                stmt.setDouble(11, ((Pedido) entidade).getValor_produtos());
                stmt.setDate(12, null);

                stmt.executeUpdate();
                
                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next()) entidade.setId(rs.getInt(1));
                
                conn.commit();
                
                Collection<ValeTroca> vts = ((Pedido) entidade).getVales();
                for(ValeTroca vt: vts){
                    ((Pedido) entidade).setVales(Arrays.asList(vt));
                    new ValeTrocaDAO().alterar(entidade);
                }
                if(((Pedido) entidade).getCliente().getVales().size() > 0)
                    new ValeTrocaDAO().salvar(((Pedido) entidade).getCliente());
                Collection<Pagamento> pgmts = ((Pedido) entidade).getPagamentos();
                for(Pagamento pgmt: pgmts){
                    ((Pedido) entidade).setPagamentos(Arrays.asList(pgmt));
                    new PagamentoDAO().salvar(entidade);
                }
                for(Item item: ((Carrinho) new CarrinhoDAO().consultar(((Pedido) entidade).getCarrinho())).getItens()){
                    Produto prod = item.getProduto();
                    prod.setQtd_estoque(prod.getQtd_estoque() - item.getQtd());
                    new ProdutoDAO().alterarQtdEstoque(prod);
                }
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
        String sql = "UPDATE PEDIDOS SET ped_spd_id=? WHERE ped_id=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Pedido){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, ((Pedido) entidade).getStatus().getId());
                stmt.setInt(2, entidade.getId());
                
                if(stmt.executeUpdate() != 1) return false;
                
                if(((Pedido) entidade).getCarrinho().getId() != 0)
                    new ItemDAO().alterar(((Pedido) entidade).getCarrinho());
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
        String sql = "DELETE FROM PEDIDOS WHERE ped_id=?";

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
        String sql = "SELECT * FROM PEDIDOS";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pedido> pedidos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Pedido pedido = new Pedido();
                
                pedido.setId(rs.getInt("ped_id"));
                pedido.setCodigo(rs.getString("ped_codigo"));
                pedido.setCarrinho((Carrinho) new CarrinhoDAO().consultar(new Carrinho().setId(rs.getInt("ped_car_id"))));
                pedido.setCliente((Cliente) new ClienteDAO().consultar(new Cliente().setId(rs.getInt("ped_cli_id"))));
                pedido.setStatus(StatusPedido.idToEnum(rs.getInt("ped_spd_id")));
                pedido.setEnd_entrega((Endereco) new EnderecoDAO().consultar(new Endereco().setId(rs.getInt("ped_end_entr_id"))));
                pedido.setEnd_cobranca((Endereco) new EnderecoDAO().consultar(new Endereco().setId(rs.getInt("ped_end_cobr_id"))));
                pedido.setCupom((Cupom) new CupomDAO().consultar(new Cupom().setId(rs.getInt("ped_cpm_id"))));
                pedido.setValor_frete(rs.getDouble("ped_valor_frete"));
                pedido.setValor_desconto(rs.getDouble("ped_valor_desconto"));
                pedido.setValor_produtos(rs.getDouble("ped_valor_produtos"));
                pedido.setDt_cadastro(new java.util.Date(rs.getTimestamp("ped_dt_inclusao").getTime()));
                
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
        String sql = "SELECT * FROM PEDIDOS WHERE ped_id=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Pedido pedido = new Pedido();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, entidade.getId());
                
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                pedido.setId(rs.getInt("ped_id"));
                pedido.setCodigo(rs.getString("ped_codigo"));
                pedido.setCarrinho((Carrinho) new CarrinhoDAO().consultar(new Carrinho().setId(rs.getInt("ped_car_id"))));
                pedido.setCliente((Cliente) new ClienteDAO().consultar(new Cliente().setId(rs.getInt("ped_cli_id"))));
                pedido.setStatus(StatusPedido.idToEnum(rs.getInt("ped_spd_id")));
                pedido.setEnd_entrega((Endereco) new EnderecoDAO().consultar(new Endereco().setId(rs.getInt("ped_end_entr_id"))));
                pedido.setEnd_cobranca((Endereco) new EnderecoDAO().consultar(new Endereco().setId(rs.getInt("ped_end_cobr_id"))));
                pedido.setCupom((Cupom) new CupomDAO().consultar(new Cupom().setId(rs.getInt("ped_cpm_id"))));
                pedido.setValor_frete(rs.getDouble("ped_valor_frete"));
                pedido.setValor_desconto(rs.getDouble("ped_valor_desconto"));
                pedido.setValor_produtos(rs.getDouble("ped_valor_produtos"));
                pedido.setDt_cadastro(new java.util.Date(rs.getTimestamp("ped_dt_inclusao").getTime()));
            }
            
            return pedido;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
    public List consultarPorCliente(Cliente cliente) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM PEDIDOS WHERE ped_cli_id=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pedido> pedidos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
                
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Pedido pedido = new Pedido();
                
                pedido.setId(rs.getInt("ped_id"));
                pedido.setCodigo(rs.getString("ped_codigo"));
                pedido.setCarrinho((Carrinho) new CarrinhoDAO().consultar(new Carrinho().setId(rs.getInt("ped_car_id"))));
                pedido.setCliente((Cliente) new ClienteDAO().consultar(new Cliente().setId(rs.getInt("ped_cli_id"))));
                pedido.setStatus(StatusPedido.idToEnum(rs.getInt("ped_spd_id")));
                pedido.setEnd_entrega((Endereco) new EnderecoDAO().consultar(new Endereco().setId(rs.getInt("ped_end_entr_id"))));
                pedido.setEnd_cobranca((Endereco) new EnderecoDAO().consultar(new Endereco().setId(rs.getInt("ped_end_cobr_id"))));
                pedido.setCupom((Cupom) new CupomDAO().consultar(new Cupom().setId(rs.getInt("ped_cpm_id"))));
                pedido.setValor_frete(rs.getDouble("ped_valor_frete"));
                pedido.setValor_desconto(rs.getDouble("ped_valor_desconto"));
                pedido.setValor_produtos(rs.getDouble("ped_valor_produtos"));
                pedido.setDt_cadastro(new java.util.Date(rs.getTimestamp("ped_dt_inclusao").getTime()));
                
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
    
}
