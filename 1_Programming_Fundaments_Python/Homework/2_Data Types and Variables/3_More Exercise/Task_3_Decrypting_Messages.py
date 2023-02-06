key = int(input())
n = int(input())

for i in range(n):
    print((chr(key + ord(input()))), end='')
