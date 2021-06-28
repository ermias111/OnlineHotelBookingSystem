--
-- Dumping data for table `address`
--
INSERT INTO `address` VALUES (1,'Forney','TX','+643...','43457','Julia 4th st'),(2,'Fairfield','IA','+641...','52557','1000 4th st');

--
-- Dumping data for table `role`
--
INSERT INTO `role` VALUES (1,'HotelRole','Hotel'),(2,'CustomerRole','Customer');

--
-- Dumping data for table `account`
--
INSERT INTO `account` VALUES ('Hotel',1,'2021-06-28','2021-06-28','1234','hilton12',NULL,NULL,NULL,'5 star','Hilton','img/1.jpg',1,2),('Customer',2,'2021-06-28','2021-06-28','1234','jj','j@gmail.com','James','Joseph',NULL,NULL,NULL,2,1);

--
-- Dumping data for table `payment`
--
INSERT INTO `payment` VALUES (1,123123123878976,1000,'3921-10-02',2);


--
-- Dumping data for table `room_type`
--
INSERT INTO `room_type` VALUES (1,'1 master bedroom','img/s.jpg',300,'Standard',1),(2,'2 master bedroom','img/e.jpg',400,'King',1);

--
-- Dumping data for table `room`
--
INSERT INTO `room` VALUES (1,100,_binary '',1,1,NULL),(2,101,_binary '',1,2,NULL),(3,102,_binary '',1,1,NULL);

