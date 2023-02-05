orders = int(input())
total = 0
for i in range(orders):
    price_per_capsule = float(input())
    days = int(input())
    capsules_needed_per_day = int(input())

    if 0.01 <= price_per_capsule <= 100.0 and 1 <= days <= 31 and 1 <= capsules_needed_per_day <= 2_000:
        sum = capsules_needed_per_day * days * price_per_capsule
        total += sum
        print("The price for the coffee is: $%.2f" % sum)

print("Total: $%.2f" % total)
