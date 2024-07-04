CREATE DATABASE IF NOT EXISTS `db-hibernate-one-to-one` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db-hibernate-one-to-one`;

-- Table structure for table `customer`
DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `nationalId` INTEGER(11) NOT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `inactive` bit(1) DEFAULT b'0',
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Dumping data for table `customer`
LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Jaramillo','Ana','14000000','1960-09-10','\0');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

-- Table structure for table `contact`
DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact` (
  `contactId` int(11) NOT NULL,
  `email` varchar(25) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`contactId`),
  CONSTRAINT `fk_customer` FOREIGN KEY (`contactId`) REFERENCES `customer` (`customerId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Dumping data for table `contact`
LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1,'ajaramillo@unla.edu.ar','11-1111-1111','011-1111-1111');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;
