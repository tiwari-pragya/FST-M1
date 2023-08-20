REM   Script: Activity9
REM   Activity9

select * from orders;

select * from orders;

select * from salesman;

select * from orders;

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

INSERT ALL 
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001) 
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001) 
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002) 
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002) 
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

select * from customers;

select a.customer_name AS "Customer Name", a.city, b.salesman_name AS "Salesman" from customers a 
    inner join salesman b on a.salesman_id = b.salesman_id;

select a.customer_name AS "Customer Name", a.grade, b.salesman_name AS "Salesman" from customers a 
    left outer join salesman b on a.salesman_id = b.salesman_id where a.grade<300 order by a.customer_id;

select a.customer_name AS "Customer Name", b.salesman_name AS "Salesman", b.commission from customers a 
    inner join salesman b on a.salesman_id = b.salesman_id where commission>12;

SELECT a.order_no, a.order_date, a.purchase_amount,  
    b.customer_name AS "Customer Name", b.grade,  
    c.salesman_name AS "Salesman", c.commission  
    FROM orders a  
	INNER JOIN customers b ON a.customer_id=b.customer_id  
	INNER JOIN salesman c ON a.salesman_id=c.salesman_id;

