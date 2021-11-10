/*
 * Engine: MySQL
 * Version: 0.0.1
 * Description: Sample Data
 */

--
-- Data for table `address`
--

INSERT INTO `address` (`city`,`zipcode`) VALUES ('Wisokyburghh','90565-7771');
INSERT INTO `address` (`city`,`zipcode`) VALUES ('Wisokyburgh','90565-777');

--
-- Data for table `person`
--

INSERT INTO `person` (`name`,`email`,`mobile_number`,`address_id`) VALUES ('John','example1@domain.com','1234567890',1);
INSERT INTO `person` (`name`,`email`,`mobile_number`,`address_id`) VALUES ('Jane','example2@domain.com','1234567891',2);



