CREATE TABLE IF NOT EXISTS authors
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS genres
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS books
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    author_id INT          NOT NULL,
    genre_id  INT          NOT NULL,
    FOREIGN KEY (author_id) REFERENCES authors(id),
    FOREIGN KEY (genre_id) REFERENCES genres(id)
);

CREATE TABLE IF NOT EXISTS comments
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    text     VARCHAR(255) NOT NULL,
    book_id INT          NOT NULL,
    FOREIGN KEY (book_id) REFERENCES books(id)
);