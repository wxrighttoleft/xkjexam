DROP TABLE XKJ.EMPLOYEEINFO;
create table XKJ.employeeinfo
(
	empid int primary key,
	emploginName varchar2(20) not null check(LENGTH(emploginName)>=3) unique,
	emploginPwd varchar2(20) not null check(LENGTH(emploginPwd)>=6),
	empname varchar2(20) not null,
	empsex int not null,
	empbirthday date not null,
	empAddress varchar2(200),
	emptel varchar2(20),
	empmobel varchar2(20),
	empqq varchar2(10),
	empremark varchar2(200)
);
DELETE FROM XKJ.employeeinfo;
DROP SEQUENCE XKJ.SEQ_STU_NO;
CREATE SEQUENCE XKJ.SEQ_STU_NO
START WITH 1
INCREMENT BY 1
MAXVALUE 999999
MINVALUE 1
NOCYCLE
CACHE 30;
insert into XKJ.employeeinfo values(XKJ.SEQ_STU_NO.NEXTVAL,'xkj','123456','xkj',1,TO_DATE('1993-08-09','YYYY-MM-DD HH:MI:SS'),'重庆市','15223415486',null,null,null);
insert into XKJ.employeeinfo values(XKJ.SEQ_STU_NO.NEXTVAL,'dwq','123456','dwq',1,TO_DATE('1993-08-19','YYYY-MM-DD HH:MI:SS'),'重庆市','15223415156',null,null,null);
insert into XKJ.employeeinfo values(XKJ.SEQ_STU_NO.NEXTVAL,'wmy','123456','wmy',1,sysdate,'重庆市','15223415156',null,null,null);

DECLARE
  NUMNO INT:=1;
BEGIN
  LOOP
  SELECT XKJ.SEQ_STU_NO.NEXTVAL INTO NUMNO FROM DUAL;
  insert into XKJ.employeeinfo values(NUMNO,'xkj' || NUMNO,'123456','xkj' || NUMNO,1,TO_DATE('1993-08-09','YYYY-MM-DD HH:MI:SS'),'重庆市','15223415486',null,null,null);
  EXIT WHEN NUMNO = 10000;
  END LOOP;
END;


select * from XKJ.employeeinfo;