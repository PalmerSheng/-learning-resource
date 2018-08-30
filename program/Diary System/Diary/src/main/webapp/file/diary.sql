/*
Navicat MySQL Data Transfer

Source Server         : sf
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : diary

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-08-30 13:57:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP DATABASE IF EXISTS `diary`;
CREATE DATABASE diary;
use diary;


DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userid` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for records
-- ----------------------------
DROP TABLE IF EXISTS `records`;
CREATE TABLE `records` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userid` varchar(20) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `troublemeet` varchar(200) DEFAULT NULL,
  `writetime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of records
-- ----------------------------

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userid` varchar(255) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `usertype` int(1) DEFAULT '0' COMMENT '0一般用户，1管理员 2系统管理员',
  `sex` int(1) DEFAULT NULL COMMENT '性别 1:男2:女',
  `age` int(2) unsigned DEFAULT NULL,
  `groups` varchar(1) DEFAULT NULL COMMENT '组别。0:java,1:.net,2:ios,3:安卓，4:前端',
  `status` varchar(1) DEFAULT '0' COMMENT '0启用 1禁用',
  `lasttime` datetime DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `profilehead` varchar(200) DEFAULT NULL,
  `profile` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('16', 'sf', '123', '盛飞', '0', '1', '11', '2', '0', '2018-08-10 18:52:38', '2018-08-10 13:40:41', null, 'ee');
