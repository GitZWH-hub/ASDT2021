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
create database `TaskMySQL` default character set utf8 collate utf8_general_ci;
use mysql;
update user set Host='%' where User='root';
flush privileges;
SET FOREIGN_KEY_CHECKS=0;
use TaskMySQL;

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
                        `uid` int NOT NULL AUTO_INCREMENT,
                        `id` int NOT NULL,
                        `name` varchar(300) NOT NULL,
                        `state` int NOT NULL,
                        PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

