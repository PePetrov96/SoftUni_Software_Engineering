SELECT category_id,
       ROUND(AVG(price), 2) AS 'Average Price',
       ROUND(MIN(price), 2) AS 'Cheapest Product',
       ROUND(MAX(price), 2) AS 'Most Expensive Product'
FROM products AS p
GROUP BY p.category_id;