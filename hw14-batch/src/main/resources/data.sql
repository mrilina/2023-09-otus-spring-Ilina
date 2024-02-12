insert into authors (name)
values ('Author_1'),
       ('Author_2'),
       ('Author_3'),
       ('Author_4'),
       ('Author_5');

insert into genres (name)
values ('Genre_1'),
       ('Genre_2'),
       ('Genre_3'),
       ('Genre_4'),
       ('Genre_5');

insert into books (genre_id, author_id, title)
values (1, 1, 'BookTitle_1'),
       (4, 2, 'BookTitle_2'),
       (1, 3, 'BookTitle_3'),
       (2, 4, 'BookTitle_4'),
       (3, 3, 'BookTitle_5'),
       (4, 5, 'BookTitle_6');