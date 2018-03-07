# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table student (
  first_name                    varchar(255),
  last_name                     varchar(255),
  age                           integer,
  id                            integer
);


# --- !Downs

drop table if exists student;

