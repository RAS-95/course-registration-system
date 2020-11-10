-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 10, 2020 at 02:51 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `course_registration_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `course_info`
--

CREATE TABLE `course_info` (
  `id` int(11) NOT NULL,
  `code` text NOT NULL,
  `description` text NOT NULL,
  `credit` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course_info`
--

INSERT INTO `course_info` (`id`, `code`, `description`, `credit`) VALUES
(1, 'CSE 1100', 'Computer Fundamentals and Ethics ', 1.5),
(2, 'CSE 1101', 'Computer Programming', 3),
(3, 'CSE 1102', 'Sessional Based on CSE 1101 ', 1.5),
(4, 'EEE 1151', 'Basic Electrical Engineering', 3),
(5, 'EEE 1152', 'Sessional Based on EEE 1151 ', 0.75),
(6, 'Math 1113', 'Differential and Integral Calculus ', 3),
(7, 'Hum 1113', 'Functional English', 3),
(8, 'Hum 1114', 'English Language Lab', 1.5),
(9, 'Chem 1113', 'Inorganic and Physical Chemistry', 3),
(10, 'Chem 1114', 'Sessional Based on Chem 1113 ', 0.75),
(11, 'CSE 1200', 'Analytical Programming', 0.75),
(12, 'CSE 1201', 'Data Structure', 3),
(13, 'CSE 1202', 'Sessional Based on CSE 1201 ', 1.5),
(14, 'CSE 1203', 'Object Oriented Programming ', 3),
(15, 'CSE 1204', 'Sessional Based on CSE 1203 ', 1.5),
(16, 'Math 1213', 'Co-ordinate Geometry and Ordinary Differential Equation', 3),
(17, 'Hum 1213', 'Economics, Government and Sociology ', 3),
(18, 'Phy 1213', 'Physics', 3),
(19, 'Phy 1214', 'Sessional Based on Phy 1213', 1.5),
(20, 'CSE 2100', 'Software Development Project I', 0.75),
(21, 'CSE 2101', 'Discrete Mathematics', 3),
(22, 'CSE 2102', 'Sessional Based on CSE 2101 ', 1.5),
(23, 'CSE 2103', 'Numerical Methods', 3),
(24, 'CSE 2104 ', 'Sessional Based on CSE 2103 ', 1.5),
(25, 'EEE 2151 ', 'Analog Electronics', 3),
(26, 'EEE 2152', 'Sessional Based on EEE 2151 ', 1.5),
(27, 'Math 2113', 'Vector Analysis and Linear Algebra ', 3),
(28, 'Hum 2113 ', 'Industrial Management and Accountancy', 3),
(29, 'CSE 2201', 'Computer Algorithms', 3),
(30, 'CSE 2202', 'Sessional Based on CSE 2201 ', 1.5),
(31, 'CSE 2203', 'Digital Techniques', 3),
(32, 'CSE 2204', 'Sessional Based on CSE 2203 ', 1.5),
(33, 'CSE 2205', 'Finite Automata Theory', 3),
(34, 'CSE 2206', 'Sessional Based on CSE 2205 ', 0.75),
(35, 'EEE 2251 ', 'Electrical Machines and Instrumentations ', 3),
(36, 'EEE 2252 ', 'Sessional Based on EEE 2251 ', 0.75),
(37, 'Math 2213', 'Complex Variable Differential Equations and Harmonic Analysis ', 3),
(38, 'CSE 3100', 'Web Based Application Lab/Project', 0.75),
(39, 'CSE 3101', 'Database Systems', 3),
(40, 'CSE 3102', 'Sessional Based on CSE 3101 ', 1.5),
(41, 'CSE 3103', 'Data Communication', 3),
(42, 'CSE 3104', 'Sessional Based on CSE 3103 ', 0.75),
(43, 'CSE 3105', 'Software Engineering', 3),
(44, 'CSE 3107', 'Applied Statistics and Queuing Theory', 3),
(45, 'CSE 3109', 'Microprocessors and Assembly Language ', 3),
(46, 'CSE 3110', 'Sessional Based on CSE 3109 ', 1.5),
(47, 'CSE 3112', 'Technical Writing and Presentation ', 0.75),
(48, 'CSE 3200', 'Software Development Project II ', 0.75),
(49, 'CSE 3201', 'Operating Systems', 3),
(50, 'CSE 3202', 'Sessional Based on CSE 3201 ', 0.75),
(51, 'CSE 3203', 'Computer Architecture and Design ', 3),
(52, 'CSE 3205', 'Computer Networks', 3),
(53, 'CSE 3206', 'Sessional Based on CSE 3205', 1.5),
(54, 'CSE 3207', 'Peripherals and Interfacings', 3),
(55, 'CSE 3208', 'Sessional Based on CSE 3207', 0.75),
(56, 'CSE 3209', 'Artificial Intelligence ', 3),
(57, 'CSE 3210', 'Sessional Based on CSE 3209 ', 0.75);

-- --------------------------------------------------------

--
-- Table structure for table `enrolled_info`
--

CREATE TABLE `enrolled_info` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `enrolled_info`
--

INSERT INTO `enrolled_info` (`id`, `user_id`, `course_id`) VALUES
(1, 2, 1),
(2, 2, 1),
(3, 2, 6);

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE `user_info` (
  `id` int(11) NOT NULL,
  `username` text NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `roll` int(11) NOT NULL,
  `role` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`id`, `username`, `email`, `password`, `roll`, `role`) VALUES
(2, 'songram', 'dsf', '12345', 1803100, 'student');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course_info`
--
ALTER TABLE `course_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `enrolled_info`
--
ALTER TABLE `enrolled_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course_info`
--
ALTER TABLE `course_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT for table `enrolled_info`
--
ALTER TABLE `enrolled_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user_info`
--
ALTER TABLE `user_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
