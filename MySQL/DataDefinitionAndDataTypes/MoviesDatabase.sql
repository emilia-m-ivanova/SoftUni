CREATE DATABASE `movies`;
USE `movies`;

CREATE TABLE `directors`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`director_name` VARCHAR(50) NOT NULL,
`notes` TEXT
);

CREATE TABLE `genres`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(50) NOT NULL,
`notes` TEXT
);

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(50) NOT NULL,
`notes` TEXT
);

CREATE TABLE `movies`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(50) NOT NULL,
`director_id` INT NOT NULL,
`copyright_year` YEAR NOT NULL,
`length` INT NOT NULL,
`genre_id` INT NOT NULL,
`category_id` INT NOT NULL,
`rating` DECIMAL(4,2),
`notes` TEXT
);

ALTER TABLE `movies` 
ADD CONSTRAINT `fk_movies_directors` 
FOREIGN KEY (`director_id`)
REFERENCES `directors` (`id`),
ADD CONSTRAINT `fk_movies_genre` 
FOREIGN KEY (`genre_id`)
REFERENCES `genres` (`id`),
ADD CONSTRAINT `fk_movies_categories` 
FOREIGN KEY (`category_id`)
REFERENCES `categories` (`id`);

INSERT INTO `directors` (`director_name`) VALUES
('Director1'),
('Director2'),
('Director3'),
('Director4'),
('Director5');

INSERT INTO `categories` (`category_name`) VALUES
('Category1'),
('Category2'),
('Category3'),
('Category4'),
('Category5');

INSERT INTO `genres` (`genre_name`) VALUES
('Genre5'),
('Genre4'),
('Genre3'),
('Genre2'),
('Genre1');

INSERT INTO `movies` (`title`,`director_id`,`copyright_year`,`length`,`genre_id`,`category_id`) VALUES
('Movie1',1,1996,90,1,5),
('Movie2',3,2000,95,2,4),
('Movie3',4,1991,120,3,3),
('Movie4',5,1995,90,4,2),
('Movie5',2,1999,90,5,1);