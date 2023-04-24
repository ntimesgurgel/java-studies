# language: pt

Funcionalidade: Apenas usuários cadastrados podem se logar

  Cenario: Um usuário válido consegue se logar
    Dado o usuário válido
    Quando realiza login
    Entao é redirecionado para a pagina de leilões


  Cenario: Um usuário inválido não consegue se logar
    Dado o usuário inválido
    Quando tenta logar
    Entao continua na página de login