--liquibase formatted sql

--changeset ashvedov:1
insert into wallet (id, balance)
VALUES ('35132472-c7f9-4723-9be4-21728a493aba', 2000);
insert into wallet (id, balance)
VALUES ('d2a53610-7dfa-47d3-aa19-0921115c2bfc', 4000);
insert into wallet (id, balance)
VALUES ('d5579c4c-a6c2-4dd3-b157-93bc6bfb67c4', 8000);
insert into wallet (id, balance)
VALUES ('412ff3c7-c07e-44ef-9504-91686fb721d7', 10000);
insert into wallet (id, balance)
VALUES ('2acb0928-d313-4b2d-b479-43443e5d5276', 12000);