/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.7.21 : Database - db_two
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_two` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `db_two`;

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(32) NOT NULL COMMENT '账户',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态 0：正常 1：禁用',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_admin` */

insert  into `t_admin`(`pk_id`,`account`,`password`,`status`) values (1,'DevilMafia','123',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
