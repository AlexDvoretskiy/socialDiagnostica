SET search_path TO public;

insert into users (name, full_name, "password", email)
values ('testUser', 'testUser', '$2a$10$w9/1hWUMTbB9eeldUARlEOcTH3Wn.0WplhGgJ9st8Pkzf9X.XDXtS', 'client@hardwork.ru');

insert into users_roles (user_id , role_id) values (1, 1);