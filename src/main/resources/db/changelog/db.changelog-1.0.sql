--liquibase formatted sql

--changeset ashvedov:1
create table if not exists wallet
(
    id      uuid not null,
    balance bigint,
    primary key (id)
);