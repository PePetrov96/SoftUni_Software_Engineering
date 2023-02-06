n = int(input())
numbers_list = []

for i in range(n):
    numbers_list.append(int(input()))

command = input()

if command == 'even':
    print(list(filter(lambda c: c % 2 == 0, numbers_list)))
elif command == 'odd':
    print(list(filter(lambda c: c % 2 != 0, numbers_list)))
elif command == 'negative':
    print(list(filter(lambda c: c < 0, numbers_list)))
elif command == 'positive':
    print(list(filter(lambda c: c >= 0, numbers_list)))
