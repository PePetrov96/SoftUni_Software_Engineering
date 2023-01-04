## Task 1. Car Shop

Build hierarchy from classes and interfaces for this UML diagram:
<<inteface>>
<<Car>>
<<Serializable>>
+TIRES: Integer
+getModel(): String
+getColor(): String
+getHorsePower(): Integer
+countryProduced(): String

Seat
+toString(): String



## Task 2. Car Shop Extend

Extend the previous problem:
<<Car>>


Class
CarImpl
+CarImpl(model, color, horsePower, countryProduced)
+toString(): String


Class
Audi
-minRentDay: Integer
-pricePerDay: Double
+toString(): String


<<Rentable>>
+getMinRentDay(): Integer
+getPricePerDay(): Double


Class
Seat
-price: Double
+toString(): String


<<Sellable>>
+getPrice(): Double



## Task 3. Say Hello
Build hierarchy from classes and interfaces for this UML diagram:

<<Person>>
+getName(): String
+sayHello(): String


Bulgarian
-name: String
+sayHello(): String


European
-name: String


Chinese
-name: String
+sayHello(): String



## Task 4. Say Hello Extend

Build hierarchy from classes and interfaces for this UML diagram

<<Person>>
+getName(): String
+sayHello(): String


(Abstract) BasePerson
-name: String
+BasePerson(name)
+getName(): String
-setName(): void


Bulgarian
+Bulgarian(name)
+sayHello(): String


European
+European(name)
+sayHello(): String


Chinese
+Chinese(name)
+sayHello(): String



## Task 5. Border Control

It’s the future, you’re the ruler of a totalitarian dystopian society inhabited by citizens and robots, since you’re afraid of rebellions you decide to implement strict control of who enters your city. Your soldiers check the Ids of everyone who enters and leaves.

You will receive from the console an unknown amount of lines until the command "End" is received, on each line, there will be the information for either a citizen or a robot who tries to enter your city in the format "{name} {age} {id}" for citizens and "{model} {id}" for robots.

After the end command on the next line, you will receive a single number representing the last digits of fake ids, all citizens or robots whose Id ends with the specified digits must be detained.

The output of your program should consist of all detained Ids each on a separate line (the order of printing doesn’t matter).

<<Identifiable>>
+ getId(): String


Robot
- id: String
- model: String
+ Robot(String, String)
+ getId(): String
+ getModel(): String


Citizen
- name: String
- age: int
- id: String
+ Citizen(String, int, String)
+ getName(): String
+ getAge(): int
+ getId(): String



## Task 6. Ferrari

Model an application that contains a class Ferrari and an interface. Your task is simple, you have a car - Ferrari, its model is "488-Spider" and it has a driver. Your Ferrari should have the functionality to use brakes and push the gas pedal. When the brakes are pushed down print "Brakes!", and when the gas pedal is pushed down - "brum-brum-brum-brrrrr". As you may have guessed this functionality is typical for all cars, so you should implement an interface to describe it.

Your task is to create a Ferrari and set the driver's name to the passed one in the input. After that, print the info. Take a look at the Examples to understand the task better.

<<Car>>
+ brakes() : String
+ gas() : String


Ferrari
- driverName: String
- model: String
+ Ferrari (String)
+ brakes() : String
+ gas() : String
+ toString(): String