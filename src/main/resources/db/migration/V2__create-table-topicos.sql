create table topicos(

    id bigint not null auto_increment,
    titulo varchar (200) not null unique,
    mensaje varchar (500) not null unique,
    fechaCreacion datetime not null,
    nombreCurso varchar(100) not null,

primary key (id)

);