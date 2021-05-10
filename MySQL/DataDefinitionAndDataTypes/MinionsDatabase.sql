CREATE DATABASE `minions`;
USE `minions`;

CREATE TABLE `minions` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (50) NOT NULL,
`age` INT
);

CREATE TABLE `towns` (
`town_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (50) NOT NULL 
);

ALTER TABLE `towns` 
RENAME COLUMN `town_id` TO `id`;

ALTER TABLE `minions` 
ADD COLUMN `town_id` INT NOT NULL, 
ADD CONSTRAINT `fk_town_id` 
FOREIGN KEY (`town_id`)
REFERENCES `towns` (`id`);

INSERT INTO `towns`(`name`) VALUES 
('Sofia'),
('Plovdiv'),
('Varna');

INSERT INTO `minions` (`name`,`age`,`town_id`) VALUES
('Kevin',22,1),
('Bob', 15, 3),
('Steward',NULL,2);

TRUNCATE TABLE `minions`;

DROP TABLE `minions`;
DROP TABLE `towns`;

CREATE TABLE `people` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` DECIMAL(3,2),
`weight` DECIMAL(5,2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT
);

INSERT INTO `people`(`name`,`height`,`gender`,`birthdate`) VALUES 
('First',1.6,'f','1996-04-01'),
('Second',1.7,'f','1996-12-01'),
('Third',1.8,'m','1998-04-10'),
('Fourth',1.85,'m','2000-04-01'),
('Fifth',1.87,'m','1994-05-01');

CREATE TABLE `users` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) UNIQUE NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time`DATETIME,
`is_deleted` BOOLEAN
);

INSERT INTO `users` (`username`, `password`, `is_deleted`) VALUES
('First', 'Password', true),
('Second', 'Pa$$word', true),
('Third', 'P@ssword', false),
('Fourth', 'Passw0rd', false),
('Fifth', '5assword', true);

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT `pk_users` PRIMARY KEY (`id`,`username`);

ALTER TABLE `users`
MODIFY `last_login_time` DATETIME DEFAULT NOW();

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD PRIMARY KEY `pk_users` (`id`);