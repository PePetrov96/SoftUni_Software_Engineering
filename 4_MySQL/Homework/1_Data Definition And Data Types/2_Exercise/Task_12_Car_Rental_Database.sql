CREATE TABLE categories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    category VARCHAR(30),
    daily_rate DOUBLE,
    weekly_rate DOUBLE,
    monthly_rate DOUBLE,
    weekend_rate DOUBLE
);

INSERT INTO categories (category)
VALUES ('Test1'),
       ('Test2'),
       ('Test3');

CREATE TABLE cars (
    id INT PRIMARY KEY AUTO_INCREMENT,
    plate_number INT,
    make VARCHAR(40),
    model VARCHAR(40),
    car_year YEAR,
    category_id INT,
    doors SMALLINT,
    picture BLOB,
    car_condition TEXT,
    available BOOLEAN
);

INSERT INTO cars (plate_number, make, available)
VALUES ('1234', 'BMW', true),
       ('2345', 'Audi', true),
       ('3454', 'VW', false);

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40),
    last_name VARCHAR(40),
    title VARCHAR(40),
    notes TEXT
);

INSERT INTO employees (first_name, last_name)
VALUES ('Test1', 'Test1'),
       ('Test2', 'Test2'),
       ('Test3', 'Test3');

CREATE TABLE customers (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    driver_licence_number VARCHAR(40),
    full_name VARCHAR(40),
    address VARCHAR(40),
    city VARCHAR(40),
    zip_code VARCHAR(40),
    notes TEXT
);

INSERT INTO customers (driver_licence_number, full_name)
VALUES ('123asd', 'Test Test Test'),
       ('843rtg', 'Test Test Test'),
       ('235prl', 'Test Test Test');

CREATE TABLE rental_orders (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    employee_id INT,
    customer_id INT,
    car_id INT,
    car_condition TEXT,
    tank_level DOUBLE,
    kilometrage_start DOUBLE,
    kilometrage_end DOUBLE,
    total_kilometrage DOUBLE,
    start_date DATE,
    end_date DATE,
    total_days INT,
    rate_applied DOUBLE,
    tax_rate DOUBLE,
    order_status VARCHAR(40),
    notes TEXT
);

INSERT INTO rental_orders (order_status)
VALUES ('shipped'),
       ('shipped'),
       ('preparing to ship');