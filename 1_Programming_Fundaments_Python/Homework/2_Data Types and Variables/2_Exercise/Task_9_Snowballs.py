n = int(input())

max_value = 0
highest = ""

for i in range(n):
    weight = int(input())
    time = int(input())
    quality = int(input())

    value = int((weight / time) ** quality)

    if value > max_value:
        max_value = value
        highest = f"{weight} : {time} = {value} ({quality})"

print(highest)
