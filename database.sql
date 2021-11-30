/*
SQLyog Enterprise - MySQL GUI v6.56
MySQL - 5.0.67-community-nt : Database - housing_society
*********************************************************************
*/member_model

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;
mysqlmysql
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`housing_society` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `housing_society`;

/*Table structure for table `complaint_model` */

DROP TABLE IF EXISTS `complaint_model`;

CREATE TABLE `complaint_model` (
  `id` int(11) NOT NULL,
  `complaint` varchar(255) default NULL,
  `date` varchar(255) default NULL,
  `hno` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `complaint_model` */

/*Table structure for table `expenses_model` */

DROP TABLE IF EXISTS `expenses_model`;

CREATE TABLE `expenses_model` (
  `id` int(11) NOT NULL,
  `cleaning` float NOT NULL,
  `event` varchar(255) default NULL,
  `eventcost` float NOT NULL,
  `hno` varchar(255) default NULL,
  `parking` float NOT NULL,
  `salary` float NOT NULL,
  `status` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `expenses_model` */

/*Table structure for table `expenses_paid` */

DROP TABLE IF EXISTS `expenses_paid`;

CREATE TABLE `expenses_paid` (
  `id` int(11) NOT NULL,
  `expenseid` varchar(255) default NULL,
  `hno` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `expenses_paid` */

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (17);

/*Table structure for table `member_model` */

DROP TABLE IF EXISTS `member_model`;

CREATE TABLE `member_model` (
  `id` int(11) NOT NULL,
  `email` varchar(255) default NULL,
  `hdescription` varchar(255) default NULL,
  `hno` varchar(255) default NULL,
  `mobile` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `sid` varchar(255) default NULL,
  `sqareyards` varchar(255) default NULL,
  `status1` varchar(255) default NULL,
  `status2` varchar(255) default NULL,
  `status3` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `member_model` */

/*Table structure for table `society_model` */

DROP TABLE IF EXISTS `society_model`;

CREATE TABLE `society_model` (
  `id` int(11) NOT NULL,
  `sid` varchar(255) default NULL,
  `societyaddress` varchar(255) default NULL,
  `societycity` varchar(255) default NULL,
  `societyhouses` varchar(255) default NULL,
  `societyname` varchar(255) default NULL,
  `societypincode` varchar(255) default NULL,
  `status1` varchar(255) default NULL,
  `status2` varchar(255) default NULL,
  `status3` varchar(255) default NULL,
  `housetype` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `society_model` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
