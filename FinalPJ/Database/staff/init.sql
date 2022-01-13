/*
Navicat MySQL Data Transfer

Source Server         : Test
Source Server Version : 80026
Source Host           : localhost:3306
Source Database       : localmysql

Target Server Type    : MYSQL
Target Server Version : 80026
File Encoding         : 65001

Date: 2022-01-03 19:12:39
*/
create database `StaffMySQL` default character set utf8 collate utf8_general_ci;
use mysql;
update user set Host='%' where User='root';
-- ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'admin123';
flush privileges;
SET FOREIGN_KEY_CHECKS=0;
use StaffMySQL;

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
                         `id` int NOT NULL,
                         `name` varchar(255) NOT NULL,
                         `branch` varchar(255) NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

