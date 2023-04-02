

insert into users(id, first_name, last_name)
values
(1, 'Иван','Иванов'),
(2, 'Петр','Петров'),
(3, 'Сергей','Сидоров'),
(4, 'Николай','Попов');

insert into role(id, name_role, id_user)
values
(1, 'Администратор',1),
(2, 'Секретарь',2),
(3, 'Пользователь',3),
(4, 'Пользователь',4);

insert into item(id, name_item, id_user)
values
(1, 'заявка-1',1),
(2, 'заявка-2',2),
(3, 'заявка-3',2),
(4, 'заявка-4',3);

insert into comments(id, name_comment, id_user)
values
(1, 'коммент-1',1),
(2, 'коммент-2',2),
(3, 'коммент-3',3),
(4, 'коммент-4',1);

insert into attachs(id, name_attachs, id_user)
values
(1, 'файл-1',1),
(2, 'файл-2',2),
(3, 'файл-3',3),
(4, 'файл-4',1);

insert into category(id, name_category, id_user)
values
(1, 'каттегория-1',1),
(2, 'каттегория-2',2),
(3, 'каттегория-3',3),
(4, 'каттегория-4',1);

insert into state(id, name_state , id_user)
values
(1, 'в пути',1),
(2, 'доставлен',2),
(3, 'на складе',3),
(4, 'в пути',4);

insert into rules(id, name_rules)
values
(1, 'Добавлять',1),
(2, 'Удалять',2),
(3, 'Читать',3);

insert into rol_rul(id, id_role, id_rules)
values
(1, 1,1),
(2, 2,2),
(3, 1,2)
(3, 3,3);

