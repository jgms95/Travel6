create table qnaboard(
id varchar2(21), 
num number(4) primary key, 
writer varchar2(21) not null, 
title varchar2(60) not null, 
content varchar2(1000), 
writeday date default sysdate, 
readcnt number(4) default 0, 
repRoot number(4), 
repStep number(4), 
repIndent number(4),
filename varchar2(100)
)

create table travelMember (
	id varchar2(21) primary key, 
	name varchar2(21) not null, 
	age number(4) check(age<200), 
	pw varchar2(15) not null
)

create table qnacomment(
id varchar2(21), 
qnanum number(4),
num number(4) primary key, 
writer varchar2(21) not null, 
content varchar2(1000), 
writeday date default sysdate, 
repRoot number(4), 
repStep number(4), 
repIndent number(4),
orgWriter varchar2(21)
)

drop table travelMember
delete from qnaboard where id = 'id1'
alter table qnaboard add (filename varchar2(100))
select * from qnaboard
select * from travelmember
select * from QNACOMMENT
select * from leaveMember
select id,name,age from travelmember where name = 'kang' and age = 11 and pw = '1'
insert into TRAVELMEMBER (id,name,age,pw) values ('id1','kang',24,'1')
insert into TRAVELMEMBER (id,name,age,pw) values ('id2','na',25,'2')
insert into TRAVELMEMBER (id,name,age,pw) values ('id3','dong',27,'3')
insert into TRAVELMEMBER (id,name,age,pw) values ('id4','shin',23,'4')
insert into TRAVELMEMBER (id,name,age,pw) values ('sample','samp',23,'1')

select id from travelmember where name = 'ad'
create table leaveMember(
	id varchar2(21) primary key, 
	name varchar2(8) not null, 
	age number(4) check(age<200)
)





drop table qnacomment

















-- test
