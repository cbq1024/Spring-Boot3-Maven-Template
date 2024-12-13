/*
 Navicat Premium Dump SQL

 Source Server         : mysql8-3306-local-docker
 Source Server Type    : MySQL
 Source Server Version : 80040 (8.0.40)
 Source Host           : localhost:3306
 Source Schema         : db

 Target Server Type    : MySQL
 Target Server Version : 80040 (8.0.40)
 File Encoding         : 65001

 Date: 12/12/2024 20:04:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `permission_name` varchar(255) NOT NULL COMMENT '权限名',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL COMMENT '更新时间',
  `version` tinyint NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `deleted` tinyint NOT NULL DEFAULT '0' COMMENT '软删除字段 [ 1 已删除 | 0 未删除 ]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of permission
-- ----------------------------
BEGIN;
INSERT INTO `permission` (`id`, `permission_name`, `create_time`, `update_time`, `version`, `deleted`) VALUES (1, 'CREATE', '2024-12-12 19:51:52', '2024-12-12 19:51:54', 1, 0);
INSERT INTO `permission` (`id`, `permission_name`, `create_time`, `update_time`, `version`, `deleted`) VALUES (2, 'DELETE', '2024-12-12 19:51:55', '2024-12-12 19:51:56', 1, 0);
INSERT INTO `permission` (`id`, `permission_name`, `create_time`, `update_time`, `version`, `deleted`) VALUES (3, 'UPDATE', '2024-12-12 19:51:57', '2024-12-12 19:51:58', 1, 0);
INSERT INTO `permission` (`id`, `permission_name`, `create_time`, `update_time`, `version`, `deleted`) VALUES (4, 'SELECT', '2024-12-12 19:51:59', '2024-12-12 19:52:00', 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_name` varchar(255) NOT NULL COMMENT '角色名',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL COMMENT '更新时间',
  `version` tinyint NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `deleted` tinyint NOT NULL DEFAULT '0' COMMENT '软删除字段 [ 1 已删除 | 0 未删除 ]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` (`id`, `role_name`, `create_time`, `update_time`, `version`, `deleted`) VALUES (1, 'ADMIN', '2024-12-12 19:51:24', '2024-12-12 19:51:25', 1, 0);
INSERT INTO `role` (`id`, `role_name`, `create_time`, `update_time`, `version`, `deleted`) VALUES (2, 'USER', '2024-12-12 19:51:31', '2024-12-12 19:51:32', 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for role_permission_map
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_map`;
CREATE TABLE `role_permission_map` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL,
  `permission_id` int DEFAULT NULL,
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL COMMENT '更新时间',
  `version` tinyint NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `deleted` tinyint NOT NULL DEFAULT '0' COMMENT '软删除字段 [ 1 已删除 | 0 未删除 ]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role_permission_map
-- ----------------------------
BEGIN;
INSERT INTO `role_permission_map` (`id`, `role_id`, `permission_id`, `create_time`, `update_time`, `version`, `deleted`) VALUES (1, 1, 1, '2024-12-12 19:52:12', '2024-12-12 19:52:13', 1, 0);
INSERT INTO `role_permission_map` (`id`, `role_id`, `permission_id`, `create_time`, `update_time`, `version`, `deleted`) VALUES (2, 1, 2, '2024-12-12 19:52:40', '2024-12-12 19:52:41', 1, 0);
INSERT INTO `role_permission_map` (`id`, `role_id`, `permission_id`, `create_time`, `update_time`, `version`, `deleted`) VALUES (3, 1, 3, '2024-12-12 19:52:42', '2024-12-12 19:52:43', 1, 0);
INSERT INTO `role_permission_map` (`id`, `role_id`, `permission_id`, `create_time`, `update_time`, `version`, `deleted`) VALUES (4, 1, 4, '2024-12-12 19:52:44', '2024-12-12 19:52:45', 1, 0);
INSERT INTO `role_permission_map` (`id`, `role_id`, `permission_id`, `create_time`, `update_time`, `version`, `deleted`) VALUES (5, 2, 4, '2024-12-12 19:52:53', '2024-12-12 19:52:54', 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL COMMENT '主键 ID',
  `username` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL COMMENT '更新时间',
  `version` tinyint NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `deleted` tinyint NOT NULL DEFAULT '0' COMMENT '软删除字段 [ 1 已删除 | 0 未删除 ]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `username`, `age`, `email`, `password`, `avatar`, `create_time`, `update_time`, `version`, `deleted`) VALUES (1867175151160201218, 'mcdd1024', 22, 'mcdd1024@gmail.com', '{pbkdf2@SpringSecurity_v5_8}1f1df50c5215008cf550f4fb01f4f8d4e2b67a71f0bbc03b177d84b07a0c85400385c37fa92f21029f40b6e2d49611d3', 'https://mcdd1024.avatar.cn', '2024-12-12 19:50:21', '2024-12-12 19:50:21', 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for user_role_map
-- ----------------------------
DROP TABLE IF EXISTS `user_role_map`;
CREATE TABLE `user_role_map` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL COMMENT '更新时间',
  `version` tinyint NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `deleted` tinyint NOT NULL DEFAULT '0' COMMENT '软删除字段 [ 1 已删除 | 0 未删除 ]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_role_map
-- ----------------------------
BEGIN;
INSERT INTO `user_role_map` (`id`, `user_id`, `role_id`, `create_time`, `update_time`, `version`, `deleted`) VALUES (1, 1867175151160201218, 1, '2024-12-12 19:53:01', '2024-12-12 19:53:02', 1, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
