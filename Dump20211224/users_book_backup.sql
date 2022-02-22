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
-- Table structure for table `book_backup`
--

DROP TABLE IF EXISTS `book_backup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_backup` (
  `idbook_backup` int NOT NULL AUTO_INCREMENT,
  `idbook` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  `idpublication` int NOT NULL,
  `idrepresentative` int NOT NULL,
  `purpose` varchar(45) NOT NULL,
  `type_of_content` varchar(45) NOT NULL,
  `action` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`idbook_backup`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_backup`
--

LOCK TABLES `book_backup` WRITE;
/*!40000 ALTER TABLE `book_backup` DISABLE KEYS */;
INSERT INTO `book_backup` VALUES (1,9,'asd','asd',4,4,'asd','asd','insert','valid'),(8,9,'ASS','asd',4,4,'asd','asd','update','valid'),(9,9,'ASS','ASS',4,4,'asd','asd','update','valid'),(10,9,'ASS','ASS',4,4,'asd','asd','update','valid'),(11,9,'ASS','asd',4,4,'asd','asd','update','valid'),(12,9,'ASS','asd',4,4,'asd','asd','update','valid'),(13,9,'ASS','asd',4,4,'asd','asd','update','valid'),(14,9,'ASS','asd',4,4,'asd','asd','update','valid'),(15,9,'ASS','ASS',4,4,'asd','asd','update','valid'),(16,1,'KEK','NIKITA',1,1,'KEK','KEK','update','valid'),(17,4,'kus','kus',4,4,'asd','asd ','update','valid'),(18,6,'xzcc','xzc',5,5,'czx','zcx','update','valid'),(19,8,'ваыва','выав',7,7,'ваы','выа','update','valid'),(20,9,'ASS','ASS',4,4,'asd','asd','update','valid'),(21,9,'ASS','ASS',4,4,'asd','asd','update','valid'),(22,9,'ASS','ASS',4,4,'asd','asd','update','valid'),(23,9,'ASS','ASS',4,4,'asd','asd','update','valid'),(24,9,'ASS','ASS',4,4,'asd','asd','update','valid'),(25,9,'ASS','ASS',4,4,'asd','asd','update','nullified'),(26,10,'asd','asd ',9,4,'asd','asd','insert','valid'),(27,10,'asd','asd ',9,4,'asd','asd','update','insert'),(28,11,'this','this',10,9,'this','this','insert','valid'),(29,11,'this','this',10,9,'this','this','update','valid'),(30,11,'this','this',10,9,'this','this','update','nullified'),(31,10,'asd','asd ',9,4,'asd','asd','update','valid'),(32,11,'this','this',10,9,'this','this','update','valid'),(33,1,'KEK','NIKITA',1,1,'ARTYOM','KEK','update','valid'),(34,16,'asd','asd',4,4,'asd','asd','insert','valid'),(35,17,'sss','sss',18,22,'s','s','insert','valid'),(36,17,'sss','sss',18,22,'s','s','update','valid'),(37,17,'sss','sss',18,22,'s','s','update','nullified');
/*!40000 ALTER TABLE `book_backup` ENABLE KEYS */;
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
