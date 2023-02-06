num = int(input())

if num <= 1:
    print(False)
    exit()
for i in range(2, int(num ** 0.5) + 1):
    if num % i == 0:
        print(False)
        exit()
else:
    print(True)
    exit()
