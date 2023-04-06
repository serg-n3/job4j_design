
create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);
insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 15, 32);
insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 115);

begin transaction;
insert into products (name, producer, count, price) VALUES ('product_5', 'producer_5', 17, 45);
savepoint first_savepoint;
insert into products (name, producer, count, price) VALUES ('product_7', 'producer_7', 7, 7);
savepoint savepoint;
insert into products (name, producer, count, price) VALUES ('product_8', 'producer_8', 8, 8);
select * from products;
rollback to savepoint;
select * from products;
rollback to first_savepoint;
select * from products;
commit transaction;
