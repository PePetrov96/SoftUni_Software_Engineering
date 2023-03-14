CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(26) NOT NULL,
    profile_picture MEDIUMBLOB,
    last_login_time TIME,
    is_deleted BOOLEAN NOT NULL
);

INSERT INTO users (username, password, is_deleted)
VALUES ('pepetrov96', '1234', false),
       ('ivivanov65', '1234', false),
       ('gogoshov93', '1234', false),
       ('krasstamatov78', '1234', false),
       ('kikirivol74', '1234', false);