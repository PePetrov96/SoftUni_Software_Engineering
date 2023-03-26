INSERT INTO actors(first_name, last_name, birthdate, height, awards, country_id)
SELECT (REVERSE(a.first_name)), (REVERSE(a.last_name)), (DATE(a.birthdate - 2)), (a.height + 10), a.country_id, (3)
FROM actors AS a
WHERE a.id <= 10;