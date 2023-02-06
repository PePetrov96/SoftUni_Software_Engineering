n = int(input())
positives = []
negatives = []

for i in range(n):
    num = int(input())

    if num >= 0:
        positives.append(num)
    else:
        negatives.append(num)

sum = 0
for i in range(len(negatives)):
    sum += negatives[i]

print(positives)
print(negatives)
print(f'Count of positives: {len(positives)}')
print(f'Sum of negatives: {sum}')
