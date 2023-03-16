SELECT department_id, COUNT(id) AS 'Number of employees'
FROM employees AS e
GROUP BY e.department_id
ORDER BY e.department_id;