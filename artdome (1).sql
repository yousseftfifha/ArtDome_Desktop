-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 04 mars 2021 à 17:25
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `artdome`
--

-- --------------------------------------------------------

--
-- Structure de la table `blog`
--

DROP TABLE IF EXISTS `blog`;
CREATE TABLE IF NOT EXISTS `blog` (
  `blog_id` int(11) NOT NULL,
  `date_post` date NOT NULL,
  `id_artist` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `cart`
--

DROP TABLE IF EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
  `CartId` varchar(30) NOT NULL,
  `OeuvreId` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `NomOeuvre` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `ID_Cat` int(11) NOT NULL AUTO_INCREMENT,
  `Type` varchar(30) NOT NULL,
  `Description` text NOT NULL,
  `NomCat` varchar(40) NOT NULL,
  PRIMARY KEY (`ID_Cat`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `event`
--

DROP TABLE IF EXISTS `event`;
CREATE TABLE IF NOT EXISTS `event` (
  `code_event` int(11) NOT NULL AUTO_INCREMENT,
  `nom_event` varchar(30) NOT NULL,
  `theme_event` varchar(30) NOT NULL,
  `date_event` date NOT NULL,
  `nb_participant` int(11) NOT NULL,
  `nb_max_part` int(11) NOT NULL,
  `image` varchar(80) NOT NULL,
  `video` varchar(80) NOT NULL,
  `code_espace` int(11) NOT NULL,
  `code_artiste` int(11) NOT NULL,
  PRIMARY KEY (`code_event`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `exposition`
--

DROP TABLE IF EXISTS `exposition`;
CREATE TABLE IF NOT EXISTS `exposition` (
  `code_expo` int(11) NOT NULL AUTO_INCREMENT,
  `nom_expo` varchar(30) NOT NULL,
  `theme_expo` varchar(30) NOT NULL,
  `code_espace` int(11) NOT NULL,
  `code_artiste` int(11) NOT NULL,
  `date_expo` date NOT NULL,
  `nb_participant` int(11) NOT NULL,
  `nb_max_participant` int(11) NOT NULL,
  `code_oeuvre` int(11) NOT NULL,
  PRIMARY KEY (`code_expo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `forum`
--

DROP TABLE IF EXISTS `forum`;
CREATE TABLE IF NOT EXISTS `forum` (
  `forum_id` int(11) NOT NULL,
  `theme` varchar(30) NOT NULL,
  `user_id` int(11) NOT NULL,
  `reponse` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `oeuvre`
--

DROP TABLE IF EXISTS `oeuvre`;
CREATE TABLE IF NOT EXISTS `oeuvre` (
  `ID_Oeuvre` int(11) NOT NULL AUTO_INCREMENT,
  `NomOeuvre` varchar(30) NOT NULL,
  `PrixOeuvre` float NOT NULL,
  `ID_Artiste` int(11) NOT NULL,
  PRIMARY KEY (`ID_Oeuvre`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `oeuvre`
--

INSERT INTO `oeuvre` (`ID_Oeuvre`, `NomOeuvre`, `PrixOeuvre`, `ID_Artiste`) VALUES
(1, 'Statue of Zeleph', 14805.8, 1),
(2, 'existence ', 6200, 1);

-- --------------------------------------------------------

--
-- Structure de la table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `OrderID` int(11) NOT NULL,
  `UserName` varchar(30) NOT NULL,
  `DueAmount` float NOT NULL,
  `InnoNumber` int(11) NOT NULL,
  `TotalQty` int(11) NOT NULL,
  `OrderDate` varchar(70) NOT NULL,
  `Status` varchar(30) NOT NULL,
  `AddressId` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `orders`
--

INSERT INTO `orders` (`OrderID`, `UserName`, `DueAmount`, `InnoNumber`, `TotalQty`, `OrderDate`, `Status`, `AddressId`) VALUES
(3381, 'youssef', 35810, 6454019, 3, 'Thu, 4 Mar 2021 14:09:33 +0100', 'confirmed', 1),
(4779, 'youssef', 6200, 3278678, 1, 'Thu, 4 Mar 2021 14:10:05 +0100', 'confirmed', 1),
(3124, 'youssef', 29610, 6713417, 2, 'Thu, 4 Mar 2021 14:14:05 +0100', 'cancelled', 1),
(7933, 'youssef', 29610, 7677311, 2, 'Thu, 4 Mar 2021 17:24:37 +0100', 'confirmed', 1),
(2622, 'youssef', 6200, 7100159, 1, 'Thu, 4 Mar 2021 17:44:04 +0100', 'confirmed', 1);

-- --------------------------------------------------------

--
-- Structure de la table `pending_orders`
--

DROP TABLE IF EXISTS `pending_orders`;
CREATE TABLE IF NOT EXISTS `pending_orders` (
  `OrderID` int(11) NOT NULL,
  `UserName` varchar(30) DEFAULT NULL,
  `InnoNumber` int(11) DEFAULT NULL,
  `OeuvreID` int(11) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Status` varchar(30) DEFAULT NULL,
  `AddressID` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pending_orders`
--

INSERT INTO `pending_orders` (`OrderID`, `UserName`, `InnoNumber`, `OeuvreID`, `Quantity`, `Status`, `AddressID`) VALUES
(3381, 'youssef', 6454019, 1, 2, 'confirmed', 1),
(3381, 'youssef', 6454019, 2, 1, 'confirmed', 1),
(4779, 'youssef', 3278678, 2, 1, 'confirmed', 1),
(3124, 'youssef', 6713417, 1, 2, 'cancelled', 1),
(7933, 'youssef', 7677311, 1, 2, 'confirmed', 1),
(2622, 'youssef', 7100159, 2, 1, 'confirmed', 1);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `code_reservation` int(11) NOT NULL AUTO_INCREMENT,
  `id_client` int(11) NOT NULL,
  `nb_place` int(11) NOT NULL,
  `code_event` int(11) NOT NULL,
  PRIMARY KEY (`code_reservation`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reservation_expo`
--

DROP TABLE IF EXISTS `reservation_expo`;
CREATE TABLE IF NOT EXISTS `reservation_expo` (
  `code_reservationE` int(11) NOT NULL AUTO_INCREMENT,
  `id_client` int(11) NOT NULL,
  `nb_placeE` int(11) NOT NULL,
  `code_expo` int(11) NOT NULL,
  PRIMARY KEY (`code_reservationE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `datenaissance` date NOT NULL,
  `ville` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `numero` int(11) NOT NULL,
  `image` varchar(80) NOT NULL,
  `role` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
