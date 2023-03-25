CREATE PROCEDURE usp_raise_salary_by_id(id INT(11))
BEGIN
    UPDATE employees
    SET salary = salary * 1.05
    WHERE employee_id = id;
END;