SELECT * from users WHERE id = 1;
SELECT * from customer WHERE id > 5;
SELECT * from customers_contact_person WHERE id = 3 OR id = 5;
SELECT * from phone WHERE number LIKE '2%';
SELECT * from email WHERE email LIKE '%dima%';
SELECT * from project WHERE id > 2 AND id < 6;
SELECT * from requirements WHERE id = 4;
SELECT * from scheduled_tests WHERE id >= 4;
SELECT * from performed_tests WHERE id >= 3 AND id <= 7;

SELECT customers_contact_person.id, customers_contact_person.name, surname, customers_contact_person.patronymic, email.email 
FROM customers_contact_person 
INNER JOIN email 
ON customers_contact_person.id = email.contact_person_id
WHERE customers_contact_person.id = 4;

SELECT * FROM project
WHERE customer_id = 2
AND date_of_ending IS NULL
ORDER BY date_of_beginning ASC;

SELECT * FROM requirements;

SELECT id, requirement_text, date_of_beginning, completion_mark
FROM requirements
WHERE completion_mark = 'tested, successful'
AND project_id > 3
ORDER BY date_of_beginning ASC;

SELECT * FROM scheduled_tests;

SELECT * FROM scheduled_tests
WHERE test_level = 'deep' AND
requirement_id <= 11
ORDER BY planned_execution_time ASC;

SELECT * FROM performed_tests;

SELECT * FROM performed_tests
WHERE scheduled_test_id < 5
ORDER BY result, datetime_of_beginning ASC;

SELECT requirements.id as "Номер требования",
requirements.requirement_text as "Текст требования",
requirements.date_of_beginning  as "Дата начала выполнения проекта",
requirements.completion_mark as "Отметка о завершении",
project.date_of_beginning as "Дата начала выполнения требования",
project.date_of_ending as "Дата начала окончания требования"
FROM requirements
FULL JOIN project
ON project.id = requirements.project_id
WHERE project_id > 3
ORDER BY requirements.date_of_beginning ASC;

SELECT requirements.id as "Номер требования",
requirements.requirement_text as "Текст требования",
requirements.date_of_beginning  as "Дата начала выполнения требования",
requirements.completion_mark as "Отметка о завершении",
project.date_of_beginning as "Дата начала выполнения проекта",
project.date_of_ending as "Дата окончания выполнения проекта"
FROM requirements
LEFT JOIN project
ON project.id = requirements.project_id
ORDER BY requirements.date_of_beginning ASC;

SELECT requirements.id as "Номер требования",
requirements.requirement_text as "Текст требования",
requirements.date_of_beginning  as "Дата начала выполнения требования",
requirements.completion_mark as "Отметка о завершении",
project.date_of_beginning as "Дата начала выполнения проекта",
project.date_of_ending as "Дата окончания выполнения проекта"
FROM requirements
RIGHT JOIN project
ON project.id = requirements.project_id
ORDER BY requirements.date_of_beginning ASC;

SELECT project_id, SUM(planned_time) AS total_planned_time
FROM requirements
GROUP BY project_id;

SELECT customer_id, COUNT(*) AS project_count
FROM project
GROUP BY customer_id;

SELECT scheduled_test_id, AVG(execution_time) AS avg_execution_time
FROM performed_tests
GROUP BY scheduled_test_id;

SELECT customer_id, COUNT(*) AS project_count
FROM project
GROUP BY customer_id
HAVING COUNT(*) >= 2;