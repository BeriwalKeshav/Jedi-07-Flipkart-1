/*
MySQL Data Transfer
Source Host: localhost
Source Database: crs
Target Host: localhost
Target Database: crs
Date: 25-05-2021 23:02:27
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `userId` varchar(100) NOT NULL default '',
  PRIMARY KEY  (`userId`),
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userName`) ON DELETE CASCADE ON UPDATE NO ACTION
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
  `courseSeats` int(11) default NULL,
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
  PRIMARY KEY  (`notificationId`),
  KEY `studentId_constraint_notification` (`studentId`),
  KEY `ref_constraint` (`referenceId`),
  CONSTRAINT `ref_constraint` FOREIGN KEY (`referenceId`) REFERENCES `payment` (`referenceId`) ON DELETE CASCADE ON UPDATE NO ACTION,
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
  `status` tinyint(4) default NULL,
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
  `proffId` varchar(100) NOT NULL default '',
  PRIMARY KEY  (`proffId`),
  CONSTRAINT `professor_ibfk_3` FOREIGN KEY (`proffId`) REFERENCES `user` (`userName`) ON DELETE CASCADE ON UPDATE NO ACTION
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
  `userId` varchar(100) NOT NULL default '',
  `branch` varchar(100) default NULL,
  PRIMARY KEY  (`userId`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userName`) ON DELETE CASCADE ON UPDATE NO ACTION
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
  `role` varchar(100) default NULL,
  PRIMARY KEY  (`userId`),
  KEY `userName` (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `admin` VALUES ('admin');
INSERT INTO `course` VALUES ('cour1', 'gafasasd adsdads', '1', 'proff', '10');
INSERT INTO `course` VALUES ('cour2', 'appppp p p p p p p ', '1', 'proff', '9');
INSERT INTO `course` VALUES ('cour3', 'gggg gggg g g gg g ', '0', 'proff', '8');
INSERT INTO `notification` VALUES ('arrarsdasfdsdsfsdf', 'hello test ', 'stud2', 'pay321');
INSERT INTO `notification` VALUES ('ggggggggggggg', 'test 2', 'stud', 'pay123');
INSERT INTO `payment` VALUES ('pay123', 'stud', '1234', '0', 'CARD');
INSERT INTO `payment` VALUES ('pay321', 'stud2', '12', '1', 'CASH');
INSERT INTO `professor` VALUES ('cse', 'ajdnasnd adasdasda', 'proff');
INSERT INTO `registered_courses` VALUES ('stud', '3', 'cour1', 'B');
INSERT INTO `registered_courses` VALUES ('stud', '3', 'cour2', '');
INSERT INTO `registered_courses` VALUES ('stud2', '1', 'cour1', 'C');
INSERT INTO `student` VALUES ('stud', 'CSE');
INSERT INTO `student` VALUES ('stud2', 'EE');
INSERT INTO `user` VALUES ('a381df18-bd60-11eb-8529-0242ac130003', 'admin', 'admin', '2021-05-18', 'ADMIN');
INSERT INTO `user` VALUES ('c0a018a8-bd60-11eb-8529-0242ac130003', 'proff', 'proff', '2021-05-05', 'PROFESSOR');
INSERT INTO `user` VALUES ('cdc397c6-bd60-11eb-8529-0242ac130003', 'stud', 'stud', '2021-05-04', 'STUDENT');
INSERT INTO `user` VALUES ('ddbd34e8-bd60-11eb-8529-0242ac130003', 'stud2', 'stud2', '2021-05-13', 'STUDENT');
