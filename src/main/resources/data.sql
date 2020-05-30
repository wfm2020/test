DROP TABLE IF EXISTS deliveryData;
DROP TABLE IF EXISTS pawnedItem;
DROP TABLE IF EXISTS customer cascade;

CREATE TABLE customer(
    ID int not null,
    firstname varchar(255),
    lastname varchar(255),
    email varchar(255) unique not null,
    birthdate date,
    phonenumber varchar(255),
    PRIMARY KEY (ID)
);

CREATE TABLE pawnedItem (
    ID int not null,
    name varchar(255),
    material varchar(255),
    weight float,
    price float,
    payed boolean,
    customerID int not null,
    PRIMARY KEY (ID),
    FOREIGN KEY (customerID) REFERENCES customer(ID)
);

INSERT INTO customer (ID, firstname, lastname, email, birthdate, phonenumber)
VALUES (4234,'John', 'Doe', 'john.doe@gmail.com', '1990-03-25', '0043727145692');

