alter table articles
    add column api_key varchar(255);

alter table countries
    add column api_key varchar(255);

alter table employees
    add column api_key varchar(255);

alter table orders
    add column api_key varchar(255);

alter table suppliers
    add column api_key varchar(255);