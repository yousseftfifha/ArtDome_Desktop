-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 09 avr. 2021 à 16:20
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
  `Title` varchar(100) NOT NULL DEFAULT ',',
  `Categorie` int(11) NOT NULL,
  `DateOfPub` date NOT NULL,
  `Image` longtext NOT NULL,
  `Description` longtext NOT NULL,
  `Publisher` varchar(40) DEFAULT NULL,
  `idBlog` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `cart`
--

CREATE TABLE `cart` (
  `id_user` int(11) NOT NULL,
  `OeuvreId` int(11) NOT NULL,
  `NomOeuvre` varchar(30) DEFAULT NULL,
  `Quantity` int(11) NOT NULL,
  `IDcart` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `ID_Cat` int(11) NOT NULL,
  `Type` varchar(30) NOT NULL,
  `Description` text NOT NULL,
  `NomCat` varchar(40) NOT NULL,
  `DateCat` date DEFAULT NULL,
  `NbreOeuvre` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `commentaire` (
  `id_comment` int(11) NOT NULL,
  `text` text NOT NULL,
  `CreatedAt` date NOT NULL,
  `UpdatedAt` date NOT NULL,
  `Id_User` int(11) NOT NULL,
  `id_blog` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `endroit`
--

CREATE TABLE `endroit` (
  `id_endroit` int(11) NOT NULL,
  `type` varchar(30) NOT NULL,
  `taille` int(11) NOT NULL,
  `prix_jour` int(11) NOT NULL,
  `nbrch` int(11) NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `disponibilite` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `event` (
  `code_event` int(11) NOT NULL,
  `nom_event` varchar(30) NOT NULL,
  `theme_event` varchar(30) NOT NULL,
  `etat` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `nb_max_part` int(11) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `video` varchar(255) DEFAULT NULL,
  `code_espace` int(11) DEFAULT NULL,
  `code_artiste` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `nb_max_participant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `notification`
--

CREATE TABLE `notification` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `oeuvre`
--

CREATE TABLE `oeuvre` (
  `ID_Oeuvre` int(11) NOT NULL,
  `NomOeuvre` varchar(30) NOT NULL,
  `PrixOeuvre` float NOT NULL,
  `ID_Artiste` int(11) NOT NULL,
  `DateOeuvre` date DEFAULT NULL,
  `ImageOeuvre` varchar(255) NOT NULL,
  `NomCat` varchar(50) DEFAULT NULL,
  `EmailArtiste` varchar(255) DEFAULT NULL,
  `code_exposition` int(11) DEFAULT NULL,
  `ID_Cat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `orders`
--

CREATE TABLE `orders` (
  `OrderID` int(11) NOT NULL,
  `IDUser` int(11) NOT NULL,
  `DueAmount` float NOT NULL,
  `InnoNumber` int(11) NOT NULL,
  `TotalQty` int(11) NOT NULL,
  `OrderDate` varchar(70) NOT NULL,
  `Status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `pending_orders`
--

CREATE TABLE `pending_orders` (
  `OrderID` int(11) NOT NULL,
  `IDUser` int(11) DEFAULT NULL,
  `InnoNumber` int(11) DEFAULT NULL,
  `OeuvreID` int(11) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Status` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id_reservation` int(10) NOT NULL,
  `idclient` int(11) NOT NULL,
  `matricule` int(10) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `date_retour` varchar(45) DEFAULT NULL,
  `Cautionnement` int(11) NOT NULL,
  `prix_total` varchar(45) DEFAULT NULL,
  `id_endroit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id_reservation`, `idclient`, `matricule`, `date_debut`, `date_fin`, `date_retour`, `Cautionnement`, `prix_total`, `id_endroit`) VALUES
(29, 0, 9, '2021-03-20', '2021-03-23', '2021-03-23', 150, '30', 0),
(30, 0, 9, '2021-03-20', '2021-03-28', '2021-03-28', 150, '80', 0),
(31, 3, 10, '2021-03-28', '2021-03-31', '2021-03-31', 20, '300', 0),
(32, 3, 12, '2021-03-11', '2021-03-19', '2021-03-19', 15, '80', 0),
(33, 3, 13, '2021-03-19', '2021-03-27', '2021-03-27', 15, '0', 0),
(34, 0, 14, '2021-03-31', '2021-04-11', '2021-04-11', 200, '0', 0),
(36, 0, 17, '2021-04-01', '2021-04-02', '2021-04-02', 4000, '0', 0),
(37, 2, 9, '2021-04-22', '2021-04-07', '2021-04-07', 400, '0', 0),
(38, 0, 80, '2021-04-02', '2021-04-16', '2021-04-16', 200, '0', 0);

-- --------------------------------------------------------

--
-- Structure de la table `reservationevent`
--

CREATE TABLE `reservationevent` (
  `code_reservation` int(11) NOT NULL,
  `code_client` int(11) DEFAULT NULL,
  `nb_place` int(11) NOT NULL,
  `code_event` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reservation_expo`
--

CREATE TABLE `reservation_expo` (
  `code_reservationE` int(11) NOT NULL,
  `code_expo` int(11) NOT NULL,
  `code_client` int(11) DEFAULT NULL,
  `nb_place` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `image` varchar(80) DEFAULT NULL,
  `role` varchar(30) DEFAULT 'user',
  `mdp` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`ID`, `nom`, `prenom`, `datenaissance`, `ville`, `email`, `numero`, `image`, `role`, `mdp`) VALUES
(0, 'tfifha', 'tfifha', '2000-02-23', 'ezzahra', 'youssef.tfifha@esprit.tn', 20245989, '<null>', 'user', 'ww'),
(2, 'feki', 'mehdi', '1999-03-24', 'lac', 'mehdi.feki@esprit.tn', 20200000, '<null>', 'admin', 'aa'),
(9, 'charf', 'hbib', '2021-04-16', 'lac', 'youssef.tfifha@esprit.tn', 20245989, NULL, 'artiste', 'ww'),
(13, 'mehdi', 'mehdi', '2021-04-16', 'malarenn', 'youssef.tfifha@esprit.tn', 20245989, NULL, 'user', 'ww');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`idBlog`),
  ADD UNIQUE KEY `blog_titres_uindex` (`Title`),
  ADD KEY `fk_categorie` (`Categorie`);

--
-- Index pour la table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`IDcart`),
  ADD KEY `fk_cart` (`id_user`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`ID_Cat`);

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`id_comment`),
  ADD KEY `fk_iduser` (`Id_User`),
  ADD KEY `fk_idblog` (`id_blog`);

--
-- Index pour la table `endroit`
--
ALTER TABLE `endroit`
  ADD PRIMARY KEY (`id_endroit`);

--
-- Index pour la table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`code_event`),
  ADD KEY `fk_espace` (`code_espace`),
  ADD KEY `fk_artiste` (`code_artiste`);

--
-- Index pour la table `exposition`
--
ALTER TABLE `exposition`
  ADD PRIMARY KEY (`code_expo`),
  ADD KEY `fk_idespace` (`code_espace`),
  ADD KEY `fk_idartiste` (`code_artiste`);

--
-- Index pour la table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_user_2` (`id_user`),
  ADD KEY `id_user` (`id_user`);

--
-- Index pour la table `oeuvre`
--
ALTER TABLE `oeuvre`
  ADD PRIMARY KEY (`ID_Oeuvre`),
  ADD KEY `fk_id` (`ID_Artiste`),
  ADD KEY `fk_exposition` (`code_exposition`),
  ADD KEY `fk_cat` (`ID_Cat`);

--
-- Index pour la table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`OrderID`),
  ADD KEY `fk_u` (`IDUser`);

--
-- Index pour la table `pending_orders`
--
ALTER TABLE `pending_orders`
  ADD PRIMARY KEY (`OrderID`),
  ADD KEY `fk_us` (`IDUser`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id_reservation`),
  ADD KEY `_idx` (`idclient`);

