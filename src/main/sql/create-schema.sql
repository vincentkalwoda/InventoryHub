create sequence articles_seq start with 1 increment by 50;
create sequence countries_seq start with 1 increment by 50;
create sequence employees_seq start with 1 increment by 50;
create sequence orders_seq start with 1 increment by 50;
create sequence suppliers_seq start with 1 increment by 50;
create table articles
(
    id          bigint not null,
    name        varchar(255),
    description varchar(255),
    category    char(1) check ( category in ('E', 'F', 'C', 'T', 'L', 'O' ) ),
    price       float(24),
    quantity    integer,
    primary key (id)
);
create table countries
(
    id        bigint       not null,
    name      varchar(255) not null,
    iso2code  varchar(255) not null,
    iso3code  varchar(255) not null,
    area_code integer      not null,
    primary key (id)
);
create table employee_orders
(
    employee_id bigint not null,
    orders_id   bigint not null unique
);
create table employees
(
    id           bigint       not null,
    firstname    varchar(255),
    lastname     varchar(255),
    email        varchar(255),
    birthdate    date         not null,
    salary       float(24)    not null,
    department   varchar(255) not null,
    position     varchar(255) not null,
    phone_type   char(1) check ( phone_type in ('H', 'M', 'W', 'F', 'O') ),
    extension    integer,
    serial_code  varchar(255),
    address_type char(1) check ( address_type in ('B', 'S') ),
    street       varchar(255),
    zip_code     varchar(255),
    city         varchar(255),
    country_id   bigint,
    country_code integer,
    area_code    integer,
    primary key (id)
);
create table order_items
(
    order_id   bigint not null,
    article_id bigint,
    quantity   integer,
);
create table orders
(
    id            bigint not null,
    order_date    date   not null,
    order_status  char(1) check ( order_status in ('P', 'S', 'D', 'C') ),
    delivery_date date,
    supplier_id   bigint,
    employees_id  bigint,
    primary key (id)
);
create table suppliers
(
    id           bigint       not null,
    firstname    varchar(255),
    lastname     varchar(255),
    email        varchar(255),
    birthdate    date         not null,
    company_name varchar(255) not null,
    phone_type   char(1) check ( phone_type in ('H', 'M', 'W', 'F', 'O') ),
    serial_code  varchar(255),
    extension    integer,
    address_type char(1) check ( address_type in ('B', 'S') ),
    street       varchar(255),
    zip_code     varchar(255),
    city         varchar(255),
    country_id   bigint,
    country_code integer,
    area_code    integer,
    primary key (id)
);
alter table if exists employee_orders add constraint FKb4yjm8kfq5vrtapb0e76qfhqu foreign key (orders_id) references orders;
alter table if exists employee_orders add constraint FK_employee_order foreign key (employee_id) references employees;
alter table if exists employees add constraint FK92tibve1v3uf1egh3n3bnslgp foreign key (country_id) references countries;
alter table if exists order_items add constraint FK_order_item_article foreign key (article_id) references articles;
alter table if exists order_items add constraint FK_order_item_order foreign key (order_id) references orders;
alter table if exists orders add constraint FK_order_employee foreign key (employees_id) references employees;
alter table if exists orders add constraint FK_order_supplier foreign key (supplier_id) references suppliers;
alter table if exists suppliers add constraint FKjcuohexsi23vnpxi0t25kvwg7 foreign key (country_id) references countries;
