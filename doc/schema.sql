DROP TABLE IF exists menu;
CREATE SEQUENCE menu_id_seq;
CREATE TABLE menu (
    id smallint NOT NULL DEFAULT nextval('menu_id_seq') PRIMARY KEY,
    title varchar(255),
    body varchar(255)
);
ALTER SEQUENCE menu_id_seq OWNED BY menu.id;