CREATE DATABASE `fsd`;

USE `fsd`;

-- 1
CREATE TABLE `countries` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45)
);

CREATE TABLE `towns`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`name` VARCHAR(45) NOT NULL,
`country_id` INT NOT NULL,
CONSTRAINT `fk_towns_countries`
FOREIGN KEY (`country_id`)
REFERENCES `countries`(`id`)
);

CREATE TABLE `stadiums`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45),
`capacity` INT,
`town_id` INT,
CONSTRAINT `fk_stadiums_towns`
FOREIGN KEY (`town_id`)
REFERENCES `towns`(`id`)
);

CREATE TABLE `teams`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`name` VARCHAR(45) NOT NULL,
`established` DATE NOT NULL,
`fan_base` BIGINT(20) NOT NULL,
`stadium_id` INT NOT NULL,
CONSTRAINT `fk_teams_stadiums`
FOREIGN KEY (`stadium_id`)
REFERENCES `stadiums`(`id`)
);

CREATE TABLE `skills_data`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`dribbling` INT,
`pace` INT,
`passing` INT,
`shooting` INT,
`speed` INT,
`strength` INT
);

CREATE TABLE `players`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`first_name` VARCHAR(10) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`age` INT NOT NULL,
`position` CHAR(1) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL,
`hire_date` DATETIME,
`skills_data_id` INT  NOT NULL,
`team_id` INT,
CONSTRAINT `fk_players_skills_data`
FOREIGN KEY (`skills_data_id`)
REFERENCES `skills_data`(`id`),

CONSTRAINT `fk_players_teams`
FOREIGN KEY (`team_id`)
REFERENCES `teams`(`id`)
);

CREATE TABLE `coaches`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`first_name` VARCHAR(10) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL DEFAULT 0,
`coach_level` INT
);

CREATE TABLE `players_coaches`(
`player_id` INT,
`coach_id` INT,

CONSTRAINT `players_coaches_players`
FOREIGN KEY (`player_id`)
REFERENCES `players`(`id`),

CONSTRAINT `players_coaches_coaches`
FOREIGN KEY (`coach_id`)
REFERENCES `coaches`(`id`)
);

-- 2
INSERT INTO `coaches`(`first_name`,`last_name`,`salary`,`coach_level`) (
	(SELECT `first_name`,`last_name`,`salary` * 2, CHAR_LENGTH(`first_name`) 
    FROM `players`
    WHERE `age` >= 45)
);

-- 3
UPDATE `coaches` AS c
JOIN `players_coaches` AS pc
ON c.`id` = pc.`coach_id`
SET `coach_level` = `coach_level` + 1
WHERE LEFT(c.`first_name`,1) = 'A';

-- 4
DELETE FROM `players`
WHERE `age` >= 45;

-- 5
SELECT `first_name`, `age`, `salary`
FROM `players`
ORDER BY `salary` DESC;

-- 6
SELECT p.`id`, CONCAT(`first_name`,' ', `last_name`) AS `full_name`, 
`age`, `position`, `hire_date`
FROM `players` AS p
JOIN `skills_data` AS s
ON p.`skills_data_id` = s.`id`
WHERE `position` = 'A' AND `age` < 23 AND
`hire_date` IS NULL AND `strength` > 50
ORDER BY `salary`,`age`;

-- 7
SELECT t.`name` AS `team_name`, t.`established`, t.`fan_base`,
COUNT(p.`id`) AS `players_count`
FROM `teams` AS t
LEFT JOIN `players` AS p
ON p.`team_id` = t.`id`
GROUP BY t.`id`
ORDER BY `players_count` DESC, `fan_base` DESC;

-- 8
SELECT MAX(s.`speed`) AS `max_speed`, 
t.`name` AS `town_name`
FROM `players` AS p
RIGHT JOIN `skills_data` AS s
ON p.`skills_data_id` = s.`id`
RIGHT JOIN `teams` AS teams
ON p.`team_id` = teams.`id`
RIGHT JOIN `stadiums` AS st
ON teams.`stadium_id` = st.`id`
RIGHT JOIN `towns` AS t
ON st.`town_id` = t.`id`
WHERE teams.`name` != 'Devify'
GROUP BY t.`id`
ORDER BY `max_speed` DESC, `town_name`;

-- 9
SELECT c.`name`, COUNT(p.`id`) AS `total_count_of_players`,
SUM(p.`salary`) AS `total_sum_of_salaries` 
FROM `players` AS p
RIGHT JOIN `teams` AS t
ON p.`team_id` = t.`id`
RIGHT JOIN `stadiums` AS s
ON t.`stadium_id` = s.`id`
RIGHT JOIN `towns` AS tn
ON s.`town_id` = tn.`id`
RIGHT JOIN `countries` AS c
ON tn.`country_id` = c.`id`
GROUP BY c.`name`
ORDER BY `total_count_of_players` DESC, c.`name`;

-- 10
DELIMITER $$
CREATE FUNCTION `udf_stadium_players_count` (stadium_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(p.`id`) FROM `players` AS p
JOIN `teams` AS t
ON p.`team_id` = t.`id` 
JOIN `stadiums` AS s
ON t.`stadium_id` = s.`id` 
WHERE s.`name` = stadium_name);
END$$

SELECT udf_stadium_players_count ('Jaxworks') as `count`$$
SELECT udf_stadium_players_count ('Linklinks') as `count`$$

-- 11
CREATE PROCEDURE `udp_find_playmaker`(`min_dribble_points` INT, `team_name` VARCHAR(45))
BEGIN
SELECT CONCAT(p.`first_name`, ' ', p.`last_name`) AS `full_name`, p.`age`, 
p.`salary`, sd.`dribbling`, sd.`speed`, t.`name` AS `team_name`
FROM `players` AS p
LEFT JOIN `skills_data` AS sd
ON p.`skills_data_id` = sd.`id`
LEFT JOIN `teams` AS t
ON p.`team_id` = t.`id`
WHERE sd.`dribbling` > `min_dribble_points` AND t.`name` = `team_name` AND
sd.`speed` > (SELECT AVG(`speed`) FROM `skills_data`)
ORDER BY sd.`speed` DESC
LIMIT 1;
END$$

CALL `udp_find_playmaker`(20, 'Skyble')$$