n = int(input())

for i in range(n):
    m = int(input())
    if not m % 2 == 0:
        print(f"{m} is odd!")
        break
else:
    print("All numbers are even.")
