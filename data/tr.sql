DROP TABLE IF EXISTS decoration;
CREATE TABLE decoration(
    id serial PRIMARY KEY,
    name varchar(30),	 
	price real
);

INSERT INTO decoration(name, price)
VALUES ('Кольцо',  5000), 
		('Браслет',  6000), 
		('Цепочка',  2000),
		('Кулон',  5000),
		('Часы',  15000);
		
begin transaction;
select * from decoration;
select * from decoration;
select * from decoration;
commit;
begin transaction isolation level repeatable read;
update book set price = 500 where name = 'Цепочка';
commit;
begin transaction isolation level serializable;
select sum(price) from decoration;
update decoration set price = 10000 where name = 'Часы';
commit;









