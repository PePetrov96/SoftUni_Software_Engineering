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