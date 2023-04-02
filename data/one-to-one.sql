
create table users(
    id serial primary key,
    first_name text,
  	last_name text,
  	age integer
);

create table users_bio(
    id serial primary key,    
  	bio text
);

insert into users(first_name, last_name, age) values ('Ivan','Ivanov', 20);
insert into users(first_name, last_name, age) values ('Petr','petrov', 22);
insert into users(first_name, last_name, age) values ('Sergey','Sidorov', 25);
insert into users_bio(bio) values ('biography Ivanova');
insert into users_bio(bio) values ('biography Petrova');
insert into users_bio(bio) values ('biography Sidirova');

SELECT u.id, u.first_name,u.last_name, ud.bio
from users as u, users_bio as ud
where u.id=ud.id
