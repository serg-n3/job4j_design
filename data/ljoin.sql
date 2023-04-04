

create table departments (
    id serial primary key,
    name varchar(255)	
);

insert into departments(id, name)
values
(1,'Отдел ремонта'),
(2,'Отдел гарантии'),
(3, 'Отдел продаж'),
(4,'Отдел доставки'),
(5, 'Отдел кадров' ),
(6,'Отдел поддержки');


create table employees(
    id serial primary key,
    name varchar(255),
	id_depatpent integer references departments(id)
);

insert into employees(id, name,id_depatpent)
values
(1,'Иванов',1),
(2,'Петров',2),
(3,'Абрамов',2),
(4,'Борисов',3),
(5,'Антошин',4),
(6,'Курочкин',3),
(7,'Блинов',5),
(8,'Сидоров',4);

select * 
from employees e
left join departments d on e.id_depatpent = d.id;

select * 
from employees e
right join departments d on e.id_depatpent = d.id;

select * 
from employees e
full join departments d on e.id_depatpent = d.id;

select * 
from departments d  
cross join employees e;

select * 
from departments d
left join employees e on d.id = e.id_depatpent 
where e.id_depatpent is null;

select d.name, e.name 
from employees e
left join departments d on e.id_depatpent = d.id;

select d.name, e.name 
from departments d
right join employees e on d.id = e.id_depatpent;

create table teens(
	id serial primary key,
	name varchar(250),
	gender varchar(1)
);

insert into teens(name, gender)
values
	('Вася', 'М'),
	('Петя', 'М'),
	('Маша', 'Ж'),
	('Оля', 'Ж'),
	('Наташа', 'Ж'),
	('Олег', 'М');

select e.name, e.gender, a.gender, a.name 
from teens e
cross join teens a
where e.gender != a.gender









