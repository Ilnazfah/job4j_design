CREATE TABLE type (
	id serial,
	name varchar (255)
);

CREATE TABLE product (
	id serial PRIMARY KEY,
	name varchar (255),
	type_id int,
	expired_date date,
	price float
);

INSERT INTO type(name) VALUES ('СЫР');
INSERT INTO type(name) VALUES ('МОЛОКО');
INSERT INTO type(name) VALUES ('БАКАЛЕЯ');
INSERT INTO type(name) VALUES ('РЫБА');
INSERT INTO type(name) VALUES ('ЗАМОРОЗКА');

INSERT INTO product(name, type_id, expired_date, price) VALUES
('Пармезан', 1, '22.11.2021', 300),
('Гауда', 1, '20.09.2021', 100),
('Гойя', 1, '10.09.2021', 350),
('Маасдам', 1, '25.12.2021', 200),
('Чеддер', 1, '20.12.2021', 150);

INSERT INTO product(name, type_id, expired_date, price) VALUES
('Молоко 3,2%', 2, '22.11.2021', 55),
('Молоко 2,5%', 2, '23.11.2021', 45),
('Соевое молоко 1%', 2, '20.09.2021', 100),
('Соевое молоко 2%', 2, '20.09.2021', 150),
('Сливки 30%', 2, '10.09.2021', 150),
('Сливки 10%', 2, '10.09.2021', 100),
('Топленое 5%', 2, '25.12.2021', 90),
('Топленое 3%', 2, '25.12.2021', 70),
('Козье молоко 2,5%;', 2, '26.12.2021', 200),
('Козье молоко 3,5%;', 2, '26.12.2021', 250),
('Овсяное молоко 1%;', 2, '20.11.2021', 100),
('Овсяное молоко 2%;', 2, '20.09.2021', 150);

INSERT INTO product(name, type_id, expired_date, price) VALUES
('Килька в томатном соусе', 3, '22.11.2021', 55),
('Горох', 3, '23.11.2021', 45),
('Кукуруза', 3, '20.09.2021', 100),
('Бобы', 3, '20.09.2021', 150),
('Соевый соус', 3, '10.09.2021', 150),
('Гранатовый соус', 3, '10.09.2021', 100),
('Имбирь маринованный', 3, '25.12.2021', 90),
('Маринованные огурцы', 3, '25.12.2021', 70),
('Корнишоны', 3, '26.12.2021', 200),
('Водоросли', 3, '26.12.2021', 250),
('Земляничное варенье', 3, '20.11.2021', 100),
('Клубничное варенье', 3, '20.09.2021', 150);

INSERT INTO product(name, type_id, expired_date, price) VALUES
('Минтай', 4, '22.11.2021', 100),
('Форель', 4, '20.09.2021', 150),
('Камбала', 4, '10.09.2021', 200),
('Кальмар', 4, '25.12.2021', 250),
('Селедка', 4, '20.12.2021', 255);

INSERT INTO product(name, type_id, expired_date, price) VALUES
('Мороженое пломбир 2%', 5, '22.11.2021', 50),
('Мороженое ГОСТ', 5, '20.09.2021', 70),
('Пломбир на палочке', 5, '10.09.2021', 30),
('Пицца', 5, '25.12.2021', 150),
('Брокколи', 5, '20.12.2021', 150);

--1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT * FROM product
INNER JOIN type AS t ON product.type_id = t.id WHERE t.name LIKE '%СЫР%';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"
SELECT * FROM product WHERE name LIKE '%Мороженое%';

--3. Написать запрос, который выводит все продукты, срок годности которых уже истек
SELECT * FROM product WHERE expired_date <= current_date;

--4. Написать запрос, который выводит самый дорогой продукт.
SELECT * FROM product
WHERE price = (
   SELECT MAX (price)
   FROM product
);

--5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество
SELECT t.name AS Тип_продукта, COUNT(p.type_id) AS Количество
FROM product AS p
INNER JOIN type AS t ON p.type_id = t.id
GROUP BY t.name
ORDER BY Количество ASC;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT * FROM product
INNER JOIN type AS t ON product.type_id = t.id WHERE t.name LIKE '%МОЛОКО%' OR t.name LIKE '%СЫР%'
ORDER BY t.name DESC;

--7. Написать запрос, который выводит тип продуктов,
--которых осталось меньше 10 штук.
--Под количеством подразумевается количество продуктов определенного типа.
--Например, если есть тип "СЫР" и продукты "Сыр плавленный" и "Сыр моцарелла",
--которые ему принадлежат, то количество продуктов типа "СЫР" будет 2.
SELECT t.name AS Тип_продукта, COUNT(p.type_id) AS Количество
FROM product AS p
INNER JOIN type AS t ON p.type_id = t.id
GROUP BY t.name
HAVING COUNT(p.type_id) < 10;

--8. Вывести все продукты и их тип.
SELECT * FROM product
INNER JOIN type AS t ON product.type_id = t.id
ORDER BY t.name DESC;