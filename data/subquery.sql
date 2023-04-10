drop table if exists customers CASCADE;
drop table if exists orders CASCADE;
CREATE TABLE customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);
insert into customers(first_name,last_name,age,country)
values 
('Иван','Иванов',12,'Россия'),
('Петр','Петров',32,'США'),
('Андрей','Сидоров',22,'Канада'),
('Николай','Николаев',62,'Франция'),
('Сергей','Прошкин',12,'Англия');

Select * 
from customers
where age =(select min(age) from customers);

CREATE TABLE orders(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);
insert into orders(amount, customer_id )
values 
(12,1),
(32,4),
(22,5),
(4,4),
(7,5);
select * from customers
where id not in (select customer_id from orders);