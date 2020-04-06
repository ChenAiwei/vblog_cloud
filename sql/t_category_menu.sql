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

 Date: 06/04/2020 19:14:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_category_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_category_menu`;
CREATE TABLE `t_category_menu` (
  `uid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一uid',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `menu_level` tinyint(1) DEFAULT NULL COMMENT '菜单级别',
  `summary` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '简介',
  `parent_uid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父uid',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'url地址',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图标',
  `sort` int DEFAULT '0' COMMENT '排序字段，越大越靠前',
  `status` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_show` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否显示 1:是 0:否',
  `menu_type` tinyint NOT NULL DEFAULT '0' COMMENT '菜单类型 0: 菜单   1: 按钮',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='资源表';

-- ----------------------------
-- Records of t_category_menu
-- ----------------------------
BEGIN;
INSERT INTO `t_category_menu` VALUES ('1313e', '首页', NULL, '首页信息', NULL, '/index', NULL, 0, 1, '2020-04-03 09:18:57', '2020-04-03 09:19:00', 1, 0);
INSERT INTO `t_category_menu` VALUES ('23232ffgfg23', '系统', NULL, '系统信息', NULL, '/system', NULL, 1, 1, '2020-04-03 09:24:24', '2020-04-03 09:24:27', 1, 0);
INSERT INTO `t_category_menu` VALUES ('2323424', '修改介绍', NULL, '修改介绍', '323dff', '/index/jieshao/edit', NULL, 0, 1, '2020-04-05 13:11:39', '2020-04-05 13:11:44', 1, 0);
INSERT INTO `t_category_menu` VALUES ('323dff', '介绍', NULL, '介绍', '1313e', '/index/jieshao', NULL, 0, 1, '2020-04-03 09:20:17', '2020-04-03 09:20:19', 1, 0);
INSERT INTO `t_category_menu` VALUES ('dfdf546546', '删除介绍', NULL, '删除介绍', '323dff', '/index/jieshao/delete', NULL, 1, 1, '2020-04-03 09:23:31', '2020-04-03 09:23:33', 1, 1);
INSERT INTO `t_category_menu` VALUES ('hdsjhd222', '监控', NULL, '监控', NULL, '/listen', NULL, 2, 1, '2020-04-05 13:15:20', '2020-04-05 13:15:27', 1, 0);
INSERT INTO `t_category_menu` VALUES ('sd23fff', '指导', NULL, '系统指导', '23232ffgfg23', '/system/zy', NULL, 0, 1, '2020-04-05 13:13:47', '2020-04-05 13:14:09', 1, 0);
INSERT INTO `t_category_menu` VALUES ('weq2133', '介绍修改保存', NULL, '介绍修改保存', '2323424', '/index/jieshao/editSave', NULL, 0, 1, '2020-04-05 13:16:55', '2020-04-05 13:17:01', 1, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
