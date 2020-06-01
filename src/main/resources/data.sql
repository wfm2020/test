DROP TABLE IF EXISTS delivery_data cascade;
DROP TABLE IF EXISTS pawned_item cascade;
DROP TABLE IF EXISTS customer cascade;

CREATE TABLE customer(
    ID serial primary key,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255) unique not null,
    birth_date date,
    phone_number varchar(255)
);

CREATE TABLE delivery_data (
    ID serial primary key,
    delivery_date date not null
);

CREATE TABLE pawned_item (
    ID serial primary key,
    item_name varchar(255),
    material varchar(255),
    weight float,
    price float,
    accepted boolean,
    payed boolean,
    customer_id serial,
    delivery_data_id serial,
    FOREIGN KEY (customer_id) REFERENCES customer(ID),
    FOREIGN KEY (delivery_data_id) REFERENCES delivery_data(ID)
);

INSERT INTO customer (first_name, last_name, email, birth_date, phone_number)
VALUES ('John', 'Doe', 'john.doe@gmail.com', '1990-03-25', '0043727145692');

