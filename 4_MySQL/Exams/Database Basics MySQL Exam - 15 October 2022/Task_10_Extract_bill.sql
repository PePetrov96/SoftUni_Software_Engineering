CREATE FUNCTION udf_client_bill(full_name VARCHAR(50))
RETURNS DECIMAL(19,2)
DETERMINISTIC
BEGIN
    DECLARE total_bill DECIMAL(19,2);
    SELECT SUM(p.price)
    INTO total_bill
    FROM orders
    JOIN orders_clients AS oc
        ON orders.id = oc.order_id
    JOIN clients AS c
        ON c.id = oc.client_id
    JOIN orders_products AS op
        ON orders.id = op.order_id
    JOIN products AS p
        ON p.id = op.product_id
    WHERE CONCAT_WS(' ', first_name, last_name) = full_name;
    RETURN total_bill;
END;

SELECT c.first_name,c.last_name, udf_client_bill('Silvio Blyth') as 'bill' FROM clients c
WHERE c.first_name = 'Silvio' AND c.last_name= 'Blyth';