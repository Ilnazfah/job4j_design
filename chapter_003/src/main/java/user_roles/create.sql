CREATE TABLE roles(
	id serial PRIMARY KEY,
	title text
);

CREATE TABLE users(
	id serial PRIMARY KEY,
	name text,
	role_id int REFERENCES roles(id)
);

CREATE TABLE rules(
	id serial PRIMARY KEY,
	title text
);

--вспомогательная таблица для roles и rules
CREATE TABLE roles_rules(
	id serial PRIMARY KEY,
	role_id int REFERENCES roles(id),
	rule_id int REFERENCES rules(id)
);

CREATE TABLE categories (
    id serial PRIMARY KEY,
	title text
);

CREATE TABLE states (
    id serial PRIMARY KEY,
	title text
);

CREATE TABLE items(
    id serial PRIMARY KEY,
	title text,
	user_id int REFERENCES users(id),
	category_id int REFERENCES categories(id),
	state_id int REFERENCES states(id)
);

CREATE TABLE comments (
    id serial PRIMARY KEY,
	comment text,
	item_id int REFERENCES items(id)
);

CREATE TABLE attachs (
    id serial PRIMARY KEY,
	filename text,
	item_id int REFERENCES items(id)
);