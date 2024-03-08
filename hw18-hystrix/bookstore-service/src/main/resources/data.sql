insert into authors(name)
values ('Author_1'), ('Author_2'), ('Author_3'), ('Author_4'), ('Author_5');

insert into genres(genre)
values ('Genre_1'), ('Genre_2'), ('Genre_3'),
       ('Genre_4'), ('Genre_5'), ('Genre_6');

insert into books(title, author_id, genre_id)
values ('BookTitle_1', 1, 3), ('BookTitle_2', 2, 6), ('BookTitle_3', 3, 5);

insert into comments(comment, book_id)
values ('Comment_1', 1), ('Comment_1', 2), ('Comment_1', 3),
       ('Comment_2', 1), ('Comment_2', 2);