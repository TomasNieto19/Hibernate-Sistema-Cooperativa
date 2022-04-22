CREATE DATABASE  IF NOT EXISTS `bdCooperativa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bdCooperativa`;
-- MySQL dump 10.13  Distrib 8.0.25, for Linux (x86_64)
--
-- Host: localhost    Database: bdCooperativa
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `Almacen`
--

DROP TABLE IF EXISTS `Almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Almacen` (
  `idAlmacen` int NOT NULL,
  `cantDeseable` int NOT NULL,
  `cantMinima` int NOT NULL,
  PRIMARY KEY (`idAlmacen`),
  CONSTRAINT `fk_Almacen_1` FOREIGN KEY (`idAlmacen`) REFERENCES `Stock` (`idStock`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Almacen`
--

LOCK TABLES `Almacen` WRITE;
/*!40000 ALTER TABLE `Almacen` DISABLE KEYS */;
INSERT INTO `Almacen` VALUES (1,20,5),(2,10,2),(3,15,7),(4,25,10);
/*!40000 ALTER TABLE `Almacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
INSERT INTO `Cliente` VALUES (1,'Rodriguez','Clara','crodriguez@gmail.com'),(2,'Lopez','Juan','jlopez@gmail.com'),(3,'Fernandez','Lucia','lfernandez@gmail.com');
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Lote`
--

DROP TABLE IF EXISTS `Lote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Lote` (
  `idLote` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `cantExistente` int NOT NULL,
  `cantInicial` int NOT NULL,
  `idAlmacen` int NOT NULL,
  PRIMARY KEY (`idLote`),
  KEY `fk_Lote_1_idx` (`idAlmacen`),
  CONSTRAINT `fk_Lote_1` FOREIGN KEY (`idAlmacen`) REFERENCES `Almacen` (`idAlmacen`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Lote`
--

LOCK TABLES `Lote` WRITE;
/*!40000 ALTER TABLE `Lote` DISABLE KEYS */;
INSERT INTO `Lote` VALUES (1,'2021-06-01',5,10,1),(2,'2021-06-08',10,10,1),(3,'2021-06-02',0,5,2),(4,'2021-06-09',3,5,2),(5,'2021-06-16',5,5,2),(6,'2021-06-16',0,10,3),(7,'2021-06-16',0,15,4),(8,'2021-06-17',4,10,3),(9,'2021-06-17',3,15,4),(10,'2021-06-18',10,10,3),(11,'2021-06-18',15,15,4);
/*!40000 ALTER TABLE `Lote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `NotaPedido`
--

DROP TABLE IF EXISTS `NotaPedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `NotaPedido` (
  `idNotaPedido` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `idCliente` int NOT NULL,
  `idPedido` int NOT NULL,
  `cantidad` tinyint NOT NULL,
  `entregado` tinyint NOT NULL,
  PRIMARY KEY (`idNotaPedido`),
  KEY `fk_Pedido_2_idx` (`idCliente`),
  KEY `fk_NotaPedido_1_idx` (`idPedido`),
  CONSTRAINT `fk_NotaPedido_1` FOREIGN KEY (`idPedido`) REFERENCES `Pedido` (`idPedido`),
  CONSTRAINT `fk_Pedido_2` FOREIGN KEY (`idCliente`) REFERENCES `Cliente` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `NotaPedido`
--

LOCK TABLES `NotaPedido` WRITE;
/*!40000 ALTER TABLE `NotaPedido` DISABLE KEYS */;
INSERT INTO `NotaPedido` VALUES (1,'2021-06-19',1,1,2,1),(2,'2021-06-20',1,2,3,1),(3,'2021-06-20',1,1,4,0),(4,'2021-06-20',2,1,2,1),(5,'2021-06-20',2,2,3,1),(6,'2021-06-21',2,1,3,0),(9,'2021-06-21',2,4,2,0),(10,'2021-06-21',2,3,2,0),(11,'2021-06-20',1,4,3,0),(12,'2021-06-20',1,3,2,1),(13,'2021-06-20',3,4,3,1),(14,'2021-06-21',3,3,2,0),(15,'2021-06-21',3,2,4,0),(16,'2021-06-21',3,1,5,1);
/*!40000 ALTER TABLE `NotaPedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pedido`
--

DROP TABLE IF EXISTS `Pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pedido` (
  `idPedido` int NOT NULL,
  PRIMARY KEY (`idPedido`),
  CONSTRAINT `fk_Pedido_1` FOREIGN KEY (`idPedido`) REFERENCES `Stock` (`idStock`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pedido`
--

LOCK TABLES `Pedido` WRITE;
/*!40000 ALTER TABLE `Pedido` DISABLE KEYS */;
INSERT INTO `Pedido` VALUES (1),(2),(3),(4);
/*!40000 ALTER TABLE `Pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Producto`
--

DROP TABLE IF EXISTS `Producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Producto` (
  `idProducto` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(6) NOT NULL,
  `producto` varchar(30) NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`idProducto`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Producto`
--

LOCK TABLES `Producto` WRITE;
/*!40000 ALTER TABLE `Producto` DISABLE KEYS */;
INSERT INTO `Producto` VALUES (1,'001','Yerba Mate El Inmigrante',385),(2,'002','Aceite Geraso 1.5 lts',218),(3,'003','Queso Cremos 1kg',520),(4,'004','Dulce batata',185);
/*!40000 ALTER TABLE `Producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Stock`
--

DROP TABLE IF EXISTS `Stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Stock` (
  `idStock` int NOT NULL AUTO_INCREMENT,
  `idProducto` int NOT NULL,
  PRIMARY KEY (`idStock`),
  KEY `fk_Stock_1_idx` (`idProducto`),
  CONSTRAINT `fk_Stock_1` FOREIGN KEY (`idProducto`) REFERENCES `Producto` (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Stock`
--

LOCK TABLES `Stock` WRITE;
/*!40000 ALTER TABLE `Stock` DISABLE KEYS */;
INSERT INTO `Stock` VALUES (1,1),(2,2),(3,3),(4,4);
/*!40000 ALTER TABLE `Stock` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-11 21:40:54
