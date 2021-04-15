#language: pt
Funcionalidade: Gerenciar Pedido

  Contexto: Acessar Site
    Dado a página inicial é acessada

  Cenário: Realizar Compra
    Dado a página de produtos é acessada
    Quando um produto é visualizado em detalhes
    E o produto é adicionado ao carrinho
    E a página de carrinho é acessada
    E o checkout é feito com os dados disponíveis
    Então um pedido é gerado

  Cenário: Finalizar Pedido
    Dado a página de administrador é acessado
    E "Vendas" é visualizado
    E existe um pedido "Aprovado"
    Quando o transporte é definido para a etapa "Em Trânsito"
    E o transporte é definido para a etapa "Entregue"
    Então o pedido está "Entregue"

  Cenário: Solicitar Troca
    Dado a página de perfil é acessada
    E "Compras" é visualizado
    E existe um pedido "Entregue"
    Quando a troca é solicitada
    E os itens de troca são selecionados
    Então o pedido está "Em Troca"

  Cenário: Aprovar Troca
    Dado a página de administrador é acessada
    E "Vendas" é visualizado
    E existe um pedido "Em Troca"
    Quando a troca é aprovada
    Então o pedido está "Troca Autorizada"
    E é gerado um vale-troca para o cliente
