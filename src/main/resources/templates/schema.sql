DROP TABLE IF EXISTS role;
CREATE TABLE role (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  role_name varchar(100) DEFAULT NULL,
  description varchar(100) DEFAULT NULL
);

DROP TABLE IF EXISTS account;
CREATE TABLE account (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255),
  password VARCHAR(255),
  active boolean,
  created_at timestamp,
  last_update timestamp
);

--DROP TABLE IF EXISTS user_role;
--CREATE TABLE user_role (
--  user_id BIGINT NOT NULL,
--  role_id BIGINT NOT NULL,
--  CONSTRAINT FK_SECURITY_ACCOUNT_ID FOREIGN KEY (user_id) REFERENCES account (id),
--  CONSTRAINT FK_SECURITY_ROLE_ID FOREIGN KEY (role_id) REFERENCES role (id)
--);

--DROP TABLE IF EXISTS user_role;
--CREATE TABLE admin (
--  admin_id BIGINT PRIMARY KEY AUTO_INCREMENT,
--  account_id INT NOT NULL UNIQUE
--);

DROP TABLE IF EXISTS hotel;
CREATE TABLE hotel (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  description VARCHAR(255),
  photoUrl VARCHAR(255),
  address_id INT,
  account_id INT
);

DROP TABLE IF EXISTS address;
CREATE TABLE address (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  adrress VARCHAR(255),
  address2 VARCHAR(255),
  district VARCHAR(255),
  city_id INT,
  postal_code INT,
  phone VARCHAR(255)
);