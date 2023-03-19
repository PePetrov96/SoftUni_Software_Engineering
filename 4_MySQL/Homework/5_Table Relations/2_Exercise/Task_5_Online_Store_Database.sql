CREATE TABLE cities (
    city_id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE item_types (
    item_type_id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE items (
    item_id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    item_type_id INT(11) NOT NULL,
    CONSTRAINT fk_item_type
        FOREIGN KEY (item_type_id)
            REFERENCES item_types(item_type_id)
);

CREATE TABLE customers (
    customer_id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    birthday DATE,
    city_id INT(11),
    CONSTRAINT fk_customers_city
        FOREIGN KEY (city_id)
            REFERENCES cities(city_id)
);

CREATE TABLE orders (
    order_id INT(11) PRIMARY KEY AUTO_INCREMENT,
    customer_id INT(11) NOT NULL,
    CONSTRAINT fk_customer_order
                    FOREIGN KEY (customer_id)
                    REFERENCES customers(customer_id)
);

CREATE TABLE order_items (
    order_id INT(11) NOT NULL,
    item_id INT(11) NOT NULL,
    CONSTRAINT fk
        PRIMARY KEY (order_id, item_id),
        CONSTRAINT fk_order
            FOREIGN KEY (order_id)
            REFERENCES orders(order_id),
        CONSTRAINT fk_customer
            FOREIGN KEY (item_id)
            REFERENCES items(item_id)
);