--1) Вывести список всех машин и все привязанные к ним детали.
SELECT c.name AS "Название авто", b.type AS "Кузов", e.volume AS "Объем двигателя", t.tr_type AS "Тип коробки передач"
FROM cars AS c
JOIN body b ON b.id = c.id
JOIN engine e ON e.id = c.id
JOIN transmission t ON t.id = c.id;

--2) Вывести отдельно детали (1 деталь - 1 запрос),
--которые не используются НИ в одной машине, кузова, двигатели, коробки передач.

--кузов
SELECT b.type AS "Тип кузова", b.color AS "Цвет" FROM body b
LEFT JOIN cars c ON b.id = c.body_id WHERE c.name IS NULL;

--двигатель
SELECT e.volume AS "Объем двигателя" FROM engine e
LEFT JOIN cars c ON e.id = c.engine_id WHERE c.name IS NULL;

--коробка передач
SELECT t.tr_type AS "Тип коробки передач" FROM transmission t
LEFT JOIN cars c ON t.id = c.transmission_id WHERE c.name IS NULL;