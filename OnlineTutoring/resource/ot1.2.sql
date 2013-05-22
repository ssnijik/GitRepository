-- MySQL dump 10.13  Distrib 5.6.10, for Win64 (x86_64)
--
-- Host: localhost    Database: onlinetutoring
-- ------------------------------------------------------
-- Server version	5.6.10

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
use onlinetutoring;
--
-- Table structure for table `application`
--



DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `application` (
  `STUDENT_ID` bigint(20) NOT NULL,
  `TIMETABLE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`STUDENT_ID`,`TIMETABLE_ID`),
  KEY `IDX_STUDENT_ID` (`STUDENT_ID`),
  KEY `IDX_TIMETABLE_ID` (`TIMETABLE_ID`),
  CONSTRAINT `FK_TIMETABLE_ID` FOREIGN KEY (`TIMETABLE_ID`) REFERENCES `timetable` (`ID`),
  CONSTRAINT `FK_STUDENT_ID` FOREIGN KEY (`STUDENT_ID`) REFERENCES `student` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arrangement`
--

DROP TABLE IF EXISTS `arrangement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arrangement` (
  `ID` bigint(20) NOT NULL,
  `TUTOR_ID` bigint(20) NOT NULL,
  `COURSE_ID` bigint(20) NOT NULL,
  `SCORE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_TUTOR_AR_ID` (`TUTOR_ID`),
  KEY `IDX_COURSE_AR_ID` (`COURSE_ID`),
  CONSTRAINT `FK_COURSE_AR_ID` FOREIGN KEY (`COURSE_ID`) REFERENCES `course` (`ID`),
  CONSTRAINT `FK_TUTOR_AR_ID` FOREIGN KEY (`TUTOR_ID`) REFERENCES `tutor` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arrangement`
--

LOCK TABLES `arrangement` WRITE;
/*!40000 ALTER TABLE `arrangement` DISABLE KEYS */;
INSERT INTO `arrangement` VALUES (1,1,1,0),(2,2,2,0);
/*!40000 ALTER TABLE `arrangement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `ID` bigint(20) NOT NULL,
  `SUBJECT_ID` bigint(20) DEFAULT NULL,
  `NAME` char(30) NOT NULL,
  `PRICE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_SUBJECT_CO_ID` (`SUBJECT_ID`),
  CONSTRAINT `FK_SUBJECT_CO_ID` FOREIGN KEY (`SUBJECT_ID`) REFERENCES `subject` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,1,'course1',2),(2,2,'course1',2);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend`
--

DROP TABLE IF EXISTS `friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friend` (
  `PRIMARY_ID` bigint(20) NOT NULL,
  `SECONDARY_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`PRIMARY_ID`,`SECONDARY_ID`),
  KEY `FK_PRIMARY_FR_ID` (`PRIMARY_ID`),
  KEY `FK_SECONDARY_FR_ID` (`SECONDARY_ID`),
  CONSTRAINT `FK_PRIMARY_FR_ID` FOREIGN KEY (`PRIMARY_ID`) REFERENCES `person` (`ID`),
  CONSTRAINT `FK_SECONDARY_FR_ID` FOREIGN KEY (`SECONDARY_ID`) REFERENCES `person` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend`
--

LOCK TABLES `friend` WRITE;
/*!40000 ALTER TABLE `friend` DISABLE KEYS */;
/*!40000 ALTER TABLE `friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master`
--

DROP TABLE IF EXISTS `master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `master` (
  `ID` bigint(20) NOT NULL,
  `POSTED_BY_ID` bigint(20) NOT NULL,
  `TITLE` char(30) NOT NULL,
  `CONTENT` varchar(1000) NOT NULL,
  `TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `VIEW` int(11) DEFAULT NULL,
  `REPLY` int(11) DEFAULT NULL,
  `PICTURE` varchar(1000) DEFAULT NULL,
  `ATTACHMENT` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_POSTED_BY_MA_ID` (`POSTED_BY_ID`),
  CONSTRAINT `FK_POSTED_BY_MA_ID` FOREIGN KEY (`POSTED_BY_ID`) REFERENCES `person` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master`
--

LOCK TABLES `master` WRITE;
/*!40000 ALTER TABLE `master` DISABLE KEYS */;
INSERT INTO `master` VALUES (1,1,'title1','content1','2013-05-07 15:10:24',0,0,NULL,NULL),(2,3,'title1','content1','2013-05-07 19:32:11',0,0,NULL,NULL);
/*!40000 ALTER TABLE `master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `ID` bigint(20) NOT NULL,
  `SENDER_ID` bigint(20) NOT NULL,
  `RECIPIENT_ID` bigint(20) NOT NULL,
  `TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `CONTENT` varchar(1000) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_SENDER_NO_ID` (`SENDER_ID`),
  KEY `IDX_RECIPIENT_NO_ID` (`RECIPIENT_ID`),
  CONSTRAINT `FK_RECIPIENT_NO_ID` FOREIGN KEY (`RECIPIENT_ID`) REFERENCES `person` (`ID`),
  CONSTRAINT `FK_SENDER_NO_ID` FOREIGN KEY (`SENDER_ID`) REFERENCES `person` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,1,2,'2013-05-07 15:10:24','i come'),(2,3,4,'2013-05-07 19:32:11','i come');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification` (
  `ID` bigint(20) NOT NULL,
  `PERSON_ID` bigint(20) NOT NULL,
  `NOTIFICATION_ID` bigint(20) NOT NULL,
  `TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `TYPE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_PERSON_ID` (`PERSON_ID`),
  CONSTRAINT `FK_PERSON_ID` FOREIGN KEY (`PERSON_ID`) REFERENCES `person` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `ID` bigint(20) NOT NULL,
  `FIRST_NAME` char(30) NOT NULL,
  `LAST_NAME` char(30) NOT NULL,
  `EMAIL` char(60) NOT NULL,
  `PASSWORD` char(30) NOT NULL,
  `PHONE` char(11) DEFAULT NULL,
  `BIRTHDAY` date DEFAULT NULL,
  `CARD_NUMBER` char(16) DEFAULT NULL,
  `TYPE` char(1) DEFAULT NULL,
  `SCORE` int(11) DEFAULT NULL,
  `AVATOR` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'fn1','ln1','e1@mail.com','pw123456a',NULL,NULL,NULL,'\0',0,NULL),(2,'fn2','ln2','e2@mail.com','pw123456b',NULL,NULL,NULL,'\0',0,NULL),(3,'fn1','ln1','e1@mail.com','pw123456a',NULL,NULL,NULL,'\0',0,NULL),(4,'fn2','ln2','e2@mail.com','pw123456b',NULL,NULL,NULL,'\0',0,NULL);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posting`
--

DROP TABLE IF EXISTS `posting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posting` (
  `ID` bigint(20) NOT NULL,
  `POSTED_BY_ID` bigint(20) NOT NULL,
  `TITLE` char(30) NOT NULL,
  `CONTENT` varchar(1000) NOT NULL,
  `TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `MASTER_ID` bigint(20) NOT NULL,
  `PICTURE` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_POSTED_BY_PO_ID` (`POSTED_BY_ID`),
  KEY `IDX_MASTER_PO_ID` (`MASTER_ID`),
  CONSTRAINT `FK_MASTER_PO_ID` FOREIGN KEY (`MASTER_ID`) REFERENCES `master` (`ID`),
  CONSTRAINT `FK_POSTED_BY_PO_ID` FOREIGN KEY (`POSTED_BY_ID`) REFERENCES `person` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posting`
