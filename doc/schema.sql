drop table if exists menu;
create table menu (
    id SERIAL not null primary key,
    title varchar(255),
    body varchar(255)
);
