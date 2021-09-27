CREATE TABLE teens(
   id serial PRIMARY KEY,
   name varchar(255),
   gender varchar(255)
);

--5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
--Используя cross join составить все возможные разнополые пары
SELECT gm.name AS male, gf.name AS female,(gf.gender, gm.gender) AS Couple
FROM teens AS gf CROSS JOIN teens AS gm
WHERE gf.gender = 'female' AND  gm.gender = 'male';