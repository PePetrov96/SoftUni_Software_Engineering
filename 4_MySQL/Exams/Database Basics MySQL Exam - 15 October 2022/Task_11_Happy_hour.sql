CREATE PROCEDURE udp_happy_hour(type_input VARCHAR(50))
BEGIN
    UPDATE products
        SET price = price - (price * 0.20)
    WHERE price >= 10.00 AND type = type_input;
END;