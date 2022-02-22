CREATE DATABASE  IF NOT EXISTS `users` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `users`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: users
-- ------------------------------------------------------
-- Server version	8.0.27

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

--
-- Table structure for table `addition_jurnal_backup`
--

DROP TABLE IF EXISTS `addition_jurnal_backup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addition_jurnal_backup` (
  `idaddition_jurnal_backup` int NOT NULL AUTO_INCREMENT,
  `idaddition_jurnal` varchar(45) NOT NULL,
  `idbook` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `idadmin` varchar(45) NOT NULL,
  `idrepresentative` varchar(45) NOT NULL,
  `action` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`idaddition_jurnal_backup`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addition_jurnal_backup`
--

LOCK TABLES `addition_jurnal_backup` WRITE;
/*!40000 ALTER TABLE `addition_jurnal_backup` DISABLE KEYS */;
INSERT INTO `addition_jurnal_backup` VALUES (1,'1','17','Tue Dec 21 23:49:08 MSK 2021','1','22','insert','valid'),(2,'1','17','Tue Dec 21 23:49:08 MSK 2021','1','22','insert','valid'),(3,'1','17','Tue Dec 21 23:49:08 MSK 2021','1','22','insert','nullified'),(4,'1','17','Tue Dec 21 23:49:08 MSK 2021','1','22','insert','nullified'),(5,'1','17','Tue Dec 21 23:49:08 MSK 2021','1','22','insert','nullified'),(6,'1','17','Tue Dec 21 23:49:08 MSK 2021','1','22','insert','nullified'),(7,'1','17','Tue Dec 21 23:49:08 MSK 2021','1','22','insert','valid'),(8,'1','17','Tue Dec 21 23:49:08 MSK 2021','1','22','insert','nullified'),(9,'1','17','Tue Dec 21 23:49:08 MSK 2021','1','22','insert','nullified'),(10,'1','17','Tue Dec 21 23:49:08 MSK 2021','1','22','insert','nullified'),(11,'1','17','Tue Dec 21 23:49:08 MSK 2021','1','22','insert','nullified'),(12,'1','17','Tue Dec 21 23:49:08 MSK 2021','1','22','insert','nullified'),(13,'1','17','Tue Dec 21 23:49:08 MSK 2021','1','22','insert','nullified'),(14,'1','17','Tue Dec 21 23:49:08 MSK 2021','1','22','insert','nullified'),(15,'1','17','Tue Dec 21 23:49:08 MSK 2021','1','22','insert','nullified'),(16,'1','17','Tue Dec 21 23:49:08 MSK 2021','1','22','insert','nullified'),(17,'1','17','Tue Dec 21 23:49:08 MSK 2021','1','22','insert','nullified'),(18,'1','17','Tue Dec 21 23:49:08 MSK 2021','1','22','insert','nullified');
/*!40000 ALTER TABLE `addition_jurnal_backup` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-24  9:52:47
