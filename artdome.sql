-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 30 mars 2021 à 20:52
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
  `Categorie` varchar(30) NOT NULL,
  `DateOfPub` date NOT NULL,
  `Image` longtext NOT NULL,
  `Description` longtext NOT NULL,
  `Publisher` varchar(40) DEFAULT NULL,
  UNIQUE KEY `blog_titres_uindex` (`Title`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `blog`
--

INSERT INTO `blog` (`Title`, `Categorie`, `DateOfPub`, `Image`, `Description`, `Publisher`) VALUES
('Art Restoration Disasters (and Miracles!)', 'Painting', '2021-03-24', 'blog1.jpg', 'Stories of artworks that were brought back to life (sort of) and tips on what to do if your artwork is damaged. \r\nArt restoration has never been a particularly trendy topic, but some recent fails have been so epic in nature that they immediately went viral. We’ve all seen the memes of disastrous attempts to restore historic (often religious) works of art — Ecce Homo and Immaculate Conception being perhaps the two most famous — which resulted in Spain deciding to overhaul its art restoration laws in 2020. But, there have been some other truly mind-boggling stories of incredibly damaged artworks, as well as art restorations gone horribly (and, sometimes, hilariously) awry. \r\n\r\nDid you hear the one about the Christo pieces that were unwrapped in customs? True story. Or that time the Las Vegas casino owner and billionaire Steve Wynn accidentally put his elbow through a Picasso worth over $130 million? Or the “starving artist” who ate the banana duct taped to the wall (also known as Comedian by Maurizio Cattelan) at Art Basel Miami in 2019? That last one had an unusually happy ending: the gallery which exhibited the work, Emmanuel Perrotin, ultimately declined to press charges against the artist, who said he did it because he was “hungry” and became an instant internet sensation. \r\nWho’s Afraid of Art Restoration?\r\nThe excellent podcast 99% Invisible has a delightfully debaucherous episode entitled, “The Many Deaths of a Painting,” about the artwork Who’s Afraid of Red, Yellow and Blue III, by American post-war artist Barnett Newman. The painting, a minimalist composition of only three primary colors — but predominantly red — was so upsetting to visitors at the Stedelijk Museum in Amsterdam (which acquired the work in 1969) that several recounted becoming physically ill and/or enraged at the mere sight of it. \r\nIn the 1980’s, while the painting was on view, a 30 year-old struggling artist named Gerard Jan van Bladeren attacked it with a box-cutter, slashing the center of the canvas. According to reports, “When the slashes were added all up together, they measured nearly fifty feet long.” But, this is only the beginning of the story, as the process to restore the painting ended up being just as controversial as the initial vandalism. \r\n\r\nAll told, the restoration took four years and ultimately cost the museum more than $1 million, drawing them into a lengthy defamation lawsuit with the work’s conservator, Daniel Goldreyer. When the Stedelijk initially hired Goldreyer, he assured the museum that he could repair the painting “within 98% accuracy.” However, when the work was finally revealed post-restoration, it seemed different somehow — the paint appeared flatter, more opaque and without the “shimmering quality to the red that gave it a sense of depth” before the attack.  \r\n\r\nLong story short, the Stedelijk had the painting forensically investigated and were told that the restorer had simply used a basic paint roller to cover the entire surface of the canvas with matte house paint, a claim he vehemently denied. Still, the painting was noticeably different and yet, it still had the same effect.\r\n\r\nIn 1997, eleven years after his initial assault, van Bladeren returned to the Stedelijk, intent on slashing the work AGAIN. Fortunately, the painting was not on view. Unfortunately, another Newman painting was on view and van Bladeren handily took his box-cutter to that work instead. (The Dutch courts ultimately declared him as psychiatrically unfit and he was sent to a mental institution.) Newman’s painting Who’s Afraid of Red, Yellow and Blue III has since been exhibited by the Stedelijk without incident, for now. ', 'tfifha youssef'),
('Artwork Archive Collector Spotlight:', 'Rare antiquity', '2021-03-25', 'blog3.jpg', 'Artwork Archive collector Yoram Roth on what drives his passion for art and life. \nMeet Artwork Archive collector Yoram Roth. Yoram is a creative entrepreneur, investor, artist, father, and art collector. Born in Berlin, Yoram studied art under acclaimed photographer Larry Fink at Fordham University, at a time when New York City was still gritty, raw, and full of potential. \n\nThe city left a lasting impression and Yoram’s been chasing down that creative energy ever since. After founding a techno music label in Berlin (D’Vision) in the 90s, and working in Los Angeles as an investor and hotelier, Yoram threw himself into his own photography practice. He’s since exhibited with esteemed galleries such as Camera Work, published three books, and sold out shows in Milan, Paris and elsewhere. \n\nCurrently, Yoram is taking a sabbatical from his art practice and focusing on his other creative enterprises, many of which are fundamentally artistic and cultural in nature. This includes NeueHouse, a private work and social space that fosters creative connections, as well as Yoram’s most ambitious project to date, “the world’s largest museum for photography” ?– Fotografiska. \n\nNeueHouse and Fotografiska are both part of the recently-formed CultureWorks, a development platform for culture, experience, and hospitality brands. Fotografiska currently has spaces in New York, Stockholm, Tallinn (Estonia), and plans to open in Berlin in 2022 (in an iconic building that was previously a notorious artist squat, formerly known as Kunsthaus Tacheles). Fotografiska is a hybrid of sorts ?– part-museum, part-immersive experience, accentuated by carefully curated and seemingly nonstop programming comprised of multiple rotating exhibitions at each location, classes, artist talks & panels, book launches, DJ sets, sound baths, of-the-moment chefs and cuisine, and more. \n\nFotografiska works directly with artists to realize ambitious shows with a high level of cultural crossover. This past year, Fotografiska NY worked with iconic photographer Andres Serrano to mount Infamous, “a visual exploration of the long history of deeply rooted racism in the United States,” according to Fotografiska’s website. The museum is also working with the Black Artist Fund and is currently showing Naima Green’s portraits and video art, which celebrate “Black and POC centered queer histories” (through April 18, 2021 in New York).\n\nWe sat down with Yoram to discuss his background, his creative interests, and how he hopes Fotografiska will impact the cultural landscape. \n\nThe following interview has been edited for length and clarity.', ' Yoram Roth'),
('Ask an Art Appraiser: Heidi Lee Komaromi, AAA', 'Genral', '2021-03-24', 'blog2.jpg', 'Expert fine art appraiser Heidi Lee Komaromi, AAA, weighs in on questions from Artwork Archive\'s collector community.\r\nHeidi Lee Komaromi, AAA, is a certified appraiser and independent curator based in the Hamptons, NY, with two decades of experience in the fine art industry. Over the course of her career, Heidi has acquired and evaluated over three thousand works of contemporary and modern art. In 2002, Heidi founded HLK Art Group, which offers art advising services to select clientele. She works with private individuals, as well as nonprofits and Fortune 500 companies such as UBS, Merrill Lynch, Goldman Sachs, Exxon, A.T. Kearney, and JP Morgan Chase, among many others. Heidi holds a Masters Degree in Modern Art from Christie’s Education and has been a certified member of the Appraisers Association of America (AAA) since 2007. \r\n\r\nHere, Heidi fields questions from Artwork Archive’s collector community and shares her insights regarding all things appraisals. ', 'albert');

-- --------------------------------------------------------

--
-- Structure de la table `cart`
--

DROP TABLE IF EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
  `CartId` varchar(30) NOT NULL,
  `OeuvreId` int(11) NOT NULL,
  `NomOeuvre` varchar(30) DEFAULT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cart`
--

INSERT INTO `cart` (`CartId`, `OeuvreId`, `NomOeuvre`, `Quantity`) VALUES
('youssef.tfifha@esprit.tn', 4, 'staut de marbre', 1),
('youssef.tfifha@esprit.tn', 3, 'mona lisa', 1),
('youssef.tfifha@esprit.tn', 2, 'existence ', 1),
('youssef.tfifha@esprit.tn', 1, 'Statue of Zeleph', 1);

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
  `NbreOeuvre` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_Cat`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`ID_Cat`, `Type`, `Description`, `NomCat`, `DateCat`, `NbreOeuvre`) VALUES
