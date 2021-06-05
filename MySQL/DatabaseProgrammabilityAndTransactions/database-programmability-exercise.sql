USE `soft_uni`;

DElIMITER $$
-- 1
CREATE PROCEDURE `usp_get_employees_salary_above_35000`()
BEGIN
	SELECT `first_name`, `last_name`
    FROM `employees`
    WHERE `salary` > 35000
    ORDER BY `first_name`, `last_name`;
END$$

CALL `usp_get_employees_salary_above_35000`$$

-- 2
CREATE PROCEDURE `usp_get_employees_salary_above`(`salary_param` DECIMAL(10,4))
BEGIN
	SELECT `first_name`, `last_name`
    FROM `employees`
    WHERE `salary` >= `salary_param`
    ORDER BY `first_name`, `last_name`;
END$$

CALL `usp_get_employees_salary_above`(45000)$$

-- 3
CREATE PROCEDURE `usp_get_towns_starting_with`(`starts_with_param` VARCHAR(30))
BEGIN
	SELECT `name` AS `town_name`
    FROM `towns`
    WHERE LEFT(LOWER(`name`), length(`starts_with_param`)) = LOWER(`starts_with_param`)
    ORDER BY `name`;
END$$

CALL `usp_get_towns_starting_with`('b')$$

-- 4
CREATE PROCEDURE `usp_get_employees_from_town`(`town_name_param` VARCHAR(30))
BEGIN
	SELECT e.`first_name`, e.`last_name`
    FROM `employees` AS e
    JOIN `addresses` USING (`address_id`)
    JOIN `towns` AS t USING(`town_id`)
    WHERE t.`name` = `town_name_param`
    ORDER BY e.`first_name`, e.`last_name`, e.`employee_id`;
END$$

CALL `usp_get_employees_from_town`('Sofia')$$

-- 5
CREATE FUNCTION `ufn_get_salary_level`(`salary_param` DECIMAL(10,2))
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
	RETURN (CASE
		WHEN `salary_param` < 30000 THEN 'Low'
		WHEN `salary_param` BETWEEN 30000 AND 50000 THEN 'Average'
		ELSE 'High'
    END);
END$$

SELECT `ufn_get_salary_level`(70000)$$

-- 6
CREATE PROCEDURE `usp_get_employees_by_salary_level`(`salary_level` VARCHAR(10))
	BEGIN
    SELECT `first_name`, `last_name`
    FROM `employees`
    WHERE `ufn_get_salary_level`(`salary`) = `salary_level`
    ORDER BY `first_name` DESC, `last_name` DESC;
    END$$

CALL `usp_get_employees_by_salary_level`('High')$$

-- 7
CREATE FUNCTION `ufn_is_word_comprised`(`set_of_letters` VARCHAR(50), `word` VARCHAR(50))
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
	RETURN `word` REGEXP (concat('^[', set_of_letters, ']+$'));
END$$

SELECT ufn_is_word_comprised('oistmiahf', 'Sofia')$$
SELECT ufn_is_word_comprised('bob', 'Rob')$$

-- 8
CREATE PROCEDURE `usp_get_holders_full_name`()
BEGIN
	SELECT CONCAT(`first_name`, ' ', `last_name`) AS `full_name`
    FROM `account_holders`
    ORDER BY `full_name`, `id`;
END$$

CALL `usp_get_holders_full_name`$$

-- 9
CREATE PROCEDURE `usp_get_holders_with_balance_higher_than`(`sum_param` DEC(12,2))
BEGIN
	SELECT `first_name`, `last_name` 
    FROM `account_holders` AS p
    JOIN `accounts` AS a
    ON p.`id` = a.`account_holder_id`
    GROUP BY a.`account_holder_id`
    HAVING SUM(a.`balance`) > `sum_param`
    ORDER BY a.`account_holder_id`;
END$$

CALL `usp_get_holders_with_balance_higher_than`(7000)$$

-- 10
CREATE FUNCTION `ufn_calculate_future_value`(`sum` DECIMAl(12,4), `yearly_interest_rate` DOUBLE, `number_of_years` INT)
RETURNS DECIMAL(12,4)
DETERMINISTIC
BEGIN
	RETURN `sum` * (POW(1+`yearly_interest_rate`,`number_of_years`));
END$$

SELECT `ufn_calculate_future_value`(1000,0.5,5)$$

-- 11
CREATE PROCEDURE `usp_calculate_future_value_for_account`(`id` INT, `interest_rate` DOUBLE)
BEGIN
	SELECT a.`id` AS `account_id`, 
    p.`first_name`, p.`last_name`,
    a.`balance` AS `current_balance`, 
    `ufn_calculate_future_value`(a.`balance`,`interest_rate`,5) AS `balance_in_5_years`
    FROM `account_holders` AS p
    JOIN `accounts` AS a
    ON p.`id` = a.`account_holder_id`
    HAVING a.`id` = `id`;
END$$

CALL `usp_calculate_future_value_for_account`(1, 0.1)$$

-- 12
CREATE PROCEDURE `usp_deposit_money`(`account_id` INT, `money_amount` DECIMAL(12,4))
BEGIN
	START TRANSACTION;
	IF `money_amount` < 0 
    THEN ROLLBACK;
    ELSE
	UPDATE `accounts` AS a
    SET `balance` = `balance` + `money_amount`
    WHERE `account_id` = a.`id`;
    END IF;
END$$

CALL `usp_deposit_money`(1,100)$$
CALL `usp_deposit_money`(1,-100)$$

-- 13
CREATE PROCEDURE `usp_withdraw_money`(`account_id` INT, `money_amount` DECIMAL(12,4))
BEGIN
	START TRANSACTION;
	IF (SELECT `balance` FROM `accounts`
		WHERE `id` = `account_id`) - `money_amount` < 0
		OR `money_amount` < 0
    THEN ROLLBACK;
    ELSE
		UPDATE `accounts` AS a
		SET `balance` = `balance` - `money_amount`
		WHERE `account_id` = a.`id`;
    END IF;
END$$

CALL `usp_withdraw_money`(1,100)$$
CALL `usp_withdraw_money`(1,-100)$$
CALL `usp_withdraw_money`(19,100)$$

-- 14
CREATE PROCEDURE `usp_transfer_money`(`from_account_id` INT, `to_account_id` INT, `amount` DECIMAL(12,4))
BEGIN
	START TRANSACTION;
    IF(SELECT COUNT(*) FROM `accounts` WHERE `id` = `from_account_id`) = 0 OR
    (SELECT COUNT(*) FROM `accounts` WHERE `id` =`to_account_id`) = 0 OR
    (SELECT `balance` FROM `accounts` WHERE `id` = `from_account_id`) < `amount` OR
    `from_account_id` = `to_account_id` OR
    `amount` < 0
    THEN ROLLBACK;
    ELSE
    UPDATE `accounts`
    SET `balance` = CASE WHEN `id` = `from_account_id` THEN `balance` - `amount`
						 WHEN `id` = `to_account_id` THEN `balance` + `amount`
                         ELSE `balance`
                         END;
    END IF;
END$$

CALL `usp_transfer_money`(1,2,100)$$
CALL `usp_transfer_money`(1,2,100)$$
CALL `usp_transfer_money`(1,78,10)$$








