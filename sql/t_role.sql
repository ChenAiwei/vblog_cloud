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

 Date: 06/07/2020 16:32:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `uid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(3) UNSIGNED NULL DEFAULT 1 COMMENT '状态',
  `summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色介绍',
  `category_menu_uids` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '角色管辖的菜单的UID',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `INDEX_UID`(`uid`) USING BTREE,
  INDEX `INDEX_NAME`(`role_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('65aee03f-9c7e-4c', '普通', '2020-07-06 09:12:17', NULL, 1, NULL, NULL);
INSERT INTO `t_role` VALUES ('bf856c32-3d18-47', '普通222', '2020-07-06 09:15:31', '2020-07-06 15:37:59', 0, '哈哈', '[\"123\"]');
INSERT INTO `t_role` VALUES ('ew2423434', '普通用户', '2020-04-03 09:16:51', '2020-04-03 09:16:56', 1, NULL, '[\"1313e\",\"23232ffgfg23\",\"323dff\",\"2323424\",\"sd23fff\",\"hdsjhd222\",\"weq2133\"]');
INSERT INTO `t_role` VALUES ('ff99617e-9c28-4a', '普通3333', '2020-07-06 15:36:28', '2020-07-06 15:40:07', 0, '哈哈', '[\"123\"]');
INSERT INTO `t_role` VALUES ('wewewe7887', '测试人员', '2020-04-03 09:17:55', '2020-04-03 09:17:58', 1, NULL, '[\"1313e\",\"323dff\",\"v43423\",\"dfdf546546\"]');

SET FOREIGN_KEY_CHECKS = 1;
