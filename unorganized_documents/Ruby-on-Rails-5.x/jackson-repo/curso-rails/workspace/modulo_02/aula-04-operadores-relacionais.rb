=begin
	Operadores Relacionais
		==	igualdade
		!=	diferença
		<	menor
		>	maior
		>=	maior igual
		<=	menor igual
		||	ou
		&&	e
=end

puts "== compara se dois valores são iguais"
if 1 == 2
	puts "verdadeira"
else
	puts "falso"
end
	
puts "!= compara se dois valores são diferentes"
if 1 != 2
	puts "verdadeira"
else
	puts "falso"
end

puts ">= compara se um determinado valor é maior ou igual a o outro"
if 1 >= 2
	puts "verdadeira"
else
	puts "falso"
end

puts "<= compara se um determinado valor é menor ou igual a outro"
if 1 <= 2
	puts "verdadeira"
else
	puts "falso"
end	

puts "|| verificar entre dois testes condicionais se alguma é verdade, se um OU outro for verdadeiro o resultado será verdadeiro"
if 1 <= 2 || 1 == 1
	puts "verdadeira"
else
	puts "falso"
end	


puts "&& verificar entre dois testes condicionais se ambos são verdade, se um OU outro for falso o resultado será falso"
if 1 >= 2 && 1 == 1
	puts "verdadeira"
else
	puts "falso"
end	
