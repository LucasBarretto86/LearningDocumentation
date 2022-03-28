# User input

name = input("Tell me what's you age my little friend: ")
print(f"Welcome {name}")

# Multiple lines prompt input
message = f"{name} this is a very long message that we gonna use as example,\n"
message += "to allow as yo use multiple lines to do an input. What do you think?\n"
message += "Isn't that great? [Y/N]"

prompt = input(message)
print(prompt)
answer = prompt[:1][0].lower()

if(answer == "y"):
    print("I knew it, we are awsome\n\n")
elif(answer == "n"):
    print("Oh that isn't right\n\n")
else:
    print("Try again dude!\n\n")


# int() method to handle number input
sum = input("2 + 2 = ")

if(int(sum) == 4):
    print("well done!\n\n")
else:
    print("Bastard!\n\n")


# int() method to modular even odd test
num = input("Inform a number to check if it's even or odd:")

if(int(num) % 2 != 0):
    result = "odd"
else:
    result = "even"

print(f"{num} is {result}")    