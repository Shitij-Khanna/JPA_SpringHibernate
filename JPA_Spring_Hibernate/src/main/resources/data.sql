insert into course(id, name, created_date, last_updated_date) 
values(10001,'JPA in 50 Steps', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10002,'Spring in 50 Steps', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10003,'Spring Boot in 100 Steps', sysdate(), sysdate());

insert into passport(id,number)
values(40004,'E123456');
insert into passport(id,number)
values(40005,'N123457');
insert into passport(id,number)
values(40006,'L123890');

insert into student(id,name,passport_id)
values(20001,'Ranga',40004);
insert into student(id,name,passport_id)
values(20002,'Adam',40005);
insert into student(id,name,passport_id)
values(20003,'Jane',40006);

insert into review(id,rating,description,course_id)
values(50001,'FIVE', 'Great Course',10001);
insert into review(id,rating,description,course_id)
values(50002,'FOUR', 'Wonderful Course',10001);
insert into review(id,rating,description,course_id)
values(50003,'FIVE', 'Awesome Course',10003);