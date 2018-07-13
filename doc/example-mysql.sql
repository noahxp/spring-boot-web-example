DROP SCHEMA IF EXISTS `company`;

CREATE SCHEMA `company` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;

DROP TABLE IF EXISTS `company`.`employee`;

CREATE TABLE `company`.`employee` (
	`employee_id` INT NOT NULL AUTO_INCREMENT COMMENT '自動流水號',
    `emp_no`      VARCHAR(10)             NOT NULL COMMENT '員工編號',
    `birthday`   DATE            NOT NULL COMMENT '生日',
    `first_name`  VARCHAR(20)     NOT NULL COMMENT '員工姓氏',
    `last_name`   VARCHAR(30)     NOT NULL COMMENT '員工名字',
    `gender`      ENUM ('M','F')  NULL COMMENT '性別 男："M"、女:"F"',
    `arrive_date`   DATE            NOT NULL COMMENT '到職日',
	`create_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '資料建立日期',
    `update_date` DATETIME NULL COMMENT '資料最後修改日期',
    PRIMARY KEY (employee_id),
    UNIQUE INDEX `emp_no_UNIQUE` (`emp_no` ASC)
);


INSERT INTO `company`.`employee` (`emp_no`,`birthday`,`first_name`,`last_name`,`gender`,`arrive_date`) VALUES ('0001', '1967/1/1' ,'joe' ,'lee', null,'2015/1/2');
INSERT INTO `company`.`employee` (`emp_no`,`birthday`,`first_name`,`last_name`,`gender`,`arrive_date`) VALUES ('0002', '1971/4/3' ,'john' ,'cheng', 'M','2015/4/1');
INSERT INTO `company`.`employee` (`emp_no`,`birthday`,`first_name`,`last_name`,`gender`,`arrive_date`) VALUES ('0003', '1972/6/1' ,'peter' ,'shih', 'M','2015/4/3');

# ------
DROP SCHEMA IF EXISTS `book_store`;

CREATE SCHEMA `book_store` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;

DROP TABLE IF EXISTS `book_store`.`books`;

CREATE TABLE `book_store`.`books` (
	`books_id` INT NOT NULL AUTO_INCREMENT COMMENT '自動流水號',
    `isdn`      VARCHAR(20)             NOT NULL COMMENT '書本國際碼',
    `books_name`   VARCHAR(30)            NOT NULL COMMENT '書名',
	`create_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '資料建立日期',
    `update_date` DATETIME NULL COMMENT '資料最後修改日期',
    PRIMARY KEY (books_id),
    UNIQUE INDEX `isdn_UNIQUE` (`isdn` ASC)
);

INSERT INTO `book_store`.`books` (`isdn`,`books_name`)VALUES ('0010788538','Java入門邁向高手之路-王者歸來');
INSERT INTO `book_store`.`books` (`isdn`,`books_name`)VALUES ('0010785554','最新 Java 程式語言');
INSERT INTO `book_store`.`books` (`isdn`,`books_name`)VALUES ('986476859X','Kotlin 實戰手冊');
INSERT INTO `book_store`.`books` (`isdn`,`books_name`)VALUES ('7115465029','奔跑吧Linux內核');
INSERT INTO `book_store`.`books` (`isdn`,`books_name`)VALUES ('9864342940','無瑕的程式碼');