(1, 'tableau', 'blabal', 'tableau', '2021-03-12', NULL),
(2, 'sculture', 'faazfaf', 'sculture', '2021-03-11', NULL);

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
  `location` varchar(30) DEFAULT NULL,
  `disponibilite` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_endroit`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `endroit`
--

INSERT INTO `endroit` (`id_endroit`, `type`, `taille`, `prix_jour`, `nbrch`, `location`, `disponibilite`) VALUES
(9, 'maison', 7, 400, 4, 'fqfq', 'disponible'),
(8, 'jh bjnkn', 10, 10, 10, 'knlk,', 'Non disponible'),
(10, 'ffafaf', 5, 2, 4, 'affa', 'disponible');

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
  `nb_participant` int(11) DEFAULT NULL,
  `nb_max_part` int(11) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `video` varchar(255) DEFAULT NULL,
  `code_espace` int(11) DEFAULT NULL,
  `code_artiste` int(11) DEFAULT NULL,
  PRIMARY KEY (`code_event`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `event`
--

INSERT INTO `event` (`code_event`, `nom_event`, `theme_event`, `etat`, `date`, `nb_participant`, `nb_max_part`, `image`, `video`, `code_espace`, `code_artiste`) VALUES
(11, 'colorMe', 'Launching', 'Digital', '2021-03-13', 22, 10, 'null', 'null', 2, 0),
(23, 'fafa', 'Concert', 'Physique', '2021-03-11', NULL, 19, 'D:\\esprit\\3A\\PiDev\\Quality-Overflow\\ArtDome_Desktop\\src\\GFX\\blog1.jpg', 'C:\\Users\\yotfi\\Downloads\\aa.mp4', 2, NULL);

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
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `exposition`
--

INSERT INTO `exposition` (`code_expo`, `nom_expo`, `theme_expo`, `code_espace`, `code_artiste`, `date_expo`, `nb_participant`, `nb_max_participant`, `code_oeuvre`) VALUES
(3, 'ffafaf', 'peinture', 1, 1, '2021-03-17', 6, 3, 1),
(2, 'fazfa', 'peinture', 0, 0, '2021-03-31', 6, 8, 2);

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
  `DateOeuvre` date DEFAULT NULL,
  `ImageOeuvre` varchar(255) NOT NULL,
  `NomCat` varchar(50) DEFAULT NULL,
  `EmailArtiste` varchar(255) DEFAULT NULL,
  `code_exposition` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_Oeuvre`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `oeuvre`
