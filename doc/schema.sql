drop table if exists menu;
create table menu (
    id integer not null primary key auto_increment,
    title varchar(255),
	body varchar(max)
);
