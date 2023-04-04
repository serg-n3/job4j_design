
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS orders_details CASCADE;

CREATE TABLE users (
    id serial primary key,
    first_name VARCHAR(50) NULL,
    last_name VARCHAR(50) NULL
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
CREATE TABLE products (
    id serial primary key,
    name VARCHAR(50) NULL,
    count INTEGER NULL,
    price INTEGER NULL
);
INSERT INTO products (id, name, count, price)
VALUES
    (1, 'Стиральная машина', 5, 12000),
    (2, 'Холодильник', 11, 17800),
    (3, 'Микроволновка', 3, 4100),
    (4, 'Пылесос', 2, 4500),
    (5, 'Вентилятор', 8, 700),
    (6, 'Телевизор', 7, 31740),
    (7, 'Тостер', 2, 2500),
    (8, 'Принтер', 4, 3000),
    (9, 'XBOX', 5, 19900),
    (10, 'Флешка 8Gb', 14, 700);
CREATE TABLE orders (
    id serial primary key,
    user_id INTEGER NULL,
    date DATE NULL,
    status VARCHAR(50) NULL
);
INSERT INTO orders (id, user_id, date, status)
VALUES
    (1, 7, '2017-01-04 ', 'success'),
    (2, 1, '2017-01-04 ', 'cancelled'),
    (3, 4, '2017-01-12 ', 'success'),
    (4, 10, '2017-01-14 ', 'new'),
    (5, 3, '2017-01-23 ', 'success'),
    (6, 2, '2017-02-01 ', 'success'),
    (7, 1, '2017-02-01 ', 'success'),
    (8, 10, '2017-02-12 ', 'success'),
    (9, 5, '2017-02-12', 'success'),
    (10, 2, '2017-02-14', 'success'),
    (11, 3, '2017-02-16', 'success'),
    (12, 5, '2017-02-28', 'cancelled'),
    (13, 10, '2017-03-02', 'new'),
    (14, 1, '2017-03-04', 'success');
CREATE TABLE orders_details (
    order_id INTEGER NULL,
    product_id INTEGER NULL
);
INSERT INTO orders_details (order_id, product_id)
VALUES
    (1, 1),
    (2, 2),
    (5, 3),
    (13, 10),
    (8, 7),
    (9, 8),
    (2, 4),
    (5, 5),
    (1, 4),
    (2, 6),
    (5, 6),
    (13, 4),
    (9, 1),
    (9, 2),
    (1, 8),
    (2, 10),
    (3, 9),
    (7, 8),
    (14, 10),
    (14, 5),
    (14, 7);

create view list_of_five_clients
    as select users.id,users.last_name, users.first_name, sum(products.price) as value
from orders
join users on orders.user_id=users.id
join orders_details on orders_details.order_id=orders.id
join products on orders_details.product_id=products.id
where orders.status='success' 
group by users.id
order by value desc
limit 5;

select * from list_of_five_clients;










