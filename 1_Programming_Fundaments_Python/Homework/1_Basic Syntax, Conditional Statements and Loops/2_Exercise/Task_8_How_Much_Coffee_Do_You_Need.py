command = input()
total_coffee = 0
while command != "END":
    if command.casefold() == "coding" or command.casefold() == "dog"\
            or command.casefold() == "cat" or command.casefold() == "movie":
        if command.isupper():
            total_coffee += 2
        else:
            total_coffee += 1
    command = input()

if total_coffee > 5:
    print("You need extra sleep")
else:
    print(total_coffee)
