CREATE TABLE directors (
    id INT PRIMARY KEY AUTO_INCREMENT,
    director_name VARCHAR(50) NOT NULL,
    notes TEXT
);

INSERT INTO directors (director_name, notes)
VALUES ('Test1', 'test1'),
       ('Test2', 'test2'),
       ('Test3', 'test3'),
       ('Test4', 'test4'),
       ('Test5', 'test5');

CREATE TABLE `genres` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    genre_name VARCHAR(50) NOT NULL,
    notes TEXT
);

INSERT INTO genres (genre_name, notes)
VALUES ('Test1', 'test1'),
       ('Test2', 'test2'),
       ('Test3', 'test3'),
       ('Test4', 'test4'),
       ('Test5', 'test5');

CREATE TABLE `categories` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(50) NOT NULL,
    notes TEXT
);

INSERT INTO categories (category_name, notes)
VALUES ('Test1', 'test1'),
       ('Test2', 'test2'),
       ('Test3', 'test3'),
       ('Test4', 'test4'),
       ('Test5', 'test5');

CREATE TABLE `movies` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    director_id INT,
    copyright_year YEAR,
    length TIME,
    genre_id INT,
    category_id INT,
    rating DOUBLE,
    notes TEXT
);

INSERT INTO movies (title)
VALUES ('Test1'),
       ('Test2'),
       ('Test3'),
       ('Test4'),
       ('Test5');