module Pagamento
    #CONSTANTE
    PI = 3.14
    
    #METODO
    def pagar(bandeira, numero, valor)
        "Pagamento com cartão #{bandeira} numero #{numero} no valor de #{valor}"
    end
    
    #CLASSE
    class Titular
        attr_accessor :nome, :email
    end
    
    #MODULO
    module Pagador
        def pagar
            "Pagando...."
        end
    end
end