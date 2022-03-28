class Animal:
	"""A class to create many cute animals"""
	def __init__(self, type, race, name, age):
		self.type = type
		self.race = race
		self.name = name
		self.age = age


	def greetings(self):
		return f"Hi from a {self.type}, I am a cute little {self.race}!\nMy name is {self.name} and I am {self.age} years old"

	
	def make_noise(self):
		raise NotImplementendError("No implementation for parent class")
''