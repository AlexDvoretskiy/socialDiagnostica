-- Категории ----------------------------------------------------------------
insert into diagnostic_category (category_name) values ('Диагностика психических состояний');
insert into diagnostic_category (category_name) values ('Личностные опросники');
insert into diagnostic_category (category_name) values ('Профориентационные тесты');
insert into diagnostic_category (category_name) values ('Семейные, гендерные тесты');

-- Метрики (тестовые) -------------------------------------------------------
insert into diagnostic_metric (metric_formula, description) values ('avarage value', 'среднее арифметическое всех показателей');
insert into diagnostic_metric (metric_formula, description) values ('max value', 'максимальное значение');
insert into diagnostic_metric (metric_formula, description) values ('sum value', 'Сумма значений баллов');

-- Тесты ---------------------------------------------------------------------
-- Данные для категории "Диагностика психических состояний"
insert into diagnostic_test(category_id, metric_id, test_name, test_description, question_count, test_duration)
values(1, 3, 'В порядке ли ваши нервы?', 'В порядке ли ваши нервы?', 10, 5);


insert into diagnostic_test(category_id, metric_id, test_name, test_description, question_count, test_duration)
values(1, 1, 'Психологическое состояние №2', 'Тест на психологическое состояние №2', 15, 10);
insert into diagnostic_test(category_id, metric_id, test_name, test_description, question_count, test_duration)
values(1, 2, 'Психологическое состояние №3', 'Тест на психологическое состояние №3', 15, 8);
insert into diagnostic_test(category_id, metric_id, test_name, test_description, question_count, test_duration)
values(2, 1, 'Индивидуальное состояние №1', 'Тест на индивидуальное состояние №1', 20, 15);
insert into diagnostic_test(category_id, metric_id, test_name, test_description, question_count, test_duration)
values(2, 2, 'Индивидуальное состояние №2', 'Тест на индивидуальное состояние №2', 25, 20);
insert into diagnostic_test(category_id, metric_id, test_name, test_description, question_count, test_duration)
values(3, 1, 'Семейное состояние №1', 'Тест на семейное состояние №1', 30, 20);
insert into diagnostic_test(category_id, metric_id, test_name, test_description, question_count, test_duration)
values(3, 1, 'Семейное состояние №2', 'Тест на семейное состояние №2', 25, 15);


-- Типы вопросов -------------------------------------------------------------
insert into question_type(question_type_name) values ('Тест с двумя вариантами ответов');
insert into question_type(question_type_name) values ('Тест с несколькими вариантами ответов');
insert into question_type(question_type_name) values ('Тест с единственным правильным ответом');

--Вопросы --------------------------------------------------------------------
-- Вопросы для теста "В порядке ли ваши нервы?"
insert into diagnostic_question(test_id, question_type_id, description)
values ('1','3','Раздражает ли вас смятая страница газеты, которую вы хотите прочитать?');
insert into diagnostic_question(test_id, question_type_id, description)
values ('1','3','Раздражает ли вас женщина «в летах», одетая, как молоденькая девушка?');
insert into diagnostic_question(test_id, question_type_id, description)
values ('1','3','Раздражает ли вас чрезмерная близость собеседника (допустим, в трамвае в час пик)?');
insert into diagnostic_question(test_id, question_type_id, description)
values ('1','3','Раздражает ли вас курящая на улице женщина?');
insert into diagnostic_question(test_id, question_type_id, description)
values ('1','3','Раздражает ли вас когда какой-то человек кашляет в вашу сторону?');
insert into diagnostic_question(test_id, question_type_id, description)
values ('1','3','Раздражает ли вас когда кто-то грызет ногти?');
insert into diagnostic_question(test_id, question_type_id, description)
values ('1','3','Раздражает ли вас когда кто-то смеется невпопад?');
insert into diagnostic_question(test_id, question_type_id, description)
values ('1','3','Раздражает ли вас когда кто-то пытается учить вас, что и как нужно делать?');
insert into diagnostic_question(test_id, question_type_id, description)
values ('1','3','Раздражает ли вас когда любимая девушка (юноша) постоянно опаздывает?');
insert into diagnostic_question(test_id, question_type_id, description)
values ('1','3','когда в кинотеатре сидящий перед вами все время вертится и комментирует сюжет фильма?');


-- Ответы --------------------------------------------------------------------
-- Ответы для теста "В порядке ли ваши нервы?"
insert into diagnostic_answer(question_id, description, cost) values ('1','очень', 3);
insert into diagnostic_answer(question_id, description, cost) values ('1','не особенно', 1);
insert into diagnostic_answer(question_id, description, cost) values ('1','ни в коем случае', 0);
insert into diagnostic_answer(question_id, description, cost) values ('2','очень', 3);
insert into diagnostic_answer(question_id, description, cost) values ('2','не особенно', 1);
insert into diagnostic_answer(question_id, description, cost) values ('2','ни в коем случае', 0);
insert into diagnostic_answer(question_id, description, cost) values ('3','очень', 3);
insert into diagnostic_answer(question_id, description, cost) values ('3','не особенно', 1);
insert into diagnostic_answer(question_id, description, cost) values ('3','ни в коем случае', 0);
insert into diagnostic_answer(question_id, description, cost) values ('4','очень', 3);
insert into diagnostic_answer(question_id, description, cost) values ('4','не особенно', 1);
insert into diagnostic_answer(question_id, description, cost) values ('4','ни в коем случае', 0);
insert into diagnostic_answer(question_id, description, cost) values ('5','очень', 3);
insert into diagnostic_answer(question_id, description, cost) values ('5','не особенно', 1);
insert into diagnostic_answer(question_id, description, cost) values ('5','ни в коем случае', 0);
insert into diagnostic_answer(question_id, description, cost) values ('6','очень', 3);
insert into diagnostic_answer(question_id, description, cost) values ('6','не особенно', 1);
insert into diagnostic_answer(question_id, description, cost) values ('6','ни в коем случае', 0);
insert into diagnostic_answer(question_id, description, cost) values ('7','очень', 3);
insert into diagnostic_answer(question_id, description, cost) values ('7','не особенно', 1);
insert into diagnostic_answer(question_id, description, cost) values ('7','ни в коем случае', 0);
insert into diagnostic_answer(question_id, description, cost) values ('8','очень', 3);
insert into diagnostic_answer(question_id, description, cost) values ('8','не особенно', 1);
insert into diagnostic_answer(question_id, description, cost) values ('8','ни в коем случае', 0);
insert into diagnostic_answer(question_id, description, cost) values ('9','очень', 3);
insert into diagnostic_answer(question_id, description, cost) values ('9','не особенно', 1);
insert into diagnostic_answer(question_id, description, cost) values ('9','ни в коем случае', 0);
insert into diagnostic_answer(question_id, description, cost) values ('10','очень', 3);
insert into diagnostic_answer(question_id, description, cost) values ('10','не особенно', 1);
insert into diagnostic_answer(question_id, description, cost) values ('10','ни в коем случае', 0);