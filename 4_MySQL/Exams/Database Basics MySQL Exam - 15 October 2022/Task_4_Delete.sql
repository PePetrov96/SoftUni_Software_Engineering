DELETE FROM waiters
WHERE id NOT IN (
    SELECT DISTINCT waiter_id FROM orders
);