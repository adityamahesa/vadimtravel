-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 23, 2011 at 11:30 AM
-- Server version: 5.1.41
-- PHP Version: 5.3.1

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
-- Table structure for table `lihat_transaksi`
--

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vadimtravel`.`lihat_transaksi` AS (select `vadimtravel`.`travel_order`.`id_travel_order` AS `id_travel_order`,`vadimtravel`.`travel_order`.`nama` AS `nama`,`vadimtravel`.`travel_order`.`alamat` AS `alamat`,`vadimtravel`.`travel_regional`.`regional` AS `regional`,`vadimtravel`.`travel_order`.`telp` AS `telp`,`vadimtravel`.`travel_order`.`tgl_transaksi` AS `tgl_transaksi`,`vadimtravel`.`travel_order`.`tgl_berangkat` AS `tgl_berangkat`,`vadimtravel`.`travel_order`.`jam_berangkat` AS `jam_berangkat`,`vadimtravel`.`travel_tujuan`.`tujuan` AS `tujuan`,`vadimtravel`.`travel_regional`.`harga` AS `harga regional`,`vadimtravel`.`travel_tujuan`.`harga` AS `harga tujuan`,`vadimtravel`.`travel_detail_order`.`charge` AS `charge`,((`vadimtravel`.`travel_regional`.`harga` + `vadimtravel`.`travel_tujuan`.`harga`) + `vadimtravel`.`travel_detail_order`.`charge`) AS `total`,`vadimtravel`.`status_travel`.`status` AS `status` from ((((`vadimtravel`.`travel_order` join `vadimtravel`.`travel_regional`) join `vadimtravel`.`travel_detail_order`) join `vadimtravel`.`status_travel`) join `vadimtravel`.`travel_tujuan`) where ((`vadimtravel`.`travel_order`.`id_travel_regional` = `vadimtravel`.`travel_regional`.`id_travel_regional`) and (`vadimtravel`.`travel_detail_order`.`id_travel_order` = `vadimtravel`.`travel_order`.`id_travel_order`) and (`vadimtravel`.`travel_detail_order`.`id_status_travel` = `vadimtravel`.`status_travel`.`id_status_travel`) and (`vadimtravel`.`travel_detail_order`.`id_travel_tujuan` = `vadimtravel`.`travel_tujuan`.`id_travel_tujuan`)));

--
-- Dumping data for table `lihat_transaksi`
--

INSERT INTO `lihat_transaksi` (`id_travel_order`, `nama`, `alamat`, `regional`, `telp`, `tgl_transaksi`, `tgl_berangkat`, `jam_berangkat`, `tujuan`, `harga regional`, `harga tujuan`, `charge`, `total`, `status`) VALUES
(13, 'Danial Syahfan', 'Alun - Alun Batu', 'Batu, Malang Barat', '0987', '2011-05-23', '2011-05-31', '19:00:00', 'Madiun', 10000, 55000, 0, 65000, 'BELUM DIKONFIRMASI'),
(2, 'Muliatama', 'Jalan Balean Barat', 'Malang Kota', '085735683050', '2011-05-20', '2011-05-31', '12:00:00', 'Trenggalek', 0, 60000, 0, 60000, 'BATAL'),
(7, 'Zein Adi', 'Griya Shanta J 440', 'Malang Kota', '0341489504', '2011-05-22', '2011-06-01', '11:00:00', 'Surabaya', 0, 60000, 0, 60000, 'SUDAH DIKONFIRMASI'),
(12, 'Yaniar Goyenk', 'Jalan Candi Badut 13', 'Malang Kota', '085755855054', '2011-05-22', '2011-05-04', '05:00:00', 'Madiun', 0, 55000, 0, 55000, 'SUDAH DIKONFIRMASI'),
(15, 'Seka Ridhola', 'Jalan Danau Tambingan', 'Malang Kota', '085233667182', '2011-05-23', '2011-06-06', '16:00:00', 'Madiun', 0, 55000, 0, 55000, 'SUDAH DIKONFIRMASI'),
(14, 'Dewanda Bramantya', 'Karangduren, Pakisaji', 'Malang Selatan', '085234332450', '2011-05-23', '2011-06-05', '16:00:00', 'Tulungagung', 20000, 45000, 0, 65000, 'BELUM DIKONFIRMASI'),
(1, 'Sherly Saskia', 'Jalan Mataram50 Dampit', 'Malang Timur', '03418292144', '2011-05-20', '2011-05-28', '15:00:00', 'Madiun', 15000, 55000, 5000, 75000, 'SUKSES');

-- --------------------------------------------------------

--
-- Table structure for table `operator`
--

CREATE TABLE IF NOT EXISTS `operator` (
  `id_operator` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(45) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(32) DEFAULT NULL,
  `id_jabatan` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id_operator`),
  KEY `id_jabatan` (`id_jabatan`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `operator`
--

INSERT INTO `operator` (`id_operator`, `nama`, `username`, `password`, `id_jabatan`) VALUES
(1, 'Aditya Arya Mahesa', 'admin', 'boss', 'adm'),
(2, 'Fahniar Firmansyah', 'fahn', 'vadim', 'adm'),
(4, 'Anton Ilmiar', 'anton', 'vadim', 'ptg');

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
  `id_status_travel` varchar(2) NOT NULL DEFAULT 'bd',
  `charge` int(11) DEFAULT '0',
  KEY `id_travel_order` (`id_travel_order`),
  KEY `id_travel_tujuan` (`id_travel_tujuan`),
  KEY `id_status_travel` (`id_status_travel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `travel_detail_order`
--

INSERT INTO `travel_detail_order` (`id_travel_order`, `id_travel_tujuan`, `id_status_travel`, `charge`) VALUES
(1, 'MDN', 's', 5000),
(2, 'TGL', 'b', 0),
(7, 'SBY', 'sd', 0),
(12, 'MDN', 'sd', 0),
(13, 'MDN', 'bd', 0),
(14, 'TLG', 'bd', 0),
(15, 'MDN', 'sd', 0);

-- --------------------------------------------------------

--
-- Table structure for table `travel_order`
--

CREATE TABLE IF NOT EXISTS `travel_order` (
  `id_travel_order` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(45) NOT NULL,
  `alamat` varchar(60) NOT NULL,
  `id_travel_regional` varchar(3) NOT NULL,
  `telp` varchar(15) NOT NULL,
  `tgl_transaksi` date NOT NULL,
  `tgl_berangkat` date NOT NULL,
  `jam_berangkat` time NOT NULL,
  PRIMARY KEY (`id_travel_order`),
  UNIQUE KEY `id_pemesan_travel_UNIQUE` (`id_travel_order`),
  KEY `id_travel_regional` (`id_travel_regional`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `travel_order`
--

INSERT INTO `travel_order` (`id_travel_order`, `nama`, `alamat`, `id_travel_regional`, `telp`, `tgl_transaksi`, `tgl_berangkat`, `jam_berangkat`) VALUES
(1, 'Sherly Saskia', 'Jalan Mataram50 Dampit', 'mlt', '03418292144', '2011-05-20', '2011-05-28', '15:00:00'),
(2, 'Muliatama', 'Jalan Balean Barat', 'mlk', '085735683050', '2011-05-20', '2011-05-31', '12:00:00'),
(7, 'Zein Adi', 'Griya Shanta J 440', 'MLK', '0341489504', '2011-05-22', '2011-06-01', '11:00:00'),
(12, 'Yaniar Goyenk', 'Jalan Candi Badut 13', 'MLK', '085755855054', '2011-05-22', '2011-05-04', '05:00:00'),
(13, 'Danial Syahfan', 'Alun - Alun Batu', 'MLB', '0987', '2011-05-23', '2011-05-31', '19:00:00'),
(14, 'Dewanda Bramantya', 'Karangduren, Pakisaji', 'MLS', '085234332450', '2011-05-23', '2011-06-05', '16:00:00'),
(15, 'Seka Ridhola', 'Jalan Danau Tambingan', 'MLK', '085233667182', '2011-05-23', '2011-06-06', '16:00:00');

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
  `harga` int(11) NOT NULL,
  `deskripsi` text,
  PRIMARY KEY (`id_travel_tujuan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `travel_tujuan`
--

INSERT INTO `travel_tujuan` (`id_travel_tujuan`, `tujuan`, `harga`, `deskripsi`) VALUES
('JMB', 'Jember', 80000, 'Kota yang merupakan wilayah timur dari Jawa Timur ini memiliki potensi sumber daya alam dan sumber daya manusia yang sangat tinggi. Sehingga sangat mempengaruhi permintaan client vadimTRAVEL saat ini. Perjalanan ini menghabiskan waktu 8 jam'),
('MDN', 'Madiun', 55000, 'Wilayah yang kerap disebut kota Gadis ini (Perdagangan, Pendidikan, dan Industri) ternyata memiliki peminat yang tak kalah banyak. Estimasi perjalanannya ialah 4 jam.'),
('PNG', 'Ponorogo', 70000, 'Kota yang terkenal dengan Grebeg Suro dan Reog Ponorogo-nya. Jika anda berminat, anda dapat bergabung dengan kami dalam waktu 5 jam'),
('SBY', 'Surabaya', 60000, 'Dikarenakan Surabaya memiliki Bandar Udara Juanda yang berskala Internasional, kini Surabaya menjadi pilihan favorit client kami. Kami sanggup melakukan perjalanan ini selama 1,5 jam (dihitung dari Singosari)'),
('TGL', 'Trenggalek', 60000, 'Banyak perantau yang datang ke Malang dan mereka sukses di Kota ini. Sehingga banyak pemesan travel ini pada saat menjelang Hari Raya. Oleh karena itu, kami dapat mengestimasikan perjalanan ini selama 4,5 jam'),
('TLG', 'Tulungagung', 45000, 'Dikarenakan Tulungagung memiliki potensi sumber daya alam berupa marmer, para investor memprioritaskan untuk bergabung bersama kami. Nikmati perjalanan 4 jam yang nyaman bersama kami');

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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
