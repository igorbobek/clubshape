-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: clubshape
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `form`
--

DROP TABLE IF EXISTS `form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `form` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `size` int(11) NOT NULL,
  `description` longtext NOT NULL,
  `image` longtext NOT NULL,
  `main` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form`
--

LOCK TABLES `form` WRITE;
/*!40000 ALTER TABLE `form` DISABLE KEYS */;
INSERT INTO `form` VALUES (3,'Форма Arsenal №7 MKHITARYAN(2017-2018)',300,32,'Хорошая Форма=)','https://allsportsgames.by/files/products/IMG_20180424_162808_HDR.600x600.jpg?61e407fb662a96ab1a5fb0a700292529',1),(4,'Тренька АРСЕНАЛА',12312,32,'КРУТАЯ ФОРМА ПОКУПАЕМ','http://www.mmsport.ru/media/catalog/product/cache/3/image/9df78eab33525d08d6e5fb8d27136e95/7/4/747618-003-arsenal-training-jersey.jpg',0),(5,'adadfgadfg',123,123123,'asdfasdf','http://www.mmsport.ru/media/catalog/product/cache/3/image/9df78eab33525d08d6e5fb8d27136e95/7/4/747618-003-arsenal-training-jersey.jpg',0),(6,'dfgadfga',123123,123123,'asdfasdf','http://www.mmsport.ru/media/catalog/product/cache/3/image/9df78eab33525d08d6e5fb8d27136e95/7/4/747618-003-arsenal-training-jersey.jpg',0),(7,'dfgadfga',123123,123123,'asdfasdf','http://www.mmsport.ru/media/catalog/product/cache/3/image/9df78eab33525d08d6e5fb8d27136e95/7/4/747618-003-arsenal-training-jersey.jpg',0),(8,'asdf',0,0,'asdf','asdf',0),(9,'asdfasdf',0,0,'asdfasdf','aasdfasdf',1),(10,'asdfasdf',123123,123,'asdfasdf','asdfsa',0),(11,'asdasd',123,123,'asdfasdf','asdf',1),(12,'adsfasdf',123123,123,'asdfad','asdfasdf',1);
/*!40000 ALTER TABLE `form` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-15  2:18:29
