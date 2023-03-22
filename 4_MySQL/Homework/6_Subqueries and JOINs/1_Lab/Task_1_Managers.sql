SELECT e.employee_id,
       CONCAT_WS(' ', e.first_name, e.last_name) AS 'full_name',
       d.department_id,
       d.name
FROM employees e
JOIN departments d ON e.employee_id = d.manager_id
ORDER BY employee_id
LIMIT 5;