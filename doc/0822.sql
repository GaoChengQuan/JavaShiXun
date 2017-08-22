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
VALUES('zhangsan',20,'男','青岛');
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




 


