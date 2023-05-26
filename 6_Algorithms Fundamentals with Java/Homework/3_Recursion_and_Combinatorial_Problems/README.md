## Task 1. Reverse Array
Write a program that reverses and prints an array. Use recursion.



## Task 2. Nested Loops To Recursion

Write a program that simulates the execution of n nested loops from 1 to n which prints the values of all its iteration variables at any given time on a single line. Use recursion.



## Task 3. Combinations with Repetition

Write a recursive program for generating and printing all combinations with duplicates of k elements from a set of n elements (k <= n). In combinations, the order of elements doesn’t matter, therefore (1 2) and (2 1) are the same combination, meaning that once you print/obtain (1 2), (2 1) is no longer valid.



## Task 4. Tower of Hanoi Your task is to solve the famous Tower of Hanoi puzzle using recursion.

In this problem, you have three rods (let’s call them source, destination, and spare). Initially, there are n disks, all placed on the source rod like in the picture below:

Your objective is to move all disks from the source rod to the destination rod. There are several rules:

1) Only one disk can be moved at a time

2) Only the topmost disk on a rod can be moved

3) A disk can only be placed on top of a larger disk or on an empty rod

Step 1. Choose Appropriate Data Structures

First, we need to decide how to model the problem in our program. The size of a disk can be represented by an integer number – the larger the number, the larger the disk.

How about the rods? According to the rules outlined above, we can either take a disk from the top of the rod or place a disk on top of it. This is an example of Last-In-First-Out (LIFO), therefore, an appropriate structure to represent a rod would be Stack we need three of them to be precise – the source, the destination, and the spare.

Step 2. Setup

Now that we have an idea of what structures we’ll be using, it’s time for the initial setup. Before solving the puzzle for any number of disks, let’s solve it with 3 and use hardcoded values. With 3 disks, it will be easier to keep track of the steps we’ll take.

Initially, the destination and spare are empty. In the source, we need to have the numbers 1, 2, and 3, 1 being on top.

Step 3. Breaking down the Problem

The Tower of Hanoi is solved by breaking it down into sub-problems. What we’ll try to do is:

1) Move all disks from source to destination starting with the largest (bottom disk)

a) If the bottom disk is equal to 1, we can simply move it

b) If the bottom disk is larger than 1

I. move all disks above it (starting from bottom – 1) to the spare rod

II. move the bottom disk to the destination

III. finally, move the disks now on spare to destination (back on top of the bottom disk)

In essence, steps 1.b.i and 1.b.iii repeat step 1, the only difference is that we’re viewing different rods as a source, destination, and spare.

Step 4. Solution

Looking at step 3 above, it’s apparent that we’ll need a method that takes 4 arguments: the value of the bottom disk and the three rods (stacks).

Step 5. Check Solution with Hardcoded Value

In order to check this solution, let’s make the three stacks static and declare an additional variable that will keep track of the current number of steps taken.

We’ll need a method that prints the contents of all stacks, so we know which disk is where after each step:

After running the program, you should now see each step of the process like this:

The Tower of Hanoi puzzle always takes exactly 2n – 1 steps. With n == 3, all seven steps should be shown and in the end all disks should end up on the destination rod.

Using the output of your program and the debugger, follow each step and try to understand how this recursive algorithm works. It’s much easier to see this with three disks.

Step 6. Remove Hardcoded Values and Retest

If everything went well and you’re confident you’ve understood the process, you can replace 3 with input from the user, just read a number from the console.

Test with several different values, and make sure that the steps taken are 2n – 1 and that all disks are successfully moved from source to destination.




## Task 5. Combinations without Repetition

Modify the solution from the problem 3 program to skip duplicates, e.g. (1 1) is not valid.



## Task 6. Connected Areas in a Matrix

Let’s define a connected area in a matrix as an area of cells in which there is a path between every two cells.

Write a program to find all connected areas in a matrix.

On the console, print the total number of areas found, and on a separate line some info about each of the areas – its position (top-left corner) and size.

Order the areas by size (in descending order) so that the largest area is printed first. If several areas have the same size, order them by their position, first by the row, then by the column of the top-left corner. So, if there are two connected areas with the same size, the one which is above and/or to the left of the other will be printed first.

On the first line, you will get the number of rows.

On the second line, you will get the number of columns.

The rest of the input will be the actual matrix.



## Task 7. Cinema

Write a program that prints all of the possible distributions of a group of friends in a cinema hall. In the first line, you will be given all of the friends‘ names separated by a comma and space. Until you receive the command "generate" you will be given some of those friends‘s names and a number of the place that they want to have. (format: "{name} - {place}") So here comes the tricky part. Those friends want only to sit in the place that they have chosen. They cannot sit in other places. For more clarification see the examples below.

Output

Print all the possible ways to distribute the friends having in mind that some of them want a particular place and they will sit there only. The order of the output does not matter.

Constrains

· The friend‘s names and the number of the place will always be valid



## Task 8. Word Cruncher

Write a program that receives some strings and forms another string that is required. In the first line, you will be given all of the strings separated by a comma and space. On the next line, you will be given the string that needs to be formed from the given strings. For more clarification see the examples below.

Input

· On the first line you will receive the strings (separated by comma and space ", ")

· On the next line you will receive the target string

Output

· Print each of them found ways to form the required string as shown in the examples

Constrains

· There might be repeating elements in the input



## Task 9. School Teams

Write a program that receives the names of girls and boys in a class and generates all possible ways to create teams with 3 girls and 2 boys. Print each team on a separate line separated by a comma and space ", " (first the girls then the boys). For more clarification see the examples below

Note: "Linda, Amy, Katty, John, Bill" is the same as "Linda, Amy, Katty, Bill, John"; so print only the first case

Input

· On the first line you will receive the girl‘s names separated by a comma and space ", ".

· On the second line you will receive the boy‘s names separated by a comma and space ", ".