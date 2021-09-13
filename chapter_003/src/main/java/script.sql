create table dishes (
id serial primary key,
	name varchar(255),
	cost numeric,
	description text
);
insert into dishes (name, cost, description) values ('Паста карбонара','250','Спагетти с мелкими кусочками бекона, смешанные с соусом из яиц, сыра пармезан и пекорино романо, соли и свежемолотого чёрного перца.');
select * from dishes;
update dishes set cost = '300';
select * from dishes;
delete from dishes;
select * from dishes;