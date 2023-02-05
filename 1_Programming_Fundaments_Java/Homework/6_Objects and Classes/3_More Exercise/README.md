## Task 1. Company Roster

Define a class **Employee** with the following information: **name, salary, position, department, email**, and **age**. The **name, salary, position**, and **department** are **mandatory**, while the rest are **optional**.

Your task is to write a program that takes **N** lines of employees from the console and calculates the department with the highest average salary, and prints for each employee in that department his **name, salary, email**, and **age** – **sorted by salary in descending order**. If an employee **doesn't have an email** – in place of that field, you should print **"n/a"** instead, if he **doesn't have an age** – print "**-1**" instead. The **salary** should be printed to **two decimal places** after the separator.



## Task 2. Raw Data

You are the owner of a courier company and want to make a system for tracking your cars and their cargo. Define a class **Car** that holds information about the **model, engine, cargo**, and a **collection of exactly 4 tires**. The engine, cargo, and tire should be **separate classes**, and create a constructor that receives all information about the Car and creates and initializes its inner components (engine, cargo, and tires).

On the first line of input you will receive a number **N** - the number of cars you have, on each of the next **N** lines you will receive information about a car in the format "**{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType} {Tire1Pressure} {Tire1Age} {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire3Age} {Tire4Pressure} {Tire4Age}**" where the speed, power, weight and tire age are **integers**, tire pressure is a **double**.

After the **N** lines, you will receive a single line with one of 2 commands "**fragile**" or "**flamable**", if the command is "**fragile**" print all cars whose **Cargo Type is "fragile"** with a **tire** whose **pressure is < 1** if the command is "**flamable**" print all cars whose **Cargo Type is "flamable"** and have **Engine Power > 250**. The cars should be printed in order to appear in the input.



## Task 3. Car Salesman

Define two classes **Car** and **Engine**. A **Car** has a **model, engine, weight**, and color. An Engine has a **model, power, displacement**, and **efficiency**. A Car's **weight** and **color** and its Engine's **displacements** and **efficiency** are **optional**.

On the first line, you will read a number **N** which will specify how many lines of engines you will receive, on each of the next **N** lines, you will receive information about an Engine in the following format "**{Model} {Power} {Displacement} {Efficiency}**". After the lines with engines, on the next line, you will receive a number **M** – specifying the number of Cars that will follow, on each of the next **M** lines, information about a Car will follow in the following format "**{Model} {Engine} {Weight} {Color}**", where the engine in the format will be the model of an existing Engine. When creating the object for a Car, you should keep a **reference to the real engine** in it, instead of just the engine's model, note that the optional properties **might be missing** from the formats.

Your task is to print each car (in the order you received them) and its information in the format defined below, if any of the optional fields have not been given, print **"n/a"** in its place instead:

**"{CarModel}:**
	**{EngineModel}:**
		**Power: {EnginePower}**
		**Displacement: {EngineDisplacement}**
		**Efficiency: {EngineEfficiency}**
	**Weight: {CarWeight}**
	**Color: {CarColor}"**



## Task 4. Teamwork Projects

It's time for teamwork projects, and you are responsible for making the teams. First, you will receive an integer - the **count** of the teams you will have to **register**. You will be given a **user** and a **team** (separated with "**-**"). The user is the **creator** of that team.

For every newly created team, you should **print** a message:

**"Team {team Name} has been created by {user}!"**

Next, you will receive a user with the team (separated with "->") which means that the user wants to **join** that **team**. Upon receiving the command: "**end of assignment**", you should print **every team**, **ordered** by the **count** of its **members (descending)** and then by **name (ascending)**. For each team (disband teams as well), you have to print its members **sorted** by name (**ascending**). However, there are several **rules**:

- If a user tries to create a team more than once, a message should be displayed: 
	**"Team {teamName} was already created!"**
- The creator of a team cannot create another team - the message should be thrown:
	**"{user} cannot create another team!"**
- If a user tries to join a currently non-existing team, a message should be displayed:
	**"Team {teamName} does not exist!"**
- A Member of a team cannot join another team - the message should be thrown:
	**"Member {user} cannot join team {team Name}!"**
- At the **end** (after teams' report), teams with **zero** members (with **only a creator**) should **disband, ordered by name in ascending other**.
- Every **valid** team should be printed ordered by **name** (ascending) in this format: 
	**"{teamName}:**
	**- {create}
	**-- {member}..."**