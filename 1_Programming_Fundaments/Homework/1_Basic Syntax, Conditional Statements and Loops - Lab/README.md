## Task 1. Student Information

You will be given 3 lines of input – student name, age, and average grade. Your task is to print all the info about the student in the following format: "Name: {student name}, Age: {student age}, Grade: {student grade}".


//Examples//

+-------+-------------------------------------+
| Input | Output                              |
+-------+-------------------------------------+
|  John | Name:   John, Age: 15, Grade: 5.40  |
+-------+                                     |
|   15  |                                     |
+-------+                                     |
|  5.4  |                                     |
+-------+-------------------------------------+
| Steve | Name:   Steve, Age: 16, Grade: 2.50 |
+-------+                                     |
|   16  |                                     |
+-------+                                     |
|  2.5  |                                     |
+-------+-------------------------------------+
| Marry | Name:   Marry, Age: 12, Grade: 6.00 |
+-------+                                     |
|   12  |                                     |
+-------+                                     |
|   6   |                                     |
+-------+-------------------------------------+

## Task 2. Passed

Write a program, which takes as an input a grade and prints "Passed!" if the grade is equal or more than 3.00.

**Input**

The input comes as a single floating-point number.

**Output**

The output is either "Passed!" if the grade is equal or more than 3.00, otherwise you should print nothing.


/Examples/

**Input**: 5.32

**Output**: Passed!

**Input**: 2.34

**Output**: (no output)


## Task 3. Passed or Failed

Modify the above program, so it will print "Failed!" if the grade is lower than 3.00.

**Input**

The input comes as a single double number.

**Output**

The output is either "Passed!" if the grade is more than 2.99, otherwise you should print "Failed!"


/Examples/

**Input**: 5.32

**Output**: Passed!

**Input**: 2.36

**Output**: Failed!



## Task 4. Back in 30 Minutes

Every time John tries to pay his bills he sees on the cash desk the sign: "I will be back in 30 minutes". One day John was sick of waiting and decided he needs a program, which prints the time after 30 minutes. That way he won’t have to wait at the desk and come at the appropriate time. He gave the assignment to you, 
so you have to do it.

**Input**

The input will be on two lines. On the first line, you will receive the hours and on the second you will receive the minutes.

**Output**

Print on the console the time after 30 minutes. The result should be in the format "hh:mm". The hours have one or two numbers and the minutes have always two numbers (with leading zero).

**Constraints**

- The hours will be between 0 and 23.
- The minutes will be between 0 and 59.


/Examples/

**Input**: 1; 46

**Output**: 2:16

**Input**: 0; 01

**Output**: 0:31

**Input**: 23; 59

**Output**: 0:29



## Task 5. Month Printer

Write a program, which takes an integer from the console and prints the corresponding month. 
If the number is more than 12 or less than 1 print "Error!".

**Input**

You will receive a single integer on a single line.

**Output**

If the number is within the boundaries print the corresponding month, otherwise print "Error!".


/Examples/

**Input**: 2

**Output**: February

**Input**: 13

**Output**: Error!



## Task 6. Foreign Languages

Write a program, which prints the language, that a given country speaks. You can receive only the following combinations: English is spoken in England and USA; Spanish is spoken in Spain, Argentina, and Mexico; for the others, we should print "unknown".

**Input**

You will receive a single country name on a single line.

**Output**

Print the language, which the country speaks, or if it is unknown for your program, print "unknown".


/Examples/

**Input**: USA

**Output**: English

**Input**: Germany

**Output**: unknown



## Task 7. Theatre Promotions

A theatre is doing a ticket sale, but they need a program to calculate the price of a single ticket. If the given age does not fit one of the categories, you should print "Error!". You can see the prices in the table below:

  Day   || (<= age <= 18) || (18 < age <= 64) || (64 < age <= 122) ||
  
Weekday ||		 12$ 	  ||  		18$		  || 	 	12$		   ||

Weekend ||		 15$ 	  ||  		20$		  || 	 	15$ 	   ||

Holiday ||		 5$ 	  ||  		12$		  || 	 	10$ 	   ||

**Input**

The input comes in two lines. On the first line, you will receive the type of day. On the second – the age of the person.

**Output**

Print the price of the ticket according to the table, or "Error!" if the age is not in the table.

**Constraints**
- The age will be in the interval [-1000…1000].
- The type of day will always be valid.

