quantity = int(input())
days = int(input())

christmas_spirit = 0
budget = 0

for day in range(1, days + 1):
    if day % 11 == 0:
        quantity += 2

    if day % 10 == 0:
        christmas_spirit -= 20
        budget += (5 + 15 + 3)

        if day == days:
            christmas_spirit -= 30

    if day % 5 == 0:
        christmas_spirit += 17
        budget += (15 * quantity)

    if day % 15 == 0:
        christmas_spirit += 30

    if day % 3 == 0:
        christmas_spirit += 13
        budget += ((3 + 5) * quantity)

    if day % 2 == 0:
        christmas_spirit += 5
        budget += (2 * quantity)

print(f"Total cost: {budget}")
print(f"Total spirit: {christmas_spirit}")
