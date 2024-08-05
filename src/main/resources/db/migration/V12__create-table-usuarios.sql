create table usuarios(

    id BIGSERIAL not null,
    login varchar(100) not null,
    senha varchar(100) not null unique,


    primary key(id)

);