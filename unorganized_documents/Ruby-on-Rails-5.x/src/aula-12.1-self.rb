class Pessoa
    def meu_id
        "Meu id é: #{self.object_id}"
    end
end

p = Pessoa.new

puts p.meu_id
