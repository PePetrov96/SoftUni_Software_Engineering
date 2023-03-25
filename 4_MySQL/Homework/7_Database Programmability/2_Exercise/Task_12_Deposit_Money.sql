CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
    START TRANSACTION;
    IF (money_amount <= 0) THEN
        ROLLBACK;
    ELSE
        UPDATE accounts AS ac
        SET ac.balance = ac.balance + money_amount
        WHERE ac.id = account_id;
    END IF;
END;