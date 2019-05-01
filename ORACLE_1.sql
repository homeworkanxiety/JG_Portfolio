--Add comment for git
--DDL TABLE CREATION
--Customer table: Contains important customer information such as contact information and purchasing information.
CREATE TABLE customers (
    customer_id NUMBER,
    customer_first VARCHAR2 (50 CHAR),
    customer_last VARCHAR2(50 CHAR),
    contact NUMBER,
    address VARCHAR2(50 CHAR),
    CONSTRAINT customer_pk PRIMARY KEY (customer_id)
);

--Warehouse table: Contains data on the warehouses or stores where costumers purchase their cpus. 
CREATE TABLE warehouse (
    warehouse_id NUMBER,
    warehouse_name  VARCHAR2(50 CHAR),
    warehouse_location VARCHAR2(50 CHAR),
    warehouse_contact NUMBER,
    warehouse_mgmt VARCHAR2(50 CHAR),
    CONSTRAINT warehouse_id_pk PRIMARY KEY (warehouse_id)
);


--Order table: contains the order_id, bridge_id, and customer_id.
CREATE TABLE orders (
    order_id NUMBER, 
    warehouse_id NUMBER,
    customer_id NUMBER,
    CONSTRAINT order_pk PRIMARY KEY (order_id), 
    CONSTRAINT warehouse_id_fk
    FOREIGN KEY(warehouse_id) REFERENCES warehouse(warehouse_id),
    CONSTRAINT customer_id_fk
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
--factory table: contains data on the factory delivering supplies to the warehouse. 
CREATE TABLE factory (
    factory_id NUMBER,
    mgmt NUMBER,
    deliveries_per_day NUMBER
    
);



-----------------------------------------------------------
--DML POPULATING TABLES
-----------------------------------------------------------

DELETE FROM customers;
DELETE FROM factory;
DELETE FROM orders;
DELETE FROM warehouse;
--Customers DML
INSERT INTO customers (customer_id, customer_first, customer_last, contact, address)
VALUES (001, 'john', 'lam',4434892627, '11 Blank Street');

INSERT INTO customers (customer_id, customer_first, customer_last, contact, address)
VALUES (002, 'Jan', 'Deer',4444443433,'12 Pencil Street');

INSERT INTO customers (customer_id, customer_first, customer_last, contact, address)
VALUES (003, 'jim', 'Obrien', 3333332323, '10 Gray Street');

INSERT INTO customers (customer_id, customer_first, customer_last, contact, address)
VALUES (004, 'jack', 'Doyle', 1231233333, '9 Purple Street');

INSERT INTO customers (customer_id, customer_first, customer_last, contact, address)
VALUES (005, 'junie', 'Muser', 4324331111, '8 Blue Street');

INSERT INTO customers (customer_id, customer_first, customer_last, contact, address)
VALUES (006, 'bob', 'Smith', 1233334411, '7 Green Street');

INSERT INTO customers (customer_id, customer_first, customer_last, contact, address)
VALUES (007, 'steve', 'Grechen', 1239991234, '6 Pink Street');

INSERT INTO customers (customer_id, customer_first, customer_last, contact, address)
VALUES (008, 'annie', 'Weber', 3431232222, '5 Hyacinth STreet');

INSERT INTO customers (customer_id, customer_first, customer_last, contact, address)
VALUES (009, 'nan', 'Shoelace', 4441233322, '4 Teal Street');

--Warehouse DML
INSERT INTO warehouse (warehouse_id, warehouse_name, warehouse_location, warehouse_contact,warehouse_mgmt)
VALUES (00, 'grayDistributors', 'distributeville', 8888888888, 'Mr. Grant');

--Factory DML
INSERT INTO factory (factory_id, mgmt, deliveries_per_day) 
VALUES (0, 6666666666, 3);

--orders DML
INSERT INTO orders (order_id, warehouse_id, customer_id)
VALUES (1,00,001);
INSERT INTO orders (order_id, warehouse_id, customer_id)
VALUES (2, 00, 002);
INSERT INTO orders (order_id, warehouse_id, customer_id)
VALUES (3, 00, 003);
INSERT INTO orders (order_id, warehouse_id, customer_id)
VALUES (4, 00, 004);
INSERT INTO orders (order_id, warehouse_id, customer_id)
VALUES (5, 00, 005);
INSERT INTO orders (order_id, warehouse_id, customer_id)
VALUES (6, 00, 006);
INSERT INTO orders (order_id, warehouse_id, customer_id)
VALUES (7, 00, 007);
INSERT INTO orders (order_id, warehouse_id, customer_id)
VALUES (8, 00, 008);
INSERT INTO orders (order_id, warehouse_id, customer_id)
VALUES (9, 00, 009);

-------------------------------------------------------------------------------------------
--DESC,SELECT, and JOIN Statements

SELECT * FROM customers;
SELECT * FROM factory;
SELECT * FROM orders;
SELECT * FROM warehouse;

SELECT * FROM customers
FULL JOIN orders
ON customers.customer_id  = orders.order_id;


SELECT customer_last, address FROM customers;
SELECT customer_id, contact FROM customers WHERE customer_last = 'Weber';
SELECT customer_id FROM orders WHERE customer_id = 8;
SELECT * FROM orders WHERE customer_id > 7;
SELECT address FROM customers WHERE customer_first = 'Jan' AND contact = 4444443433;
SELECT customer_last FROM customers WHERE customer_first LIKE 'j%';
