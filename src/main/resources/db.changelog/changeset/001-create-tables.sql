--liquibase formatted sql

--changeset vpetrovaa:create_comment_tables

create schema if not exists employees_schema;
set schema 'employees_schema';

create table if not exists employees
(
    id bigserial,
	email varchar(45) not null unique,
	first_name varchar(45) not null,
	last_name varchar(45) not null,
	job_title varchar(45) not null,
	company varchar(45) not null,
	primary key (id)
);
