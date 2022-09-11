## Task 1. Messaging

You will be given a **list of numbers** and a string. For each element of the list, you have to take the **sum of its digits** and take the **element corresponding to that index** from the text. If the index is greater than the length of the text, start counting from the beginning (so that you always have a valid index). After getting the element from the text, you have to remove the character you have taken from it (so for the next index, the text will be with one characterless).



## Task 2. Car Race

Write a program to calculate the **winner of a car race**. You will receive an **array of numbers**. Each element of the array represents the time needed to pass through that step (the index). There are going to be **two cars**. **One** of them **starts from the left** side and the **other** one **starts from the right side**. The **middle index** of the array is the **finish line**. (The number of elements of the array will always be odd). Calculate the total time for each racer to reach the finish (the middle of the array) and print the winner with his total time. (The racer with less time). If you have a zero in the array, you have to reduce the time of the racer that reached it by 20% (from the time so far).

Print the result in the following format **"The winner is {left/right} with total time: {total time}"**, formatted with **one** digit after the decimal point.



## Task 3. Take/Skip Rope

Write a program, which reads a **string** and **skips** through it, extracting a **hidden message**. The algorithm you have to implement is as follows:

Let’s take the string **"skipTest_String044170"** as an example.

Take every **digit** from the string and **store it** somewhere. After that, **remove** all the digits from the string. After this operation, you should have two lists of items: the numbers list and the non-numbers list:

- Numbers list: [0, 4, 4, 1, 7, 0]
- Non-numbers: [s, k, i, p, T, e, s, t, _, S, t, r, i, n, g]

After that, take every digit in the numbers list and split it up into a take list and a skip list, depending on whether the digit is in an even or an odd index:
- Numbers list: [0, 4, 4, 1, 7, 0]
- Take list: [0, 4, 7]
- Skip list: [4, 1, 0]

Afterward, iterate over both of the lists and **skip {skipCount}** characters from the non-numbers list, then take **{takeCount}** characters and store it in a result string. Note that the skipped characters are summed up as they go. The process would look like this on the aforementioned non-numbers list:

**Example: "skipTest_String"**

- 1. Take **0** characters -> Taken: "", skip 4 characters è Skipped: "skip" **->** Result: ""
- 2. Take **4** characters -> Taken: "Test", skip 1 characters è Skipped: "_" **->** Result: **"Test"**
- 3. Take **7** characters -> Taken: "String", skip 0 characters è Skipped: "" **->** Result: **"TestString"**

After that, just print the **result string** on the console.



## Task 4. Mixed Up Lists

Write a program that mixes up two lists by some rules. You will receive two lines of input, each one being a list of numbers. The mixing rules are:

- Start from the beginning of the first list and the ending of the second.
- Add element from the first and element from the second.
- In the end, there will always be a list in which there are 2 elements remaining.
- These elements will be the range of the elements you need to print.
- Loop through the result list and take only the elements that fulfill the condition.
- Print the elements ordered in ascending order and separated by a space.



## Task 5. Drum Set

Gabsy is Orgolt's Final Revenge charming drummer. She has a drum set but the different drums have different origins – some she bought, some are gifts, so they are all of different quality. Every day she practices on each of them, so she does damage and reduces the drum's quality. Sometimes a drum breaks, so she needs to buy a new one. Help her keep her drum set organized.

You will receive Gabsy's savings, the money she can spend on new drums. Next, you receive a sequence of integers which represent the initial quality of each drum in Gabsy's drum set.

Until you receive the command **"Hit it again, Gabsy!"**, you will be receiving integer: the hit power Gabsy applies on each drum while practicing. When the power is applied you should decrease the value of the drum's quality with the current power.

When a certain drum reaches 0 quality, it breaks. Then Gabsy should buy a replacement. She needs to buy the same model. Therefore, its quality will be the same as the initial quality of the broken drum. The price is calculated by the formula: **{initialQuality} x 3**. Gabsy will always replace her broken drums until the moment she can no longer afford them. If she doesn't have enough money for a replacement, the broken drum is removed from the drum set.

When you receive the command **"Hit it again, Gabsy!"**, the program ends and you should print the current state of the drum set. On the second line, you should print the remaining money in Gabsy's savings account.