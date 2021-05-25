/*
MySQL Data Transfer
Source Host: localhost
Source Database: crs
Target Host: localhost
Target Database: crs
Date: 25-05-2021 18:59:39
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `userId` varchar(100) default NULL,
  KEY `user_id_constraint_admin` (`userId`),
  CONSTRAINT `user_id_constraint_admin` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cCode` varchar(100) NOT NULL default '',
  `cName` varchar(100) default NULL,
  `isOffered` binary(255) default NULL,
  `instructor` varchar(100) default NULL,
  PRIMARY KEY  (`cCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `notificationId` varchar(100) NOT NULL,
  `message` varchar(300) NOT NULL,
  `studentId` varchar(100) NOT NULL,
  `referenceId` varchar(100) default NULL,
  KEY `studentId_constraint_notification` (`studentId`),
  CONSTRAINT `studentId_constraint_notification` FOREIGN KEY (`studentId`) REFERENCES `student` (`userId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `referenceId` varchar(100) NOT NULL default '',
  `studentId` varchar(100) default NULL,
  `amount` int(11) default NULL,
  `status` binary(255) default NULL,
  `paymentType` varchar(100) default NULL,
  PRIMARY KEY  (`referenceId`),
  KEY `studentId` (`studentId`),
  CONSTRAINT `studentId` FOREIGN KEY (`studentId`) REFERENCES `student` (`userId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for professor
-- ----------------------------
DROP TABLE IF EXISTS `professor`;
CREATE TABLE `professor` (
  `department` varchar(100) default NULL,
  `designation` varchar(100) default NULL,
  `userId` varchar(100) default NULL,
  KEY `user_id_constraint_proff` (`userId`),
  CONSTRAINT `user_id_constraint_proff` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for registered_courses
-- ----------------------------
DROP TABLE IF EXISTS `registered_courses`;
CREATE TABLE `registered_courses` (
  `studentId` varchar(100) default NULL,
  `semester` int(11) default NULL,
  `courseCode` varchar(100) default NULL,
  `grade` varchar(10) default NULL,
  KEY `stud_id_constraint` (`studentId`),
  KEY `course_code_constraint` (`courseCode`),
  CONSTRAINT `stud_id_constraint` FOREIGN KEY (`studentId`) REFERENCES `student` (`userId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `course_code_constraint` FOREIGN KEY (`courseCode`) REFERENCES `course` (`cCode`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `userId` varchar(100) default NULL,
  `branch` varchar(100) default NULL,
  KEY `user_id_constraint` (`userId`),
  CONSTRAINT `user_id_constraint` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(100) NOT NULL default '',
  `userName` varchar(100) default NULL,
  `passwordHash` varchar(100) default NULL,
  `createDate` date default NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
