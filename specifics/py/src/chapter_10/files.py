# How to handle local files in Py

# How to open files in python
with open('chapter_10/pi_digits.txt') as file:
  contents = file.read()
  print(contents) 

# How to open multiple lines file and print line by line
with open('chapter_10/multiple_lines.txt') as file:
  for line in file:
    print(line)


# How to handle multiple lines at once
with open('chapter_10/multiple_lines.txt') as file:
  lines = file.readlines()
  print(lines)


  for line in lines:
    print(line)