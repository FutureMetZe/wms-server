/*
 Navicat Premium Data Transfer

 Source Server         : mysql_loaclhost
 Source Server Type    : MySQL
 Source Server Version : 50634
 Source Host           : localhost:3306
 Source Schema         : wms

 Target Server Type    : MySQL
 Target Server Version : 50634
 File Encoding         : 65001

 Date: 03/09/2018 15:40:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for r_user_role
-- ----------------------------
DROP TABLE IF EXISTS `r_user_role`;
CREATE TABLE `r_user_role`  (
  `user_id` int(10) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` int(10) NULL DEFAULT NULL COMMENT '角色ID'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户-角色关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of r_user_role
-- ----------------------------
INSERT INTO `r_user_role` VALUES (2, 2);
INSERT INTO `r_user_role` VALUES (3, 3);
INSERT INTO `r_user_role` VALUES (1, 1);
INSERT INTO `r_user_role` VALUES (1, 2);
INSERT INTO `r_user_role` VALUES (1, 3);
INSERT INTO `r_user_role` VALUES (4, 2);
INSERT INTO `r_user_role` VALUES (4, 3);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父类id',
  `sort` tinyint(4) NULL DEFAULT NULL COMMENT '排序',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '描述',
  `icon` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统菜单' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', NULL, 0, 1, NULL, 'ios-flower');
INSERT INTO `sys_menu` VALUES (2, '菜单2', NULL, 0, 2, NULL, 'ios-flower-outline');
INSERT INTO `sys_menu` VALUES (3, '菜单3', NULL, 0, 3, NULL, 'ios-rose');
INSERT INTO `sys_menu` VALUES (4, '用户管理', '/base/user', 1, 1, NULL, 'ios-person');
INSERT INTO `sys_menu` VALUES (5, '菜单管理', '/base/menu', 1, 2, NULL, 'android-list');
INSERT INTO `sys_menu` VALUES (6, '角色管理', '/base/role', 1, 3, NULL, 'ios-people');
INSERT INTO `sys_menu` VALUES (7, '子菜单22', '/base/test4', 2, 2, NULL, 'ios-reverse-camera-outline');
INSERT INTO `sys_menu` VALUES (8, '子菜单31', '/base/test5', 3, 1, NULL, 'ios-eye');
INSERT INTO `sys_menu` VALUES (9, '子菜单32', '/base/test6', 3, 2, NULL, 'ios-eye-outline');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `modules` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '权限',
  `describe` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'ROLE_ADMIN', '管理员', '4;5;6;', '管理员');
INSERT INTO `sys_role` VALUES (2, 'ROLE_TEST1', 'test1', '7;', '测试1');
INSERT INTO `sys_role` VALUES (3, 'ROLE_TEST2', 'test2', '9;8;', '测试2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录名',
  `password` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `sex` int(2) NULL DEFAULT NULL,
  `creat_time` datetime(0) NULL DEFAULT NULL,
  `phone_num` bigint(13) NULL DEFAULT NULL,
  `status` int(2) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `login_name`(`login_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'William', 'admin', '123456', NULL, NULL, '2018-09-03 15:01:04', NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
