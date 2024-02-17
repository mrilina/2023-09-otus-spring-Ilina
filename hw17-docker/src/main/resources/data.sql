insert into authors(name)
values ('Author_1'), ('Author_2'), ('Author_3');

insert into genres(genre)
values ('Genre_1'), ('Genre_2'), ('Genre_3'),
       ('Genre_4'), ('Genre_5'), ('Genre_6');

insert into books(title, author_id, genre_id)
values ('BookTitle_1', 1, 3), ('BookTitle_2', 2, 6), ('BookTitle_3', 3, 5);

insert into comments(comment, book_id)
values ('Comment_1', 1), ('Comment_1', 2), ('Comment_1', 3),
       ('Comment_2', 1), ('Comment_2', 2);

insert into users(username, password, authority)
values ('adm', '$2a$12$8pnMmhZwwsHvAQNcti0rGe/w3L24vwBNbondgNEzYCMcoNi7XsRqS', 'ROLE_ADMIN'),
       ('usr', '$2a$12$RikQvoFNSmWkX1SbfWQ9QOu2gZElz.i8w84uNMcbfUpAAwzcXMHwe', 'ROLE_USER');