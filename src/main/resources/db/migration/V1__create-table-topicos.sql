create table topicos(

id bigint not null auto_increment,
titulo varchar(100) not null unique,
mensaje varchar(200) not null unique,
fecha date not null,
status int not null,
autor varchar(100) not null,
curso varchar(100) not null,

primary key(id)

)

