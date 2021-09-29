--1. Создать структур данных в базе.
CREATE TABLE body(
   id serial PRIMARY KEY,
   type varchar(255),
   color varchar (255)
);

CREATE TABLE engine(
   id serial PRIMARY KEY,
   volume numeric(2, 1)
);

CREATE TABLE transmission(
   id serial PRIMARY KEY,
   tr_type varchar (255)
);

--2. Создать структуру Машина. Машина не может существовать без данных из п.1.
CREATE TABLE cars(
   id serial PRIMARY KEY,
   name varchar(255),
   body_id int references body(id),
   engine_id int references engine(id),
   transmission_id int references transmission(id)
);