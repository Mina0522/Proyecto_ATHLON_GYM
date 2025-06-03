-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: bna0qopo8smun5oybrpg-mysql.services.clever-cloud.com    Database: bna0qopo8smun5oybrpg
-- ------------------------------------------------------
-- Server version	8.0.22-13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'a05a675a-1414-11e9-9c82-cecd01b08c7e:1-491550428,
a38a16d0-767a-11eb-abe2-cecd029e558e:1-553758493';

--
-- Table structure for table `adminTable`
--

DROP TABLE IF EXISTS `adminTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adminTable` (
  `id_admin` int NOT NULL,
  `user` varchar(45) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminTable`
--

LOCK TABLES `adminTable` WRITE;
/*!40000 ALTER TABLE `adminTable` DISABLE KEYS */;
INSERT INTO `adminTable` VALUES (1,'admin','$2a$12$YcIYpIbAAmgELxAsugo0c.lqhT/Z1.fshnUw4Jz5V/ALq4nkENbH6');
/*!40000 ALTER TABLE `adminTable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_plan_types`
--

DROP TABLE IF EXISTS `class_plan_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_plan_types` (
  `id_membership` int NOT NULL,
  `id_class_type` int NOT NULL,
  PRIMARY KEY (`id_membership`,`id_class_type`),
  KEY `class_plan_types_ibfk_2` (`id_class_type`),
  CONSTRAINT `class_plan_types_ibfk_1` FOREIGN KEY (`id_membership`) REFERENCES `membership` (`id`),
  CONSTRAINT `class_plan_types_ibfk_2` FOREIGN KEY (`id_class_type`) REFERENCES `class_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_plan_types`
--

LOCK TABLES `class_plan_types` WRITE;
/*!40000 ALTER TABLE `class_plan_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_plan_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_session`
--

DROP TABLE IF EXISTS `class_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_session` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_instructor` int NOT NULL,
  `id_class_type` int NOT NULL,
  `session_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `class_session_ibfk_1` (`id_instructor`),
  KEY `class_session_ibfk_2` (`id_class_type`),
  CONSTRAINT `class_session_ibfk_1` FOREIGN KEY (`id_instructor`) REFERENCES `instructor` (`id`),
  CONSTRAINT `class_session_ibfk_2` FOREIGN KEY (`id_class_type`) REFERENCES `class_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_session`
--

LOCK TABLES `class_session` WRITE;
/*!40000 ALTER TABLE `class_session` DISABLE KEYS */;
INSERT INTO `class_session` VALUES (1,1,1,'2025-06-02'),(2,2,1,'2025-05-01'),(3,3,3,'2025-05-20');
/*!40000 ALTER TABLE `class_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_type`
--

DROP TABLE IF EXISTS `class_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type_name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_type`
--

LOCK TABLES `class_type` WRITE;
/*!40000 ALTER TABLE `class_type` DISABLE KEYS */;
INSERT INTO `class_type` VALUES (1,'yoga'),(2,'pilates'),(3,'pesas');
/*!40000 ALTER TABLE `class_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `id_instructor_type` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `instructor_ibfk_1` (`id_instructor_type`),
  CONSTRAINT `instructor_ibfk_1` FOREIGN KEY (`id_instructor_type`) REFERENCES `instructor_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES (1,'Andoni',NULL,'6131000999',1),(2,'Carlos',NULL,'1234567890',2),(3,'Adrian',NULL,'5479754456',2),(4,'Moises',NULL,'6756543256',1);
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor_type`
--

DROP TABLE IF EXISTS `instructor_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type_name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor_type`
--

LOCK TABLES `instructor_type` WRITE;
/*!40000 ALTER TABLE `instructor_type` DISABLE KEYS */;
INSERT INTO `instructor_type` VALUES (1,'general'),(2,'personal');
/*!40000 ALTER TABLE `instructor_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` int NOT NULL AUTO_INCREMENT,
  `control_num` int NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `control_num_UNIQUE` (`control_num`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,226576,'Pedrito','Sola','6136666666'),(2,265289,'Chrisopher','Larkin','0180000000'),(3,489120,'Cristiano','Ronaldo','7135095123'),(8,287172,'el pepe','rojas','61232131231'),(9,374680,'asda','adas','12312'),(10,485990,'asda','adas','12312');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_class_registration`
--

DROP TABLE IF EXISTS `member_class_registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member_class_registration` (
  `id_member` int NOT NULL,
  `id_class_session` int NOT NULL,
  `registration_date` date NOT NULL,
  PRIMARY KEY (`id_member`,`id_class_session`),
  KEY `member_class_registration_ibfk_2` (`id_class_session`),
  CONSTRAINT `member_class_registration_ibfk_1` FOREIGN KEY (`id_member`) REFERENCES `member` (`id`),
  CONSTRAINT `member_class_registration_ibfk_2` FOREIGN KEY (`id_class_session`) REFERENCES `class_session` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_class_registration`
--

LOCK TABLES `member_class_registration` WRITE;
/*!40000 ALTER TABLE `member_class_registration` DISABLE KEYS */;
INSERT INTO `member_class_registration` VALUES (1,1,'2025-06-02'),(2,1,'2025-06-02'),(2,2,'2025-05-01');
/*!40000 ALTER TABLE `member_class_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membership`
--

DROP TABLE IF EXISTS `membership`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `membership` (
  `id` int NOT NULL AUTO_INCREMENT,
  `branches_number` int NOT NULL,
  `promotions` varchar(100) DEFAULT NULL,
  `has_invitation_pass` tinyint(1) NOT NULL,
  `duration_days` int NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membership`
--

LOCK TABLES `membership` WRITE;
/*!40000 ALTER TABLE `membership` DISABLE KEYS */;
INSERT INTO `membership` VALUES (1,1,'Ninguna',1,30,500),(2,3,'Ninguna',1,30,700),(3,1,'Ninguna',1,7,150);
/*!40000 ALTER TABLE `membership` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membership_payment`
--

DROP TABLE IF EXISTS `membership_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `membership_payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_member` int NOT NULL,
  `id_membership` int NOT NULL,
  `transaction_date` date NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `membership_payment_ibfk_1` (`id_member`),
  KEY `membership_payment_ibfk_2` (`id_membership`),
  CONSTRAINT `membership_payment_ibfk_1` FOREIGN KEY (`id_member`) REFERENCES `member` (`id`),
  CONSTRAINT `membership_payment_ibfk_2` FOREIGN KEY (`id_membership`) REFERENCES `membership` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membership_payment`
--

LOCK TABLES `membership_payment` WRITE;
/*!40000 ALTER TABLE `membership_payment` DISABLE KEYS */;
INSERT INTO `membership_payment` VALUES (2,1,1,'2025-06-01',500),(3,2,1,'2025-06-01',500),(4,3,2,'2025-06-01',700),(5,3,2,'2025-06-01',700),(6,3,2,'2025-06-01',700);
/*!40000 ALTER TABLE `membership_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan_instructor_types`
--

DROP TABLE IF EXISTS `plan_instructor_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan_instructor_types` (
  `id_instructor_type` int NOT NULL,
  `id_membership` int NOT NULL,
  PRIMARY KEY (`id_instructor_type`,`id_membership`),
  KEY `plan_instructor_types_ibfk_2` (`id_membership`),
  CONSTRAINT `plan_instructor_types_ibfk_1` FOREIGN KEY (`id_instructor_type`) REFERENCES `instructor_type` (`id`),
  CONSTRAINT `plan_instructor_types_ibfk_2` FOREIGN KEY (`id_membership`) REFERENCES `membership` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan_instructor_types`
--

LOCK TABLES `plan_instructor_types` WRITE;
/*!40000 ALTER TABLE `plan_instructor_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `plan_instructor_types` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-03  4:08:38
