create table if not exists character
(
    id         integer not null
        primary key,
    first_name varchar(255),
    last_name  varchar(255),
    role       integer,
    sex        integer,
    father     integer
        constraint fkogrd477pxprsy23xhrjah9r0m
            references character,
    mother     integer
        constraint fka820jpic2o18cmdxh66648xji
            references character
);

alter table character
    owner to dione;

