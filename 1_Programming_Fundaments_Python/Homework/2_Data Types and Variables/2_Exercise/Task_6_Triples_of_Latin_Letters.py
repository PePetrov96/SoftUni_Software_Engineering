n = int(input())

for i in range(n):
    for j in range(n):
        for k in range(n):
            print(chr(97+i) + chr(97+j) + chr(97+k))
