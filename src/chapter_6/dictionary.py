# Dictionary
# Kinda like Hash in Ruby or event kinda of struct

alien_0 = {"color": "green", "points": 5}

print(alien_0["color"])
print(alien_0["points"])
print(alien_0)


# Assign new keys and values
alien_0["x"] = 25
alien_0["y"] = 0

print(f"Alien y = {alien_0['y']}, Alien x = {alien_0['x']}")


# Removing dictionary value
print(alien_0)

del alien_0["color"]

print(alien_0)


# Method get()
print(alien_0.get("color", "Value not found"))


# Method items()
for key, value in alien_0.items():
    print(key, value)


# Method keys()
print(alien_0.keys())


# Method values()
print(alien_0.values())


# List of Dictionary
players = [
    {"health": 100},
    {"health": 80},
    {"health": 50},
    {"health": 20},
]

for player in players:
    print(player["health"])


# List inside a Dictionary
zoo = {"animals": ["Elephant", "Monkey", "Tiger", "Lion"]}

print(zoo["animals"][2])


# Dictionary inside a Dictionary
player = {"skills": {"Stregth": 10, "Charisma": 0, "Dexterity": 5, "Lucky": -5}}

print(player["skills"]["Lucky"])
