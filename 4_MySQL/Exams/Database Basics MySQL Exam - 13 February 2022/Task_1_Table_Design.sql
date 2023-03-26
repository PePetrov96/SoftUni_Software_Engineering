CREATE TABLE brands(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE categories(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE reviews(
    id INT PRIMARY KEY AUTO_INCREMENT,
    content TEXT,
    rating DECIMAL(10,2) NOT NULL,
    picture_url VARCHAR(80) NOT NULL,
    published_at DATETIME NOT NULL
);

CREATE TABLE products(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    price DECIMAL(19,2) NOT NULL,
    quantity_in_stock INT,
    description TEXT,
    brand_id INT NOT NULL,
    category_id INT NOT NULL,
    review_id INT,
    CONSTRAINT fk_brand_id
        FOREIGN KEY (brand_id)
            REFERENCES brands(id),
    CONSTRAINT fk_category_id
        FOREIGN KEY (category_id)
            REFERENCES categories(id),
    CONSTRAINT fk_review_id
        FOREIGN KEY (review_id)
            REFERENCES reviews(id)
);

CREATE TABLE customers(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    phone VARCHAR(30) NOT NULL UNIQUE,
    address VARCHAR(60) NOT NULL,
    discount_card BIT(1) NOT NULL DEFAULT b'0'
);

CREATE TABLE orders(
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_datetime DATETIME NOT NULL,
    customer_id INT NOT NULL,
    CONSTRAINT fk_customer_id
        FOREIGN KEY (customer_id)
            REFERENCES customers(id)
);

CREATE TABLE orders_products(
    order_id INT,
    product_id INT,
    KEY pk_orders_products (order_id, product_id),
    CONSTRAINT fk_order_id_products
        FOREIGN KEY (order_id)
            REFERENCES orders(id),
    CONSTRAINT fk_product_id_products
        FOREIGN KEY (product_id)
            REFERENCES products(id)
);