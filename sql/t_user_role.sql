/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : vblog

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 06/07/2020 16:32:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `uid` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户ID',
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`uid`) USING BTREE,
  INDEX `INDEX_USER_ID`(`user_id`) USING BTREE,
  INDEX `INDEX_ROLE_ID`(`role_id`) USING BTREE,
  UNIQUE INDEX `INDEX_UID`(`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户角色' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('01b072f1-5bce-43', '2c48e905-c895-4f', '65aee03f-9c7e-4c');
INSERT INTO `t_user_role` VALUES ('1594022918591', '1594022918561', 'wewewe7887');
INSERT INTO `t_user_role` VALUES ('1594022918594', '1594022918561', 'ew2423434');
INSERT INTO `t_user_role` VALUES ('15940ab8e3b2f723', '159408196c0d3351', 'wewewe7887');
INSERT INTO `t_user_role` VALUES ('15940ea766bd1073', '159408196c0d3351', 'ew2423434');
INSERT INTO `t_user_role` VALUES ('2581994a-331d-43', '2c48e905-c895-4f', 'wewewe7887');
INSERT INTO `t_user_role` VALUES ('322d', 'er43353535', '65aee03f-9c7e-4c');
INSERT INTO `t_user_role` VALUES ('3b0185b0-9c7f-4e', '73b49d6a', 'bf856c32-3d18-47');
INSERT INTO `t_user_role` VALUES ('9b8e7441-1a4c-4e', '73b49d6a', 'ff99617e-9c28-4a');
INSERT INTO `t_user_role` VALUES ('d7d0136f-92ee-46', '2c48e905-c895-4f', 'ew2423434');

SET FOREIGN_KEY_CHECKS = 1;
