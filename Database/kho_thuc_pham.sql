-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2024 at 05:30 PM
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
-- Table structure for table `inventory_transactions`
--

CREATE TABLE `inventory_transactions` (
  `transactionsid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `sid` int(11) NOT NULL,
  `transactions_type` char(11) NOT NULL,
  `transactions_quantity` int(11) NOT NULL,
  `transactions_note` varchar(255) DEFAULT NULL,
  `transactions_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inventory_transactions`
--

INSERT INTO `inventory_transactions` (`transactionsid`, `pid`, `uid`, `sid`, `transactions_type`, `transactions_quantity`, `transactions_note`, `transactions_date`) VALUES
(1, 1, 2, 1, 'Nhập', 200, 'Nhập thêm hàng từ nhà cung cấp Kamereo.', '2024-09-01'),
(2, 2, 3, 2, 'Nhập', 50, 'Nhập lô mì từ Công ty Hoàng Đông.', '2024-09-03'),
(3, 3, 4, 3, 'Nhập', 50, 'Nhập thịt bò từ Hanoifood.', '2024-09-05'),
(4, 4, 2, 4, 'Nhập', 100, 'Nhập gà tươi từ Hữu Nghị Food.', '2024-09-07'),
(5, 5, 3, 5, 'Nhập', 300, 'Nhập cà rốt từ Zin Food Việt Nam.', '2024-09-09'),
(6, 6, 4, 6, 'Nhập', 150, 'Nhập bí đỏ từ Organica.', '2024-09-11'),
(7, 7, 2, 1, 'Nhập', 20, 'Nhập cá hồi từ Kamereo.', '2024-09-13'),
(8, 8, 3, 2, 'Nhập', 30, 'Nhập tôm từ Công ty Hoàng Đông.', '2024-09-15'),
(9, 9, 4, 3, 'Nhập', 50, 'Nhập xoài từ Hanoifood.', '2024-09-17'),
(10, 10, 2, 5, 'Nhập', 40, 'Nhập nho từ Zin Food Việt Nam.', '2024-09-19'),
(11, 11, 3, 1, 'Nhập', 120, 'Nhập gạo nếp từ Kamereo.', '2024-09-21'),
(12, 12, 4, 4, 'Nhập', 300, 'Nhập bột mì từ Hữu Nghị Food.', '2024-09-23'),
(13, 13, 2, 3, 'Nhập', 80, 'Nhập thịt heo từ Hanoifood.', '2024-09-25'),
(14, 14, 3, 5, 'Nhập', 150, 'Nhập cánh gà từ Zin Food Việt Nam.', '2024-09-27'),
(15, 15, 4, 6, 'Nhập', 250, 'Nhập khoai từ Organica.', '2024-09-29'),
(16, 16, 2, 1, 'Nhập', 200, 'Nhập rau từ Kamereo.', '2024-10-01'),
(17, 17, 3, 2, 'Nhập', 40, 'Nhập mực tươi từ Công ty Hoàng Đông.', '2024-10-03'),
(18, 18, 4, 3, 'Nhập', 25, 'Nhập sò điệp từ Hanoifood.', '2024-10-05'),
(19, 19, 2, 5, 'Nhập', 60, 'Nhập táo từ Zin Food Việt Nam.', '2024-10-07'),
(20, 20, 3, 6, 'Nhập', 100, 'Nhập dưa từ Organica.', '2024-10-09');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `pid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `pname` varchar(255) NOT NULL,
  `pdescribe` varchar(255) DEFAULT NULL,
  `pprice` int(11) NOT NULL,
  `pquantity` int(11) NOT NULL,
  `pstatus` bit(1) NOT NULL DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`pid`, `cid`, `pname`, `pdescribe`, `pprice`, `pquantity`, `pstatus`) VALUES
