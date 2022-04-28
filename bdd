-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 28 avr. 2022 à 09:17
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `pizzeria`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

DROP TABLE IF EXISTS `adresse`;
CREATE TABLE IF NOT EXISTS `adresse` (
  `idAdresse` int(11) NOT NULL AUTO_INCREMENT,
  `numRue` int(11) DEFAULT NULL,
  `ville` varchar(50) DEFAULT NULL,
  `codePostale` int(11) DEFAULT NULL,
  `completementAdresse` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idAdresse`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `nomClient` varchar(50) DEFAULT NULL,
  `prenomClient` varchar(50) DEFAULT NULL,
  `telClient` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idClient`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`idClient`, `nomClient`, `prenomClient`, `telClient`) VALUES
(1, 'COBI', 'ROMY', '01228732692');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `idCommande` int(11) NOT NULL,
  `HeureArrive` varchar(50) DEFAULT NULL,
  `idAdresse` int(11) NOT NULL,
  `idLivreur` int(11) NOT NULL,
  `idCuisinier` int(11) NOT NULL,
  `idDate` int(11) NOT NULL,
  `idClient` int(11) NOT NULL,
  PRIMARY KEY (`idCommande`),
  KEY `idAdresse` (`idAdresse`),
  KEY `idLivreur` (`idLivreur`),
  KEY `idCuisinier` (`idCuisinier`),
  KEY `idDate` (`idDate`),
  KEY `idClient` (`idClient`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `comporter`
--

DROP TABLE IF EXISTS `comporter`;
CREATE TABLE IF NOT EXISTS `comporter` (
  `idCommande` int(11) NOT NULL,
  `idPizza` int(11) NOT NULL,
  PRIMARY KEY (`idCommande`,`idPizza`),
  KEY `idPizza` (`idPizza`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `cuisinier`
--

DROP TABLE IF EXISTS `cuisinier`;
CREATE TABLE IF NOT EXISTS `cuisinier` (
  `idCuisinier` int(11) NOT NULL,
  `nomCuisinier` varchar(50) DEFAULT NULL,
  `prenomCuisinier` varchar(50) DEFAULT NULL,
  `numTel` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCuisinier`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `datecommande`
--

DROP TABLE IF EXISTS `datecommande`;
CREATE TABLE IF NOT EXISTS `datecommande` (
  `idDate` int(11) NOT NULL AUTO_INCREMENT,
  `DateCommande` date DEFAULT NULL,
  PRIMARY KEY (`idDate`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE IF NOT EXISTS `ingredient` (
  `idIngredient` int(11) NOT NULL AUTO_INCREMENT,
  `nomIngredient` varchar(50) DEFAULT NULL,
  `quantiteIngrediant` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`idIngredient`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `livreur`
--

DROP TABLE IF EXISTS `livreur`;
CREATE TABLE IF NOT EXISTS `livreur` (
  `idLivreur` int(11) NOT NULL,
  `nomLivreur` varchar(50) NOT NULL,
  `prenomLivreur` varchar(50) DEFAULT NULL,
  `numTel` int(11) DEFAULT NULL,
  PRIMARY KEY (`idLivreur`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `pizza`
--

DROP TABLE IF EXISTS `pizza`;
CREATE TABLE IF NOT EXISTS `pizza` (
  `idPizza` int(11) NOT NULL,
  `nomPizza` varchar(50) DEFAULT NULL,
  `taillePizza` varchar(50) DEFAULT NULL,
  `prixPizza` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`idPizza`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `posséder`
--

DROP TABLE IF EXISTS `posséder`;
CREATE TABLE IF NOT EXISTS `posséder` (
  `idPizza` int(11) NOT NULL,
  `idIngredient` int(11) NOT NULL,
  PRIMARY KEY (`idPizza`,`idIngredient`),
  KEY `idIngredient` (`idIngredient`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
