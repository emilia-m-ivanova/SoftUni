CREATE DATABASE `table_relations_exercise`;

USE `table_relations_exercise`;

-- 1
CREATE TABLE `passports`(
`passport_id` INT PRIMARY KEY,
`passport_number` VARCHAR(10) UNIQUE NOT NULL
);

CREATE TABLE `people`(
`person_id`INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`salary` DECIMAL(10,2),
`passport_id` INT UNIQUE,
CONSTRAINT `fk_people_passports`
FOREIGN KEY (`passport_id`)
REFERENCES `passports`(`passport_id`)
);

INSERT INTO `passports` VALUES
(101, 'N34FG21B'),
(102, 'K65LO4R7'),
(103, 'ZE657QP2');

INSERT INTO `people` VALUES
(1, 'Roberto', 43300.00, 102),
(2, 'Tom', 56100.00, 103),
(3, 'Yana', 60200.00, 101);

-- 2
CREATE TABLE `manufacturers`(
`manufacturer_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) UNIQUE NOT NULL,
`established_on` DATE
);

CREATE TABLE `models`(
`model_id` INT PRIMARY KEY,
`name` VARCHAR(40) UNIQUE NOT NULL,
`manufacturer_id` INT,
CONSTRAINT `fk_models_manufacturers`
FOREIGN KEY (`manufacturer_id`)
REFERENCES `manufacturers`(`manufacturer_id`)
);

INSERT INTO `manufacturers` VALUES
(1,'BMW', '1916-03-01'),
(2, 'Tesla', '2003-01-01'),
(3, 'Lada', '1966-05-01');

INSERT INTO `models` VALUES
(101, 'X1', 1),
(102, 'i6', 1),
(103, 'Model S', 2),
(104, 'Model X', 2),
(105, 'Model 3', 2),
(106, 'Nova', 3);

-- 3
CREATE TABLE `exams`(
`exam_id` INT PRIMARY KEY,
`name` VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE `students`(
`student_id` INT PRIMARY KEY,
`name` VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE `students_exams`(
`student_id` INT NOT NULL,
CONSTRAINT `fk_students_exams_students`
FOREIGN KEY (`student_id`)
REFERENCES `students`(`student_id`),
`exam_id` INT NOT NULL,
CONSTRAINT `fk_students_exams_exams`
FOREIGN KEY (`exam_id`)
REFERENCES `exams`(`exam_id`),
CONSTRAINT `pk_students_exams`
PRIMARY KEY (`student_id`,`exam_id`)
);

INSERT INTO `exams` VALUES
(101, 'Spring MVC'),
(102, 'Neo4j'),
(103, 'Oracle 11g');

INSERT INTO `students` VALUES
(1, 'Mila'),                                      
(2, 'Toni'),
(3, 'Ron');

INSERT INTO `students_exams` VALUES
(1, 101),
(1, 102),
(2, 101),
(3, 103),
(2, 102),
(2, 103);

-- 4
CREATE TABLE `teachers`(
`teacher_id` INT PRIMARY KEY,
`name` VARCHAR(50),
`manager_id` INT,
CONSTRAINT `fk_teachers_techers`
FOREIGN KEY (`manager_id`)
REFERENCES `teachers`(`teacher_id`)
);

INSERT INTO `teachers` VALUES
(101, 'John', NULL),
(106, 'Greta', 101),
(105, 'Mark', 101),
(104, 'Ted', 105),
(102, 'Maya', 106),
(103, 'Silvia', 106);

-- 9
USE `geography`;

SELECT m.`mountain_range`, p.`peak_name`, p.`elevation` AS `peak_elevation`
FROM `mountains` AS m
JOIN `peaks` AS p
ON m.`id` = p.`mountain_id`
WHERE `mountain_range` = 'Rila'
ORDER BY `peak_elevation` DESC;
