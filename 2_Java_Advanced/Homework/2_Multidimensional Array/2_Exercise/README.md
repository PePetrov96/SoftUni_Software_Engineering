## Task 1. Fill the Matrix

Filling a matrix regularly (top to bottom and left to right) is boring. Write two methods that fill a size N x N matrix in two different patterns.



## Task 2. Matrix of Palindromes

Write a program to generate the following matrix of palindromes of 3 letters with r rows and c columns like the one in the examples below.
-Rows define the first and the last letter: row 0 -> ‘a’, row 1 -> ‘b’, row 2 -> ‘c’, …
-Columns + rows define the middle letter:
  --column 0, row 0 -> ‘a’, column 1, row 0 -> ‘b’, column 2, row 0 -> ‘c’, …
  --column 0, row 1 -> ‘b’, column 1, row 1 -> ‘c’, column 2, row 1 -> ‘d’, …



## Task 3. Diagonal Difference

Write a program that finds the difference between the sums of the square matrix diagonals (absolute value).



## Task 4. Maximal Sum

Write a program that reads a rectangular integer matrix of size N x M and finds the square 3 x 3 with a maximal sum of its elements.



## Task 5. Matrix Shuffling

Write a program which reads a string matrix from the console and performs certain operations with its elements. User input is provided similarly to the problems above – first, you read the dimensions and then the data.

Your program should then receive commands in the format: "swap row1 col1 row2c col2" where row1, row2, col1, col2 are coordinates in the matrix. For a command to be valid, it should start with the "swap" keyword along with four valid coordinates (no more, no less). You should swap the values at the given coordinates (cell [row1, col1] with cell [row2, col2]) and print the matrix at each step (this you'll be able to check if the operation was performed correctly).

If the command is not valid (doesn't contain the keyword "swap", has fewer or more coordinates entered, or the given coordinates do not exist), print "Invalid input!" and move on to the next command. Your program should finish when the string "END" is entered.



## Task 6. String Matrix Rotation

You are given a sequence of text lines. Assume these text lines form a matrix of characters (pad the missing positions with spaces to build a rectangular matrix). Write a program to rotate the matrix by 90, 180, 270, 360,… degrees. Print the result as a sequence of strings at the console after receiving the "END" command.



## Task 7. Crossfire

You will receive two integers, which represent the dimensions of a matrix. Then, you must fill the matrix with increasing integers starting from 1, and continuing on every row, like this: first row: 1, 2, 3, …, n second row: n + 1, n + 2, n + 3, …, n + n third row: 2 * n + 1, 2 * n + 2, …, 2 * n + n

You will also receive several commands in the form of 3 integers separated by a space. Those 3 integers will represent a row in the matrix, a column, and a radius. You must then destroy the cells, which correspond to those arguments cross-like.

Destroying a cell means that that cell becomes completely nonexistent in the matrix. Destroying cells cross-like means that you form a cross figure with a center point - equal to the cell with coordinates – the given row and column, and lines with length equal to the given radius. See the examples for more info.

The input ends when you receive the command "Nuke it from orbit". When that happens, you must print what has remained from the initial matrix.



## Task 8. The Heigan Dance

At last, level 80. And what do level eighties do? Go raiding. This is where you are now – trying not to be wiped by the famous dance boss, Heigan the Unclean. The fight is pretty straightforward - dance around the Plague Clouds and Eruptions, and you'll be just fine.

Heigan's chamber is a 15-by-15 two-dimensional array. The player always starts at the exact center. For each turn, Heigan uses a spell that hits a certain cell and the neighboring rows/columns. For example, if he hits (1,1), he also hits (0,0, 0,1, 0,2, 1,0 … 2,2). If the player's current position is within the area of damage, the player tries to move. First, he tries to move up. If there's damage/wall, he tries to move right, down, and left. If he cannot move in any direction because the cell is damaged or there is a wall, the player stays in place and takes the damage.

Plague cloud does 3500 damage when it hits, and 3500 damage the next turn. Then it expires. Eruption does 6000 damage when it hits. If a spell hits a player that also has an active Plague Cloud from the previous turn, the cloud damage is applied first. Both Heigan and the player may die in the same turn. If Heigan is dead, the spell he would have cast is ignored.

The player always starts at 18500 hit points; Heigan starts at 3,000,000 hit points. Each turn, the player does damage to Heigan. The fight is over either when the player is killed, or Heigan is defeated.



## Task 9. *Parking System

The parking lot in front of SoftUni is one of the busiest in the country, and it's a common cause of conflicts between the doorkeeper Svetlin and the students. The SoftUni team wants to proactively resolve all conflicts, so an automated parking system should be implemented. They are organizing a competition – Parkoniada – and the author of the best parking system will win a romantic dinner with RoYaL. That's exactly what you've been dreaming of, so you decide to join in.

The parking lot is a rectangular matrix; the first column is always free, and all other cells are parking spots. A car can enter from any cell of the first column and then decides to go to a specific spot. If that spot is not free, the car searches for the closest free spot on the same row. If all the cells on that specific row are used, the car cannot park and leaves. If two free cells are located at the same distance from the initial parking spot, the cell which is closer to the entrance is preferred. A car can pass through a used parking spot.

Your task is to calculate the distance traveled by each car to its parking spot.




## Task 10. *Radioactive Mutant Vampire Bunnies

Browsing through GitHub, you come across an old JS Basics teamwork game. It is about very nasty bunnies that multiply extremely fast. There's also a player that has to escape from their lair. The last thing that is left is the algorithm that decides if the player will escape the lair or not. You like the game, so you decide to port it to Java because that's your language of choice.

First, you will receive a line holding integers N and M, representing the rows and columns in the lair. Then you receive N strings that can only consist of ".", "B", "P". The bunnies are marked with "B", the player is marked with "P", and everything else is free space, marked with a dot ".". They represent the initial state of the lair. There will be only one player. Then you will receive a string with commands such as LLRRUUDD – where each letter represents the player's next move (Left, Right, Up, Down).

After each step of the player, each of the bunnies spread to the up, down, left, and right (neighboring cells marked as "." changes their value to B). If the player moves to a bunny cell or a bunny reaches the player, the player has died. If the player goes out of the lair without encountering a bunny, the player has won.

When the player dies or wins, the game ends. All the activities for this turn continue (e.g., all the bunnies spread normally), but there are no more turns. There will be no stalemates where the moves of the player end before he dies or escapes.

Finally, print the final state of the lair with every row on a separate line. On the last line, print either "dead: {row} {col}" or "won: {row} {col}". Row and col are the coordinates of the cell where the player has died or the last cell he has been in before escaping the lair.



## Task 11. Reverse Matrix Diagonals

You are given a matrix (2D array) of integers. You have to print the matrix diagonal but in reversed order. Print each diagonal on a new line.



## Task 12.*** the Matrix

You are given a matrix (2D array) of lowercase alphanumeric characters (a-z, 0-9), a starting position – defined by a start row startRow and a start column startCol – and a filling symbol fillChar. Let's call the symbol originally at startRow and startCol the startChar. Write a program, which, starting from the symbol at startRow and startCol, changes to fillChar every symbol in the matrix which:
- is equal to startChar AND
- can be reached from startChar by going up (row – 1), down (row + 1), left (col – 1) and right (col + 1) and “stepping” ONLY on symbols equal startChar

So, you basically start from startRow and startCol and can move either by changing the row OR column (not both at once, i.e. you can't go diagonally) by 1 and can only go to positions that have the startChar written on them. Once you find all those positions, you change them to fillChar.

In other words, you need to implement something like the Fill tool in MS Paint, but for a 2D char array instead of a bitmap.