--

INSERT INTO `oeuvre` (`ID_Oeuvre`, `NomOeuvre`, `PrixOeuvre`, `ID_Artiste`, `DateOeuvre`, `ImageOeuvre`, `NomCat`, `EmailArtiste`, `code_exposition`) VALUES
(1, 'Statue of Zeleph', 14805.8, 1, '2021-03-28', 'samba.jpg', 'sculture', 'youssef.tfifha@esprit.tn', 2),
(2, 'existence ', 6200, 1, '2021-03-25', 'fazaaa.jpg', 'tableau', 'youssef.tfifha@esprit.tn', 2),
(3, 'mona lisa', 87450, 1, '2021-03-10', 'Mona_lisa.jpg', 'tableau', 'youssef.tfifha@esprit.tn', 2),
(4, 'staut de marbre', 65412.5, 1, '2021-03-01', 'sculture.jpg', 'sculture', 'youssef.tfifha@esprit.tn', 2);

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
  `AddressId` int(11) NOT NULL,
  PRIMARY KEY (`OrderID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `orders`
--

INSERT INTO `orders` (`OrderID`, `UserName`, `DueAmount`, `InnoNumber`, `TotalQty`, `OrderDate`, `Status`, `AddressId`) VALUES
(9578, 'youssef.tfifha@esprit.tn', 14805, 1506801, 1, 'Mon, 22 Mar 2021 18:46:25 +0100', 'cancelled', 1),
(3956, 'youssef.tfifha@esprit.tn', 42010, 4401373, 4, 'Mon, 22 Mar 2021 23:13:00 +0100', 'pending', 1),
(2851, 'youssef.tfifha@esprit.tn', 806200, 1566616, 2, 'Tue, 23 Mar 2021 20:04:23 +0100', 'cancelled', 1),
(1510, 'youssef.tfifha@esprit.tn', 1722230, 1025799, 8, 'Tue, 23 Mar 2021 20:06:53 +0100', 'pending', 1),
(4303, 'youssef.tfifha@esprit.tn', 821005, 6519642, 3, 'Tue, 23 Mar 2021 22:00:28 +0100', 'pending', 1),
(9832, 'youssef.tfifha@esprit.tn', 1233120, 6445450, 24, 'Wed, 24 Mar 2021 13:07:52 +0100', 'pending', 1),
(6087, 'youssef.tfifha@esprit.tn', 886417, 8019442, 4, 'Wed, 24 Mar 2021 13:08:39 +0100', 'confirmed', 1),
(3263, 'youssef.tfifha@esprit.tn', 0, 1601715, 0, 'Wed, 24 Mar 2021 13:08:39 +0100', 'pending', 1),
(5174, 'youssef.tfifha@esprit.tn', 1112260, 4724572, 9, 'Thu, 25 Mar 2021 14:28:05 +0100', 'pending', 1),
(9686, 'youssef.tfifha@esprit.tn', 29610, 1355444, 2, 'Sun, 28 Mar 2021 16:56:33 +0100', 'pending', 1),
(9510, 'youssef.tfifha@esprit.tn', 145629, 7461382, 3, 'Sun, 28 Mar 2021 21:27:22 +0100', 'pending', 1),
(1649, 'youssef.tfifha@esprit.tn', 12400, 6343703, 2, 'Mon, 29 Mar 2021 10:32:15 +0100', 'pending', 1),
(3394, 'youssef.tfifha@esprit.tn', 188672, 4212879, 5, 'Mon, 29 Mar 2021 20:20:14 +0100', 'pending', 1),
(3172, 'youssef.tfifha@esprit.tn', 173867, 8856460, 4, 'Mon, 29 Mar 2021 21:10:50 +0100', 'pending', 1),
(7331, 'youssef.tfifha@esprit.tn', 239279, 7497261, 5, 'Tue, 30 Mar 2021 14:27:15 +0100', 'pending', 1),
(9407, 'youssef.tfifha@icloud.com', 239279, 7483671, 5, 'Tue, 30 Mar 2021 15:17:59 +0100', 'pending', 1),
(9762, 'youssef.tfifha@esprit.tn', 14805, 2626394, 1, 'Thu, 18 Mar 2021 16:42:22 +0100', 'confirmed', 1),
(9652, 'youssef.tfifha@esprit.tn', 886417, 2591836, 4, 'Thu, 18 Mar 2021 17:16:24 +0100', 'confirmed', 1),
(2727, 'youssef.tfifha@esprit.tn', 6200, 3822592, 1, 'Thu, 18 Mar 2021 17:20:50 +0100', 'cancelled', 1),
(1410, 'youssef.tfifha@esprit.tn', 151829, 8195799, 4, 'Thu, 18 Mar 2021 17:32:38 +0100', 'cancelled', 1),
(4810, 'youssef.tfifha@esprit.tn', 35810, 7313125, 3, 'Thu, 18 Mar 2021 21:51:34 +0100', 'pending', 1),
(1729, 'youssef.tfifha@esprit.tn', 886417, 8227547, 4, 'Thu, 18 Mar 2021 21:53:12 +0100', 'confirmed', 1),
(8086, 'youssef.tfifha@esprit.tn', 21005, 4573482, 2, 'Mon, 22 Mar 2021 14:22:43 +0100', 'confirmed', 1),
(2633, 'youssef.tfifha@esprit.tn', 886417, 3185079, 4, 'Mon, 22 Mar 2021 17:21:41 +0100', 'cancelled', 1),
(2821, 'youssef.tfifha@esprit.tn', 916027, 7304427, 6, 'Mon, 22 Mar 2021 17:26:25 +0100', 'confirmed', 1),
(8671, 'youssef.tfifha@esprit.tn', 886417, 3062422, 4, 'Mon, 22 Mar 2021 17:28:12 +0100', 'pending', 1),
(2598, 'youssef.tfifha@esprit.tn', 886417, 9671328, 4, 'Mon, 22 Mar 2021 17:32:59 +0100', 'pending', 1);

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
(6087, 'tfifha youssef', 8019442, 1, 1, 'confirmed', 1),
(5174, 'tfifha youssef', 4724572, 1, 2, 'pending', 1),
(5174, 'tfifha youssef', 4724572, 2, 1, 'pending', 1),
(6087, 'tfifha youssef', 8019442, 4, 1, 'confirmed', 1),
(6087, 'tfifha youssef', 8019442, 3, 1, 'confirmed', 1),
(6087, 'tfifha youssef', 8019442, 2, 1, 'confirmed', 1),
(9832, 'tfifha youssef', 6445450, 1, 2, 'pending', 1),
(9832, 'tfifha youssef', 6445450, 4, 2, 'pending', 1),
(9832, 'tfifha youssef', 6445450, 1, 2, 'pending', 1),
(9832, 'tfifha youssef', 6445450, 1, 2, 'pending', 1),
(9832, 'tfifha youssef', 6445450, 1, 2, 'pending', 1),
(9832, 'tfifha youssef', 6445450, 1, 2, 'pending', 1),
(9832, 'tfifha youssef', 6445450, 2, 1, 'pending', 1),
(9832, 'tfifha youssef', 6445450, 3, 1, 'pending', 1),
(1510, 'tfifha youssef', 1025799, 3, 2, 'pending', 1),
(1510, 'tfifha youssef', 1025799, 1, 3, 'pending', 1),
(1510, 'tfifha youssef', 1025799, 2, 2, 'pending', 1),
(1510, 'tfifha youssef', 1025799, 4, 1, 'pending', 1),
(4303, 'tfifha youssef', 6519642, 2, 1, 'pending', 1),
(4303, 'tfifha youssef', 6519642, 1, 1, 'pending', 1),
(4303, 'tfifha youssef', 6519642, 3, 1, 'pending', 1),
(9832, 'tfifha youssef', 6445450, 1, 2, 'pending', 1),
(9832, 'tfifha youssef', 6445450, 1, 2, 'pending', 1),
(9832, 'tfifha youssef', 6445450, 1, 2, 'pending', 1),
(9832, 'tfifha youssef', 6445450, 1, 2, 'pending', 1),
(9832, 'tfifha youssef', 6445450, 1, 2, 'pending', 1),
(9762, 'tfifha youssef', 2626394, 1, 1, 'confirmed', 1),
(9652, 'tfifha youssef', 2591836, 3, 1, 'confirmed', 1),
(9652, 'tfifha youssef', 2591836, 1, 1, 'confirmed', 1),
(9652, 'tfifha youssef', 2591836, 2, 1, 'confirmed', 1),
(9652, 'tfifha youssef', 2591836, 4, 1, 'confirmed', 1),
(2727, 'tfifha youssef', 3822592, 2, 1, 'cancelled', 1),
(1410, 'tfifha youssef', 8195799, 1, 1, 'cancelled', 1),
(1410, 'tfifha youssef', 8195799, 4, 2, 'cancelled', 1),
(1410, 'tfifha youssef', 8195799, 2, 1, 'cancelled', 1),
(4810, 'tfifha youssef', 7313125, 2, 1, 'pending', 1),
(4810, 'tfifha youssef', 7313125, 1, 2, 'pending', 1),
(1729, 'tfifha youssef', 8227547, 3, 1, 'confirmed', 1),
(1729, 'tfifha youssef', 8227547, 1, 1, 'confirmed', 1),
(1729, 'tfifha youssef', 8227547, 2, 1, 'confirmed', 1),
(1729, 'tfifha youssef', 8227547, 4, 1, 'confirmed', 1),
(8086, 'tfifha youssef', 4573482, 1, 1, 'confirmed', 1),
(8086, 'tfifha youssef', 4573482, 2, 1, 'confirmed', 1),
(2633, 'tfifha youssef', 3185079, 2, 1, 'cancelled', 1),
(2633, 'tfifha youssef', 3185079, 3, 1, 'cancelled', 1),
(2633, 'tfifha youssef', 3185079, 4, 1, 'cancelled', 1),
(2633, 'tfifha youssef', 3185079, 1, 1, 'cancelled', 1),
(2821, 'tfifha youssef', 7304427, 4, 1, 'confirmed', 1),
(2821, 'tfifha youssef', 7304427, 3, 1, 'confirmed', 1),
(2821, 'tfifha youssef', 7304427, 1, 3, 'confirmed', 1),
(2821, 'tfifha youssef', 7304427, 2, 1, 'confirmed', 1),
(8671, 'tfifha youssef', 3062422, 3, 1, 'pending', 1),
(8671, 'tfifha youssef', 3062422, 1, 1, 'pending', 1),
(8671, 'tfifha youssef', 3062422, 4, 1, 'pending', 1),
(8671, 'tfifha youssef', 3062422, 2, 1, 'pending', 1),
(2598, 'tfifha youssef', 9671328, 2, 1, 'pending', 1),
(2598, 'tfifha youssef', 9671328, 3, 1, 'pending', 1),
(2598, 'tfifha youssef', 9671328, 1, 1, 'pending', 1),
(2598, 'tfifha youssef', 9671328, 4, 1, 'pending', 1),
(9578, 'tfifha youssef', 1506801, 1, 1, 'cancelled', 1),
(3956, 'tfifha youssef', 4401373, 2, 2, 'pending', 1),
(3956, 'tfifha youssef', 4401373, 1, 2, 'pending', 1),
(2851, 'tfifha youssef', 1566616, 2, 1, 'cancelled', 1),
(2851, 'tfifha youssef', 1566616, 3, 1, 'cancelled', 1),
(5174, 'tfifha youssef', 4724572, 4, 4, 'pending', 1),
(5174, 'tfifha youssef', 4724572, 1, 1, 'pending', 1),
(5174, 'tfifha youssef', 4724572, 3, 1, 'pending', 1),
(9686, 'tfifha youssef', 1355444, 1, 2, 'pending', 1),
(9510, 'tfifha youssef', 7461382, 4, 2, 'pending', 1),
(9510, 'tfifha youssef', 7461382, 1, 1, 'pending', 1),
(1392, 'tfifha youssef', 2434859, 1, 1, 'pending', 1),
(1392, 'tfifha youssef', 2434859, 2, 1, 'pending', 1),
(1392, 'tfifha youssef', 2434859, 3, 1, 'pending', 1),
(1392, 'tfifha youssef', 2434859, 1, 2, 'pending', 1),
(1392, 'tfifha youssef', 2434859, 4, 1, 'pending', 1),
(5553, 'tfifha youssef', 2061274, 3, 1, 'pending', 1),
(5553, 'tfifha youssef', 2061274, 4, 1, 'pending', 1),
(5553, 'tfifha youssef', 2061274, 1, 1, 'pending', 1),
(5553, 'tfifha youssef', 2061274, 2, 1, 'pending', 1),
(1649, 'tfifha youssef', 6343703, 2, 2, 'pending', 1),
(3394, 'tfifha youssef', 4212879, 1, 1, 'pending', 1),
(3394, 'tfifha youssef', 4212879, 4, 1, 'pending', 1),
(3394, 'tfifha youssef', 4212879, 1, 1, 'pending', 1),
(3394, 'tfifha youssef', 4212879, 3, 1, 'pending', 1),
(3394, 'tfifha youssef', 4212879, 2, 1, 'pending', 1),
(3172, 'tfifha youssef', 8856460, 4, 1, 'pending', 1),
(3172, 'tfifha youssef', 8856460, 2, 1, 'pending', 1),
(3172, 'tfifha youssef', 8856460, 1, 1, 'pending', 1),
(3172, 'tfifha youssef', 8856460, 3, 1, 'pending', 1),
(7331, 'tfifha youssef', 7497261, 4, 2, 'pending', 1),
(7331, 'tfifha youssef', 7497261, 2, 1, 'pending', 1),
(7331, 'tfifha youssef', 7497261, 1, 1, 'pending', 1),
(7331, 'tfifha youssef', 7497261, 3, 1, 'pending', 1),
(9407, 'tfifha youssef', 7483671, 1, 1, 'pending', 1),
(9407, 'tfifha youssef', 7483671, 2, 1, 'pending', 1),
(9407, 'tfifha youssef', 7483671, 4, 2, 'pending', 1),
(9407, 'tfifha youssef', 7483671, 3, 1, 'pending', 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id_reservation`, `idclient`, `matricule`, `date_debut`, `date_fin`, `date_retour`, `Cautionnement`, `prix_total`) VALUES
(28, 0, 7, '2021-03-18', '2021-03-27', '2021-03-27', 10, '900'),
(29, 0, 6, '2021-03-20', '2021-03-23', '2021-03-23', 150, '30'),
(30, 0, 8, '2021-03-20', '2021-03-28', '2021-03-28', 150, '80'),
(31, 3, 7, '2021-03-28', '2021-03-31', '2021-03-31', 20, '300'),
(32, 3, 6, '2021-03-11', '2021-03-19', '2021-03-19', 15, '80'),
(33, 3, 5, '2021-03-19', '2021-03-27', '2021-03-27', 15, '0');

