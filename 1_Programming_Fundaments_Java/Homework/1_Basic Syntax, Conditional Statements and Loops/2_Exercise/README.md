## Task 1. Ages

Write a program that determines whether based on the given age a person is: baby, child, teenager, adult, elder. The bounders are:

- **0-2 – baby;**
- **3-13 – child;**
- **14-19 – teenager;**
- **20-65 – adult;**
- **>=66 – elder;**
- All the values are **inclusive**



## Task 2. Division

You will be given an integer and you have to print on the console whether that number is divisible by the following numbers: 2, 3, 6, 7, 10. You should always take the bigger division. If the number is divisible by both **2** and **3** it is also divisible by **6** and you should print only the division by **6**. If a number is divisible by **2** it is sometimes also divisible by **10** and you should print the division by **10**. If the number is not divisible by any of the given numbers print **"Not divisible"**. Otherwise, print **"The number is divisible by {number}"**.



## Task 3. Vacation

You are given a group of people, type of the group, on which day of the week they are going to stay. Based on that information calculate how much they have to pay and print that price on the console. Use the table below. In each cell is the price for a **single person**. The output should look like that: **"Total price: {price}"**. The price should be formatted to the second decimal point.


<table style="border-collapse:collapse;border-spacing:0" class="tg"><thead><tr><th style="border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;font-weight:bold;overflow:hidden;padding:10px 5px;text-align:center;vertical-align:middle;word-break:normal"> </th><th style="border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;font-weight:bold;overflow:hidden;padding:10px 5px;text-align:center;vertical-align:middle;word-break:normal">Friday</th><th style="border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;font-weight:bold;overflow:hidden;padding:10px 5px;text-align:center;vertical-align:middle;word-break:normal">Saturday</th><th style="border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;font-weight:bold;overflow:hidden;padding:10px 5px;text-align:center;vertical-align:middle;word-break:normal">Sunday</th></tr></thead><tbody><tr><td style="border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;font-weight:bold;overflow:hidden;padding:10px 5px;text-align:center;vertical-align:middle;word-break:normal">Students</td><td style="border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:10px 5px;text-align:center;vertical-align:middle;word-break:normal">8.45</td><td style="border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:10px 5px;text-align:center;vertical-align:middle;word-break:normal">9.8</td><td style="border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:10px 5px;text-align:center;vertical-align:middle;word-break:normal">10.46</td></tr><tr><td style="border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;font-weight:bold;overflow:hidden;padding:10px 5px;text-align:center;vertical-align:middle;word-break:normal">Business</td><td style="border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:10px 5px;text-align:center;vertical-align:middle;word-break:normal">10.9</td><td style="border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:10px 5px;text-align:center;vertical-align:middle;word-break:normal">15.6</td><td style="border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:10px 5px;text-align:center;vertical-align:middle;word-break:normal">16</td></tr><tr><td style="border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;font-weight:bold;overflow:hidden;padding:10px 5px;text-align:center;vertical-align:middle;word-break:normal">Regular</td><td style="border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:10px 5px;text-align:center;vertical-align:middle;word-break:normal">15</td><td style="border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:10px 5px;text-align:center;vertical-align:middle;word-break:normal">20</td><td style="border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:10px 5px;text-align:center;vertical-align:middle;word-break:normal">22.5</td></tr></tbody></table>


There are also discounts based on some conditions:

- **Students** – if the group is bigger than or equal to 30 people you should reduce the **total** price by 15%
- **Business** – if the group is bigger than or equal to 100 people **10** of them can stay for **free**.
- **Regular** – if the group is bigger than or equal to 10 and less than or equal to 20 reduce the **total** price by 5%

**You should reduce the prices in that EXACT order.**



## Task 4. Print and Sum

Write a program to display numbers from given start to given end and their sum. All the numbers will be integers. On the first line, you will receive the start number, on the second the end number.



## Task 5. Login

You will be given a string representing a username. The password will be that username reversed. Until you receive the correct password print on the console **"Incorrect password. Try again."**. When you receive the correct password print **"User {username} logged in."** However on the fourth try if the password is still not correct print **"User {username} blocked!"** and end the program.



## Task 6. Strong Number

Write a program to check if a given number is a strong number or not. A number is strong if the sum of the Factorial of each digit is equal to the number. For example 145 is a strong number, because **1! + 4! + 5! = 145**. Print **"yes"** if the number is strong and **"no"** if the number is not strong.



## Task 7. Vending Machine

Your task is to calculate the total price of a purchase from a vending machine. Until you receive **"Start"** you will be given different coins that are being inserted into the machine. You have to sum them to have the total money inserted. There is a problem though. Your vending machine only works with **0.1, 0.2, 0.5, 1, and 2** coins. If someone tries to insert some other coins you have to display **"Cannot accept {money}"**, where the value is **formatted to the second digit after the decimal point** and not added to the total money. On the next few lines until you receive "End" you will be given products to purchase. Your machine has however only **"Nuts", "Water", "Crisps", "Soda", "Coke"**. The prices are: **2.0, 0.7, 1.5, 0.8, 1.0** respectively. If the person tries to purchase a not existing product print **“Invalid product”**. Be careful that the person may try to purchase a product for which he doesn't have money. In that case, print **"Sorry, not enough money"**. If the person purchases a product successfully print. **"Purchased {product name}"**. After the **"End"** command print the money that is left formatted to the second decimal point in the format **"Change: {money left}"**.



## Task 8. Triangle of Numbers

Write a program, which receives a number – **n**, and prints a triangle from **1 to n** as in the examples.



## Task 9. Orders

We are placing **N** orders at a time. You need to calculate the price on the following formula:
**((daysInMonth * capsulesCount) * pricePerCapsule)**



## Task 10. Padawan Equipment

Yoda is starting his newly created Jedi academy. So, he asked Master George Lucas to **buy** the **needed equipment**. The number of **items** depends on **how many students will sign up**. The equipment for the Padawan contains **lightsabers, belts, and robes**. 
You will be given the **amount of money George Lucas has**, the **number of students**, and the **prices of each item**. You have to help George Lucas **calculate** if the **money** he has is **enough to buy all of the equipment**, or how much more money he needs. Because the lightsabers sometimes break, George Lucas should **buy 10% more, rounded up** to the next integer. Also, every **sixth belt is free**.



## Task 11. Rage Expenses

As a MOBA challenger player, Peter has the bad habit to trash his PC when he loses a game and rage quits. His gaming setup consists of a **headset, mouse, keyboard, and display**. You will receive Peter`s lost games count.

Every **second** lost game, Peter trashes his **headset**.

Every **third** lost game, Peter trashes his **mouse**.

When Peter trashes **both his mouse and headset** in the same lost game, he also trashes his **keyboard**.

Every **second** time, when he trashes his **keyboard**, he also trashes his **display**.

You will receive the price of each item in his gaming setup. Calculate his rage expenses for renewing his gaming equipment.