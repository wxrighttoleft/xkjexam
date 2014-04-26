use master;
--创建数据库
if exists(select * from sys.databases where name = 'ZYExam')
	drop database ZYExam;
create database ZYExam;
use ZYExam;
--科目表
create table subjects
(
	sj_id int primary key identity(1,1),--id编号
	sj_name varchar(20) not null
);
--年纪表
create table objects
(
	o_id int primary key identity(1,1),--id编号
	o_name varchar(20) not null--对象名称
);
--题库表
create table questions
(
	qt_id int primary key identity(1,1),--id编号
	qt_content varchar(500) not null,--题目
	qt_optionA varchar(500) not null,--试题选项1
	qt_optionB varchar(500) not null,--试题选项2
	qt_optionC varchar(500) null,--试题选项3
	qt_optionD varchar(500) null,--试题选项4
	qt_subject int not null,--所属科目
	qt_object int not null,--所属对象
	qt_result varchar(20)--参考答案
);
--用户表
create table sys_users
(
	user_id int primary key identity(10000,1),--id编号
	user_name varchar(50) not null,--名字
	user_password varchar(100) not null,--密码
	user_sex int not null default(1),--性别1男，0女
	user_birthday datetime null,--出生日期
	user_phone varchar(15) null,--联系电话
	user_qq varchar(12) null,--联系QQ
	user_email varchar(100) null,--联系邮箱
	user_state int not null default(1),
	user_ip_address varchar(100) null
);
--试卷表
create table test_questions
(
	tq_id int primary key identity(1,1),--id编号
	tq_name varchar(100) not null,--试卷名称
	tq_full_mark int not null,--满分分数
	tq_content_num int not null,--题量
	tq_start_time datetime not null,--试卷开始时间
	tq_end_time datetime not null--试卷结束时间
);
create table test_content_questions
(
	tcq_id int primary key identity(1,1),--id编号
	tcq_tq_id int not null,--试卷编号
	tcq_q_id int not null--试题编号
);
--试卷考察对象表
create table test_object
(
	to_id int primary key identity(1,1),--id编号
	to_tq_id int not null,--试卷编号
	to_user int not null,--考察对象
	to_state int not null--考试状态 0考试中，1缺考,2考试结束
);
--成绩表
create table test_result
(
	tr_id int primary key identity(1,1),--id编号
	tr_user_id int not null,--用户id
	tr_tq_id int not null,--试卷编号
	tr_result int not null,--考试成绩
	tr_mark varchar(300)
);
--权限表
--角色表
--管理员表
