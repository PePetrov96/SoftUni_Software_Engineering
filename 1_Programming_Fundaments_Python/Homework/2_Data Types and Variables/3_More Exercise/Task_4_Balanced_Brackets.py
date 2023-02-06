lines = int(input())

is_balanced = True
has_open_bracket = False

for _ in range(0, lines):
    line = input()
    if line != '(' and line != ')':
        continue

    is_open_bracket = line == '('
    if has_open_bracket == is_open_bracket:
        is_balanced = False
        break

    has_open_bracket = is_open_bracket

if is_balanced:
    print('BALANCED')
else:
    print('UNBALANCED')