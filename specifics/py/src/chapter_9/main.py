import animal
import car
from dog import Dog
from multiple_modules import Something, SomethingElse

elephant = animal.Animal("Elephant", "Grey Elephant", "Dimbo", "8")
print(elephant.greetings())


my_car = car.Car({"manifacture": "Ford", "horsepower": 500,"top_speed": 289}, "Ford", "Mk2", "87")
print(my_car.specs())


# Importing without redundancy
my_dog = Dog("Schnauzer", "Didi", 5)
print(my_dog.greetings())
print(my_dog.make_noise())


print(my_dog.express_mood())
# print(elephant.express_mood())  Exeception will be raised



thing = Something()
print(thing.to_s())

thing = SomethingElse()
print(thing.to_s())