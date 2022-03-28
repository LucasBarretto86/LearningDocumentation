# More about lists

## For Loop, Iteration
animals = ["Dog", "Cat", "Bat", "Horse"]

for animal in animals:
    print(animal)


## Iteration based in range method
for index in range(0, 4):
    print(animals[index])


## list method to create a list using range method 
numbers = list(range(1,10))
print(numbers)

## max method
print(max(numbers))

## min method
print(min(numbers))

## sum method
print(sum(numbers))

## create list of squares using append method and range method
squares = []

for value in range(1, 11):
    squares.append(value**2)
print(squares)

## create list of squares using for and range method
squares = [value**2 for value in range(1, 11)]
print(squares)

# List slices
## Slice from index X to length Y, [index:length]
names = ["Lucas", "Mariano", "Roberto", "Reginaldo", "Gilberto"]
print(names)
print(names[1:5])

## Slice from index X to an unknown length
integers = list(range(0, 101)) 
print(integers[90:])

## Looping through slice
for value in integers[:10]:
    print(value)

for value in integers[-11:]:
    print(value)

## Copying list through slice
colors = ["Blue", "Red", "Yellow", "Black", "Pink"]
print(colors)

colors_copy = colors[:] # Copy with slice
colors_backup = colors

colors.pop()
print(colors)
print(colors_backup)
print(colors_copy) # Since it's copy from the value and not from reference isn't effected by changes on the colors
