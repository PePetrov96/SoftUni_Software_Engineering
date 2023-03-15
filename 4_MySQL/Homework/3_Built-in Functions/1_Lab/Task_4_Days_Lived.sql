SELECT CONCAT_WS(' ', first_name, last_name) AS 'Full Name',
       TIMESTAMPDIFF(DAY, born, died)
FROM authors;