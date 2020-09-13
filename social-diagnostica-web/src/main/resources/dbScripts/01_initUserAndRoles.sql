create schema if not exists public;

create table if not exists roles (
	id serial not null constraint PK_role primary key,
	name varchar(50) not null
);

insert into roles (name) values ('ROLE_USER'), ('ROLE_SPECIALIST'),('ROLE_ADMIN');

create table if not exists users (
	id serial not null constraint PK_user primary key,
	name varchar NOT NULL,
	full_name varchar NOT NULL,
  	password varchar NOT NULL,
    email varchar NOT NULL,
    app_token varchar
);

create table if not exists users_roles (
	user_id int not null constraint FK_users_id references users on delete no action on update no action,
	role_id int not null constraint FK_roles_id references roles on delete no action on update no action
);
