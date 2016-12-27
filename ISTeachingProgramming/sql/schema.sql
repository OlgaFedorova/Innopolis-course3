--Users
create table users (
		id serial primary key,
		name varchar(25) UNIQUE,
		password varchar(15)
);

--Tasks
create table tasks (
		id serial primary key,
		name varchar(255),
		content text
);

-- add new task
insert into tasks (name, content) values ('Задание №1', 'Содержание задания №1');
insert into tasks (name, content) values ('Задание №2', 'Содержание задания №2');
insert into tasks (name, content) values ('Задание №3', 'Содержание задания №3');
insert into tasks (name, content) values ('Задание №4', 'Содержание задания №4');
insert into tasks (name, content) values ('Задание №5', 'Содержание задания №5');
insert into tasks (name, content) values ('Задание №6', 'Содержание задания №6');
insert into tasks (name, content) values ('Задание №7', 'Содержание задания №7');
insert into tasks (name, content) values ('Задание №8', 'Содержание задания №8');
insert into tasks (name, content) values ('Задание №9', 'Содержание задания №9');
insert into tasks (name, content) values ('Задание №10', 'Содержание задания №10');
insert into tasks (name, content) values ('Задание №11', 'Содержание задания №11');
insert into tasks (name, content) values ('Задание №12', 'Содержание задания №12');
insert into tasks (name, content) values ('Задание №13', 'Содержание задания №13');

--decision
create table decisions (
		id serial primary key,
		id_task int REFERENCES tasks(id),
		id_user int REFERENCES users(id),
		decision text
);

--mark
create table mark (
		id serial primary key,
		id_task int REFERENCES tasks(id),
		id_user int REFERENCES users(id),
		mark int not null
);
