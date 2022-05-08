require_relative 'modulos' #importacao do arquivo modulos.rb
include Pagamento #inclusão do modulo pagamento

# USO DA CONSTANTE PRESENTE NO MODULO PAGAMENTO
puts Pagamento::PI

# USO DE UM METODO PRESENTE NO MODULO PAGAMENTO
puts Pagamento::pagar("Master", 5464648732648732823629876, 15.00)

# USO DA CLASSE TITULAR PRESENTE NO MODULO PAGAMENTO
p = Pagamento::Titular.new

p.nome = "Lucas"
p.email ="mohamed28.lucas@gmail.com"

puts p.nome
puts p.email

# USO DE UM MODULO PRESENTE DENTRO DO MODULO PAGAMENTO
include Pagamento::Pagador
puts Pagamento::Pagador.pagar