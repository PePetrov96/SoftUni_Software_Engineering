SELECT first_name, last_name
FROM employees
WHERE LOWER(last_name) LIKE '%ei%'
ORDER BY employee_id;