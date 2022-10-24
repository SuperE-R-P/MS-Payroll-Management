-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 22 oct. 2022 à 21:20
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
-- Base de données : `payrolldb`
--

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(8);

-- --------------------------------------------------------

--
-- Structure de la table `payroll`
--

CREATE TABLE `payroll` (
  `id` bigint(20) NOT NULL,
  `deductions` float NOT NULL,
  `earnings` float NOT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `payroll_month` varchar(255) DEFAULT NULL,
  `salary` float NOT NULL,
  `total_working_days` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `payroll`
--

INSERT INTO `payroll` (`id`, `deductions`, `earnings`, `employee_name`, `payroll_month`, `salary`, `total_working_days`) VALUES
(1, 0, 0, 'Mariem', NULL, 2000, 0),
(2, 0, 0, 'Sarra', NULL, 2000, 0),
(3, 0, 0, 'Mohamed', NULL, 2000, 0),
(4, 100, 200, 'Khalil', '3', 2500, 20),
(5, 0, 0, 'Mariem', NULL, 2000, 0),
(6, 0, 0, 'Sarra', NULL, 2000, 0),
(7, 0, 0, 'Mohamed', NULL, 2000, 0);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `payroll`
--
ALTER TABLE `payroll`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
