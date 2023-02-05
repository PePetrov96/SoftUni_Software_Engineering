## Task 1. Convert Meters to Kilometers

You will be given an integer that will be a distance in meters. Write a program that converts meters to kilometers formatted to the second decimal point.



## Task 2. Pounds to Dollars

Write a program that converts British pounds to US dollars formatted to the 3rd decimal point.

1 British Pound = 1.36 Dollars



## Task 3. Exact Sum of Real Numbers

Write a program to enter n numbers and calculate and print their exact sum (without rounding).



## Task 4. Town Info

You will be given 3 lines of input. On the first line you will be given the name of the town, on the second – the population and on the third the area. Use the correct data types and print the result in the following format:

**"Town {town name} has population of {population} and area {area} square km.".**



## Task 5. Concat Names

Read two names and a delimiter. Print the names joined by the delimiter.



## Task 6. Chars to String

Write a program that reads 3 lines of input. On each line, you get a single character. Combine all the characters into one string and print it on the console.



## Task 7. Reversed Chars

Write a program that takes 3 lines of characters and prints them in reversed order with a space between them.



## Task 8. Lower or Upper

Write a program that prints whether a given character is upper-case or lower-case.



## Task 9. Centuries to Minutes

Write a program to enter an integer number of **centuries** and convert it to **years**, **days**, **hours**, and **minutes**.



## Task 10. Special Numbers

A number is special when its **sum of digits is 5, 7, or 11.**

Write a program to read an integer **n** and for all numbers in the range **1…n** to print the number and if it is special or not **(True / False)**.



## Task 11. Refactor Volume of Pyramid

You are given a **working code** that finds the **volume of a pyramid**. However, you should consider that the variables exceed their optimum span and have improper naming. Also, search for variables that have **multiple purposes**.

**CODE**
Scanner scanner = new Scanner(System.in);
double dul, sh, V = 0;
System.out.print("Length: ");
dul = Double.parseDouble(scanner.nextLine());
System.out.print("Width: ");
sh = Double.parseDouble(scanner.nextLine());
System.out.print("Height: ");
V = Double.parseDouble(scanner.nextLine());
V = (dul * sh * V) / 3;
System.out.printf("Pyramid Volume: %.2f", V);



## Task 12. Refactor Special Numbers

You are given a **working code** that is a solution to **roblem 9**. Special Numbers. However, the variables are **improperly named, declared before they are needed** and some of them are used for **multiple things**. Without using your previous solution, **modify the code** so that it is **easy to read and understand**.

**CODE**
Scanner scanner = new Scanner(System.in);
int kolkko = Integer.parseInt(scanner.nextLine());
int obshto = 0;
int takova = 0;
boolean toe = false;
for (int ch = 1; ch <= kolkko; ch++) {
takova = ch;
while (ch > 0) {
obshto += ch % 10; ch = ch / 10; 
} 
toe = (obshto == 5) || (obshto == 7) || (obshto == 11); 
System.out.printf("%d -> %b%n", takova, toe); 
obshto = 0; 
ch = takova; 
}