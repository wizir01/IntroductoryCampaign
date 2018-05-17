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
