capacity = 255
n = int(input())

for i in range(n):
    pour = int(input())

    if pour <= capacity:
        capacity -= pour
    else:
        print("Insufficient capacity!")

print(255 - capacity)
