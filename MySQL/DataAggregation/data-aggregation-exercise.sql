USE `gringotts`;

SELECT COUNT(`id`) AS `count` FROM `wizzard_deposits`;

SELECT MAX(`magic_wand_size`) AS `longest_magic_wand` FROM `wizzard_deposits`;

SELECT `deposit_group`, MAX(`magic_wand_size`) AS `longest_magic_wand` 
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `longest_magic_wand`, `deposit_group`;

SELECT `deposit_group`
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY AVG(`magic_wand_size`) 
LIMIT 1;

SELECT `deposit_group`, SUM(`deposit_amount`) AS `total_sum`
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `total_sum`;

SELECT `deposit_group`, SUM(`deposit_amount`) AS `total_sum`
FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
ORDER BY `deposit_group`;

SELECT `deposit_group`, SUM(`deposit_amount`) AS `total_sum`
FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
HAVING `total_sum` < 150000
ORDER BY `total_sum` DESC;

SELECT `deposit_group`, `magic_wand_creator`, MIN(`deposit_charge`)
FROM `wizzard_deposits`
GROUP BY `deposit_group`, `magic_wand_creator`
ORDER BY `magic_wand_creator`,`deposit_group`;

-- 9
SELECT 
CASE 
WHEN `age`<=10 THEN '[0-10]'
WHEN `age`>10 AND `age`<=20 THEN '[11-20]'
WHEN `age`>20 AND `age`<=30 THEN '[21-30]'
WHEN `age`>30 AND `age`<=40 THEN '[31-40]'
WHEN `age`>40 AND `age`<=50 THEN '[41-50]'
WHEN `age`>50 AND `age`<=60 THEN '[51-60]'
ELSE '61+'
END
AS `age_group`, COUNT(*) AS `wizzard_count`
FROM `wizzard_deposits`
GROUP BY `age_group`
ORDER BY `age_group`;

-- 10
SELECT LEFT(`first_name`,1) AS `first_letter`
FROM `wizzard_deposits`
WHERE `deposit_group` = 'Troll Chest'
GROUP BY `first_letter`
ORDER BY `first_letter`;

-- 11
SELECT `deposit_group`, `is_deposit_expired`, AVG(`deposit_interest`) AS `average_interest`
FROM `wizzard_deposits`
WHERE `deposit_start_date` > '1985-01-01'
GROUP BY  `deposit_group`, `is_deposit_expired`
ORDER BY  `deposit_group` DESC, `is_deposit_expired`;

-- 12
SELECT `first_name` AS `host_wizard`, `deposit_amount` AS `host_wizard_deposit`,
 (SELECT `first_name`
 FROM `wizzard_deposits` AS `g1`
 WHERE g1.`id`= h.`id`+1) AS `guest_wizard`,
 (SELECT `deposit_amount`
 FROM `wizzard_deposits`  AS `g2`
 WHERE g2.`id`= h.`id`+1) AS `guest_wizard_deposit`,
 (SELECT h.`deposit_amount` -  g3.`deposit_amount`
  FROM `wizzard_deposits`  AS `g3`
 WHERE g3.`id`= h.`id`+1) AS `difference`
 FROM `wizzard_deposits` AS `h`
 HAVING `guest_wizard` IS NOT NULL;

-- 13
USE `soft_uni`;

SELECT `department_id`, MIN(`salary`) AS `minimum_salary`
FROM `employees`
WHERE `department_id` IN (2,5,7) AND `hire_date` > '2000-01-01'
GROUP BY `department_id`
ORDER BY `department_id`;

-- 14
CREATE TABLE `high_paid`
SELECT * FROM `employees`
WHERE `salary`>30000 AND `manager_id`!= 42;

UPDATE `high_paid`
SET `salary` = `salary` + 5000
WHERE `department_id` = 1;

SELECT `department_id`, AVG(`salary`) AS `avg_salary`
FROM `high_paid`
GROUP BY `department_id`
ORDER BY `department_id`;

-- 15
SELECT `department_id`, MAX(`salary`) AS `max_salary`
FROM `employees`
GROUP BY `department_id`
HAVING 30000 > `max_salary` OR `max_salary` > 70000
ORDER BY `department_id`;

-- 16
SELECT COUNT(`salary`) FROM `employees`
WHERE `manager_id` IS NULL;

-- 17
SELECT `department_id`, 
(SELECT DISTINCT `salary`
FROM `employees` AS e2
WHERE e1.`department_id` = e2.`department_id`
ORDER BY `salary` DESC
LIMIT 2,1) AS `third_highest_salary`
FROM `employees` AS e1
GROUP BY `department_id`
HAVING `third_highest_salary` IS NOT NULL
ORDER BY `department_id`;

-- 18
SELECT `first_name`, `last_name`, `department_id`
FROM `employees` AS e1
WHERE `salary` >
 (SELECT AVG(`salary`) 
 FROM `employees` AS e2
WHERE e1.`department_id` = e2.`department_id`)
ORDER BY `department_id`, `employee_id`
LIMIT 10;

-- 19
SELECT `department_id`, SUM(`salary`) AS `total_salary`
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;