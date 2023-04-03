## Task 1. Recursive Array Sum

Write a program that finds the sum of all elements in an integer array. Use recursion.

Note: In practice, this recursion should not be used here (instead use an iterative solution), this is just an exercise.


Hints

Write a recursive method. It will take as arguments the input array and the current index.

- The method should return the current element + the sum of all next elements (obtained by recursively calling it).
- The recursion should stop when there are no more elements in the array.



## Task 2. Recursive Drawing

Write a program that draws the figure below depending on n. Use recursion.

Hints:
- Set the bottom of the recursion
- Define pre- and post- recursive behavior



## Task 3. Generating 0/1 Vectors

Generate all n-bit vectors of zeroes and ones in lexicographic order.

Hints:
- The method should receive as parameters the array which will be our vector and a current index
- Bottom of recursion should be when the index is outside of the vector
- To generate all combinations, create a for loop with a recursive call



## Task 4. Recursive Factorial

Write a program that finds the factorial of a given number. Use recursion.

Note: In practice, this recursion should not be used here (instead use an iterative solution), this is just an exercise.

Hints:

Write a recursive method. It will take as arguments an integer number.
- The method should return the current element * the result of calculating the factorial of current element - 1 (obtained by recursively calling it).
- The recursion should stop when the last element is reached



## Task 5. Find All Paths in a Labyrinth

You are given a labyrinth. Your goal is to find all paths from the start (cell 0, 0) to the exit, marked with 'e'.
- Empty cells are marked with a dash '-'
- Walls are marked with a star '*'

On the first line, you will receive the dimensions of the labyrinth. Next, you will receive the actual labyrinth.

The order of the paths does not matter.

Hints
- Create methods for reading and finding all paths in the labyrinth.
- Create a static list that will hold every direction (basically the path)
- Finding all paths should be recursive
- Implement all helper methods that are present in the code above.



## Task 6. Queens Puzzle

In this lab, we will implement a recursive algorithm to solve the "8 Queens" puzzle. Our goal is to write a program to find all possible placements of 8 chess queens on a chessboard so that no two queens can attack each other (on a row, colum,n or diagonal).

#### 1. Learn about the "8 Queens" Puzzle
Learn about the "8 Queens" puzzle, e.g. from Wikipedia: http://en.wikipedia.org/wiki/Eight_queens_puzzle.


#### 2. Define a Data Structure to Hold the Chessboard

First, let’s define a data structure to hold the chessboard. It should consist of 8 x 8 cells, each either occupied by a queen or empty. Let’s also define the size of the chessboard as a constant:


#### 3. Define a Data Structure to Hold the Attacked Positions

We need to hold the attacked positions in some data structure. At any moment during the execution of the program, we need to know whether a certain position {row, col} is under attack by a queen or not.

There are many ways to store the attacked positions:
- By keeping all currently placed queens and checking whether the new position conflicts with some of them.
- By keeping an int[][] matrix of all attacked positions and checking the new position directly in it. This will be complex to maintain because the matrix should change many positions after each queen placement/removal.
- By keeping sets of all attacked rows, columns and diagonals. Let’s try this idea:

The above definitions have the following assumptions:
- The Rows are 8, numbered from 0 to 7.
- The Columns are 8, numbered from 0 to 7.
- The left diagonals are 15, numbered from -7 to 7. We can use the following formula to calculate the left diagonal number by row and column: leftDiag = col - row.
- The right diagonals are 15, numbered from 0 to 14 by the formula: rightDiag = col + row.

Let’s take as an example the following chessboard with 8 queens placed on it at the following positions:
- {0, 0}; {1, 6}; {2, 4}; {3, 7}; {4, 1}; {5, 3}; {6, 5}; {7, 2}

Following the definitions above for our example, the queen {4, 1} occupies row 4, column 1, left diagonal -3 and, right diagonal 5.


#### 4. Write the Backtracking Algorithm

Now, it is time to write the recursive backtracking algorithm for placing the 8 queens.

The algorithm starts from row 0 and tries to place a queen at some column at row 0. On success, it tries to place the next queen at row 1, then the next queen at row 2, etc. until the last row is passed.


#### 5. Check if a Position is Free

Now, let’s write the code to check whether a certain position is free. A position is free when it is not under attack by any other queen. This means that if some of the rows, columns, or diagonals are already occupied by another queen, the position is occupied. Otherwise, it is free.

Recall that col-row is the number of the left diagonal and row+col is the number of the right diagonal.


#### 6. Mark / Unmark Attacked Positions

After a queen is placed, we need to mark as occupied all rows, columns, and diagonals that it can attack.

On removal of a queen, we will need a method to mark as free all rows, columns, and diagonals that were attacked by it.


#### 7. Print Solutions

When a solution is found, it should be printed on the console. First, introduce a solutions counter to simplify checking whether the found solutions are correct.

Next, pass through all rows and through all columns at each row and print the chessboard cells:


#### 8. Testing the Code

The "8 queens" puzzle has 92 distinct solutions. Check whether your code generates and prints all of them correctly. The solutionsFound counter will help you check the number of solutions. Below are the 92 distinct solutions:

Submit your code in judge, printing all 92 solutions, separated by a single line.


#### 9. Optimize the Solution

Now we can optimize our code:
- Remove the attackedRows set. It is not needed because all queens are placed consecutively at rows 0…7.
- Try to use boolean[] array for attackedColumns, attackedLeftDiagonals and attackedRightDiagonals instead of sets. Note that arrays are indexed from 0 to their size and cannot hold negative indexes.


#### * Permutation Based Solution

Try to implement the more-efficient permutation-based solution of the "8 Queens" puzzle. Look at this code to grasp the idea: http://introcs.cs.princeton.edu/java/23recursion/Queens.java.html.



## Task 7. Recursive Fibonacci

Each member of the Fibonacci sequence is calculated from the sum of the two previous members. The first two elements are 1, 1. Therefore the sequence goes as 1, 1, 2, 3, 5, 8, 13, 21, 34…

The following sequence can be generated with an array, but that’s easy, so your task is to implement it recursively.

If the function getFibonacci(n) returns the nth Fibonacci number, we can express it using getFibonacci(n) = getFibonacci(n-1) + getFibonacci(n-2).

However, this will never end and in a few seconds, a Stack Overflow Exception is thrown. In order for the recursion to stop it has to have a "bottom". The bottom of the recursion is getFibonacci(1), and should return 1. The same goes for getFibonacci(0).

Input
- On the only line in the input the user should enter the wanted Fibonacci number N where 1 ≤ N ≤ 49

Output
- The output should be the nth Fibonacci number counting from 0

Hint

For the nth Fibonacci number, we calculate the N-1st and the N-2nd number, but for the calculation of N-1st number we calculate the N-1-1st(N-2nd) and the N-1-2nd number, so we have a lot of repeated calculations.