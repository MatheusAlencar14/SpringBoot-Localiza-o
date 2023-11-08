create table tb_cidade (
    id_cidade bigint not null primary key,
    nome varchar(50) not null,
    habitantes bigint
);

insert into tb_cidade
    (id_cidade, nome, habitantes)
values
    (1, 'Gama', 200500),
    (2, 'Santa Maria', 23499),
    (3, 'Recanto das Emas', 532);