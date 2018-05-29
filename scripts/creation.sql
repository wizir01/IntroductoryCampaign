DROP DATABASE IF EXISTS fp_db;
CREATE DATABASE fp_db DEFAULT CHARACTER SET utf8mb4;
USE fp_db;

drop table if exists Department;

drop table if exists DepartmentRequirement;

drop table if exists Exams;

drop table if exists Rating;

drop table if exists Speciality;

drop table if exists Subjects;

drop table if exists University;

drop table if exists User;

/*==============================================================*/
/* Table: Department                                            */
/*==============================================================*/
create table Department
(
  Department_id        int not null auto_increment,
  Speciality_id        int not null,
  University_id        int not null,
  StudyPlacesNumber    int not null,
  primary key (Department_id)
);

/*==============================================================*/
/* Table: DepartmentRequirement                                 */
/*==============================================================*/
create table DepartmentRequirement
(
  DepReq_id            int not null auto_increment,
  Department_id        int not null,
  Subjects_id          int not null,
  primary key (DepReq_id)
);

/*==============================================================*/
/* Table: Exams                                                 */
/*==============================================================*/
create table Exams
(
  Exams_id             int not null auto_increment,
  Subjects_id          int not null,
  User_id              int not null,
  Mark                 int,
  primary key (Exams_id)
);

/*==============================================================*/
/* Table: Rating                                                */
/*==============================================================*/
create table Rating
(
  Rating_id            int not null auto_increment,
  User_id              int not null,
  Department_id        int not null,
  Rating               int,
  primary key (Rating_id)
);

/*==============================================================*/
/* Table: Speciality                                            */
/*==============================================================*/
create table Speciality
(
  Speciality_id        int not null auto_increment,
  SpecialityName       varchar(60) not null,
  primary key (Speciality_id)
);

/*==============================================================*/
/* Table: Subjects                                              */
/*==============================================================*/
create table Subjects
(
  Subjects_id          int not null auto_increment,
  SubjectName          varchar(50) not null,
  primary key (Subjects_id)
);

/*==============================================================*/
/* Table: University                                            */
/*==============================================================*/
create table University
(
  University_id        int not null auto_increment,
  UniversityName       varchar(60) not null,
  primary key (University_id)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
  User_id              int not null auto_increment,
  Name                 varchar(60) not null,
  Email                varchar(60) not null,
  Password             varchar(60) not null,
  Is_Admin             bool not null,
  primary key (User_id)
);

alter table Department add constraint FK_Relationship_10 foreign key (Speciality_id)
references Speciality (Speciality_id) on delete restrict on update restrict;

alter table Department add constraint FK_Relationship_9 foreign key (University_id)
references University (University_id) on delete restrict on update restrict;

alter table DepartmentRequirement add constraint FK_Relationship_7 foreign key (Department_id)
references Department (Department_id) on delete restrict on update restrict;

alter table DepartmentRequirement add constraint FK_Relationship_8 foreign key (Subjects_id)
references Subjects (Subjects_id) on delete restrict on update restrict;

alter table Exams add constraint FK_Relationship_2 foreign key (User_id)
references User (User_id) on delete restrict on update restrict;

alter table Exams add constraint FK_Relationship_6 foreign key (Subjects_id)
references Subjects (Subjects_id) on delete restrict on update restrict;

alter table Rating add constraint FK_Relationship_11 foreign key (User_id)
references User (User_id) on delete restrict on update restrict;

alter table Rating add constraint FK_Relationship_12 foreign key (Department_id)
references Department (Department_id) on delete restrict on update restrict;

INSERT INTO university (UniversityName) VALUES ('Київський політехнічний інститут імені Ігоря Сікорського');
INSERT INTO university (UniversityName) VALUES ('Національний педагогічний університет імені М.П. Драгоманова');
INSERT INTO university (UniversityName) VALUES ('Національний медичний університет імені О.О. Богомольця');
INSERT INTO university (UniversityName) VALUES ('Національний економічний університет імені Вадима Гетьмана');
INSERT INTO university (UniversityName) VALUES ('Національний авіаційний університет');
INSERT INTO university (UniversityName) VALUES ('Київський національний університет імені Тараса Шевченка');

