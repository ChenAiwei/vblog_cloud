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

 Date: 06/07/2020 16:32:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `uid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一uid',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `pass_word` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `gender` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '性别(1:男2:女)',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人头像',
  `email` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `birthday` date NULL DEFAULT NULL COMMENT '出生年月日',
  `mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `login_count` int(10) UNSIGNED NULL DEFAULT 0 COMMENT '登录次数',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '127.0.0.1' COMMENT '最后登录IP',
  `status` tinyint(3) UNSIGNED NULL DEFAULT 1 COMMENT '状态',
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '平台uuid',
  `qq_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'QQ号',
  `we_chat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信号',
  `comment_status` tinyint(1) NULL DEFAULT 1 COMMENT '评论状态 1:正常 0:禁言',
  `browser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器',
  `os` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作系统',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `INDEX_UID`(`uid`) USING BTREE,
  INDEX `INDEX_NAME`(`user_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1594022918561', '里斯', 'dsdsf45@#24', NULL, 0, NULL, NULL, NULL, NULL, 0, NULL, '127.0.0.1', 1, NULL, NULL, NULL, 1, NULL, NULL, '2020-07-06 16:08:39', NULL);
INSERT INTO `t_user` VALUES ('159408196c0d3351', '里2斯', 'dsdsf45@#24', NULL, 0, NULL, NULL, NULL, NULL, 0, NULL, '127.0.0.1', 1, NULL, NULL, NULL, 1, NULL, NULL, '2020-07-06 16:16:21', NULL);
INSERT INTO `t_user` VALUES ('2c48e905-c895-4f', 'xixi11', 'dsdsf45@#24', NULL, 0, NULL, NULL, NULL, NULL, 0, NULL, '127.0.0.1', 1, NULL, NULL, NULL, 1, NULL, NULL, '2020-07-06 15:15:17', '2020-07-06 15:16:56');
INSERT INTO `t_user` VALUES ('73b49d6a', 'xiaodi', 'dsdsf45@#24', NULL, 0, NULL, NULL, NULL, NULL, 0, NULL, '127.0.0.1', 1, NULL, NULL, NULL, 1, NULL, NULL, '2020-07-02 16:34:01', NULL);
INSERT INTO `t_user` VALUES ('er43353535', 'xixi', 'we3233', NULL, 0, NULL, NULL, '2020-04-05', NULL, 0, NULL, '127.0.0.1', 1, NULL, NULL, NULL, 1, NULL, NULL, '2020-04-05 13:45:46', '2020-04-05 13:45:51');

SET FOREIGN_KEY_CHECKS = 1;
