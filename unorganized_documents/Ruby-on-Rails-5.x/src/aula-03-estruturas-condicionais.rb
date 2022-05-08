#Estruturas Condicionais

#if
puts "EXEMPLO DE TESTE CONDICIONAL IF"
x=1

if x == 1
    puts "Validação verdadeira"
end

#else
puts "EXEMPLO DE TESTE CONDICIONAL IF ELSE"
w = 1
if w == 2
    puts "Verdadeiro"
else
    puts "falso"
end

#elsif
puts "EXEMPLO DE TESTE CONDICIONAL ELSIF"
y = 2

if y == 3
    puts "A condição if é verdadeira"
elsif y < 3
    puts "A condição if é falsa e a condição elsif é verdadeira"
end

#unless
puts "EXEMPLO DE TESTE CONDICIONAL UNLESS"
z = 1

unless z > 10
	puts "condição unless" 
else
	puts "condição else', ou seja, o x é maior que dez"
end

#case
puts "EXEMPLO DE TESTE CONDICIONAL CASE"
idade = 5

case idade
    when 0 .. 2
		puts "Bebe"
	when 3 .. 12
		puts "Criança"
	when 13 .. 18
		puts "Adolescente"
	else
	    puts "Adulto"
end