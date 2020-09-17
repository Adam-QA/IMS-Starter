drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims` ;
CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
	`pid` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`item_name` VARCHAR(40),
	`price` DOUBLE(11, 2)
);

CREATE TABLE IF NOT EXISTS `orders`(
	`order_id` INT(11) NOT NULL AUTO_INCREMENT,
	`fk_cid` INT(11) NOT NULL,
	PRIMARY KEY (`order_id`),
	FOREIGN KEY (`fk_cid`) REFERENCES `customers` (`id`)
);
CREATE TABLE IF NOT EXISTS `orderline`(
	`orderl_id` INT(11) NOT NULL AUTO_INCREMENT,
	`order_id` INT(11) NOT NULL,
	`fk_pid` INT(11) NOT NULL,
	PRIMARY KEY (`orderl_id`),
	CONSTRAINT `fk_orderline_1` FOREIGN KEY (`order_id`) REFERENCES `orders`(`order_id`) on delete cascade,
	CONSTRAINT `fk_orderline_2` FOREIGN KEY (`fk_pid`) REFERENCES `items` (`pid`)


);
