USE `camp`;
 -- 1
CREATE TABLE `mountains`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (50)
);
CREATE TABLE `peaks`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (50),
`mountain_id` INT,
CONSTRAINT `fk_peaks_mountains`
FOREIGN KEY (`mountain_id`) 
REFERENCES `mountains`(`id`)
);

-- 2
SELECT v.`driver_id`, v.`vehicle_type`, 
CONCAT(c.`first_name`, ' ', c.`last_name`) AS `driver_name`
FROM `campers` AS c
JOIN `vehicles` AS v ON
c.`id` = v.`driver_id`;

-- 3
SELECT r.`starting_point` AS `route_starting_point`, 
r.`end_point` AS `route_ending_point`, r.`leader_id`,
CONCAT(c.`first_name`, ' ', c.`last_name`) AS `leader_name`
FROM `campers` AS c
JOIN `routes` AS r ON
c.`id` = r.`leader_id`;

-- 4
DROP TABLE `peaks`;
DROP TABLE `mountains`;
CREATE TABLE `mountains`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (50)
);
CREATE TABLE `peaks`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (50),
`mountain_id` INT,
CONSTRAINT `fk_peaks_mountains`
FOREIGN KEY (`mountain_id`) 
REFERENCES `mountains`(`id`)
ON DELETE CASCADE
);

-- 5
CREATE TABLE `clients`(
`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`client_name` VARCHAR(100)
);

CREATE TABLE `employees`(
`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30),
`last_name` VARCHAR(30),
`project_id` INT(11) UNIQUE
);

CREATE TABLE `projects`(
`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`client_id` INT(11),
CONSTRAINT `fk_projects_clients`
FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`),
`project_lead_id` INT(11),
CONSTRAINT `fk_projects_employees`
FOREIGN KEY (`project_lead_id`)
REFERENCES `employees`(`id`)
);

ALTER TABLE `employees`
ADD CONSTRAINT `fk_employees_projects`
FOREIGN KEY (`project_id`)
REFERENCES `projects`(`id`);
