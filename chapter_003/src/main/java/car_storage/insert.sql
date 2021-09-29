--2. Заполнить таблицы через insert.
INSERT INTO body (type, color)
VALUES ('Седан', 'Синий'), ('Универсал', 'Красный'), ('Универсал', 'Зеленый'), ('Хетчбэк', 'Белый');

INSERT INTO engine(volume) VALUES (2.0), (2.4), (2.7), (1.5), (3.5);

INSERT INTO transmission(tr_type)
VALUES ('Автомат'), ('Механическая '), ('Роботизированная'), ('Вариативная ');

INSERT INTO cars(name, body_id, engine_id, transmission_id) VALUES
('Car_1', 1, 2, 1),
('Car_2', 2, 1, 2),
('Car_3', 3, 3, 4),
('Car_4', 3, 3, 4),
('Car_5', 1, 1, 1),
('Car_6', 2, 2, 2),
('Car_7', 2, 1, 1);

