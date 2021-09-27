CREATE TABLE teens(
   id serial PRIMARY KEY,
   name varchar(255),
   gender varchar(255)
);


--5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
--Используя cross join составить все возможные разнополые пары
INSERT INTO teens(name, gender) VALUES ('Олег', 'male');
INSERT INTO teens(name, gender) VALUES ('Игорь', 'male');
INSERT INTO teens(name, gender) VALUES ('Дмитрий', 'male');
INSERT INTO teens(name, gender) VALUES ('Наталья', 'female');
INSERT INTO teens(name, gender) VALUES ('Юлия', 'female');
INSERT INTO teens(name, gender) VALUES ('Оксана', 'female');

SELECT gm.name AS male, gf.name AS female,(gf.gender, gm.gender) AS Couple
FROM teens AS gf CROSS JOIN teens AS gm
WHERE gf.gender = 'female' AND  gm.gender = 'male';