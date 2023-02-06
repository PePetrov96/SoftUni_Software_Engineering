text = str.lower(input())
counter = 0
index = 0

beach_words = ["sand", "water", "fish", "sun"]

for n in beach_words:
    counter += text.count(n)

print(counter)
