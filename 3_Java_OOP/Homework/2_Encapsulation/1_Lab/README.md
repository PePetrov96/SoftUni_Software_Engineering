## Task 1. Sort by Name and Age

Create a class Person, which should have private fields for:
- firstName: String
- lastName: String
- age: int
- toString() - override



## Task 2. Salary Increase

Read person with their names, age, and salary. Read percent bonus to every person salary. People younger than 30 get a half bonus. Expand Person from the previous task. Add salary field and getter and setter with proper access.

New fields and methods
- salary: double
- increaseSalary(double bonus)



## Task 3. Validation Data

Expand Person with proper validation for every field:
- Names must be at least 3 symbols
- Age must not be zero or negative
- Salary can't be less than 460.0

Print proper message to end-user (look at an example for messages).

Don't use System.out.println() in Person class.



## Task 4. First and Reserve Team

Create a Team class. Add to this team all people you read. All people younger than 40 go on the first team, others go on the reverse team. At the end print first and reserve team sizes.

The class should have private fields for:
- name: String
- firstTeam: List<Person>
- reserveTeam: List<Person>

The class should have constructors:
- eam(String name)

The class should also have private method for setName and public methods for:
- getName(): String
- addPlayer(Person person): void
- getFirstTeam(): List<Person> (Collections.unmodifiableList)
- getReserveTeam(): List<Person> (Collections.unmodifiableList)