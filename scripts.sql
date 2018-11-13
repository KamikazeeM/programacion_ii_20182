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
	foreign key(rol_id) references rol(id),
    index (permiso_id ),
	foreign key(permiso_id) references permiso(id)
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
	index (rol_id),
	foreign key(rol_id) references rol(id)
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
    nombres varchar(100) not null,
    fecha_documento date,
    fecha_radicado date,
    origen varchar(45) not null,
    asunto_id int not null,
    index (asunto_id),
	foreign key(asunto_id) references asunto(id),
    usuario_id int not null,
    index (usuario_id),
	foreign key(usuario_id) references asunto(id),
    numero_radicado bigint,
    comentarios varchar(255),
    anexo varchar(255)
);


insert into usuario values(null, 'rgarcia', 'Joder123,', null); 
insert into rol values(null, 'administrador'); 
insert into permiso values(null, 'administrarDestinos'); 
insert into rol_permiso values(null, (select id from rol where nombre = 'administrador'),(select id from permiso where nombre = 'administrarDestinos'));




