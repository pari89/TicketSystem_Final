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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `sysid` varchar(45) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(45) NOT NULL,
  `usertype` varchar(45) NOT NULL,
  `userstatus` tinyint NOT NULL,
  `availabilty` tinyint DEFAULT NULL,
  `setype` varchar(45) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`sysid`,`username`),
  UNIQUE KEY `sysid_UNIQUE` (`sysid`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('04c53a53-2382-4d58-9ab7-8abc47f0414e','Vamsi','9191','ServiceEngineer',1,0,'General','Parinitha.Pembarthi@planonsoftware.com'),('09158aa0-18f8-4454-bbf1-22fdecaddced','Narmada','2424','ServiceEngineer',1,1,'Finance','Parinitha.Pembarthi@planonsoftware.com'),('2450d3fd-8a7c-4cbe-9f8e-e516ad6ace83','Lukman','9090','EndUser',0,1,NULL,'mohdluqmanuddin.siddiqui@planonsoftware.com'),('38007e83-28b2-4431-97d9-ac07e4f9a030','Parinitha','8989','Admin',1,1,NULL,'Parinitha.Pembarthi@planonsoftware.com'),('3e9f2bc8-e023-4def-918d-5c3efe172d23','Veda','1515','ServiceEngineer',0,0,'General','Parinitha.Pembarthi@planonsoftware.com'),('6388a9e1-282c-4446-aa61-59b76e1f3cad','Tanushri','2525','EndUser',1,1,NULL,'Parinitha.Pembarthi@planonsoftware.com'),('8ab25fb2-3cc3-40c3-8ecc-2fbb1e5f44e0','Bhavita','3131','ServiceEngineer',1,0,'Finance','Parinitha.Pembarthi@planonsoftware.com'),('a722f11c-5901-47ba-8ba4-8755757e8a96','Naveen','8080','EndUser',0,1,NULL,'mohdluqmanuddin.siddiqui@planonsoftware.com'),('b528dc50-ebdb-46da-af18-99b51bbe6d53','Srinivas','1414','ServiceEngineer',1,1,'Technical','Parinitha.Pembarthi@planonsoftware.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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
