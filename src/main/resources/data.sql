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
    (3, 'Recanto das Emas', 532),
    (4, 'Taguatinga', 549213),
    (5, 'Guará', 354846),
    (6, 'Asa Sul', 84654),
    (7, 'Sudoeste', 75400),
    (8, 'Brazlândia', 876402),
    (9, 'Ceilândia', 654020),
    (10, 'Jardim Botânico', 6501);