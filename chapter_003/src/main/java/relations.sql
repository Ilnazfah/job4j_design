-- персональные карты клиентов
CREATE TABLE cards(
    id serial PRIMARY KEY,
	proximity_number int
);

-- статусы клиентов
CREATE TABLE statuses(
    id serial PRIMARY KEY,
	name VARCHAR(255)
);

-- данные о клиентах
CREATE TABLE clients(
    id serial PRIMARY KEY,
	name VARCHAR(255),
	surname VARCHAR(255),
	client_status_id int REFERENCES statuses(id),
	personal_card_id int REFERENCES cards(id) unique
);

-- типы скидок для клиентов
CREATE TABLE discounts(
	id serial PRIMARY KEY,
	type VARCHAR(255),
	amount int
);

CREATE TABLE discounts_clients(
	id serial PRIMARY KEY,
	client_id int REFERENCES clients(id),
	discount_id int REFERENCES discounts(id)
);

INSERT INTO cards(proximity_number) values (12345678);
INSERT INTO cards(proximity_number) values (12345679);
INSERT INTO cards(proximity_number) values (12345681);
INSERT INTO cards(proximity_number) values (12345682);
INSERT INTO cards(proximity_number) values (12345683);

INSERT INTO statuses(name) values ('regular');
INSERT INTO statuses(name) values ('silver');
INSERT INTO statuses(name) values ('gold');
INSERT INTO statuses(name) values ('diamond');
INSERT INTO statuses(name) values ('platinum');

INSERT INTO discounts(type, amount) values ('forTVs', 10);
INSERT INTO discounts(type, amount) values ('forAllHouseholdAppliances', 15);
INSERT INTO discounts(type, amount) values ('forAllInstruments', 5);

INSERT INTO clients(name, surname, client_status_id, personal_card_id)
values ('Ilnaz', 'Fahriev', 5, 1);
INSERT INTO clients(name, surname, client_status_id, personal_card_id)
values ('Ivan', 'Ivanov', 5, 2);
INSERT INTO clients(name, surname, client_status_id, personal_card_id)
values ('Molodes', 'Molodsov', 2, 3);
INSERT INTO clients(name, surname, client_status_id, personal_card_id)
values ('Klava', 'Knopkovich', 3, 4);
INSERT INTO clients(name, surname, client_status_id, personal_card_id)
values ('Klava', 'Knopkovich', 2, 5);

INSERT INTO discounts_clients(client_id, discount_id) VALUES (1, 1);
INSERT INTO discounts_clients(client_id, discount_id) VALUES (1, 2);
INSERT INTO discounts_clients(client_id, discount_id) VALUES (1, 3);
INSERT INTO discounts_clients(client_id, discount_id) VALUES (2, 1);
INSERT INTO discounts_clients(client_id, discount_id) VALUES (2, 2);
INSERT INTO discounts_clients(client_id, discount_id) VALUES (2, 3);
INSERT INTO discounts_clients(client_id, discount_id) VALUES (3, 3);
