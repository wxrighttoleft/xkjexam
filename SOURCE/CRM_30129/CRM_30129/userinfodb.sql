use master;
if exists(select * from sys.databases where name = 'userinfodb')
	drop database userinfodb;
create database userinfodb;
use userinfodb;
create table employeeinfo
(
	empid int identity primary key,
	emploginName varchar(20) not null check(len(emploginName)>=3) unique,
	emploginPwd varchar(20) not null check(len(emploginPwd)>=6),
	empname varchar(20) not null,
	empsex int default(1),
	empbirthday datetime default('1991-1-1'),
	empAddress varchar(200),
	emptel varchar(20),
	empmobel varchar(20),
	empqq varchar(10),
	empremark varchar(200)
);

insert into employeeinfo values('xkj','123456','xkj',1,'1993-08-09','重庆市','15223415486',null,null,null);
insert into employeeinfo values('dwq','123456','dwq',1,'1993-08-19','重庆市','15223415156',null,null,null);

select * from employeeinfo;