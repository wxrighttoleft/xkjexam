/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2005                    */
/* Created on:     2013-7-25 10:05:55                           */
/*==============================================================*/
use master
go
if exists(select * from sys.databases where name = 'projectdb')
	drop database projectdb
go
create database projectdb
go
use projectdb
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('developInfo') and o.name = 'FK_DEVELOPI_REFERENCE_PROJECTI')
alter table developInfo
   drop constraint FK_DEVELOPI_REFERENCE_PROJECTI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('developInfo') and o.name = 'FK_DEVELOPI_REFERENCE_PROJECTT')
alter table developInfo
   drop constraint FK_DEVELOPI_REFERENCE_PROJECTT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('developInfo') and o.name = 'FK_DEVELOPI_REFERENCE_MEMBERIN')
alter table developInfo
   drop constraint FK_DEVELOPI_REFERENCE_MEMBERIN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('projectAsk') and o.name = 'FK_PROJECTA_RELATIONS_MEMBERIN')
alter table projectAsk
   drop constraint FK_PROJECTA_RELATIONS_MEMBERIN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('projectAsk') and o.name = 'FK_PROJECTA_RELATIONS_PROJECTS')
alter table projectAsk
   drop constraint FK_PROJECTA_RELATIONS_PROJECTS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('projectAsk') and o.name = 'FK_PROJECTA_RELATIONS_PROJECTL')
alter table projectAsk
   drop constraint FK_PROJECTA_RELATIONS_PROJECTL
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('projectInfo') and o.name = 'FK_PROJECTI_RELATIONS_PROJECTS')
alter table projectInfo
   drop constraint FK_PROJECTI_RELATIONS_PROJECTS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('projectInfo') and o.name = 'FK_PROJECTI_RELATIONS_PROJECTL')
alter table projectInfo
   drop constraint FK_PROJECTI_RELATIONS_PROJECTL
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('projectTask') and o.name = 'FK_PROJECTT_RELATIONS_PROJECTI')
alter table projectTask
   drop constraint FK_PROJECTT_RELATIONS_PROJECTI
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ProjectLanguageType')
            and   type = 'U')
   drop table ProjectLanguageType
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ProjectSystemType')
            and   type = 'U')
   drop table ProjectSystemType
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('developInfo')
            and   name  = 'Reference_5_FK'
            and   indid > 0
            and   indid < 255)
   drop index developInfo.Reference_5_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('developInfo')
            and   name  = 'Reference_4_FK'
            and   indid > 0
            and   indid < 255)
   drop index developInfo.Reference_4_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('developInfo')
            and   name  = 'Reference_3_FK'
            and   indid > 0
            and   indid < 255)
   drop index developInfo.Reference_3_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('developInfo')
            and   type = 'U')
   drop table developInfo
go

if exists (select 1
            from  sysobjects
           where  id = object_id('memberInfo')
            and   type = 'U')
   drop table memberInfo
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('projectAsk')
            and   name  = 'Relationship_7_FK'
            and   indid > 0
            and   indid < 255)
   drop index projectAsk.Relationship_7_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('projectAsk')
            and   name  = 'Relationship_6_FK'
            and   indid > 0
            and   indid < 255)
   drop index projectAsk.Relationship_6_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('projectAsk')
            and   name  = 'Relationship_2_FK'
            and   indid > 0
            and   indid < 255)
   drop index projectAsk.Relationship_2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('projectAsk')
            and   type = 'U')
   drop table projectAsk
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('projectInfo')
            and   name  = 'Relationship_9_FK'
            and   indid > 0
            and   indid < 255)
   drop index projectInfo.Relationship_9_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('projectInfo')
            and   name  = 'Relationship_8_FK'
            and   indid > 0
            and   indid < 255)
   drop index projectInfo.Relationship_8_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('projectInfo')
            and   type = 'U')
   drop table projectInfo
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('projectTask')
            and   name  = 'Relationship_1_FK'
            and   indid > 0
            and   indid < 255)
   drop index projectTask.Relationship_1_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('projectTask')
            and   type = 'U')
   drop table projectTask
go

/*==============================================================*/
/* Table: ProjectLanguageType                                   */
/*==============================================================*/
create table ProjectLanguageType (
   plt_id               int                  identity,
   plt_name             varchar(20)          not null,
   constraint PK_PROJECTLANGUAGETYPE primary key nonclustered (plt_id)
)
go

/*==============================================================*/
/* Table: ProjectSystemType                                     */
/*==============================================================*/
create table ProjectSystemType (
   pst_id               int                  identity,
   pst_name             varchar(20)          not null,
   constraint PK_PROJECTSYSTEMTYPE primary key nonclustered (pst_id)
)
go

/*==============================================================*/
/* Table: developInfo                                           */
/*==============================================================*/
create table developInfo (
   mb_mail              varchar(100)         null,
   pro_id               int                  null,
   pt_id                int                  null,
   di_if                int                  null
)
go

