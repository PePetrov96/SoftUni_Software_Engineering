SELECT (COUNT(p.name)) AS 'items_count',
       c.name,
       SUM(quantity_in_stock) AS 'total_quantity'
FROM products AS p
JOIN categories AS c
    ON c.id = p.category_id
GROUP BY category_id
ORDER BY items_count DESC,
         total_quantity
LIMIT 5;