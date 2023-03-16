SELECT COUNT(price) AS 'Products'
FROM products AS p
WHERE price > 8.00 AND category_id = 2
GROUP BY p.category_id;