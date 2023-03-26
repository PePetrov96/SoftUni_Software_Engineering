SELECT CONCAT(last_name, first_name, LENGTH(first_name), 'Restaurant') AS 'username',
       CONCAT(REVERSE(SUBSTR(email, 2, 12))) AS 'passwords'
FROM waiters
WHERE salary IS NOT NULL
ORDER BY passwords DESC;