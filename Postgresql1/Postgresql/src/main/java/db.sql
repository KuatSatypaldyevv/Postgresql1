CREATE TABLE users (
                       userId serial primary key,
                       username varchar(200) UNIQUE,
                       password numeric not null,

);
ALTER TABLE users ALTER COLUMN password TYPE character varying(255);


