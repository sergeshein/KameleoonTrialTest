insert into users(id, created_at, email, name, password)
values (1, CURRENT_TIMESTAMP, 'mail.mail', 'user', 'pass');

ALTER SEQUENCE user_seq RESTART WITH 2;