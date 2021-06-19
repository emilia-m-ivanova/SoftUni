CREATE DATABASE `softuni_stores_system`;
USE `softuni_stores_system`;

CREATE TABLE `pictures`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`url` VARCHAR(100) NOT NULL,
`added_on` DATETIME NOT NULL
);

CREATE TABLE `categories`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(40) UNIQUE NOT NULL
);

CREATE TABLE `products`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(40) UNIQUE NOT NULL,
`best_before` DATE,
`price` DECIMAL(10,2) NOT NULL,
`description` TEXT,
`category_id` INT NOT NULL,
`picture_id` INT NOT NULL,
CONSTRAINT `fk_products_categories`
FOREIGN KEY(`category_id`)
REFERENCES `categories`(`id`),
CONSTRAINT `fk_products_pictures`
FOREIGN KEY(`picture_id`)
REFERENCES `pictures`(`id`)
);

CREATE TABLE `towns`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE `addresses`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50) UNIQUE NOT NULL,
`town_id` INT NOT NULL,
CONSTRAINT `fk_addresses_towns`
FOREIGN KEY(`town_id`)
REFERENCES `towns`(`id`)
);

CREATE TABLE `stores`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(20) UNIQUE NOT NULL,
`rating` FLOAT NOT NULL,
`has_parking` TINYINT(1) DEFAULT 0,
`address_id` INT NOT NULL,
CONSTRAINT `fk_stores_adresses`
FOREIGN KEY(`address_id`)
REFERENCES `addresses`(`id`)
);

CREATE TABLE `products_stores`(
`product_id` INT NOT NULL,
`store_id` INT NOT NULL,
CONSTRAINT `pk_products_stores`
PRIMARY KEY (`product_id`,`store_id`),
CONSTRAINT `fk_products_stores_products`
FOREIGN KEY(`product_id`)
REFERENCES `products`(`id`),
CONSTRAINT `fk_products_stores_stores`
FOREIGN KEY(`store_id`)
REFERENCES `stores`(`id`)
);

CREATE TABLE `employees`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR(15) NOT NULL,
`middle_name` CHAR(1),
`last_name` VARCHAR(20) NOT NULL,
`salary` DECIMAL(19,2) DEFAULT 0,
`hire_date` DATE NOT NULL,
`manager_id` INT,
`store_id` INT NOT NULL,
CONSTRAINT `fk_employees_managers`
FOREIGN KEY(`manager_id`)
REFERENCES `employees`(`id`),
CONSTRAINT `fk_employees_stores`
FOREIGN KEY(`store_id`)
REFERENCES `stores`(`id`)
);

-- 2
INSERT INTO `products_stores` (
SELECT p.`id`, 1
FROM `products` AS p
LEFT JOIN `products_stores` AS ps
ON p.`id` = ps.`product_id`
WHERE ps.`store_id` IS NULL);

-- 3
UPDATE `employees`
SET `manager_id` = 3, `salary` = `salary` - 500
WHERE `hire_date` > '2003-12-01' AND `store_id` NOT IN (5,14);

-- 4
DELETE FROM `employees`
WHERE `salary` > 6000 and `manager_id` IS NOT NULL;

-- 5
SELECT `first_name`, `middle_name`, `last_name`, `salary`, `hire_date`
FROM `employees`
ORDER BY `hire_date` DESC;

-- 6
SELECT pr.`name` AS `product_name`, pr.`price`, pr.`best_before`,
CONCAT(LEFT(pr.`description`,10), '...') AS `short_description`, pi.`url`
FROM `products` AS pr
JOIN `pictures` AS pi
ON pr.`picture_id` = pi.`id`
WHERE LENGTH(`description`) > 100 AND pi.`added_on` < '2019-01-01' AND pr.`price` > 20
ORDER BY pr.`price` DESC;

-- 7
SELECT s.`name`, COUNT(ps.`product_id`) AS `product_count`, 
ROUND(AVG(p.`price`),2) AS `avg`
FROM `stores` AS s
LEFT JOIN `products_stores` AS ps
ON s.`id` = ps.`store_id`
LEFT JOIN `products` AS p
ON p.`id` = ps.`product_id`
GROUP BY s.`id`
ORDER BY `product_count` DESC, `avg` DESC, s.`id`;

-- 8
SELECT CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS `Full_name`,
s.`name` AS `Store_name`, a.`name` AS `address`, e.`salary` 
FROM `employees` AS e
JOIN `stores` AS s
ON e.`store_id` = s.`id`
JOIN `addresses` AS a 
ON s.`address_id` = a.`id`
WHERE e.`salary` < 4000 AND (a.`name` REGEXP('[5]+'))
AND LENGTH(s.`name`) > 8 AND (RIGHT(e.`last_name`,1) = 'n');

-- 9
SELECT REVERSE(s.`name`) AS `reversed_name`, 
CONCAT_WS('-', UPPER(t.`name`), a.`name`) AS `full_address`,
COUNT(e.`id`) AS `employees_count`
FROM `employees` AS e
JOIN `stores` AS s
ON s.`id` = e.`store_id`
JOIN `addresses` AS a
ON a.`id` = s.`address_id`
JOIN `towns` AS t
ON t.`id` = a.`town_id`
GROUP BY s.`id`
ORDER BY `full_address` ASC;

-- 10
DELIMITER $$
CREATE FUNCTION `udf_top_paid_employee_by_store`(store_name VARCHAR(50))
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
	RETURN(SELECT CONCAT(e.`first_name`, ' ', e.`middle_name`, '. ',  e.`last_name`, 
    ' works in store for ', TIMESTAMPDIFF(year, e.`hire_date`, '2020-10-18') , ' years')
    FROM `employees` e, `stores` s
    WHERE e.`store_id` = s.`id` AND s.`name` = store_name
    ORDER BY e.`salary` DESC
    LIMIT 1);
END$$

SELECT udf_top_paid_employee_by_store('Stronghold') as 'full_info'$$

-- 11
CREATE PROCEDURE `udp_update_product_price`(address_name VARCHAR (50))
BEGIN
DECLARE `price_increase` INT;
	IF LEFT(address_name, 1) = '0' THEN 
    SET `price_increase` = 100;
    ELSE SET `price_increase` = 200;
    END IF;
    
UPDATE `products`
SET `price` = `price` + `price_increase`
WHERE `id` IN (
	SELECT ps.`product_id` FROM `products_stores` ps
	JOIN `stores` s
	ON s.`id` = ps.`store_id`
	JOIN `addresses` a 
	ON a.`id` = s.`address_id`
	WHERE a.`name` = address_name
    );
END$$

CALL udp_update_product_price('07 Armistice Parkway')$$
SELECT name, price FROM products WHERE id = 15$$

CALL udp_update_product_price('1 Cody Pass')$$
SELECT name, price FROM products WHERE id = 17$$


