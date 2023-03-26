SELECT first_name,
       last_name,
       birthdate,
       review
FROM clients AS c
WHERE c.card IS NULL AND YEAR(c.birthdate) BETWEEN '1978' AND '1993'
ORDER BY last_name DESC, id
LIMIT 5;