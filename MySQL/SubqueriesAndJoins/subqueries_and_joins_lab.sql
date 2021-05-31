USE `soft_uni`;

-- 1
SELECT e.`employee_id`, CONCAT(e.`first_name`, ' ', e.`last_name`) AS `full_name`,
d.`department_id`, d.`name` AS `department_name`
FROM `departments` AS d
JOIN `employees` AS e
ON e.`employee_id` = d.`manager_id`
ORDER BY e.`employee_id`
LIMIT 5;

-- 2
SELECT t.`town_id`, t.`name` AS `town_name`, a.`address_text`
FROM `towns` AS t
JOIN `addresses` AS a
ON t.`town_id` = a.`town_id`
WHERE t.`name` IN ('San Francisco', 'Sofia', 'Carnation');

-- 3
SELECT `employee_id`, `first_name`, `last_name`, `department_id`, `salary`
FROM `employees`
WHERE `manager_id` IS NULL;

-- 4
SELECT COUNT(*) AS `count`
FROM `employees`
WHERE `salary` > (SELECT AVG(`salary`) FROM `employees`);