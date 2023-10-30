/*
 Navicat MySQL Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : mvc_zhoukai

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 31/12/2022 17:35:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `publish_time` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '截至时间',
  `u_id` int NULL DEFAULT NULL COMMENT '发布者',
  `commit_num` int NULL DEFAULT 0 COMMENT '提交数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of homework
-- ----------------------------
INSERT INTO `homework` VALUES (15, '软件文档写作qw', '2022-12-30 15:33:06', '2023-01-09 04:00:00', 2, 1);
INSERT INTO `homework` VALUES (16, '区块链技术', '2022-12-30 15:34:50', '2023-01-10 04:00:00', 2, 0);
INSERT INTO `homework` VALUES (17, 'mysql数据库设计', '2022-12-30 15:35:08', '2023-01-10 04:00:00', 2, 0);
INSERT INTO `homework` VALUES (18, '数学', '2022-12-31 09:08:21', '2023-01-01 04:00:00', 2, 0);

-- ----------------------------
-- Table structure for homework_answer
-- ----------------------------
DROP TABLE IF EXISTS `homework_answer`;
CREATE TABLE `homework_answer`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `t_id` int NULL DEFAULT NULL,
  `u_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `tb_task_answer_un`(`t_id`, `u_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of homework_answer
-- ----------------------------
INSERT INTO `homework_answer` VALUES (15, 13, '3', 'aaaaa', '2022-12-30 23:36:07');
INSERT INTO `homework_answer` VALUES (16, 13, '4', 'adadafaf', '2022-12-31 17:10:21');
INSERT INTO `homework_answer` VALUES (17, 15, '4', 'adadafafaaaa', '2022-12-31 17:10:33');

-- ----------------------------
-- Table structure for system_log
-- ----------------------------
DROP TABLE IF EXISTS `system_log`;
CREATE TABLE `system_log`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `u_id` int NULL DEFAULT NULL,
  `start_time` bigint NULL DEFAULT NULL,
  `end_time` bigint NULL DEFAULT NULL,
  `cost_time` bigint NULL DEFAULT NULL,
  `option_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 202 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_log
-- ----------------------------
INSERT INTO `system_log` VALUES (173, 'http://localhost:8046/api/log/list', 1, 1672414233405, 0, 0, '/api/log/list');
INSERT INTO `system_log` VALUES (174, 'http://localhost:8046/api/log/list', 1, 1672414239313, 0, 0, '/api/log/list');
INSERT INTO `system_log` VALUES (175, 'http://localhost:8046/api/log/list', 1, 1672414241899, 0, 0, '/api/log/list');
INSERT INTO `system_log` VALUES (176, 'http://localhost:8046/api/log/list', 1, 1672414246480, 0, 0, '/api/log/list');
INSERT INTO `system_log` VALUES (177, 'http://localhost:8046/api/task/list', 2, 1672414292149, 1672414292332, 183, '/api/task/list');
INSERT INTO `system_log` VALUES (178, 'http://localhost:8046/api/task', 2, 1672414306301, 1672414306576, 275, '/api/task');
INSERT INTO `system_log` VALUES (179, 'http://localhost:8046/api/task/list', 2, 1672414306686, 1672414306816, 130, '/api/task/list');
INSERT INTO `system_log` VALUES (180, 'http://localhost:8046/api/task', 2, 1672414340048, 1672414340293, 245, '/api/task');
INSERT INTO `system_log` VALUES (181, 'http://localhost:8046/api/task/list', 2, 1672414340387, 1672414340473, 86, '/api/task/list');
INSERT INTO `system_log` VALUES (182, 'http://localhost:8046/api/task', 2, 1672414386107, 1672414386303, 196, '/api/task');
INSERT INTO `system_log` VALUES (183, 'http://localhost:8046/api/task/list', 2, 1672414386412, 1672414386515, 103, '/api/task/list');
INSERT INTO `system_log` VALUES (184, 'http://localhost:8046/api/task/answer-list/13', 2, 1672414393653, 1672414393730, 77, '/api/task/answer-list/13');
INSERT INTO `system_log` VALUES (185, 'http://localhost:8046/api/task/answer-list/14', 2, 1672414397075, 1672414397152, 77, '/api/task/answer-list/14');
INSERT INTO `system_log` VALUES (186, 'http://localhost:8046/api/task/answer-list/15', 2, 1672414398703, 1672414398812, 109, '/api/task/answer-list/15');
INSERT INTO `system_log` VALUES (187, 'http://localhost:8046/api/task', 2, 1672414490261, 1672414490492, 231, '/api/task');
INSERT INTO `system_log` VALUES (188, 'http://localhost:8046/api/task/list', 2, 1672414490575, 1672414490654, 79, '/api/task/list');
INSERT INTO `system_log` VALUES (189, 'http://localhost:8046/api/task', 2, 1672414507407, 1672414507641, 234, '/api/task');
INSERT INTO `system_log` VALUES (190, 'http://localhost:8046/api/task/list', 2, 1672414507736, 1672414507820, 84, '/api/task/list');
INSERT INTO `system_log` VALUES (191, 'http://localhost:8046/api/task/answer-list/13', 2, 1672414512287, 1672414512361, 74, '/api/task/answer-list/13');
INSERT INTO `system_log` VALUES (192, 'http://localhost:8046/api/task/student/list', 3, 1672414558066, 1672414558157, 91, '/api/task/student/list');
INSERT INTO `system_log` VALUES (193, 'http://localhost:8046/api/task/answer', 3, 1672414567328, 1672414567658, 330, '/api/task/answer');
INSERT INTO `system_log` VALUES (194, 'http://localhost:8046/api/task/student/list', 3, 1672414567727, 1672414567807, 80, '/api/task/student/list');
INSERT INTO `system_log` VALUES (195, 'http://localhost:8046/api/task/student/list', 3, 1672414574558, 1672414574636, 78, '/api/task/student/list');
INSERT INTO `system_log` VALUES (196, 'http://localhost:8046/api/log/list', 1, 1672414778434, 0, 0, '/api/log/list');
INSERT INTO `system_log` VALUES (197, 'http://localhost:8046/api/log/list', 1, 1672414780599, 0, 0, '/api/log/list');
INSERT INTO `system_log` VALUES (198, 'http://localhost:8046/api/log/list', 1, 1672414780755, 0, 0, '/api/log/list');
INSERT INTO `system_log` VALUES (199, 'http://localhost:8046/api/log/list', 1, 1672414788703, 0, 0, '/api/log/list');
INSERT INTO `system_log` VALUES (200, 'http://localhost:8046/api/log/list', 1, 1672414788916, 0, 0, '/api/log/list');
INSERT INTO `system_log` VALUES (201, 'http://localhost:8046/api/log/list', 1, 1672414793698, 0, 0, '/api/log/list');
INSERT INTO `system_log` VALUES (202, 'http://localhost:8046/api/log/list', 1, 1672414889105, 1672414889293, 188, '/api/log/list');
INSERT INTO `system_log` VALUES (203, 'http://localhost:8046/api/modify-password', 1, 1672414913225, 1672414913676, 451, '/api/modify-password');
INSERT INTO `system_log` VALUES (204, 'http://localhost:8046/api/log/list', 1, 1672414961080, 1672414961212, 132, '/api/log/list');
INSERT INTO `system_log` VALUES (205, 'http://localhost:8046/api/modify-password', 1, 1672414970304, 1672414970532, 228, '/api/modify-password');
INSERT INTO `system_log` VALUES (206, 'http://localhost:8046/api/log/list', 1, 1672414994108, 1672414994278, 170, '/api/log/list');
INSERT INTO `system_log` VALUES (207, 'http://localhost:8046/api/log/list', 1, 1672476864814, 1672476864978, 164, '/api/log/list');
INSERT INTO `system_log` VALUES (208, 'http://localhost:8046/api/modify-password', 1, 1672476887478, 1672476887647, 169, '/api/modify-password');
INSERT INTO `system_log` VALUES (209, 'http://localhost:8046/api/modify-password', 1, 1672477129498, 1672477130003, 505, '/api/modify-password');
INSERT INTO `system_log` VALUES (210, 'http://localhost:8046/api/log/list', 1, 1672477566542, 1672477566772, 230, '/api/log/list');
INSERT INTO `system_log` VALUES (211, 'http://localhost:8046/api/modify-password', 1, 1672477584680, 1672477584864, 184, '/api/modify-password');
INSERT INTO `system_log` VALUES (212, 'http://localhost:8046/api/task/list', 2, 1672477671817, 1672477671995, 178, '/api/task/list');
INSERT INTO `system_log` VALUES (213, 'http://localhost:8046/api/task/answer-list/13', 2, 1672477678141, 1672477678293, 152, '/api/task/answer-list/13');
INSERT INTO `system_log` VALUES (214, 'http://localhost:8046/api/task', 2, 1672477701305, 1672477701509, 204, '/api/task');
INSERT INTO `system_log` VALUES (215, 'http://localhost:8046/api/task/list', 2, 1672477701662, 1672477701793, 131, '/api/task/list');
INSERT INTO `system_log` VALUES (216, 'http://localhost:8046/api/task/answer-list/13', 2, 1672477708014, 1672477708200, 186, '/api/task/answer-list/13');
INSERT INTO `system_log` VALUES (217, 'http://localhost:8046/api/task/14', 2, 1672477713059, 1672477713353, 294, '/api/task/14');
INSERT INTO `system_log` VALUES (218, 'http://localhost:8046/api/task/list', 2, 1672477713436, 1672477713531, 95, '/api/task/list');
INSERT INTO `system_log` VALUES (219, 'http://localhost:8046/api/task', 2, 1672477720057, 1672477720370, 313, '/api/task');
INSERT INTO `system_log` VALUES (220, 'http://localhost:8046/api/task/list', 2, 1672477720442, 1672477720518, 76, '/api/task/list');
INSERT INTO `system_log` VALUES (221, 'http://localhost:8046/api/task/answer-list/15', 2, 1672477723608, 1672477723697, 89, '/api/task/answer-list/15');
INSERT INTO `system_log` VALUES (222, 'http://localhost:8046/api/modify-password', 2, 1672477733115, 1672477733436, 321, '/api/modify-password');
INSERT INTO `system_log` VALUES (223, 'http://localhost:8046/api/task/student/list', 4, 1672477806300, 1672477806435, 135, '/api/task/student/list');
INSERT INTO `system_log` VALUES (224, 'http://localhost:8046/api/task/answer', 4, 1672477821671, 1672477821892, 221, '/api/task/answer');
INSERT INTO `system_log` VALUES (225, 'http://localhost:8046/api/task/student/list', 4, 1672477822012, 1672477822113, 101, '/api/task/student/list');
INSERT INTO `system_log` VALUES (226, 'http://localhost:8046/api/task/answer', 4, 1672477833462, 1672477833671, 209, '/api/task/answer');
INSERT INTO `system_log` VALUES (227, 'http://localhost:8046/api/task/student/list', 4, 1672477833763, 1672477833875, 112, '/api/task/student/list');
INSERT INTO `system_log` VALUES (228, 'http://localhost:8046/api/modify-password', 4, 1672477843827, 1672477844005, 178, '/api/modify-password');
INSERT INTO `system_log` VALUES (229, 'http://localhost:8046/api/task/list', 2, 1672477907780, 1672477907965, 185, '/api/task/list');
INSERT INTO `system_log` VALUES (230, 'http://localhost:8046/api/task/answer-list/13', 2, 1672477910428, 1672477910503, 75, '/api/task/answer-list/13');
INSERT INTO `system_log` VALUES (231, 'http://localhost:8046/api/task/13', 2, 1672477918115, 1672477918361, 246, '/api/task/13');
INSERT INTO `system_log` VALUES (232, 'http://localhost:8046/api/task/list', 2, 1672477918407, 1672477918487, 80, '/api/task/list');
INSERT INTO `system_log` VALUES (233, 'http://localhost:8046/api/task/list', 2, 1672477920760, 1672477920909, 149, '/api/task/list');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `role` int NOT NULL COMMENT '1 管理员 2 教师 3 学生',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', '4d5676abecdad0ca3f83c8e146829ac3', 1);
INSERT INTO `users` VALUES (2, '周凯', '827ccb0eea8a706c4c34a16891f84e7b', 2);
INSERT INTO `users` VALUES (3, '张三', '202cb962ac59075b964b07152d234b70', 3);
INSERT INTO `users` VALUES (4, '欧阳春', 'e10adc3949ba59abbe56e057f20f883e', 3);
INSERT INTO `users` VALUES (5, '刘新凯', '202cb962ac59075b964b07152d234b70', 2);
INSERT INTO `users` VALUES (6, '李四', '202cb962ac59075b964b07152d234b70', 2);
INSERT INTO `users` VALUES (7, '潘俊', '202cb962ac59075b964b07152d234b70', 3);

SET FOREIGN_KEY_CHECKS = 1;
