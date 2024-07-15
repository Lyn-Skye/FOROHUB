create table usuarios(

    id bigint not null auto_increment,
    nombre varchar (100) not null,
    email varchar (100) not null unique,
    clave varchar(500) not null,

primary key (id)
);

insert into usuarios(id, nombre, email, clave) values(1, "Bowser", "Bowser@BowserBoss.com", "$2a$10$mk9UsG/X2.4PI1AaYJPib.i/yXRfXvK9Kq22RPIOZX52a3GjkhWTa");