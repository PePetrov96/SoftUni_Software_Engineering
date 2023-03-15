SELECT town_id, name
FROM towns
WHERE lower(name) NOT LIKE 'r%'
   AND lower(name) NOT LIKE 'b%'
   AND lower(name) NOT LIKE 'd%'
ORDER BY name;