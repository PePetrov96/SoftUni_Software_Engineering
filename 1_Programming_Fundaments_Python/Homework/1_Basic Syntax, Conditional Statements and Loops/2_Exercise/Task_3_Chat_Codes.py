n = int(input())

for i in range(n):
    code = int(input())
    if code == 88:
        print("Hello")
    elif code == 86:
        print("How are you?")
    elif code < 88:
        print("GREAT!")
    else:
        print("Bye.")