-- --------------------------------------------------------

--
-- Structure de la table `reservationevent`
--

DROP TABLE IF EXISTS `reservationevent`;
CREATE TABLE IF NOT EXISTS `reservationevent` (
  `code_reservation` int(11) NOT NULL AUTO_INCREMENT,
  `code_client` int(11) DEFAULT NULL,
  `nom_client` varchar(50) DEFAULT NULL,
  `prenom_client` varchar(50) DEFAULT NULL,
  `telephone` int(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `nb_place` int(11) NOT NULL,
  `code_event` int(11) NOT NULL,
  PRIMARY KEY (`code_reservation`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reservationevent`
--

INSERT INTO `reservationevent` (`code_reservation`, `code_client`, `nom_client`, `prenom_client`, `telephone`, `email`, `nb_place`, `code_event`) VALUES
(24, 0, 'ghada', 'slimene', 23232323, 'ghada@gmail.com', 3, 16),
(28, 0, 'ghada', 'ghada', 2222, 'ggggg', 6, 12);

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
  PRIMARY KEY (`code_reservationE`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reservation_expo`
--

INSERT INTO `reservation_expo` (`code_reservationE`, `code_expo`, `code_client`, `nb_place`) VALUES
(1, 0, 0, 0),
(2, 0, 0, 0);

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
  `role` varchar(30) DEFAULT NULL,
  `mdp` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`ID`, `nom`, `prenom`, `datenaissance`, `ville`, `email`, `numero`, `image`, `role`, `mdp`) VALUES
(0, 'tfifha', 'youssef', '2000-02-24', 'ezzahra', 'youssef.tfifha@esprit.tn', 20245989, '<null>', 'user', 'a'),
(2, 'feki', 'mehdi', '1999-03-24', 'lac', 'mehdi.feki@esprit.tn', 20200000, '<null>', 'admin', 'aa'),
(4, 'tfifha', 'youssef', '2000-02-24', 'ezzahra', 'youssef.tfifha@icloud.com', 20245989, NULL, 'user', '1234');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
