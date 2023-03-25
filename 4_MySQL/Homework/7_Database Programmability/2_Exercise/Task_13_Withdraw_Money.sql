CREATE PROCEDURE usp_withdraw_money(account_id int, money_amount decimal(19,4))
BEGIN
    START TRANSACTION;
    IF (money_amount <= 0 OR
        (SELECT `balance`
         FROM accounts AS a
         WHERE a.`id` = account_id) < money_amount) THEN
    ROLLBACK;
    ELSE
        UPDATE accounts as ac SET ac.balance = ac.balance - money_amount
        WHERE ac.id = account_id;
        COMMIT;
    END IF;
END;