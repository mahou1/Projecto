-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-11-2018 a las 19:55:44
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mydb`
--
CREATE DATABASE IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `mydb`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `guia`
--

CREATE TABLE `guia` (
  `idGuia` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `guia`
--

INSERT INTO `guia` (`idGuia`, `nombre`, `telefono`, `deleted_at`) VALUES
(1, 'Pablo', '222222', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion`
--

CREATE TABLE `sesion` (
  `idTour` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `disponibilidad` tinyint(4) NOT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `idGuia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sesion`
--

INSERT INTO `sesion` (`idTour`, `fecha`, `disponibilidad`, `deleted_at`, `idGuia`) VALUES
(1, '2018-09-21', 0, NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tour`
--

CREATE TABLE `tour` (
  `idTour` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` text,
  `precio` int(11) NOT NULL,
  `duracion` varchar(10) NOT NULL,
  `ubicacion` varchar(45) NOT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tour`
--

INSERT INTO `tour` (`idTour`, `nombre`, `descripcion`, `precio`, `duracion`, `ubicacion`, `deleted_at`) VALUES
(1, 'ValpoTour', 'asdadsa', 1200, '20 minutos', 'valpo', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL,
  `fechaVenta` date NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `rut` varchar(10) NOT NULL,
  `idTour` int(11) NOT NULL,
  `fechaSesion` date NOT NULL,
  `cantidad` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`idVenta`, `fechaVenta`, `nombre`, `telefono`, `rut`, `idTour`, `fechaSesion`, `cantidad`) VALUES
(11, '2018-11-26', 'aa', 'aaaa', '1211', 1, '2018-09-21', 5),
(12, '2018-11-26', 'aaaa', '1111', '222', 1, '2018-09-21', 5),
(13, '2018-11-26', 'bbbb', '11122', '444', 1, '2018-09-21', 10);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `guia`
--
ALTER TABLE `guia`
  ADD PRIMARY KEY (`idGuia`);

--
-- Indices de la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD PRIMARY KEY (`idTour`,`fecha`),
  ADD KEY `fk_sesion_guia1_idx` (`idGuia`);

--
-- Indices de la tabla `tour`
--
ALTER TABLE `tour`
  ADD PRIMARY KEY (`idTour`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`idVenta`,`idTour`,`fechaSesion`),
  ADD KEY `fk_venta_sesion1_idx` (`idTour`,`fechaSesion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `guia`
--
ALTER TABLE `guia`
  MODIFY `idGuia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tour`
--
ALTER TABLE `tour`
  MODIFY `idTour` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD CONSTRAINT `fk_sesion_guia1` FOREIGN KEY (`idGuia`) REFERENCES `guia` (`idGuia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_table1_Tour1` FOREIGN KEY (`idTour`) REFERENCES `tour` (`idTour`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `fk_venta_sesion1` FOREIGN KEY (`idTour`,`fechaSesion`) REFERENCES `sesion` (`idTour`, `fecha`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
