lost_fights = int(input())
helmet_price = float(input())
sword_price = float(input())
shield_price = float(input())
armor_price = float(input())

expenses = 0
shields = 0

for i in range(1, lost_fights+1):
    if i % 2 == 0:
        expenses += helmet_price  # break helmet

    if i % 3 == 0:
        expenses += sword_price  # break sword

    if i % 2 == 0 and i % 3 == 0:  # if sword and helmet break
        expenses += shield_price  # break shield
        shields += 1
        if shields % 2 == 0:  # every second shield break
            expenses += armor_price  # also break his armor

print(f"Gladiator expenses: {expenses:.2f} aureus")
