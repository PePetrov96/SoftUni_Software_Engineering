## Task 1. Rhombus of Stars

Create a program that reads a positive integer n as input and prints on the console a rhombus with size n



## Task 2. Point in Rectangle

Create a class Point and a class Rectangle. The Point should hold coordinates X and Y and the Rectangle should hold 2 Points – its bottom left and top right corners. In the Rectangle class, you should implement a contains(Point point) method that returns true or false, based on whether the Point given as an attribute is inside or outside of the Rectangle object. Points on the side of a Square are considered inside.



## Task 3. Student System

You are given a working project for a small Student System, but the code is very poorly organized. Break up the code logically into smaller functional units – methods and classes and don’t break the functionality.

The program supports the following commands:
- "Create {studentName} {studentAge} {studentGrade}" – creates a new student and adds them to the repository.
- "Show {studentName}" – prints on the console information about a student in the format: "{studentName} is {studentAge} years old. {commentary}.", where the commentary is based on the student’s grade.
- "Exit" – closes the program.

Do not add any extra validation or functionality to the app!



## Task 4. Hotel Reservation

Create a class PriceCalculator that calculates the total price of a holiday, given the price per day, number of days, the season, and a discount type. The discount type and season should be an enum.

Use the class in your main() method to read input and print on the console the price of the whole holiday.

The price per day will be multiplied depending on the season by:
- 1 during Autumn
- 2 during Spring
- 3 during Winter
- 4 during Summer

The discount is applied to the total price and is one of the following:
- 20% for VIP clients - VIP
- 10% for clients, visiting for a second time - SecondVisit
- 0% if there is no discount - None