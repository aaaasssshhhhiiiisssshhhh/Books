CREATE KEYSPACE IF NOT EXISTS book_shop WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};


CREATE TABLE IF NOT EXISTS book_shop.book
(
    book_id         text,
    name            text,
    price           BIGINT,
    description     text,
    category        text,
    PRIMARY KEY ((book_id, name))
    );