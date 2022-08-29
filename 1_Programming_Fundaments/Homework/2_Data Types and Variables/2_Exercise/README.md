## Task 1. Integer Operations

Read **four integer numbers**. Add first to the second, divide (integer) the sum by the third number, and multiply the result by the fourth number. Print the result.

**Constraints**
- The four numbers from the input are in the range [-2,147,483,648… 2,147,483,647].



## Task 2. Sum Digits

You will be given a **single integer**. Your task is to find the **sum of its digits**.



## Task 3. Elevator

Calculate how many courses will be needed to **elevate n persons** by using an elevator with a **capacity of p persons**. The input holds two lines: the **number of people n** and the **capacity p** of the elevator.



## Task 4. Sum of Chars

Write a program, which **sums the ASCII** codes of **n** characters. Print the **sum** on the console.



## Task 5. Print Part of the ASCII Table 

Write a program that prints part of the **ASCII table of characters** at the console. On the **first line of input**, you will receive the **char index** you should start with, and on the **second line - the index of the last character** you should print



## Task 6. Triples of Latin Letters

Write a program to read an integer n and print all **triples** of the first **n small Latin letters**, ordered alphabetically:


## Task 7. Water Overflow

You have a **water tank** with a capacity of **255 liters**. On the next **n** lines, you will receive **liters of water**, which you have to **pour** into your **tank**. If the **capacity** is **not enough**, print **"Insufficient capacity!"** and **continue reading** the next line. On the last line, print the **liters** in the **tank**.



## Task 8. Beer Kegs

Write a program, which calculates the volume of **n** beer kegs. You will receive in total **3 * n lines***. Every three lines will hold information for a single keg. First up is the model of the keg, after that is the radius of the keg, and lastly is the height of the keg.

Calculate the volume using the following formula: **π * r^2 * h.**

In the end, print the **model** of the **biggest keg**.



## Task 9. Spice Must Flow

Write a program that calculates the **total amount** of spice that can be extracted from a source. The source has a **starting yield**, which indicates how much spice can be mined on the first day. After it has been mined for a day, the yield drops by 10, meaning on the second day it’ll produce 10 less spice than on the first, on the third day 10 less than on the second, and so on (see examples). A source is considered profitable only while its yield is at least 100 – when **less than 100** spices are expected in a day, abandon the source.

The mining crew **consumes 26 spices** every day at the end of their shift and **an additional 26** after the mine has been exhausted. Note that the workers cannot consume more spice than there is in storage.

When the operation is complete, print on the console on two separate lines how many days the mine has operated and the total amount of spice extracted.



## Task 10. Poke Mon

A Poke Mon is a special type of pokemon which likes to Poke others. But at the end of the day, the Poke Mon wants to keep statistics, about how many pokes it has managed to make.

The Poke Mon pokes his target and then proceeds to poke another target. The distance between his targets reduces his poke power.

You will be given the poke power the Poke Mon has, N – an integer.

Then you will be given the distance between the poke targets, M – an integer.

Then you will be given the exhaustionFactor Y – an integer.

Your task is to start subtracting M from N until N becomes less than M, i.e. the Poke Mon does not have enough power to reach the next target. Every time you subtract M from N that means you’ve reached a target and poked it successfully. COUNT how many targets you’ve poked – you’ll need that count.

The Poke Mon becomes gradually more exhausted. IF N becomes equal to EXACTLY 50 % of its original value, you must divide N by Y, if it is POSSIBLE. This DIVISION is between integers.

If a division is not possible, you should NOT do it. Instead, you should continue subtracting.

After dividing, you should continue subtracting from N, until it becomes less than M.

When N becomes less than M, you must take what has remained of N and the count of targets you’ve poked, and print them as output.

NOTE: When you are calculating percentages, you should be PRECISE at maximum.

Example: 505 is NOT EXACTLY 50 % from 1000, its 50.5 %.



## Task 11. *Snowballs

Tony and Andi love playing in the snow and having snowball fights, but they always argue about which makes the best snowballs. They have decided to involve you in their fray, by making you write a program that calculates snowball data and outputs the best snowball value.

You will receive N – an integer, the number of snowballs being made by Tony and Andi. For each snowball you will receive 3 input lines:

· On the first line, you will get the snowballSnow – an integer.

· On the second line, you will get the snowballTime – an integer.

· On the third line, you will get the snowballQuality – an integer.

For each snowball you must calculate its snowballValue by the following formula:

(snowballSnow / snowballTime) ^ snowballQuality

In the end, you must print the highest calculated snowballValue.