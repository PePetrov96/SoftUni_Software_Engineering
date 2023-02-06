array = input().split(", ")

if array.pop() == "wolf":
    print("Please go away and stop eating my sheep")
    raise SystemExit

reversed_array = array[::-1]

for i in range(len(reversed_array)):
    if reversed_array[i] == "wolf":
        print(f"Oi! Sheep number {i + 1}! You are about to be eaten by a wolf!")
