

CREATE TABLE genres (
    id serial primary key,
    name VARCHAR(50) NULL
);
INSERT INTO genres (id, name)
VALUES
    (1, 'Rock'),
    (2, 'Pop'),
    (3, 'Rap'),
    (4, 'Jazz'),
    (5, 'Electronic'),
    (6, 'Metal');
CREATE TABLE artists (
    id serial primary key,
    name VARCHAR(50) NULL,
    genre_id INTEGER NULL references genres(id),
    is_group BOOLEAN NULL
);
INSERT INTO artists (id, name, genre_id, is_group)
VALUES
    (1, 'Skrillex', 5, False),
    (2, 'Eminem', 3, False),
    (3, 'Metallica', 6, True),
    (4, 'Linkin Park', 1, True),
    (5, 'Hardwell', 5, False),
    (6, '50 Cent', 3, False),
    (7, 'Slipknot', 6, True),
    (8, 'Green Day', 1, True),
    (9, 'Daft punk', 5, True),
    (10, 'Snoop Dogg', 3, False),
    (11, 'Korn', 6, True),
    (12, 'Blink 182', 1, True),
    (13, 'Maroon 5', 2, True);
	
select a.name as Исполнитель, g.name as Жанр
from genres as g
join artists as a on a.genre_id=g.id
where a.is_group=True;

select a.name as Исполнитель, g.name as Жанр
from genres as g
join artists as a on a.genre_id=g.id
where a.name like '%li%';

select a.name as Исполнитель, g.name as Жанр
from genres as g
join artists as a on a.genre_id=g.id
where g.name='Rap'
