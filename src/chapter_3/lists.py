#List
names = ["Lucas", "Rafael", "Daniel"]
print(names)

## Accessing values
print(names[2])

##  Modifying values
print(names)

names[2] = "Camila"
print(names)


## Avoiding no index due to list length
numbers = [1, 2, 3, 4, 5]
print(numbers[-1])

numbers.remove(4)
print(numbers[-1])


## Appending method
animals = ["Dog", "Cat", "Frog"]
print(animals)

animals.append("Monkey")
print(animals)


## Insert method
letters = ["A", "C", "D"]
print(letters)

letters.insert(1, "B")
print(letters)

letters.insert(4, "E")
print(letters)


## Pop method
motorcycles = ["Honda", "Yamaha", "Suzuki"]
last = motorcycles.pop()
print(last)
print(motorcycles)


## Sort method - Permanently
fruits = ["Mango", "Banana", "Orange","Grape"]
print(fruits)

fruits.sort()
print(fruits)

## Sort method - Temporarily
veggies = ["Tomato", "Carrot", "Onion", "Broccoli"]
sorted_veggies = sorted(veggies)

print(veggies)
print(sorted_veggies)


## Reverse method
print(sorted_veggies.reverse())


## length method
print(len(sorted_veggies))


## Removing method
colors = ["Red", "Gold", "Black"]
print(colors)

colors.remove("Black")
print(colors)


## del statement
names = ["Lucas", "Xiao", "Someone"]
print(names)

del names[2]
print(names)

name = "Lucas"
print(name)

del name
print(name)
