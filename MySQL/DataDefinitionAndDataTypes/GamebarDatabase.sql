CREATE DATABASE `gamebar`;
USE gamebar;
CREATE TABLE `employees` (
    `id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL
);
CREATE TABLE `categories` (
    `id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL
);
CREATE TABLE `products` (
    `id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `category_id` INT NOT NULL
);

INSERT INTO `employees` (`first_name`,`last_name`) VALUES
('Test1','Test1'),
('Test2','Test2'),
('Test3','Test3');

ALTER TABLE `employees` 
ADD COLUMN `middle_name` VARCHAR(50) NOT NULL DEFAULT '';

ALTER TABLE `products`
ADD CONSTRAINT `fk_category_id`
FOREIGN KEY (`category_id`)
REFERENCES `categories` (`id`)
ON DELETE RESTRICT
ON UPDATE CASCADE;

ALTER TABLE `employees`
MODIFY COLUMN `middle_name` VARCHAR(100);
