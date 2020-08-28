
create table if not exists diagnostic_category (
	category_id serial not null constraint PK_diagnostic_category primary key,
	category_name varchar not null
);

create table if not exists diagnostic_metric (
    metric_id serial not null constraint PK_diagnostic_metric primary key,
    metric_formula varchar,
    description varchar
);

create table if not exists diagnostic_test (
	test_id serial not null constraint PK_diagnostic_test primary key,
	category_id integer not null references diagnostic_category (category_id),
	metric_id integer not null references diagnostic_metric (metric_id),
	test_name varchar not null,
	test_description varchar,
  	question_count smallint,
    test_duration decimal
);

create table if not exists question_type (
    question_type_id serial not null constraint PK_question_type primary key,
    question_type_name varchar not null
);

create table if not exists diagnostic_question (
	question_id serial not null constraint PK_diagnostic_question primary key,
	test_id integer not null references diagnostic_test (test_id),
	question_type_id integer not null references question_type (question_type_id),
	description varchar not null,
    duration decimal
);

create table if not exists diagnostic_answer (
	answer_id serial not null constraint PK_diagnostic_answer primary key,
	question_id integer not null references diagnostic_question (question_id),
	description varchar not null,
	cost integer not null
);

create table if not exists diagnostic_test_result (
    test_result_id serial not null constraint PK_diagnostic_test_result primary key,
    test_id integer not null constraint FK_test_result_tests references diagnostic_test (test_id),
    user_id integer not null constraint FK_test_result_users references users (id),
    result_value varchar not null,
    result_data jsonb
);