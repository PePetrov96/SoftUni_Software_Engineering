CREATE PROCEDURE udp_reduce_price(category_name VARCHAR(40))
BEGIN
    UPDATE products AS p
    JOIN categories AS c
        ON c.id = p.category_id
    JOIN reviews AS r
        ON p.review_id = r.id
    SET p.price = p.price - (p.price * 0.30)
    WHERE r.rating < 4 AND c.name = category_name;
END;