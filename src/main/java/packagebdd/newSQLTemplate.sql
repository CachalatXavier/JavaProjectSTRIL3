/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  najim
 * Created: 11 mai 2016
 */


CREATE DATABASE `chatbox`;
CREATE TABLE `chatbox`.`utilisateur` ( `idU` INT NOT NULL AUTO_INCREMENT , `nomU` VARCHAR(100) NOT NULL , `prenomU` VARCHAR(100) NOT NULL , `mdpU` VARCHAR(100) NOT NULL , `droitU` VARCHAR(100) NOT NULL , `presentU` BOOLEAN NOT NULL , PRIMARY KEY (`idU`)) ENGINE = InnoDB;
SELECT * FROM `utilisateur`
DROP TABLE `utilisateur`
CREATE TABLE `chatbox`.`utilisateur` ( `id` INT NOT NULL AUTO_INCREMENT , `nomU` VARCHAR(100) NOT NULL , `prenomU` VARCHAR(100) NOT NULL , `mdpU` VARCHAR(100) NOT NULL , `droitU` INT NOT NULL , `presentU` BOOLEAN NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;
CREATE TABLE `chatbox`.`utilisateur` ( `id` INT NOT NULL AUTO_INCREMENT , `nomU` VARCHAR(100) NOT NULL , `prenomU` VARCHAR(100) NOT NULL , `mdpU` VARCHAR(100) NOT NULL , `droitU` INT NOT NULL , `presentU` BOOLEAN NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;
CREATE TABLE `chatbox`.`essage` ( `idM` INT NOT NULL AUTO_INCREMENT , `contenuM` TEXT NOT NULL , `dateM` DATE NOT NULL , `emetteurM` VARCHAR(100) NOT NULL , `destinataireM` VARCHAR(100) NOT NULL , PRIMARY KEY (`idM`)) ENGINE = InnoDB;
CREATE TABLE `chatbox`.`salon` ( `idS` INT NOT NULL AUTO_INCREMENT , `description` TEXT NOT NULL , `listUser` TEXT NOT NULL , `listMessage` TEXT NOT NULL , PRIMARY KEY (`idS`)) ENGINE = InnoDB;
ALTER TABLE `salon` DROP `listUser`;
CREATE TABLE `chatbox`.`message` ( `idM` int( 11 ) NOT NULL , `contenuM` text NOT NULL , `dateM` date NOT NULL , `emetteurM` varchar( 100 ) NOT NULL , `destinataireM` varchar( 100 ) NOT NULL ) ENGINE = InnoDB DEFAULT CHARSET = latin1
CREATE TABLE `chatbox`.`messageSalon` ( `idMsalon` INT NOT NULL AUTO_INCREMENT , `contenuMS` TEXT NOT NULL , `dateMS` DATE NOT NULL , PRIMARY KEY (`idMsalon`)) ENGINE = InnoDB;
CREATE TABLE `chatbox`.`messageSalon` ( `idMsalon` INT NOT NULL AUTO_INCREMENT , `contenuMS` TEXT NOT NULL , `dateMS` DATE NOT NULL , PRIMARY KEY (`idMsalon`)) ENGINE = InnoDB;
CREATE TABLE `chatbox`.`fairePartie` ( `idU` INT NOT NULL , `idS` INT NOT NULL , PRIMARY KEY (`idS`)) ENGINE = InnoDB;
Développer Exécuter la requête à nouveau Modifier Expliquer Profilage Base de données: chatbox Daté du: 17:2:24
SELECT * FROM `utilisateur`

