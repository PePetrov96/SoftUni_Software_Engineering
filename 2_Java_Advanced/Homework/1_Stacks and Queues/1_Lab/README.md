## Task 1. Browser History

Write a program that takes two types of browser instructions:
•	Normal navigation: a URL is set, given by a string;
•	The string "back" sets the current URL to the last set URL
After each instruction, the program should print the current URL. If the back instruction can't be executed, print 
"no previous URLs". The input ends with the "Home" command, and then you simply have to stop the program.



## Task 2. Simple Calculator

Create a simple calculator that can evaluate simple expressions that will not hold any operator different from addition and subtraction. There will not be parentheses or operator precedence.
Solve the problem using a Stack.



## Task 3. Decimal to Binary Converter
Create a simple program that can convert a decimal number to its binary representation. Implement an elegant solution using a Stack.
Print the binary representation back at the terminal.



## Task 4. Matching Brackets
We are given an arithmetical expression with brackets. Scan through the string and extract each sub-expression.
Print the result back at the terminal.
II.	Working with Queues



## Task 5. Printer Queue
The printer queue is a simple way to control the order of files sent to a printer device. We know that a single printer can be shared between multiple devices. So to preserve the order of the files sent, we can use a queue. 
Write a program which takes filenames until the "print" command is received. Then as output, print the filenames in the order of printing. Some of the tasks may be canceled. If you receive "cancel" you have to remove the first file to be printed. If there is no current file to be printed, print "Printer is on standby".



## Task 6. Hot Potato
Hot potato is a game in which children form a circle and start passing a hot potato. The counting starts with the first kid. Every nth toss, the child left with the potato leaves the game. When a kid leaves the game, it passes the potato forward. This continues repeating until there is only one kid left.
Create a program that simulates the game of Hot Potato. Print every kid that is removed from the circle. In the end, print the kid that is left last.



## Task 7. Math Potato
Rework the previous problem so that a child is removed only on a composite (not prime) cycle (cycles start from 1). 
If a cycle is prime, print the child's name.
As before, print the name of the child that is left last.



## Task 8. Browser History Upgrade
Extend "Browser History" with a "forward" instruction, which visits URLs that were navigated away from by "back".
Each forward instruction visits the next most recent such URL. If normal navigation happens, all potential forward URLs are removed until a new back instruction is given if the forward instruction can't be executed, print 
"no next URLs".