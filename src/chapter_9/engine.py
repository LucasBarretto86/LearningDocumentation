class Engine:
	"""Engine class, will composite car instances"""

	def __init__(self, manifacture, horsepower, top_speed):
		self.manifacture = manifacture
		self.hp = horsepower
		self.top_speed = top_speed


	def specs(self):
		specs = f"Engine specs:\n"
		specs += f"\tManifacture: {self.manifacture}\n"
		specs += f"\tHP: {self.hp}hp\n"
		specs += f"\tTop Speed: {self.top_speed}Km/h\n"
		return specs