--Activity 9

-- Create the customers table
create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

-- Insert values into it
insert all
into customers values (3002, 'Nick Rimando', 'New York', 100, 5001)
into customers values (3007, 'Brad Davis', 'New York', 200, 5001)
into customers values (3005, 'Graham Zusi', 'California', 200, 5002)
into customers values (3008, 'Julian Green', 'London', 300, 5002)
into customers values (3004, 'Fabian Johnson', 'Paris', 300, 5006)
into customers values (3009, 'Geoff Cameron', 'Berlin', 100, 5003)
into customers values (3003, 'Jozy Altidor', 'Moscow', 200, 5007)
into customers values (3001, 'Brad Guzan', 'London', 300, 5005)
select 1 from dual;

select * from customers;
select * from salesman;

-- Write an SQL statement to know which salesman are working for which customer.
SELECT  a.customer_name
        ,b.salesman_name
        ,b.commission
        FROM customers a 
INNER JOIN salesman b ON a.salesman_id=b.salesman_id;


select * from customers;
select * from salesman;
-- Write an SQL statement to make a list in ascending order for the customer who holds a grade less than 300 and works either through a salesman
SELECT  a.customer_name
        ,a.grade
        ,b.salesman_name
        FROM customers a 
LEFT OUTER JOIN salesman b ON a.salesman_id=b.salesman_id 
WHERE a.grade<300 
ORDER BY a.grade asc;