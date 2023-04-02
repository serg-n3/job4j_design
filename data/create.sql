
create table users(
	id serial primary key,
    first_name text,
	last_name text
);

create table role(
	id serial primary key,
    name_role text,
	id_user integer references users(id)
);

create table item(
	id serial primary key,
    name_item text,
	id_user integer references users(id)
);

create table comments (
	id serial primary key,
    name_comment  text,
	id_item integer references item(id)
);

create table attachs  (
	id serial primary key,
    name_attachs   text,
	id_item integer references item(id)
);

create table category   (
	id serial primary key,
    name_category   text,
	id_item integer references item(id)
);

create table state    (
	id serial primary key,
    name_state   text,
	id_item integer references item(id)
);

create table rules     (
	id serial primary key,
    name_rules    text	
);

create table rol_rul    (
	id serial primary key,    
	id_role integer references role(id),
	id_rules integer references rules(id)
);

