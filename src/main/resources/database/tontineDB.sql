/*
SQLyog Trial v13.1.8 (64 bit)
MySQL - 8.0.31 : Database - tontine
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tontine` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `tontine`;

/*Table structure for table `adherant` */

DROP TABLE IF EXISTS `adherant`;

CREATE TABLE `adherant` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `date_naissance` date NOT NULL,
  `date_adhesion` date DEFAULT NULL,
  `contact` int DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `sexe` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `adherant` */

insert  into `adherant`(`id`,`nom`,`prenom`,`date_naissance`,`date_adhesion`,`contact`,`email`,`sexe`) values 
(1,'Abdonise ','Abélie ','1990-02-23','2023-01-01',4544544,'Abélie@ton.cm',NULL),
(2,'Astou ','kim ','1990-01-03','2023-01-01',654544544,'Astou@ton.cm',NULL),
(3,'Diango ','Koffi ','1990-01-03','2023-01-01',654544544,'Astou@ton.cm',NULL),
(4,'Diango ','Coumba ','1990-08-08','2023-01-01',654544544,'Astou@ton.cm',NULL),
(5,'Demba ','Meyya ','1990-08-08','2023-01-01',654544544,'Astou@ton.cm',NULL),
(6,'Mesha','prenom','2020-12-12','2020-12-12',343433,'mesha@ton.com','M'),
(7,'Mesha','Vegas','2006-12-12','2016-12-12',68141,'vEGAS@MESHA','M'),
(8,'Mesha','Vegas','2006-12-12','2016-12-12',68141,'vEGAS@MESHA','M'),
(9,'mesha','Vegas','2010-06-12','2020-06-12',68141,'','F');

/*Table structure for table `credit` */

DROP TABLE IF EXISTS `credit`;

CREATE TABLE `credit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `adherant_id` int DEFAULT NULL,
  `sceance_id` int DEFAULT NULL,
  `montant` float DEFAULT NULL,
  `date_pret` datetime DEFAULT NULL,
  `date_limite` datetime DEFAULT NULL,
  `taux_interet` float NOT NULL,
  `etat` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_credit_adherant` (`adherant_id`),
  KEY `fk_credit_sceance` (`sceance_id`),
  CONSTRAINT `fk_credit_adherant` FOREIGN KEY (`adherant_id`) REFERENCES `adherant` (`id`),
  CONSTRAINT `fk_credit_sceance` FOREIGN KEY (`sceance_id`) REFERENCES `sceance` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `credit` */

insert  into `credit`(`id`,`adherant_id`,`sceance_id`,`montant`,`date_pret`,`date_limite`,`taux_interet`,`etat`) values 
(1,1,1,20000,'2023-02-16 00:00:00','2023-03-16 00:00:00',0.2,'Active'),
(2,2,1,10000,'2023-02-16 00:00:00','2023-03-16 00:00:00',0.2,'Active'),
(3,4,2,60000,'2023-02-16 00:00:00','2023-03-16 00:00:00',0.9,'Active');

/*Table structure for table `epargne` */

DROP TABLE IF EXISTS `epargne`;

CREATE TABLE `epargne` (
  `id` int NOT NULL AUTO_INCREMENT,
  `adherant_id` int DEFAULT NULL,
  `sceance_id` int DEFAULT NULL,
  `montant` float DEFAULT NULL,
  `date_epargne` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_epargne_adherant` (`adherant_id`),
  KEY `fk_epargne_sceance` (`sceance_id`),
  CONSTRAINT `fk_epargne_adherant` FOREIGN KEY (`adherant_id`) REFERENCES `adherant` (`id`),
  CONSTRAINT `fk_epargne_sceance` FOREIGN KEY (`sceance_id`) REFERENCES `sceance` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `epargne` */

insert  into `epargne`(`id`,`adherant_id`,`sceance_id`,`montant`,`date_epargne`) values 
(1,1,1,2000,'2023-01-01 00:00:00'),
(2,6,1,500000,'2021-01-01 00:00:00'),
(3,1,4,2000,'2021-01-01 00:00:00'),
(5,1,1,2000,'2021-01-01 00:00:00');

/*Table structure for table `rembousement` */

DROP TABLE IF EXISTS `rembousement`;

CREATE TABLE `rembousement` (
  `id` int NOT NULL AUTO_INCREMENT,
  `credit_id` int DEFAULT NULL,
  `montant` float DEFAULT NULL,
  `date_rembouserment` datetime DEFAULT NULL,
  `sceance_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_rembousement_adherant` (`credit_id`),
  KEY `fk_rembousement_sceance` (`sceance_id`),
  CONSTRAINT `fk_rembousement_adherant` FOREIGN KEY (`credit_id`) REFERENCES `credit` (`id`),
  CONSTRAINT `fk_rembousement_sceance` FOREIGN KEY (`sceance_id`) REFERENCES `sceance` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `rembousement` */

/*Table structure for table `sceance` */

DROP TABLE IF EXISTS `sceance`;

CREATE TABLE `sceance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dateSeance` date NOT NULL,
  `lieu` varchar(45) DEFAULT NULL,
  `heure_debut` datetime DEFAULT NULL,
  `heure_fin` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `sceance` */

insert  into `sceance`(`id`,`dateSeance`,`lieu`,`heure_debut`,`heure_fin`) values 
(1,'2023-01-01','MFOU','2023-01-01 10:34:09','2023-01-01 14:34:09'),
(2,'2023-01-05','MFOU','2023-01-05 10:34:09','2023-01-05 14:34:09'),
(3,'2023-01-08','MFOU','2023-01-08 10:34:09','2023-01-08 14:34:09'),
(4,'2023-01-10','MFOU','2023-01-10 10:34:09','2023-01-10 14:34:09'),
(5,'2023-01-14','MFOU','2023-01-14 10:34:09','2023-01-14 14:34:09');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `passwrd` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`passwrd`) values 
(1,'mesha','a50a526a62bb4e836d49100e8e812342');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