--
-- Index pour la table `reservationevent`
--
ALTER TABLE `reservationevent`
  ADD PRIMARY KEY (`code_reservation`),
  ADD KEY `fk_event` (`code_event`),
  ADD KEY `fk_client` (`code_client`);

--
-- Index pour la table `reservation_expo`
--
ALTER TABLE `reservation_expo`
  ADD PRIMARY KEY (`code_reservationE`),
  ADD KEY `fk_expo` (`code_expo`),
  ADD KEY `fk_clients` (`code_client`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `blog`
--
ALTER TABLE `blog`
  MODIFY `idBlog` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `cart`
--
ALTER TABLE `cart`
  MODIFY `IDcart` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `ID_Cat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `endroit`
--
ALTER TABLE `endroit`
  MODIFY `id_endroit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `event`
--
ALTER TABLE `event`
  MODIFY `code_event` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT pour la table `exposition`
--
ALTER TABLE `exposition`
  MODIFY `code_expo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `notification`
--
ALTER TABLE `notification`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `oeuvre`
--
ALTER TABLE `oeuvre`
  MODIFY `ID_Oeuvre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id_reservation` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT pour la table `reservationevent`
--
ALTER TABLE `reservationevent`
  MODIFY `code_reservation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT pour la table `reservation_expo`
--
ALTER TABLE `reservation_expo`
  MODIFY `code_reservationE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

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
  ADD CONSTRAINT `fk_cat` FOREIGN KEY (`ID_Cat`) REFERENCES `categorie` (`ID_Cat`) ON DELETE CASCADE ON UPDATE CASCADE,
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
