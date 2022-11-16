## Task 1. Furniture

Write a program to calculate the total cost of different types of furniture. You will be given some lines of input until you receive the line "Purchase". For the line to be valid, it should be in the following format:

">>{furniture name}<<{price}!{quantity}"

The price can be a floating-point number or a whole number. Store the names of the furniture and the total price. In the end, print each bought furniture on a separate line in the format:

"Bought furniture:
{1st name}
{2nd name}
…"

And on the last line, print the following: "Total money spend: {spend money}", formatted to the second decimal point.



## Task 2. Race

Write a program that processes information about a race. On the first line, you will be given a list of participants separated by ", ". On the next few lines, until you receive the line "end of race" you will be given some info which will be some alphanumeric characters. In between them, you could have some extra characters which you should ignore. For example: "G!32e%o7r#32g$235@!2e". The letters are the name of the person, and the sum of the digits is the distance he ran. So here we have George, who ran 29 km. Store the information about the person only if the list of racers contains the name of the person. If you receive the same person more than once add the distance to his old distance. In the end, print the top 3 racers in the format:

"1st place: {first racer}
2nd place: {second racer}
3rd place: {third racer}"



## Task 3. *SoftUni Bar Income

Let's take a break and visit the game bar at SoftUni. It is about time for the people behind the bar to go home, and you are the person who has to draw the line and calculate the money from the products that were sold throughout the day. Until you receive a line with the text "end of shift", you will be given lines of input. But before processing that line, you have to do some validations first.

Each valid order should have a customer, product, count, and price:
- Valid customer's name should be surrounded by '%' and must start with a capital letter, followed by lower-case letters.
- Valid product contains any word character and must be surrounded by '<' and '>'.
- The valid count is an integer surrounded by '|'.
- The valid price is any real number followed by '$'.

The parts of a valid order should appear in the order given: customer, product, count, and price.

Between each part there can be other symbols, except ('|', '$', '%' and '. ')

For each valid line print on the console: "{customerName}: {product} - {totalPrice}"

When you receive "end of shift", print the total amount of money for the day rounded to 2 decimal places in the following format: "Total income: {income}".



## Task 4. *Star Enigma

The war is at its peak, but you, young Padawan, can turn the tides with your programming skills. You are tasked to create a program to decrypt the messages of The Order and prevent the death of hundreds of lives.

You will receive several messages, which are encrypted using the legendary star enigma. You should decrypt the messages following these rules:

To properly decrypt a message, you should count all the letters [s, t, a, r] – case insensitive and remove the count from the current ASCII value of each symbol of the encrypted message.

After decryption:

Each message should have a planet name, population, attack type ('A', as an attack or 'D', as destruction), and soldier count.

The planet's name starts after '@' and contains only letters from the Latin alphabet.

The planet population starts after ':' and is an Integer;

The attack type may be "A"(attack) or "D"(destruction) and must be surrounded by "!" (Exclamation mark).

The soldier count starts after "->" and should be an Integer.

The order in the message should be: planet name -> planet population -> attack type -> soldier count. Each part can be separated from the others by any character except: '@', '-', '!', ':' and '>'.



## Task 5. *Nether Realms

A mighty battle is coming. In the stormy nether realms, demons fight against each other for supremacy in a duel from which only one will survive.

Your job, however, is not so exciting. You must sign in all the participants in the nether realm's mighty battle's demon book.

A demon's name contains his health and his damage.

The sum of the asci codes of all characters (excluding numbers (0-9), arithmetic symbols ('+', '-', '*', '/') and delimiter dot ('.')) gives a demon's total health.

The sum of all numbers in his name forms his base damage. Note that you should consider the plus '+' and minus '-' signs (e.g., +10 is 10 and -10 is -10). However, there are some symbols ('*' and '/') that can further alter the base damage by multiplying or dividing it by 2 (e.g. in the name "m15*/c-5.0", the base damage is 15 + (-5.0) = 10 and then you need to multiply it by 2 (e.g. 10 * 2 = 20) and then divide it by 2 (e.g. 20 / 2 = 10)).

So, multiplication and division are applied only after all numbers are included in the calculation and the order they appear in the name.



## Task 6. *Extract Emails

Write a program to extract all email addresses from a given text. The text comes at the only input line. Print the emails on the console, each at a separate line. Emails are considered to be in format <user>@<host>, where:
- <user> is a sequence of letters and digits, where '.', '-' and '_' can appear between them.
	- Examples of valid users: "stephan", "mike03", "s.johnson", "st_steward", "softuni-bulgaria", "12345".
	- Examples of invalid users: ''--123", ".....", "nakov_-", "_steve", ".info".
- <host> is a sequence of at least two words, separated by dots '.'. Each word is a sequence of letters and can have hyphens '-' between the letters.
	- Examples of hosts: "softuni.bg", "software-university.com", "intoprogramming.info", "mail.softuni.org".
	- Examples of invalid hosts: "helloworld", ".unknown.soft.", "invalid-host-", "invalid-".
- Examples of valid emails: info@softuni-bulgaria.org, kiki@hotmail.co.uk, no-reply@github.com, s.peterson@mail.uu.net, info-bg@software-university.software.academy.
- Examples of invalid emails: --123@gmail.com, …@mail.bg, .info@info.info, _steve@yahoo.cn, mike@helloworld, mike@.unknown.soft., s.johnson@invalid-.
