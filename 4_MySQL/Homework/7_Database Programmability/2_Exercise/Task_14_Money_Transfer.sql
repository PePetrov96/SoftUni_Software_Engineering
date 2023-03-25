CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, money_amount DECIMAL(19,4))
BEGIN
    START TRANSACTION;
    IF (money_amount <= 0
        OR (SELECT `balance`
         FROM accounts AS a
         WHERE a.`id` = from_account_id) < money_amount)
        OR from_account_id = to_account_id
        OR (SELECT COUNT(id) FROM accounts WHERE id = from_account_id) <> 1
        OR (SELECT COUNT(id) FROM accounts WHERE id = to_account_id) <> 1
       THEN
    ROLLBACK;
    ELSE
        UPDATE accounts as ac
        SET ac.balance = ac.balance - money_amount
        WHERE ac.id = from_account_id;
        UPDATE accounts as ac
        SET ac.balance = ac.balance + money_amount
        WHERE ac.id = to_account_id;
        COMMIT;
    END IF;
END;