--REM   Script: Activity5
--REM   Activity5

--Activity 5
INSERT INTO salesman VALUES(5008, 'James Hoog', 'Pandora', 12, 300);

UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;
