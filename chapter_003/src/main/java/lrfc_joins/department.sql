CREATE TABLE departments(
    id serial primary key,
    name varchar(255)
);

CREATE TABLE employees(
    id serial primary key,
    name varchar(255),
    department_id int REFERENCES departments(id)
);

--1. Создать таблицы и заполнить их начальными данными
INSERT INTO departments(name) VALUES ('ИТ'), ('HR'), ('Финансы'), ('Отдел продаж'), ('Безопасность');

INSERT INTO employees(name, department_id) VALUES ('Олег', NULL);
INSERT INTO employees(name, department_id) VALUES ('Дмитрий', NULL);
INSERT INTO employees(name, department_id) VALUES ('Геннадий', 1);
INSERT INTO employees(name, department_id) VALUES ('Татьяна', 2);
INSERT INTO employees(name, department_id) VALUES ('Юлия', 3);
INSERT INTO employees(name, department_id) VALUES ('Максим', 4);
INSERT INTO employees(name, department_id) VALUES ('Наталья', 4);

--2. Выполнить запросы с left, rigth, full, cross соединениями

-- left
SELECT * FROM departments d left JOIN employees e ON d.id = e.department_id;

--rigth
SELECT * FROM departments d right JOIN employees e ON d.id = e.department_id;

--full
SELECT * FROM departments d FULL JOIN employees e ON d.id = e.department_id;

--cross
SELECT * FROM departments d cross JOIN employees e;

--3. Используя left join найти департаменты, у которых нет работников
SELECT * FROM departments d left JOIN employees e ON d.id = e.department_id WHERE e.department_id IS NULL;

--4. Используя left и right join написать запросы, которые давали бы одинаковый результат.
SELECT * FROM departments d left JOIN employees e ON d.id = e.department_id;
SELECT * FROM employees e right  JOIN departments d ON d.id = e.department_id;