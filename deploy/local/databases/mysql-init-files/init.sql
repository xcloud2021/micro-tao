DROP DATABASE IF EXISTS product;
CREATE DATABASE product CHARACTER SET UTF8;
USE product;
CREATE TABLE product
(
pid BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
product_name VARCHAR(50),
product_price BIGINT,
product_sales BIGINT DEFAULT 0,
product_status BIGINT DEFAULT 0
);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('空调',100, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('冰箱',200, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('洗衣机',300, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('电视',400, 1, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('电话',500, 0, 1);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('电脑',600, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('空调',100, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('冰箱',200, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('洗衣机',300, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('电视',400, 1, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('电话',500, 0, 1);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('电脑',600, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('空调',100, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('冰箱',200, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('洗衣机',300, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('电视',400, 1, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('电话',500, 0, 1);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('电脑',600, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('空调',100, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('冰箱',200, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('洗衣机',300, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('电视',400, 1, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('电话',500, 0, 1);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('电脑',600, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('空调',100, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('冰箱',200, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('洗衣机',300, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('电视',400, 1, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('电话',500, 0, 1);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('电脑',600, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('空调',100, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('冰箱',200, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('洗衣机',300, 0, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('电视',400, 1, 0);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('电话',500, 0, 1);
INSERT INTO product(product_name,product_price, product_sales, product_status) VALUES('电脑',600, 0, 0);

DROP DATABASE IF EXISTS taouser;
CREATE DATABASE taouser CHARACTER SET UTF8;
USE taouser;
CREATE TABLE user
(
id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
account VARCHAR(32) UNIQUE NOT NULL,
nickname VARCHAR(32),
passwd VARCHAR(64) NOT NULL,
gender VARCHAR(16),
`address` VARCHAR(128)
);
INSERT INTO user(account, nickname, passwd, gender, `address`) VALUES('root','root', "root", "M", "未知");
INSERT INTO user(account, nickname, passwd, gender, `address`) VALUES('default1','defaultuser1', "123456", "M", "未知");
INSERT INTO user(account, nickname, passwd, gender, `address`) VALUES('default2','defaultuser1', "123456", "M", "未知");
INSERT INTO user(account, nickname, passwd, gender, `address`) VALUES('default3','defaultuser1', "123456", "M", "未知");
INSERT INTO user(account, nickname, passwd, gender, `address`) VALUES('default4','defaultuser1', "123456", "M", "未知");
INSERT INTO user(account, nickname, passwd, gender, `address`) VALUES('default5','defaultuser1', "123456", "M", "未知");

DROP DATABASE IF EXISTS taocart;
CREATE DATABASE taocart CHARACTER SET UTF8;
USE taocart;
CREATE TABLE taocart
(
id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
user_id BIGINT NOT NULL,
product_id BIGINT NOT NULL,
create_at DATETIME NOT NULL,
`status` BIGINT DEFAULT 0
);
INSERT INTO taocart(user_id, product_id, create_at, `status`) VALUES(1, 1, now(), 0);
INSERT INTO taocart(user_id, product_id, create_at, `status`) VALUES(1, 2, now(), 0);
INSERT INTO taocart(user_id, product_id, create_at, `status`) VALUES(1, 3, now(), 0);

DROP DATABASE IF EXISTS taoorder;
CREATE DATABASE taoorder CHARACTER SET UTF8;
USE taoorder;
CREATE TABLE taoorder
(
id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
user_id BIGINT NOT NULL,
product_id BIGINT NOT NULL,
product_price BIGINT NOT NULL,
create_at DATETIME NOT NULL
);
INSERT INTO taoorder(user_id, product_id, product_price, create_at) VALUES(1, 1, 99, now());
INSERT INTO taoorder(user_id, product_id, product_price, create_at) VALUES(1, 1, 98, now());
INSERT INTO taoorder(user_id, product_id, product_price, create_at) VALUES(1, 1, 99, now());
