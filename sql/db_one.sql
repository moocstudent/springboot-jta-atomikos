/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.7.21 : Database - db_one
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_one` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_one`;

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(32) NOT NULL COMMENT '账户',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `nickname` varchar(32) NOT NULL COMMENT '昵称',
  `salt` varchar(45) NOT NULL COMMENT '盐值',
  `delete_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除 0：正常 1：删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`pk_id`,`account`,`password`,`nickname`,`salt`,`delete_flag`,`create_time`) values (1,'DevilMafia','10a59874b8da091dfae55f530e22c44f5356f4f322fd99fc4aa2fcb76bebe637efd3484080bfe1c0f3b368b49bf353ef678182890ea3ef0d846da583258efaff','大憨豆先生。','731f1836f5f29021cbfa9312f7fcb7b4',0,'2018-11-12 16:43:27');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
