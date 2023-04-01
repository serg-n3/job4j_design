create table first(
id serial primary key,
name char(256),
age integer,
comment text
);
insert into first(name, age, comment) values ('Ivan', 25, 'good friend');
update first set age = 23;
delete from first;