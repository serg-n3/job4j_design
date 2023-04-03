insert into role(id, name_role)
values
(1, 'Администратор'),
(2, 'Секретарь'),
(3, 'Пользователь'),
(4, 'Пользователь');
insert into category(id, name_category)
values
(1, 'каттегория-1'),
(2, 'каттегория-2'),
(3, 'каттегория-3'),
(4, 'каттегория-4');
insert into state(id, name_state)
values
(1, 'в пути'),
(2, 'доставлен'),
(3, 'на складе');
insert into rules(id, name_rules)
values
(1, 'Добавлять'),
(2, 'Удалять'),
(3, 'Читать');
insert into users(id, first_name, last_name,id_role)
values
(1, 'Иван','Иванов',1),
(2, 'Петр','Петров',2),
(3, 'Сергей','Сидоров',3),
(4, 'Николай','Попов',4);
insert into item(id, name_item, id_user, id_category, id_state)
values
(1, 'заявка-1',1,1,2),
(2, 'заявка-2',2,2,2 ),
(3, 'заявка-3',2,3,1),
(4, 'заявка-4',3,3,3);

insert into comments(id, name_comment, id_item)
values
(1, 'коммент-1',1),
(2, 'коммент-2',2),
(3, 'коммент-3',3),
(4, 'коммент-4',1);

insert into attachs(id, name_attachs, id_item)
values
(1, 'файл-1',1),
(2, 'файл-2',2),
(3, 'файл-3',3),
(4, 'файл-4',1);

insert into rol_rul(id, id_role, id_rules)
values
(1, 1,1),
(2, 2,2),
(3, 1,2),
(4, 3,3);
