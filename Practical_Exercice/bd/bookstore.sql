-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 12 Novembre 2020 à 16:30
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `bookstore`
--

-- --------------------------------------------------------

--
-- Structure de la table `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) DEFAULT NULL,
  `Author` varchar(100) DEFAULT NULL,
  `Price` double(8,2) DEFAULT NULL,
  `releaseDate` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Contenu de la table `book`
--

INSERT INTO `book` (`Id`, `Title`, `Author`, `Price`, `releaseDate`) VALUES
(1, 'fdg', 'gh', 12.00, '1970-01-01'),
(3, 'sd', 'fg', 200.00, '1970-01-01'),
(6, 'Dali', 'Mejbri', 100.00, '1970-01-01'),
(7, 'test', 'dali', 16.00, '2004-01-23'),
(8, 'test1', 'mejbri', 29.00, '1990-01-10'),
(9, 'qsd', 'df', 11.00, '3333-01-10'),
(10, 'qsd', 'df', 45.00, '2005-01-10'),
(11, 'sq', 'df', 98.00, '2000-01-11'),
(12, 'sqf', 'gf', 45.00, '2000-01-10'),
(13, 'Test', 'Malek', 15.00, '2000-10-20'),
(14, 'sdf', 'gfd', 12.00, '2001-10-25');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `Id` bigint(11) NOT NULL AUTO_INCREMENT,
  `idBook` int(11) DEFAULT NULL,
  `Price` double(8,2) DEFAULT NULL,
  `Quantite` int(11) DEFAULT NULL,
  `total` decimal(20,2) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `NewForeignKey` (`idBook`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `Id` int(8) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(100) DEFAULT NULL,
  `Prenom` varchar(100) DEFAULT NULL,
  `Telephone` bigint(20) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`Id`, `Nom`, `Prenom`, `Telephone`, `Email`) VALUES
(1, 'Mejbri', 'Dali', 22509063, 'daaa@mejbri.com');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `NewForeignKey` FOREIGN KEY (`idBook`) REFERENCES `book` (`Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
