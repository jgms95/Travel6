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
repIndent number(4) )

create table travelMember (
	id varchar2(4) primary key, 
	name varchar2(8) not null, 
	age number(4) check(age<200), 
	pw varchar2(8) not null
)

select * from travelmember

insert into TRAVELMEMBER (id,name,age,pw) values ('id1','kim',23,'1')




drop table qnaboard
drop table travelMember


create table qnacomment(
id varchar2(21), 
qnanum number(4),
num number(4) primary key, 
writer varchar2(21) not null, 
content varchar2(1000), 
writeday date default sysdate, 
repRoot number(4), 
repStep number(4), 
repIndent number(4)
)
select * from qnacomment where qnanum = 12 order by repRoot desc, num asc, repStep desc 


select id, num, writer, content, writeday, repIndent from qnacomment where qnanum = 12 order by repRoot desc, repStep asc
drop table qnacomment
select * from QNACOMMENT

insert into qnacomment (id,num,writer,content,)