--

LOCK TABLES `posting` WRITE;
/*!40000 ALTER TABLE `posting` DISABLE KEYS */;
INSERT INTO `posting` VALUES (1,3,'ptitle1','pcontent1','2013-05-07 19:32:11',2,NULL);
/*!40000 ALTER TABLE `posting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialty`
--

DROP TABLE IF EXISTS `specialty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `specialty` (
  `TUTOR_ID` bigint(20) NOT NULL,
  `SUBJECT_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`TUTOR_ID`,`SUBJECT_ID`),
  KEY `IDX_TUTOR_SP_ID` (`TUTOR_ID`),
  KEY `IDX_SUBJECT_SP_ID` (`SUBJECT_ID`),
  CONSTRAINT `FK_SUBJECT_SP_ID` FOREIGN KEY (`SUBJECT_ID`) REFERENCES `subject` (`ID`),
  CONSTRAINT `FK_TUTOR_SP_ID` FOREIGN KEY (`TUTOR_ID`) REFERENCES `tutor` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialty`
--

LOCK TABLES `specialty` WRITE;
/*!40000 ALTER TABLE `specialty` DISABLE KEYS */;
/*!40000 ALTER TABLE `specialty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `ID` bigint(20) NOT NULL,
  `PERSON_ID` bigint(20) NOT NULL,
  `BALANCE` bigint(20) DEFAULT NULL,
  `GRADE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_PERSON_S_ID` (`PERSON_ID`),
  CONSTRAINT `FK_PERSON_S_ID` FOREIGN KEY (`PERSON_ID`) REFERENCES `person` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,2,0,0),(2,4,0,0);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_timetable`
--

DROP TABLE IF EXISTS `student_timetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_timetable` (
  `ID` bigint(20) NOT NULL,
  `STUDENT_ID` bigint(20) NOT NULL,
  `TIMETABLE_ID` bigint(20) NOT NULL,
  `SCORE` int(11) DEFAULT NULL,
  `REMARK` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_STUDENT_ST_ID` (`STUDENT_ID`),
  KEY `IDX_TIMETABLE_ST_ID` (`TIMETABLE_ID`),
  CONSTRAINT `FK_STUDENT_ST_ID` FOREIGN KEY (`STUDENT_ID`) REFERENCES `student` (`ID`),
  CONSTRAINT `FK_TIMETABLE_ST_ID` FOREIGN KEY (`TIMETABLE_ID`) REFERENCES `timetable` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_timetable`
--

LOCK TABLES `student_timetable` WRITE;
/*!40000 ALTER TABLE `student_timetable` DISABLE KEYS */;
INSERT INTO `student_timetable` VALUES (1,1,1,0,NULL),(2,2,2,0,NULL);
/*!40000 ALTER TABLE `student_timetable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `ID` bigint(20) NOT NULL,
  `SUBJECT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_SUBJECT_SU_ID` (`SUBJECT_ID`),
  CONSTRAINT `FK_SUBJECT_SU_ID` FOREIGN KEY (`SUBJECT_ID`) REFERENCES `subject` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,NULL),(2,NULL);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timetable`
--

DROP TABLE IF EXISTS `timetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timetable` (
  `ID` bigint(20) NOT NULL,
  `ARRANGEMENT_ID` bigint(20) NOT NULL,
  `START_TIME` date DEFAULT NULL,
  `END_TIME` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_ARRANGEMENT_TI_ID` (`ARRANGEMENT_ID`),
  CONSTRAINT `FK_ARRANGEMENT_TI_ID` FOREIGN KEY (`ARRANGEMENT_ID`) REFERENCES `arrangement` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timetable`
--

LOCK TABLES `timetable` WRITE;
/*!40000 ALTER TABLE `timetable` DISABLE KEYS */;
INSERT INTO `timetable` VALUES (1,1,NULL,NULL),(2,2,NULL,NULL);
/*!40000 ALTER TABLE `timetable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutor`
--

DROP TABLE IF EXISTS `tutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tutor` (
  `ID` bigint(20) NOT NULL,
  `PERSON_ID` bigint(20) NOT NULL,
  `SALARY` bigint(20) DEFAULT NULL,
  `DESCRIPTION` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_PERSON_T_ID` (`PERSON_ID`),
  CONSTRAINT `FK_PERSON_T_ID` FOREIGN KEY (`PERSON_ID`) REFERENCES `person` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor`
--

LOCK TABLES `tutor` WRITE;
/*!40000 ALTER TABLE `tutor` DISABLE KEYS */;
INSERT INTO `tutor` VALUES (1,1,0,NULL),(2,3,0,NULL);
/*!40000 ALTER TABLE `tutor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-05-17 11:47:18
