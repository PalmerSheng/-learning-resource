/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : spring

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-01-21 17:19:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collegeinfo
-- ----------------------------
DROP TABLE IF EXISTS `collegeinfo`;
CREATE TABLE `collegeinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `collegecode` varchar(255) DEFAULT NULL,
  `collegename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collegeinfo
-- ----------------------------
INSERT INTO `collegeinfo` VALUES ('4', '446', 'DDD');
INSERT INTO `collegeinfo` VALUES ('5', '555', 'EEE');
INSERT INTO `collegeinfo` VALUES ('7', '777', 'GGG');
INSERT INTO `collegeinfo` VALUES ('9', '888', 'EEE');
