


create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);
insert into fauna(id,name,avg_age,discovery_date)
values
(1,'isher',19000, date '1948-09-01'),
(2,'fiser',20000, null),
(3,'fisher',23000, date '2021-09-01'),
(4,'fiher',9000, date '1946-09-01'),
(5,'fisher',17000, date '2020-09-01'),
(6,'fiser',1000, null);
select * 
from fauna 
where name like '%fish%';
select * 
from fauna 
where avg_age between 10000  and 21000;
select * 
from fauna 
where discovery_date is null;
select * 
from fauna 
where discovery_date <'01.01.1950';

