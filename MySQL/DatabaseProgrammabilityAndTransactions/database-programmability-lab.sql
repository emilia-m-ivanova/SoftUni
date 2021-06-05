USE `soft_uni`;

-- 1
DElIMITER $$
CREATE FUNCTION `ufn_count_employees_by_town`(`town_name` VARCHAR(50)) 
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE `e_count` INT;
	SET `e_count`:= (SELECT COUNT(*) FROM `employees` AS e
    JOIN `addresses` AS a
    ON e.`address_id` = a.`address_id`
    
    JOIN `towns` AS t
    ON t.`town_id` = a.`town_id`
    
    WHERE t.`name` = `town_name`);
    RETURN `e_count`;
END$$

SELECT `ufn_count_employees_by_town`('Sofia') AS `count`$$

-- 2
DROP PROCEDURE IF EXISTS `usp_raise_salaries`$$
CREATE PROCEDURE `usp_raise_salaries`(`department_name` VARCHAR(50))
BEGIN
	UPDATE `employees` AS e
    JOIN `departments`  AS d
    USING (`department_id`)
    SET `salary` = `salary` * 1.05
    WHERE d.`name` = `department_name`;
END$$

CALL `usp_raise_salaries`('Finance')$$

SELECT e.`first_name`, e.`salary` 
FROM `employees` AS e
JOIN `departments` AS d
USING (`department_id`)
WHERE d.`name` = 'Finance'
ORDER BY e.`first_name`, e.`salary`$$

-- 3
DROP PROCEDURE IF EXISTS `usp_raise_salary_by_id`$$
CREATE PROCEDURE `usp_raise_salary_by_id`(`id` INT)
BEGIN
	UPDATE `employees` 
    SET `salary` = `salary` * 1.05
    WHERE `employee_id` = `id`;
END$$

CALL `usp_raise_salary_by_id`(178)$$

SELECT `salary` FROM `employees`
WHERE `employee_id` = 178$$

-- 4
CREATE TABLE `deleted_employees`(
`employee_id` INT PRIMARY KEY, 
`first_name` VARCHAR(50),
`last_name` VARCHAR(50),
`middle_name` VARCHAR(50),
`job_title` VARCHAR(50),
`deparment_id` INT,
`salary` DECIMAL(10,2)
)$$

CREATE TRIGGER `tr_deleted_employees`
AFTER DELETE
ON `employees`
FOR EACH ROW
BEGIN
	INSERT INTO `deleted_employees` VALUES(
    OLD.`employee_id`,
    OLD.`first_name`,
	OLD.`last_name`,
	OLD.`middle_name`,
	OLD.`job_title`,
	OLD.`department_id`,
	OLD.`salary`
    );
END$$

DELETE FROM `employees`
WHERE `employee_id` = 2;