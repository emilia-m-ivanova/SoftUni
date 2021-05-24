USE `soft_uni`;

SELECT `first_name`, `last_name` FROM `employees`
WHERE SUBSTRING(`first_name`,1,2) = 'Sa';

SELECT `first_name`, `last_name` FROM `employees`
WHERE `last_name` LIKE '%ei%';

SELECT `first_name` FROM `employees`
WHERE `department_id` IN(3,10) 
AND EXTRACT(YEAR FROM `hire_date`) BETWEEN 1995 AND 2005
ORDER BY `employee_id`;

SELECT `first_name`, `last_name` FROM `employees`
WHERE `job_title` NOT LIKE '%engineer%';

SELECT `name` FROM `towns`
WHERE CHAR_LENGTH(`name`) IN(5,6)
ORDER BY `name`;

SELECT * FROM `towns`
WHERE SUBSTRING(`name`,1,1) IN('M','K','B','E')
ORDER BY `name`;

SELECT * FROM `towns`
WHERE SUBSTRING(`name`,1,1) NOT IN('R','B','D')
ORDER BY `name`;

CREATE VIEW `v_employees_hired_after_2000` AS
SELECT `first_name`, `last_name` FROM `employees`
WHERE EXTRACT(YEAR FROM `hire_date`) > 2000;
SELECT * FROM `v_employees_hired_after_2000`;

SELECT `first_name`, `last_name` FROM `employees`
WHERE CHAR_LENGTH(`last_name`)=5;

USE `geography`;

SELECT `country_name`, `iso_code` FROM `countries`
WHERE `country_name` LIKE '%a%a%a%'
ORDER BY `iso_code`;

SELECT p.`peak_name`, r.`river_name`, LOWER(CONCAT(p.`peak_name`,SUBSTRING(r.`river_name`,2))) AS `mix`
FROM `peaks` AS p, `rivers` AS r
WHERE RIGHT(`peak_name`,1) = LEFT(`river_name`,1)
ORDER BY `mix`;

USE `diablo`;

SELECT `name`, DATE_FORMAT(`start`,'%Y-%m-%d') FROM `games`
WHERE YEAR(`start`) IN(2011, 2012)
ORDER BY `start`,`name`
LIMIT 50;

SELECT `user_name`, SUBSTRING(`email`,LOCATE('@',`email`)+1) AS `Email Provider`
FROM `users`
ORDER BY `Email Provider`,`user_name`;

SELECT `user_name`, `ip_address` FROM `users`
WHERE `ip_address` LIKE '___.1%.%.___' 
ORDER BY `user_name`;

SELECT `name` AS `game`, 
CASE
WHEN HOUR(`start`) BETWEEN 0 AND 11 THEN "Morning"
WHEN HOUR(`start`) BETWEEN 12 AND 17 THEN "Afternoon"
ELSE "Evening"
END
 AS `Part of the Day`, 
CASE
WHEN `duration`<=3 THEN "Extra Short"
WHEN `duration` BETWEEN 3 AND 6 THEN "Short"
WHEN `duration` BETWEEN 6 AND 10 THEN "Long"
ELSE "Extra Long"
END
AS `Duration` 
FROM `games`;

USE `orders`;

SELECT `product_name`, `order_date`, 
DATE_ADD(`order_date`, INTERVAL 3 DAY) AS `deliver_due`,
DATE_ADD(`order_date`, INTERVAL 1 MONTH) AS `pay_due`
FROM `orders`;