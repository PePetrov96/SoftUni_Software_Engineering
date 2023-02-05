n = int(input())

for i in range(n):
    line = input()
    if ',' not in line and '.' not in line and '_' not in line:
        print(f"{line} is pure.")
    else:
        print(f"{line} is not pure!")
