CREATE TABLE task_definition (
	ID BIGINT ,
	NAME varchar(255) not null,
	Description varchar(255)
);
create sequence taskdef_sequence start with 1 increment by 1;

CREATE TABLE task_definition_mirror (
	ID BIGINT ,
	NAME varchar(255) not null,
	Description varchar(255)
);

create sequence taskdefmirror_sequence start with 1 increment by 1;

insert into task_definition (NAME, Description) values ('ibrahim', 'bla bla bla');
insert into task_definition (NAME, Description) values ('task ', 'bla bla bla');

insert into task_definition_mirror (NAME, Description) values ('ibrahim', 'bla bla bla');
insert into task_definition_mirror (NAME, Description) values ('task ', 'bla bla bla');