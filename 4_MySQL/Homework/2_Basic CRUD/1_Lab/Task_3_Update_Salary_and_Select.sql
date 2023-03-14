UPDATE employees
set salary = salary + 100
WHERE job_title = 'Manager';

SELECT salary FROM employees;