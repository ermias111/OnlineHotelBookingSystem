CREATE TABLE `address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `account` (
  `dtype` varchar(31) NOT NULL,
  `account_id` int NOT NULL AUTO_INCREMENT,
  `created_at` date DEFAULT NULL,
  `last_update` date DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL UNIQUE,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `photo_url` varchar(255) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  `address_id` int DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  CONSTRAINT `account_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `account_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
);

CREATE TABLE `payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `card_num` bigint DEFAULT NULL,
  `payment_amount` double DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `payment_account` FOREIGN KEY (`customer_id`) REFERENCES `account` (`account_id`)
);

CREATE TABLE `booking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `check_in` date DEFAULT NULL,
  `check_out` date DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `payment_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `booking_payment` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`),
  CONSTRAINT `booking_account` FOREIGN KEY (`customer_id`) REFERENCES `account` (`account_id`)
);


CREATE TABLE `feedback` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `hotel_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `feedback_account` FOREIGN KEY (`hotel_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `feedback_account_customer` FOREIGN KEY (`customer_id`) REFERENCES `account` (`account_id`)
);


CREATE TABLE `room_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(2000) DEFAULT NULL,
  `photo_url` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `hotel_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `room_type_account` FOREIGN KEY (`hotel_id`) REFERENCES `account` (`account_id`)
);


DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int NOT NULL AUTO_INCREMENT,
  `room_number` int DEFAULT NULL,
  `vacant` bit(1) DEFAULT NULL,
  `hotel_id` int DEFAULT NULL,
  `room_type_id` int DEFAULT NULL,
  `room_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `room_account` FOREIGN KEY (`hotel_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `room_room_type` FOREIGN KEY (`room_type_id`) REFERENCES `room_type` (`id`),
  CONSTRAINT `room_booking` FOREIGN KEY (`room_id`) REFERENCES `booking` (`id`)
);


