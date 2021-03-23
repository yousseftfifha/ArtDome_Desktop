-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 04 mars 2021 à 23:33
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 7.4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `artdome`
--

-- --------------------------------------------------------

--
-- Structure de la table `blog`
--

CREATE TABLE `blog` (
  `blog_id` int(11) NOT NULL,
  `date_post` date NOT NULL,
  `id_artist` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `cart`
--

CREATE TABLE `cart` (
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

CREATE TABLE `categorie` (
  `ID_Cat` int(11) NOT NULL,
  `Type` varchar(30) NOT NULL,
  `Description` text NOT NULL,
  `NomCat` varchar(40) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `event`
--

CREATE TABLE `event` (
  `code_event` int(11) NOT NULL,
  `nom_event` varchar(30) NOT NULL,
  `theme_event` varchar(30) NOT NULL,
  `etat` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `nb_participant` int(11) DEFAULT NULL,
  `nb_max_part` int(11) NOT NULL,
  `image` varchar(80) NOT NULL,
  `video` varchar(80) NOT NULL,
  `code_espace` int(11) DEFAULT NULL,
  `code_artiste` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `event`
--

INSERT INTO `event` (`code_event`, `nom_event`, `theme_event`, `etat`, `date`, `nb_participant`, `nb_max_part`, `image`, `video`, `code_espace`, `code_artiste`) VALUES
(11, 'colorMe', 'divertissement', 'Réel', '2021-03-13', 22, 10, '', '', 3, NULL),
(12, 'all i can see', 'art show', 'En ligne', '2021-03-26', NULL, 3, '', '', 3, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `exposition`
--

CREATE TABLE `exposition` (
  `code_expo` int(11) NOT NULL,
  `nom_expo` varchar(30) NOT NULL,
  `theme_expo` varchar(30) NOT NULL,
  `code_espace` int(11) NOT NULL,
  `code_artiste` int(11) NOT NULL,
  `date_expo` date NOT NULL,
  `nb_participant` int(11) NOT NULL,
  `nb_max_participant` int(11) NOT NULL,
  `code_oeuvre` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `forum`
--

CREATE TABLE `forum` (
  `forum_id` int(11) NOT NULL,
  `theme` varchar(30) NOT NULL,
  `user_id` int(11) NOT NULL,
  `reponse` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `oeuvre`
--

CREATE TABLE `oeuvre` (
  `ID_Oeuvre` int(11) NOT NULL,
  `NomOeuvre` varchar(30) NOT NULL,
  `PrixOeuvre` float NOT NULL,
  `ID_Artiste` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `orders`
--

CREATE TABLE `orders` (
  `OrderID` int(11) NOT NULL,
  `UserName` varchar(30) NOT NULL,
  `DueAmount` float NOT NULL,
  `InnoNumber` int(11) NOT NULL,
  `TotalQty` int(11) NOT NULL,
  `OrderDate` varchar(70) NOT NULL,
  `Status` int(11) NOT NULL,
  `AddressId` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `pending_orders`
--

CREATE TABLE `pending_orders` (
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

CREATE TABLE `reservation` (
  `code_reservation` int(11) NOT NULL,
  `code_client` int(11) DEFAULT NULL,
  `nom_client` varchar(50) DEFAULT NULL,
  `prenom_client` varchar(50) DEFAULT NULL,
  `telephone` int(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `nb_place` int(11) NOT NULL,
  `code_event` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`code_reservation`, `code_client`, `nom_client`, `prenom_client`, `telephone`, `email`, `nb_place`, `code_event`) VALUES
(24, 0, 'ghada', 'slimene', 23232323, 'ghada@gmail.com', 3, 16),
(28, 0, 'ghada', 'ghada', 2222, 'ggggg', 6, 12);

-- --------------------------------------------------------

--
-- Structure de la table `reservation_expo`
--

CREATE TABLE `reservation_expo` (
  `code_reservationE` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `nb_placeE` int(11) NOT NULL,
  `code_expo` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `datenaissance` date NOT NULL,
  `ville` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `numero` int(11) NOT NULL,
  `image` varchar(80) NOT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`ID_Cat`);

--
-- Index pour la table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`code_event`);

--
-- Index pour la table `exposition`
--
ALTER TABLE `exposition`
  ADD PRIMARY KEY (`code_expo`);

--
-- Index pour la table `oeuvre`
--
ALTER TABLE `oeuvre`
  ADD PRIMARY KEY (`ID_Oeuvre`);

--
-- Index pour la table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`OrderID`);

--
-- Index pour la table `pending_orders`
--
ALTER TABLE `pending_orders`
  ADD PRIMARY KEY (`OrderID`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`code_reservation`);

--
-- Index pour la table `reservation_expo`
--
ALTER TABLE `reservation_expo`
  ADD PRIMARY KEY (`code_reservationE`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `ID_Cat` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `event`
--
ALTER TABLE `event`
  MODIFY `code_event` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `exposition`
--
ALTER TABLE `exposition`
  MODIFY `code_expo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `oeuvre`
--
ALTER TABLE `oeuvre`
  MODIFY `ID_Oeuvre` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `orders`
--
ALTER TABLE `orders`
  MODIFY `OrderID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pending_orders`
--
ALTER TABLE `pending_orders`
  MODIFY `OrderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `code_reservation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT pour la table `reservation_expo`
--
ALTER TABLE `reservation_expo`
  MODIFY `code_reservationE` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
