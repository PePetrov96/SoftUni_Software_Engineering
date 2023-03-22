SELECT e.employee_id,
       e.first_name,
       IF(YEAR(p.start_date) >= 2005, NULL, p.name) AS 'project_name'
FROM employees AS e
JOIN employees_projects AS ep
    ON e.employee_id = ep.employee_id
JOIN projects p
    ON p.project_id = ep.project_id
WHERE e.employee_id = 24
ORDER BY p.name;