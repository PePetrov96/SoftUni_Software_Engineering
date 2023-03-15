SELECT town_id, name
FROM towns
WHERE lower(name) LIKE 'm%'
   OR lower(name) LIKE 'k%'
   OR lower(name) LIKE 'b%'
   OR lower(name) LIKE 'e%'
ORDER BY name;