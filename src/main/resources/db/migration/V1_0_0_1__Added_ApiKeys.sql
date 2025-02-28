create sequence articles_seq start with 1 increment by 50;
create sequence countries_seq start with 1 increment by 50;
create sequence employees_seq start with 1 increment by 50;
create sequence orders_seq start with 1 increment by 50;
create sequence suppliers_seq start with 1 increment by 50;
create table articles
(
    id          bigint       not null,
    api_key     varchar(255),
    name        varchar(255) not null,
    description varchar(255),
    category    char(1)      not null,
    price       float4       not null,
    quantity    integer,
    primary key (id)
);
create table countries
(
    country_id bigint       not null,
    api_key    varchar(255),
    name       varchar(255) not null,
    iso2code   varchar(255) not null,
    iso3code   varchar(255) not null,
    area_code  integer      not null,
    primary key (country_id)
);
create table employees
(
    id           bigint       not null,
    api_key      varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    email        varchar(255),
    birthdate    date         not null,
    salary       float4       not null,
    department   varchar(255) not null,
    position     varchar(255) not null,
    phone_type   char(1),
    extension    integer,
    serial_code  varchar(255),
    address_type char(1),
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
    quantity   integer
);
create table orders
(
    id            bigint  not null,
    api_key       varchar(255),
    order_date    date    not null,
    order_status  char(1) not null,
    delivery_date date    not null,
    supplier_id   bigint  not null,
    employees_id  bigint  not null,
    primary key (id)
);
create table suppliers
(
    id           bigint       not null,
    api_key      varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    email        varchar(255),
    birthdate    date         not null,
    company_name varchar(255) not null,
    phone_type   char(1),
    serial_code  varchar(255),
    extension    integer,
    address_type char(1),
    street       varchar(255),
    zip_code     varchar(255),
    city         varchar(255),
    country_id   bigint,
    country_code integer,
    area_code    integer,
    primary key (id)
);
alter table if exists employees add constraint FK_supplier_country foreign key (country_id) references countries;
alter table if exists order_items add constraint FK_order_item_article foreign key (article_id) references articles;
alter table if exists order_items add constraint FK_order_item_order foreign key (order_id) references orders;
alter table if exists orders add constraint FK_order_employee foreign key (employees_id) references employees;
alter table if exists orders add constraint FK_order_supplier foreign key (supplier_id) references suppliers;
alter table if exists suppliers add constraint FK_supplier_country foreign key (country_id) references countries;