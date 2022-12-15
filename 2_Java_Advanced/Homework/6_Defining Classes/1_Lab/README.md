## Task 1. Car Info
Create a class named Car.

The class should have public fields for:
- Brand: String
- Model: String
- Horsepower: int


Create Car Info Method
This method should return the info about any car object in the following format:
**"The car is: {brand} {model} – {horsePower} HP."**

Read cars objects, add them to the collection of your choice, and print each one on the console using the **carInfo()** method. The input consists of a single integer N, the number of lines representing car objects. On each line you will read car info in the following format "**{brand} {model} {horsePower}**" separated by single space.



## Task 2. Car Constructors
Make proper constructors for the Car class so you can create car objects with a different type of input information.

If you miss information about the field of type String set the value to "unknown", and for an integer, fieldset -1.
First, declare a constructor which takes only the car brand as a parameter, sets the model to "unknown" and the horsepower to -1.
Also, create a constructor which sets all the fields.

Read information about cars the same way as the previous task, however, this time uses constructors to create the objects, not creating an object with the default constructor. You should be able to handle different types of input, the format will be the same as the previous task, but this time some of the data may be missing. For example, you can get only the car brand – which means you have to set the car model to "unknown" and the Horsepower value to -1. There will be lines with complete car data, declare constructor which sets all the fields.

You have to add the car objects to a collection of your choice and print the data as in the previous task. The input will always have one or three elements on each line.



## Task 3. Bank Account
Create class BankAccount.

The class should have private fields for:
- Id: int (Starts from 1 and increments for every new account)
- Balance: double
- Interest rate: double (Shared for all accounts. Default value: 0.02)

The class should also have public methods for:
- setInterestRate(double interest): void (static)
- getInterest(int Years): double
- deposit(double amount): void

Create a test client supporting the following commands:
- Create
- Deposit {Id} {Amount}
- SetInterest {Interest}
- GetInterest {ID} {Years}
- End