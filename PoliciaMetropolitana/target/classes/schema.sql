
--
-- Estructura de tabla para la tabla `asalto`
--

CREATE TABLE `asalto` (
  `id` int(11) NOT NULL,
  `clave_detenido` int(11) NOT NULL,
  `condena` varchar(255) DEFAULT NULL,
  `condenado` bit(1) NOT NULL,
  `fecha_asalto` date NOT NULL,
  `juez_encargado` int(11) NOT NULL,
  `sucursal_asalto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `banda_organizada`
--

CREATE TABLE `banda_organizada` (
  `nro_banda` int(11) NOT NULL,
  `cant_miembros` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contratacion`
--

CREATE TABLE `contratacion` (
  `id` int(11) NOT NULL,
  `cod_sucursal` int(11) NOT NULL,
  `cod_vigilante` int(11) NOT NULL,
  `con_arma` bit(1) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detenido`
--

CREATE TABLE `detenido` (
  `clave` int(11) NOT NULL,
  `banda_pertenece` int(11) NOT NULL,
  `nombre_completo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entidad_bancaria`
--

CREATE TABLE `entidad_bancaria` (
  `codigo` int(11) NOT NULL,
  `domicilio_central` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juez`
--

CREATE TABLE `juez` (
  `clave_juzgado` int(11) NOT NULL,
  `anos_servicio` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal_bancaria`
--

CREATE TABLE `sucursal_bancaria` (
  `codigo` int(11) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `entidad_central` int(11) NOT NULL,
  `nro_empleados` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `role`
--
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `user_id` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vigilantes`
--

CREATE TABLE `vigilantes` (
  `edad` bigint(20) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asalto`
--
ALTER TABLE `asalto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `banda_organizada`
--
ALTER TABLE `banda_organizada`
  ADD PRIMARY KEY (`nro_banda`);

--
-- Indices de la tabla `contratacion`
--
ALTER TABLE `contratacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `detenido`
--
ALTER TABLE `detenido`
  ADD PRIMARY KEY (`clave`);

--
-- Indices de la tabla `entidad_bancaria`
--
ALTER TABLE `entidad_bancaria`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `juez`
--
ALTER TABLE `juez`
  ADD PRIMARY KEY (`clave_juzgado`);

--
-- Indices de la tabla `sucursal_bancaria`
--
ALTER TABLE `sucursal_bancaria`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indices de la tabla `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `UK_it77eq964jhfqtu54081ebtio` (`role_id`) USING BTREE;

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`user_id`);

--
-- Indices de la tabla `vigilantes`
--
ALTER TABLE `vigilantes`
  ADD PRIMARY KEY (`user_id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  ADD CONSTRAINT `FKdb77ocp4vrjv2qx01rjf35iuy` FOREIGN KEY (`user_id`) REFERENCES `usuarios` (`user_id`);

--
-- Filtros para la tabla `vigilantes`
--
ALTER TABLE `vigilantes`
  ADD CONSTRAINT `FKsweqt1qomh0u7mxdc30tm6mxx` FOREIGN KEY (`user_id`) REFERENCES `usuarios` (`user_id`);
COMMIT;

