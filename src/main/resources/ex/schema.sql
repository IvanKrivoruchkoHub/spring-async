create table if not exists ingredients (
    id varchar(4) not null,
    name varchar(25) not null,
    type varchar(10) not null,
    PRIMARY KEY (id)
);

create table if not exists tacos (
    id identity,
    name varchar(50) not null,
    createdAt timestamp not null,
    PRIMARY KEY (id)
);

create table if not exists taco_ingredients (
    taco bigint not null,
    ingredient varchar(4) not null,
    foreign key (taco) references tacos(id),
    foreign key (ingredient) references ingredients(id)
);
