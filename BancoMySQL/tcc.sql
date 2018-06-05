-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 05-Jun-2018 às 23:17
-- Versão do servidor: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tcc`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `patos`
--

CREATE TABLE `patos` (
  `idpato` int(10) UNSIGNED NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `descr` varchar(1500) DEFAULT NULL,
  `preco` int(10) DEFAULT NULL,
  `foto` varchar(45) DEFAULT NULL,
  `gif` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `patos`
--

INSERT INTO `patos` (`idpato`, `nome`, `descr`, `preco`, `foto`, `gif`) VALUES
(5, 'Pato', 'Pato ', 0, '/Arquivos/Pato.png', '/Arquivos/Patog.gif'),
(6, 'PatoPool', 'PatoPool', 1, '/Arquivos/PatoPool.png', '/Arquivos/PatoPoolg.gif'),
(8, 'MedPato', 'MedPato', 1, '/Arquivos/MedPato.png', '/Arquivos/MedPatog.gif'),
(9, 'RockStarPato', 'RockStarPato', 1, '/Arquivos/RockStarPato.png', '/Arquivos/RockStarPatog.gif'),
(10, 'Patudao', 'Patudao', 1, '/Arquivos/Patudao.png', '/Arquivos/Patudaog.gif');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuariopatos`
--

CREATE TABLE `usuariopatos` (
  `idusuariopato` int(10) UNSIGNED NOT NULL,
  `patoID` int(10) UNSIGNED NOT NULL,
  `usuarioID` int(10) UNSIGNED NOT NULL,
  `uso` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuariopatos`
--

INSERT INTO `usuariopatos` (`idusuariopato`, `patoID`, `usuarioID`, `uso`) VALUES
(5, 5, 9, 0),
(9, 9, 9, 0),
(10, 6, 9, 1),
(11, 5, 14, 0),
(12, 5, 14, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `idusuario` int(10) UNSIGNED NOT NULL,
  `nickname` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `senha` varchar(16) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `adm` tinyint(1) DEFAULT NULL,
  `moedas` int(10) DEFAULT NULL,
  `pontos` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`idusuario`, `nickname`, `login`, `senha`, `email`, `adm`, `moedas`, `pontos`) VALUES
(9, '7Bryssk', 'bonaky', '1010', 'bruninho.carvalho159@gmail.com', 0, 1238, 1820),
(10, 'gabe XD', 'gbcosta', 'jesus te ama', 'gbcosta8090@gmail.com', 0, 105, 210),
(12, 'ayzet', 'ana_mena', '1010', 'anacarolinamdf@live.com', 0, 0, 0),
(13, 'bonaky', '7Bryssk', '10010', 'bruno@email.com', 0, 0, 0),
(14, 'BGrook', 'Bruna', '1010', 'brunacarolinegesser1999@gmail.com', 0, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `patos`
--
ALTER TABLE `patos`
  ADD PRIMARY KEY (`idpato`);

--
-- Indexes for table `usuariopatos`
--
ALTER TABLE `usuariopatos`
  ADD PRIMARY KEY (`idusuariopato`),
  ADD KEY `fk_usuariopatos_patos_idx` (`patoID`),
  ADD KEY `fk_usuariopatos_usuarios1_idx` (`usuarioID`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idusuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `patos`
--
ALTER TABLE `patos`
  MODIFY `idpato` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `usuariopatos`
--
ALTER TABLE `usuariopatos`
  MODIFY `idusuariopato` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idusuario` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `usuariopatos`
--
ALTER TABLE `usuariopatos`
  ADD CONSTRAINT `fk_usuariopatos_patos` FOREIGN KEY (`patoID`) REFERENCES `patos` (`idpato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuariopatos_usuarios1` FOREIGN KEY (`usuarioID`) REFERENCES `usuarios` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
