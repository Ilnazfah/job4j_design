INSERT INTO roles(title) values ('manager');
INSERT INTO roles(title) values ('operator');
INSERT INTO roles(title) values ('driver');

INSERT INTO users(name, role_id) values ('Ivan', 1);
INSERT INTO users(name, role_id) values ('Oleg', 2);
INSERT INTO users(name, role_id) values ('Kiril', 3);

INSERT INTO rules(title) values ('Driver license');
INSERT INTO rules(title) values ('Sociability');
INSERT INTO rules(title) values ('Medical book');
INSERT INTO rules(title) values ('Secondary education');
INSERT INTO rules(title) values ('Higher education');

INSERT INTO roles_rules(role_id, rule_id) values (1, 2);
INSERT INTO roles_rules(role_id, rule_id) values (1, 3);
INSERT INTO roles_rules(role_id, rule_id) values (1, 5);

INSERT INTO roles_rules(role_id, rule_id) values (2, 2);
INSERT INTO roles_rules(role_id, rule_id) values (2, 3);
INSERT INTO roles_rules(role_id, rule_id) values (2, 4);

INSERT INTO roles_rules(role_id, rule_id) values (3, 1);
INSERT INTO roles_rules(role_id, rule_id) values (3, 2);

INSERT INTO categories(title) values ('To do');
INSERT INTO categories(title) values ('Remake');
INSERT INTO categories(title) values ('Completed');

INSERT INTO states(title) values ('Open');
INSERT INTO states(title) values ('In progress');
INSERT INTO states(title) values ('Resolved');

INSERT INTO items(title, user_id, category_id, state_id) values ('Some_item_1', 1, 1, 1);
INSERT INTO items(title, user_id, category_id, state_id) values ('Some_item_2', 1, 2, 2);
INSERT INTO items(title, user_id, category_id, state_id) values ('Some_item_3', 1, 3, 3);
INSERT INTO items(title, user_id, category_id, state_id) values ('Some_item_4', 2, 2, 2);
INSERT INTO items(title, user_id, category_id, state_id) values ('Some_item_5', 3, 2, 2);
INSERT INTO items(title, user_id, category_id, state_id) values ('Some_item_6', 1, 3, 3);

INSERT INTO comments(comment, item_id) values ('Some_comment_1', 1);
INSERT INTO comments(comment, item_id) values ('Some_comment_2', 1);
INSERT INTO comments(comment, item_id) values ('Some_comment_3', 1);

INSERT INTO attachs(filename, item_id) values ('Some_file_1', 1);
INSERT INTO attachs(filename, item_id) values ('Some_file_2', 2);
INSERT INTO attachs(filename, item_id) values ('Some_file_3', 3);