/*
Navicat MySQL Data Transfer

Source Server         : sf
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : messageboard

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-05-24 09:44:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for loginss
-- ----------------------------
DROP TABLE IF EXISTS `loginss`;
CREATE TABLE `loginss` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loginss
-- ----------------------------
INSERT INTO `loginss` VALUES ('30', 'sf', '123', '0');

-- ----------------------------
-- Table structure for messagess
-- ----------------------------
DROP TABLE IF EXISTS `messagess`;
CREATE TABLE `messagess` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `time` datetime NOT NULL,
  `title` varchar(20) NOT NULL,
  `message` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of messagess
-- ----------------------------
INSERT INTO `messagess` VALUES ('30', 'sf', '2018-05-13 00:00:00', '这是标题', '这是内容');
INSERT INTO `messagess` VALUES ('30', 'sf', '2018-05-13 00:00:00', '这是标题1', '这是内容2');
