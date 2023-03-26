INSERT INTO reviews(content, rating, picture_url, published_at)
SELECT LEFT(p.description, 15),
       (p.price / 8),
       REVERSE(p.name),
       DATE('2010/10/10')
FROM products AS p
WHERE p.id >= 5;