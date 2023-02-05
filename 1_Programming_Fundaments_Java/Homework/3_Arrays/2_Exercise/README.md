## Task 1. Train

You will be given a count of wagons in a train n. On the next n lines, you will receive how many people are going to get on that wagon. At the end print the whole train and after that the sum of the people on the train.



## Task 2. Common Elements

Write a program, which prints common elements in two arrays. You have to compare the elements of the second array to the elements of the first.



## Task 3. Zig-Zag Arrays

Write a program that creates 2 arrays. You will be given an integer n. On the next n lines, you get 2 integers. Form 2 arrays as shown below.



## Task 4. Array Rotation

Write a program that receives an array and the number of rotations you have to perform (the first element goes at the end) Print the resulting array



## Task 5. Top Integers

Write a program to find all the top integers in an array. A top integer is an integer that is bigger than all the elements to its right.



## Task 6. Equal Sums

Write a program that determines if there exists an element in the array such that the sum of the elements on its left is equal to the sum of the elements on its right. If there are no elements to the left/right, their sum is considered to be 0. Print the index that satisfies the required condition or "no" if there is no such index.



## Task 7. Max Sequence of Equal Elements

Write a program that finds the longest sequence of equal elements in an array of integers. If several longest sequences exist, print the leftmost one.



## Task 8. Magic Sum

Write a program, which prints all unique pairs in an array of integers whose sum is equal to a given number.



## Task 9. Array Modifier

You are given an array with integers. Write a program to modify the elements after receiving the following commands:

- **"swap {index1} {index2}"** takes two elements and swap their places.
- **"multiply {index1} {index2}"** takes element at the 1st index and multiply it with the element at 2nd index. Save the product at the 1st index.
- **"decrease"** decreases all elements in the array with 1.



## Task 10. Treasure Hunt

The pirates need to carry a treasure chest safely back to the ship, looting along the way.

Create a program that manages the state of the treasure chest along the way. On the first line, you will receive the initial loot of the treasure chest, which is a string of items separated by a "|".

"{loot1}|{loot2}|{loot3} … {lootn}"

The following lines represent commands until "Yohoho!" which ends the treasure hunt:

- "Loot {item1} {item2}…{itemn}":

o Pick up treasure loot along the way. Insert the items at the beginning of the chest.

o If an item is already contained, don't insert it.
- "Drop {index}":

o Remove the loot at the given position and add it at the end of the treasure chest.

o If the index is invalid, skip the command.
- "Steal {count}":

o Someone steals the last count loot items. If there are fewer items than the given count, remove as much as there are.

o Print the stolen items separated by ", ":

"{item1}, {item2}, {item3} … {itemn}"
