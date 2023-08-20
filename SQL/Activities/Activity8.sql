REM   Script: Activity8
REM   Activity8

select max(purchase_amount), customer_id from orders group by customer_id;

select max(purchase_amount), salesman_id, order_date from orders where order_date=To_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY salesman_id, order_date;

select max(purchase_amount), order_no, order_date, customer_id from orders group by customer_id,order_date  
    having max(purchase_amount) in (2030, 3450, 5760, 6000);

select max(purchase_amount), order_date, customer_id from orders group by customer_id,order_date  
    having max(purchase_amount) in (2030, 3450, 5760, 6000);

