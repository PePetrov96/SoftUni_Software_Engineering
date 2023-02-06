text = input()
indexes = []
for i in range(len(text)):
    if text[i].isupper():
        indexes.append(i)
print(indexes)
