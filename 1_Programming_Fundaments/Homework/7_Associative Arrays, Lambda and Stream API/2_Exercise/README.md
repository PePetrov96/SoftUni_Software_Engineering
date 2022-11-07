## Task 1. Count Chars in a String

Write a program that **counts all characters** in a string **except space (' ')**.

**Print all occurrences in the following format:**

**"{char} -> {occurrences}"**



## Task 2. A Miner Task

Until you receive the **"stop"** command, you will be given a sequence of strings, each on a new line. Every **odd** line on the console represents a **resource** (e.g., Gold, Silver, Copper, etc.) and every **even - quantity**. Your task is to collect the resources and print them on a new line.

**Print the resources and their quantities in format: "{resource} –> {quantity}".**

The quantities inputs will be in the range **[1 … 2 000 000 000]**.



## Task 3. Orders

Write a program which keeps the information about **products** and their **prices**. Each product has a **name**, a **price**, and its **quantity**. If the product **doesn't exist** yet, **add** it with its **starting quantity**.

If you receive a product that **already exists, increases** its quantity by the input quantity and if its **price is different**, **replace** the price as well.

You will receive products' **names**, **prices**, and **quantities** on **new lines**. Until you receive the command **"buy"**, keep adding items. When you do receive the command **"buy"**, print the items with their names and the **total price** of all the products with that name.



## Task 4. SoftUni Parking

Write a program that validates **parking** for an online service. Users can register to park and unregister to leave.

The program receives **2 commands**:

- **"register {username} {licensePlateNumber}":**

	- The system only supports one car per user at the moment, so if a user tries to register another license plate using the same username, the system should print: **"ERROR: already registered with plate number {licensePlateNumber}"**

	- If the aforementioned checks pass successfully, the plate can be registered, so the system should print: **"{username} registered {licensePlateNumber} successfully"**

- **"unregister {username}":**

	- If the user is not present in the database, the system should print: **"ERROR: user {username} not found"**

	- If the aforementioned check passes successfully, the system should print: **"{username} unregistered successfully"**

After you execute all of the commands, print all the currently registered users and their license plates in the format:

- **"{username} => {licensePlateNumber}"**



## Task 5. Courses

Write a program which keeps the information about **courses**. Each course has a **name** and **registered students**.

You will receive the course name and student name until you receive the command "end". Check if such a course already exists and if not - add the course. Register the user into the course. When you do receive the command "end", print the courses with their names and total registered users. For each contest, print the registered users.



## Task 6. Student Academy

Write a program that keeps the information about students and their grades.

On the first line, you will receive number n. After that, you will receive n pair of rows. First, you will receive the student's name, after that, you will receive his grade. Check if the student already exists and if not - add him. Keep track of all grades for each student.

When you finish reading data, keep students with an average grade higher or equal to 4.50.

Print the students and their average grade in the format:

"{name} –> {averageGrade}"

Format the average grade to the 2nd decimal place.



## Task 7. Legendary Farming

You are playing a game, and your goal is to win a legendary item - any legendary item will be good enough. However, it's a tedious process and requires quite a bit of farming. The possible items are:

- "Shadowmourne" - requires 250 Shards
- "Valanyr" - requires 250 Fragments
- "Dragonwrath" - requires 250 Motes

"Shards", "Fragments", and "Motes" are the key materials (case-insensitive), and everything else is junk.

You will be given lines of input in the format:

"{quantity1} {material1} {quantity2} {material2} … {quantityN} {materialN}"

Keep track of the key materials - the first one that reaches 250, wins the race. At that point, you have to print that the corresponding legendary item is obtained.

In the end, print the remaining shards, fragments, and motes in the format:

"shards: {numberOfShards}

fragments: {numberOfFragments}

motes: {numberOfMotes}"

Finally, print the collected junk items in the order of appearance.



## Task 8. Company Users

Write a program which keeps the information about companies and their employees.

You will receive company names and an employees' id until you receive the "End" command. Add each employee to the given company. Keep in mind that a company cannot have two employees with the same id.

Print the company name and each employee's id in the following format:

"{company_name}

-- {id1}

-- {id2}

…

-- {idN}"



## Task 9. *ForceBook

The force users are struggling to remember which side is the different forceUsers from because they switch them too often. So you are tasked to create a web application to manage their profiles.

You will receive several input lines in one of the following formats:

"{force_side} | {force_user}"

"{force_user} -> {force_side}"

The "force_user" and "force_side" are strings containing any character.

If you receive "force_side | force_user":
- If there is no such force user and no such force side -> create a new force side and add the force user to the corresponding side.
- Only if there is no such force user on any force side -> add the force user to the corresponding side.
- If there is such force user already -> skip the command and continue to the next operation.

If you receive a "force_user -> force_side":
- If there is such force user already -> change their side.
- If there is no such force user on any force side -> add the force user to the corresponding force side.
- If there is no such force user and no such force side -> create a new force side and add the force user to the corresponding side.
- Then you should print on the console: "{force_user} joins the {force_side} side!".

You should end your program when you receive the command "Lumpawaroo". At that point, you should print each force side. For each side, print the force users.

In case there are no force users on a side, you shouldn't print the side information



## Task 10. *SoftUni Exam Results

Judge statistics on the last Programming Fundamentals exam were not working correctly, so you have the task to take all the submissions and analyze them properly. You should collect all the submissions and print the final results and statistics about each language in which the participants submitted their solutions.

You will be receiving lines in the following format: "{username}-{language}-{points}" until you receive "exam finished". You should store each username and their submissions and points.

You can receive a command to ban a user for cheating in the following format: "{username}-banned". In that case, you should remove the user from the contest but preserve his submissions in the total count of submissions for each language.

After receiving "exam finished", print each of the participants in the following format:

"Results:

{username} | {points}

{username2} | {points}

…

{usernameN} | {points}"

After that, print each language used in the exam in the following format:

"Submissions:

{language1} - {submissions_count}

{language2} - {submissions_count}

…

{language3} - {submissions_count}"