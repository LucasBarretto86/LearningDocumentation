
from animal import Animal

class Dog(Animal):
	"""Dog animal class, this has inherentance from Animal class"""

	def __init__(self, race, name, age):
		super()
		self.type = "Dog"
		self.race = race
		self.name = name
		self.age = age
		self.mood = "Happy"

	def make_noise(self):
		return "Bwahwahwah!"


	def express_mood(self):
		reaction  = ""
		
		if self.mood == "Happy":
		 	reaction = f"{self.name} is happy, he's shaking it's tail" 
		else: 
		 	reaction = f"{self.name} doesn't answer"
		
		return reaction