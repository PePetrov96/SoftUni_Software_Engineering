SELECT e.first_name, e.last_name, t.name, a.address_text
FROM employees e
JOIN addresses a ON a.address_id = e.address_id
JOIN towns t on t.town_id = a.town_id
ORDER BY e.first_name, e.last_name
LIMIT 5;