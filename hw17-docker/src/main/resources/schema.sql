create table if not exists authors
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

create table if not exists genres
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    GENRE VARCHAR(255) NOT NULL
);

create table if not exists books
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    title     varchar(255) not null,
    genre_id  bigint references genres (id) on delete restrict on update cascade not null,
    author_id bigint references authors (id) on delete restrict on update cascade not null
);

create table if not exists comments
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    comment varchar(1000) not null,
    book_id bigint references books (id) on delete cascade on update cascade not null
);

create table if not exists users
(
    id      bigserial primary key,
    username varchar(255) not null unique,
    password varchar(1000) not null,
    authority varchar(255)
);