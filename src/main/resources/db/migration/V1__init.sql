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
       ('Secateurs', 1500, 2),
       ('Bread', 28, 1),
       ('Milk_2', 80, 1),
       ('Salt_2', 12, 1),
       ('Vinegar_2', 150, 1),
       ('Mayonnaise_2', 25, 1),
       ('Cheese_2', 450, 1),
       ('Rake_2', 1280, 2),
       ('Shovel_2', 800, 2),
       ('Axe_2', 2570, 2),
       ('Secateurs_2', 1500, 2),
       ('Bread_3', 28, 1),
       ('Milk_3', 80, 1),
       ('Salt_3', 12, 1),
       ('Vinegar_3', 150, 1),
       ('Mayonnaise_3', 25, 1),
       ('Cheese_3', 450, 1),
       ('Rake_3', 1280, 2),
       ('Shovel_3', 800, 2),
       ('Axe_3', 2570, 2),
       ('Secateurs_4', 1500, 2),
       ('Bread_4', 28, 1),
       ('Milk_4', 80, 1),
       ('Salt_4', 12, 1),
       ('Vinegar_4', 150, 1),
       ('Mayonnaise_4', 25, 1),
       ('Cheese_4', 450, 1),
       ('Rake_4', 1280, 2),
       ('Shovel_4', 800, 2),
       ('Axe_4', 2570, 2),
       ('Secateurs_4', 1500, 2);