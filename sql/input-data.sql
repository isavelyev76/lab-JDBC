INSERT INTO "users" 
(id, login   ,  password  , role) VALUES
(1 ,'admin1' , 'password1', 1   ),
(2 ,'tester1', 'password2', 2   ),
(3 ,'tester2', 'password3', 2   ),
(4 ,'tester3', 'password4', 1   ),
(5 ,'admin2' , 'password5', 1   );
--SELECT setval('id', 5);

-- Наполнение таблицы customer
INSERT INTO "customer" 
(id,     name    , legal_address, bank_details) VALUES
(1 , 'Компания А', 'Адрес А'    , 123456      ),
(2 , 'Компания Б', 'Адрес Б'    , 654321      ),
(3 , 'Компания В', 'Адрес В'    , 111222      ),
(4 , 'Компания Г', 'Адрес Г'    , 333444      ),
(5 , 'Компания Д', 'Адрес Д'    , 112233      ); -- bank_details пустое
--SELECT setval('id', 5);

-- Наполнение таблицы customers_contact_person
INSERT INTO "customers_contact_person"
(id,  name    ,   surname  ,  patronymic , customer_id) VALUES
(1 , 'Иван'   , 'Иванов'   , 'Иванович'  , 1          ),
(2 , 'Петр'   , 'Петров'   , 'Петрович'  , 1          ),
(3 , 'Сидор'  , 'Сидоров'  , 'Сидорович' , 2          ),
(4 , 'Алексей', 'Алексеев' , 'Алексеевич', 3          ),
(5 , 'Мария'  , 'Михайлова', 'Сергеевна' , 4          ),
(6 , 'Макар'  , 'Михайлов' , 'Угадайкин' , 4          ),
(7 , 'Прохор' , 'Михайлова', 'Афелков'   , 5          ); -- customer_id пустое
--SELECT setval('id', 5);

-- Наполнение таблицы phone
INSERT INTO "phone" 
(    number    , contact_person_id) VALUES
('123-456-7890', 1                ),
('098-765-4321', 2                ),
('555-555-5555', 3                ),
('444-444-4444', 4                ),
('777-777-777' , 5                ); -- номер пустой


-- Наполнение таблицы email
INSERT INTO "email" 
(         email          , contact_person_id) VALUES
('ivan@example.com'      , 1                 ),
('petr@example.com'      , 2                 ),
('sidor@example.com'     , 3                 ),
('sidor_homo@example.com', 3                 ),
('diman@example.com'     , 4                 ), -- email пустой
('maria@example.com'     , 5                 ); -- contact_person_id пустое

-- Наполнение таблицы project
INSERT INTO "project" 
(id,    name   , date_of_beginning , date_of_ending, customer_id) VALUES
(1 , 'Проект 1', '2023-01-01'      , '2023-06-01'  , 1          ),
(2 , 'Проект 2', '2023-02-01'      ,  NULL         , 2          ), -- date_of_ending пустое
(3 , 'Проект 3', '2023-03-01'      , '2023-09-01'  , 3          ),
(4 , 'Проект 4', '2023-04-01'      , '2023-10-01'  , 4          ),
(5 , 'Проект 5', '2023-05-01'      , '2023-11-01'  , 5          ); -- customer_id пустое
--SELECT setval('id', 5);

-- Наполнение таблицы requirements
INSERT INTO "requirements" 
(id, requirement_text, date_of_beginning, planned_time, priority_of_execution_time, criticality_level,      completion_mark      , probability_of_change, project_id) VALUES
(1 , 'Требование 1' , '2023-01-01'      , '01:00:00'  , 'high'                    , 'high'           , 'implementation completed', 'high'               , 1         ),
(2 , 'Требование 2' ,  NULL             , '02:00:00'  , 'medium'                  , 'medium'         , 'tested, successful'      , 'medium'             , 2         ), -- date_of_beginning пустое
(3 , 'Требование 3' , '2023-03-01'      , '01:30:00'  , 'low'                     , 'low'            ,  NULL                     , 'low'                , 3         ), -- completion_mark пустое
(4 , 'Требование 4' , '2023-04-01'      , '03:00:00'  , 'high'                    , 'high'           , 'tested, unsuccessful'    , 'high'               , 4         ),
(5 , 'Требование 5' , '2023-05-01'      , '02:30:00'  , 'medium'                  , 'medium'         , 'tested, needs revision'  , 'medium'             , 5      ); -- probability_of_change пустое
--SELECT setval('id', 5);

-- Наполнение таблицы scheduled_tests
INSERT INTO "scheduled_tests" 
(id, description_of_execution,    expected_result     , planned_execution_time, test_level, requirement_id) VALUES
(1 , 'Запланированный тест 1', 'Ожидаемый результат 1', '01:00:00'            , 'surface' , 1             ),
(2 , 'Запланированный тест 2', 'Ожидаемый результат 2', '02:00:00'            , 'medium'  , 2             ), -- requirement_id пустое
(3 , 'Запланированный тест 3', 'Ожидаемый результат 3', '01:30:00'            , 'deep'    , 3             ),
(4 , 'Запланированный тест 4', 'Ожидаемый результат 4', '03:00:00'            , 'surface' , 4             ),
(5 , 'Запланированный тест 5', 'Ожидаемый результат 5', '02:22:00'            , 'medium'  , 5             ); -- planned_execution_time пустое
--SELECT setval('id', 5);

-- Наполнение таблицы performed_tests
INSERT INTO "performed_tests"
(id, datetime_of_beginning, execution_time,  result , scheduled_test_id) VALUES
(1 , '2023-07-01 10:00:00', '01:00:00'    , 'passed', 1                ),
(2 , '2023-07-02 11:00:00', '02:00:00'    , 'failed', 2                ),
(3 , '2023-07-03 12:00:00', '03:00:00'    , 'passed', 3                ), -- execution_time пустое
(4 , '2023-07-04 13:00:00', '01:30:00'    , 'failed', 4                ), -- scheduled_test_id пустое
(5 , '2023-07-05 13:30:00', '02:00:00'    , 'passed', 5                ); -- datetime_o  f_beginning пустое
--SELECT setval('id', 5);