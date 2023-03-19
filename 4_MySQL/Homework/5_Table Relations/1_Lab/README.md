## Task 1. Mountains and Peaks
Write a query to create two tables – mountains and peaks and link their fields properly. Tables should have:
- Mountains:
	-- id 
	-- name
- Peaks: 
	-- id
	-- name
	-- mountain_id
Check your solutions using the "Run Queries and Check DB" strategy.



## Task 2.	 Trip Organization
Write a query to retrieve information about SoftUni camp's transportation organization. Get information about the drivers (name and id) and their vehicle type. Submit your queries using the "MySQL prepare DB and Run Queries" strategy.



## Task 3.	SoftUni Hiking
Get information about the hiking routes – starting point and ending point, and their leaders – name and id. Submit your queries using the "MySQL prepare DB and Run Queries" strategy.
Example
route_starting_point	route_ending_point	leader_id	leader_name
Hotel Malyovitsa	Malyovitsa Peak	3	RoYaL Yonkov
Hotel Malyovitsa	Malyovitsa Hut	3	RoYaL Yonkov
Ribni Ezera Hut	Rila Monastery	3	RoYaL Yonkov
Borovets	Musala Peak	4	Ivan Ivanov



## Task 4.	Delete Mountains
Drop tables from the task 1.
Write a query to create a one-to-many relationship between a table, holding information about 
mountains (id, name) and other - about peaks (id, name, mountain_id), so that when a mountain 
gets removed from the database, all his peaks are deleted too.
Submit your queries using the "MySQL run queries & check DB" strategy.



## Task 5.	 Project Management DB*
Write a query to create a project management db according to the following E/R Diagram:

- employees:
	-- id
	-- first_name
	-- last_name
	-- project_id

- projects:
	-- client_id
	-- project_lead_id

- clients:
	-- id
	-- client_name