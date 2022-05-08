class Pessoa
    
    def initialize
        puts "Inicializando o objeto...."
    end
    
    def falar
        "Olá mundo Ruby!"
    end
    
    def falar_2(nome = "Lucas")
      "Olá #{nome}!" 
    end
    
    def falar_3(nome, mensagem = "tamo junto!")
        "Olá #{nome}, #{mensagem}"
    end
end

p = Pessoa.new

puts p.falar;

puts p.falar_2("Jorge")

puts p.falar_3("Lucas")

puts p.falar_3("Lucas", "Ah... Muleke!")