(1, 1, 'Gạo thơm Jasmine', 'Gạo thơm Jasmine là loại gạo cao cấp, được sản xuất từ các ruộng lúa sạch, không sử dụng thuốc trừ sâu. Gạo có hạt dài, dẻo và thơm, rất thích hợp cho các bữa cơm gia đình.', 15000, 150, b'1'),
(2, 1, 'Mì gói Hảo Hảo', 'Mì gói Hảo Hảo là sản phẩm nổi tiếng với hương vị tôm chua cay. Mì được sản xuất từ nguyên liệu cao cấp, đảm bảo an toàn vệ sinh thực phẩm và có thời gian sử dụng lâu dài.', 3500, 100, b'1'),
(3, 2, 'Thịt bò Úc', 'Thịt bò Úc là loại thịt bò nhập khẩu, được nuôi trong môi trường tự nhiên, không chứa hormone tăng trưởng. Thịt bò mềm, ngọt và giàu protein, phù hợp cho các món nướng, xào.', 250000, 50, b'1'),
(4, 2, 'Thịt gà ta', 'Thịt gà ta được chăn nuôi theo phương pháp tự nhiên, thịt săn chắc, giàu protein và ít mỡ. Đây là loại thịt lý tưởng cho các món ăn truyền thống như gà kho, gà nướng.', 130000, 100, b'1'),
(5, 3, 'Cà rốt', 'Cà rốt là một loại rau củ sạch, có giá trị dinh dưỡng cao, chứa nhiều vitamin A và C. Cà rốt thích hợp để nấu các món hầm, súp hoặc ăn sống.', 20000, 300, b'1'),
(6, 3, 'Bí đỏ', 'Bí đỏ là loại rau củ chứa nhiều chất xơ và vitamin, giúp cải thiện sức khỏe tim mạch và tiêu hóa. Bí đỏ có thể chế biến thành nhiều món như súp, bánh hoặc xào.', 15000, 150, b'1'),
(7, 4, 'Cá hồi Na Uy', 'Cá hồi Na Uy là loại cá được đánh bắt từ vùng biển sạch, giàu omega-3 và vitamin D. Cá hồi có thịt mềm, ngọt, rất tốt cho sức khỏe, thích hợp làm sushi hoặc nướng.', 450000, 20, b'1'),
(8, 4, 'Tôm sú', 'Tôm sú là loại hải sản tươi sống, giàu protein và khoáng chất. Tôm sú thích hợp cho các món lẩu, nướng hoặc chiên giòn.', 300000, 30, b'1'),
(9, 5, 'Xoài cát Hòa Lộc', 'Xoài cát Hòa Lộc là loại trái cây nổi tiếng với hương vị ngọt ngào và thịt mềm, thích hợp ăn trực tiếp hoặc làm sinh tố. Xoài được trồng từ các vườn trái cây sạch.', 60000, 50, b'1'),
(10, 5, 'Nho Mỹ không hạt', 'Nho Mỹ không hạt là loại trái cây nhập khẩu từ Mỹ, có vị ngọt, hương thơm đặc biệt và rất giàu vitamin C. Nho Mỹ không hạt rất tiện lợi cho việc ăn trực tiếp hoặc làm salad.', 120000, 40, b'1'),
(11, 1, 'Gạo nếp cái hoa vàng', 'Gạo nếp cái hoa vàng là loại gạo nếp ngon, dẻo, thường được dùng để làm xôi, bánh chưng, bánh tét trong các dịp lễ tết.', 25000, 120, b'1'),
(12, 1, 'Bột mì đa dụng', 'Bột mì đa dụng là nguyên liệu cơ bản trong nấu ăn và làm bánh. Bột mì có thể được sử dụng để làm bánh mì, bánh ngọt, bánh quy và nhiều món ăn khác.', 12000, 300, b'1'),
(13, 2, 'Thịt heo ba chỉ', 'Thịt heo ba chỉ là phần thịt được yêu thích nhờ sự kết hợp hoàn hảo giữa mỡ và nạc. Thịt heo ba chỉ thích hợp để kho, nướng hoặc chiên.', 150000, 80, b'1'),
(14, 2, 'Cánh gà', 'Cánh gà tươi, được sử dụng trong nhiều món ăn như cánh gà chiên, nướng hoặc hấp. Cánh gà có thịt mềm, mỡ vừa đủ, ngon miệng và dễ chế biến.', 120000, 150, b'1'),
(15, 3, 'Khoai tây', 'Khoai tây là một loại củ phổ biến, chứa nhiều tinh bột và vitamin. Khoai tây có thể chế biến thành các món chiên, nghiền hoặc hầm.', 20000, 250, b'1'),
(16, 3, 'Cải bó xôi', 'Cải bó xôi (hay còn gọi là rau spinach) rất giàu vitamin A, C, sắt và canxi. Cải bó xôi có thể ăn sống trong salad hoặc chế biến thành các món xào, súp.', 30000, 200, b'1'),
(17, 4, 'Mực ống', 'Mực ống tươi, được đánh bắt từ biển, có thịt ngọt và dai. Mực ống thích hợp chế biến món chiên, nướng hoặc làm món mực xào.', 350000, 40, b'1'),
(18, 4, 'Sò điệp', 'Sò điệp tươi ngon, được thu hoạch từ các vùng biển sạch, thịt sò điệp ngọt và mềm. Sò điệp rất phù hợp để nướng, hấp hoặc xào.', 400000, 25, b'1'),
(19, 5, 'Táo Fuji', 'Táo Fuji là loại táo nhập khẩu từ Nhật Bản, có vị ngọt, giòn và rất ít chua. Táo Fuji chứa nhiều vitamin và chất chống oxy hóa.', 90000, 60, b'1'),
(20, 5, 'Dưa hấu không hạt', 'Dưa hấu không hạt tươi ngon, ngọt mát, được trồng trong các vườn dưa sạch, không có hạt. Dưa hấu rất thích hợp cho mùa hè, là món tráng miệng tuyệt vời.', 25000, 100, b'1');

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
  `stype` varchar(255) NOT NULL,
  `sstatus` bit(1) NOT NULL DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`sid`, `sname`, `semail`, `sphone`, `saddress`, `stype`, `sstatus`) VALUES
