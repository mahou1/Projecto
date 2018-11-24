-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-11-2018 a las 21:46:29
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
-- Base de datos: `bd_tours`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `guia`
--

CREATE TABLE `guia` (
  `idGuia` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `guia`
--

INSERT INTO `guia` (`idGuia`, `nombre`, `telefono`, `deleted_at`) VALUES
(1, 'EDSON', '6666777', NULL),
(3, 'Pablo', '89988998', NULL),
(4, 'JONY', '12345678', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion`
--

CREATE TABLE `sesion` (
  `idTour` int(11) NOT NULL,
  `fecha` varchar(8) NOT NULL,
  `disponibilidad` tinyint(4) NOT NULL,
  `idGuia` int(11) NOT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sesion`
--

INSERT INTO `sesion` (`idTour`, `fecha`, `disponibilidad`, `idGuia`, `deleted_at`) VALUES
(1, '2018-11-', 14, 1, NULL),
(2, '22-22-22', 12, 4, NULL),
(3, '21-12-12', 12, 1, NULL),
(4, '21-23-12', 45, 1, NULL),
(5, '10-21-18', 23, 3, NULL),
(6, '10-21-18', 23, 3, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tour`
--

CREATE TABLE `tour` (
  `idTour` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` text NOT NULL,
  `precio` int(11) NOT NULL,
  `duracion` varchar(10) NOT NULL,
  `ubicacion` int(11) NOT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tour`
--

INSERT INTO `tour` (`idTour`, `nombre`, `descripcion`, `precio`, `duracion`, `ubicacion`, `deleted_at`) VALUES
(1, 'AAAAA', 'RRRRRRRR', 22222, '3', 12, NULL),
(2, 'BBBBBBB', 'RRRRRRRR', 22222, '3 HORAS', 12, '2018-11-23 20:55:28'),
(3, 'CCCCCCC', 'RRRRRRRR', 22222, '3 HORAS', 12, NULL),
(4, 'DDDDDDDD', 'RRRRRRRR', 22222, '3 HORAS', 12, NULL),
(5, 'aaaasdsad', 'RRRRRRRR', 22222, '3 HORAS', 12, '2018-11-23 20:26:58'),
(6, 'FFFFF', 'QWEERQWEQWWE', 2222, '2', 2, NULL),
(7, 'PRUEBA 2', 'aaaaaaaaaaaaaaaaaaaaa', 66666, '2 Horas', 1, NULL);

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
  ADD KEY `fk_sesion_guia` (`idGuia`);

--
-- Indices de la tabla `tour`
--
ALTER TABLE `tour`
  ADD PRIMARY KEY (`idTour`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `guia`
--
ALTER TABLE `guia`
  MODIFY `idGuia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tour`
--
ALTER TABLE `tour`
  MODIFY `idTour` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD CONSTRAINT `fk_sesion_guia` FOREIGN KEY (`idGuia`) REFERENCES `guia` (`idGuia`),
  ADD CONSTRAINT `fk_tour_sesion` FOREIGN KEY (`idTour`) REFERENCES `tour` (`idTour`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
