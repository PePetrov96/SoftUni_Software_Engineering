## Task 1. Card Suit

Create an enumeration type that has as its constants the four suits of a deck of playing cards (CLUBS, DIAMONDS, HEARTS, SPADES). Iterate over the values of the enumeration type and print all ordinal values and names.



## Task 2. Card Rank

Create an enumeration type that has as its constants the thirteen ranks of a deck of playing cards (ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING). Iterate over the values of the enumeration type and print all ordinal values and names.



## Task 3. Cards with Power

Create a program that generates a deck of cards (class Card) that have power. The power of a card is calculated by adding the power of its rank plus the power of its suit.

Rank powers are as follows: (ACE - 14, TWO - 2, THREE - 3, FOUR - 4, FIVE - 5, SIX - 6, SEVEN - 7, EIGHT - 8, NINE - 9, TEN - 10, JACK - 11, QUEEN - 12, KING - 13).

Suit powers are as follows: (CLUBS - 0, DIAMONDS - 13, HEARTS - 26, SPADES - 39).

You will get a command consisting of two lines. On the first line, you will receive the Rank of the card and on the second line, you will get the suit of the card.

Print the output in the format: "Card name: {card name} of {suit name}; Card power: {power of rank + power of suit}".



## Task 4. Traffic Lights

Implement a simple state machine in the form of a traffic light. Every traffic light has three possible signals - red, green, and yellow. Each traffic light can be updated, which changes the color of its signal (e.g. if it is currently red, it changes to green, if it is green it changes to yellow). The order of signals is red -> green -> yellow -> red and so on.

On the first line, you will be given multiple traffic light signals in the format "RED GREEN YELLOW". They may be 3, more, or less than 3. You need to make as many traffic lights as there are signals in the input.

On the second line, you will receive the n number of times you need to change each traffic light's signal.

Your output should consist of n number of lines, including each updated traffic light's signal. To better understand the problem, see the example below.



## Task 5. Jedi Galaxy

Peter is Jedi and so he starts gathering stars to grow stronger.

His galaxy is represented as a two-dimensional array. Every cell in the matrix is a star that has a value. Peter starts at the given col and row. He can move only on the diagonal from the lowest left to the upper right and adds to his score all the stars (values) from the cells he passes through. Unfortunately, there is always an Evil power that tries to prevent his success.

Evil power starts at the given row and col and instantly destroys all-stars on the opposite diagonal – From the lowest right to the upper left.

Peter adds the values only of the stars that are not destroyed by the evil power.

You will receive two integers, separated by space, which represent the two-dimensional array - the first being the rows and the second being the columns. Then, you must fill the two-dimensional array with increasing integers starting from 0, and continuing on every row, like this: first row: 0, 1, 2… m second row: n+1, n+2, n+3… n + n.



## Task 6. Greedy Times

Finally, you have unlocked the safe and reached the treasure! Inside there are all kinds of gems, cash in different currencies, and gold bullions. Next to you, there is a bag which unfortunately has limited space. You don’t have much time so you need to take as much wealth as possible! But to get a bigger amount of the most valuable items, you need to keep the following rules:
- The gold amount in your bag should always be more than or equal to the gem amount at any time
- The gem amount should always be more than or equal to the cash amount at any time

If you read an item that breaks one of these rules you should not put it in the bag. You should always be careful not to exceed the overall bag’s capacity because it will tear down and you will lose everything! You will receive the content of the safe on a single line in the format "{item} {quantity}" pairs, separated by whitespace. You need to gather only three types of items:
- Cash - All three letter items
- Gem - All items which end on "Gem" (at least 4 symbols)
- Gold - this type has only one item with the name - "Gold"

Each item that does not fall in one of the above categories is useless and you should skip it. Reading item’s names should be CASE-INSENSITIVE, except when the item is Cash. You should aggregate items’ quantities that have the same name.

If you’ve kept the rules you should escape successfully with a bag full of wealth. Now it’s time to review what you have managed to get out of the safe. Print all the types ordered by the total amount in descending order. Inside a type, order the items first alphabetically in descending order and then by their amount in ascending order. Use the format described below for each type.