CREATE TABLE pip` (
  `id` VARCHAR(256) NOT NULL,
  `pk` BLOB NULL,
  `sid_auth` VARCHAR(256) NULL,
  `sid_cert` VARCHAR(256) NULL,
  `ppa_subs` VARCHAR(256) NULL,
  `ppa_emit` VARCHAR(256) NULL,
  PRIMARY KEY (`id`));

INSERT INTO `oic`.`pip` (`id`, `sid_auth`, `sid_cert`)
 VALUES ('1', 'http://localhost:8080/openid-connect-server-webapp/token', 'http://localhost:8080/openid-connect-server-webapp/auth');

