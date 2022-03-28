# Simple polling system to create a dictionary of users based in questions and responses
# It will use while loop, for loop, list, dictionary, input and if statements

users = []

questions = {
    "name": "What's your name?",
    "age": "How old are you?",
    "color": "What's your favorite color?"
}

polling_status_active = True

while polling_status_active:
    new_user = {}

    for attr, question in questions.items():
        answer = input(f"{question} (q = Quit)\n")

        if answer.lower() == "q" and len(answer) == 1:
            polling_status_active = False
            break
        else:
            new_user[attr] = answer
    
    if len(new_user) > 0:
        users.append(new_user)

    print(users)       
