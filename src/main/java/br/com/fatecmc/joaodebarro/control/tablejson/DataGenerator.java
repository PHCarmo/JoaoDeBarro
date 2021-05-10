package br.com.fatecmc.joaodebarro.control.tablejson;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.Mask;
import java.util.List;
import org.json.JSONArray;

public class DataGenerator {

    public JSONArray getClienteData(List<EntidadeDominio> entidades) {
        JSONArray data = new JSONArray();
        
        for (EntidadeDominio e : entidades) {
            Cliente c = (Cliente) e;
            JSONArray obj = new JSONArray();
            
            obj.put("<div class='circle " + (c.getStatus() ? "green" : "grey") + "'></div>");
            obj.put(c.getCodigo());
            obj.put(c.getUsuario().getId());
            obj.put(c.getNome());
            obj.put(Mask.toCPF(c.getCpf()));
            obj.put("<a class='btn btn-default' title='Ativar/Inativar' href='#'><img class='icon' src='icon/eye.png' /></a>"
                    + "<a class='btn btn-default' title='Historico de Transacoes' href='#'><img class='icon' src='icon/history.png' /></a>");
            
            data.put(obj);
        }
        
        return data;
    }
    
    public JSONArray getVendaData(List<EntidadeDominio> entidades) {
        JSONArray data = new JSONArray();
        
        for (EntidadeDominio e : entidades) {
            Pedido p = (Pedido) e;
            JSONArray obj = new JSONArray();
            
            obj.put("<div class='circle " + p.getStatus().getCor() + "'></div>");
            obj.put(p.getCodigo());
            obj.put(p.getCliente().getCodigo());
            obj.put(Mask.toDateHour(p.getDt_cadastro()));
            obj.put(Mask.toMoney(p.getValor_total()));
            
            String first_button;
            switch (p.getStatus()) {
                case EM_PROCESSAMENTO:
                    first_button = "<a class='btn btn-default change-status-show' title='Aprovar Pedido' "
                            + "onclick='changeStatus("+p.getId()+","+StatusPedido.APROVADA.getId()+",\""+StatusPedido.APROVADA.getDescricao()+"\");'><img class='icon' src='icon/checkmark.png' /></a>";
                    break;
                default:
                    first_button = "<a class='btn btn-default invisible' href=''><img class='icon' src='icon/eye.png'/></a>";
                    break;
            }
            
            String second_button;
            switch (p.getStatus()) {
                case EM_PROCESSAMENTO:
                    second_button = "<a class='btn btn-default' title='Reprovar Pedido' "
                            + "onclick='changeStatus("+p.getId()+","+StatusPedido.REPROVADA.getId()+",\""+StatusPedido.REPROVADA.getDescricao()+"\");'><img class='icon' src='icon/remove.png' /></a>";
                    break;
                case APROVADA:
                    second_button = "<a class='btn btn-default' title='Iniciar Entrega' "
                            + "onclick='changeStatus("+p.getId()+","+StatusPedido.EM_TRANSITO.getId()+",\""+StatusPedido.EM_TRANSITO.getDescricao()+"\");'><img class='icon' src='icon/truck.png' /></a>";
                    break;
                case EM_TRANSITO:
                    second_button = "<a class='btn btn-default' title='Pedido Entregue!' "
                            + "onclick='changeStatus("+p.getId()+","+StatusPedido.ENTREGUE.getId()+",\""+StatusPedido.ENTREGUE.getDescricao()+"\");'><img class='icon' src='icon/truck.png' /></a>";
                    break;
                case EM_TROCA:
                    second_button = "<a class='btn btn-default' title='Liberar Troca' "
                            + "onclick='changePedido("+p.getId()+","+StatusPedido.TROCA_AUTORIZADA.getId()+",\""+StatusPedido.TROCA_AUTORIZADA.getDescricao()+"\");'><img class='icon' src='icon/padlock.png' /></a>";
                    break;
                default:
                    second_button = "<a class='btn btn-default invisible'><img class='icon' src='icon/eye.png'/></a>";
                    break;
            }
            
            obj.put(first_button + second_button + "<a class='btn btn-default' title='Visualizar' href='#'><img class='icon' src='icon/eye.png' /></a>"
                    + "<a class='btn btn-default' title='Historico de Transacoes' href='#'><img class='icon' src='icon/history.png' /></a>");
            
            data.put(obj);
        }
        
        return data;
    }
    
    public JSONArray getCompraData(List<EntidadeDominio> entidades) {
        JSONArray data = new JSONArray();
        
        for (EntidadeDominio e : entidades) {
            Pedido p = (Pedido) e;
            JSONArray obj = new JSONArray();
            
            obj.put("<div class='circle " + p.getStatus().getCor() + "'></div>");
            obj.put(p.getCodigo());
            obj.put(Mask.toDateHour(p.getDt_cadastro()));
            obj.put(Mask.toMoney(p.getValor_total()));
            
            String first_button;
            switch (p.getStatus()) {
                case ENTREGUE:
                    first_button = "<a class='btn btn-default' title='Trocar Item/Compra' "
                            + "onclick='changePedido("+p.getId()+","+StatusPedido.EM_TROCA.getId()+",\""+StatusPedido.EM_TROCA.getDescricao()+"\");'><img class='icon' src='icon/undo.png' /></a>";
                    break;
                default:
                    first_button = "<a class='btn btn-default invisible'><img class='icon' src='icon/eye.png'/></a>";
                    break;
            }
            
            obj.put(first_button + "<a class='btn btn-default' title='Visualizar' href='#'><img class='icon' src='icon/eye.png' /></a>"
                    + "<a class='btn btn-default' title='Historico de Transacoes' href='#'><img class='icon' src='icon/history.png' /></a>");
            
            data.put(obj);
        }
        
        return data;
    }
    
    public JSONArray getCarrinhoData(List<EntidadeDominio> entidades) {
        JSONArray data = new JSONArray();
        
        for (EntidadeDominio e : entidades) {
            Carrinho c = (Carrinho) e;
            
            for (Item i : c.getItens()) {
                JSONArray obj = new JSONArray();
                
                obj.put("<img src='images/produtos/" + i.getProduto().getImg_nome() + "' alt='img' />");
                obj.put(i.getProduto().getDescricao());
                obj.put(Mask.toMoney(i.getProduto().getValor_venda()));
                obj.put("<input class='form-control-sm' type='number' value='" + i.getQtd() + "' min='1' style='width: 60px;'>"
                        + "<a class='btn btn-default' title='Remover' href='item?pcr_id="+i.getId()+"&operacao=EXCLUIR'><img class='icon' src='icon/remove-red.png' /></a>");
                obj.put(Mask.toMoney(i.getProduto().getValor_venda() * i.getQtd()));
                
                data.put(obj);
            }
        }
        
        return data;
    }

}
