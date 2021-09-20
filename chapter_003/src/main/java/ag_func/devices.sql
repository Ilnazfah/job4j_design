create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('Телефон', 20000);
insert into devices(name, price) values ('Утюг', 4000);
insert into devices(name, price) values ('Кофемашина', 15000);
insert into devices(name, price) values ('Телевизор', 25000);
insert into devices(name, price) values ('Холодильник', 30000);
insert into devices(name, price) values ('Планшет', 45000);
insert into devices(name, price) values ('ПК', 50000);
insert into devices(name, price) values ('Ноут', 100000);
insert into devices(name, price) values ('Принтер', 23500);
insert into devices(name, price) values ('Фотоаппарат', 70000);
insert into devices(name, price) values ('USB_кабель', 150);
insert into devices(name, price) values ('Клавиатура', 2000);
insert into devices(name, price) values ('Мышь', 500);

insert into people(name) values('Игорь');
insert into people(name) values('Дмитрий');
insert into people(name) values('Владимир');
insert into people(name) values('Олег');

insert into devices_people(people_id, device_id) values(1, 1), (1, 2), (1, 3);
insert into devices_people(people_id, device_id) values(2, 4), (2, 5), (2, 6);
insert into devices_people(people_id, device_id) values(3, 7), (3, 8), (3, 9), (3, 10);
insert into devices_people(people_id, device_id) values(4, 11), (4, 12), (4, 13);

select p.name as Имя, avg(d.price) as Сред_стоимость
from people as p
inner join devices_people dp on p.id= dp.people_id
inner join devices as d on dp.device_id = d.id
group by p.name having avg(d.price) > 5000;