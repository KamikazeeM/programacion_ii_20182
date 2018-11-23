SET GLOBAL time_zone = '-5:00';
drop database if exists programacion_ii_20182;
create database if not exists programacion_ii_20182;

use programacion_ii_20182;

create table rol (
	id int not null unique primary key auto_increment,
    nombre varchar(100) not null
);

create table permiso (
	id int not null unique primary key auto_increment,
    nombre varchar(100) not null
);

create table rol_permiso (
	id int not null unique primary key auto_increment,
    rol_id int not null,
    permiso_id int not null,
	index (rol_id),
    index (permiso_id )
);

create table asunto (
	id int not null unique primary key auto_increment,
    nombre varchar(255) not null
);

create table usuario (
	id int not null unique primary key auto_increment,
    usuario varchar(100) not null,
    contrasena varchar(100) not null,
    rol_id int,
	index (rol_id)
);

create table destino (
	id int not null unique primary key auto_increment,
    nombres varchar(100) not null,
    apellidos varchar(100) not null,
    area varchar(45) not null,
    correo varchar(255) not null
);

create table documento (
	id int not null unique primary key auto_increment,
    titulo varchar(100) not null,
    fecha_documento date,
    fecha_radicado date,
    origen varchar(45) not null,
    asunto_id int not null,
    index (asunto_id),
    usuario_id int not null,
    index (usuario_id),
    numero_radicado bigint,
    comentarios varchar(255),
    anexo varchar(255)
);


insert into usuario values(null, 'rgarcia', '420F1BEE798DCADD0868AB9D05157C8B5F054D4F66EB7267E604998763A3EC21', 1); 
insert into usuario values(null, 'santafe', '420F1BEE798DCADD0868AB9D05157C8B5F054D4F66EB7267E604998763A3EC21', 2);
insert into asunto values(null, 'Incapacidad'); 
insert into rol values(null, 'administrador'); 
insert into rol values(null, 'Detinatario'); 
insert into permiso values(null, 'administrarDestinos'); 
insert into rol_permiso values(null, (select id from rol where nombre = 'administrador'),(select id from permiso where nombre = 'administrarDestinos'));


