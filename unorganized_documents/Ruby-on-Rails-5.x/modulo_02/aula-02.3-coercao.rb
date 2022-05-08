# coerção
puts "Digite seu nome: "
nome = gets.chomp

puts "Digite sua idade: "
idade = gets.chomp.to_i #string to integer

puts "Digite seu salário: "
salario = gets.chomp.to_f #string to float

puts "Nome: " + nome + "\nIdade: " + idade.to_s + "\nSalario: " + salario.to_s # numeros (integer, float) to string

nomes = "Lucas Daniel Rafael".split # string to array
puts nomes;

=begin
    Tabela de metodos de coerço
    Class	      Explicit	   Implicit
    Array	        to_a	    to_ary
    Hash	        to_h	    to_hash
    String	        to_s	    to_str
    Integer 	    to_i    	to_int
    Float  	        to_f    	-
    Complex	        to_c    	-
    Rational	    to_r    	-
    Regexp	        -	        to_regexp
    IO	            -	        to_io
=end