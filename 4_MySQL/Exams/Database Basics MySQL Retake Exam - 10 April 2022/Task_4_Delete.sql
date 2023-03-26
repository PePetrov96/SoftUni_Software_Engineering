DELETE c
FROM countries AS c
LEFT JOIN movies AS m
    ON c.id = m.country_id
WHERE m.country_id IS NULL;