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

CREATE TABLE IF NOT EXISTS book_shop.user_entity
(
    user_id         text,
    email           text,
    name            text,
    gender          text,
    type            text,
    address         text,
    phone_number    text,
    date_of_birth   text
    PRIMARY KEY ((user_id, email))
    );
