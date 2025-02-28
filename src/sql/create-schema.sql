create sequence articles_seq start with 1 increment by 50;
create sequence countries_seq start with 1 increment by 50;
create sequence employees_seq start with 1 increment by 50;
create sequence orders_seq start with 1 increment by 50;
create sequence suppliers_seq start with 1 increment by 50;
create table articles
(
    category    char(1)      not null,
    price       float4       not null,
    quantity    integer,
    id          bigint       not null,
    api_key     varchar(255),
    description varchar(255),
    name        varchar(255) not null,
    primary key (id)
);
create table countries
(
    area_code  integer      not null,
    country_id bigint       not null,
    iso2code   varchar(255) not null,
    iso3code   varchar(255) not null,
    name       varchar(255) not null,
    primary key (country_id)
);
create table employees
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    salary       float4       not null,
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    department   varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    position     varchar(255) not null,
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
create table order_items
(
    quantity   integer,
    article_id bigint,
    order_id   bigint not null
);
create table orders
(
    delivery_date date    not null,
    order_date    date    not null,
    order_status  char(1) not null,
    employees_id  bigint  not null,
    id            bigint  not null,
    supplier_id   bigint  not null,
    api_key       varchar(255),
    primary key (id)
);
create table suppliers
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    company_name varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
alter table if exists employees add constraint FK_supplier_country foreign key (country_id) references countries;
alter table if exists order_items add constraint FK_order_item_article foreign key (article_id) references articles;
alter table if exists order_items add constraint FK_order_item_order foreign key (order_id) references orders;
alter table if exists orders add constraint FK_order_employee foreign key (employees_id) references employees;
alter table if exists orders add constraint FK_order_supplier foreign key (supplier_id) references suppliers;
alter table if exists suppliers add constraint FK_supplier_country foreign key (country_id) references countries;
create sequence articles_seq start with 1 increment by 50;
create sequence countries_seq start with 1 increment by 50;
create sequence employees_seq start with 1 increment by 50;
create sequence orders_seq start with 1 increment by 50;
create sequence suppliers_seq start with 1 increment by 50;
create table articles
(
    category    char(1)      not null,
    price       float4       not null,
    quantity    integer,
    id          bigint       not null,
    api_key     varchar(255),
    description varchar(255),
    name        varchar(255) not null,
    primary key (id)
);
create table countries
(
    area_code  integer      not null,
    country_id bigint       not null,
    iso2code   varchar(255) not null,
    iso3code   varchar(255) not null,
    name       varchar(255) not null,
    primary key (country_id)
);
create table employees
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    salary       float4       not null,
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    department   varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    position     varchar(255) not null,
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
create table order_items
(
    quantity   integer,
    article_id bigint,
    order_id   bigint not null
);
create table orders
(
    delivery_date date    not null,
    order_date    date    not null,
    order_status  char(1) not null,
    employees_id  bigint  not null,
    id            bigint  not null,
    supplier_id   bigint  not null,
    api_key       varchar(255),
    primary key (id)
);
create table suppliers
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    company_name varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
alter table if exists employees add constraint FK_supplier_country foreign key (country_id) references countries;
alter table if exists order_items add constraint FK_order_item_article foreign key (article_id) references articles;
alter table if exists order_items add constraint FK_order_item_order foreign key (order_id) references orders;
alter table if exists orders add constraint FK_order_employee foreign key (employees_id) references employees;
alter table if exists orders add constraint FK_order_supplier foreign key (supplier_id) references suppliers;
alter table if exists suppliers add constraint FK_supplier_country foreign key (country_id) references countries;
create sequence articles_seq start with 1 increment by 50;
create sequence countries_seq start with 1 increment by 50;
create sequence employees_seq start with 1 increment by 50;
create sequence orders_seq start with 1 increment by 50;
create sequence suppliers_seq start with 1 increment by 50;
create table articles
(
    category    char(1)      not null,
    price       float4       not null,
    quantity    integer,
    id          bigint       not null,
    api_key     varchar(255),
    description varchar(255),
    name        varchar(255) not null,
    primary key (id)
);
create table countries
(
    area_code  integer      not null,
    country_id bigint       not null,
    iso2code   varchar(255) not null,
    iso3code   varchar(255) not null,
    name       varchar(255) not null,
    primary key (country_id)
);
create table employees
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    salary       float4       not null,
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    department   varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    position     varchar(255) not null,
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
create table order_items
(
    quantity   integer,
    article_id bigint,
    order_id   bigint not null
);
create table orders
(
    delivery_date date    not null,
    order_date    date    not null,
    order_status  char(1) not null,
    employees_id  bigint  not null,
    id            bigint  not null,
    supplier_id   bigint  not null,
    api_key       varchar(255),
    primary key (id)
);
create table suppliers
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    company_name varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
alter table if exists employees add constraint FK_supplier_country foreign key (country_id) references countries;
alter table if exists order_items add constraint FK_order_item_article foreign key (article_id) references articles;
alter table if exists order_items add constraint FK_order_item_order foreign key (order_id) references orders;
alter table if exists orders add constraint FK_order_employee foreign key (employees_id) references employees;
alter table if exists orders add constraint FK_order_supplier foreign key (supplier_id) references suppliers;
alter table if exists suppliers add constraint FK_supplier_country foreign key (country_id) references countries;
create sequence articles_seq start with 1 increment by 50;
create sequence countries_seq start with 1 increment by 50;
create sequence employees_seq start with 1 increment by 50;
create sequence orders_seq start with 1 increment by 50;
create sequence suppliers_seq start with 1 increment by 50;
create table articles
(
    category    char(1)      not null,
    price       float4       not null,
    quantity    integer,
    id          bigint       not null,
    api_key     varchar(255),
    description varchar(255),
    name        varchar(255) not null,
    primary key (id)
);
create table countries
(
    area_code  integer      not null,
    country_id bigint       not null,
    iso2code   varchar(255) not null,
    iso3code   varchar(255) not null,
    name       varchar(255) not null,
    primary key (country_id)
);
create table employees
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    salary       float4       not null,
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    department   varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    position     varchar(255) not null,
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
create table order_items
(
    quantity   integer,
    article_id bigint,
    order_id   bigint not null
);
create table orders
(
    delivery_date date    not null,
    order_date    date    not null,
    order_status  char(1) not null,
    employees_id  bigint  not null,
    id            bigint  not null,
    supplier_id   bigint  not null,
    api_key       varchar(255),
    primary key (id)
);
create table suppliers
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    company_name varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
alter table if exists employees add constraint FK_supplier_country foreign key (country_id) references countries;
alter table if exists order_items add constraint FK_order_item_article foreign key (article_id) references articles;
alter table if exists order_items add constraint FK_order_item_order foreign key (order_id) references orders;
alter table if exists orders add constraint FK_order_employee foreign key (employees_id) references employees;
alter table if exists orders add constraint FK_order_supplier foreign key (supplier_id) references suppliers;
alter table if exists suppliers add constraint FK_supplier_country foreign key (country_id) references countries;
create sequence articles_seq start with 1 increment by 50;
create sequence countries_seq start with 1 increment by 50;
create sequence employees_seq start with 1 increment by 50;
create sequence orders_seq start with 1 increment by 50;
create sequence suppliers_seq start with 1 increment by 50;
create table articles
(
    category    char(1)      not null,
    price       float4       not null,
    quantity    integer,
    id          bigint       not null,
    api_key     varchar(255),
    description varchar(255),
    name        varchar(255) not null,
    primary key (id)
);
create table countries
(
    area_code  integer      not null,
    country_id bigint       not null,
    iso2code   varchar(255) not null,
    iso3code   varchar(255) not null,
    name       varchar(255) not null,
    primary key (country_id)
);
create table employees
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    salary       float4       not null,
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    department   varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    position     varchar(255) not null,
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
create table order_items
(
    quantity   integer,
    article_id bigint,
    order_id   bigint not null
);
create table orders
(
    delivery_date date    not null,
    order_date    date    not null,
    order_status  char(1) not null,
    employees_id  bigint  not null,
    id            bigint  not null,
    supplier_id   bigint  not null,
    api_key       varchar(255),
    primary key (id)
);
create table suppliers
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    company_name varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
alter table if exists employees add constraint FK_supplier_country foreign key (country_id) references countries;
alter table if exists order_items add constraint FK_order_item_article foreign key (article_id) references articles;
alter table if exists order_items add constraint FK_order_item_order foreign key (order_id) references orders;
alter table if exists orders add constraint FK_order_employee foreign key (employees_id) references employees;
alter table if exists orders add constraint FK_order_supplier foreign key (supplier_id) references suppliers;
alter table if exists suppliers add constraint FK_supplier_country foreign key (country_id) references countries;
create sequence articles_seq start with 1 increment by 50;
create sequence countries_seq start with 1 increment by 50;
create sequence employees_seq start with 1 increment by 50;
create sequence orders_seq start with 1 increment by 50;
create sequence suppliers_seq start with 1 increment by 50;
create table articles
(
    category    char(1)      not null,
    price       float4       not null,
    quantity    integer,
    id          bigint       not null,
    api_key     varchar(255),
    description varchar(255),
    name        varchar(255) not null,
    primary key (id)
);
create table countries
(
    area_code  integer      not null,
    country_id bigint       not null,
    iso2code   varchar(255) not null,
    iso3code   varchar(255) not null,
    name       varchar(255) not null,
    primary key (country_id)
);
create table employees
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    salary       float4       not null,
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    department   varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    position     varchar(255) not null,
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
create table order_items
(
    quantity   integer,
    article_id bigint,
    order_id   bigint not null
);
create table orders
(
    delivery_date date    not null,
    order_date    date    not null,
    order_status  char(1) not null,
    employees_id  bigint  not null,
    id            bigint  not null,
    supplier_id   bigint  not null,
    api_key       varchar(255),
    primary key (id)
);
create table suppliers
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    company_name varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
alter table if exists employees add constraint FK_supplier_country foreign key (country_id) references countries;
alter table if exists order_items add constraint FK_order_item_article foreign key (article_id) references articles;
alter table if exists order_items add constraint FK_order_item_order foreign key (order_id) references orders;
alter table if exists orders add constraint FK_order_employee foreign key (employees_id) references employees;
alter table if exists orders add constraint FK_order_supplier foreign key (supplier_id) references suppliers;
alter table if exists suppliers add constraint FK_supplier_country foreign key (country_id) references countries;
create sequence articles_seq start with 1 increment by 50;
create sequence countries_seq start with 1 increment by 50;
create sequence employees_seq start with 1 increment by 50;
create sequence orders_seq start with 1 increment by 50;
create sequence suppliers_seq start with 1 increment by 50;
create table articles
(
    category    char(1)      not null,
    price       float4       not null,
    quantity    integer,
    id          bigint       not null,
    api_key     varchar(255),
    description varchar(255),
    name        varchar(255) not null,
    primary key (id)
);
create table countries
(
    area_code  integer      not null,
    country_id bigint       not null,
    iso2code   varchar(255) not null,
    iso3code   varchar(255) not null,
    name       varchar(255) not null,
    primary key (country_id)
);
create table employees
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    salary       float4       not null,
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    department   varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    position     varchar(255) not null,
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
create table order_items
(
    quantity   integer,
    article_id bigint,
    order_id   bigint not null
);
create table orders
(
    delivery_date date    not null,
    order_date    date    not null,
    order_status  char(1) not null,
    employees_id  bigint  not null,
    id            bigint  not null,
    supplier_id   bigint  not null,
    api_key       varchar(255),
    primary key (id)
);
create table suppliers
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    company_name varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
alter table if exists employees add constraint FK_supplier_country foreign key (country_id) references countries;
alter table if exists order_items add constraint FK_order_item_article foreign key (article_id) references articles;
alter table if exists order_items add constraint FK_order_item_order foreign key (order_id) references orders;
alter table if exists orders add constraint FK_order_employee foreign key (employees_id) references employees;
alter table if exists orders add constraint FK_order_supplier foreign key (supplier_id) references suppliers;
alter table if exists suppliers add constraint FK_supplier_country foreign key (country_id) references countries;
create sequence articles_seq start with 1 increment by 50;
create sequence countries_seq start with 1 increment by 50;
create sequence employees_seq start with 1 increment by 50;
create sequence orders_seq start with 1 increment by 50;
create sequence suppliers_seq start with 1 increment by 50;
create table articles
(
    category    char(1)      not null,
    price       float4       not null,
    quantity    integer,
    id          bigint       not null,
    api_key     varchar(255),
    description varchar(255),
    name        varchar(255) not null,
    primary key (id)
);
create table countries
(
    area_code  integer      not null,
    country_id bigint       not null,
    iso2code   varchar(255) not null,
    iso3code   varchar(255) not null,
    name       varchar(255) not null,
    primary key (country_id)
);
create table employees
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    salary       float4       not null,
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    department   varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    position     varchar(255) not null,
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
create table order_items
(
    quantity   integer,
    article_id bigint,
    order_id   bigint not null
);
create table orders
(
    delivery_date date    not null,
    order_date    date    not null,
    order_status  char(1) not null,
    employees_id  bigint  not null,
    id            bigint  not null,
    supplier_id   bigint  not null,
    api_key       varchar(255),
    primary key (id)
);
create table suppliers
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    company_name varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
alter table if exists employees add constraint FK_supplier_country foreign key (country_id) references countries;
alter table if exists order_items add constraint FK_order_item_article foreign key (article_id) references articles;
alter table if exists order_items add constraint FK_order_item_order foreign key (order_id) references orders;
alter table if exists orders add constraint FK_order_employee foreign key (employees_id) references employees;
alter table if exists orders add constraint FK_order_supplier foreign key (supplier_id) references suppliers;
alter table if exists suppliers add constraint FK_supplier_country foreign key (country_id) references countries;
create sequence articles_seq start with 1 increment by 50;
create sequence countries_seq start with 1 increment by 50;
create sequence employees_seq start with 1 increment by 50;
create sequence orders_seq start with 1 increment by 50;
create sequence suppliers_seq start with 1 increment by 50;
create table articles
(
    category    char(1)      not null,
    price       float4       not null,
    quantity    integer,
    id          bigint       not null,
    api_key     varchar(255),
    description varchar(255),
    name        varchar(255) not null,
    primary key (id)
);
create table countries
(
    area_code  integer      not null,
    country_id bigint       not null,
    iso2code   varchar(255) not null,
    iso3code   varchar(255) not null,
    name       varchar(255) not null,
    primary key (country_id)
);
create table employees
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    salary       float4       not null,
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    department   varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    position     varchar(255) not null,
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
create table order_items
(
    quantity   integer,
    article_id bigint,
    order_id   bigint not null
);
create table orders
(
    delivery_date date    not null,
    order_date    date    not null,
    order_status  char(1) not null,
    employees_id  bigint  not null,
    id            bigint  not null,
    supplier_id   bigint  not null,
    api_key       varchar(255),
    primary key (id)
);
create table suppliers
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    company_name varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
alter table if exists employees add constraint FK_supplier_country foreign key (country_id) references countries;
alter table if exists order_items add constraint FK_order_item_article foreign key (article_id) references articles;
alter table if exists order_items add constraint FK_order_item_order foreign key (order_id) references orders;
alter table if exists orders add constraint FK_order_employee foreign key (employees_id) references employees;
alter table if exists orders add constraint FK_order_supplier foreign key (supplier_id) references suppliers;
alter table if exists suppliers add constraint FK_supplier_country foreign key (country_id) references countries;
create sequence articles_seq start with 1 increment by 50;
create sequence countries_seq start with 1 increment by 50;
create sequence employees_seq start with 1 increment by 50;
create sequence orders_seq start with 1 increment by 50;
create sequence suppliers_seq start with 1 increment by 50;
create table articles
(
    category    char(1)      not null,
    price       float4       not null,
    quantity    integer,
    id          bigint       not null,
    api_key     varchar(255),
    description varchar(255),
    name        varchar(255) not null,
    primary key (id)
);
create table countries
(
    area_code  integer      not null,
    country_id bigint       not null,
    iso2code   varchar(255) not null,
    iso3code   varchar(255) not null,
    name       varchar(255) not null,
    primary key (country_id)
);
create table employees
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    salary       float4       not null,
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    department   varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    position     varchar(255) not null,
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
create table order_items
(
    quantity   integer,
    article_id bigint,
    order_id   bigint not null
);
create table orders
(
    delivery_date date    not null,
    order_date    date    not null,
    order_status  char(1) not null,
    employees_id  bigint  not null,
    id            bigint  not null,
    supplier_id   bigint  not null,
    api_key       varchar(255),
    primary key (id)
);
create table suppliers
(
    address_type char(1),
    area_code    integer,
    birthdate    date         not null,
    country_code integer,
    extension    integer,
    phone_type   char(1),
    country_id   bigint,
    id           bigint       not null,
    api_key      varchar(255),
    city         varchar(255),
    company_name varchar(255) not null,
    email        varchar(255),
    firstname    varchar(255),
    lastname     varchar(255),
    serial_code  varchar(255),
    street       varchar(255),
    zip_code     varchar(255),
    primary key (id)
);
alter table if exists employees add constraint FK_supplier_country foreign key (country_id) references countries;
alter table if exists order_items add constraint FK_order_item_article foreign key (article_id) references articles;
alter table if exists order_items add constraint FK_order_item_order foreign key (order_id) references orders;
alter table if exists orders add constraint FK_order_employee foreign key (employees_id) references employees;
alter table if exists orders add constraint FK_order_supplier foreign key (supplier_id) references suppliers;
alter table if exists suppliers add constraint FK_supplier_country foreign key (country_id) references countries;
