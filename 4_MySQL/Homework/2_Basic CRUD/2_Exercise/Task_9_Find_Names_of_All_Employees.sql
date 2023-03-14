SELECT CONCAT(first_name, ' ', middle_name, ' ', last_name) AS 'Full Name'
FROM employees
WHERE salary = 25000 OR salary = 14000 OR salary = 12500 OR salary = 23600;