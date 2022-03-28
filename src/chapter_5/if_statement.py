# If statements


# Ternary operator | (if_test_false,if_test_true)[test]
a, b, = 10, 20
print( (b, a) [a < b] )


# If else in line | [on_true] if [expression] else [on_false] 
name = "Lucas"

print("Yes it is" if name == 'lucas' else "No it isn't")


# if else block
name = "Teste"

if name == 'Teste':
    result = "It's a test" 
else: 
    result = "Nothing"

print(result)


# if else in chain
age = 12

if age < 4:
 price = 0
elif age < 18:
 price = 25
elif age < 65:
 price = 40
elif age >= 65:
 price = 20

print(price)


# Compare operators
# and
age = 15

if age >= 12 and age < 18:
    print("Teenager")
else:
    print("Not Teenager")


age = 11
# or
if age < 12 or age > 18:
    print("Not Teenager")
else:
    print("Teenager")

