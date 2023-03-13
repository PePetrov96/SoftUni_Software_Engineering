CREATE TABLE people (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    picture MEDIUMBLOB,
    height DOUBLE(50, 2),
    weight DOUBLE(50, 2),
    gender CHAR(1) NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT
);

INSERT INTO people (`name`, `gender`, `birthdate`)
VALUES ('Ivan', 'm', '1996-03-03'),
       ('Kiro', 'm', '1995-02-01'),
       ('Misho', 'm', '1998-05-21'),
       ('Gosho', 'm', '1993-03-03'),
       ('Iva', 'f', '1991-02-01');