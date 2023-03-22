SELECT e.employee_id, e.job_title, e.address_id, address_text
FROM employees e
JOIN addresses a on a.address_id = e.address_id
ORDER BY a.address_id
LIMIT 5;