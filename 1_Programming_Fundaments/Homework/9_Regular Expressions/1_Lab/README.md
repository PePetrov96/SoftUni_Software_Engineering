## Task 1. Match Full Name

Write a Java Program to match full names from a list of names and print them on the console.

Writing the Regular Expression

First, write a regular expression to match a valid full name, according to these conditions:

- A valid full name has the following characteristics:
	- It consists of two words.
	- Each word starts with a capital letter.
	- After the first letter, it only contains lowercase letters afterward.
	- Each of the two words should be at least two letters long.
	- The two words are separated by a single space.



## Task 2. Match Phone Number

Write a regular expression to match a valid phone number from Sofia. After you find all valid phones, print them on the console, separated by a comma and a space ", ".

Compose the Regular Expression

A valid number has the following characteristics:
- It starts with "+359".
- Then, it is followed by the area code (always 2).
- After that, it's followed by the number itself:
- The number consists of 7 digits (separated into two groups of 3 and 4 digits, respectively).
- The different parts are separated by either a space or a hyphen ('-').

You can use the following RegEx properties to help with the matching:
- Use quantifiers to match a specific number of digits.
- Use a capturing group to ensure the delimiter is only one of the allowed characters (space or hyphen) and not a combination of both (e.g., +359 2-111 111 has mixed delimiters, it is invalid). Use a group back reference to achieve this.
- Add a word boundary at the end of the match to avoid partial matches (the last example is on the right-hand side).
- Ensure that before the '+' sign, there is either a space or the beginning of the string.



## Task 3. Match Dates

Write a program that matches a date in the format "dd{separator}MMM{separator}yyyy". Use named capturing groups in your regular expression.

Compose the Regular Expression

Every valid date has the following characteristics:
- Always starts with two digits, followed by a separator.
- After that, it has one uppercase and two lowercase letters (e.g., Jan, Mar).
- After that, it has a separator and exactly 4 digits (for the year).
- The separator could be either of three things: a period ("."), a hyphen ("-") or a forward-slash ("/").
- The separator needs to be the same for the whole date (e.g., 13.03.2016 is valid, 13.03/2016 is NOT). Use a group back reference to check for this.