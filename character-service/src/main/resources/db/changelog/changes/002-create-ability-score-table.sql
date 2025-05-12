--liquibase formatted sql

--changeset kasimov:002-create-ability-score-table.sql
create table if not exists ability_score(
    id bigserial primary key,
    ability varchar(255) not null,
    base_score integer not null,
    background_modifier integer not null check (background_modifier <= 3),
    total integer not null,
    ability_modifier integer not null,
    character_id BIGINT not null,
    constraint fk_character foreign key (character_id) references character(id) on delete cascade
);
