#language: pt
@regressivo
Funcionalidade: Gerenciar Pedido

  Contexto: Acessar Site
    Dado a página inicial é acessada

  Cenário: Realizar Compra de Múltiplos Produtos
    Dado a página de produtos é acessada
    Quando o produto "prod1" é visualizado em detalhes
    E "4" produto é adicionado ao carrinho
    E a página de produtos é acessada
    E o produto "prod3" é visualizado em detalhes
    E "2" produto é adicionado ao carrinho
    E a página de carrinho é acessada
    E o checkout é feito com os dados disponíveis
    Então a página de perfil de cliente é exibida

  Cenário: Iniciar Entrega de Pedido
    Dado o cliente possui um pedido já aprovado
    E a página de administrador é acessada
    E "Vendas" é visualizado
    E existe um pedido "Aprovada"
    Quando o transporte é definido para a etapa "Iniciar Entrega"
    Então a página de perfil de administrador é exibida

  Cenário: Finalizar Entrega de Pedido
    Dado a página de administrador é acessada
    E "Vendas" é visualizado
    E existe um pedido "Em Tr�nsito"
    Quando o transporte é definido para a etapa "Pedido Entregue!"
    Então a página de perfil de administrador é exibida

  Cenário: Solicitar Troca
    Dado a página de perfil é acessada
    E "Compras" é visualizado
    E existe um pedido "Entregue"
    Quando é realizada a ação "Trocar Item/Compra"
    E todos itens de troca são selecionados
    E a troca é confirmada
    Então a página de perfil de cliente é exibida

  Cenário: Aprovar Troca
    Dado a página de administrador é acessada
    E "Vendas" é visualizado
    E existe um pedido "Em Troca"
    Quando é realizada a ação "Liberar Troca"
    E a troca é confirmada
    Então a página de perfil de administrador é exibida
    E é gerado um vale-troca para o cliente

  Cenário: Realizar Compra com Múltiplos Cartões, Cupom e Vale-Troca
    Dado a página de produtos é acessada
    Quando o produto "prod2" é visualizado em detalhes
    E "3" produto é adicionado ao carrinho
    E a página de carrinho é acessada
    E um novo cartão é iniciado cadastro
    E os dados de cartão inválido "5239269870313897" são preenchidos
    E a página de carrinho é acessada
    E o checkout é feito usando os cartões e cupons
    Então é exibida a modal com o erro "Não se paga compra gratuita!"

