command = input()

while command != "End":
    if not command == "SoftUni":
        for i in range(len(command)):
            print(command[i] + command[i], end='')
        print()
    command = input()
