## Task 1. Reverse Numbers with a Stack
Write a program that reads N integers from the console and reverses them using a stack. Use the ArrayDeque<Integer> class. Just put the input numbers in the stack and pop them.



## Task 2. Basic Stack Operations
You will be given an integer N representing the number of elements to push into the stack, an integer S representing the number of elements to pop from the stack, and an integer X, an element that you should check whether is present in the stack. If it is, print "true" on the console. If it's not, print the smallest element currently present in the stack.



## Task 3. Maximum Element
You have an empty sequence, and you will be given N commands. Each command is one of the following types:
•	"1 X" - Push the element X into the stack.
•	"2" - Delete the element present at the top of the stack.
•	"3" - Print the maximum element in the stack.



## Task 4. Basic Queue Operations
You will be given an integer N representing the number of elements to enqueue (add), an integer S representing the number of elements to dequeue (remove/poll) from the queue, and finally, an integer X, an element that you should check whether is present in the queue. If it is - prints true on the console, if it is not - print the smallest element currently present in the queue.



## Task 5. Balanced Parentheses
Given a sequence consisting of parentheses, determine whether the expression is balanced. A sequence of parentheses is balanced if every open parenthesis can be paired uniquely with a closing parenthesis that occurs after the former. Also, the interval between them must be balanced.
You will be given three types of parentheses: (, {, and [.
{[()]} - This is a balanced parenthesis.
{[(])} - This is not a balanced parenthesis.



## Task 6. Recursive Fibonacci
Each member of the Fibonacci sequence is calculated from the sum of the two previous members. The first two elements are 1, 1. Therefore, the sequence goes like 1, 1, 2, 3, 5, 8, 13, 21, 34… 
The following sequence can be generated with an array, but that's easy, so your task is to implement it recursively.
If the function getFibonacci(n) returns the nth Fibonacci number, we can express it using getFibonacci(n) = getFibonacci(n-1) + getFibonacci(n-2).
However, this will never end, and a Stack Overflow Exception is thrown in a few seconds. For the recursion to stop, it has to have a "bottom". The bottom of the recursion is getFibonacci(1), and should return 1. The same goes for getFibonacci(0).



## Task 7. *Simple Text Editor
You are given an empty text. Your task is to implement 4 types of commands related to manipulating the text:
•	"1 {string}" - appends [string] to the end of the text.
•	"2 {count}" - erases the last [count] elements from the text.
•	"3 {index}" - returns the element at position [index] from the text.
•	"4" - undoes the last not-undone command of type 1 or 2 and returns the text to the state before that operation.



## Task 8. *Infix to Postfix
Mathematical expressions are written in an infix notations, for example "5 / ( 3 + 2 )". However, this kind of notation is not efficient for computer processing, as you first need to evaluate the expression inside the brackets, so there is a lot of back and forth movement. A more suitable approach is to convert it into the so-called postfix notations (also called Reverse Polish Notation), in which the expression is evaluated from left to right, for example, "3 2 + 5 /".
Implement an algorithm that converts the mathematical expression from infix notation into a postfix notation. Use the famous Shunting-yard algorithm.



## Task 9. **Poisonous Plants
You are given N plants in a garden. Each of these plants has been added with some amount of pesticide. You are given the pesticide's initial values and each plant's position. After each day, if any plant has more pesticide than the plant at its left, being weaker (more GMO) than the left one, it dies. Print the number of days after which no plant dies, i.e. the time after which there are no plants with more pesticide content than the plant to their left.



## Task 10. **Robotics 
Somewhere in the future, there will be a robotics factory. The current project is assembly-line robots.
Each robot has a processing time, the time it needs to process a product. When a robot is free, it should take a product for processing and log its name, product, and processing start time.
Each robot processes a product coming from the assembly line. A product comes from the line each second (so the first product should appear at [start time + 1 second]). If a product passes the line and there is no free robot to take it, it should be queued at the end of the line again.
The robots are standing in the line in the order of their appearance.
