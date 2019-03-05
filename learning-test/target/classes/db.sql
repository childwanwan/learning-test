//用户表
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `username` varchar(255) NOT NULL COMMENT 'username',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `role` int(255) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`),
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

//故障表
CREATE TABLE `fault` (
  `id` varchar(50) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '故障单名称',
  `create_date` date DEFAULT NULL,
  `influence_system` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '影响的系统',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '故障单描述',
  `branch` int(50) NOT NULL COMMENT '分支',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '提交人',
  `status` int(255) DEFAULT NULL COMMENT '状态，0已转派，1待转派，2成功处理',
  `url` varchar(255) DEFAULT NULL COMMENT '文件地址',
  `to_username` varchar(255) DEFAULT NULL COMMENT '转派给谁',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `branch_id` (`branch`),
  CONSTRAINT `branch_id` FOREIGN KEY (`branch`) REFERENCES `branch` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

//故障处理表
CREATE TABLE `deal_fault` (
  `id` varchar(50) NOT NULL,
  `fault_id` varchar(50) DEFAULT NULL,
  `status` int(255) DEFAULT NULL COMMENT '状态0未处理，1是处理,并派发',
  `to_username` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `operate_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fault_id` (`fault_id`),
  KEY `user_username` (`to_username`),
  CONSTRAINT `fault_id` FOREIGN KEY (`fault_id`) REFERENCES `fault` (`id`),
  CONSTRAINT `user_username` FOREIGN KEY (`to_username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

//branch
CREATE TABLE `branch` (
  `id` int(50) NOT NULL,
  `branch_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;