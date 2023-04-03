
create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

insert into devices(id, name, price)
values
(1,'Телефон', 10000),
(2,'Ноутбук', 29000),
(3, 'Микроволновка', 30000),
(4,'Часы',3000),
(5, 'Машина', 50),
(6,'Флешка',1000),
(7,'Утюг',3500),
(8,'Лампа',500);

create table people(
    id serial primary key,
    name varchar(255)
);

insert into people(id, name)
values
(1,'Иван'),
(2,'Петр'),
(3,'Сергей');

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices_people(id, device_id, people_id)
values
(1,1,1),
(2,2,1),
(3,3,2),
(4,4,2),
(5,5,3),
(6,6,3),
(7,7,3),
(8,8,1);

select avg(price) as Средняя_цена
from devices;

select p.name, round(avg(price)) as Средняя_цена
from devices as d
join devices_people as d_p on d.id=d_p.device_id
join people as p on p.id=d_p.people_id
group by p.name;

select p.name, round(avg(price)) as Средняя_цена
from devices as d
join devices_people as d_p on d.id=d_p.device_id
join people as p on p.id=d_p.people_id
group by p.name
having avg(price)>5000;
