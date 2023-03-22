SELECT COUNT(e.employee_id) AS 'count'
FROM employees e
WHERE e.salary > (
    SELECT AVG(salary) AS 'average_salary' FROM employees
    );