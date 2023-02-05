name = input()

while "Welcome!" != name:
    length = len(name)

    if name == "Voldemort":
        print("You must not speak of that name!")
        break

    if length < 5:
        print(f"{name} goes to Gryffindor.")
    elif length == 5:
        print(f"{name} goes to Slytherin.")
    elif length == 6:
        print(f"{name} goes to Ravenclaw.")
    elif length > 6:
        print(f"{name} goes to Hufflepuff.")

    name = input()

else:
    print("Welcome to Hogwarts.")
