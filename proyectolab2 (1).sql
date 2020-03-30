-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-03-2020 a las 09:29:25
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectolab2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `centro`
--

CREATE TABLE `centro` (
  `id_centro` int(11) NOT NULL,
  `ciudad` varchar(255) NOT NULL,
  `direccion_centro` varchar(255) NOT NULL,
  `nombre_centro` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `centro`
--

INSERT INTO `centro` (`id_centro`, `ciudad`, `direccion_centro`, `nombre_centro`) VALUES
(1, 'Santiago', 'Diego Portales 350', 'Centro Diego Portales'),
(2, 'Temuco', 'Rudencindo Ortega 234', 'Centro Victor Jara');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equiporov`
--

CREATE TABLE `equiporov` (
  `id_equipo_rov` int(11) NOT NULL,
  `ano_ingreso` date NOT NULL,
  `estado` varchar(255) NOT NULL,
  `tipo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `equiporov`
--

INSERT INTO `equiporov` (`id_equipo_rov`, `ano_ingreso`, `estado`, `tipo`) VALUES
(1, '2020-03-06', 'Mantencion', 'Terrestre'),
(2, '2020-03-14', 'Inactivo', 'Aereo'),
(3, '2020-03-18', 'Activo', 'Terrestre');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mantencionequiporov`
--

CREATE TABLE `mantencionequiporov` (
  `equipo_rovid_equipo_rov` int(11) NOT NULL,
  `usuario_id_usuario` int(11) NOT NULL,
  `usuario_rut` varchar(255) NOT NULL,
  `detalle_mantencion` varchar(255) NOT NULL,
  `fecha_mantencion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `mantencionequiporov`
--

INSERT INTO `mantencionequiporov` (`equipo_rovid_equipo_rov`, `usuario_id_usuario`, `usuario_rut`, `detalle_mantencion`, `fecha_mantencion`) VALUES
(1, 0, '191111111', 'Helice Rota', '2020-03-11');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

CREATE TABLE `mensaje` (
  `id_mensaje` int(11) NOT NULL,
  `cuerpo` varchar(255) NOT NULL,
  `id_recceptor` int(11) NOT NULL,
  `usuario_id_usuario` int(11) NOT NULL,
  `usuario_rut` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productoinventario`
--

CREATE TABLE `productoinventario` (
  `id_producto` int(11) NOT NULL,
  `cantidad_producto` int(11) NOT NULL,
  `depto_id_depto` int(11) NOT NULL,
  `detalle_producto` varchar(255) NOT NULL,
  `imagen_producto` varchar(255) DEFAULT NULL,
  `nombre_producto` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productoinventario`
--

INSERT INTO `productoinventario` (`id_producto`, `cantidad_producto`, `depto_id_depto`, `detalle_producto`, `imagen_producto`, `nombre_producto`) VALUES
(1, 100, 1, 'Resmas para utilizar en Documentos', NULL, 'Resma Hojas oficio'),
(2, 20, 2, 'Para poder intervenir los equipos', NULL, 'Alicate'),
(3, 10, 3, 'Para proteger la integridad del piloto', NULL, 'Gafas de seguridad');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `rut` varchar(9) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  `contrato` varchar(255) NOT NULL,
  `depto_id_depto` int(11) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `fecha_contrato` date DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `prevision` varchar(255) NOT NULL,
  `salario` int(11) NOT NULL,
  `telefono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`rut`, `apellido`, `contrasena`, `contrato`, `depto_id_depto`, `direccion`, `fecha_contrato`, `nombre`, `prevision`, `salario`, `telefono`) VALUES
('191111111', 'Benz', '191111111', 'Indefinido', 2, '520 Calle Ufro', '2020-03-14', 'Ignacio', 'Isapre', 1000000, 99887744),
('192222222', 'Vergara', '192222222', 'Indefinido', 3, '1234 Ufro', '2020-03-07', 'Javiera ', 'Fonasa', 500000, 33665544),
('192318637', 'Chavez', '192318637', 'Indefinido', 1, 'Portales 351 Temuco', '2020-02-10', 'Rodrigo', 'Isapre', 1600000, 93887744);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `centro`
--
ALTER TABLE `centro`
  ADD PRIMARY KEY (`id_centro`);

--
-- Indices de la tabla `equiporov`
--
ALTER TABLE `equiporov`
  ADD PRIMARY KEY (`id_equipo_rov`);

--
-- Indices de la tabla `mantencionequiporov`
--
ALTER TABLE `mantencionequiporov`
  ADD PRIMARY KEY (`equipo_rovid_equipo_rov`,`usuario_id_usuario`,`usuario_rut`),
  ADD KEY `FKnw0iiiilqeesakd94ih4jpenc` (`usuario_rut`);

--
-- Indices de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD PRIMARY KEY (`id_mensaje`),
  ADD KEY `FKeod3vqds26ie2pt9lnbq7uner` (`usuario_rut`);

--
-- Indices de la tabla `productoinventario`
--
ALTER TABLE `productoinventario`
  ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`rut`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `centro`
--
ALTER TABLE `centro`
  MODIFY `id_centro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `equiporov`
--
ALTER TABLE `equiporov`
  MODIFY `id_equipo_rov` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  MODIFY `id_mensaje` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productoinventario`
--
ALTER TABLE `productoinventario`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `mantencionequiporov`
--
ALTER TABLE `mantencionequiporov`
  ADD CONSTRAINT `FKe4tp1naw5gbot2ig52nyqblgh` FOREIGN KEY (`equipo_rovid_equipo_rov`) REFERENCES `equiporov` (`id_equipo_rov`),
  ADD CONSTRAINT `FKnw0iiiilqeesakd94ih4jpenc` FOREIGN KEY (`usuario_rut`) REFERENCES `usuario` (`rut`);

--
-- Filtros para la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD CONSTRAINT `FKeod3vqds26ie2pt9lnbq7uner` FOREIGN KEY (`usuario_rut`) REFERENCES `usuario` (`rut`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
