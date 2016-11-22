-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: volunteer_database
-- ------------------------------------------------------
-- Server version	5.7.15-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `volunteer`
--

DROP TABLE IF EXISTS `volunteer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `volunteer` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobile_number` varchar(50) DEFAULT NULL,
  `date_started` date DEFAULT NULL,
  `status` int(20) DEFAULT '1',
  `gender` int(10) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volunteer`
--

LOCK TABLES `volunteer` WRITE;
/*!40000 ALTER TABLE `volunteer` DISABLE KEYS */;
INSERT INTO `volunteer` VALUES (2,'Andrew','Sherman',26,'andrew@gmail.com','2829102345','2000-02-01',1,0),(3,'Mary','Stera',32,'ahsn_332@yahoo.com','234234234','2010-04-07',1,1),(4,'Sam','Smithy',54,'smihgsh@gmail.com','947276222','2004-06-24',1,0),(5,'Wendy','Wailer',76,'wnehy32@yahoo.com','76643334','2016-02-05',1,1),(7,'Cory','Mant',29,'coregsy@yahoo.com','8263833443','2010-06-14',0,0),(8,'Albert','Sui',30,'al34b@gmail.com','893237234','2016-07-25',1,0),(9,'Penny','Doris',37,'penshykj@email.com','4393032334','2012-12-19',2,1),(10,'Robert','Cena',45,'rob555@robaer.com','82739222333','2011-11-24',1,0),(23,'Randy','Chan',36,'ran@yahoo.com','3829374233','2014-06-04',0,0),(24,'Mary','Sue',43,'mmmshye@gmail.com','3222399332','2011-02-22',2,1),(25,'Der','Ham',22,'hsye@yahoo.com','3829304233','2014-11-19',2,1);
/*!40000 ALTER TABLE `volunteer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-23  0:13:11
