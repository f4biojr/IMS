/*
SQLyog Community v8.4 
MySQL - 5.1.41-3ubuntu12.3 : Database - ims3
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ims3` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ims3`;

/*Table structure for table `estado` */

DROP TABLE IF EXISTS `estado`;

CREATE TABLE `estado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_servidor` int(11) DEFAULT NULL,
  `id_servico` int(11) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `horario` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id_servidor` (`id_servidor`),
  KEY `id_servico` (`id_servico`),
  CONSTRAINT `estado_ibfk_1` FOREIGN KEY (`id_servidor`) REFERENCES `servidores` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `estado_ibfk_2` FOREIGN KEY (`id_servico`) REFERENCES `servicos` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;

/*Data for the table `estado` */

insert  into `estado`(`id`,`id_servidor`,`id_servico`,`estado`,`horario`) values (44,1,1,'1998840','2010-06-17 14:31:25'),(45,1,2,'3057264','2010-06-17 14:31:25'),(46,1,4,'3309448','2010-06-17 14:31:25'),(47,1,7,'0.49','2010-06-17 14:31:25'),(48,1,1,'1998840','2010-06-17 14:32:52'),(49,1,2,'3057264','2010-06-17 14:32:52'),(50,1,4,'3314340','2010-06-17 14:32:52'),(51,1,7,'0.37','2010-06-17 14:32:52'),(52,1,1,'1998840','2010-06-17 19:38:04'),(53,1,2,'3057264','2010-06-17 19:38:04'),(54,1,4,'4135000','2010-06-17 19:38:04'),(55,1,7,'1.00','2010-06-17 19:38:04'),(56,1,1,'1998840','2010-06-17 19:38:48'),(57,1,2,'3057264','2010-06-17 19:38:48'),(58,1,4,'4117668','2010-06-17 19:38:48'),(59,1,7,'0.73','2010-06-17 19:38:48');

/*Table structure for table `servicos` */

DROP TABLE IF EXISTS `servicos`;

CREATE TABLE `servicos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT NULL,
  `mib` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `servicos` */

insert  into `servicos`(`id`,`nome`,`mib`) values (0,'',''),(1,'memTotalSwap','.1.3.6.1.4.1.2021.4.4.0'),(2,'memAvailSwap','.1.3.6.1.4.1.2021.4.5.0'),(3,'memTotalReal','.1.3.6.1.4.1.2021.4.6.0'),(4,'memAvailReal','.1.3.6.1.4.1.2021.4.11.0'),(5,'memTotalFree','.1.3.6.1.4.1.2021.4.12.0'),(6,'ipAdEntAddr','.1.3.6.1.2.1.4.20.1.2'),(7,'laLoad.1','.1.3.6.1.4.1.2021.10.1.3.1'),(8,'laLoad.2','.1.3.6.1.4.1.2021.10.1.3.2'),(9,'laLoad.3','.1.3.6.1.4.1.2021.10.1.3.3'),(10,'sysContact','.1.3.6.1.2.1.1.4.0');

/*Table structure for table `servidor_has_servicos` */

DROP TABLE IF EXISTS `servidor_has_servicos`;

CREATE TABLE `servidor_has_servicos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_servidor` int(11) DEFAULT NULL,
  `id_servico` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_servidor` (`id_servidor`),
  KEY `id_servico` (`id_servico`),
  CONSTRAINT `servidor_has_servicos_ibfk_1` FOREIGN KEY (`id_servidor`) REFERENCES `servidores` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `servidor_has_servicos_ibfk_2` FOREIGN KEY (`id_servico`) REFERENCES `servicos` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `servidor_has_servicos` */

insert  into `servidor_has_servicos`(`id`,`id_servidor`,`id_servico`) values (9,1,1),(10,1,2),(11,1,4),(12,1,7);

/*Table structure for table `servidores` */

DROP TABLE IF EXISTS `servidores`;

CREATE TABLE `servidores` (
  `id` int(11) NOT NULL,
  `ip` varchar(15) DEFAULT NULL,
  `community` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `servidores` */

insert  into `servidores`(`id`,`ip`,`community`) values (1,'127.0.0.1','public');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
