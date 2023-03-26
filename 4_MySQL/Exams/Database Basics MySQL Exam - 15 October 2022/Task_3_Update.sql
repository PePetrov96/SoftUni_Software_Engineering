UPDATE orders
SET table_id = table_id - 1
WHERE id >= 12 AND id <= 23;