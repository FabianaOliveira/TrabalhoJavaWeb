-- MySQL dump 10.11
--
-- Host: localhost    Database: jw
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt

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
-- Current Database: `jw`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jw` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `jw`;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `clientes` (
  `id` int(11) NOT NULL auto_increment,
  `nome` varchar(20) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `email` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Kleber','123123123-12','1234-4321','candidomendes@ap.com.br'),(2,'Vinicius','321321289-32','1111-1111','vinicius@ap.com.br'),(3,'Elaine','456456456-32','2222-2222','elaine@ap.com.br'),(4,'Spock','678678678-32','3333-3333','candidomendes@ap.com.br'),(5,'Yara','135135135-15','4444-4444','yara@ap.com.br'),(6,'Joelma','123321123-12','1234-4321',NULL),(7,'Melissa','123123123-12','4321-4321',NULL),(8,'Teste2','cpf','telefone',NULL),(9,'teste2','teste2','teste2',NULL),(10,'12','12','12',NULL),(11,'123','123','123',NULL),(12,'1','1','1',NULL),(13,'Novo Teste da Silva','cpf da Silva','Telefone da Silva',NULL);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itenspedidos`
--

DROP TABLE IF EXISTS `itenspedidos`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `itenspedidos` (
  `id` int(11) NOT NULL auto_increment,
  `quantidade` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL,
  `idPedido` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `idProduto` (`idProduto`),
  KEY `idPedido` (`idPedido`),
  CONSTRAINT `itenspedidos_ibfk_1` FOREIGN KEY (`idProduto`) REFERENCES `produtos` (`id`),
  CONSTRAINT `itenspedidos_ibfk_2` FOREIGN KEY (`idPedido`) REFERENCES `pedidos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `itenspedidos`
--

LOCK TABLES `itenspedidos` WRITE;
/*!40000 ALTER TABLE `itenspedidos` DISABLE KEYS */;
INSERT INTO `itenspedidos` VALUES (1,1,79,2),(2,1,83,2),(3,1,82,7),(4,10,87,3),(5,1,83,4),(6,1,83,5),(7,1,79,5),(8,1,86,6);
/*!40000 ALTER TABLE `itenspedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL auto_increment,
  `numero` varchar(20) NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `idCliente` (`idCliente`),
  CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (2,'P10010-0',2),(3,'P20010-0',2),(4,'P30010-0',2),(5,'P10010-1',3),(6,'P10020-2',3),(7,'P30020-2',1);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `produtos` (
  `id` int(11) NOT NULL auto_increment,
  `nome` varchar(50) default NULL,
  `codigo` varchar(50) default NULL,
  `preco` double default NULL,
  `descricao` varchar(50) default NULL,
  `image` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (79,'CD - Ta Nervoso...Vai Pesca','cd002',16.5,'Ataide & Alexandre','cd002.gif'),(82,'TV 29','tv29philips',1925,'29 Tela Plana Estereo','tv001.gif'),(83,'CD - As Gargantas do Brasil','cd001',14.3,'Milionario e Jose Rico','cd001.gif'),(86,'Maquina fotografica','maqFot001',88,'Maquina fotografica','maqFot001.gif'),(85,'CD - Meu Reino Encantado','cd003',18,'Daniel','cd003.gif');
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-07-06  1:15:02

