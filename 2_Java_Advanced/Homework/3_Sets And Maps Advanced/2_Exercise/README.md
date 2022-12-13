## Task 1. Unique Usernames

Write a simple program that reads a sequence of usernames from the console and keeps a collection with only the unique ones. Print the collection on the console in order of insertion:



## Task 2. Sets of Elements

On the first line, you are given the length of two sets, N and M. On the next N + M lines, there are N numbers that are in the first set and M numbers that are in the second one. Find all non-repeating element that appears in both of them, and print them in the same order at the console:

Set with length N = 4: {1, 3, 5, 7}

Set with length M = 3: {3, 4, 5}

Set that contains all repeating elements -> {3, 5}



## Task 3. Periodic Table

You are given an n number of chemical compounds. You need to keep track of all chemical elements used in the compounds and at the end, print all unique ones in ascending order:



## Task 4. Count Symbols

Write a program that reads some text from the console and counts the occurrences of each character in it. Print the results in alphabetical (lexicographical) order.



## Task 5. Phonebook

Write a program that receives some info from the console about people and their phone numbers.

You are free to choose how the data is entered. Each entry should have just one name and one number (both of them strings). If you receive a name that already exists in the phonebook, simply update its number.

After filling this simple phonebook, upon receiving the command "search", your program should be able to perform a search of contact by name and print her details in the format "{name} -> {number}". In case the contact isn't found, print "Contact {name} does not exist.".



## Task 6. Fix Emails

You are given a sequence of strings, each on a new line, until you receive the "stop" command. The first string is a name of a person. On the second line, you receive his email. Your task is to collect their names and emails and remove emails whose domain ends with "us", "uk," or "com" (case insensitive). Print in the following format:

"{name} – > {email}"



## Task 7. Hands Of Cards

You are given a sequence of people and what cards he draws from the deck for every person. The input will be separate lines in the format:

"{personName}: {PT, PT, PT,… PT}"

Where P (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A) is the power of the card and T (S, H, D, C) is the type. The input ends when a "JOKER" is drawn. The name can contain any ASCII symbol except ":". The input will always be valid, and in the format described, there is no need to check it.

A single person cannot have more than one card with the same power and type. If he draws such a card, he discards it. The people are playing with multiple decks. Each card has a value that is calculated by the power multiplied by the type. Powers 2 to 10 have the same value, and J to A is 11 to 14. Types are mapped to multipliers the following way (S -> 4, H-> 3, D -> 2, C -> 1).

Finally, print out the total value each player has in his hand in the format:

"{personName}: {value}"



## Task 8. *User Logs

Marian is a famous system administrator. The person to overcome the security of his servers has not yet been born. However, there is a new type of threat where users flood the server with messages that are hard to be detected since they change their IP address all the time. Well, Marian is a system administrator and is not so into programming. Therefore, he needs a skillful programmer to track the user logs of his servers. You are the chosen one to help him!

You are given an input in the format:

"IP={IP.Address} message={A&sample&message} user={username}"

Your task is to parse the IP and the username from the input, and for every user, you have to display every IP from which the corresponding user has sent a message and the count of the messages sent with the corresponding IP. In the output, the usernames must be sorted alphabetically, while their IP addresses should be displayed in the order of their first appearance. The output should be in the following format:

"username:

{IP} => {count}, {IP} => {count}."

For example, given the following input - IP=192.23.30.40 message='Hello&derps.' user=destroyer, you have to get the username destroyer and the IP 192.23.30.40 and display it in the following format:

"destroyer:

192.23.30.40 => 1. "

The username destroyer has sent a message from IP 192.23.30.40 once.

Check the examples below. They will further clarify the assignment.



## Task 9. *Population Counter

So many people! It's hard to count them all. But that's your job as a statistician. You get raw data for a given city, and you need to aggregate it.