/*==============================================================*/
/* Index: Reference_3_FK                                        */
/*==============================================================*/
create index Reference_3_FK on developInfo (
pro_id ASC
)
go

/*==============================================================*/
/* Index: Reference_4_FK                                        */
/*==============================================================*/
create index Reference_4_FK on developInfo (
pt_id ASC
)
go

/*==============================================================*/
/* Index: Reference_5_FK                                        */
/*==============================================================*/
create index Reference_5_FK on developInfo (
mb_mail ASC
)
go

/*==============================================================*/
/* Table: memberInfo                                            */
/*==============================================================*/
create table memberInfo (
   mb_mail              varchar(100)         not null,
   mb_pass              varchar(6)           not null,
   mb_name              varchar(20)          null,
   mb_sex               int                  null,
   mb_tel               varchar(11)          not null,
   constraint PK_MEMBERINFO primary key nonclustered (mb_mail)
)
go

/*==============================================================*/
/* Table: projectAsk                                            */
/*==============================================================*/
create table projectAsk (
   ask_id               int                  identity,
   mb_mail              varchar(100)         null,
   pst_id               int                  null,
   plt_id               int                  null,
   ask_name             varchar(100)         not null,
   ask_remark           varchar(2000)        not null,
   ask_time             datetime             not null,
   ask_reader           bit                  not null,
   constraint PK_PROJECTASK primary key nonclustered (ask_id)
)
go

/*==============================================================*/
/* Index: Relationship_2_FK                                     */
/*==============================================================*/
create index Relationship_2_FK on projectAsk (
mb_mail ASC
)
go

/*==============================================================*/
/* Index: Relationship_6_FK                                     */
/*==============================================================*/
create index Relationship_6_FK on projectAsk (
pst_id ASC
)
go

/*==============================================================*/
/* Index: Relationship_7_FK                                     */
/*==============================================================*/
create index Relationship_7_FK on projectAsk (
plt_id ASC
)
go

/*==============================================================*/
/* Table: projectInfo                                           */
/*==============================================================*/
create table projectInfo (
   pro_id               int                  identity,
   plt_id               int                  null,
   pst_id               int                  null,
   pro_name             varchar(100)         not null,
   pro_remark           varchar(200)         null,
   pro_number           int                  not null,
   constraint PK_PROJECTINFO primary key nonclustered (pro_id)
)
go

/*==============================================================*/
/* Index: Relationship_8_FK                                     */
/*==============================================================*/
create index Relationship_8_FK on projectInfo (
pst_id ASC
)
go

/*==============================================================*/
/* Index: Relationship_9_FK                                     */
/*==============================================================*/
create index Relationship_9_FK on projectInfo (
plt_id ASC
)
go

/*==============================================================*/
/* Table: projectTask                                           */
/*==============================================================*/
create table projectTask (
   pt_id                int                  identity,
   pro_id               int                  null,
   pt_name              varchar(100)         not null,
   pt_remark            varchar(1000)        null,
   constraint PK_PROJECTTASK primary key nonclustered (pt_id)
)
go

/*==============================================================*/
/* Index: Relationship_1_FK                                     */
/*==============================================================*/
create index Relationship_1_FK on projectTask (
pro_id ASC
)
go

alter table developInfo
   add constraint FK_DEVELOPI_REFERENCE_PROJECTI foreign key (pro_id)
      references projectInfo (pro_id)
go

alter table developInfo
   add constraint FK_DEVELOPI_REFERENCE_PROJECTT foreign key (pt_id)
      references projectTask (pt_id)
go

alter table developInfo
   add constraint FK_DEVELOPI_REFERENCE_MEMBERIN foreign key (mb_mail)
      references memberInfo (mb_mail)
go

alter table projectAsk
   add constraint FK_PROJECTA_RELATIONS_MEMBERIN foreign key (mb_mail)
      references memberInfo (mb_mail)
go

alter table projectAsk
   add constraint FK_PROJECTA_RELATIONS_PROJECTS foreign key (pst_id)
      references ProjectSystemType (pst_id)
go

alter table projectAsk
   add constraint FK_PROJECTA_RELATIONS_PROJECTL foreign key (plt_id)
      references ProjectLanguageType (plt_id)
go

alter table projectInfo
   add constraint FK_PROJECTI_RELATIONS_PROJECTS foreign key (pst_id)
      references ProjectSystemType (pst_id)
go

alter table projectInfo
   add constraint FK_PROJECTI_RELATIONS_PROJECTL foreign key (plt_id)
      references ProjectLanguageType (plt_id)
go

alter table projectTask
   add constraint FK_PROJECTT_RELATIONS_PROJECTI foreign key (pro_id)
      references projectInfo (pro_id)
go

