-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-09-2020 a las 17:51:14
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `catrea`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aspirantes`
--

CREATE TABLE `aspirantes` (
  `id_aspirante` int(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `dni` varchar(30) NOT NULL,
  `estadocivil` varchar(20) NOT NULL,
  `nivelestudio` varchar(30) NOT NULL,
  `localidad` varchar(30) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `mail` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aspirantes`
--

INSERT INTO `aspirantes` (`id_aspirante`, `nombre`, `apellido`, `dni`, `estadocivil`, `nivelestudio`, `localidad`, `telefono`, `mail`) VALUES
(25, 'Ariel', 'Riscica', '39185121', 'soltero', 'secundarioCompleto', 'CABA', '1155336699', 'arielriscica@gmail.com'),
(26, 'Ana', 'Lopez', '33456896', 'casado', 'secundarioIncompleto', 'CABA', '1163635656', 'analopez@gmail.com'),
(27, 'Mara', 'Cabrera', '43082123', 'soltero', 'secundarioCompleto', 'CABA', '1199554411', 'maracabrera@gmail.com'),
(28, 'Diego', 'Aranda', '40555666', 'soltero', 'secundarioIncompleto', 'Merlo', '1175459572', 'diegomerlo@gmail.com'),
(29, 'Florencia', 'Malhamud', '41235687', 'soltero', 'secundarioCompleto', 'CABA', '1145632588', 'florenciamalhamud@gmail.com'),
(30, 'Roman', 'Toledo', '42123236', 'soltero', 'secundarioIncompleto', 'Moron', '1189562321', 'romantoledo@gmail.com'),
(31, 'Roque', 'Gonzalez', '43555666', 'soltero', 'secundarioCompleto', 'Ciudadela', '1135689471', 'roquegonzalez@gmail.com'),
(32, 'Abel ', 'Leis', '42222333', 'soltero', 'secundarioIncompleto', 'CABA', '1144556677', 'rodrigoleis@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carreras`
--

CREATE TABLE `carreras` (
  `id_carrera` int(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `duracion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `carreras`
--

INSERT INTO `carreras` (`id_carrera`, `nombre`, `duracion`) VALUES
(8, 'soldado voluntario', '10'),
(9, 'suboficial', '2'),
(10, 'oficial', '4');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `operadores`
--

CREATE TABLE `operadores` (
  `dni` int(20) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `contrasenia` varchar(30) NOT NULL,
  `mail_operador` varchar(100) NOT NULL,
  `rol` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `operadores`
--

INSERT INTO `operadores` (`dni`, `nombre`, `apellido`, `contrasenia`, `mail_operador`, `rol`) VALUES
(12345678, 'Administrador', 'Administrador', 'administrador', 's.i.l.v.i.n.a.xiii@gmail.com', 'administrador'),
(22425636, 'silvina', 'paez', 'sil13', 'almabru1310@gmail.com', 'operador'),
(33240752, 'juan', 'rivera', 'Espinosa', 'juanm2587@gmail.com', 'operador'),
(33391222, 'estefania', 'ucedo', 'Espinosa', 'ucedoestefi@gmail.com ', 'operador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preinscripciones`
--

CREATE TABLE `preinscripciones` (
  `id_preinscripcion` int(20) NOT NULL,
  `fecha` date NOT NULL,
  `id_carrera` int(20) NOT NULL,
  `id_operador` int(20) NOT NULL,
  `id_aspirante` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `preinscripciones`
--

INSERT INTO `preinscripciones` (`id_preinscripcion`, `fecha`, `id_carrera`, `id_operador`, `id_aspirante`) VALUES
(10, '2020-09-09', 10, 22425636, 25),
(11, '2020-09-09', 8, 22425636, 26),
(12, '2020-09-10', 10, 22425636, 27),
(13, '2020-09-10', 9, 22425636, 28),
(14, '2020-09-10', 9, 22425636, 29),
(15, '2020-09-10', 8, 22425636, 30),
(16, '2020-09-10', 10, 22425636, 31),
(17, '2020-09-10', 8, 22425636, 32);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aspirantes`
--
ALTER TABLE `aspirantes`
  ADD PRIMARY KEY (`id_aspirante`),
  ADD UNIQUE KEY `id_postulante` (`id_aspirante`),
  ADD UNIQUE KEY `id_postulante_2` (`id_aspirante`),
  ADD UNIQUE KEY `id_postulante_3` (`id_aspirante`);

--
-- Indices de la tabla `carreras`
--
ALTER TABLE `carreras`
  ADD PRIMARY KEY (`id_carrera`);

--
-- Indices de la tabla `operadores`
--
ALTER TABLE `operadores`
  ADD PRIMARY KEY (`dni`) USING BTREE;

--
-- Indices de la tabla `preinscripciones`
--
ALTER TABLE `preinscripciones`
  ADD PRIMARY KEY (`id_preinscripcion`),
  ADD KEY `id_carrera` (`id_carrera`),
  ADD KEY `id_operador` (`id_operador`),
  ADD KEY `id_aspirante` (`id_aspirante`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aspirantes`
--
ALTER TABLE `aspirantes`
  MODIFY `id_aspirante` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `carreras`
--
ALTER TABLE `carreras`
  MODIFY `id_carrera` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `preinscripciones`
--
ALTER TABLE `preinscripciones`
  MODIFY `id_preinscripcion` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `preinscripciones`
--
ALTER TABLE `preinscripciones`
  ADD CONSTRAINT `preinscripciones_ibfk_1` FOREIGN KEY (`id_aspirante`) REFERENCES `aspirantes` (`id_aspirante`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
