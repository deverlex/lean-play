# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table booker (
  id                            integer auto_increment not null,
  user_id                       integer,
  topup                         float,
  is_active                     tinyint(1) default 0,
  constraint pk_booker primary key (id)
);

create table user (
  id                            integer auto_increment not null,
  first_name                    varchar(255),
  last_name                     varchar(255),
  age                           datetime(6),
  created_time                  datetime(6),
  constraint pk_user primary key (id)
);


# --- !Downs

drop table if exists booker;

drop table if exists user;

