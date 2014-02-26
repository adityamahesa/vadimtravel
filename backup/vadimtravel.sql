-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 04, 2011 at 09:57 AM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `vadimtravel`
--

-- --------------------------------------------------------

--
-- Table structure for table `jabatan`
--

CREATE TABLE IF NOT EXISTS `jabatan` (
  `id_jabatan` varchar(3) NOT NULL,
  `nama` varchar(20) NOT NULL,
  PRIMARY KEY (`id_jabatan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jabatan`
--

INSERT INTO `jabatan` (`id_jabatan`, `nama`) VALUES
('adm', 'Administrator'),
('ptg', 'Petugas');

-- --------------------------------------------------------

--
-- Table structure for table `operator`
--

CREATE TABLE IF NOT EXISTS `operator` (
  `id_operator` int(11) NOT NULL,
  `nama` varchar(45) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(12) DEFAULT NULL,
  `id_jabatan` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id_operator`),
  KEY `id_jabatan` (`id_jabatan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `operator`
--


-- --------------------------------------------------------

--
-- Table structure for table `status_travel`
--

CREATE TABLE IF NOT EXISTS `status_travel` (
  `id_status_travel` varchar(2) NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`id_status_travel`),
  UNIQUE KEY `status_UNIQUE` (`status`),
  UNIQUE KEY `id_status_UNIQUE` (`id_status_travel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status_travel`
--

INSERT INTO `status_travel` (`id_status_travel`, `status`) VALUES
('b', 'BATAL'),
('bd', 'BELUM DIKONFIRMASI'),
('sd', 'SUDAH DIKONFIRMASI'),
('s', 'SUKSES');

-- --------------------------------------------------------

--
-- Table structure for table `travel_detail_order`
--

CREATE TABLE IF NOT EXISTS `travel_detail_order` (
  `id_travel_order` int(11) NOT NULL,
  `id_travel_tujuan` varchar(3) NOT NULL,
  `id_status_travel` varchar(2) NOT NULL,
  `charge` int(11) NOT NULL,
  KEY `id_travel_order` (`id_travel_order`),
  KEY `id_travel_tujuan` (`id_travel_tujuan`),
  KEY `id_status_travel` (`id_status_travel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `travel_detail_order`
--


-- --------------------------------------------------------

--
-- Table structure for table `travel_order`
--

CREATE TABLE IF NOT EXISTS `travel_order` (
  `id_travel_order` int(11) NOT NULL,
  `nama` varchar(45) NOT NULL,
  `alamat` varchar(60) NOT NULL,
  `id_travel_regional` varchar(3) NOT NULL,
  `tgl_transaksi` datetime NOT NULL,
  `tgl_jam_berangkat` datetime NOT NULL,
  PRIMARY KEY (`id_travel_order`),
  UNIQUE KEY `id_pemesan_travel_UNIQUE` (`id_travel_order`),
  KEY `id_travel_regional` (`id_travel_regional`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `travel_order`
--


-- --------------------------------------------------------

--
-- Table structure for table `travel_regional`
--

CREATE TABLE IF NOT EXISTS `travel_regional` (
  `id_travel_regional` varchar(3) NOT NULL,
  `regional` varchar(25) NOT NULL,
  `harga` int(11) NOT NULL,
  PRIMARY KEY (`id_travel_regional`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `travel_regional`
--

INSERT INTO `travel_regional` (`id_travel_regional`, `regional`, `harga`) VALUES
('MLB', 'Batu, Malang Barat', 10000),
('MLK', 'Malang Kota', 0),
('MLS', 'Malang Selatan', 20000),
('MLT', 'Malang Timur', 15000),
('MLU', 'Malang Utara', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `travel_tujuan`
--

CREATE TABLE IF NOT EXISTS `travel_tujuan` (
  `id_travel_tujuan` varchar(3) NOT NULL,
  `tujuan` varchar(15) NOT NULL,
  `harga` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_travel_tujuan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `travel_tujuan`
--

INSERT INTO `travel_tujuan` (`id_travel_tujuan`, `tujuan`, `harga`) VALUES
('MDN', 'Madiun', 55000),
('SBY', 'Surabaya', 20000),
('TGL', 'Trenggalek', 60000),
('TLG', 'Tulungagung', 45000);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `operator`
--
ALTER TABLE `operator`
  ADD CONSTRAINT `operator_ibfk_1` FOREIGN KEY (`id_jabatan`) REFERENCES `jabatan` (`id_jabatan`);

--
-- Constraints for table `travel_detail_order`
--
ALTER TABLE `travel_detail_order`
  ADD CONSTRAINT `travel_detail_order_ibfk_1` FOREIGN KEY (`id_travel_order`) REFERENCES `travel_order` (`id_travel_order`),
  ADD CONSTRAINT `travel_detail_order_ibfk_2` FOREIGN KEY (`id_travel_tujuan`) REFERENCES `travel_tujuan` (`id_travel_tujuan`),
  ADD CONSTRAINT `travel_detail_order_ibfk_3` FOREIGN KEY (`id_status_travel`) REFERENCES `status_travel` (`id_status_travel`);

--
-- Constraints for table `travel_order`
--
ALTER TABLE `travel_order`
  ADD CONSTRAINT `travel_order_ibfk_1` FOREIGN KEY (`id_travel_regional`) REFERENCES `travel_regional` (`id_travel_regional`);
