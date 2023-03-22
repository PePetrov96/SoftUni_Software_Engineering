SELECT e.first_name,
       e.last_name,
       e.hire_date,
       d.name AS 'dept_name'
FROM employees AS e
JOIN departments AS d
    ON d.department_id = e.department_id
WHERE d.name IN ('Sales', 'Finance') AND DATE(hire_date) > '1999-01-01'
ORDER BY hire_date;