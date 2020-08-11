
create table if not exists diagnostic_category (
	id serial not null constraint PK_diagnostic_category primary key,
	name varchar NOT NULL,
	color varchar
);

create table if not exists diagnostic_test (
	test_id serial not null constraint PK_diagnostic_test primary key,
	category_id integer not null references diagnostic_category (id),
	name varchar NOT NULL,
	description varchar,
  	question_count smallint,
    duration decimal
);

create table if not exists diagnostic_question (
	question_id serial not null constraint PK_diagnostic_question primary key,
	test_id integer not null references diagnostic_test (test_id),
	description varchar NOT NULL,
    duration decimal
);

create table if not exists diagnostic_answer (
	answer_id serial not null constraint PK_diagnostic_answer primary key,
	question_id integer not null references diagnostic_question (question_id),
	description varchar NOT NULL
);