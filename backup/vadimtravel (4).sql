-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 21, 2011 at 10:19 AM
-- Server version: 5.1.37
-- PHP Version: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

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
-- Stand-in structure for view `lihat_transaksi`
--
CREATE TABLE IF NOT EXISTS `lihat_transaksi` (
`id_travel_order` int(11)
,`nama` varchar(45)
,`alamat` varchar(60)
,`regional` varchar(25)
,`telp` varchar(15)
,`tgl_transaksi` date
,`tgl_berangkat` date
,`jam_berangkat` time
,`tujuan` varchar(15)
,`harga regional` int(11)
,`harga tujuan` int(11)
,`charge` int(11)
,`total` bigint(13)
,`status` varchar(20)
);
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `operator`
--

INSERT INTO `operator` (`id_operator`, `nama`, `username`, `password`, `id_jabatan`) VALUES
(1, 'Aditya Arya Mahesa', 'admin', 'ceb8447cc4ab78d2ec34cd9f11e4bed2', 'adm'),
(2, 'Fahniar Firmansyah', 'fahn', '171c6d4e0685a32a28b0db65e423ec3f', 'adm'),
(3, 'Anton Ilmiar', 'anton', '171c6d4e0685a32a28b0db65e423ec3f', 'ptg');

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
  `charge` int(11) NOT NULL,
  KEY `id_travel_order` (`id_travel_order`),
  KEY `id_travel_tujuan` (`id_travel_tujuan`),
  KEY `id_status_travel` (`id_status_travel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `travel_detail_order`
--

INSERT INTO `travel_detail_order` (`id_travel_order`, `id_travel_tujuan`, `id_status_travel`, `charge`) VALUES
(1, 'MDN', 'bd', 0),
(2, 'TGL', 'bd', 0);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `travel_order`
--

INSERT INTO `travel_order` (`id_travel_order`, `nama`, `alamat`, `id_travel_regional`, `telp`, `tgl_transaksi`, `tgl_berangkat`, `jam_berangkat`) VALUES
(1, 'Sherly Saskia', 'Jalan Mataram50 Dampit', 'mlt', '03418292144', '2011-05-20', '2011-05-28', '15:00:00'),
(2, 'Muliatama', 'Jalan Balean Barat', 'mlk', '085735683050', '2011-05-20', '0000-00-00', '00:00:00');

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

-- --------------------------------------------------------

--
-- Structure for view `lihat_transaksi`
--
DROP TABLE IF EXISTS `lihat_transaksi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `lihat_transaksi` AS (select `travel_order`.`id_travel_order` AS `id_travel_order`,`travel_order`.`nama` AS `nama`,`travel_order`.`alamat` AS `alamat`,`travel_regional`.`regional` AS `regional`,`travel_order`.`telp` AS `telp`,`travel_order`.`tgl_transaksi` AS `tgl_transaksi`,`travel_order`.`tgl_berangkat` AS `tgl_berangkat`,`travel_order`.`jam_berangkat` AS `jam_berangkat`,`travel_tujuan`.`tujuan` AS `tujuan`,`travel_regional`.`harga` AS `harga regional`,`travel_tujuan`.`harga` AS `harga tujuan`,`travel_detail_order`.`charge` AS `charge`,((`travel_regional`.`harga` + `travel_tujuan`.`harga`) + `travel_detail_order`.`charge`) AS `total`,`status_travel`.`status` AS `status` from ((((`travel_order` join `travel_regional`) join `travel_detail_order`) join `status_travel`) join `travel_tujuan`) where ((`travel_order`.`id_travel_regional` = `travel_regional`.`id_travel_regional`) and (`travel_detail_order`.`id_travel_order` = `travel_order`.`id_travel_order`) and (`travel_detail_order`.`id_status_travel` = `status_travel`.`id_status_travel`) and (`travel_detail_order`.`id_travel_tujuan` = `travel_tujuan`.`id_travel_tujuan`)));

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