(1, 'Công ty TNHH Kamereo', 'kamereo@gmail.com', '081275374', 'Tầng 1 – Tòa nhà The Manor Officetel, số 89 đường Nguyễn Hữu Cảnh, Phường 22, quận Bình Thạnh, Thành phố Hồ Chí Minh', 'Nhà cung cấp', b'1'),
(2, 'Công ty TNHH Thực phẩm Hoàng Đông', 'tphoanhdong@gmail.com', '0214748367', '94 P. Trần Quý Cáp, phường Văn Chương, quận Đống Đa, Hà Nội.', 'Nhà cung cấp', b'1'),
(3, 'Công Ty Hanoifood', 'hanoifood@gmail.com', '0211456557', '84 Quán Thánh, quận Ba Đình, Hà Nội.', 'Nhà cung cấp', b'1'),
(4, 'Hữu Nghị Food', 'huunghifood@gmail.com', '0214741247', '122 Định Công, phường Định Công, quận Hoàng Mai, Hà Nội.', 'Nhà cung cấp', b'1'),
(5, 'Công ty Cổ phần Zin Food Việt Nam', 'zinfoodvn@gmail.com', '0214748364', 'TT10-39, KĐT Mới Văn Phú, phường Phú La, quận Hà Đông, Hà Nội.', 'Nhà cung cấp', b'1'),
(6, 'Công ty Cổ phần Đầu tư Organica', 'organica@gmail.com', '0901828681', '180 Nguyễn Thị Minh Khai, phường Võ Thị Sáu, Quận 3, TPHCM.', 'Nhà cung cấp', b'1'),
(7, 'Siêu thị CoopMart', 'coopmart@gmail.com', '0283838388', 'Chung Cư Mipec Riverside, TTTM, Số 2 Phố P. Long Biên 2, Ngọc Lâm, Long Biên, Hà Nội', 'Đại lý phân phối', b'1'),
(8, 'Siêu thị Tasco', 'tascomall@gmail.com', '0283939397', '7 9 Đ. Nguyễn Văn Linh, Gia Thụy, Long Biên, Hà Nội', 'Đại lý phân phối', b'1'),
(9, 'Siêu Thị WinMart', 'winmart@gmail.com', '0559701666', 'Số 38A P. Nguyễn Lân, Phương Liệt, Thanh Xuân, Hà Nội', 'Đại lý phân phối', b'1');

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
  `urole` enum('Admin','NV') NOT NULL,
  `ustatus` bit(5) NOT NULL DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`uid`, `uname`, `upassword`, `ufullname`, `uphone`, `urole`, `ustatus`) VALUES
(1, 'admin', '1', 'Quản lý', '096969696', 'Admin', b'00001'),
(2, 'nv01', '1', 'Lương Anh', '012345678', 'NV', b'00001'),
(3, 'nv02', '1', 'Nghĩa', '012456214', 'NV', b'00001'),
(4, 'nv03', '1', 'Việt', '055444335', 'NV', b'00001');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `inventory_transactions`
--
ALTER TABLE `inventory_transactions`
  ADD PRIMARY KEY (`transactionsid`),
  ADD KEY `fk_transaction_suser` (`uid`),
  ADD KEY `fk_transaction_food` (`pid`),
  ADD KEY `fk_suppliers` (`sid`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`pid`),
  ADD KEY `fk_fooditems_categories` (`cid`);

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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `inventory_transactions`
--
ALTER TABLE `inventory_transactions`
  MODIFY `transactionsid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `inventory_transactions`
--
ALTER TABLE `inventory_transactions`
  ADD CONSTRAINT `fk_suppliers` FOREIGN KEY (`sid`) REFERENCES `suppliers` (`sid`),
  ADD CONSTRAINT `fk_transaction_food` FOREIGN KEY (`pid`) REFERENCES `products` (`pid`),
  ADD CONSTRAINT `fk_transaction_suser` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `fk_fooditems_categories` FOREIGN KEY (`cid`) REFERENCES `categories` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
