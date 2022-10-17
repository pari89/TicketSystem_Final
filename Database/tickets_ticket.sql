-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: tickets
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `ticketid` int NOT NULL,
  `ticketname` varchar(20) NOT NULL,
  `tickettype` varchar(45) NOT NULL,
  `enduser` varchar(45) NOT NULL,
  `serviceeng` varchar(45) DEFAULT NULL,
  `ticketstatus` varchar(45) DEFAULT NULL,
  `ticketdes` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `ticketdate` datetime DEFAULT NULL,
  PRIMARY KEY (`enduser`,`ticketid`),
  UNIQUE KEY `ticketid_UNIQUE` (`ticketid`),
  KEY `enduser_idx` (`enduser`),
  CONSTRAINT `enduser` FOREIGN KEY (`enduser`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,'Earphones','General','Tanushri','Veda','open','need new earphones','2022-10-10 10:33:27'),(2,'Bags','General','Tanushri','vamsi','open','Didn\'t receive bags','2022-10-10 10:34:00'),(3,'Salary','Finance','Tanushri','Narmada','close','Salary increment','2022-10-10 10:34:25'),(4,'Salary','Finance','Tanushri','Bhavita','close','Salary decrement','2022-10-10 10:34:56'),(5,'Credit card','Finance','Tanushri','Narmada','open','Credit card problem','2022-10-10 10:35:36'),(6,'Website','Technical','Tanushri','Srinivas','close','Website down','2022-10-10 10:36:17'),(7,'Database','Technical','Tanushri','Srinivas','hold','Database down','2022-10-10 10:36:47'),(8,'Credit card','Finance','Tanushri','Bhavita','open','Not able to apply for credit card','2022-10-13 10:58:43'),(9,'Mouse','Technical','Tanushri','Srinivas','hold','Mouse isn\'t working','2022-10-17 10:18:15');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-17 11:36:37
