## Task 1. Train

On the first line, you will be given a **list of wagons** (integers). Each integer represents the **number of passengers** that are currently **in each wagon**. On the next line, you will get the **max capacity of each wagon** (single integer). Until you receive **"end"** you will be given two types of input:

- **Add {passengers}** - add a wagon to the end with the given number of passengers
- **{passengers}** - find an existing wagon to fit all the passengers (starting from the first wagon)

At the end **print** the final state of the train (all the wagons separated by a space)



## Task 2. Change List

Write a program, which reads a **list of integers** from the console and receives **commands**, which **manipulate** the list. Your program may receive the following commands:

- **Delete {element}** - delete all elements in the array, which are equal to the given element
- **Insert {element} {position}** - insert element at the given position

You should stop the program when you receive the command **"end"**. Print all numbers in the array separated with a single whitespace.



## Task 3. House Party

Write a program that keeps track of the guests that are going to a house party.

On the first input line, you are going to receive how many commands you are going to have. On the next lines you are going to receive some of the following inputs:

- **"{name} is going!"**
- **"{name} is not going!"**

If you receive the first type of input, you have to add the person if he/she is not on the list. (If he/she is in the list print on the console: **"{name} is already in the list!"**). If you receive the second type of input, you have to remove the person if he/she is on the list. (If not print: **"{name} is not in the list!"**). At the end print all guests.



## Task 4. List Operations

You will be given numbers (list of integers) on the first input line. Until you receive **"End"** you will be given operations you have to apply on the list. The possible commands are:
- **Add {number}** - add number at the end
- **Insert {number} {index}** - insert number at given index
- **Remove {index}** - remove that index
- **Shift left {count}** - first number becomes last 'count' times
- **Shift right {count}** - last number becomes first 'count' times

Note: The index given may be outside of the bounds of the array. In that case print **"Invalid index"**.



## Task 5. Bomb Numbers

Write a program that reads a sequence of numbers and a special bomb number with a certain **power**. Your task is to detonate every occurrence of the special bomb number and according to its power - his neighbors from left and right. Detonations are performed from left to right and all detonated numbers disappear. Finally, print the sum of the remaining elements in the sequence.



## Task 6. Cards Game

You will be given two hands of cards, which will be **integer** numbers. Assume that you have two players. You have to find out the winning deck and respectively the winner.

You start from the beginning of both hands. Compare the cards from the first deck to the cards from the second deck. The player, who has a bigger card, takes both cards and puts them at the back of his hand - **the second player's card is last, and the first person's card (the winning one) is before it (second to last)** and the player with the smaller card must remove the card from his deck. If both players' cards have the same values - no one wins, and the two cards must be removed from the decks. The game is over when one of the decks is left without any cards. You have to print the winner on the console and the sum of the left cards: **"{First/Second} player wins! Sum: {sum}"**.



## Task 7. Append Arrays

Write a program to **append several arrays** of numbers.
- Arrays are separated by **"|"**.
- Values are separated by spaces **(" ", one or several)**.
- Order the arrays from the **last** to the **first**, and their values from **left** to **right**.



## Task 8. *Anonymous Threat
You will receive a single input line containing **STRINGS** separated by spaces. The strings may contain any **ASCII** character except **whitespace**.

You will then begin receiving commands in one of the following formats:
- **merge {startIndex} {endIndex}**
- **divide {index} {partitions}**

Every time you receive the merge command, you must merge all elements from the **startIndex** till the **endIndex**. In other words, you should concatenate them. Example: {abc, def, ghi} -> merge 0 1 -> {abcdef, ghi}

If any of the given indexes is out of the array, you must take ONLY the range that is INSIDE the array and merge it.

Every time you receive the divide command, you must DIVIDE the element at the given index into several small substrings with equal length. The count of the substrings should be equal to the given partitions.

Example: {abcdef, ghi, jkl} -> divide 0 3 -> {ab, cd, ef, ghi, jkl}

If the string CANNOT be exactly divided into the given partitions, make all partitions except the LAST with EQUAL LENGTHS, and make the LAST one – the LONGEST.

Example: {abcd, efgh, ijkl} -> divide 0 3 -> {a, b, cd, efgh, ijkl}

The **input ends** when you receive the command **"3:1"**. At that point you must print the **resulting elements, joined by a space**.



## Task 9. *Pokémon Don't Go
You will receive a sequence of integers, separated by spaces - the distances to the Pokémons. Then you will begin receiving integers, which will correspond to indexes in that sequence.

When you receive an index, you must remove the element at that index from the sequence (as if you've captured the Pokémon).
- You must **INCREASE** the value of **all elements** in the sequence which are **LESS or EQUAL than** the removed element, with the value of the removed element.
- You must **DECREASE** the value of **all elements** in the sequence which are **GREATER than** the removed element, with the value of the removed element.

If the given index is LESS than 0, remove the first element of the sequence, and COPY the last element to its place.

If the given index is GREATER than the last index of the sequence, remove the last element from the sequence, and COPY the first element to its place.

The increasing and decreasing of elements should be done in these cases, also. The element, whose value you should use, is the REMOVED element.

The program ends when the sequence has no elements (there are no Pokémons left for Ely to catch).



## Task 10. *SoftUni Course Planning

You are tasked to help plan the next Programming Fundamentals course by keeping track of the lessons, that are going to be included in the course, as well as all the exercises for the lessons.

On the first input line, you will receive the initial schedule of lessons and exercises that are going to be part of the next course, separated by comma and space ", ". But before the course starts, there are some changes to be made. Until you receive "course start" you will be given some commands to modify the course schedule. The possible commands are:

**Add:{lessonTitle}** - add the lesson to the end of the schedule, if it does not exist

**Insert:{lessonTitle}**:{index} -insert the lesson to the given index, if it does not exist

**Remove:{lessonTitle}** -remove the lesson, if it exists

**Swap:{lessonTitle}**:{lessonTitle} -change the place of the two lessons, if they exist

**Exercise:{lessonTitle}** -add Exercise in the schedule right after the lesson index, if the lesson exists and there is no exercise already, in the following format "{lessonTitle}-Exercise". If the lesson doesn't exist, add the lesson at the end of the course schedule, followed by the Exercise.

Each time you Swap or Remove a lesson, you should do the same with the Exercises, if there are any, which follow the lessons.