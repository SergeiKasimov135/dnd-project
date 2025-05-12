--liquibase formatted sql

--changeset kasimov:create-character-table
create table if not exists character(
    id bigserial primary key,
    name varchar(255) not null,
    specie varchar(255) not null,
    subrace varchar(255),
    character_class varchar(255) not null,
    background varchar(255) not null
);
--rollback DROP TABLE IF EXISTS character
