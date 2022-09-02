## Task 1. Encrypt, Sort and Print Array

Write a program that reads a **sequence of strings** from the console. Encrypt every string by summing:

- The code of **each vowel multiplied** by the string length
- The code of **each consonant divided** by the string length

**Sort** the **number** sequence in ascending order and print it on the console.

On the first line, you will always receive the number of strings you have to read.



## Task 2. Pascal Triangle

The triangle may be constructed in the following manner: In row 0 (the topmost row), there is a unique nonzero entry 1. Each entry of each subsequent row is constructed by adding the number above and to the left with the number above and to the right, treating blank entries as 0. For example, the initial number in the first (or any other) row is 1 (the sum of 0 and 1), whereas the numbers 1 and 3 in the third row are added to produce the number 4 in the fourth row. If you want more info about it: https://en.wikipedia.org/wiki/Pascal's_triangle

Print each row element separated with whitespace.



## Task 3. Recursive Fibonacci

The Fibonacci sequence is quite a famous sequence of numbers. Each member of the sequence is calculated from the sum of the two previous elements. The first two elements are 1, 1. Therefore the sequence goes like 1, 1, 2, 3, 5, 8, 13, 21, 34… 

Write a code to generate this triangle, on **n** number of rows.


## Task 4. Longest Increasing Subsequence (LIS)

Read a **list of integers** and find the **longest increasing subsequence** (LIS). If several such exist, print the **leftmost**.



## Task 5. Kamino Factory

The clone factory in Kamino got another order to clone troops. But this time you are tasked to find the best DNA sequence to use in the production.

You will receive the DNA length and until you receive the command **"Clone them!"** you will be receiving DNA sequences of ones and zeroes, split by **"!"** **(one or several)**.

You should select the sequence with the longest subsequence of ones. If there are several sequences with the same length of a subsequence of ones, print the one with the leftmost starting index, if there are several sequences with the same length and starting index, select the sequence with the greater sum of its elements.

After you receive the last command **"Clone them!"** you should print the collected information in the following format:

**"Best DNA sample {bestSequenceIndex} with sum: {bestSequenceSum}."**

**"{DNA sequence, joined by space}"**



## Task 6. LadyBugs

You are given a field size and the indexes of ladybugs inside the field. After that on every new line, until the "end" command is given, a ladybug changes its position either to its left or to its right by a given fly length.

A command to a ladybug looks like this: "0 right 1". This means that the little insect placed on index 0 should fly one index to its right. If the ladybug lands on a fellow ladybug, it continues to fly in the same direction by the same fly length. If the ladybug flies out of the field, it is gone.

For example, imagine you are given a field with size 3 and ladybugs on indexes 0 and 1. If the ladybug on index 0 needs to fly to its right by the length of 1 (0 right 1) it will attempt to land on index 1 but as there is another ladybug there it

will continue further to the right by an additional length of 1, landing on index 2. After that, if the same ladybug needs to fly to its right by the length of 1 (2 right 1), it will land somewhere outside of the field, so it flies away.

If you are given a ladybug index that does not have a ladybug there, nothing happens. If you are given a ladybug index that is outside the field, nothing happens.

Your job is to create the program, simulating the ladybugs flying around doing nothing. In the end, print all cells in the field separated by blank spaces. For each cell that has a ladybug on it print '1' and for each empty cell print '0'. For the example above, the output should be '0 1 0'.
