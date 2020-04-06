/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : vblog

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 06/04/2020 19:14:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `uid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `status` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '状态',
  `summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色介绍',
  `category_menu_uids` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '角色管辖的菜单的UID',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
BEGIN;
INSERT INTO `t_role` VALUES ('ew2423434', '普通用户', '2020-04-03 09:16:51', '2020-04-03 09:16:56', 1, NULL, '[\"1313e\",\"23232ffgfg23\",\"323dff\",\"2323424\",\"sd23fff\",\"hdsjhd222\",\"weq2133\"]');
INSERT INTO `t_role` VALUES ('wewewe7887', '测试人员', '2020-04-03 09:17:55', '2020-04-03 09:17:58', 1, NULL, '[\"1313e\",\"323dff\",\"v43423\",\"dfdf546546\"]');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