INSERT INTO speciality (SpecialityName) VALUES ('Авіаційна та ракетно-космічна техніка');
INSERT INTO speciality (SpecialityName) VALUES ('Галузеве машинобудування');
INSERT INTO speciality (SpecialityName) VALUES ('Електроніка');
INSERT INTO speciality (SpecialityName) VALUES ('Менеджмент');
INSERT INTO speciality (SpecialityName) VALUES ('Атомна енергетика');
INSERT INTO speciality (SpecialityName) VALUES ('Фізика та астрономія');
INSERT INTO speciality (SpecialityName) VALUES ('Телекомунікації та радіотехніка');
INSERT INTO speciality (SpecialityName) VALUES ('Прикладна фізика та наноматеріали');
INSERT INTO speciality (SpecialityName) VALUES ('Інженерія програмного забезпечення');
INSERT INTO speciality (SpecialityName) VALUES ('Інформаційні системи та технології');
INSERT INTO speciality (SpecialityName) VALUES ('Дизайн');
INSERT INTO speciality (SpecialityName) VALUES ('Дошкільна освіта');
INSERT INTO speciality (SpecialityName) VALUES ('Освітні, педагогічні науки');
INSERT INTO speciality (SpecialityName) VALUES ('Журналістика');
INSERT INTO speciality (SpecialityName) VALUES ('Історія та археологія');
INSERT INTO speciality (SpecialityName) VALUES ('Біотехнології та біоінженерія');
INSERT INTO speciality (SpecialityName) VALUES ('Медицина');
INSERT INTO speciality (SpecialityName) VALUES ('Педіатрія');
INSERT INTO speciality (SpecialityName) VALUES ('Стоматологія');
INSERT INTO speciality (SpecialityName) VALUES ('Економіка');
INSERT INTO speciality (SpecialityName) VALUES ('Міжнародні економічні відносини');
INSERT INTO speciality (SpecialityName) VALUES ('Облік і оподаткування');
INSERT INTO speciality (SpecialityName) VALUES ('Право');

INSERT INTO subjects (SubjectName) VALUES ('Математика');
INSERT INTO subjects (SubjectName) VALUES ('Фізика');
INSERT INTO subjects (SubjectName) VALUES ('Іноземна мова');
INSERT INTO subjects (SubjectName) VALUES ('Географія');
INSERT INTO subjects (SubjectName) VALUES ('Історія України');
INSERT INTO subjects (SubjectName) VALUES ('Українська мова та література');
INSERT INTO subjects (SubjectName) VALUES ('Хімія');
INSERT INTO subjects (SubjectName) VALUES ('Біологія');

INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (1, 1, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (1, 5, 3);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (2, 1, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (3, 1, 4);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (3, 5, 3);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (4, 1, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (4, 4, 4);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (4, 2, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (5, 1, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (6, 1, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (6, 2, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (7, 1, 3);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (7, 5, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (8, 1, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (9, 1, 3);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (9, 4, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (9, 5, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (10, 1, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (10, 5, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (11, 2, 3);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (11, 6, 4);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (12, 2, 4);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (13, 2, 3);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (14, 2, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (14, 4, 3);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (14, 6, 3);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (15, 2, 4);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (15, 6, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (16, 1, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (16, 3, 4);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (17, 3, 4);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (18, 3, 3);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (19, 3, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (20, 4, 4);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (20, 6, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (21, 4, 3);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (22, 4, 3);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (22, 6, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (23, 1, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (23, 4, 2);
INSERT INTO department (Speciality_id, University_id, StudyPlacesNumber) VALUES (23, 6, 2);

INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (1, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (1, 2);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (1, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (2, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (2, 2);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (2, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (3, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (3, 2);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (3, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (4, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (4, 2);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (4, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (5, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (5, 2);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (5, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (6, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (6, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (6, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (7, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (7, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (7, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (8, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (8, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (8, 5);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (9, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (9, 2);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (9, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (10, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (10, 2);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (10, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (11, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (11, 2);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (11, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (12, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (12, 2);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (12, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (13, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (13, 2);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (13, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (14, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (14, 2);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (14, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (15, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (15, 2);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (15, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (16, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (16, 2);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (16, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (17, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (17, 2);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (17, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (18, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (18, 2);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (18, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (19, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (19, 2);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (19, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (20, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (20, 4);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (20, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (21, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (21, 4);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (21, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (22, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (22, 5);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (22, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (23, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (23, 2);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (23, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (24, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (24, 5);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (24, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (25, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (25, 5);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (25, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (26, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (26, 5);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (26, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (27, 4);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (27, 5);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (27, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (28, 4);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (28, 5);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (28, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (29, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (29, 7);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (29, 8);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (30, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (30, 7);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (30, 8);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (31, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (31, 7);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (31, 8);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (32, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (32, 7);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (32, 8);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (33, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (33, 7);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (33, 8);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (34, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (34, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (34, 4);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (35, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (35, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (35, 5);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (36, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (36, 4);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (36, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (37, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (37, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (37, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (38, 1);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (38, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (38, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (39, 4);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (39, 5);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (39, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (40, 3);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (40, 5);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (40, 6);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (41, 4);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (41, 5);
INSERT INTO departmentrequirement (Department_id, Subjects_id) VALUES (41, 6);

INSERT INTO user (Name, Email, Password, Is_Admin) VALUES ('Гудзенко Іван Володимирович', 'wizir01@gmail.com', '123123', 0);
INSERT INTO user (Name, Email, Password, Is_Admin) VALUES ('Володимир Вікторович Стеблина', 'viktor.steb@ukr.net', 'steblina', 1);
INSERT INTO user (Name, Email, Password, Is_Admin) VALUES ('Іваненко Іван Володимирович', 'wizir01@rambler.ru', 'password', 0);