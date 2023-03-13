CREATE TABLE `employees` (
  `id` INT AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `categories` (
  `id` INT AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `products` (
  `id` INT AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `category_iD` INT NOT NULL,
  PRIMARY KEY (`id`));