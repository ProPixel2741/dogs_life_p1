drop table if exists dogs;
create table dogs
(
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(250) not null,
    age INT NOT NULL
);