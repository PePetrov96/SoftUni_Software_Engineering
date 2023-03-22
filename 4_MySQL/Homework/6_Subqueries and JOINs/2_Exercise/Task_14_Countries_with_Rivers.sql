SELECT c.country_name,
       r.river_name
FROM countries AS c
JOIN countries_rivers AS cr
    ON c.country_code = cr.country_code
JOIN rivers AS r
    ON r.id = cr.river_id
WHERE c.continent_code = 'AF'
ORDER BY c.country_name
LIMIT 5;