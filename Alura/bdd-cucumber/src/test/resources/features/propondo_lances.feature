# language: pt
Funcionalidade: Propondo lances
  Cenário: : Propondo um único lance válido
    Dado um lance de 10.0 reais do usuario "fulano"
    Quando propõe ao leilão
    Então o lance é aceito

  Cenário: Propondo vários lances válidos
    Dado um lance de 10.0 reais do usuario "fulano"
    E um lance de 15.0 reais do usuario "beltrano"
    Quando propõe vários lances ao leilão
    Então os lances são aceitos

  Esquema do Cenário: Propondo um lance inválido
    Dado um lance inválido de <valor> reais do usuário "fulano"
    Quando propõe ao leilão
    Então o lance não é aceito

    Exemplos:
      | valor |
      |   0.0 |
      |  -1.0 |
      | -10.0 |

  Cenário: Propondo um sequencia de lances
    Dado um lance de 10.0 reais do usuario "fulano"
    E um lance de 15.0 reais do usuario "fulano"
    Quando propõe vários lances ao leilão
    Então o segundo lance não é aceito

    Cenario: Dois lances válidos de pessoas iguais
      Dado dois lances
        | valor | nomeUsuario |
        |  10.0 |   beltrano  |
        |  11.0 |   beltrano  |
      Quando propõe vários lances ao leilão
      Então o segundo lance não é aceito