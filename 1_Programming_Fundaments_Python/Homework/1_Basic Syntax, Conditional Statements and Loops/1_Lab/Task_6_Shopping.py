budget = int(input())
command = input()
while "End" != command:
    product_price = int(command)
    budget -= product_price

    if budget < 0:
        print("You went in overdraft!")
        break
    command = input()

else:
    print("You bought everything needed.")
