SELECT t.town_id, t.name, a.address_text
FROM towns t
JOIN addresses a on t.town_id = a.town_id
WHERE t.town_id IN (9, 15, 32)
ORDER BY t.town_id, a.address_id;