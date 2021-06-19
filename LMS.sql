CREATE TABLE accounts
(
    aname VARCHAR(50),
    username VARCHAR(50) PRIMARY KEY not NULL ,
    apassword VARCHAR(10) not NULL
)
CREATE table books
(
bookid int PRIMARY key,
bookname NVARCHAR(255) not NULL,
Edition NVARCHAR(10),
publisher NVARCHAR(255) ,
Price int

)
CREATE TABLE student
(
    studentid int PRIMARY KEY,
    studentname nvarchar(255) not NULL,
    fathername NVARCHAR(255) not NULL,
    course NVARCHAR(100),
    branch NVARCHAR(100),
    semester NVARCHAR(10)

)
create table issue
(
    bookid int ,
    bookname NVARCHAR(255) not NULL,
    Edition NVARCHAR(10),
    publisher NVARCHAR(255) ,
    Price int,
    studentid int ,
    studentname nvarchar(255) not NULL,
    fathername NVARCHAR(255) not NULL,
    course NVARCHAR(100),
    branch NVARCHAR(100),
    semester NVARCHAR(10)




)
ALTER table issue
add dateofissue NVARCHAR(255)
create table returned(
     studentid int ,
    studentname nvarchar(255) not NULL,
    fathername NVARCHAR(255) not NULL,
    course NVARCHAR(100),
    branch NVARCHAR(100),
    semester NVARCHAR(10),
     bookid int ,
    bookname NVARCHAR(255) not NULL,
    Edition NVARCHAR(10),
    publisher NVARCHAR(255) ,
    Price int


)
ALTER table returned
add dateofissue NVARCHAR(255)
ALTER table returned
add returndate NVARCHAR(255)

drop table books
select * from accounts
select * from books
select * from student

SELECT * FROM issue
SELECT * from returned