## Task 1. Sum Adjacent Equal Numbers

Write a program to **sum all adjacent equal numbers** in a list of decimal numbers, starting from **left to right**.
- After two numbers are summed, the obtained result could be equal to some of its neighbors and should be summed as well (see the examples below).
- Always sum the leftmost two equal neighbors (if several couples of equal neighbors are available)



## Task 2. Gauss' Trick

Write a program that sum all numbers in a list in the following order:
first + last, first + 1 + last - 1, first + 2 + last - 2, … first + n, last - n.



## Task 3. Merging Lists

You are going to receive two lists with numbers. Create a result list that contains the numbers from both of the lists. The first element should be from the first list, the second from the second list, and so on. If the length of the two lists is not equal, just add the remaining elements at the end of the list.



## Task 4. List Manipulation Basics

Write a program that reads a list of integers. Then until you receive "end", you will be given different commands:
**Add {number}**: add a number to the end of the list
**Remove {number}**: remove a number from the list
**RemoveAt {index}**: remove a number at a given index
**Insert {number} {index}**: insert a number at a given index
**Note: All the indices will be valid!**
When you receive the **"end"** command print the **final state** of the list **(separated by spaces)**



## Task 5. List Manipulation Advanced

Now we will implement more complicated list commands. Again, read a list, and until you receive **"end"** read commands:
**Contains {number}** – check if the list contains the number. If yes print **"Yes"**, otherwise print **"No such number"**
**Print even** – print all the numbers that are even separated by a space
**Print odd** – print all the numbers that are oddly separated by a space
**Get sum** – print the sum of all the numbers
**Filter {condition} {number}** – print all the numbers that **fulfill that condition**. The condition will be either **'<', '>', ">=", "<="**



## Task 6. List of Products

Read a number n and n lines of products. Print a numbered list of all the products ordered by name.



## Task 7. Remove Negatives and Reverse

Read a **list of integers, remove all negative numbers** from it and print the remaining elements in reversed order. In case of no elements left in the list, print **"empty"**.