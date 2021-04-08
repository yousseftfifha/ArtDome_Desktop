-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 08 avr. 2021 à 19:23
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
  `Title` varchar(100) NOT NULL DEFAULT ',',
  `Categorie` int(11) NOT NULL,
  `DateOfPub` date NOT NULL,
  `Image` longtext NOT NULL,
  `Description` longtext NOT NULL,
  `Publisher` varchar(40) DEFAULT NULL,
  `idBlog` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idBlog`),
  UNIQUE KEY `blog_titres_uindex` (`Title`),
  KEY `fk_categorie` (`Categorie`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `cart`
--

DROP TABLE IF EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
  `id_user` int(11) NOT NULL,
  `OeuvreId` int(11) NOT NULL,
  `NomOeuvre` varchar(30) DEFAULT NULL,
  `Quantity` int(11) NOT NULL,
  `IDcart` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`IDcart`),
  KEY `fk_cart` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `DateCat` date DEFAULT NULL,
  `NbreOeuvre` int(11) DEFAULT '0',
  PRIMARY KEY (`ID_Cat`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`ID_Cat`, `Type`, `Description`, `NomCat`, `DateCat`, `NbreOeuvre`) VALUES
(1, 'tableau', 'tableau', ' tableau', '2021-03-02', 3),
(2, 'sculture', 'sculture', 'sculture', '2021-03-11', 3),
(9, 'antiquite', 'antiquite', 'antiquite', '2021-04-17', 1);

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `id_comment` int(11) NOT NULL,
  `text` text NOT NULL,
  `CreatedAt` date NOT NULL,
  `UpdatedAt` date NOT NULL,
  `Id_User` int(11) NOT NULL,
  `id_blog` int(11) NOT NULL,
  PRIMARY KEY (`id_comment`),
  KEY `fk_iduser` (`Id_User`),
  KEY `fk_idblog` (`id_blog`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `endroit`
--

DROP TABLE IF EXISTS `endroit`;
CREATE TABLE IF NOT EXISTS `endroit` (
  `id_endroit` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  `taille` int(11) NOT NULL,
  `prix_jour` int(11) NOT NULL,
  `nbrch` int(11) NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `disponibilite` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_endroit`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `endroit`
--

INSERT INTO `endroit` (`id_endroit`, `type`, `taille`, `prix_jour`, `nbrch`, `location`, `disponibilite`) VALUES
(10, 'espace', 50, 80000, 4, 'tunis', 'disponible'),
(12, 'manoir', 7, 400, 4, 'lac', 'disponible'),
(13, 'aaa', 4, 4000, 7, 'malarena', 'disponible'),
(14, 'faf', 5, 700, 7, 'Champ de Mars, 5 Avenue Anatole France, 75007 Paris, France', 'disponible'),
(15, 'aaa', 9, 400, 8, 'Cebalat, Tunisia', 'disponible'),
(16, 'faf', 8, 400, 4, 'Cebalat, Tunisia', 'disponible');

-- --------------------------------------------------------

--
-- Structure de la table `event`
--

