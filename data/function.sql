DROP TABLE IF EXISTS products;
DROP PROCEDURE delet(integer);
create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);	
insert into products(name, producer, count, price)
values
	('Капуста','Ферма_1',1,100),
	('Помидоры','Ферма_1',0,300),
	('Яблоки','Ферма_2',4,400),
	('Бананы','Ферма_2',5,700),
	('Огурцы','Ферма_3',8,800),
	('Лук','Ферма_4',0,900);

create or replace procedure delet(counter integer)
language 'plpgsql'
as $$
    BEGIN
    delete from products
	where products.count = counter;
    END
$$;
call delet(0);

create or replace function del(pric integer)
returns void
language 'plpgsql'
as
$$
    begin
        delete from products
	where products.price = pric;
    end;
$$;
select del(100);
select * from products;







