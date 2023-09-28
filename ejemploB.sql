-- Crear una secuencia
CREATE SEQUENCE secuencia_documentoCinco
  START WITH 1
  INCREMENT BY 1
  MINVALUE 1
  NOMAXVALUE;

CREATE TABLE documentoCinco (
  id_documento NUMBER DEFAULT secuencia_documentoCinco.NEXTVAL PRIMARY KEY,
  nombre_documento nvarchar2(50)
);


CREATE SEQUENCE secuencia_areaCinco
  START WITH 1
  INCREMENT BY 1
  MINVALUE 1
  NOMAXVALUE;
  
  
CREATE TABLE areaCinco (
  id_area NUMBER DEFAULT secuencia_areaCinco.NEXTVAL PRIMARY KEY,
  nombre_area nvarchar2(50) not null 
);


CREATE SEQUENCE secuencia_cargoCinco
  START WITH 1
  INCREMENT BY 1
  MINVALUE 1
  NOMAXVALUE;
  
CREATE TABLE cargoCinco (
  id_cargo NUMBER DEFAULT secuencia_cargoCinco.NEXTVAL PRIMARY KEY,
  nombre_cargo nvarchar2(50) not null 
);



CREATE SEQUENCE secuencia_empleadoCinco
  START WITH 1
  INCREMENT BY 1
  MINVALUE 1
  NOMAXVALUE;
  
CREATE TABLE empleadoCinco (
  id_empleado NUMBER DEFAULT secuencia_empleadoCinco.NEXTVAL PRIMARY KEY,
  id_documento NUMBER not null,
  id_area NUMBER not null,
  id_cargo NUMBER not null,
  nombre_empleado nvarchar2(50) not null,
  apellido_empleado nvarchar2(50) not null,
  FOREIGN KEY (id_documento) REFERENCES documentoCinco (id_documento),
  FOREIGN KEY (id_area) REFERENCES areaCinco (id_area),
  FOREIGN KEY (id_cargo) REFERENCES cargoCinco (id_cargo)
);



























CREATE TABLE empleado (
  id_empleado NUMBER GENERATED BY DEFAULT AS IDENTITY (START WITH 1) NOT NULL,
  id_documento NUMBER not null,
  id_area NUMBER not null,
  id_cargo NUMBER not null,
  nombre_empleado nvarchar2(50) not null,
  apellido_empleado nvarchar2(50) not null,
  CONSTRAINT pk_empleado PRIMARY KEY (id_empleado),
  FOREIGN KEY (id_documento) REFERENCES documento (id_documento),
  FOREIGN KEY (id_area) REFERENCES area (id_area),
  FOREIGN KEY (id_cargo) REFERENCES cargo (id_cargo)
);


CREATE TABLE documento (
  id_documento NUMBER GENERATED BY DEFAULT AS IDENTITY (START WITH 1) NOT NULL,
  nombre_documento nvarchar2(50) not null,
  CONSTRAINT pk_documento PRIMARY KEY (id_documento)
);

CREATE TABLE area (
  id_area NUMBER GENERATED BY DEFAULT AS IDENTITY (START WITH 1) NOT NULL,
  nombre_area nvarchar2(50) not null,
  CONSTRAINT pk_area PRIMARY KEY (id_area)
);

CREATE TABLE cargo (
  id_cargo NUMBER GENERATED BY DEFAULT AS IDENTITY (START WITH 1) NOT NULL,
  nombre_cargo nvarchar2(50) not null,
  CONSTRAINT pk_cargo PRIMARY KEY (id_cargo)
);




















create table categoria(
  id_categoria number generated by default as identity (start with 1) not null,
  nombre_categoria nvarchar2(50) not null,
  constraint pk_categoria primary key (id_categoria)
)

create table marca(
  id_marca number generated by default as identity (start with 1) not null,
  nombre_marca nvarchar2(50) not null,
  constraint pk_marca primary key (id_marca)
  
)

SELECT p.*, m.nombre_marca FROM producto3 p JOIN marca m ON p.id_marca = m.id_marca

SELECT p.*, m.nombre_marca, c.nombre_categoria 
FROM producto3 p JOIN marca m ON p.id_marca = m.id_marca
JOIN categoria c ON p.id_categoria = c.id_categoria

CREATE TABLE producto3 (
  id_producto number generated by default as identity (start with 1) not null,
  id_categoria NUMBER not null,
  id_marca NUMBER not null,
  descripcion_producto nvarchar2(50) not null,
  precio_producto nvarchar2(50) not null,
  constraint pk_producto3 primary key (id_producto),
  foreign key (id_marca) references marca (id_marca),
  foreign key (id_categoria) references categoria (id_categoria)
);


CREATE TABLE producto (
  id_producto number generated by default as identity (start with 1) not null,
  id_categoria NUMBER not null,
  id_marca NUMBER not null,
  descripcion_producto nvarchar2(50) not null,
  precio_producto nvarchar2(50) not null,
  fecha_registro date,
  constraint pk_producto2 primary key (id_producto),
  foreign key (id_marca) references marca (id_marca),
  foreign key (id_categoria) references categoria (id_categoria)
);















