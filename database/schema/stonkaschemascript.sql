-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: stonkav1
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
-- Table structure for table `administratorzy`
--

DROP TABLE IF EXISTS `administratorzy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administratorzy` (
  `idAdministratorzy` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(45) DEFAULT NULL,
  `nazwisko` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `pesel` varchar(45) NOT NULL,
  `haslo` varchar(45) NOT NULL,
  PRIMARY KEY (`idAdministratorzy`),
  UNIQUE KEY `id_UNIQUE` (`idAdministratorzy`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `pesel_UNIQUE` (`pesel`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administratorzy`
--

LOCK TABLES `administratorzy` WRITE;
/*!40000 ALTER TABLE `administratorzy` DISABLE KEYS */;
INSERT INTO `administratorzy` VALUES (1,'Jan','Kowalski','jan1234@gmail.com','60110203234','admin1');
/*!40000 ALTER TABLE `administratorzy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `analitycy`
--

DROP TABLE IF EXISTS `analitycy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `analitycy` (
  `idAnalitycy` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(45) DEFAULT NULL,
  `nazwisko` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `pesel` varchar(45) DEFAULT NULL,
  `haslo` varchar(45) DEFAULT NULL,
  `administratorzy_idAdministrator` int(11) NOT NULL,
  PRIMARY KEY (`idAnalitycy`),
  UNIQUE KEY `idAnalityk_UNIQUE` (`idAnalitycy`),
  KEY `fk_analitycy_administratorzy_idx` (`administratorzy_idAdministrator`),
  CONSTRAINT `fk_analitycy_administratorzy` FOREIGN KEY (`administratorzy_idAdministrator`) REFERENCES `administratorzy` (`idAdministratorzy`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analitycy`
--

LOCK TABLES `analitycy` WRITE;
/*!40000 ALTER TABLE `analitycy` DISABLE KEYS */;
INSERT INTO `analitycy` VALUES (1,'Jakub','Pawelec','pawe1213@gmail.com','70020201345','analityk1',1);
/*!40000 ALTER TABLE `analitycy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ankiety`
--

DROP TABLE IF EXISTS `ankiety`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ankiety` (
  `idAnkieta` int(11) NOT NULL AUTO_INCREMENT,
  `tytul` varchar(45) NOT NULL,
  `opis` varchar(90) DEFAULT NULL,
  `analitycy_idAnalityk` int(11) NOT NULL,
  PRIMARY KEY (`idAnkieta`),
  UNIQUE KEY `idAnkieta_UNIQUE` (`idAnkieta`),
  KEY `fk_ankiety_analitycy1_idx` (`analitycy_idAnalityk`),
  CONSTRAINT `fk_ankiety_analitycy1` FOREIGN KEY (`analitycy_idAnalityk`) REFERENCES `analitycy` (`idAnalitycy`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ankiety`
--

LOCK TABLES `ankiety` WRITE;
/*!40000 ALTER TABLE `ankiety` DISABLE KEYS */;
INSERT INTO `ankiety` VALUES (1,'Badanie jakosci uslug','Sprawdzenie zadowolenia klientow',1),(2,'Badanie poziomu zadowolenia','Badanie ',1),(3,'Czy stonka najlepsza?','Badanie jakosci',1),(4,'Ocena nowych ulotek','Ocena jakosci i przejrzystosci nowych gazetek promocyjnych',1);
/*!40000 ALTER TABLE `ankiety` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dopuszczenia`
--

DROP TABLE IF EXISTS `dopuszczenia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dopuszczenia` (
  `idDopuszczenia` int(11) NOT NULL AUTO_INCREMENT,
  `dataDopuszczenia` varchar(45) NOT NULL,
  `dataWycofania` varchar(45) DEFAULT NULL,
  `ankiety_idAnkieta` int(11) NOT NULL,
  `sklepy_idSklepy` int(11) NOT NULL,
  PRIMARY KEY (`idDopuszczenia`),
  UNIQUE KEY `idDopuszczenia_UNIQUE` (`idDopuszczenia`),
  KEY `fk_dopuszczenia_ankiety1_idx` (`ankiety_idAnkieta`),
  KEY `fk_dopuszczenia_sklepy1_idx` (`sklepy_idSklepy`),
  CONSTRAINT `fk_dopuszczenia_ankiety1` FOREIGN KEY (`ankiety_idAnkieta`) REFERENCES `ankiety` (`idAnkieta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dopuszczenia_sklepy1` FOREIGN KEY (`sklepy_idSklepy`) REFERENCES `sklepy` (`idSklepy`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dopuszczenia`
--

LOCK TABLES `dopuszczenia` WRITE;
/*!40000 ALTER TABLE `dopuszczenia` DISABLE KEYS */;
INSERT INTO `dopuszczenia` VALUES (1,'09.12.2017','25.01.2018',1,1),(2,'27.12.2017','03.03.2018',2,1),(3,'10.11.2017','10.11.2018',3,1),(4,'20.01.2018','20.01.2019',2,2);
/*!40000 ALTER TABLE `dopuszczenia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kierownicy`
--

DROP TABLE IF EXISTS `kierownicy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kierownicy` (
  `idKierownicy` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(45) DEFAULT NULL,
  `nazwisko` varchar(45) DEFAULT NULL,
  `pesel` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `haslo` varchar(45) NOT NULL,
  `administratorzy_idAdministrator` int(11) NOT NULL,
  PRIMARY KEY (`idKierownicy`),
  UNIQUE KEY `idKierownicy_UNIQUE` (`idKierownicy`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `pesel_UNIQUE` (`pesel`),
  KEY `fk_kierownicy_administratorzy1_idx` (`administratorzy_idAdministrator`),
  CONSTRAINT `fk_kierownicy_administratorzy1` FOREIGN KEY (`administratorzy_idAdministrator`) REFERENCES `administratorzy` (`idAdministratorzy`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kierownicy`
--

LOCK TABLES `kierownicy` WRITE;
/*!40000 ALTER TABLE `kierownicy` DISABLE KEYS */;
INSERT INTO `kierownicy` VALUES (1,'Janusz','Wernet','56020304123','sumator12@gmail.com','sumator1',1);
/*!40000 ALTER TABLE `kierownicy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `klienci`
--

DROP TABLE IF EXISTS `klienci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `klienci` (
  `idKlienci` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(45) DEFAULT NULL,
  `nazwisko` varchar(45) DEFAULT NULL,
  `pesel` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `haslo` varchar(45) DEFAULT NULL,
  `dataUrodzenia` varchar(10) DEFAULT NULL,
  `ulica` varchar(45) DEFAULT NULL,
  `nrDomu` varchar(5) DEFAULT NULL,
  `miejscowosc` varchar(45) DEFAULT NULL,
  `kod` varchar(2) DEFAULT NULL,
  `pocztowy` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`idKlienci`),
  UNIQUE KEY `klienci_idKlienci_uindex` (`idKlienci`),
  UNIQUE KEY `klienci_email_uindex` (`email`),
  UNIQUE KEY `klienci_pesel_uindex` (`pesel`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klienci`
--

LOCK TABLES `klienci` WRITE;
/*!40000 ALTER TABLE `klienci` DISABLE KEYS */;
INSERT INTO `klienci` VALUES (1,'Janusz','Polak','88888888888','janusz.polak@gmail.com','janusz1','1972-01-06','Sienkiewicz','6','Łowicz','99','400'),(2,'janek','dzbanek','94110201234','janek12@gmail.com','janek1','1972-01-07',NULL,NULL,NULL,NULL,NULL),(7,'gfyf','gyugug','7879','ihi','ufuytfgu','1978-10-06',NULL,NULL,NULL,NULL,NULL),(8,'hiuhiu','huhiuh','987987','saresrsr','uyhiui','1969-03-23',NULL,NULL,NULL,NULL,NULL),(9,'vxzvxz','xczvxcv','12234556','ancypanes','afasfa','1972-01-06',NULL,NULL,NULL,NULL,NULL),(10,'Kuba','Jakis','77777777777','kuba12345@gmail.com','kuba1','2018-01-01','Jakas','8888','Jakas','44','333'),(11,'Janek','Nowy','99999999999','jidjigjfiojbo','ifjboidjb','2018-01-01','ggjdjoij','9999','gjifjgoifjg','88','666'),(12,'Adam','Nowak','65234512345','adam1234@gmail.com','adam1','2018-01-01','Koszarowa','5','Warszawa','99','400'),(13,'Łukasz','Szczęsny','96120301234','lukasz1234@gmail.com','lukasz1','1996-12-03',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `klienci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `odpowiedzi`
--

DROP TABLE IF EXISTS `odpowiedzi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `odpowiedzi` (
  `idOdpowiedzi` int(11) NOT NULL AUTO_INCREMENT,
  `tresc` varchar(45) DEFAULT NULL,
  `nrPorzadkowyOdpowiedzi` int(11) DEFAULT NULL,
  `pytania_idPytania` int(11) NOT NULL,
  PRIMARY KEY (`idOdpowiedzi`),
  UNIQUE KEY `idOdpowiedzi_UNIQUE` (`idOdpowiedzi`),
  KEY `fk_odpowiedzi_pytania1_idx` (`pytania_idPytania`),
  CONSTRAINT `fk_odpowiedzi_pytania1` FOREIGN KEY (`pytania_idPytania`) REFERENCES `pytania` (`idPytania`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `odpowiedzi`
--

LOCK TABLES `odpowiedzi` WRITE;
/*!40000 ALTER TABLE `odpowiedzi` DISABLE KEYS */;
INSERT INTO `odpowiedzi` VALUES (1,'Zadowolony',1,1);
/*!40000 ALTER TABLE `odpowiedzi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pozycje`
--

DROP TABLE IF EXISTS `pozycje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pozycje` (
  `idPozycje` int(11) NOT NULL AUTO_INCREMENT,
  `nrPorzadkowyPozycji` int(11) NOT NULL,
  `pytania_idPytania` int(11) NOT NULL,
  `ankiety_idAnkieta` int(11) NOT NULL,
  PRIMARY KEY (`idPozycje`),
  UNIQUE KEY `idPozycje_UNIQUE` (`idPozycje`),
  KEY `fk_pozycje_pytania1_idx` (`pytania_idPytania`),
  KEY `fk_pozycje_ankiety1_idx` (`ankiety_idAnkieta`),
  CONSTRAINT `fk_pozycje_ankiety1` FOREIGN KEY (`ankiety_idAnkieta`) REFERENCES `ankiety` (`idAnkieta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pozycje_pytania1` FOREIGN KEY (`pytania_idPytania`) REFERENCES `pytania` (`idPytania`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pozycje`
--

LOCK TABLES `pozycje` WRITE;
/*!40000 ALTER TABLE `pozycje` DISABLE KEYS */;
INSERT INTO `pozycje` VALUES (1,1,1,1),(2,2,2,1),(3,1,3,2),(4,2,4,2),(5,1,5,4),(6,2,6,4),(7,1,7,3),(8,3,8,1),(9,4,9,1);
/*!40000 ALTER TABLE `pozycje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pytania`
--

DROP TABLE IF EXISTS `pytania`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pytania` (
  `idPytania` int(11) NOT NULL AUTO_INCREMENT,
  `tresc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPytania`),
  UNIQUE KEY `idPytania_UNIQUE` (`idPytania`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pytania`
--

LOCK TABLES `pytania` WRITE;
/*!40000 ALTER TABLE `pytania` DISABLE KEYS */;
INSERT INTO `pytania` VALUES (1,'Jak oceniasz czystosc sklepu?'),(2,'Jak oceniasz poziom cen?'),(3,'Jak oceniasz ostatnia wizyte?'),(4,'Jak oceniasz poziom obsługi?'),(5,'Jak oceniasz nowa szate graficzna ulotek?'),(6,'Jak oceniasz przejrzystosc ulotek?'),(7,'Jak oceniasz w porownaniu do innych sklepow?'),(8,'Jak oceniasz rozlozenie towaru?'),(9,'Jak oceniasz jakosc lokalnych marek?');
/*!40000 ALTER TABLE `pytania` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sklepy`
--

DROP TABLE IF EXISTS `sklepy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sklepy` (
  `idSklepy` int(11) NOT NULL AUTO_INCREMENT,
  `miejscowosc` varchar(45) DEFAULT NULL,
  `ulica` varchar(45) DEFAULT NULL,
  `nrBudynku` int(11) DEFAULT NULL,
  `kodPocztowy` varchar(10) DEFAULT NULL,
  `administratorzy_idAdministrator` int(11) NOT NULL,
  `kierownicy_idKierownicy` int(11) NOT NULL,
  PRIMARY KEY (`idSklepy`),
  UNIQUE KEY `idSklepy_UNIQUE` (`idSklepy`),
  KEY `fk_sklepy_administratorzy1_idx` (`administratorzy_idAdministrator`),
  KEY `fk_sklepy_kierownicy1_idx` (`kierownicy_idKierownicy`),
  CONSTRAINT `fk_sklepy_administratorzy1` FOREIGN KEY (`administratorzy_idAdministrator`) REFERENCES `administratorzy` (`idAdministratorzy`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sklepy_kierownicy1` FOREIGN KEY (`kierownicy_idKierownicy`) REFERENCES `kierownicy` (`idKierownicy`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sklepy`
--

LOCK TABLES `sklepy` WRITE;
/*!40000 ALTER TABLE `sklepy` DISABLE KEYS */;
INSERT INTO `sklepy` VALUES (1,'Lowicz','Tuszewska',2,'99400',1,1),(2,'Wrocław','Reja',15,'55680',1,1),(3,'Wrocław','Sienkiewicza',46,'55690',1,1),(4,'Wrocław','Fabryczna',1,'555670',1,1),(5,'Warszawa','Piłsudskiego',15,'22781',1,1),(6,'Warszawa','Gdańska',15,'42187',1,1),(7,'Gdańsk','Kolejowa',86,'26123',1,1),(8,'Radom','Sochaczewska',34,'37498',1,1),(9,'Sosnowiec','Januszowa',24,'34651',1,1);
/*!40000 ALTER TABLE `sklepy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wypelnienia`
--

DROP TABLE IF EXISTS `wypelnienia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wypelnienia` (
  `idWypelnienia` int(11) NOT NULL,
  `data` varchar(45) DEFAULT NULL,
  `godzina` varchar(45) DEFAULT NULL,
  `pozycje_idPozycje` int(11) NOT NULL,
  `sklepy_idSklepy` int(11) NOT NULL,
  `odpowiedzi_idOdpowiedzi` int(11) NOT NULL,
  PRIMARY KEY (`idWypelnienia`),
  KEY `fk_wypelnienia_pozycje1_idx` (`pozycje_idPozycje`),
  KEY `fk_wypelnienia_sklepy1_idx` (`sklepy_idSklepy`),
  KEY `fk_wypelnienia_odpowiedzi1_idx` (`odpowiedzi_idOdpowiedzi`),
  CONSTRAINT `fk_wypelnienia_odpowiedzi1` FOREIGN KEY (`odpowiedzi_idOdpowiedzi`) REFERENCES `odpowiedzi` (`idOdpowiedzi`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_wypelnienia_pozycje1` FOREIGN KEY (`pozycje_idPozycje`) REFERENCES `pozycje` (`idPozycje`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_wypelnienia_sklepy1` FOREIGN KEY (`sklepy_idSklepy`) REFERENCES `sklepy` (`idSklepy`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wypelnienia`
--

LOCK TABLES `wypelnienia` WRITE;
/*!40000 ALTER TABLE `wypelnienia` DISABLE KEYS */;
INSERT INTO `wypelnienia` VALUES (1,'05.12.2017','20.11',1,1,1);
/*!40000 ALTER TABLE `wypelnienia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-17 21:43:06
