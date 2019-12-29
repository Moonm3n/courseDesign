/*
 Navicat MySQL Data Transfer

 Source Server         : first
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : courseDesign

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 27/12/2019 10:46:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administor
-- ----------------------------
DROP TABLE IF EXISTS `administor`;
CREATE TABLE `administor` (
  `administor_id` char(6) COLLATE utf8_bin NOT NULL,
  `password` varchar(12) COLLATE utf8_bin NOT NULL,
  `administor_name` varchar(15) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`administor_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of administor
-- ----------------------------
BEGIN;
INSERT INTO `administor` VALUES ('2B5424', '654321', '李小冉');
INSERT INTO `administor` VALUES ('3D2313', '123456', '王小明');
COMMIT;

-- ----------------------------
-- Table structure for book_info
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info` (
  `book_id` char(11) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `book_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `publisher` varchar(80) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `location` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `book_num` int(255) DEFAULT NULL,
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_info
-- ----------------------------
BEGIN;
INSERT INTO `book_info` VALUES ('C244.22/163', '悲惨世界', '（法）维克多·雨果著/李玉民译', '中央编译出版社', '04C020506', 3);
INSERT INTO `book_info` VALUES ('D324.55/175', 'Java从入门到精通', '明日科技', '清华大学出版社', '02B010305', 4);
INSERT INTO `book_info` VALUES ('I313.45/156', '科学技术史', '王鸿生', '中国人民大学出版社', '03D010203', 5);
INSERT INTO `book_info` VALUES ('I313.45/157', '科学技术史', '王鸿生', '中国人民大学出版社', '03D010203', 6);
COMMIT;

-- ----------------------------
-- Table structure for borrow_info
-- ----------------------------
DROP TABLE IF EXISTS `borrow_info`;
CREATE TABLE `borrow_info` (
  `book_id` char(11) COLLATE utf8_bin NOT NULL,
  `reader_id` char(13) COLLATE utf8_bin NOT NULL,
  `status` char(2)  COLLATE utf8_bin NOT NULL DEFAULT '1' COMMENT '1-已借出，2-已归还',
  `borrow_time` datetime(6) NOT NULL,
  `due_time` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of borrow_info
-- ----------------------------
BEGIN;
INSERT INTO `borrow_info` VALUES ('I313.45/851', '2018091613002', '1', '2019-11-27 10:18:35.000000', '2019-12-27 10:18:35.000000');
INSERT INTO `borrow_info` VALUES ('I313.45/852', '2018091613002', '1', '2019-11-20 10:19:36.000000', '2019-12-20 10:19:36.000000');
COMMIT;

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader` (
  `reader_id` char(13) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `reader_name` varchar(16) NOT NULL,
  `borrowed_book` int(255) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `id_registration_time` datetime(6) NOT NULL,
  `id_due_time` datetime(6) NOT NULL,
  PRIMARY KEY (`reader_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reader
-- ----------------------------
BEGIN;
INSERT INTO `reader` VALUES ('2018091613002', '吴亦凡', 3, '123456', '2018-09-01 10:00:00.000000', '2019-06-30 10:00:01.000000');
COMMIT;

-- ----------------------------
-- Table structure for return_info
-- ----------------------------
DROP TABLE IF EXISTS `return_info`;
CREATE TABLE `return_info` (
  `book_id` char(50) COLLATE utf8_bin NOT NULL,
  `reader_id` char(13) COLLATE utf8_bin DEFAULT NULL,
  `return_time` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of return_info
-- ----------------------------
BEGIN;
INSERT INTO `return_info` VALUES ('I313.45/852', '2018091613002', '2019-12-10 10:20:29.000000');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
