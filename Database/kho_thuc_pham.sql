-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 21, 2024 at 05:20 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kho_thuc_pham`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `cid` int(11) NOT NULL,
  `cname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`cid`, `cname`) VALUES
(1, 'Lương thực'),
(2, 'Thực phẩm tươi sống'),
(3, 'Rau củ'),
(4, 'Hải sản'),
(5, 'Trái cây');

-- --------------------------------------------------------

--
-- Table structure for table `fooditems`
--

CREATE TABLE `fooditems` (
  `fid` int(11) NOT NULL,
  `cid` int(11) DEFAULT NULL,
  `fname` varchar(255) NOT NULL,
  `fdescribe` varchar(255) NOT NULL,
  `fprice` int(11) NOT NULL,
  `fquantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `fooditems`
--

INSERT INTO `fooditems` (`fid`, `cid`, `fname`, `fdescribe`, `fprice`, `fquantity`) VALUES
(1, 1, 'Gạo thơm Jasmine', 'Loại gạo thơm chất lượng cao, phù hợp với các bữa ăn gia đình.', 15000, 200),
(2, 1, 'Mì gói Hảo Hảo', 'Mì ăn liền hương vị tôm chua cay.', 3500, 500),
(3, 2, 'Thịt bò Úc', 'Thịt bò nhập khẩu từ Úc, đảm bảo tươi ngon.', 250000, 50),
(4, 2, 'Thịt gà ta', 'Thịt gà ta tươi, thích hợp cho các món ăn truyền thống.', 130000, 100),
(5, 3, 'Cà rốt', 'Rau củ sạch, thích hợp cho các món hầm và salad.', 20000, 300),
(6, 3, 'Bí đỏ', 'Rau củ sạch, có giá trị dinh dưỡng cao.', 15000, 150),
(7, 4, 'Cá hồi Na Uy', 'Cá hồi nhập khẩu chất lượng cao.', 450000, 20),
(8, 4, 'Tôm sú', 'Tôm sú tươi sống, thích hợp cho các món lẩu hoặc nướng.', 300000, 30),
(9, 5, 'Xoài cát Hòa Lộc', 'Trái cây tươi ngọt, giàu dinh dưỡng.', 60000, 50),
(10, 5, 'Nho Mỹ không hạt', 'Trái cây nhập khẩu, giàu vitamin.', 120000, 40),
(11, 1, 'Gạo nếp cái hoa vàng', 'Loại gạo nếp thơm, dẻo, dùng cho các món xôi, bánh.', 25000, 120),
(12, 1, 'Bột mì đa dụng', 'Bột mì thích hợp làm bánh hoặc nấu ăn.', 12000, 300),
(13, 2, 'Thịt heo ba chỉ', 'Thịt heo tươi, phù hợp với các món kho và nướng.', 150000, 80),
(14, 2, 'Cánh gà', 'Cánh gà tươi, thích hợp để chiên hoặc nướng.', 120000, 150),
(15, 3, 'Khoai tây', 'Khoai tây tươi, thích hợp làm món chiên hoặc nghiền.', 20000, 250),
(16, 3, 'Cải bó xôi', 'Rau cải xanh, giàu vitamin và khoáng chất.', 30000, 200),
(17, 4, 'Mực ống', 'Mực tươi, thích hợp cho món chiên giòn hoặc hấp.', 350000, 40),
(18, 4, 'Sò điệp', 'Sò điệp tươi ngon, thích hợp cho món nướng hoặc súp.', 400000, 25),
(19, 5, 'Táo Fuji', 'Táo nhập khẩu từ Nhật Bản, ngọt và giòn.', 90000, 60),
(20, 5, 'Dưa hấu không hạt', 'Dưa hấu tươi, ngọt, không có hạt.', 25000, 100);

-- --------------------------------------------------------

--
-- Table structure for table `inventory_transactions`
--

CREATE TABLE `inventory_transactions` (
  `transactionsid` int(11) NOT NULL,
  `fid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `sid` int(11) NOT NULL,
  `transactions_type` int(11) NOT NULL,
  `transactions_quantity` int(11) NOT NULL,
  `transactions_note` varchar(255) DEFAULT NULL,
  `transactions_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inventory_transactions`
--

INSERT INTO `inventory_transactions` (`transactionsid`, `fid`, `uid`, `sid`, `transactions_type`, `transactions_quantity`, `transactions_note`, `transactions_date`) VALUES
(1, 1, 2, 1, 0, 100, 'Nhập thêm hàng từ nhà cung cấp Kamereo.', '2024-09-01'),
(2, 2, 3, 2, 0, 200, 'Nhập lô mì từ Công ty Hoàng Đông.', '2024-09-03'),
(3, 3, 4, 3, 0, 30, 'Nhập thịt bò từ Hanoifood.', '2024-09-05'),
(4, 4, 2, 4, 0, 50, 'Nhập gà tươi từ Hữu Nghị Food.', '2024-09-07'),
(5, 5, 3, 5, 0, 100, 'Nhập cà rốt từ Zin Food Việt Nam.', '2024-09-09'),
(6, 6, 4, 6, 0, 80, 'Nhập bí đỏ từ Organica.', '2024-09-11'),
(7, 7, 2, 1, 0, 10, 'Nhập cá hồi từ Kamereo.', '2024-09-13'),
(8, 8, 3, 2, 0, 15, 'Nhập tôm từ Công ty Hoàng Đông.', '2024-09-15'),
(9, 9, 4, 3, 0, 40, 'Nhập xoài từ Hanoifood.', '2024-09-17'),
(10, 10, 2, 5, 0, 20, 'Nhập nho từ Zin Food Việt Nam.', '2024-09-19'),
(11, 11, 3, 1, 0, 80, 'Nhập gạo nếp từ Kamereo.', '2024-09-21'),
(12, 12, 4, 4, 0, 150, 'Nhập bột mì từ Hữu Nghị Food.', '2024-09-23'),
(13, 13, 2, 3, 0, 40, 'Nhập thịt heo từ Hanoifood.', '2024-09-25'),
(14, 14, 3, 5, 0, 70, 'Nhập cánh gà từ Zin Food Việt Nam.', '2024-09-27'),
(15, 15, 4, 6, 0, 120, 'Nhập khoai từ Organica.', '2024-09-29'),
(16, 16, 2, 1, 0, 50, 'Nhập rau từ Kamereo.', '2024-10-01'),
(17, 17, 3, 2, 0, 15, 'Nhập mực tươi từ Công ty Hoàng Đông.', '2024-10-03'),
(18, 18, 4, 3, 0, 10, 'Nhập sò điệp từ Hanoifood.', '2024-10-05'),
(19, 19, 2, 5, 0, 30, 'Nhập táo từ Zin Food Việt Nam.', '2024-10-07'),
(20, 20, 3, 6, 0, 50, 'Nhập dưa từ Organica.', '2024-10-09'),
(21, 1, 2, 7, 1, 50, 'Xuất kho cho khách hàng bán lẻ tại CoopMart.', '2024-09-02'),
(22, 2, 3, 8, 1, 150, 'Xuất bán cho siêu thị Big C.', '2024-09-04'),
(23, 3, 4, 7, 1, 20, 'Cung cấp thịt bò cho cửa hàng CoopMart.', '2024-09-06'),
(24, 4, 2, 9, 1, 30, 'Cung cấp gà ta cho cửa hàng Bách Hóa Xanh.', '2024-09-08'),
(25, 5, 3, 10, 1, 60, 'Cung cấp cà rốt cho VinMart.', '2024-09-10'),
(26, 6, 4, 7, 1, 50, 'Xuất kho bí đỏ cho khách hàng CoopMart.', '2024-09-12'),
(27, 7, 2, 8, 1, 5, 'Cung cấp cá hồi cho siêu thị Big C.', '2024-09-14'),
(28, 8, 3, 9, 1, 10, 'Xuất bán tôm cho cửa hàng Bách Hóa Xanh.', '2024-09-16'),
(29, 9, 4, 10, 1, 20, 'Cung cấp xoài cho VinMart.', '2024-09-18'),
(30, 10, 2, 7, 1, 15, 'Cung cấp nho Mỹ cho CoopMart.', '2024-09-20'),
(31, 11, 3, 8, 1, 60, 'Cung cấp gạo nếp cho siêu thị Big C.', '2024-09-22'),
(32, 12, 4, 9, 1, 100, 'Xuất bột mì cho cửa hàng Bách Hóa Xanh.', '2024-09-24'),
(33, 13, 2, 10, 1, 30, 'Cung cấp thịt heo cho VinMart.', '2024-09-26'),
(34, 14, 3, 7, 1, 50, 'Cung cấp cánh gà cho CoopMart.', '2024-09-28'),
(35, 15, 4, 8, 1, 80, 'Cung cấp khoai tây cho siêu thị Big C.', '2024-09-30'),
(36, 16, 2, 9, 1, 30, 'Cung cấp cải bó xôi cho cửa hàng Bách Hóa Xanh.', '2024-10-02'),
(37, 17, 3, 10, 1, 10, 'Xuất mực cho VinMart.', '2024-10-04'),
(38, 18, 4, 7, 1, 5, 'Cung cấp sò điệp cho CoopMart.', '2024-10-06'),
(39, 19, 2, 8, 1, 20, 'Cung cấp táo Fuji cho siêu thị Big C.', '2024-10-08'),
(40, 20, 3, 9, 1, 30, 'Cung cấp dưa hấu cho cửa hàng Bách Hóa Xanh.', '2024-10-10');

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `sid` int(11) NOT NULL,
  `sname` varchar(255) NOT NULL,
  `semail` varchar(255) NOT NULL,
  `sphone` text NOT NULL,
  `saddress` varchar(255) NOT NULL,
  `stype` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`sid`, `sname`, `semail`, `sphone`, `saddress`, `stype`) VALUES
