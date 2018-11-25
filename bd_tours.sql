-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-11-2018 a las 16:59:34
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
  `telefono` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion`
--

CREATE TABLE `sesion` (
  `idTour` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `disponiblidad` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sesion`
--

INSERT INTO `sesion` (`idTour`, `fecha`, `disponiblidad`) VALUES
(1, '2018-11-21 21:00:00', 15),
(1, '2018-11-21 22:00:00', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesionguia`
--

CREATE TABLE `sesionguia` (
  `idGuia` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `idTour` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `ubicacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tour`
--

INSERT INTO `tour` (`idTour`, `nombre`, `descripcion`, `precio`, `duracion`, `ubicacion`) VALUES
(1, 'PRUEBA', 'LOREM IPSUM ASDASDADADA', 10000, '3horas', 1);

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
  ADD PRIMARY KEY (`idTour`,`fecha`);

--
-- Indices de la tabla `sesionguia`
--
ALTER TABLE `sesionguia`
  ADD PRIMARY KEY (`idGuia`,`fecha`,`idTour`),
  ADD KEY `fk_sesion_sesionGuia` (`idTour`,`fecha`);

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
  MODIFY `idGuia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tour`
--
ALTER TABLE `tour`
  MODIFY `idTour` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD CONSTRAINT `fk_tour_sesion` FOREIGN KEY (`idTour`) REFERENCES `tour` (`idTour`);

--
-- Filtros para la tabla `sesionguia`
--
ALTER TABLE `sesionguia`
  ADD CONSTRAINT `fk_guia_sesion` FOREIGN KEY (`idGuia`) REFERENCES `guia` (`idGuia`),
  ADD CONSTRAINT `fk_sesion_sesionGuia` FOREIGN KEY (`idTour`,`fecha`) REFERENCES `sesion` (`idTour`, `fecha`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
