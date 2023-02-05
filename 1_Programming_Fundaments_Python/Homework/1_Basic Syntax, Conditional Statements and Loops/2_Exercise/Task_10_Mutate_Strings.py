first = input()
second = input()

for i in range(len(first)):
    if first[i] != second[i]:
        print(second[0:i+1], end='')
        print(first[i+1:len(first)], end='')
        print()
