DELETE FROM customers AS c
WHERE id NOT IN (SELECT customer_id
                 FROM orders);