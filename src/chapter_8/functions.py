# Functions
def say_hello():
    print("Hello!")

say_hello()


# Parameters / Arguments
def say_hello_to(someone):
    print(f"Hello, {someone}!")


say_hello_to("XiaoJiao")


# Return simple value
def sum(x, y):
    result = x + y
    return result


print(sum(2, 2))


# Default Parameters / Arguments
def smile(smilling=True):
    if smilling:
        print("You are happy")
    else:
        print("You are sad")


smile()
smile(False)


# Join list values with filter to remove None values
def full_name(name, last_name, middle_name=None):
    params = [name, middle_name, last_name]

    return " ".join(filter(lambda element: element != None, params))


print(full_name("Lucas", "Silva"))
print(full_name("Lucas", "Silva", "Barretto e"))


# Key parameters
def set_user_name(first_name="", middle_name="", last_name=""):
    params = [first_name, middle_name, last_name]

    return " ".join(filter(lambda element: len(element) > 1, params))


print(set_user_name(first_name="Jorge"))
print(set_user_name(middle_name="Ben"))
print(set_user_name(last_name="Jor"))
print(set_user_name("Jorge", "Ben", "Jor"))
print(set_user_name("Jorge", "Ben"))
print(set_user_name("Jorge", "", "Jor"))


# Function with list as paramenter
def say_hellos(names):
    for name in names:
        print(f"Hello, {name}")


say_hellos(["Lucas", "Fulano", "Sicrana"])

# Function changing list data


def modifying(list):
    for item in list:
        if type(item) == int or type(item) == float:
            list[list.index(item)] = item**2
    return list


list = [1, 2, 3, 4]
modifying(list)
print(list)


# Function transfering data between lists
def transfer(invitees, confirmed):
    while invitees:
        guest = invitees.pop()
        if len(guest) < 8:
            confirmed.append(guest)
    return confirmed


invitees = ["Julio", "Mariano", "Adalberto", "Pachuca", "Guarapiranga"]

confirmed = transfer(invitees, [])

print(confirmed)


# Function copy lists
def titlelize(surnames):
    for surname in surnames:
        surnames[surnames.index(surname)] = surname.title()

    return surnames


# No copying
surnames = ["silva", "olveira", "lopes", "souza"]
print(titlelize(surnames))
print(surnames)

# Copying
surnames = ["silva", "olveira", "lopes", "souza"]
print(titlelize(surnames[:]))
print(surnames)


# Arbitrary paramenters
def display_cars(*cars):
    for car in cars:
        print(car)


display_cars("Ferrari", "Audi", "Ford", "Toyota", "Honda")


# Positional and Abritary paramenters
def display_fruits(limit, *fruits):
    counter = 0
    while counter < limit:
        print(fruits[counter])
        counter += 1


display_fruits(3, "Banana", "Mango", "Apple", "Orange", "Grapes", "Lemon")


# Positional and Abritary key paramenters
def display_months(month, **options):
    print(options)
    print(options[month])


display_months("jul", jul=7, aug=8, sep=9)


def greetings(name):
    print(f"Hello {name}!")

