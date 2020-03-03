insert into course(id, name, created_date, last_updated_date) 
values(10001,'JPA', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10002,'Spring', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10003,'Spring Boot', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10004,'Docker', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10005,'AWS', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10006,'Kubernetes', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10007,'Jenkins', sysdate(), sysdate());

insert into passport(id,number)
values(40004,'E123456');
insert into passport(id,number)
values(40005,'N123457');
insert into passport(id,number)
values(40006,'L123890');
insert into passport(id,number)
values(40007,'M187890');
insert into passport(id,number)
values(40008,'N166890');

insert into student(id,name,passport_id)
values(20001,'Shitij',40004);
insert into student(id,name,passport_id)
values(20002,'Nitish',40005);
insert into student(id,name,passport_id)
values(20003,'Mahesh',40006);
insert into student(id,name,passport_id)
values(20004,'Pankaj',40007);
insert into student(id,name,passport_id)
values(20005,'Gaurav',40008);

insert into review(id,rating,description,course_id)
values(50001,'FIVE', 'Great Course',10001);
insert into review(id,rating,description,course_id)
values(50002,'FOUR', 'Wonderful Course',10001);
insert into review(id,rating,description,course_id)
values(50003,'FIVE', 'Awesome Course',10003);

insert into student_course(student_id,course_id)
values(20001,10001);
insert into student_course(student_id,course_id)
values(20001,10002);
insert into student_course(student_id,course_id)
values(20001,10003);
insert into student_course(student_id,course_id)
values(20001,10004);
insert into student_course(student_id,course_id)
values(20001,10005);
insert into student_course(student_id,course_id)
values(20002,10001);
insert into student_course(student_id,course_id)
values(20003,10001);
insert into student_course(student_id,course_id)
values(20002,10003);
insert into student_course(student_id,course_id)
values(20002,10005);
insert into student_course(student_id,course_id)
values(20002,10004);
insert into student_course(student_id,course_id)
values(20004,10001);