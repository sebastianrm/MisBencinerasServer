CREATE TABLE `trxuser` (
  `bencina` varchar(100) NOT NULL,
  `empresa` varchar(100) NOT NULL,
  `latBencinera` float NOT NULL,
  `longBencinera` float NOT NULL,
  `key` varchar(100) NOT NULL,
  `latUser` float NOT NULL,
  `longUser` float NOT NULL,
  `fecha_hora_consulta` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`fecha_hora_consulta`,`longUser`,`latUser`,`key`,`empresa`,`bencina`,`latBencinera`,`longBencinera`)
) ENGINE=InnoDB;