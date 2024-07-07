create database hospital;
use hospital;
create table patients(
id int auto_increment primary key,
name varchar(50) not null,
age int not null,
gender varchar(10) not null
);
create table doctors(
id int auto_increment primary key,
name varchar(50) not null,
specialization varchar(20) not null
);
create table appointments(
id int auto_increment primary key,
patient_id int not null,
doctor_id int not null,
apppointment_date date not null,
foreign key (patient_id) references patients(id),
foreign key (doctor_id) references doctors(id)
);
show tables;
insert into doctors (name, specialization) values ("William", "physician");
insert into doctors (name, specialization) values ("John doe", "Eyesurgean");
select * from doctors;