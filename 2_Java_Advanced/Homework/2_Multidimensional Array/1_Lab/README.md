## Task 1. Compare Matrices
Write a program that reads two integer matrices (2D arrays) from the console and compares them element by element. For better code reusability, you could make the comparison in a method that returns true if they are equal and false if not.
Each matrix definition on the console will contain a line with a positive integer number R – the number of rows in the matrix and C – the number of columns – followed by R lines containing the C numbers, separated by spaces (each line will have an equal amount of numbers.
The matrices will have at most 10 rows and at most 10 columns.
Print "equal" if the matrices match and "not equal" if they don't match.



## Task 2. Positions Of
Write a program that reads a matrix of integers from the console, then a number, and prints all the positions at which that number appears in the matrix.
The matrix definition on the console will contain a line with two positive integer numbers R and C – the number of rows and columns in the matrix – followed by R lines, each containing C numbers (separated by spaces), representing each row of the matrix.
The number you will need to find the positions will be entered on a single line after the matrix.
You should print each position on a single line – first print the row, then the column at which the number appears.
If the number does not appear in the matrix, print "not found".



## Task 3. Intersection of Two Matrices
Write a program that reads two char matrices (A[][] and B[][]) of the same order M * N and prints the third matrix C[][], which is filled with the intersecting elements of A and B, otherwise set the element to '*'. On the first two lines, you receive M and N, then on 2 * M lines N characters – the matrices elements.
The matrix elements may be any ASCII char except '*'.



## Task 4. Sum Matrix Elements
Write a program that reads a matrix from the console and prints:
· The count of rows
· The count of columns
· The sum of all matrix's elements
On the first line, you will get the matrix dimensions in the format "{rows, columns}". On the next lines, you will get the elements for each row separated by a comma.



## Task 5. Maximum Sum of 2X2 Submatrix
Write a program that reads a matrix from the console. Then find the biggest sum of a 2x2 submatrix. Print the submatrix and its sum.
On the first line, you will get the matrix dimensions in the format "{rows, columns}". On the next lines, you will get the elements for each row separated by a comma.



## Task 6. Print Diagonals of Square Matrix
Write a program that reads a matrix from the console. Then print the diagonals. The matrix will always be square. On the first line, you read a single integer N the matrix size. Then on each line N elements. The first diagonal should always start with the element at the first row and col. The second diagonal should start with the element at the last row and first col.



## Task 7. ** Find the Real Queen
Write a program that reads (8 x 8) matrix of characters from the console. The matrix represents a chessboard with figures on it. The figures can be - queens as char 'q' or any other ASCII symbol. There will be more than one queen, but only one queen will have a valid position, which is not attacked by any other queen and does not attack any other queen. In another word, in the way of the valid queen, there are no other queens, but there may be any other ASCII symbol. Your task is to read the chessboard and find the position of the valid queen. According to chess rules, the queen can attack all the cells in horizontal verticals and both diagonals, which cross the queen position.



## Task 8. Wrong Measurements
You will be given the rows of a matrix. Then the matrix itself. Inside this matrix, there are mistaken values that need to be replaced. You will receive the wrong value at the last line. Those values should be replaced with the sum of the nearest elements in the four directions, up, down, left, and right, but only if they are valid values. In the end, you have to print the fixed measurements.