--create user table
create table users (
	id serial primary key,
	login varchar(20) not null unique,
	first_name varchar(20) not null,
	last_name varchar(20)
);

--insert into user table
insert into users (first_name, last_name, login)
values
	('Олег', 'Иванов', 'oleiva'),
	('Иван', 'Петров', 'ivapet'),
	('Максим', 'Сергеев', 'makser'),
	('Антон', 'Филатов', 'antfil');

--select
--select with like, %ole or ole% or %ole%
select * from users;
select * from users where id > 2;

--update(change) some in table
update users set first_name 'some-name' where id = 1;

--delete smth
delete from users where id = 1;
delete from users where login like '%a';

--create channel table
create table channel (
	id serial primary key,
	name varchar(60) not null unique,
	display_name varchar(100) not null
);

--one to one channel
create table channel_details (
	channel_id bigint primary key,
	people_count int not null,
	discription text,
	foreign key(channel_id) references channel(id)
);

insert into channel (name, display_name)
values
	('levelUpJava2', 'Levelup.Java2'),
	('proJvm', 'Pro.Jvm');

insert into channel_details
values
	(1, 5, 'Java, levelUp courses');

insert into channel (name, display_name)
values
	('proAlgoritmsSecond', 'pro.algoritms.second - second version');

create table messages (
	id serial primary key,
	text text not null,
	date timestamp not null,
	user_id bigint not null,
	channel_id bigint not null,
	constraint message_user_id_fkey foreign key (user_id) references users(id),
	constraint message_channel_id_fkey foreign key (channel_id) references channel(id)
);

create table user_channels (
	user_id bigint,
	channel_id bigint,
	constraint user_channels_pkey primary key (user_id, channel_id),
	constraint user_id_user_channel_fkey foreign key (user_id) references users(id),
	constraint channel_id_user_channel_fkey foreign key (channel_id) references channel(id)
);


select * from channel;

insert into user_channels
values
	(1, 2),
	(2, 3),
	(4, 1);

select * from user_channels;
insert into messages (text, date, user_id, channel_id)
values
	('Hello', now(), 1, 2),
	('Hello, how are you&', now(), 2, 3),
	('Love you', '2020-11-11 10:15:15', 4, 1);

select * from messages;

--bad select (cross join)
select u.first_name, u.last_name, m.text, m.date from users u, messages m where u.id = m.user_id;

--good select
select u.first_name, u.last_name, m.text, m.date from users u inner join messages m on u.id = m.user_id;

select u.first_name, u.last_name, m.text, m.date from users u
left outer join messages m on u.id = m.user_id;

--select count
select count(*) users u where u.first_name = 'Иван';

--subselect
select m.text from messages m where m.date = (select max(m.date) from messages m);

select u.first_name, u.last_name, count(m.text) from users u
left join messages m on u.id = m.user_id
group by u.id
having count(m.text) > 1
order by count(m.text) desc;

--limit - количество строк в результате
--offest - с какой строки вывод начинать
--fetch first 10 rows only

--change column constraint
alter table messages alter column text drop not null;


create table user_password (
	user_id Integer primary key,
	user_password text not null,
	foreign key(user_id) references users(id)
);