create table fauna (
	id serial primary key,
	name text,
	avg_age int,
	discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values ('animal_1', 9000, '10.12.1920');
insert into fauna(name, avg_age, discovery_date) values ('animal_2', 11000, '15.06.1806');
insert into fauna(name, avg_age, discovery_date) values ('animal_3', 15000, '15.06.1925');
insert into fauna(name, avg_age, discovery_date) values ('animal_4', 2000, '04.04.1960');
insert into fauna(name, avg_age, discovery_date) values ('animal_5', 20000, '05.09.1975');
insert into fauna(name, avg_age, discovery_date) values ('animal_6', 17000, '01.01.1900');
insert into fauna(name, avg_age, discovery_date) values ('animal_7', 10000, '06.09.1927');
insert into fauna(name, avg_age, discovery_date) values ('animal_8', 21000, '25.05.1910');
insert into fauna(name, avg_age, discovery_date) values ('fish_1', 13000, '02.01.1805');
insert into fauna(name, avg_age, discovery_date) values ('fish_2', 9000, '15.03.1905');
insert into fauna(name, avg_age, discovery_date) values ('fish_3', 8000, '15.03.1905');
insert into fauna(name, avg_age, discovery_date) values ('fish_4', 8000, null);

--Извлечение данных, у которых имя name содержит подстроку fish
select * from fauna where name like '%fish%';

--Извлечение данных, у которых сред. продолжительность жизни находится в диапазоне 10 000 и 21 000
select * from fauna where avg_age >= 10000 and avg_age <= 21000;

--Извлечение данных, у которых дата открытия не известна (null)
select * from fauna where discovery_date is null;

--Извлечение данных видов, у которых дата открытия раньше 1950 года
select * from fauna where discovery_date < '01.01.1950';