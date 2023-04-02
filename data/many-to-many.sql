
CREATE TABLE roles (
    id serial primary key,
    name text
);
INSERT INTO roles (id, name)
VALUES
    (1, 'Менеджер'),
    (2, 'Дизайнер'),
    (3, 'Программист'),
    (4, 'Маркетолог'),
    (5, 'Бухгалтер');
CREATE TABLE users (
    id serial primary key,
    first_name text NULL,
    last_name text NULL
);
INSERT INTO users (id, first_name, last_name)
VALUES
    (1, 'Виктор', 'Алтушев'),
    (2, 'Светлана', 'Иванова'),
    (3, 'Елена', 'Абрамова'),
    (4, 'Василиса', 'Кац'),
    (5, 'Антон', 'Сорокин'),
    (6, 'Алёна', 'Алясева'),
    (7, 'Антон', 'Белый'),
    (8, 'Игорь', 'Маф'),
    (9, 'Анастасия', 'Дейчман'),
    (10, 'Александр', 'Дмитриев');
CREATE TABLE users_roles (
    user_id INTEGER ,
    role_id INTEGER 
);
INSERT INTO users_roles (user_id, role_id)
VALUES
    (1, 2),
    (2, 1),
    (3, 2),
    (4, 5),
    (5, 3),
    (6, 4),
    (7, 3),
    (8, 3),
    (1, 1),
    (3, 4),
    (5, 1);
select users.id, users.first_name, users.last_name 
from users
join users_roles on users_roles.user_id=users.id
join roles on roles.id=users_roles.role_id
where roles.id=3
order by users.last_name
