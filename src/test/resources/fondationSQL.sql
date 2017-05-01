-- MySQL dump 10.13  Distrib 5.6.33, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: fondation_norsys
-- ------------------------------------------------------
-- Server version	5.6.33-0ubuntu0.14.04.1

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
-- Table structure for table `ACTIVITE`
--

DROP TABLE IF EXISTS `ACTIVITE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACTIVITE` (
  `ID_ACTIVITE` int(11) NOT NULL AUTO_INCREMENT,
  `DATE_ACTIVITE` date DEFAULT NULL,
  `DUREE_ACTIVITE` varchar(255) DEFAULT NULL,
  `ETAT` varchar(255) DEFAULT NULL,
  `INTITULE` varchar(255) DEFAULT NULL,
  `LIEU` varchar(255) DEFAULT NULL,
  `ID_ANIMATEUR` int(11) DEFAULT NULL,
  `ID_COMPOSANTE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_ACTIVITE`),
  CONSTRAINT `FK_542w67p5qnw52yyc20x4qnph6` FOREIGN KEY (`ID_COMPOSANTE`) REFERENCES `COMPOSANTE` (`ID_COMPOSANTE`),
  CONSTRAINT `FK_pv4dovsx7dssdkd2oudlpbjnc` FOREIGN KEY (`ID_ANIMATEUR`) REFERENCES `COLLABORATEUR` (`ID_COLLABORATEUR`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACTIVITE`
--

--
-- Table structure for table `BENIFICIAIRE`
--

DROP TABLE IF EXISTS `BENIFICIAIRE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BENIFICIAIRE` (
  `ID_BENIFICIAIRE` int(11) NOT NULL AUTO_INCREMENT,
  `CIN` varchar(255) DEFAULT NULL,
  `ADRESSE` varchar(255) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `NUMERO_TELEPHONE` varchar(255) DEFAULT NULL,
  `PAYS` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  `VILLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_BENIFICIAIRE`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BENIFICIAIRE`
--
--
-- Table structure for table `BENIFICIAIRE_ACTIVITE`
--

DROP TABLE IF EXISTS `BENIFICIAIRE_ACTIVITE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BENIFICIAIRE_ACTIVITE` (
  `ID_ACTIVITE` int(11) NOT NULL,
  `ID_BENIFICIAIRE` int(11) NOT NULL,
  CONSTRAINT `FK_98p1nxuq5hsp2rg8o2fvukguk` FOREIGN KEY (`ID_ACTIVITE`) REFERENCES `ACTIVITE` (`ID_ACTIVITE`),
  CONSTRAINT `FK_q4w73a3e35kg0tj40lnsxo62p` FOREIGN KEY (`ID_BENIFICIAIRE`) REFERENCES `BENIFICIAIRE` (`ID_BENIFICIAIRE`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BENIFICIAIRE_ACTIVITE`
--

-- Table structure for table `BILAN`
--

DROP TABLE IF EXISTS `BILAN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BILAN` (
  `ID_BILAN` int(11) NOT NULL AUTO_INCREMENT,
  `INTITULE` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  `ID_PROJET` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_BILAN`),
  CONSTRAINT `FK_umbpj63f7re9yku0pismxtak` FOREIGN KEY (`ID_PROJET`) REFERENCES `PROJET` (`ID_PROJET`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BILAN`
--

--
-- Table structure for table `COLLABORATEUR`
--

DROP TABLE IF EXISTS `COLLABORATEUR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COLLABORATEUR` (
  `TYPE_COLLABORATEUR` varchar(31) NOT NULL,
  `ID_COLLABORATEUR` int(11) NOT NULL AUTO_INCREMENT,
  `CIN` varchar(255) DEFAULT NULL,
  `ADRESSE` varchar(255) DEFAULT NULL,
  `DATE_NAISSANCE` date DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `LIEU_NAISSANCE` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `NUMERO_TELEPHONE` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_COLLABORATEUR`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COLLABORATEUR`
--

--
-- Table structure for table `COLLABORATEUR_ACTIVITE`
--

DROP TABLE IF EXISTS `COLLABORATEUR_ACTIVITE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COLLABORATEUR_ACTIVITE` (
  `ID_ACTIVITE` int(11) NOT NULL,
  `ID_COLLABORATEUR` int(11) NOT NULL,
  CONSTRAINT `FK_2h7xg42sr9w3ypvfdxqohp89u` FOREIGN KEY (`ID_COLLABORATEUR`) REFERENCES `COLLABORATEUR` (`ID_COLLABORATEUR`),
  CONSTRAINT `FK_p8d6343r7i70oo1qai3t0uhvr` FOREIGN KEY (`ID_ACTIVITE`) REFERENCES `ACTIVITE` (`ID_ACTIVITE`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COLLABORATEUR_ACTIVITE`
--

--
-- Table structure for table `COMPOSANTE`
--

DROP TABLE IF EXISTS `COMPOSANTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COMPOSANTE` (
  `ID_COMPOSANTE` int(11) NOT NULL AUTO_INCREMENT,
  `INTITULE` varchar(255) DEFAULT NULL,
  `ID_PROJET` int(11) DEFAULT NULL,
  `ID_THEMATIQUE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_COMPOSANTE`),
  CONSTRAINT `FK_g9jpoewor6p839nyi3e2nqclo` FOREIGN KEY (`ID_PROJET`) REFERENCES `PROJET` (`ID_PROJET`),
  CONSTRAINT `FK_r6scn1qxr892xswql65fl2u9o` FOREIGN KEY (`ID_THEMATIQUE`) REFERENCES `THEMATIQUE` (`ID_THEMATIQUE`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COMPOSANTE`
--

--
-- Table structure for table `PARTENAIRE`
--

DROP TABLE IF EXISTS `PARTENAIRE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PARTENAIRE` (
  `ID_PARTENAIRE` int(11) NOT NULL AUTO_INCREMENT,
  `ADRESSE` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `NUMERO_TELEPHONE` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_PARTENAIRE`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PARTENAIRE`
--
--
-- Table structure for table `PARTENAIRE_PROJET`
--

DROP TABLE IF EXISTS `PARTENAIRE_PROJET`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PARTENAIRE_PROJET` (
  `ID_PARTENAIRE` int(11) NOT NULL,
  `ID_PROJET` int(11) NOT NULL,
  CONSTRAINT `FK_fi5mpxwqumtbym9401ffspqgp` FOREIGN KEY (`ID_PROJET`) REFERENCES `PROJET` (`ID_PROJET`),
  CONSTRAINT `FK_s5d1j2hp57a3hrj19m2s61anx` FOREIGN KEY (`ID_PARTENAIRE`) REFERENCES `PARTENAIRE` (`ID_PARTENAIRE`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PARTENAIRE_PROJET`
--


--
-- Table structure for table `PORTEUR_PROJET`
--

DROP TABLE IF EXISTS `PORTEUR_PROJET`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PORTEUR_PROJET` (
  `ID_PORTEUR` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `NUMERO_TELEPHONE` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_PORTEUR`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PORTEUR_PROJET`
--

--
-- Table structure for table `PROJET`
--

DROP TABLE IF EXISTS `PROJET`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROJET` (
  `ID_PROJET` int(11) NOT NULL AUTO_INCREMENT,
  `DATE_DEBUT` date DEFAULT NULL,
  `DATE_FIN` date DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `INTITULE` varchar(255) DEFAULT NULL,
  `ID_ADMINISTRATEUR` int(11) DEFAULT NULL,
  `ID_PROPOSITION` int(11) DEFAULT NULL,
  `ID_RESPONSABLE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_PROJET`),
  CONSTRAINT `FK_dkt1g07ckbunne31cuyjvuvdu` FOREIGN KEY (`ID_RESPONSABLE`) REFERENCES `COLLABORATEUR` (`ID_COLLABORATEUR`),
  CONSTRAINT `FK_mom4v8km9pvp7mx62i8o8hpt7` FOREIGN KEY (`ID_PROPOSITION`) REFERENCES `PROPOSITION` (`ID_PROPOSITION`),
  CONSTRAINT `FK_r279fhx8bgxw42up2wyj17dff` FOREIGN KEY (`ID_ADMINISTRATEUR`) REFERENCES `COLLABORATEUR` (`ID_COLLABORATEUR`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROJET`
--


--
-- Table structure for table `PROPOSITION`
--

DROP TABLE IF EXISTS `PROPOSITION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROPOSITION` (
  `ID_PROPOSITION` int(11) NOT NULL AUTO_INCREMENT,
  `ANNEXE` longblob,
  `BUDGET_PREVISIONNEL` varchar(255) DEFAULT NULL,
  `DATE_PREVISION` date DEFAULT NULL,
  `DUREE_ACTION` varchar(255) DEFAULT NULL,
  `OBJECTIF` varchar(255) DEFAULT NULL,
  `POPULATION_CIBLE` varchar(255) DEFAULT NULL,
  `THEMATIQUE` varchar(255) DEFAULT NULL,
  `TYPE_ACTION` varchar(255) DEFAULT NULL,
  `TYPE_SOUTIEN` varchar(255) DEFAULT NULL,
  `ZONE_GEOGRAPHIQUE` varchar(255) DEFAULT NULL,
  `ID_PORTEUR_PROJET` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_PROPOSITION`),
  CONSTRAINT `FK_9ketnhf3s4j39lytbw72huj1o` FOREIGN KEY (`ID_PORTEUR_PROJET`) REFERENCES `PORTEUR_PROJET` (`ID_PORTEUR`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROPOSITION`
--


--
-- Table structure for table `PUBLICATION`
--

DROP TABLE IF EXISTS `PUBLICATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PUBLICATION` (
  `ID_PUBLICATION` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `TITRE` varchar(255) DEFAULT NULL,
  `ID_PROJET` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_PUBLICATION`),
  CONSTRAINT `FK_b9qvv4mjp7q0xri4o67upd6a6` FOREIGN KEY (`ID_PROJET`) REFERENCES `PROJET` (`ID_PROJET`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PUBLICATION`
--


--
-- Table structure for table `RAPPORT`
--

DROP TABLE IF EXISTS `RAPPORT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RAPPORT` (
  `ID_RAPPORT` int(11) NOT NULL AUTO_INCREMENT,
  `INTITULE` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  `ID_PROJET` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_RAPPORT`),
  CONSTRAINT `FK_j266dhogdkpcjm8235yj9cw8y` FOREIGN KEY (`ID_PROJET`) REFERENCES `PROJET` (`ID_PROJET`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RAPPORT`
--

--
-- Table structure for table `RENDEZ_VOUS`
--

DROP TABLE IF EXISTS `RENDEZ_VOUS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RENDEZ_VOUS` (
  `ID_RENDEZVOUS` int(11) NOT NULL AUTO_INCREMENT,
  `DATE` datetime DEFAULT NULL,
  `SUJET` varchar(255) DEFAULT NULL,
  `ID_ADMINISTRATEUR` int(11) DEFAULT NULL,
  `ID_PORTEUR_PROJET` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_RENDEZVOUS`),
  CONSTRAINT `FK_rdgk3xa2rgi5ojl2muwfqleiq` FOREIGN KEY (`ID_ADMINISTRATEUR`) REFERENCES `COLLABORATEUR` (`ID_COLLABORATEUR`),
  CONSTRAINT `FK_sgntiewin9j1d7ioe6tirksej` FOREIGN KEY (`ID_PORTEUR_PROJET`) REFERENCES `PORTEUR_PROJET` (`ID_PORTEUR`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RENDEZ_VOUS`


--
-- Table structure for table `THEMATIQUE`
--

DROP TABLE IF EXISTS `THEMATIQUE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `THEMATIQUE` (
  `ID_THEMATIQUE` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `INTITULE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_THEMATIQUE`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `THEMATIQUE`
--

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-01 20:13:32