-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: oic
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `access_token`
--

DROP TABLE IF EXISTS `access_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `access_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `token_value` varchar(4096) DEFAULT NULL,
  `expiration` timestamp NULL DEFAULT NULL,
  `token_type` varchar(256) DEFAULT NULL,
  `refresh_token_id` bigint(20) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `auth_holder_id` bigint(20) DEFAULT NULL,
  `approved_site_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `access_token`
--

LOCK TABLES `access_token` WRITE;
/*!40000 ALTER TABLE `access_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `access_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `access_token_permissions`
--

DROP TABLE IF EXISTS `access_token_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `access_token_permissions` (
  `access_token_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `access_token_permissions`
--

LOCK TABLES `access_token_permissions` WRITE;
/*!40000 ALTER TABLE `access_token_permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `access_token_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `formatted` varchar(256) DEFAULT NULL,
  `street_address` varchar(256) DEFAULT NULL,
  `locality` varchar(256) DEFAULT NULL,
  `region` varchar(256) DEFAULT NULL,
  `postal_code` varchar(256) DEFAULT NULL,
  `country` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `approved_site`
--

DROP TABLE IF EXISTS `approved_site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `approved_site` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT NULL,
  `access_date` timestamp NULL DEFAULT NULL,
  `timeout_date` timestamp NULL DEFAULT NULL,
  `whitelisted_site_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `approved_site`
--

LOCK TABLES `approved_site` WRITE;
/*!40000 ALTER TABLE `approved_site` DISABLE KEYS */;
INSERT INTO `approved_site` VALUES (1,'admin','client','2019-06-04 11:17:01','2019-06-04 11:17:01',NULL,NULL);
/*!40000 ALTER TABLE `approved_site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `approved_site_scope`
--

DROP TABLE IF EXISTS `approved_site_scope`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `approved_site_scope` (
  `owner_id` bigint(20) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `approved_site_scope`
--

LOCK TABLES `approved_site_scope` WRITE;
/*!40000 ALTER TABLE `approved_site_scope` DISABLE KEYS */;
INSERT INTO `approved_site_scope` VALUES (1,'address'),(1,'phone'),(1,'openid'),(1,'email'),(1,'profile');
/*!40000 ALTER TABLE `approved_site_scope` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authentication_holder`
--

DROP TABLE IF EXISTS `authentication_holder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `authentication_holder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_auth_id` bigint(20) DEFAULT NULL,
  `approved` tinyint(1) DEFAULT NULL,
  `redirect_uri` varchar(2048) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authentication_holder`
--

LOCK TABLES `authentication_holder` WRITE;
/*!40000 ALTER TABLE `authentication_holder` DISABLE KEYS */;
/*!40000 ALTER TABLE `authentication_holder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authentication_holder_authority`
--

DROP TABLE IF EXISTS `authentication_holder_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `authentication_holder_authority` (
  `owner_id` bigint(20) DEFAULT NULL,
  `authority` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authentication_holder_authority`
--

LOCK TABLES `authentication_holder_authority` WRITE;
/*!40000 ALTER TABLE `authentication_holder_authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `authentication_holder_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authentication_holder_extension`
--

DROP TABLE IF EXISTS `authentication_holder_extension`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `authentication_holder_extension` (
  `owner_id` bigint(20) DEFAULT NULL,
  `extension` varchar(2048) DEFAULT NULL,
  `val` varchar(2048) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authentication_holder_extension`
--

LOCK TABLES `authentication_holder_extension` WRITE;
/*!40000 ALTER TABLE `authentication_holder_extension` DISABLE KEYS */;
/*!40000 ALTER TABLE `authentication_holder_extension` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authentication_holder_request_parameter`
--

DROP TABLE IF EXISTS `authentication_holder_request_parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `authentication_holder_request_parameter` (
  `owner_id` bigint(20) DEFAULT NULL,
  `param` varchar(2048) DEFAULT NULL,
  `val` varchar(2048) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authentication_holder_request_parameter`
--

LOCK TABLES `authentication_holder_request_parameter` WRITE;
/*!40000 ALTER TABLE `authentication_holder_request_parameter` DISABLE KEYS */;
/*!40000 ALTER TABLE `authentication_holder_request_parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authentication_holder_resource_id`
--

DROP TABLE IF EXISTS `authentication_holder_resource_id`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `authentication_holder_resource_id` (
  `owner_id` bigint(20) DEFAULT NULL,
  `resource_id` varchar(2048) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authentication_holder_resource_id`
--

LOCK TABLES `authentication_holder_resource_id` WRITE;
/*!40000 ALTER TABLE `authentication_holder_resource_id` DISABLE KEYS */;
/*!40000 ALTER TABLE `authentication_holder_resource_id` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authentication_holder_response_type`
--

DROP TABLE IF EXISTS `authentication_holder_response_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `authentication_holder_response_type` (
  `owner_id` bigint(20) DEFAULT NULL,
  `response_type` varchar(2048) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authentication_holder_response_type`
--

LOCK TABLES `authentication_holder_response_type` WRITE;
/*!40000 ALTER TABLE `authentication_holder_response_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `authentication_holder_response_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authentication_holder_scope`
--

DROP TABLE IF EXISTS `authentication_holder_scope`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `authentication_holder_scope` (
  `owner_id` bigint(20) DEFAULT NULL,
  `scope` varchar(2048) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authentication_holder_scope`
--

LOCK TABLES `authentication_holder_scope` WRITE;
/*!40000 ALTER TABLE `authentication_holder_scope` DISABLE KEYS */;
/*!40000 ALTER TABLE `authentication_holder_scope` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_authority` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('admin','ROLE_ADMIN'),('admin','ROLE_USER'),('user','ROLE_USER');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authorization_code`
--

DROP TABLE IF EXISTS `authorization_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `authorization_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(256) DEFAULT NULL,
  `auth_holder_id` bigint(20) DEFAULT NULL,
  `expiration` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorization_code`
--

LOCK TABLES `authorization_code` WRITE;
/*!40000 ALTER TABLE `authorization_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `authorization_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blacklisted_site`
--

DROP TABLE IF EXISTS `blacklisted_site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `blacklisted_site` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uri` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blacklisted_site`
--

LOCK TABLES `blacklisted_site` WRITE;
/*!40000 ALTER TABLE `blacklisted_site` DISABLE KEYS */;
/*!40000 ALTER TABLE `blacklisted_site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `claim`
--

DROP TABLE IF EXISTS `claim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `claim` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `friendly_name` varchar(1024) DEFAULT NULL,
  `claim_type` varchar(1024) DEFAULT NULL,
  `claim_value` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `claim`
--

LOCK TABLES `claim` WRITE;
/*!40000 ALTER TABLE `claim` DISABLE KEYS */;
/*!40000 ALTER TABLE `claim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `claim_issuer`
--

DROP TABLE IF EXISTS `claim_issuer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `claim_issuer` (
  `owner_id` bigint(20) NOT NULL,
  `issuer` varchar(1024) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `claim_issuer`
--

LOCK TABLES `claim_issuer` WRITE;
/*!40000 ALTER TABLE `claim_issuer` DISABLE KEYS */;
/*!40000 ALTER TABLE `claim_issuer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `claim_to_permission_ticket`
--

DROP TABLE IF EXISTS `claim_to_permission_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `claim_to_permission_ticket` (
  `permission_ticket_id` bigint(20) NOT NULL,
  `claim_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `claim_to_permission_ticket`
--

LOCK TABLES `claim_to_permission_ticket` WRITE;
/*!40000 ALTER TABLE `claim_to_permission_ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `claim_to_permission_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `claim_to_policy`
--

DROP TABLE IF EXISTS `claim_to_policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `claim_to_policy` (
  `policy_id` bigint(20) NOT NULL,
  `claim_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `claim_to_policy`
--

LOCK TABLES `claim_to_policy` WRITE;
/*!40000 ALTER TABLE `claim_to_policy` DISABLE KEYS */;
/*!40000 ALTER TABLE `claim_to_policy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `claim_token_format`
--

DROP TABLE IF EXISTS `claim_token_format`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `claim_token_format` (
  `owner_id` bigint(20) NOT NULL,
  `claim_token_format` varchar(1024) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `claim_token_format`
--

LOCK TABLES `claim_token_format` WRITE;
/*!40000 ALTER TABLE `claim_token_format` DISABLE KEYS */;
/*!40000 ALTER TABLE `claim_token_format` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_authority`
--

DROP TABLE IF EXISTS `client_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `client_authority` (
  `owner_id` bigint(20) DEFAULT NULL,
  `authority` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_authority`
--

LOCK TABLES `client_authority` WRITE;
/*!40000 ALTER TABLE `client_authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `client_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_claims_redirect_uri`
--

DROP TABLE IF EXISTS `client_claims_redirect_uri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `client_claims_redirect_uri` (
  `owner_id` bigint(20) DEFAULT NULL,
  `redirect_uri` varchar(2048) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_claims_redirect_uri`
--

LOCK TABLES `client_claims_redirect_uri` WRITE;
/*!40000 ALTER TABLE `client_claims_redirect_uri` DISABLE KEYS */;
/*!40000 ALTER TABLE `client_claims_redirect_uri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_contact`
--

DROP TABLE IF EXISTS `client_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `client_contact` (
  `owner_id` bigint(20) DEFAULT NULL,
  `contact` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_contact`
--

LOCK TABLES `client_contact` WRITE;
/*!40000 ALTER TABLE `client_contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `client_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_default_acr_value`
--

DROP TABLE IF EXISTS `client_default_acr_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `client_default_acr_value` (
  `owner_id` bigint(20) DEFAULT NULL,
  `default_acr_value` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_default_acr_value`
--

LOCK TABLES `client_default_acr_value` WRITE;
/*!40000 ALTER TABLE `client_default_acr_value` DISABLE KEYS */;
/*!40000 ALTER TABLE `client_default_acr_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_details`
--

DROP TABLE IF EXISTS `client_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `client_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client_description` varchar(256) DEFAULT NULL,
  `reuse_refresh_tokens` tinyint(1) NOT NULL DEFAULT '1',
  `dynamically_registered` tinyint(1) NOT NULL DEFAULT '0',
  `allow_introspection` tinyint(1) NOT NULL DEFAULT '0',
  `id_token_validity_seconds` bigint(20) NOT NULL DEFAULT '600',
  `device_code_validity_seconds` bigint(20) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `client_secret` varchar(512) DEFAULT NULL,
  `access_token_validity_seconds` bigint(20) DEFAULT NULL,
  `refresh_token_validity_seconds` bigint(20) DEFAULT NULL,
  `application_type` varchar(256) DEFAULT NULL,
  `client_name` varchar(256) DEFAULT NULL,
  `token_endpoint_auth_method` varchar(256) DEFAULT NULL,
  `subject_type` varchar(256) DEFAULT NULL,
  `logo_uri` varchar(256) DEFAULT NULL,
  `policy_uri` varchar(256) DEFAULT NULL,
  `client_uri` varchar(256) DEFAULT NULL,
  `tos_uri` varchar(256) DEFAULT NULL,
  `jwks_uri` varchar(1024) DEFAULT NULL,
  `jwks` varchar(2048) DEFAULT NULL,
  `sector_identifier_uri` varchar(512) DEFAULT NULL,
  `request_object_signing_alg` varchar(256) DEFAULT NULL,
  `user_info_signed_response_alg` varchar(256) DEFAULT NULL,
  `user_info_encrypted_response_alg` varchar(256) DEFAULT NULL,
  `user_info_encrypted_response_enc` varchar(256) DEFAULT NULL,
  `id_token_signed_response_alg` varchar(256) DEFAULT NULL,
  `id_token_encrypted_response_alg` varchar(256) DEFAULT NULL,
  `id_token_encrypted_response_enc` varchar(256) DEFAULT NULL,
  `token_endpoint_auth_signing_alg` varchar(256) DEFAULT NULL,
  `default_max_age` bigint(20) DEFAULT NULL,
  `require_auth_time` tinyint(1) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `initiate_login_uri` varchar(512) DEFAULT NULL,
  `clear_access_tokens_on_refresh` tinyint(1) NOT NULL DEFAULT '1',
  `software_statement` varchar(512) DEFAULT NULL,
  `software_id` varchar(512) DEFAULT NULL,
  `software_version` varchar(512) DEFAULT NULL,
  `code_challenge_method` varchar(256) DEFAULT NULL,
  `pk` blob,
  `sid_auth_not` varchar(256) DEFAULT NULL,
  `ppa_subs_not` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `client_id` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_details`
--

LOCK TABLES `client_details` WRITE;
/*!40000 ALTER TABLE `client_details` DISABLE KEYS */;
INSERT INTO `client_details` VALUES (1,NULL,1,0,1,600,NULL,'client','secret',3600,NULL,NULL,'Test Client','SECRET_BASIC',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `client_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_grant_type`
--

DROP TABLE IF EXISTS `client_grant_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `client_grant_type` (
  `owner_id` bigint(20) DEFAULT NULL,
  `grant_type` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_grant_type`
--

LOCK TABLES `client_grant_type` WRITE;
/*!40000 ALTER TABLE `client_grant_type` DISABLE KEYS */;
INSERT INTO `client_grant_type` VALUES (1,'authorization_code'),(1,'urn:ietf:params:oauth:grant_type:redelegate'),(1,'implicit'),(1,'refresh_token'),(1,'authorization_code'),(1,'urn:ietf:params:oauth:grant_type:redelegate'),(1,'implicit'),(1,'refresh_token');
/*!40000 ALTER TABLE `client_grant_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_post_logout_redirect_uri`
--

DROP TABLE IF EXISTS `client_post_logout_redirect_uri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `client_post_logout_redirect_uri` (
  `owner_id` bigint(20) DEFAULT NULL,
  `post_logout_redirect_uri` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_post_logout_redirect_uri`
--

LOCK TABLES `client_post_logout_redirect_uri` WRITE;
/*!40000 ALTER TABLE `client_post_logout_redirect_uri` DISABLE KEYS */;
/*!40000 ALTER TABLE `client_post_logout_redirect_uri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_redirect_uri`
--

DROP TABLE IF EXISTS `client_redirect_uri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `client_redirect_uri` (
  `owner_id` bigint(20) DEFAULT NULL,
  `redirect_uri` varchar(2048) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_redirect_uri`
--

LOCK TABLES `client_redirect_uri` WRITE;
/*!40000 ALTER TABLE `client_redirect_uri` DISABLE KEYS */;
INSERT INTO `client_redirect_uri` VALUES (1,'http://localhost/'),(1,'http://localhost:8080/'),(1,'http://localhost:8080/simple-web-app/openid_connect_login'),(1,'http://localhost/'),(1,'http://localhost:8080/');
/*!40000 ALTER TABLE `client_redirect_uri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_request_uri`
--

DROP TABLE IF EXISTS `client_request_uri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `client_request_uri` (
  `owner_id` bigint(20) DEFAULT NULL,
  `request_uri` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_request_uri`
--

LOCK TABLES `client_request_uri` WRITE;
/*!40000 ALTER TABLE `client_request_uri` DISABLE KEYS */;
/*!40000 ALTER TABLE `client_request_uri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_resource`
--

DROP TABLE IF EXISTS `client_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `client_resource` (
  `owner_id` bigint(20) DEFAULT NULL,
  `resource_id` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_resource`
--

LOCK TABLES `client_resource` WRITE;
/*!40000 ALTER TABLE `client_resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `client_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_response_type`
--

DROP TABLE IF EXISTS `client_response_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `client_response_type` (
  `owner_id` bigint(20) DEFAULT NULL,
  `response_type` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_response_type`
--

LOCK TABLES `client_response_type` WRITE;
/*!40000 ALTER TABLE `client_response_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `client_response_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_scope`
--

DROP TABLE IF EXISTS `client_scope`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `client_scope` (
  `owner_id` bigint(20) DEFAULT NULL,
  `scope` varchar(2048) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_scope`
--

LOCK TABLES `client_scope` WRITE;
/*!40000 ALTER TABLE `client_scope` DISABLE KEYS */;
INSERT INTO `client_scope` VALUES (1,'openid'),(1,'profile'),(1,'email'),(1,'address'),(1,'phone'),(1,'offline_access'),(1,'openid'),(1,'profile'),(1,'email'),(1,'address'),(1,'phone'),(1,'offline_access');
/*!40000 ALTER TABLE `client_scope` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_code`
--

DROP TABLE IF EXISTS `device_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `device_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `device_code` varchar(1024) DEFAULT NULL,
  `user_code` varchar(1024) DEFAULT NULL,
  `expiration` timestamp NULL DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `approved` tinyint(1) DEFAULT NULL,
  `auth_holder_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_code`
--

LOCK TABLES `device_code` WRITE;
/*!40000 ALTER TABLE `device_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_code_request_parameter`
--

DROP TABLE IF EXISTS `device_code_request_parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `device_code_request_parameter` (
  `owner_id` bigint(20) DEFAULT NULL,
  `param` varchar(2048) DEFAULT NULL,
  `val` varchar(2048) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_code_request_parameter`
--

LOCK TABLES `device_code_request_parameter` WRITE;
/*!40000 ALTER TABLE `device_code_request_parameter` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_code_request_parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_code_scope`
--

DROP TABLE IF EXISTS `device_code_scope`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `device_code_scope` (
  `owner_id` bigint(20) NOT NULL,
  `scope` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_code_scope`
--

LOCK TABLES `device_code_scope` WRITE;
/*!40000 ALTER TABLE `device_code_scope` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_code_scope` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pairwise_identifier`
--

DROP TABLE IF EXISTS `pairwise_identifier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pairwise_identifier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `identifier` varchar(256) DEFAULT NULL,
  `sub` varchar(256) DEFAULT NULL,
  `sector_identifier` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pairwise_identifier`
--

LOCK TABLES `pairwise_identifier` WRITE;
/*!40000 ALTER TABLE `pairwise_identifier` DISABLE KEYS */;
/*!40000 ALTER TABLE `pairwise_identifier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdc`
--

DROP TABLE IF EXISTS `pdc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pdc` (
  `id` varchar(256) NOT NULL,
  `ppa` varchar(256) DEFAULT NULL,
  `dps` varchar(256) DEFAULT NULL,
  `dpr` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdc`
--

LOCK TABLES `pdc` WRITE;
/*!40000 ALTER TABLE `pdc` DISABLE KEYS */;
/*!40000 ALTER TABLE `pdc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdw`
--

DROP TABLE IF EXISTS `pdw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pdw` (
  `pid` varchar(256) DEFAULT NULL,
  `sid` varchar(256) DEFAULT NULL,
  `ppa` varchar(256) DEFAULT NULL,
  `id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdw`
--

LOCK TABLES `pdw` WRITE;
/*!40000 ALTER TABLE `pdw` DISABLE KEYS */;
/*!40000 ALTER TABLE `pdw` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `resource_set_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission_scope`
--

DROP TABLE IF EXISTS `permission_scope`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `permission_scope` (
  `owner_id` bigint(20) NOT NULL,
  `scope` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission_scope`
--

LOCK TABLES `permission_scope` WRITE;
/*!40000 ALTER TABLE `permission_scope` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission_scope` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission_ticket`
--

DROP TABLE IF EXISTS `permission_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `permission_ticket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ticket` varchar(256) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  `expiration` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission_ticket`
--

LOCK TABLES `permission_ticket` WRITE;
/*!40000 ALTER TABLE `permission_ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pip`
--

DROP TABLE IF EXISTS `pip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pip` (
  `id` varchar(256) NOT NULL,
  `pk` blob,
  `sid_auth` varchar(256) DEFAULT NULL,
  `sid_cert` varchar(256) DEFAULT NULL,
  `ppa_subs` varchar(256) DEFAULT NULL,
  `ppa_emit` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pip`
--

LOCK TABLES `pip` WRITE;
/*!40000 ALTER TABLE `pip` DISABLE KEYS */;
INSERT INTO `pip` VALUES ('1',NULL,'http://localhost:8080/openid-connect-server-webapp/token','http://localhost:8080/openid-connect-server-webapp/auth',NULL,NULL);
/*!40000 ALTER TABLE `pip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policy`
--

DROP TABLE IF EXISTS `policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `policy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(1024) DEFAULT NULL,
  `resource_set_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy`
--

LOCK TABLES `policy` WRITE;
/*!40000 ALTER TABLE `policy` DISABLE KEYS */;
/*!40000 ALTER TABLE `policy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policy_scope`
--

DROP TABLE IF EXISTS `policy_scope`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `policy_scope` (
  `owner_id` bigint(20) NOT NULL,
  `scope` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy_scope`
--

LOCK TABLES `policy_scope` WRITE;
/*!40000 ALTER TABLE `policy_scope` DISABLE KEYS */;
/*!40000 ALTER TABLE `policy_scope` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ppa`
--

DROP TABLE IF EXISTS `ppa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ppa` (
  `id` varchar(256) NOT NULL,
  `ppm` varchar(256) DEFAULT NULL,
  `pip` varchar(256) DEFAULT NULL,
  `opt` varchar(4096) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ppa`
--

LOCK TABLES `ppa` WRITE;
/*!40000 ALTER TABLE `ppa` DISABLE KEYS */;
/*!40000 ALTER TABLE `ppa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ppm`
--

DROP TABLE IF EXISTS `ppm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ppm` (
  `id` varchar(256) NOT NULL,
  `dp` varchar(256) DEFAULT NULL,
  `mod` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ppm`
--

LOCK TABLES `ppm` WRITE;
/*!40000 ALTER TABLE `ppm` DISABLE KEYS */;
/*!40000 ALTER TABLE `ppm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refresh_token`
--

DROP TABLE IF EXISTS `refresh_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `refresh_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `token_value` varchar(4096) DEFAULT NULL,
  `expiration` timestamp NULL DEFAULT NULL,
  `auth_holder_id` bigint(20) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refresh_token`
--

LOCK TABLES `refresh_token` WRITE;
/*!40000 ALTER TABLE `refresh_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `refresh_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource_set`
--

DROP TABLE IF EXISTS `resource_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `resource_set` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(1024) NOT NULL,
  `uri` varchar(1024) DEFAULT NULL,
  `icon_uri` varchar(1024) DEFAULT NULL,
  `rs_type` varchar(256) DEFAULT NULL,
  `owner` varchar(256) NOT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource_set`
--

LOCK TABLES `resource_set` WRITE;
/*!40000 ALTER TABLE `resource_set` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource_set_scope`
--

DROP TABLE IF EXISTS `resource_set_scope`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `resource_set_scope` (
  `owner_id` bigint(20) NOT NULL,
  `scope` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource_set_scope`
--

LOCK TABLES `resource_set_scope` WRITE;
/*!40000 ALTER TABLE `resource_set_scope` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource_set_scope` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saved_registered_client`
--

DROP TABLE IF EXISTS `saved_registered_client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `saved_registered_client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `issuer` varchar(1024) DEFAULT NULL,
  `registered_client` varchar(8192) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saved_registered_client`
--

LOCK TABLES `saved_registered_client` WRITE;
/*!40000 ALTER TABLE `saved_registered_client` DISABLE KEYS */;
/*!40000 ALTER TABLE `saved_registered_client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saved_user_auth`
--

DROP TABLE IF EXISTS `saved_user_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `saved_user_auth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(1024) DEFAULT NULL,
  `authenticated` tinyint(1) DEFAULT NULL,
  `source_class` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saved_user_auth`
--

LOCK TABLES `saved_user_auth` WRITE;
/*!40000 ALTER TABLE `saved_user_auth` DISABLE KEYS */;
/*!40000 ALTER TABLE `saved_user_auth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saved_user_auth_authority`
--

DROP TABLE IF EXISTS `saved_user_auth_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `saved_user_auth_authority` (
  `owner_id` bigint(20) DEFAULT NULL,
  `authority` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saved_user_auth_authority`
--

LOCK TABLES `saved_user_auth_authority` WRITE;
/*!40000 ALTER TABLE `saved_user_auth_authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `saved_user_auth_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sid`
--

DROP TABLE IF EXISTS `sid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sid` (
  `id` varchar(256) NOT NULL,
  `pip` varchar(45) DEFAULT NULL,
  `crt_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sid`
--

LOCK TABLES `sid` WRITE;
/*!40000 ALTER TABLE `sid` DISABLE KEYS */;
/*!40000 ALTER TABLE `sid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_scope`
--

DROP TABLE IF EXISTS `system_scope`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `system_scope` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `scope` varchar(256) NOT NULL,
  `description` varchar(4096) DEFAULT NULL,
  `icon` varchar(256) DEFAULT NULL,
  `restricted` tinyint(1) NOT NULL DEFAULT '0',
  `default_scope` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `scope` (`scope`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_scope`
--

LOCK TABLES `system_scope` WRITE;
/*!40000 ALTER TABLE `system_scope` DISABLE KEYS */;
INSERT INTO `system_scope` VALUES (1,'openid','log in using your identity','user',0,1),(2,'profile','basic profile information','list-alt',0,1),(3,'email','email address','envelope',0,1),(4,'address','physical address','home',0,1),(5,'phone','telephone number','bell',0,1),(6,'offline_access','offline access','time',0,0);
/*!40000 ALTER TABLE `system_scope` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token_scope`
--

DROP TABLE IF EXISTS `token_scope`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `token_scope` (
  `owner_id` bigint(20) DEFAULT NULL,
  `scope` varchar(2048) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token_scope`
--

LOCK TABLES `token_scope` WRITE;
/*!40000 ALTER TABLE `token_scope` DISABLE KEYS */;
/*!40000 ALTER TABLE `token_scope` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sub` varchar(256) DEFAULT NULL,
  `preferred_username` varchar(256) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `given_name` varchar(256) DEFAULT NULL,
  `family_name` varchar(256) DEFAULT NULL,
  `middle_name` varchar(256) DEFAULT NULL,
  `nickname` varchar(256) DEFAULT NULL,
  `profile` varchar(256) DEFAULT NULL,
  `picture` varchar(256) DEFAULT NULL,
  `website` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `email_verified` tinyint(1) DEFAULT NULL,
  `gender` varchar(256) DEFAULT NULL,
  `zone_info` varchar(256) DEFAULT NULL,
  `locale` varchar(256) DEFAULT NULL,
  `phone_number` varchar(256) DEFAULT NULL,
  `phone_number_verified` tinyint(1) DEFAULT NULL,
  `address_id` varchar(256) DEFAULT NULL,
  `updated_time` varchar(256) DEFAULT NULL,
  `birthdate` varchar(256) DEFAULT NULL,
  `src` varchar(4096) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,'01921.FLANRJQW','user','Demo User',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'user@example.com',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'90342.ASDFJWFA','admin','Demo Admin',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin@example.com',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'01921.FLANRJQW','user','Demo User',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'user@example.com',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'90342.ASDFJWFA','admin','Demo Admin',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin@example.com',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','password',1),('user','password',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `whitelisted_site`
--

DROP TABLE IF EXISTS `whitelisted_site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `whitelisted_site` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creator_user_id` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `whitelisted_site`
--

LOCK TABLES `whitelisted_site` WRITE;
/*!40000 ALTER TABLE `whitelisted_site` DISABLE KEYS */;
/*!40000 ALTER TABLE `whitelisted_site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `whitelisted_site_scope`
--

DROP TABLE IF EXISTS `whitelisted_site_scope`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `whitelisted_site_scope` (
  `owner_id` bigint(20) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `whitelisted_site_scope`
--

LOCK TABLES `whitelisted_site_scope` WRITE;
/*!40000 ALTER TABLE `whitelisted_site_scope` DISABLE KEYS */;
/*!40000 ALTER TABLE `whitelisted_site_scope` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-11 14:22:04
