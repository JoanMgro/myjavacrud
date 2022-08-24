DROP DATABASE IF EXISTS ecodosruedas;
CREATE DATABASE IF NOT EXISTS ecodosruedas;

USE ecodosruedas;

CREATE TABLE fabricantes (
id_fabricante VARCHAR(25) PRIMARY KEY NOT NULL,
producto VARCHAR(25)
);

INSERT INTO fabricantes (id_fabricante, producto)
VALUES ("Cannondale", "Bicicleta"),
("Trek", "Bicicleta"),
("Yeti", "Bicicleta"),
("Fuji", "Bicicleta"),
("Bmc", "Bicicleta"),
("Starker", "Moto Electrica"),
("Lucky Lion", "Moto Electrica"),
("Be Electric", "Moto Electrica"),
("Aima", "Moto Electrica"),
("Mec de Colombia", "Moto Electrica"),
("Atom Electric", "Moto Electrica");

CREATE TABLE bicicletas (
id_bici INT PRIMARY KEY NOT NULL,
fabricante VARCHAR(25),
precio INT,
anio INT,
FOREIGN KEY (fabricante) REFERENCES fabricantes (id_fabricante)
);

INSERT INTO bicicletas (id_bici, fabricante, precio, anio)
VALUES (101, "Cannondale", 1200000, 2020),
(102, "Trek", 1450000, 2019),
(103, "Yeti", 2000000, 2020),
(104, "Fuji", 950000, 2021),
(105, "Bmc", 1950000, 2018);

CREATE TABLE prov_motores(
id_prov_motor VARCHAR(25) PRIMARY KEY NOT NULL,
direccion VARCHAR(50),
telefono VARCHAR(25)
);
INSERT INTO prov_motores (id_prov_motor, direccion, telefono)
VALUES ("Auteco", "calle 7 No. 45-17", "05713224459"),
("Hitachi", "calle 19 No. 108-26", "05714223344"),
("Bosch", "carrera 68 No. 26-45", "05715678798"),
("Teco", "calle 19 No. 108-26", "05714223344"),
("General Electric", "calle 29 No. 26-12", "05717239919");


CREATE TABLE motocicletas_electricas(
id_moto INT PRIMARY KEY NOT NULL,
fabricante VARCHAR(25),
precio INT,
autonomia VARCHAR(10),
prov_motor VARCHAR(25),
FOREIGN KEY (prov_motor) REFERENCES prov_motores (id_prov_motor),
FOREIGN KEY (fabricante) REFERENCES fabricantes (id_fabricante)
);

INSERT INTO motocicletas_electricas (id_moto, fabricante, precio, autonomia, prov_motor)
VALUES (201, "Starker", 4200000, "18 horas", "Auteco"),
(202, "Lucky Lion", 5600000, "14 horas", "Hitachi"),
(203, "Be Electric", 4600000, "26 horas", "Auteco"),
(204, "Aima", 8000000, "36 horas", "Bosch"),
(205, "Mec de Colombia", 5900000, "20 horas", "Teco"),
(206, "Atom Electric", 4500000, "12 horas", "General Electric");

CREATE TABLE clientes(
id_alias VARCHAR(25) primary key NOT NULL,
nombres VARCHAR(25),
apellidos VARCHAR(25),
email VARCHAR(25),
celular VARCHAR(25),
contrasena INT,
fecha_nac DATE
);

INSERT INTO clientes(id_alias, nombres, apellidos, email, celular, contrasena, fecha_nac)
VALUES ("lucky", "Pedro", "Perez", "pperez@mintic.com", "3127890978", 12345678, '2000-06-11'),
("malopez", "Maria", "Lopez", "mlopez@mintic.com", "3127890975", 12345698, '1993-08-12'),
("diva", "Ana", "Diaz", "adiaz@mintic.com", "3127856978", 12347378, '1985-02-05'),
("dreamer", "Luis", "Rojas", "lrojas@mintic.com", "3157690978", 89345678, '1957-06-21'),
("ninja", "Andres", "Cruz", "acruz@mintic.com", "3187840578", 32145678, '2002-12-08'),
("neon", "Nelson", "Ruiz", "nruiz@mintic.com", "3157450978", 123359878, '2001-11-01'),
("rose", "Claudia", "Mendez", "cmendez@mintic.com", "3189490978", 89045678, '1982-10-03'),
("green", "Jorge", "Rodriguez", "jrodriguez@mintic.com", "3117980978", 90045678, '2005-02-08');

CREATE TABLE intencion(
id_intencion INT PRIMARY KEY NOT NULL,
alias VARCHAR(25),
fabricante VARCHAR(25),
fecha_hora TIMESTAMP,
FOREIGN KEY (alias) REFERENCES clientes (id_alias),
FOREIGN KEY (fabricante) REFERENCES fabricantes (id_fabricante)
);

INSERT INTO intencion (id_intencion, alias, fabricante, fecha_hora)
VALUES (501, "lucky", "Cannondale", '2017-10-25 20:00:00'),
(502, "lucky", "Trek", '2019-03-15 18:30:00'),
(503, "lucky", "Starker", '2019-05-20 20:30:00'),
(504, "malopez", "Cannondale", '2018-05-20 20:30:00'),
(505, "malopez", "Starker", '2020-01-20 20:30:00'),
(506, "diva", "Yeti", '2019-05-20 20:30:00'),
(507, "diva", "Fuji", '2018-06-22 21:30:00'),
(508, "diva", "Lucky Lion", '2020-03-17 15:30:20'),
(509, "dreamer", "Lucky Lion", '2020-03-17 15:30:20'),
(510, "dreamer", "Be Electric", '2020-04-10 18:30:20'),
(511, "ninja", "Aima", '2020-02-17 20:30:20'),
(512, "ninja", "Starker", '2020-02-20 16:30:20'),
(513, "ninja", "Mec de Colombia", '2020-03-27 18:30:20'),
(514, "rose", "Atom Electric", '2020-03-20 21:30:20'),
(515, "green", "Yeti", '2020-01-10 17:30:20'),
(516, "green", "Trek", '2020-02-15 20:30:20'),
(517, "green", "Bmc", '2020-03-17 18:30:20');