create table hellos(
    id serial primary key,
    text text not null
);

insert into hellos(text) values('Hello Postgres!');