package br.com.fatecmc.joaodebarro.control.viewhelper;

import br.com.fatecmc.joaodebarro.model.domain.*;
import br.com.fatecmc.joaodebarro.util.ParameterParser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdutoVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        Produto produto = new Produto();
        
        produto.setTipo(TipoProduto.idToEnum(ParameterParser.toInt(request.getParameter("prd_tpd_id"))));
        produto.setDescricao(request.getParameter("prd_descricao"));
        produto.setMarca(request.getParameter("prd_marca"));
        produto.setCor_tonalidade(request.getParameter("prd_cor_tonalidade"));
        produto.setMaterial(request.getParameter("prd_material"));
        produto.setComprimento(ParameterParser.toInt(request.getParameter("prd_comprimento")));
        produto.setLargura(ParameterParser.toInt(request.getParameter("prd_largura")));
        produto.setCodigo_barra(request.getParameter("prd_codigo_barra"));
        produto.setPei(ParameterParser.toInt(request.getParameter("prd_pei")));
        produto.setGrupo(GrupoPrecificacao.idToEnum(ParameterParser.toInt(request.getParameter("prd_gpp_id"))));
        
        if(request.getParameterValues("ctg_id") != null)
            for(String value: request.getParameterValues("ctg_id")){
                produto.getCategorias().add(Categoria.idToEnum(Integer.parseInt(value)));
            }
        
        return produto;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("operacao").equals("CONSULTAR")){
            request.setAttribute("produto", resultado);
            request.getRequestDispatcher("form_produto.jsp").forward(request, response);
        } else {
            response.sendRedirect("admin.jsp");
        }
    }
    
}
