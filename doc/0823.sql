-- 列出所有的数据库
SHOW DATABASES;
-- 创建数据库
CREATE DATABASE java1707 DEFAULT CHARACTER SET utf8;
USE java1707;
-- 学生表  班级表  课程表
-- 删除表
DROP TABLE student;
-- 创建学生表
CREATE TABLE student(
   id INT PRIMARY KEY AUTO_INCREMENT,
   NAME VARCHAR(10),
   age INT,
   gender VARCHAR(1),
   address VARCHAR(50)
);
-- 插入数据
INSERT INTO student(NAME,age,gender,address) 
VALUES('zhangsan',20,'男','青岛');
INSERT INTO student(NAME,age,gender,address) 
VALUES('wangwu',23,'女','济南');
INSERT INTO student(NAME,age,gender,address) 
VALUES('lisi',20,'男','青岛');
INSERT INTO student(NAME,age,gender,address) 
VALUES('zhangsan',20,'AS男A','青岛');
-- 查询数据库
SELECT * FROM student;
SELECT NAME,address FROM student;
-- 根据条件来查询
SELECT * FROM student WHERE NAME='zhangsan';
-- 逻辑查询：and(同时成立) or (只要有一个成立)
SELECT * FROM student WHERE NAME='zhangsan' AND gender='女';

-- 修改数据
UPDATE student SET address='深圳',java=100 WHERE id=1;

-- 删除数据
DELETE FROM student WHERE NAME='aa';

-- 比较查询:>  <  >=  <=  <>(不等于)
SELECT * FROM student WHERE java!=60;
SELECT * FROM student WHERE java>=60 AND java<=70;

-- 聚合查询：sum(字段),avg(字段),max(字段),min(字段),count();
SELECT SUM(java) AS 'java总成绩' FROM student;
SELECT AVG(java) AS 'java平均值' FROM student;
SELECT COUNT(*) AS '总人数' FROM student;
SELECT COUNT(id) AS '总人数' FROM student;

-- 查询排序
SELECT * FROM student;
-- order by 字段  asc  desc(降序)
SELECT * FROM student ORDER BY c;

-- 分组查询(group by)
--  性别   人数
--  男      3
--  女      2
-- 先分好组（男、女），在分好组的基础上在每个组里面去查询
SELECT gender AS '性别',COUNT(*) AS '人数'
FROM student GROUP BY gender; 

-- 分组查询后筛选 性别人数>2
-- having   
SELECT gender AS '性别',COUNT(*) AS '人数'
FROM student GROUP BY gender HAVING COUNT(*) > 2; 


-- --------------------多表查询-------------------
-- 学生表
CREATE TABLE student(
    id INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(10),
    age INT,
    gender VARCHAR(1),
    address VARCHAR(50),
    banji_id INT,
    FOREIGN KEY(banji_id) REFERENCES banji(id)
);
INSERT INTO student(NAME,age,gender,address,banji_id) 
VALUES('zhangsan',20,'男','青岛',1);
INSERT INTO student(NAME,age,gender,address,banji_id) 
VALUES('lisi',30,'男','青岛',1);
INSERT INTO student(NAME,age,gender,address,banji_id) 
VALUES('wangwu',30,'女','济南',2);
-- 班级表
CREATE TABLE banji(
    id INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(10)
);
INSERT INTO banji(NAME) VALUES('java1705');
INSERT INTO banji(NAME) VALUES('java1707');

-- 课程表
CREATE TABLE course(
    id INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(10),
    credit INT
);
INSERT INTO course(NAME,credit) VALUES('java',5);
INSERT INTO course(NAME,credit) VALUES('ui',4);
INSERT INTO course(NAME,credit) VALUES('h5',4);
-- 班级课程表banji_course
CREATE TABLE banji_course(
   banji_id INT,
   course_id INT,
   PRIMARY KEY(banji_id,course_id),
   FOREIGN KEY(banji_id) REFERENCES banji(id), 
   FOREIGN KEY(course_id) REFERENCES course(id)
);
-- banji表id是1的班级java1705学习了course表id是1的java这门课程
INSERT INTO banji_course(banji_id,course_id)
VALUES(1,1);
INSERT INTO banji_course(banji_id,course_id)
VALUES(1,3);
INSERT INTO banji_course(banji_id,course_id)
VALUES(2,1);
INSERT INTO banji_course(banji_id,course_id)
VALUES(2,2);
INSERT INTO banji_course(banji_id,course_id)
VALUES(2,3);

-- 子查询
-- 班级是java1705班所有学生信息
SELECT * FROM student WHERE banji_id=1;
SELECT * FROM student WHERE banji_id=
(SELECT id FROM banji WHERE NAME='java1705');
-- 班级是java1705班或者java1707所有学生信息
SELECT * FROM student WHERE banji_id IN
(SELECT id FROM banji WHERE NAME='java1705' OR NAME='java1707');
-- 子查询：只能从一张表里面查询数据,另外表提供条件.

-- 查询学生的信息和班级信息
SELECT * FROM student
INNER JOIN banji ON student.banji_id=banji.id;

SELECT s.name,age,gender,b.name FROM student AS s
INNER JOIN banji AS b ON s.banji_id=b.id;

-- 查询‘zhangsan’上了什么课程



SELECT * FROM course;
SELECT * FROM student;
SELECT * FROM banji;

















 


