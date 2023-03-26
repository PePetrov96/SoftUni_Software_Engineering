SELECT c.name, COUNT(*) AS num_movies
FROM countries AS c
JOIN movies AS m
    ON c.id = m.country_id
GROUP BY c.name
HAVING COUNT(*) >= 7
ORDER BY c.name DESC;