DROP TABLE IF exists menu;
CREATE SEQUENCE menu_id_seq;
CREATE TABLE menu (
    id smallint NOT NULL DEFAULT nextval('menu_id_seq') PRIMARY KEY,
    title varchar(255),
    body varchar(255)
);
ALTER SEQUENCE menu_id_seq OWNED BY menu.id;

DROP TABLE IF exists user_account;
CREATE SEQUENCE user_id_seq;
CREATE TABLE user_account (
    id smallint NOT NULL DEFAULT nextval('user_id_seq') PRIMARY KEY,
    username varchar(255),
    password varchar(255)
);
ALTER SEQUENCE user_id_seq OWNED BY user_account.id;