DROP TABLE IF EXISTS `event`;
CREATE TABLE IF NOT EXISTS `event` (
  `code_event` int(11) NOT NULL AUTO_INCREMENT,
  `nom_event` varchar(30) NOT NULL,
  `theme_event` varchar(30) NOT NULL,
  `etat` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `nb_max_part` int(11) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `video` varchar(255) DEFAULT NULL,
  `code_espace` int(11) DEFAULT NULL,
  `code_artiste` int(11) DEFAULT NULL,
  PRIMARY KEY (`code_event`),
  KEY `fk_espace` (`code_espace`),
  KEY `fk_artiste` (`code_artiste`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

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
  `nb_max_participant` int(11) NOT NULL,
  PRIMARY KEY (`code_expo`),
  KEY `fk_idespace` (`code_espace`),
  KEY `fk_idartiste` (`code_artiste`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `notification`
--

DROP TABLE IF EXISTS `notification`;
CREATE TABLE IF NOT EXISTS `notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_user_2` (`id_user`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `DateOeuvre` date DEFAULT NULL,
  `ImageOeuvre` varchar(255) NOT NULL,
  `NomCat` varchar(50) DEFAULT NULL,
  `EmailArtiste` varchar(255) DEFAULT NULL,
  `code_exposition` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_Oeuvre`),
  KEY `fk_id` (`ID_Artiste`),
  KEY `fk_exposition` (`code_exposition`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `OrderID` int(11) NOT NULL,
  `IDUser` int(11) NOT NULL,
  `DueAmount` float NOT NULL,
  `InnoNumber` int(11) NOT NULL,
  `TotalQty` int(11) NOT NULL,
  `OrderDate` varchar(70) NOT NULL,
  `Status` varchar(30) NOT NULL,
  PRIMARY KEY (`OrderID`),
  KEY `fk_u` (`IDUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `pending_orders`
--

DROP TABLE IF EXISTS `pending_orders`;
CREATE TABLE IF NOT EXISTS `pending_orders` (
  `OrderID` int(11) NOT NULL,
  `IDUser` int(11) DEFAULT NULL,
  `InnoNumber` int(11) DEFAULT NULL,
  `OeuvreID` int(11) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Status` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`OrderID`),
  KEY `fk_us` (`IDUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id_reservation` int(10) NOT NULL AUTO_INCREMENT,
  `idclient` int(11) NOT NULL,
  `matricule` int(10) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `date_retour` varchar(45) DEFAULT NULL,
  `Cautionnement` int(11) NOT NULL,
  `prix_total` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_reservation`),
  KEY `_idx` (`idclient`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id_reservation`, `idclient`, `matricule`, `date_debut`, `date_fin`, `date_retour`, `Cautionnement`, `prix_total`) VALUES
(29, 0, 9, '2021-03-20', '2021-03-23', '2021-03-23', 150, '30'),
(30, 0, 9, '2021-03-20', '2021-03-28', '2021-03-28', 150, '80'),
(31, 3, 10, '2021-03-28', '2021-03-31', '2021-03-31', 20, '300'),
(32, 3, 12, '2021-03-11', '2021-03-19', '2021-03-19', 15, '80'),
(33, 3, 13, '2021-03-19', '2021-03-27', '2021-03-27', 15, '0'),
(34, 0, 14, '2021-03-31', '2021-04-11', '2021-04-11', 200, '0'),
(36, 0, 17, '2021-04-01', '2021-04-02', '2021-04-02', 4000, '0'),
(37, 2, 9, '2021-04-22', '2021-04-07', '2021-04-07', 400, '0'),
(38, 0, 80, '2021-04-02', '2021-04-16', '2021-04-16', 200, '0');

-- --------------------------------------------------------

--
-- Structure de la table `reservationevent`
--

DROP TABLE IF EXISTS `reservationevent`;
CREATE TABLE IF NOT EXISTS `reservationevent` (
  `code_reservation` int(11) NOT NULL AUTO_INCREMENT,
  `code_client` int(11) DEFAULT NULL,
  `nb_place` int(11) NOT NULL,
  `code_event` int(11) NOT NULL,
  PRIMARY KEY (`code_reservation`),
  KEY `fk_event` (`code_event`),
  KEY `fk_client` (`code_client`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reservation_expo`
--

DROP TABLE IF EXISTS `reservation_expo`;
CREATE TABLE IF NOT EXISTS `reservation_expo` (
  `code_reservationE` int(11) NOT NULL AUTO_INCREMENT,
  `code_expo` int(11) NOT NULL,
  `code_client` int(11) DEFAULT NULL,
  `nb_place` int(11) DEFAULT NULL,
  PRIMARY KEY (`code_reservationE`),
  KEY `fk_expo` (`code_expo`),
  KEY `fk_clients` (`code_client`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

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
  `image` varchar(80) DEFAULT NULL,
  `role` varchar(30) DEFAULT 'user',
  `mdp` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`ID`, `nom`, `prenom`, `datenaissance`, `ville`, `email`, `numero`, `image`, `role`, `mdp`) VALUES
(0, 'tfifha', 'tfifha', '2000-02-23', 'ezzahra', 'youssef.tfifha@esprit.tn', 20245989, '<null>', 'user', 'ww'),
(2, 'feki', 'mehdi', '1999-03-24', 'lac', 'mehdi.feki@esprit.tn', 20200000, '<null>', 'admin', 'aa'),
(9, 'charf', 'hbib', '2021-04-16', 'lac', 'youssef.tfifha@esprit.tn', 20245989, NULL, 'artiste', 'ww'),
(13, 'mehdi', 'mehdi', '2021-04-16', 'malarenn', 'youssef.tfifha@esprit.tn', 20245989, NULL, 'user', 'ww');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `blog`
--
ALTER TABLE `blog`
  ADD CONSTRAINT `fk_categorie` FOREIGN KEY (`Categorie`) REFERENCES `categorie` (`ID_Cat`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `fk_cart` FOREIGN KEY (`id_user`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `fk_idblog` FOREIGN KEY (`id_blog`) REFERENCES `blog` (`idBlog`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_iduser` FOREIGN KEY (`Id_User`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `fk_artiste` FOREIGN KEY (`code_artiste`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_espace` FOREIGN KEY (`code_espace`) REFERENCES `endroit` (`id_endroit`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `exposition`
--
ALTER TABLE `exposition`
  ADD CONSTRAINT `fk_idartiste` FOREIGN KEY (`code_artiste`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_idespace` FOREIGN KEY (`code_espace`) REFERENCES `endroit` (`id_endroit`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`ID`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `oeuvre`
--
ALTER TABLE `oeuvre`
  ADD CONSTRAINT `fk_exposition` FOREIGN KEY (`code_exposition`) REFERENCES `exposition` (`code_expo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id` FOREIGN KEY (`ID_Artiste`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_u` FOREIGN KEY (`IDUser`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `pending_orders`
--
ALTER TABLE `pending_orders`
  ADD CONSTRAINT `fk_order` FOREIGN KEY (`OrderID`) REFERENCES `orders` (`OrderID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_us` FOREIGN KEY (`IDUser`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reservationevent`
--
ALTER TABLE `reservationevent`
  ADD CONSTRAINT `fk_client` FOREIGN KEY (`code_client`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_event` FOREIGN KEY (`code_event`) REFERENCES `event` (`code_event`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reservation_expo`
--
ALTER TABLE `reservation_expo`
  ADD CONSTRAINT `fk_clients` FOREIGN KEY (`code_client`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_expo` FOREIGN KEY (`code_expo`) REFERENCES `exposition` (`code_expo`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