(1, 'Kamereo', 'kamereo@gmail.com', '0812463727', 'Tầng 1 – Tòa nhà The Manor Officetel, số 89 đường Nguyễn Hữu Cảnh, Phường 22, quận Bình Thạnh, Thành phố Hồ Chí Minh', 0),
(2, 'Công ty TNHH Thực phẩm Hoàng Đông', 'tphoanhdong@gmail.com', '0214748367', '94 P. Trần Quý Cáp, phường Văn Chương, quận Đống Đa, Hà Nội.', 0),
(3, 'Công Ty Hanoifood', 'hanoifood@gmail.com', '0211456557', '84 Quán Thánh, quận Ba Đình, Hà Nội.', 0),
(4, 'Hữu Nghị Food', 'huunghifood@gmail.com', '0214741247', '122 Định Công, phường Định Công, quận Hoàng Mai, Hà Nội.', 0),
(5, 'Công ty Cổ phần Zin Food Việt Nam', 'zinfoodvn@gmail.com', '0214748364', 'TT10-39, KĐT Mới Văn Phú, phường Phú La, quận Hà Đông, Hà Nội.', 0),
(6, 'Công ty Cổ phần Đầu tư Organica', 'organica@gmail.com', '0901828681', '180 Nguyễn Thị Minh Khai, phường Võ Thị Sáu, Quận 3, TPHCM.', 0),
(7, 'Siêu thị CoopMart', 'coopmart@gmail.com', '0283838388', 'Quận 3, TP.HCM', 1),
(8, 'Siêu thị Big C', 'bigc@gmail.com', '0283939397', 'Quận Tân Bình, TP.HCM', 1),
(9, 'Cửa hàng Bách Hóa Xanh', 'bhx@gmail.com', '0283637646', 'Quận 1, TP.HCM', 1),
(10, 'VinMart', 'vinmart@gmail.com', '0243234321', 'Quận Cầu Giấy, Hà Nội', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `uid` int(11) NOT NULL,
  `uname` varchar(255) NOT NULL,
  `upassword` varchar(255) NOT NULL,
  `ufullname` varchar(255) NOT NULL,
  `uphone` text NOT NULL,
  `urole` enum('Admin','NV') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`uid`, `uname`, `upassword`, `ufullname`, `uphone`, `urole`) VALUES
