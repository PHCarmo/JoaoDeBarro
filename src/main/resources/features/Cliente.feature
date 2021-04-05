#language: pt
Funcionalidade: Gerenciar Conta Pessoal

  Contexto: Acessar Site
    Dado a página inicial é acessada

  Esquema do Cenário: Registrar Cliente
    Dado a página de login é acessada
    Quando os dados de registro "<email>" "<senha>" são preenchidos
    E a página de cadastro de cliente é exibida
    E os dados do cliente "<cpf>" são preenchidos
    E os dados de endereço "<cep>" são preenchidos
    Então a página de perfil de cliente é exibida

    Exemplos: 
      | email         | senha     | cpf         | cep      |
      | aut@teste.com | @uT0M@ção | 84617405054 | 16902165 |

  Cenário: Cadastrar Endereço
    Dado a página de perfil é acessada
    Quando "Endereços" é visualizado
    E o cadastro de "endereco" é inicializado
    E os dados de endereço "84617405054" são preenchidos
    Então a página de perfil de cliente é exibida

  Cenário: Cadastrar Cartão de Crédito
    Dado a página de perfil é acessada
    Quando "Cartões" é visualizado
    E o cadastro de "cartao" é inicializado
    E os dados de cartão "84617405054" são preenchidos
    Então a página de perfil de cliente é exibida
