/*
 Navicat Premium Data Transfer

 Source Server         : localhostMySql
 Source Server Type    : MySQL
 Source Server Version : 80042 (8.0.42)
 Source Host           : localhost:3306
 Source Schema         : sql_exp

 Target Server Type    : MySQL
 Target Server Version : 80042 (8.0.42)
 File Encoding         : 65001

 Date: 21/05/2025 15:23:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exp_check
-- ----------------------------
DROP TABLE IF EXISTS `exp_check`;
CREATE TABLE `exp_check`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `manager_id` int NOT NULL,
  `user_id` int NOT NULL,
  `room_id` char(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `check_in_time` datetime NOT NULL,
  `check_out_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exp_check
-- ----------------------------

-- ----------------------------
-- Table structure for exp_manager
-- ----------------------------
DROP TABLE IF EXISTS `exp_manager`;
CREATE TABLE `exp_manager`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `phone` char(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `permission` tinyint NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exp_manager
-- ----------------------------
INSERT INTO `exp_manager` VALUES (1, '张1', '136....3595', 0);
INSERT INTO `exp_manager` VALUES (2, '张2', '136....3595', 0);
INSERT INTO `exp_manager` VALUES (3, '张3', '136....3595', 0);
INSERT INTO `exp_manager` VALUES (4, '张4', '136....3595', 0);
INSERT INTO `exp_manager` VALUES (5, '张5', '136....3595', 0);
INSERT INTO `exp_manager` VALUES (6, '李1', '136....3595', 1);
INSERT INTO `exp_manager` VALUES (7, '李2', '136....3595', 1);
INSERT INTO `exp_manager` VALUES (8, '李3', '136....3595', 1);
INSERT INTO `exp_manager` VALUES (9, '李4', '136....3595', 1);
INSERT INTO `exp_manager` VALUES (10, '李5', '136....3595', 1);
INSERT INTO `exp_manager` VALUES (11, '李6', '136....3595', 1);
INSERT INTO `exp_manager` VALUES (12, '李7', '136....3595', 1);
INSERT INTO `exp_manager` VALUES (13, '李8', '136....3595', 1);

-- ----------------------------
-- Table structure for exp_room
-- ----------------------------
DROP TABLE IF EXISTS `exp_room`;
CREATE TABLE `exp_room`  (
  `id` char(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `type` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `price` decimal(10, 0) NOT NULL DEFAULT 0,
  `status` tinyint NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exp_room
-- ----------------------------
INSERT INTO `exp_room` VALUES ('101', '大床房', 100, 0);
INSERT INTO `exp_room` VALUES ('102', '大床房', 100, 2);
INSERT INTO `exp_room` VALUES ('103', '大床房', 100, 0);
INSERT INTO `exp_room` VALUES ('104', '大床房', 100, 0);
INSERT INTO `exp_room` VALUES ('105', '大床房', 100, 0);
INSERT INTO `exp_room` VALUES ('106', '大床房', 100, 0);
INSERT INTO `exp_room` VALUES ('201', '大床房', 100, 0);
INSERT INTO `exp_room` VALUES ('202', '大床房', 100, 0);
INSERT INTO `exp_room` VALUES ('203', '大床房', 100, 0);
INSERT INTO `exp_room` VALUES ('204', '大床房', 100, 0);
INSERT INTO `exp_room` VALUES ('205', '大床房', 100, 0);
INSERT INTO `exp_room` VALUES ('206', '大床房', 100, 0);

-- ----------------------------
-- Table structure for exp_service
-- ----------------------------
DROP TABLE IF EXISTS `exp_service`;
CREATE TABLE `exp_service`  (
  `permission` tinyint NOT NULL,
  `room_id` int NOT NULL,
  PRIMARY KEY (`permission`, `room_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exp_service
-- ----------------------------
INSERT INTO `exp_service` VALUES (0, 101);
INSERT INTO `exp_service` VALUES (0, 102);
INSERT INTO `exp_service` VALUES (0, 103);
INSERT INTO `exp_service` VALUES (0, 104);
INSERT INTO `exp_service` VALUES (0, 105);
INSERT INTO `exp_service` VALUES (0, 106);
INSERT INTO `exp_service` VALUES (0, 201);
INSERT INTO `exp_service` VALUES (0, 202);
INSERT INTO `exp_service` VALUES (0, 203);
INSERT INTO `exp_service` VALUES (0, 204);
INSERT INTO `exp_service` VALUES (0, 205);
INSERT INTO `exp_service` VALUES (0, 206);
INSERT INTO `exp_service` VALUES (1, 101);
INSERT INTO `exp_service` VALUES (1, 102);
INSERT INTO `exp_service` VALUES (1, 103);
INSERT INTO `exp_service` VALUES (1, 104);
INSERT INTO `exp_service` VALUES (1, 105);
INSERT INTO `exp_service` VALUES (1, 106);

-- ----------------------------
-- Table structure for exp_user
-- ----------------------------
DROP TABLE IF EXISTS `exp_user`;
CREATE TABLE `exp_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `phone` char(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `status` tinyint NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exp_user
-- ----------------------------
INSERT INTO `exp_user` VALUES (1, '王1', '13676623595', 1);
INSERT INTO `exp_user` VALUES (2, '王2', '13676623595', 1);

-- ----------------------------
-- Table structure for exp_user_room
-- ----------------------------
DROP TABLE IF EXISTS `exp_user_room`;
CREATE TABLE `exp_user_room`  (
  `user_id` int NOT NULL,
  `room_id` char(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `check_time` datetime NOT NULL,
  PRIMARY KEY (`user_id`, `room_id`, `check_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exp_user_room
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
