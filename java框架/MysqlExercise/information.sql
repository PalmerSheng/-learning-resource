/*
Navicat MySQL Data Transfer

Source Server         : sf
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : information

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-05-24 09:44:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES ('1', 'sf', '2018-05-20 00:00:00');
INSERT INTO `info` VALUES ('2', 'zz', '2018-05-20 00:00:00');
INSERT INTO `info` VALUES ('3', 'cc', '2018-05-20 00:00:00');

-- ----------------------------
-- Table structure for info_copy
-- ----------------------------
DROP TABLE IF EXISTS `info_copy`;
CREATE TABLE `info_copy` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of info_copy
-- ----------------------------
INSERT INTO `info_copy` VALUES ('1', 'sf');
INSERT INTO `info_copy` VALUES ('2', 'zz');
INSERT INTO `info_copy` VALUES ('3', 'cc');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `SNo` int(11) NOT NULL,
  `SName` varchar(255) DEFAULT NULL,
  `SAge` int(10) DEFAULT NULL,
  PRIMARY KEY (`SNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'sf', '12');

-- ----------------------------
-- Procedure structure for qwe
-- ----------------------------
DROP PROCEDURE IF EXISTS `qwe`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `qwe`(in a int,out b int)
BEGIN
set b = a;
select b;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for select
-- ----------------------------
DROP PROCEDURE IF EXISTS `select`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `select`(IN `a` int)
BEGIN
	#Routine body goes here...
select a;
select b;
END
;;
DELIMITER ;
