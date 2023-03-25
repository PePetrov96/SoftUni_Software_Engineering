## Task 1.	Count Employees by Town
Write a function ufn_count_employees_by_town(town_name) that accepts town_name as parameter and returns the count of employees who live in that town.



## Task 2.	Employees Promotion
Write a stored procedure usp_raise_salaries(department_name) to raise the salary of all employees in given department as parameter by 5%. 



## Task 3. Employees Promotion by ID
Write a stored procedure usp_raise_salary_by_id(id) that raises a given employee's salary (by id as parameter) by 5%. Consider that you cannot promote an employee that doesn't exist – if that happens, no changes to the database should be made.



## Task 4. Triggered
Create a table deleted_employees(employee_id PK, first_name,last_name,middle_name,job_title,deparment_id,salary) that will hold information about fired(deleted) employees from the employees table. Add a trigger to employees table that inserts the corresponding information in deleted_employees.