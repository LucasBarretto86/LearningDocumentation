# Modules
import bot
bot.greetings("Lucas")


# Modules with alias
import bad_named_module as good_name
good_name.greetings("Rafael")


# Importing all functions from external module
from functions import *
print(full_name("Lucas", "Silva"))
