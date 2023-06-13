create database enrollments;
use enrollments;

create table career(
id int primary key auto_increment,
description varchar(128)
);

create table subject(
id int primary key auto_increment,
description varchar(128),
career_id int,
foreign key (career_id) references career(id)
);

create table user(
id int primary key,
username varchar(128) unique,
password varchar(32),
type int not null,
career_id int,
status int not null,
foreign key (career_id) references career(id)
);

/*
-- Agregar índices a las tablas
ALTER TABLE subject ADD INDEX fk_subject_career_idx (career_id);
ALTER TABLE user ADD INDEX fk_user_career_idx (career_id);

-- Agregar datos de ejemplo a la tabla "career"
INSERT INTO career (description) VALUES
    ('Carrera 1'),
    ('Carrera 2'),
    ('Carrera 3');

COMMIT;
*/