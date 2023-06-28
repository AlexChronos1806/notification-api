INSERT INTO users (id, name, email, phone) VALUES (1, 'Alex', 'alex@gmail.com', '555-22233');
INSERT INTO users (id, name, email, phone) VALUES (2, 'Brian', 'brian@gmail.com', '555-11222');
INSERT INTO users (id, name, email, phone) VALUES (3, 'Mariana', 'mariana@gmail.com', '555-44777');

INSERT INTO channels(id, name) VALUES(1, 'SMS');
INSERT INTO channels(id, name) VALUES(2, 'EMAIL');
INSERT INTO channels(id, name) VALUES(3, 'PUSH');

INSERT INTO categories(id, name) VALUES(1, 'SPORTS');
INSERT INTO categories(id, name) VALUES(2, 'FINANCE');
INSERT INTO categories(id, name) VALUES(3, 'FILMS');

INSERT INTO users_channels(users_id, channels_id) VALUES(1, 1);
INSERT INTO users_channels(users_id, channels_id) VALUES(1, 2);
INSERT INTO users_channels(users_id, channels_id) VALUES(1, 3);

INSERT INTO users_channels(users_id, channels_id) VALUES(2, 1);
INSERT INTO users_channels(users_id, channels_id) VALUES(2, 2);
INSERT INTO users_channels(users_id, channels_id) VALUES(2, 3);

INSERT INTO users_channels(users_id, channels_id) VALUES(3, 1);
INSERT INTO users_channels(users_id, channels_id) VALUES(3, 2);
INSERT INTO users_channels(users_id, channels_id) VALUES(3, 3);

INSERT INTO users_categories(users_id, categories_id) VALUES(1, 1);
INSERT INTO users_categories(users_id, categories_id) VALUES(1, 3);

INSERT INTO users_categories(users_id, categories_id) VALUES(2, 1);
INSERT INTO users_categories(users_id, categories_id) VALUES(2, 2);
INSERT INTO users_categories(users_id, categories_id) VALUES(2, 3);

INSERT INTO users_categories(users_id, categories_id) VALUES(3, 1);