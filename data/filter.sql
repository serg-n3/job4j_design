
create table product(
    id serial primary key,
    name varchar(255),
	type_id int,
	expired_date date,
    price float
);

insert into product(id, name, type_id, expired_date, price)
values
(1,'Сыр плавленный', 2,'2023-01-12',345),
(2,'Сыр моцарелла', 2,'2023-05-15',600),
(3, 'Сыр косичка', 2,'2023-05-05',267),
(4,'Сыр шоколадный',2,'2023-05-25',432),
(5, 'Домик в деревне', 1,'2023-06-22',278),
(6,'Петмол',1,'2023-06-11',345),
(7,'Простоквашино',1,'2023-06-12',600),
(8,'Латона',1,'2023-06-05',128),
(9,'мороженое эскимо',3,'2023-06-11',125),
(10,'мороженое стаканчик',3,'2023-06-12',110),
(11,'Фруктовый лед',3,'2023-06-05',138);

create table type(
    id serial primary key,
    name varchar(255)
);

insert into type(id, name)
values
(1,'МОЛОКО'),
(2,'СЫР'),
(3,'МОРОЖЕНОЕ');

select p.id,p.name, p.type_id, p.expired_date, p.price
from product p
join type t on p.type_id=t.id
where t.id=2;

select p.id, p.name, p.type_id, p.expired_date, p.price
from product p
type t on p.type_id=t.id
where p.name like '%мороженое%';

select p.id, p.name, p.type_id, p.expired_date, p.price
from product p
join type t on p.type_id=t.id
where p.expired_date<now();

select name, max(price) as pr
from product
where price = (select max(price) from product)
group by name;


select t.name, count(p.name)
from product p
join type t on p.type_id=t.id
group by t.name;

select t.name, count(p.name) as count
from product p
join type t on p.type_id=t.id
group by t.name
having count(p.name) <10;

select t.name,p.name
from product p
join type t on p.type_id=t.id 





