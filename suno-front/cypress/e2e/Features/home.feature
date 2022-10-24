#language: pt

Funcionalidade: Validar Home e Search
    Cenário: Validar Home e consultar por por serie peaky blinders 
    Dado que o usuario esta na home
    Quando clicar em search 
    E pesquisar por serie peaky blinders
    Então validar url

    Cenário: Validar Home e consultar por por serie peaky blinders e validar na pdp presença de "entre com uma conta pra editar"
    Dado que o usuario esta na home
    Quando clicar em search 
    E pesquisar por serie peaky blinders
    E selecionar serie
    Então validar botão de acessar conta

   