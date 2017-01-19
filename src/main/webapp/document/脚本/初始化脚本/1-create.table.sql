drop table if exists BASIC_INFO;

drop table if exists RESOURCE_R_CLASSLEVEL;

drop table if exists RES_COMMENT;

drop table if exists RESOURCE;

drop table if exists CLASSLEVEL;

drop table if exists DMSSERVER;

drop table if exists SUBJECT;

drop table if exists USER;

/*==============================================================*/
/* Table: BASIC_INFO                                            */
/*==============================================================*/
create table BASIC_INFO
(
   INFO_NAME            varchar(100) not null,
   INFO_VALUE           varchar(1000),
   primary key (INFO_NAME)
);

alter table BASIC_INFO comment '基础信息表';

/*==============================================================*/
/* Table: CLASSLEVEL                                            */
/*==============================================================*/
create table CLASSLEVEL
(
   CLASSLEVEL_ID        varchar(32) not null,
   CLASSLEVEL_NAME      varchar(200) not null,
   SORT                 int,
   DELETE_FLAG          char(1) not null default 'N' comment '删除与否标志：Y/删除，N/未删除',
   DELETE_TIME          timestamp NULL DEFAULT NULL,
   CREATE_TIME          timestamp NULL DEFAULT NULL,
   primary key (CLASSLEVEL_ID)
);

alter table CLASSLEVEL comment '年级';

/*==============================================================*/
/* Table: DMSSERVER                                             */
/*==============================================================*/
create table DMSSERVER
(
   SERVER_ID            varchar(32) not null,
   SERVER_NAME          varchar(200) not null,
   SERVER_VALUE         varchar(1000) not null,
   LAST_MODIFY_TIME     timestamp NULL DEFAULT NULL,
   CREATE_TIME          timestamp NULL DEFAULT NULL,
   primary key (SERVER_ID)
);

/*==============================================================*/
/* Table: RESOURCE                                              */
/*==============================================================*/
create table RESOURCE
(
   RESOURCE_ID          varchar(32) not null,
   RESOURCE_NAME        varchar(400) not null,
   SUBJECT_ID           varchar(32) not null,
   AUTHOR               varchar(100) comment '主讲老师',
   THUMB_PATH           varchar(400) comment '视频类资源缩略图目录',
   VIEW_CNT             numeric(10,0),
   SIZE                 bigint,
   SOURCE_TYPE          varchar(50) not null comment '来源类型
            1：上传 UPLOAD
            2：录播RECORD',
   STORE_PATH           varchar(400),
   LIVING_PATH          varchar(1000),
   LIVING_FLAG          char(1) comment '是否直播
            Y
            N',
   DELETE_FLAG          char(1) not null default 'N' comment '删除与否标志：Y/删除，N/未删除 ',
   DELETE_USER_ID       varchar(32),
   DELETE_TIME          timestamp NULL DEFAULT NULL,
   CREATE_USER_ID       varchar(32) ,
   CREATE_TIME          timestamp NULL DEFAULT NULL,
   primary key (RESOURCE_ID)
);

alter table RESOURCE comment '资源表';

/*==============================================================*/
/* Table: RESOURCE_R_CLASSLEVEL                                 */
/*==============================================================*/
create table RESOURCE_R_CLASSLEVEL
(
   RESOURCE_ID          varchar(32) not null,
   CLASSLEVEL_ID        varchar(32) not null,
   primary key (RESOURCE_ID, CLASSLEVEL_ID)
);

alter table RESOURCE_R_CLASSLEVEL comment '资源和班级关联表';

/*==============================================================*/
/* Table: RES_COMMENT                                           */
/*==============================================================*/
create table RES_COMMENT
(
   RESOURCE_COMMENT_ID  varchar(32) not null,
   RESOURCE_ID          varchar(32) not null,
   COMMENT_USER_ID      varchar(32) not null,
   COMMENT_CONTENT      varchar(800) not null,
   PARENT_COMMENT_ID    varchar(32),
   REPLY_TO_USER_ID     varchar(32),
   CREATE_TIME          timestamp NULL DEFAULT NULL,
   primary key (RESOURCE_COMMENT_ID)
);

alter table RES_COMMENT comment '资源评论';

/*==============================================================*/
/* Table: SUBJECT                                               */
/*==============================================================*/
create table SUBJECT
(
   SUBJECT_ID           varchar(32) not null,
   SUBJECT_NAME         varchar(200) not null,
   SORT                 int,
   DELETE_FLAG          char(1) not null default 'N' comment '删除与否标志：Y/删除，N/未删除',
   DELETE_TIME          timestamp NULL DEFAULT NULL,
   CREATE_TIME          timestamp NULL DEFAULT NULL,
   primary key (SUBJECT_ID)
);

alter table SUBJECT comment '学科表';

/*==============================================================*/
/* Table: USER                                                  */
/*==============================================================*/
create table USER
(
   USER_ID              varchar(32) not null,
   USERNAME             varchar(100) not null,
   REALNAME             varchar(100) not null,
   PASSWORD             varchar(32) not null,
   USER_TYPE            varchar(20) not null comment '用户类型
            SUPER_ADMIN
            ADMIN
            TEACHER
            STUDENT',
   DELETE_FLAG          char(1) not null comment '删除与否标志：Y/删除，N/未删除',
   DELETE_TIME          timestamp NULL DEFAULT NULL,
   CREATE_TIME          timestamp NULL DEFAULT NULL,
   primary key (USER_ID)
);

alter table USER comment '用户表';

alter table RESOURCE add constraint FK_RESOURCE_C_R_USER foreign key (CREATE_USER_ID)
      references USER (USER_ID) on delete restrict on update restrict;

alter table RESOURCE add constraint FK_RESOURCE_D_R_USER foreign key (DELETE_USER_ID)
      references USER (USER_ID) on delete restrict on update restrict;

alter table RESOURCE add constraint FK_RESOURCE_R_SUBBJECT foreign key (SUBJECT_ID)
      references SUBJECT (SUBJECT_ID) on delete restrict on update restrict;

alter table RESOURCE_R_CLASSLEVEL add constraint FK_RES_CLS_R_CLS foreign key (CLASSLEVEL_ID)
      references CLASSLEVEL (CLASSLEVEL_ID) on delete restrict on update restrict;

alter table RESOURCE_R_CLASSLEVEL add constraint FK_RES_CLS_R_RES foreign key (RESOURCE_ID)
      references RESOURCE (RESOURCE_ID) on delete cascade on update restrict;

alter table RES_COMMENT add constraint FK_RES_CMT_REPLY_USER foreign key (REPLY_TO_USER_ID)
      references USER (USER_ID) on delete restrict on update restrict;

alter table RES_COMMENT add constraint FK_RES_CMT_R_RES foreign key (RESOURCE_ID)
      references RESOURCE (RESOURCE_ID) on delete restrict on update restrict;

alter table RES_COMMENT add constraint FK_RES_CMT_R_USER foreign key (COMMENT_USER_ID)
      references USER (USER_ID) on delete restrict on update restrict;
