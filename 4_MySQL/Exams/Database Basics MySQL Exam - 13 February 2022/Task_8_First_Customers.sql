SELECT CONCAT_WS(' ', c.first_name, c.last_name) AS 'full_name',
       c.address,
       o.order_datetime AS 'order_date'
FROM customers AS c
JOIN orders AS o
    ON c.id = o.customer_id
WHERE YEAR(order_datetime) <= '2018'
ORDER BY full_name DESC;