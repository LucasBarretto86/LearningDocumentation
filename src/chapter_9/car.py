from engine import Engine
class Car:
	"""Car class, used to create many car instances"""

	def __init__(self, new_engine, manifacture, model, year):
		self.engine = Engine(new_engine["manifacture"], new_engine["horsepower"], new_engine["top_speed"])
		self.manifacture = manifacture
		self.model = model
		self.year = year

	def specs(self):
		specs = f"Manifacture: {self.manifacture}\n"
		specs += f"Model: {self.model}\n"
		specs += f"Year: {self.year}\n"
		specs += self.engine.specs()
		return specs
