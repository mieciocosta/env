#language: pt
@movie
Funcionalidade: validar envio de movie
		
    Cenario: CT - Validar dados de retorno
    Dado que estou enviando dados para a api com a apiKey
      | codigoDeRetorno | apiKey                                    |
      | 200 			| 5daebf506d952695f0e767e0fca43bda          |

    Quando valido o id do IMDB
      | idImdb    | apiKey                                    |
      | tt0137523 | 5daebf506d952695f0e767e0fca43bda          |

    Entao valido o spoken language
       |apiKey                          |name   | iso|
      |5daebf506d952695f0e767e0fca43bda |English| en       |
  