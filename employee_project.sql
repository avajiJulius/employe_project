DROP TABLE IF EXISTS professions;
DROP TABLE IF EXISTS drivers;
DROP TABLE IF EXISTS nannies;
DROP TABLE IF EXISTS prev_employers;

CREATE TABLE prev_employers (
	prev_employer_id SERIAL,
	f_name varchar(15) not null,
	l_name varchar(20) not null,
	work_start date not null,
	work_end date not null,
	quit_reason text,
	PRIMARY KEY(prev_employer_id)
);

CREATE TABLE nannies (
	nanny_id SERIAL,
	prev_employer_id integer,
	f_name varchar(15) not null,
	l_name varchar(20) not null,
	b_day date not null,
	experience double precision,
	hourly_pay double precision not null,
	about text,
	mail varchar(30) not null,
	PRIMARY KEY(nanny_id)
);

CREATE TABLE drivers (
	driver_id SERIAL,
	prev_employer_id integer,
	f_name varchar(15) not null,
	l_name varchar(20) not null,
	b_day date not null,
	experience double precision,
	salary double precision not null,
	car_model varchar(15),
	about text,
	mail varchar(30) not null,
	PRIMARY KEY(driver_id)
);

CREATE TABLE professions (
	profession_id SERIAL,
	professions varchar(15) not null,
 	PRIMARY KEY(profession_id)
);