CREATE DATABASE  IF NOT EXISTS `db_spring_example`;
USE `db_spring_example`;


DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

LOCK TABLES `employee` WRITE;

INSERT INTO `employee` VALUES 
	(1,'test1','123','1@a.com'),
	(2,'test2','456','2@b.com'),
	(3,'test3','789','3@c.com');

UNLOCK TABLES;
