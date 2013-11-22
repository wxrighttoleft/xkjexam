use master;
if exists(select * from sys.databases where name = 'PasswordAdminDb')
	drop database PasswordAdminDb;
create database PasswordAdminDb;
use PasswordAdminDb;
create table adminInfo
(
	id int identity primary key,
	loginname varchar(20) not null unique,
	loginpwd varchar(20) not null check(len(loginpwd)>=8)
);
create table info
(
	id int identity primary key,
	adminAuthor int references adminInfo(id),
	loginname varchar(30) not null,
	loginPwd varchar(30) not null,
	loginAddress varchar(100) not null
);
insert into adminInfo values('sa','523201314')
insert into adminInfo values('root','123456789')

insert into info values(1,'xkjwmy','ZMLtarot78SAKURA','www.12306.cn')

select * from admininfo;
select * from info;