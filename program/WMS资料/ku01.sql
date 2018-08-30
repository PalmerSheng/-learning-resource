/*
Navicat MySQL Data Transfer

Source Server         : qwe
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ku01

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-07-01 18:21:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for buy_return
-- ----------------------------
DROP TABLE IF EXISTS `buy_return`;
CREATE TABLE `buy_return` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_code` varchar(255) DEFAULT NULL COMMENT '商品号',
  `goods_num` int(11) DEFAULT NULL COMMENT '操作数量',
  `supply_code` varchar(255) DEFAULT NULL COMMENT '供应商code',
  `user_code` varchar(255) DEFAULT NULL COMMENT '用户code',
  `time` datetime DEFAULT NULL COMMENT '进货时间',
  `sum_money` varchar(255) DEFAULT NULL COMMENT '总金额',
  `single_money` varchar(255) DEFAULT NULL COMMENT '单价',
  `state` varchar(255) DEFAULT NULL COMMENT '进出库状态  0入库  1出库',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='进出货记录';

-- ----------------------------
-- Records of buy_return
-- ----------------------------
INSERT INTO `buy_return` VALUES ('1', '0101001', '12', '1111', '3333', '2018-05-05 00:00:00', '1476', '123', '1');
INSERT INTO `buy_return` VALUES ('2', '0101001', '12', '1111', '3333', '2018-05-05 00:00:00', '1476', '123', '1');
INSERT INTO `buy_return` VALUES ('3', '0101001', '12', '1111', '3333', '2018-05-05 00:00:00', '1476', '123', '0');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_code` varchar(255) DEFAULT NULL COMMENT '商品号',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '商品名',
  `goods_num` int(11) DEFAULT NULL COMMENT '库存数量',
  `time` datetime DEFAULT NULL COMMENT '更新时间',
  `single_money` varchar(255) DEFAULT NULL COMMENT '单价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='商品信息';

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '0101001', 'qwqeq', '555', '2018-05-05 00:00:00', '123');
INSERT INTO `goods` VALUES ('2', '0101002', 'qwqeqqe', '555', '2018-05-05 00:00:00', '123');
INSERT INTO `goods` VALUES ('3', '0101003', 'qwqeqqew', '555', '2018-05-05 00:00:00', '123');
INSERT INTO `goods` VALUES ('4', '0101004', 'qwqeqeq', '555', '2018-05-05 00:00:00', '123');
INSERT INTO `goods` VALUES ('5', '0101005', 'qwqeqeqwrqw', '555', '2018-05-05 00:00:00', '123');

-- ----------------------------
-- Table structure for goods_type
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type` (
  `id` int(11) NOT NULL,
  `class01` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品类别';

-- ----------------------------
-- Records of goods_type
-- ----------------------------

-- ----------------------------
-- Table structure for sqlinfo
-- ----------------------------
DROP TABLE IF EXISTS `sqlinfo`;
CREATE TABLE `sqlinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '库名',
  `place` varchar(255) DEFAULT NULL COMMENT '地址',
  `duty` varchar(255) DEFAULT NULL COMMENT '负责人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库区管理(数据库管理)';

-- ----------------------------
-- Records of sqlinfo
-- ----------------------------

-- ----------------------------
-- Table structure for supplyinfo
-- ----------------------------
DROP TABLE IF EXISTS `supplyinfo`;
CREATE TABLE `supplyinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `supply_name` varchar(255) DEFAULT NULL COMMENT '供应商名字',
  `supply_code` varchar(255) DEFAULT NULL COMMENT '供应商code',
  `tel` varchar(255) DEFAULT NULL,
  `duty_name` varchar(255) DEFAULT NULL COMMENT '负责人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='供应商信息';

-- ----------------------------
-- Records of supplyinfo
-- ----------------------------
INSERT INTO `supplyinfo` VALUES ('1', 'qqq', '1111', '23123', 'qqq');
INSERT INTO `supplyinfo` VALUES ('2', 'www', '2222', '12312', 'qqq');
INSERT INTO `supplyinfo` VALUES ('3', 'eee', '3333', '13212', 'www');
INSERT INTO `supplyinfo` VALUES ('4', 'rrrr', '4444', '21313', 'www');

-- ----------------------------
-- Table structure for takeinfo
-- ----------------------------
DROP TABLE IF EXISTS `takeinfo`;
CREATE TABLE `takeinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_code` varchar(255) DEFAULT NULL COMMENT '商品号',
  `goods_num` int(11) DEFAULT NULL COMMENT '操作数量',
  `take_code` varchar(255) DEFAULT NULL COMMENT '领料人code',
  `duty_code` varchar(255) DEFAULT NULL COMMENT '负责人code',
  `time` datetime DEFAULT NULL COMMENT '领料时间',
  `take_state` varchar(255) DEFAULT NULL COMMENT '领料状态  0未领  1已领',
  `state` varchar(255) DEFAULT NULL COMMENT '进出库状态  0入库  1出库',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='本地出入库记录';

-- ----------------------------
-- Records of takeinfo
-- ----------------------------
INSERT INTO `takeinfo` VALUES ('1', '0101001', '5', '1122', '3333', '2018-05-09 00:00:00', '1', '1');
INSERT INTO `takeinfo` VALUES ('2', '0101001', '5', '1122', '3333', '2018-05-09 00:00:00', '0', '1');
INSERT INTO `takeinfo` VALUES ('3', '0101001', '5', '1122', '3333', '2018-05-09 00:00:00', '0', '0');
INSERT INTO `takeinfo` VALUES ('4', '0101001', '5', '1122', '3333', '2018-05-09 00:00:00', '1', '0');

-- ----------------------------
-- Table structure for trans_goods
-- ----------------------------
DROP TABLE IF EXISTS `trans_goods`;
CREATE TABLE `trans_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_code` varchar(255) DEFAULT NULL COMMENT '商品号',
  `goods_num` int(11) DEFAULT NULL COMMENT '数量',
  `take_code` varchar(255) DEFAULT NULL COMMENT '调拨人',
  `douser_code` varchar(255) DEFAULT NULL COMMENT '办理人',
  `place` varchar(255) DEFAULT NULL COMMENT '调拨地区',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品调拨\r\n操作员输入调拨商品编码、数量、调拨人等，系统更新数据库（此操作相当于移库操作）';

-- ----------------------------
-- Records of trans_goods
-- ----------------------------

-- ----------------------------
-- Table structure for unitinfo
-- ----------------------------
DROP TABLE IF EXISTS `unitinfo`;
CREATE TABLE `unitinfo` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `depart` varchar(255) DEFAULT NULL COMMENT '部名',
  `group` varchar(255) DEFAULT NULL COMMENT '组名',
  `code` varchar(255) DEFAULT NULL COMMENT '编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='单位信息';

-- ----------------------------
-- Records of unitinfo
-- ----------------------------
INSERT INTO `unitinfo` VALUES ('00000000001', '部门01', '组00', '0100');
INSERT INTO `unitinfo` VALUES ('00000000002', '01', '01', '0101');
INSERT INTO `unitinfo` VALUES ('00000000003', '01', '02', '0102');
INSERT INTO `unitinfo` VALUES ('00000000004', '01', '03', '0103');
INSERT INTO `unitinfo` VALUES ('00000000005', '02', '00', '0200');
INSERT INTO `unitinfo` VALUES ('00000000006', '02', '01', '0201');
INSERT INTO `unitinfo` VALUES ('00000000007', '02', '02', '0202');
INSERT INTO `unitinfo` VALUES ('00000000008', '00', '00', '0000');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `usercode` varchar(255) DEFAULT NULL COMMENT '用户账号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `unit_code` varchar(255) DEFAULT NULL COMMENT '工作单位',
  `level` int(11) DEFAULT NULL COMMENT '用户级别',
  `user_state` int(11) DEFAULT NULL COMMENT '账号状态  0启用  1冻结',
  `tel` varchar(255) DEFAULT NULL COMMENT '用户电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户信息';

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', 'admin', 'admin', '0000', '0000', '1', '4', '12321312');
INSERT INTO `userinfo` VALUES ('2', 'qqqq', '2222', '0000', '0100', '1', '3', '1123123123');
INSERT INTO `userinfo` VALUES ('3', 'wwww', '3333', '0000', '0101', '1', '2', '111321');
INSERT INTO `userinfo` VALUES ('4', '12312', '1122', '0000', '0101', '1', '1', '2312');
INSERT INTO `userinfo` VALUES ('5', 'weq', '123', '0000', '0101', '1', '1', '1212312424');
INSERT INTO `userinfo` VALUES ('6', 'qeeqw', '233', '0000', '0101', '1', '1', '1212312');