On each input line, you'll be given data in the format: "city|country|population". There will be no redundant whitespaces anywhere in the input. Aggregate the data by country and by city and print it on the console. For each country, print its total population and on separate lines the data for each of its cities. Countries should be ordered by their total population in descending order, and within each country, the cities should be ordered by the same criterion. If two countries/cities have the same population, keep them in the order in which they were entered. Check out the examples. Follow the output format strictly!



## Task 10. *Logs Aggregator

You are given a sequence of access logs in format "{IP} {user} {duration}". For example:
- 192.168.0.11 peter 33
- 10.10.17.33 alex 12
- 10.10.17.35 peter 30
- 10.10.17.34 peter 120
- 10.10.17.34 peter 120
- 212.50.118.81 alex 46
- 212.50.118.81 alex 4

Write a program to aggregate the logs data and print for each user the total duration of his sessions and a list of unique IP addresses in the format "{user}: {duration} [IP1, IP2, ...]". Order the users alphabetically. Order the IPs alphabetically. In our example, the output should be the following:
- alex: 62 [10.10.17.33, 212.50.118.81]
- peter: 303 [10.10.17.34, 10.10.17.35, 192.168.0.11]



## Task 11. *Legendary Farming

You've beaten all the content, and the last thing left to accomplish is to own a legendary item. However, it's a tedious process and requires quite a bit of farming. Anyway, you are not too pretentious – any legendary will do. The possible items are:
- Shadowmourne – requires 250 Shards;
- Valanyr – requires 250 Fragments;
- Dragonwrath – requires 250 Motes;

Shards, Fragments, and Motes are the key materials, all else is junk. You will be given lines of input, such as 2 motes 3 ores 15 stones. Keep track of the key materials - the first that reaches the 250 mark wins the race. At that point, print the corresponding legendary obtained. Then, print the remaining shards, fragments, and motes,

ordered by quantity in descending order, each on a new line. Finally, print the collected junk items in alphabetical order.



## Task 12. ***Сръбско Unleashed

Admit it – the СРЪБСКО is your favorite sort of music. You never miss a concert, and you have become quite the geek concerning everything involved with СРЪБСКО. You can't decide between all the singers you know who your favorite one is. One way to find out is to keep a statistic of how much money their concerts make. Write a program that does all the boring calculations for you.

On each input line you’ll be given data in format: "{singer} @{venue} {ticketsPrice} {ticketsCount}". There will be no redundant whitespaces anywhere in the input. Aggregate the data by venue and by the singer. For each venue, print the singer and the total amount of money his/her concerts have made on a separate line. Venues

should be kept in the same order they were entered, the singers should be sorted by how much money they have made in descending order. If two singers have made the same amount of money, keep them in the order in which they were entered.

Keep in mind that if a line is in incorrect format, it should be skipped, and its data should not be added to the output. Each of the four tokens must be separated by a space, everything else is invalid. The venue should be denoted with @ in front of it, such as @Sunny Beach

SKIP THOSE: Ceca@Belgrade125 12378, Ceca @Belgrade12312 123

The singer and town name may consist of one to three words.



## Task 13. ***Dragon Army

Heroes III is the best game ever. Everyone loves it, and everyone plays it all the time. John is not an exclusion from this rule. His favorite units in the game are all types of dragons – black, red, gold, azure, etc… He likes them so much that he gives them names and keeps logs of their stats: damage, health, and armor. The process of aggregating all the data is quite tedious, so he would like to have a program doing it. Since he is no programmer, it's your task to help him

You need to categorize dragons by their type. For each dragon, identified by name, keep information about his stats. Type is preserved as in the input order, but dragons are sorted alphabetically by name. For each type, you should also print the average damage, health, and armor of the dragons. For each dragon, print his stats.

There may be missing stats in the input, though. If a stat is missing, you should assign its default values. Default values are as follows: health - 250, damage - 45, and armor - 10. Missing stat will be marked by null.

The input is in the following format "{type} {name} {damage} {health} {armor}". Any of the integers may be assigned a null value. See the examples below for a better understanding of your task.

If the same dragon is added a second time, the new stats should overwrite the previous ones. Two dragons are considered equal if they match by both name and type.