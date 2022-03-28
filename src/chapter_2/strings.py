#Strings
message = "Hello Python World!"
print(message)


## String transformation/cases
warning = "atTenTion pleAse"
print(warning)

### Titlecase
print(warning.title())

### Uppercase
print(warning.upper())

### Lowercase
print(warning.lower())


## String interpolation
name = "xiao jiao"
last_name = "liu"
full_name = f"{last_name.upper()}, {name.title()}"
print(full_name)

message = f"I love you Ms. {full_name}"
print(message)


## Adding tab to a string
print("\tPython")

## Adding line breaker to a string
print("Language:\nPython\nC\nJavascript\n")


## Strip method
string_with_extra_space = " python "
print(string_with_extra_space.strip())

### Right side strip method
print(string_with_extra_space.rstrip())

### Left side strip method
print(string_with_extra_space.lstrip())
