CREATE TABLE mountains (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE peaks (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    mountain_id INT,
    CONSTRAINT mountain_id
        FOREIGN KEY (mountain_id)
            REFERENCES mountains(id)
            ON DELETE CASCADE
);