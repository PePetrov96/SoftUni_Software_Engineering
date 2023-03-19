## Task 1.	One-To-One Relationship

Create two tables as follows. Use appropriate data types.
<ol>
	<li>People</li>
		<ol>
			<li>person_id</li>
				<ol>
					<li>1</li>
					<li>2</li>
					<li>3</li>
				</ol>
		</ol>
		<ol>
			<li>first_name</li>
				<ol>
					<li>Roberto	</li>
					<li>Tom</li>
					<li>Yana</li>
				</ol>
		</ol>
		<ol>
			<li>salary</li>
				<ol>
					<li>43300.00</li>
					<li>56100.00</li>
					<li>60200.00</li>
				</ol>
		</ol>
		<ol>
			<li>passport_id</li>
				<ol>
					<li>102</li>
					<li>103</li>
					<li>101</li>
				</ol>
		</ol>
	<li>passports</li>
		<ol>
			<li>passport_id</li>
				<ol>
					<li>101</li>
					<li>102</li>
					<li>103</li>
				</ol>
		</ol>
		<ol>
			<li>passport_number</li>
				<ol>
					<li>N34FG21B</li>
					<li>K65LO4R7</li>
					<li>ZE657QP2</li>
				</ol>
		</ol>
</ol>


Insert the data from the example above.
- Alter table people and make person_id a primary key. 
- Create a foreign key between people and passports by using the passport_id column. 
- Think about which passport field should be UNIQUE.
- Format salary to second digit after decimal point.
Submit your queries by using "MySQL run queries & check DB" strategy.



## Task 2.	One-To-Many Relationship
Create two tables as follows. Use appropriate data types.

<ol>
  <li>Manufacturers</li>
		<ol>
			<li>manufacturer_id</li>
				<ol>
					<li>1</li>
					<li>2</li>
					<li>3</li>
				</ol>
		</ol>
		<ol>
			<li>name</li>
				<ol>
					<li>BMW</li>
					<li>Tesla</li>
					<li>Lada</li>
				</ol>
		</ol>
		<ol>
			<li>established_on</li>
				<ol>
					<li>01/03/1916</li>
					<li>01/01/2003</li>
					<li>01/05/1966</li>
				</ol>
		</ol>
	<li>Models</li>
		<ol>
			<li>model_id</li>
				<ol>
					<li>101</li>
					<li>102</li>
					<li>103</li>
					<li>104</li>
					<li>105</li>
					<li>106</li>
				</ol>
		</ol>
		<ol>
			<li>name</li>
				<ol>
					<li>X1</li>
					<li>i6</li>
					<li>Model S</li>
					<li>Model X</li>
					<li>Model 3</li>
					<li>Nova</li>
				</ol>
		</ol>
		<ol>
			<li>name</li>
				<ol>
					<li>1</li>
					<li>1</li>
					<li>2</li>
					<li>2</li>
					<li>2</li>
					<li>3</li>
				</ol>
		</ol>
</ol>


Insert the data from the example above. 
- Add primary and foreign keys.
Submit your queries by using "MySQL run queries & check DB" strategy.



## Task 3.	Many-To-Many Relationship
Create three tables as follows. Use appropriate data types.

<ol>
	<li>Students</li>
		<ol>
			<li>student_id</li>
				<ol>
					<li>1</li>
					<li>2</li>
					<li>3</li>
				</ol>
		</ol>
		<ol>
			<li>name</li>
				<ol>
					<li>Mila</li>
					<li>Toni</li>
					<li>Ron</li>
				</ol>
		</ol>
	<li>Exams</li>
		<ol>
			<li>exam_id</li>
				<ol>
					<li>1</li>
					<li>2</li>
					<li>3</li>
				</ol>
		</ol>
		<ol>
			<li>name</li>
				<ol>
					<li>Spring MVC</li>
					<li>Neo4j</li>
					<li>Oracle 11g</li>
				</ol>
		</ol>
	<li>Students_exams</li>
		<ol>
			<li>student_id</li>
				<ol>
					<li>1</li>
					<li>1</li>
					<li>2</li>
					<li>3</li>
					<li>2</li>
					<li>2</li>
				</ol>
		</ol>
		<ol>
			<li>exam_id</li>
				<ol>
					<li>101</li>
					<li>102</li>
					<li>101</li>
					<li>103</li>
					<li>102</li>
					<li>103</li>
				</ol>
		</ol>
</ol>

Insert the data from the example above.
- Add primary and foreign keys.
- Have in mind that the table student_exams should have a 
composite primary key.
Submit your queries by using "MySQL run queries & check DB" strategy.



## Task 4.	Self-Referencing

Create a single table as follows. Use appropriate data types.

<ol>
	<li>Teachers</li>
		<ol>
			<li>teacher_id</li>
				<ol>
					<li>101</li>
					<li>102</li>
					<li>103</li>
					<li>104</li>
					<li>105</li>
					<li>106</li>
				</ol>
		</ol>
		<ol>
			<li>name</li>
				<ol>
					<li>John</li>
					<li>Maya</li>
					<li>Silvia</li>
					<li>Ted</li>
					<li>Mark</li>
					<li>Greta</li>
				</ol>
		</ol>
		<ol>
			<li>manager_id</li>
				<ol>
					<li>NULL</li>
					<li>106</li>
					<li>106</li>
					<li>105</li>
					<li>101</li>
					<li>101</li>
				</ol>
		</ol>
</ol>

Insert the data from the example above. 
- Add primary and foreign keys. 
- The foreign key should be between manager_id and teacher_id.
Submit your queries by using "	MySQL run queries & check DB" strategy.



## Task 5.	Online Store Database
Create a new database and design the following structure:
 
Submit your queries by using "MySQL run queries & check DB" strategy.



## Task 6.	University Database
Create a new database and design the following structure: 

Submit your queries by using "MySQL run queries & check DB" strategy.



## Task 7.	SoftUni Design
Create an E/R Diagram of the SoftUni Database. There are some special relations you should check out: employees are self-referenced (manager_id) and departments have One-to-One with the employees (manager_id) while the employees have One-to-Many (department_id). You might find it interesting how it looks on а diagram. 



## Task 8.	Geography Design

Create an E/R Diagram of the Geography Database.



## Task 9.	Peaks in Rila

Display all peaks for "Rila" mountain_range. Include:
- mountain_range
- peak_name
- peak_elevation
Peaks should be sorted by peak_elevation descending.

