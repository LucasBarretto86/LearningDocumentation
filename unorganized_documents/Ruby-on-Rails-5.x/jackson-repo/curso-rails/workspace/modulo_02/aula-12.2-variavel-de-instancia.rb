class Pessoa
    
    def initialize
        @nome = "Lucas"   
    end
    
    def show_nome
        @nome
    end
end

p = Pessoa.new

puts p.show_nome
