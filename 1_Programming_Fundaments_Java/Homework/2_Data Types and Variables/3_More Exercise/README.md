## Task 1. Data Type Finder

You will receive input until you receive **"END"**. Find what **data type** is the input. Possible data types are:
- Integer
- Floating point
- Characters
- Boolean
- Strings

Print the result in the following format: **"{input} is {data type} type"**.



## Task 2. From Left to the Right

You will receive a number that represents how many lines we will get as input. On the next N lines, you will receive a string with 2 numbers separated by a single space. You need to compare them. If the left number is greater than the right number, you need to print the sum of all digits in the left number, otherwise, print the sum of all digits in the right number.



## Task 3. Floating Equality

Write a program that safely compares floating-point numbers (double) with precision eps = 0.000001. Note that we cannot directly compare two floating-point numbers a and b by a==b because of the nature of the floating-point arithmetic. Therefore, we assume two numbers are equal if they are more close to each other than some fixed constant eps.

You will receive two lines, each containing a floating-point number. Your task is to compare the values of the two numbers.



## Task 4. Refactoring: Prime Checker

You are given a program that checks if numbers in a given range [2...N] are prime. For each number is printed **"{number} -> {true or false}"**. The code, however, is not very well written. Your job is to modify it in a way that is easy to read and understand.

Scanner chetec = new Scanner(System.in);

int ___Do___ = Integer.parseInt(chetec.nextLine());
for (int takoa = 2; takoa <= ___Do___; takoa++) {
boolean takovalie = true;
for (int cepitel = 2; cepitel < takoa; cepitel++) {
if (takoa % cepitel == 0) {
takovalie = false;
break;
}
}
System.out.printf("%d -> %b%n", takoa, takovalie);
}



## Task 5. Decrypting Messages

You will receive a **key (integer)** and **n** characters afterward. Add the key to each of the characters and append them to the **message**. At the end print the message, which you decrypted.



## Task 6. Balanced Brackets

You will receive **n** lines. On **those lines**, you will receive **one** of the following:
- Opening bracket – "**(**"
- Closing bracket – "**)**" or
- **Random string**

Your task is to find out if the **brackets** are **balanced**. That means after every **closing** bracket should follow an opening one. Nested parentheses are not valid, and if two consecutive opening brackets exist, the expression should be marked as unbalanced.

