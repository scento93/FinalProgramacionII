INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'ADMIN'),
(2, 'INVESTIGADOR'),
(3, 'VIGILANTE');

INSERT INTO `usuarios` (`user_id`, `password`, `tipo`) VALUES
(1, '123', 'administrador'),
(2, '123', 'investigador'),
(3, '123', 'vigilante'),
(321, '123', 'investigador'),
(750, 'perez', 'vigilante'),
(1111, '123', 'administrador'),
(1313, 'vigilante', 'vigilante'),
(2222, '123', 'investigador'),
(3131, 'vigilante', 'vigilante'),
(3333, '123', 'vigilante'),
(4321, '123', 'administrador'),
(4444, '123', 'vigilante'),
(5555, '123', 'administrador');

INSERT INTO `vigilantes` (`edad`, `user_id`) VALUES
(32, 3),
(55, 750),
(54, 1313),
(34, 3131),
(25, 3333),
(23, 4444);

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 3),
(321, 2),
(750, 3),
(1111, 1),
(1111, 2),
(1313, 3),
(2222, 2),
(3131, 3),
(3333, 3),
(4321, 1),
(4321, 2),
(4444, 3),
(5555, 1),
(5555, 2);

INSERT INTO `banda_organizada` (`nro_banda`, `cant_miembros`) VALUES
(100, 45),
(200, 346),
(300, 154),
(400, 75),
(500, 65);

INSERT INTO `detenido` (`clave`, `banda_pertenece`, `nombre_completo`) VALUES
(12, 300, 'Jesus Fernandez'),
(34, 100, 'Manuel Gonzalez'),
(66, 400, 'Angel Moreno'),
(245, 400, 'Jose Martinez'),
(346, 500, 'Antonio Garcia'),
(354, 400, 'Carmen Moreno'),
(543, 200, 'Pedro Gomez');

INSERT INTO `entidad_bancaria` (`codigo`, `domicilio_central`) VALUES
(1, 'Corrientes 300'),
(10, 'Uruguay 400'),
(35, 'Independencia 702'),
(54, '9 de Julio 1460'),
(88, 'Rivadavia 236');

INSERT INTO `juez` (`clave_juzgado`, `anos_servicio`, `nombre`) VALUES
(35, 35, 'Hipolito Gomez'),
(65, 53, 'Romulo Perez'),
(67, 43, 'Benjamin Esposito'),
(74, 29, 'Geronimo Varela'),
(98, 24, 'Leandro Hernandez');

INSERT INTO `sucursal_bancaria` (`codigo`, `direccion`, `entidad_central`, `nro_empleados`) VALUES
(67, 'Nicaragua 2503', 1, 63),
(85, 'Junin 657', 35, 126),
(235, 'Azcuenaga 536', 35, 75),
(325, 'Peru 523', 1, 43),
(457, 'Olazabal 5631', 54, 97),
(754, '25 de Mayo 634', 54, 65),
(857, 'Triunvirato 4474', 88, 283),
(963, 'Niceto Vega 6342', 10, 40),
(2756, 'Juncal 346', 88, 324),
(3465, 'San juan 1200', 10, 623);

INSERT INTO `contratacion` (`id`, `cod_sucursal`, `cod_vigilante`, `con_arma`, `fecha`) VALUES
(1, 325, 3131, TRUE, '2019-01-10'),
(2, 857, 3, TRUE, '2019-02-28'),
(3, 754, 750, FALSE, '2019-02-14'),
(4, 963, 4444, TRUE, '2019-03-01'),
(5, 2756, 1313, FALSE, '2019-03-01'),
(6, 457, 3333, FALSE, '2019-03-02'),
(7, 3465, 3131, TRUE, '2019-03-05'),
(8, 67, 4444, FALSE, '2019-03-06'),
(9, 85, 3131, FALSE, '2019-03-02'),
(10, 857, 3131, TRUE, '2019-03-02'),
(11, 857, 3, TRUE, '2019-03-04'),
(12, 67, 750, FALSE, '2019-02-22');

INSERT INTO `asalto` (`id`, `clave_detenido`, `condena`, `condenado`, `fecha_asalto`, `juez_encargado`, `sucursal_asalto`) VALUES
(13, 346, '45 meses', TRUE, '2019-03-02', 74, 235),
(14, 245, '10 meses',TRUE, '2019-03-03', 74, 457),
(15, 346, '', FALSE, '2019-03-01', 98, 963),
(16, 354, '', FALSE, '2019-02-14', 65, 2756),
(17, 66, '56 meses', TRUE, '2019-03-19', 74, 85),
(18, 354, '', FALSE, '2019-01-31', 74, 963),
(19, 34, '', FALSE, '2019-03-05', 67, 857),
(20, 245, '24 meses', TRUE, '2019-01-25', 67, 754),
(21, 245, '12 meses',TRUE, '2019-02-20', 67, 325);
