# While loop
current_number = 1

while current_number <= 5:
    print(current_number)
    current_number += 1


# # Using also input()
message = ""

while message != "Yes, I do":
    message = input("I love you XiaoJiao! Do you love me too?\n")
    print(message)


# Using flag
active = True

while active:
    message = input("Type 'q' to quit operation:\n")

    if(message.lower() == "q"):
        active = False

# Break loop
while True:
    message = input("Type 'q' to quit operation:\n")

    if(message.lower() == "q"):
        break


# While loop to transfer data bewteen Lists
guests = []

invitees = ["JuJu", "Dudu", "Babu", "ZonZon"]

while invitees:
    guests.append(invitees.pop())

print(guests)


# While in for lists checking conditional value
animals = ["Dog", "Bee", "Monkey", "Bee", "Cat", "Elephant", "Bee", "Kanguroo", "Bee"]

while "Bee" in animals:
    animals.remove("Bee")

print(animals)


# while to handle dictionary
player = {"x": 0, "y": 0}

target = 300

while target > player["x"]:
    player["x"] += 10

print(player)