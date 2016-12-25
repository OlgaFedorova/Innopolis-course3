--Users
create table users (
		id serial primary key,
		name varchar(25) UNIQUE,
		password varchar(15)
);


--Lectures
create table lectures (
		id serial primary key,
		subject varchar(200),
		hours_of_theory int,
		hours_of_practice int
);
--Journal
create table journal (
    id serial primary key,
		date_of_record DATE,
		lecture_id int not null references lectures(id),
		student_id int not null references students(id)
);

-- add new student
insert into students (name, class) values ('Petrov Petr', '1A');
insert into students (name, class) values ('Petrova Irina', '1A');
insert into students (name, class) values ('Ivanov Ivan', '2A');
insert into students (name, class) values ('Ivanova Maria', '2A');
insert into students (name, class) values ('Sergeev Andrey', '2A');

-- add new lecture
insert into lectures (subject, hours_of_theory, hours_of_practice) values ('Lecture 1', 2, 5);
insert into lectures (subject, hours_of_theory, hours_of_practice) values ('Lecture 2', 2, 2);
insert into lectures (subject, hours_of_theory, hours_of_practice) values ('Lecture 3', 1, 4);
insert into lectures (subject, hours_of_theory, hours_of_practice) values ('Lecture 4', 2, 3);

-- add new record in journal
insert into journal (date_of_record, lecture_id, student_id) values ('2016-12-20', 1, 1);
insert into journal (date_of_record, lecture_id, student_id) values ('2016-12-20', 1, 2);
insert into journal (date_of_record, lecture_id, student_id) values ('2016-12-20', 1, 4);
