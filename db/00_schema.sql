DROP TABLE IF exists menu;
CREATE SEQUENCE menu_id_seq;
CREATE TABLE menu (
    id smallint NOT NULL DEFAULT nextval('menu_id_seq') PRIMARY KEY,
    name varchar(255),
    description varchar(255),
    price money,
    spice smallint,
    is_gluten_free boolean
);
ALTER SEQUENCE menu_id_seq OWNED BY menu.id;

DROP TABLE IF exists user_account;
CREATE SEQUENCE user_id_seq;
CREATE TABLE user_account (
    id smallint NOT NULL DEFAULT nextval('user_id_seq') PRIMARY KEY,
    username varchar(255),
    hs512_password varchar(255),
    salt varchar(255)
);
ALTER SEQUENCE user_id_seq OWNED BY user_account.id;

