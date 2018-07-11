/*
employee
 */
CREATE SCHEMA `consumer` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;

DROP TABLE IF EXISTS `consumer`.`users`  ;

CREATE TABLE `consumer`.`users` (
  `users_id` INT NOT NULL AUTO_INCREMENT COMMENT '自動流水號',
  `first_name` VARCHAR(30) NOT NULL,
  `family_name` VARCHAR(30) NOT NULL,
  `age` SMALLINT NOT NULL DEFAULT 0,
  `create_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` DATETIME NULL,
  PRIMARY KEY (`users_id`));


/*
books
 */
CREATE SCHEMA `books` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;

DROP TABLE IF EXISTS `books`.`sell_item`  ;

CREATE TABLE `books`.`sell_item` (
  `sell_item_id` INT NOT NULL AUTO_INCREMENT COMMENT '自動流水號',
  `item_name` VARCHAR(50) NOT NULL COMMENT '品名',
  `unit_price` SMALLINT NOT NULL DEFAULT 0,
  `unit_name` VARCHAR(50) NOT NULL,
  `create_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` DATETIME NULL,
  PRIMARY KEY (`sell_item_id`));
