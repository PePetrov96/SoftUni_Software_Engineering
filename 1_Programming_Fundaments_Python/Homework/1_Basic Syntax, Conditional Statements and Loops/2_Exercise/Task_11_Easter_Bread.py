budget = float(input())

flour_price = float(input())
eggs_price = flour_price * 0.75
milk_price = flour_price * 1.25

bread_price = flour_price + eggs_price + (milk_price / 4)

loaves = 0
colored_eggs = 0

while budget >= bread_price:
    loaves += 1
    budget -= bread_price
    colored_eggs += 3
    if loaves % 3 == 0:
        colored_eggs -= (loaves - 2)

print(f'You made {loaves} loaves of Easter bread! Now you have {colored_eggs} eggs and {budget:.2f}BGN left.')
