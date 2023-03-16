SELECT department_id, ROUND(AVG(salary), 2) AS 'Average  Salary'
FROM employees AS e
GROUP BY e.department_id
ORDER BY e.department_id;