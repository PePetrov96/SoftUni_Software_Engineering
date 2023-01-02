## Task 1. Class Box

You are given a geometric figure Box with fields length, width, and height. Model a class Box that can be instantiated by the same three parameters. Expose to the outside world only methods for its surface area, lateral surface area, and its volume.

On the first three lines, you will get the length, width, and height. On the next three lines print the surface area, lateral surface area, and the volume of the box.

A box’s side should not be zero or a negative number. Add data validation for each parameter given to the constructor. Make a private setter that performs data validation internally.



## Task 2. Animal Farm

You should be familiar with encapsulation already. For this problem, you’ll need to create a class called Chicken. Chicken should contain several fields, a constructor, and several methods. Your task is to encapsulate or hide anything that is not intended to be viewed or modified from outside the class.

#### Step 1. Encapsulate Fields

Fields should be private. Leaving fields open for modification from outside the class is potentially dangerous. Make all fields in the Chicken class private.

In case the value inside a field is needed elsewhere, use getters to reveal it.
Chicken lives for 15 years. Chicken has a name for sure, at least 1 symbol long. Chicken producing eggs:
- First 6 years it produces 2 eggs per day [0 - 5].
- Next 6 years it produces 1 egg per day [6 - 11].
- And after that, it produces 0.75 eggs per day.

#### Step 2. Ensure Classes Have a Correct State

Having getters and setters is useless if you don’t use them. The Chicken constructor modifies the fields directly which is wrong when there are suitable setters available. Modify the constructor to fix this issue.

#### Step 3. Validate Data Properly

Validate the chicken’s name (it cannot be null, empty, or whitespace). In case of an invalid name, print the exception message "Name cannot be empty."

Validate the age properly, minimum and maximum age are provided, make use of them. In case of invalid age, print the exception message "Age should be between 0 and 15."

#### Step 4. Hide Internal Logic

If a method is intended to be used only by descendant classes or internally to perform some action, there is no point in keeping them public. The calculateProductPerDay() method is used by the productPerDay() public method. This means the method can safely be hidden inside the Chicken class by declaring it private.



## Task 3. Shopping Spree

Create two classes: class Person and class Product. Each person should have a name, money, and a bag of products. Each product should have a name and cost. The name cannot be an empty string. Be careful about white space in the name. Money and cost cannot be a negative number.

Create a program in which each command corresponds to a person buying a product. If the person can afford a product add it to his bag. If a person doesn’t have enough money, print an appropriate exception message: "{Person name} can't afford {Product name}"

In the first two lines, you are given all people and all products. After all, purchases print every person in the order of appearance and all products that he has bought also in order of appearance. If nothing is bought, print: "{Person name} - Nothing bought".

Read commands till you find the line with the "END" command. In case of invalid input (negative money exception message: "Money cannot be negative") or empty name: (empty name exception message "Name cannot be empty") break the program with an appropriate message. See the examples below:



## Task 4. Pizza Calories

A Pizza is made of dough and different toppings. You should model a class Pizza which should have a name, dough, and toppings as fields. Every type of ingredient should have its class.

Every ingredient has different fields: the dough can be white or wholegrain and in addition, it can be crispy, chewy, or homemade. The toppings can be of type meat, veggies, cheese, or sauce. Every ingredient should weigh grams and a method for calculating its calories according to its type. Calories per gram are calculated through modifiers. Every ingredient has 2 calories per gram as a base and a modifier that gives the exact calories.

Your job is to model the classes in such a way that they are properly encapsulated and to provide a public method for every pizza that calculates its calories according to the ingredients it has.

For example, the white dough has a modifier of 1.5, a chewy dough has a modifier of 1.1, which means that a white chewy dough weighing 100 grams will have (2 * 100) * 1.5 * 1.1 = 330.00 total calories.

For example, meat has a modifier of 1.2, which means that meat weighing 50 grams will have (2 * 50) * 1.2 = 120.00 total calories.

#### Data Validation must be in the order of the Input Data.
Data Validation must be in the order of the Input Data.
- If an invalid flour type or an invalid baking technique is given an exception is thrown with the message "Invalid type of dough.".
- If dough weight is outside of the range [1..200] throw an exception with the message "Dough weight should be in the range [1..200]."
- If topping is not one of the provided types throw an exception with the message "Cannot place {name of invalid argument} on top of your pizza."
- If topping weight is outside of the range [1..50] throw an exception with the message "{Topping type name} weight should be in the range [1..50].".
- If the name of the pizza is empty, only whitespace or longer than 15 symbols throw an exception with the message "Pizza name should be between 1 and 15 symbols.".
- If a number of toppings are outside of the range [0..10] throw an exception with the message "Number of toppings should be in range [0..10].".

The input for a pizza consists of several lines:
- On the first line is the pizza name and the number of toppings it has in the format: Pizza {pizzaName} {numberOfToppings}
- On the second line you will get input for the dough in the format: Dough {flourType} {bakingTechnique} {weightInGrams}
- On the next lines, you will receive every topping the pizza has, until an"END" command is given: Topping {toppingType} {weightInGrams}

If the creation of the pizza was successfully printed on a single line the name of the pizza and the total calories it has rounded to the second digit after the decimal point.



## Task 5. **Football Team Generator

A football team has a variable number of players, a name, and a rating.

A player has a name and stats which are the basis for his skill level. The stats a player has are endurance, sprint, dribble, passing, and shooting. Each stat can be in the range [0..100]. The overall skill level of a player is calculated as the average of his stats. Only the name of a player and his stats should be visible to all of the outside world. Everything else should be hidden.

A team should expose a name, a rating (calculated by the average skill level of all players in the team), and methods for adding and removing players.

Your task is to model the team and the players following the proper principles of Encapsulation. Expose only the fields that need to be visible and validate data appropriately.

#### Data Validation
- A name cannot be null, empty, or white space. If not, print: "A name should not be empty."
- Stats should be in the range [0..100]. If not, print: "{Stat name} should be between 0 and 100."
- If you receive a command to remove a missing player, print: "Player {Player name} is not in {Team name} team."
- If you receive a command to add a player to a missing team, print: "Team {team name} does not exist."
- If you receive a command to show stats for a missing team, print: "Team {team name} does not exist."