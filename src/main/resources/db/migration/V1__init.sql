create table categories
(
    id    bigserial primary key,
    title varchar(255)
);
insert into categories (title)
values ('Food'),
       ('Inventory');

create table products
(
    id          bigserial primary key,
    title       varchar(255),
    price       int,
    category_id bigint references categories (id)
);
insert into products (title, price, category_id)
values ('Bread', 28, 1),
       ('Milk', 80, 1),
       ('Salt', 12, 1),
       ('Vinegar', 150, 1),
       ('Mayonnaise', 25, 1),
       ('Cheese', 450, 1),
       ('Rake', 1280, 2),
       ('Shovel', 800, 2),
       ('Axe', 2570, 2),
       ('Secateurs', 1500, 2);