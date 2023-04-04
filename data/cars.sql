
create table car_bodies  (
    id serial primary key,
    name varchar(255)	
);

insert into car_bodies(id, name)
values
(1,'Пикап'),
(2,'Кабриолет'),
(3, 'Хетчбэк'),
(4,'Купе'),
(5, 'Седан');


create table car_engines (
    id serial primary key,
    name varchar(255)	
);

insert into car_engines(id, name)
values
(1,'Дизельный'),
(2,'Бензиновый'),
(3,'Электрический');

create table car_transmissions  (
    id serial primary key,
    name varchar(255)	
);
insert into car_transmissions(id, name)
values
(1,'Автоматическая'),
(2,'Механическая'),
(3,'Робот'),
(4,'Вариатор');

create table cars   (
    id serial primary key,
    name varchar(255),	
	body_id integer references car_bodies(id),
	engine_id integer references car_engines(id),
	transmission_id integer references car_transmissions(id)
);

insert into cars(id, name, body_id, engine_id, transmission_id) 
values 
(1,'Mazda', 1, 2, 1), 
(2,'Honda', 2, 1, 2), 
(3,'Audi', 1, 2, 4), 
(4,'Ford', 4, 1, 2), 
(5,'Toyota', 4, 2, 1),
(6,'Kia', 2, null, 2), 
(7,'Skoda', 5, 1, null), 
(8,'Opel', null, 2, 1), 
(9,'Dodge', 5, 2, 4), 
(10,'Maserati', null, null, null);

select cars.id, cars.name, car_bodies.name, car_engines.name, car_transmissions.name
from cars
left join car_bodies on cars.body_id = car_bodies.id
left join car_engines on cars.engine_id = car_engines.id
left join car_transmissions on cars.transmission_id = car_transmissions.id;

select car_bodies.name
from car_bodies
left join cars on cars.body_id = car_bodies.id
where cars.body_id is null;

select car_engines.name
from car_engines
left join cars on cars.engine_id = car_engines.id
where cars.engine_id is null;

select car_transmissions.name
from car_transmissions
left join cars on cars.transmission_id = car_transmissions.id
where cars.transmission_id is null;










