CREATE DATABASE `car_rental`;
USE `car_rental`;

CREATE TABLE `categories`(
`id` INT AUTO_INCREMENT PRIMARY KEY, 
`category` VARCHAR(50) NOT NULL, 
`daily_rate` DECIMAL(4,2), 
`weekly_rate` DECIMAL(4,2), 
`monthly_rate` DECIMAL(4,2), 
`weekend_rate` DECIMAL(4,2)
);
CREATE TABLE `cars` (
`id`INT AUTO_INCREMENT PRIMARY KEY, 
`plate_number` VARCHAR(50) NOT NULL, 
`make` VARCHAR(50), 
`model` VARCHAR(50), 
`car_year` YEAR, 
`category_id` INT NOT NULL, 
`doors` INT, 
`picture` BLOB, 
`car_condition` VARCHAR(50), 
`available` BOOLEAN NOT NULL
);

CREATE TABLE `employees` (
`id`INT AUTO_INCREMENT PRIMARY KEY, 
`first_name`VARCHAR(50) NOT NULL, 
`last_name`VARCHAR(50) NOT NULL, 
`title` VARCHAR(50) NOT NULL, 
`notes` TEXT
);

CREATE TABLE `customers` (
`id` INT AUTO_INCREMENT PRIMARY KEY, 
`driver_licence_number` VARCHAR(50) , 
`full_name` VARCHAR(50) NOT NULL, 
`address` VARCHAR(50), 
`city` VARCHAR(50), 
`zip_code` VARCHAR(50), 
`notes` TEXT
);

CREATE TABLE `rental_orders` (
`id`INT AUTO_INCREMENT PRIMARY KEY, 
`employee_id` INT NOT NULL, 
`customer_id` INT NOT NULL, 
`car_id` INT NOT NULL, 
`car_condition` VARCHAR(50), 
`tank_level` INT, 
`kilometrage_start` INT, 
`kilometrage_end` INT, 
`total_kilometrage` INT, 
`start_date` DATE, 
`end_date` DATE, 
`total_days` INT, 
`rate_applied` DECIMAL(4,2), 
`tax_rate`DECIMAL(4,2), 
`order_status` VARCHAR(50), 
`notes` TEXT
);

INSERT INTO `categories`(`category`) VALUES
('Category1'),
('Category2'),
('Category3');

INSERT INTO `cars`(`plate_number`,`category_id`, `available`) VALUES
('Plate1',1,true),
('Plate2',2,false),
('Plate3',3,true);

INSERT INTO `employees`(`first_name`,`last_name`, `title`) VALUES
('Emi','Ivanova','Employee1'),
('Emi','Mincheva','Employee2'),
('Emili','Ivanova','Employee3');

INSERT INTO `customers`(`full_name`) VALUES
('Customer1'),
('Customer2'),
('Customer3');

INSERT INTO `rental_orders`(`employee_id`,`customer_id`, `car_id`) VALUES
(1,2,3),
(2,3,1),
(3,1,2);