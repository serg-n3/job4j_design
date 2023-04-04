
create or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.1
	where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_t
    before insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax();
	
	
create or replace function tax_row()
    returns trigger as
$$
    BEGIN		
        update products
        set price = price + price * 0.1
		where id = new.id;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';	

create trigger tax_row_trigger
    after insert
    on products
    for each row
    execute procedure tax_row();
	
	
create or replace function inserty()
    returns trigger as
$$
    BEGIN
		insert into history_of_price (name, price, date) 
		VALUES (new.name, new.price, current_date);                
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';	

create trigger inserty_trigger
    before insert
    on products
    for each row
    execute procedure inserty();	







