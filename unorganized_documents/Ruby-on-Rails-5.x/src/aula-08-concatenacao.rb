#concatenação +
x = "teste_1 "
puts x
puts x.object_id

y = "de concatenação"
puts y
puts y.object_id

x = x + y
puts x
puts x.object_id

# concatenação <<
a = "teste_2 "
b = "de concatenação"

puts a << b
puts a.object_id
puts b.object_id

puts a
puts a.object_id


#concatenação interpolada
puts "teste_3 #{"de concatenação"}"

z = "de concatenação"

puts "teste_4 #{z}"