class Pessoa
    attr_accessor :nome, :email
end

class PessoaFisica < Pessoa
    attr_accessor :cpf
end

class PessoaJuridica < Pessoa
    attr_accessor :cnpj
end

pf = PessoaFisica.new
pf.nome = "Lucas"
pf.cpf = 33333333333333

puts pf.nome
puts pf.cpf

pj = PessoaJuridica.new
pj.nome = "Funil"
pj.cnpj = 12341245676878923456

puts pj.nome
puts pj.cnpj
