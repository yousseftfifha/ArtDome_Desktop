-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 28 fév. 2021 à 13:42
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
  `CartId` int(11) NOT NULL,
  `OeuvreId` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cart`
--

INSERT INTO `cart` (`CartId`, `OeuvreId`, `Quantity`) VALUES
(0, 1, 7),
(0, 0, 8),
(0, 0, 7),
(0, 1, 6),
(0, 0, 6),
(0, 1, 5),
(0, 0, 5),
(0, 1, 4),
(0, 0, 4),
(0, 1, 3),
(0, 0, 3),
(0, 1, 2),
(0, 0, 2),
(0, 1, 1);

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `OrderID` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(30) NOT NULL,
  `DueAmount` float NOT NULL,
  `InnoNumber` int(11) NOT NULL,
  `TotalQty` int(11) NOT NULL,
  `OrderDate` varchar(70) NOT NULL,
  `Status` int(11) NOT NULL,
  `AddressId` int(11) NOT NULL,
  PRIMARY KEY (`OrderID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `pending_orders`
--

DROP TABLE IF EXISTS `pending_orders`;
CREATE TABLE IF NOT EXISTS `pending_orders` (
  `OrderID` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(30) DEFAULT NULL,
  `InnoNumber` int(11) DEFAULT NULL,
  `OeuvreID` int(11) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Status` varchar(30) DEFAULT NULL,
  `AddressID` int(11) DEFAULT NULL,
  PRIMARY KEY (`OrderID`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pending_orders`
--

INSERT INTO `pending_orders` (`OrderID`, `UserName`, `InnoNumber`, `OeuvreID`, `Quantity`, `Status`, `AddressID`) VALUES
(1, 'youssef', 8614832, 1, 4, 'pending', 1),
(2, 'youssef', 8614832, 1, 1, 'pending', 1),
(3, 'youssef', 8614832, 1, 2, 'pending', 1),
(4, 'youssef', 8614832, 1, 5, 'pending', 1),
(5, 'youssef', 8614832, 1, 3, 'pending', 1),
(6, 'youssef', 9691978, 1, 6, 'pending', 1),
(7, 'youssef', 9691978, 1, 1, 'pending', 1),
(8, 'youssef', 9691978, 1, 3, 'pending', 1),
(9, 'youssef', 9691978, 1, 2, 'pending', 1),
(10, 'youssef', 9691978, 1, 5, 'pending', 1),
(11, 'youssef', 9691978, 1, 4, 'pending', 1),
(12, 'youssef', 1963572, 1, 3, 'pending', 1),
(13, 'youssef', 1963572, 1, 5, 'pending', 1),
(14, 'youssef', 1963572, 1, 4, 'pending', 1),
(15, 'youssef', 1963572, 1, 2, 'pending', 1),
(16, 'youssef', 1963572, 1, 7, 'pending', 1),
(17, 'youssef', 1963572, 1, 6, 'pending', 1),
(18, 'youssef', 1963572, 1, 1, 'pending', 1);

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
