--вещи
create table things(
	id serial primary key,
	name varchar(255),
	inventoryNumber int
);

--стеллажы
create table shelvings(
	id serial primary key,
	number int,
	thing_id int references things(id) unique
);

insert into things(name, inventoryNumber) values ('thing_1', 123);
insert into things(name, inventoryNumber) values ('thing_2', 124);
insert into things(name, inventoryNumber) values ('thing_3', 125);
insert into things(name, inventoryNumber) values ('thing_4', 126);
insert into things(name, inventoryNumber) values ('thing_5', 127);

insert into shelvings(number, thing_id) values (1, 1);
insert into shelvings(number, thing_id) values (2, 2);
insert into shelvings(number, thing_id) values (3, 3);
insert into shelvings(number, thing_id) values (4, 4);
insert into shelvings(number, thing_id) values (5, 5);
insert into shelvings(number) values (6);
insert into shelvings(number) values (7);
insert into shelvings(number) values (8);

select shelvings.number Номер_стеллажа, things.name Наименование
from shelvings
inner join things
on things.id = shelvings.thing_id;

select shelvings.number Номер_стеллажа, things.inventoryNumber ИнвентарныйНомер, things.name Наименование
from shelvings
inner join things
on things.id = shelvings.number;

select * from shelvings join things t on shelvings.thing_id = t.id;