-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.16-log - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for restaurant
CREATE DATABASE IF NOT EXISTS `restaurant` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `restaurant`;

-- Dumping structure for table restaurant.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `empid` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(50) NOT NULL,
  `dob` varchar(50) NOT NULL,
  `education` varchar(50) NOT NULL,
  `experience` int(11) DEFAULT NULL,
  `phoneno` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `skills` varchar(50) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `emppassword` varchar(50) NOT NULL,
  `jobid` int(11) DEFAULT NULL,
  PRIMARY KEY (`empid`),
  KEY `jobid` (`jobid`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`jobid`) REFERENCES `job` (`jobid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table restaurant.employee: ~2 rows (approximately)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`empid`, `fullname`, `dob`, `education`, `experience`, `phoneno`, `address`, `skills`, `username`, `emppassword`, `jobid`) VALUES
	(1, 'test', '05-01-1990', 'hfd', 4, '8475847584', 'sdhjdfhdj', 'jfhgjfhj', 'test05011990', 'test05011990', 2),
	(2, 'manager name', '09-08-1992', 'MBA', 5, '8594859485', 'jdsghsj', 'hfdjghjsdghj', 'manager name09081992', 'mana09081992', 1),
	(4, 'full name', '2017-10-14', 'MBA', 3, '9897878748', 'dhfdjsfhj', 'kjsdfhsdjh', 'full name2017-10-14', 'full2017-10-14', 3);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Dumping structure for table restaurant.job
CREATE TABLE IF NOT EXISTS `job` (
  `jobid` int(11) NOT NULL AUTO_INCREMENT,
  `jobtype` varchar(50) NOT NULL,
  `jobdesc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`jobid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table restaurant.job: ~3 rows (approximately)
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` (`jobid`, `jobtype`, `jobdesc`) VALUES
	(1, 'Manager', 'Manager'),
	(2, 'Part time Employee', 'part time employee'),
	(3, 'Full time employee', 'Full time employee');
/*!40000 ALTER TABLE `job` ENABLE KEYS */;

-- Dumping structure for table restaurant.menu
CREATE TABLE IF NOT EXISTS `menu` (
  `itemName` varchar(50) NOT NULL,
  `itemDesc` varchar(50) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table restaurant.menu: ~2 rows (approximately)
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`itemName`, `itemDesc`, `cost`) VALUES
	('Chicken Pizza', 'Chicken and chilly', 220),
	('Veg Pizza', 'corn and onion', 200);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

-- Dumping structure for table restaurant.reservation
CREATE TABLE IF NOT EXISTS `reservation` (
  `reservationid` int(11) NOT NULL AUTO_INCREMENT,
  `guestname` varchar(50) NOT NULL,
  `noofguests` int(11) NOT NULL,
  `typeid` int(11) DEFAULT NULL,
  `guestid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`reservationid`),
  KEY `typeid` (`typeid`),
  CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`typeid`) REFERENCES `reservationtype` (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table restaurant.reservation: ~2 rows (approximately)
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` (`reservationid`, `guestname`, `noofguests`, `typeid`, `guestid`) VALUES
	(1, 'guest name', 4, 1, 'guest name1509344862778'),
	(2, 'guest 2', 4, 1, 'guest 21509345048703');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;

-- Dumping structure for table restaurant.reservationtype
CREATE TABLE IF NOT EXISTS `reservationtype` (
  `typeid` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(50) NOT NULL,
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table restaurant.reservationtype: ~4 rows (approximately)
/*!40000 ALTER TABLE `reservationtype` DISABLE KEYS */;
INSERT INTO `reservationtype` (`typeid`, `typename`) VALUES
	(1, 'Dinner'),
	(2, 'Lunch'),
	(3, 'Brunch'),
	(4, 'Breakfast');
/*!40000 ALTER TABLE `reservationtype` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
