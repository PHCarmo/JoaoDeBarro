#language: pt
Funcionalidade: Gerenciar Conta Pessoal

  Contexto: Acessar Site
    Dado a página inicial é acessada

  Esquema do Cenário: Registrar Usuário
    Dado a página de login é acessada
    Quando os dados de registro "<email>" "<senha>" são preenchidos
    Então a página de cadastro de cliente é exibida

    Exemplos: 
      | email         | senha     |
      | aut@teste.com | @uT0M@ção |
