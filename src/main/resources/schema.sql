create table if not exists wallet (
    id uuid not null,
    balance bigint,
    primary key (id)
);