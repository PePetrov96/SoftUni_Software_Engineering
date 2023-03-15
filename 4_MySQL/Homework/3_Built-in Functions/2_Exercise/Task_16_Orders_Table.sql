SELECT product_name, order_date,
       ADDDATE(order_date, interval 3 day) AS 'pay_due',
       ADDDATE(order_date, interval 1 month) AS 'deliver_due'
FROM orders;