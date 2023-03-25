CREATE PROCEDURE usp_get_towns_starting_with (town_substring VARCHAR(50))
BEGIN
    SELECT name AS 'town_name'
    FROM towns
    WHERE name LIKE CONCAT(town_substring,'%')
    ORDER BY name;
END;