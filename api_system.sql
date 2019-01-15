# Host: localhost  (Version: 5.5.53)
# Date: 2019-01-15 23:05:46
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "api_menu"
#

DROP TABLE IF EXISTS `api_menu`;
CREATE TABLE `api_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `path` varchar(100) NOT NULL DEFAULT '' COMMENT '菜单路径',
  `icon` varchar(100) NOT NULL DEFAULT '' COMMENT '图标的class',
  `sort` tinyint(3) NOT NULL DEFAULT '0' COMMENT '排序',
  `is_show` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否显示',
  `level` tinyint(1) NOT NULL DEFAULT '1' COMMENT '菜单层级',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `modify_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

#
# Data for table "api_menu"
#


#
# Structure for table "api_product"
#

DROP TABLE IF EXISTS `api_product`;
CREATE TABLE `api_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sku` varchar(30) NOT NULL DEFAULT '' COMMENT 'sku',
  `cn_name` varchar(120) NOT NULL DEFAULT '' COMMENT '名称',
  `weight` decimal(6,3) NOT NULL DEFAULT '0.000' COMMENT '重量',
  `price` decimal(11,2) NOT NULL DEFAULT '0.00' COMMENT '价格',
  `supplier_name` varchar(50) NOT NULL DEFAULT '' COMMENT '供应商名称',
  `sku_link` varchar(200) NOT NULL DEFAULT '' COMMENT '供应商产品详情链接',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `sales_volume` int(11) NOT NULL DEFAULT '0' COMMENT '销量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='产品主信息表';

#
# Data for table "api_product"
#

INSERT INTO `api_product` VALUES (1,'ywsj001','中文名称1',100.000,210.00,'义乌三杰','','0000-00-00 00:00:00','0000-00-00 00:00:00',0),(4,'3333','33331',3.000,3.00,'31','31','0000-00-00 00:00:00','0000-00-00 00:00:00',1),(5,'4444','44',44.000,441.00,'4444','444','0000-00-00 00:00:00','0000-00-00 00:00:00',4),(6,'5555','555',5.000,55.00,'5555','5555','0000-00-00 00:00:00','0000-00-00 00:00:00',5);

#
# Structure for table "api_product_picture"
#

DROP TABLE IF EXISTS `api_product_picture`;
CREATE TABLE `api_product_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL DEFAULT '0' COMMENT '产品id',
  `sku` varchar(30) NOT NULL DEFAULT '' COMMENT 'sku',
  `picture_path` varchar(500) NOT NULL DEFAULT '' COMMENT '图片路径',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `picture_type` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '图片类型,1主图，2附属图',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品图片信息表';

#
# Data for table "api_product_picture"
#


#
# Structure for table "api_product_stock"
#

DROP TABLE IF EXISTS `api_product_stock`;
CREATE TABLE `api_product_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL DEFAULT '0' COMMENT '产品id',
  `sku` varchar(30) NOT NULL DEFAULT '' COMMENT 'sku',
  `real_quantity` int(11) NOT NULL DEFAULT '0' COMMENT '真实库存数量',
  `trans_quantity` int(11) NOT NULL DEFAULT '0' COMMENT '在途库存',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品库存信息表';

#
# Data for table "api_product_stock"
#


#
# Structure for table "api_role_permission"
#

DROP TABLE IF EXISTS `api_role_permission`;
CREATE TABLE `api_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL DEFAULT '0' COMMENT '角色id',
  `resouce_id` int(11) NOT NULL DEFAULT '0' COMMENT '资源id',
  `resouce_type` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1、菜单2、按钮',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `resouce_id` (`resouce_id`,`resouce_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';

#
# Data for table "api_role_permission"
#


#
# Structure for table "api_roles"
#

DROP TABLE IF EXISTS `api_roles`;
CREATE TABLE `api_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL DEFAULT '0',
  `role_name` varchar(20) NOT NULL DEFAULT '' COMMENT '角色名',
  `role_code` varchar(20) NOT NULL DEFAULT '' COMMENT '角色code',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `modify_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name` (`role_name`),
  UNIQUE KEY `role_code` (`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

#
# Data for table "api_roles"
#


#
# Structure for table "api_user"
#

DROP TABLE IF EXISTS `api_user`;
CREATE TABLE `api_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `pass_word` char(32) NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(15) NOT NULL DEFAULT '' COMMENT '姓名',
  `avater` varchar(200) NOT NULL DEFAULT '' COMMENT '照片',
  `telphone` varchar(11) NOT NULL DEFAULT '' COMMENT '手机号',
  `dep_id` int(11) NOT NULL DEFAULT '0' COMMENT '部门id',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `token` char(32) NOT NULL DEFAULT '' COMMENT 'token',
  `token_expire` bigint(20) NOT NULL DEFAULT '0' COMMENT '过期时间戳',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `modify_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`),
  KEY `token` (`token`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户表';

#
# Data for table "api_user"
#

INSERT INTO `api_user` VALUES (2,'test','e10adc3949ba59abbe56e057f20f883e','测试用户1','','',0,1,'41cd217dedd91095e5db64e7f166c7ad',1536741780,'0000-00-00 00:00:00','0000-00-00 00:00:00'),(4,'wiggin','e10adc3949ba59abbe56e057f20f883e','wiggin','','',0,1,'2f21337d0492455e906de9784f26961b',1547563082755,'0000-00-00 00:00:00','2018-09-12 07:43:44');

#
# Structure for table "api_user_roles"
#

DROP TABLE IF EXISTS `api_user_roles`;
CREATE TABLE `api_user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `role_id` int(11) NOT NULL DEFAULT '0' COMMENT '角色id',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

#
# Data for table "api_user_roles"
#

