
puts "EXEMPLO DO LOOP WHILE"
i = 0;
while i < 3
	puts i
	i+=1
end

puts "EXEMPLO DO LOOP UNTIL"
a = 0
until a > 10
	puts a
	a+=2
end

puts "EXEMPLO DO LOOP EACH EM UM RANGE"
(0..5).each do |x|
	puts x
end	

puts "EXEMPLO DO LOOP EACH EM UM ARRAY "
['a', 'b', 3, 4].each do |y|
	puts y
end