(1, 'admin', '1', 'Quản lý', '096969696', 'Admin'),
(2, 'nv01', '1', 'Lương Anh', '012345678', 'NV'),
(3, 'nv02', '1', 'Nghĩa', '012456214', 'NV'),
(4, 'nv03', '1', 'Việt', '055444335', 'NV');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `fooditems`
--
ALTER TABLE `fooditems`
  ADD PRIMARY KEY (`fid`),
  ADD KEY `fk_fooditems_categories` (`cid`);

--
-- Indexes for table `inventory_transactions`
--
ALTER TABLE `inventory_transactions`
  ADD PRIMARY KEY (`transactionsid`),
  ADD KEY `fk_transaction_suser` (`uid`),
  ADD KEY `fk_transaction_food` (`fid`),
  ADD KEY `fk_suppliers` (`sid`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`sid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`uid`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `fooditems`
--
ALTER TABLE `fooditems`
  ADD CONSTRAINT `fk_fooditems_categories` FOREIGN KEY (`cid`) REFERENCES `categories` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `inventory_transactions`
--
ALTER TABLE `inventory_transactions`
  ADD CONSTRAINT `fk_suppliers` FOREIGN KEY (`sid`) REFERENCES `suppliers` (`sid`),
  ADD CONSTRAINT `fk_transaction_food` FOREIGN KEY (`fid`) REFERENCES `fooditems` (`fid`),
  ADD CONSTRAINT `fk_transaction_suser` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
