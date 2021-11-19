-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 19, 2021 at 04:05 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pontoquente`
--

-- --------------------------------------------------------

--
-- Table structure for table `attribute`
--

CREATE TABLE `attribute` (
  `id` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `value_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `attribute`
--

INSERT INTO `attribute` (`id`, `type`, `value_name`) VALUES
(3, 'BRAND', 'APPLE'),
(4, 'EAN', '421421421421421'),
(5, 'EAN', '421421421421421'),
(6, 'BRAND', 'APPLE'),
(7, 'EAN', '421421421421421'),
(8, 'BRAND', 'APPLE'),
(9, 'EAN', '421421421421421'),
(10, 'BRAND', 'APPLE'),
(11, 'BRAND', 'APPLE'),
(12, 'EAN', '421421421421421');

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`id`, `name`) VALUES
('TUxCQ1NFUmI1ZGQx', 'Serra');

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`id`, `name`) VALUES
('BR', 'Brasil');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL,
  `available_quantity` int(11) NOT NULL,
  `base_price` float DEFAULT NULL,
  `condicao` varchar(255) DEFAULT NULL,
  `currency_id` varchar(255) DEFAULT NULL,
  `id_integracao` bigint(20) NOT NULL,
  `initial_quantity` int(11) NOT NULL,
  `original_price` float DEFAULT NULL,
  `permalink` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `seller_id` bigint(20) NOT NULL,
  `seller_contact` varchar(255) DEFAULT NULL,
  `site_id` varchar(255) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `stop_time` datetime DEFAULT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `seller_address_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `available_quantity`, `base_price`, `condicao`, `currency_id`, `id_integracao`, `initial_quantity`, `original_price`, `permalink`, `price`, `seller_id`, `seller_contact`, `site_id`, `start_time`, `stop_time`, `subtitle`, `title`, `seller_address_id`) VALUES
(23, 2, 7299, 'new', 'BRL', 123123, 5, NULL, 'URLASERDADA/NOMESERVICO/PRODUTO/IDANUNCIO', 7299, 386261043, NULL, 'PTQ', '2019-03-11 17:12:44', '2039-03-06 01:00:00', NULL, 'macbook m1', 6),
(24, 2, 7299, 'new', 'BRL', 123123, 5, NULL, 'URLASERDADA/NOMESERVICO/PRODUTO/IDANUNCIO', 7299, 386261043, NULL, 'PTQ', '2019-03-11 17:12:44', '2039-03-06 01:00:00', NULL, 'macbook m1', 6),
(25, 2, 7299, 'new', 'BRL', 123123, 5, NULL, 'URLASERDADA/NOMESERVICO/PRODUTO/IDANUNCIO', 7299, 386261043, NULL, 'PTQ', '2019-03-11 17:12:44', '2039-03-06 01:00:00', NULL, 'macbook m1', 6),
(26, 2, 7299, 'new', 'BRL', 123123, 5, NULL, 'URLASERDADA/NOMESERVICO/PRODUTO/IDANUNCIO', 7299, 386261043, NULL, 'PTQ', '2019-03-11 17:12:44', '2039-03-06 01:00:00', NULL, 'MAC MINI', 6),
(27, 2, 7299, 'new', 'BRL', 123123, 5, NULL, 'URLASERDADA/NOMESERVICO/PRODUTO/IDANUNCIO', 7299, 386261043, NULL, 'PTQ', '2019-03-11 17:12:44', '2039-03-06 01:00:00', NULL, 'MAC MINI', 6);

-- --------------------------------------------------------

--
-- Table structure for table `product_attributes`
--

CREATE TABLE `product_attributes` (
  `product_product_id` bigint(20) NOT NULL,
  `attributes_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product_attributes`
--

INSERT INTO `product_attributes` (`product_product_id`, `attributes_id`) VALUES
(23, 3),
(23, 4),
(24, 5),
(24, 6),
(25, 7),
(25, 8),
(26, 9),
(26, 10),
(27, 11),
(27, 12);

-- --------------------------------------------------------

--
-- Table structure for table `seller_address`
--

CREATE TABLE `seller_address` (
  `id` bigint(20) NOT NULL,
  `city_id` varchar(255) DEFAULT NULL,
  `country_id` varchar(255) DEFAULT NULL,
  `state_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `seller_address`
--

INSERT INTO `seller_address` (`id`, `city_id`, `country_id`, `state_id`) VALUES
(5, 'TUxCQ1NFUmI1ZGQx', 'BR', 'BR-ES'),
(6, 'TUxCQ1NFUmI1ZGQx', 'BR', 'BR-ES');

-- --------------------------------------------------------

--
-- Table structure for table `state`
--

CREATE TABLE `state` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `state`
--

INSERT INTO `state` (`id`, `name`) VALUES
('BR-ES', 'Espírito Santo');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attribute`
--
ALTER TABLE `attribute`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `FKcdrqj642hj5m1pw02vfgn5no2` (`seller_address_id`);

--
-- Indexes for table `product_attributes`
--
ALTER TABLE `product_attributes`
  ADD UNIQUE KEY `UK_f2efepwpwx0twh81ywdojvaoa` (`attributes_id`),
  ADD KEY `FKcos1hpnm9gebk4gtpatnma2kd` (`product_product_id`);

--
-- Indexes for table `seller_address`
--
ALTER TABLE `seller_address`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtjqq1vmr7c0ldthoyxafpy2j0` (`city_id`),
  ADD KEY `FKp1s8k2jtk9itfb9eh2rbo5hvo` (`country_id`),
  ADD KEY `FKrnxyyt63npc1wmw0j3ns7lxuv` (`state_id`);

--
-- Indexes for table `state`
--
ALTER TABLE `state`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attribute`
--
ALTER TABLE `attribute`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `seller_address`
--
ALTER TABLE `seller_address`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FKcdrqj642hj5m1pw02vfgn5no2` FOREIGN KEY (`seller_address_id`) REFERENCES `seller_address` (`id`);

--
-- Constraints for table `product_attributes`
--
ALTER TABLE `product_attributes`
  ADD CONSTRAINT `FKcos1hpnm9gebk4gtpatnma2kd` FOREIGN KEY (`product_product_id`) REFERENCES `product` (`product_id`),
  ADD CONSTRAINT `FKj8ke4a0mgyl3y1cxm2ikkq3g6` FOREIGN KEY (`attributes_id`) REFERENCES `attribute` (`id`);

--
-- Constraints for table `seller_address`
--
ALTER TABLE `seller_address`
  ADD CONSTRAINT `FKp1s8k2jtk9itfb9eh2rbo5hvo` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  ADD CONSTRAINT `FKrnxyyt63npc1wmw0j3ns7lxuv` FOREIGN KEY (`state_id`) REFERENCES `state` (`id`),
  ADD CONSTRAINT `FKtjqq1vmr7c0ldthoyxafpy2j0` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
