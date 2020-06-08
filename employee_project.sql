DROP TABLE IF EXISTS e_form;
DROP TABLE IF EXISTS n_info;
DROP TABLE IF EXISTS d_info;
DROP TABLE IF EXISTS e_info;
DROP TABLE IF EXISTS contact_info;
DROP TABLE IF EXISTS p_info;

CREATE TABLE p_info (
	person_id SERIAL,
	sex varchar(10),
	f_name varchar(15) not null,
	l_name varchar(20) not null,
	b_day date not null,
	PRIMARY KEY(person_id)
);

CREATE TABLE e_info (
	employee_id SERIAL,
	profession varchar(30) not null,
	expirience double precision,
	about text,
	PRIMARY KEY(employee_id)
);

CREATE TABLE n_info (
	nanny_id SERIAL,
	employee_id integer not null,
	hourly_pay double precision,
	children_age integer,
	PRIMARY KEY(nanny_id)
);

CREATE TABLE d_info (
	driver_id SERIAL,
	employee_id integer not null,
	salary double precision,
	car varchar(20),
	PRIMARY KEY(driver_id)
);

CREATE TABLE contact_info (
	contact_id SERIAL,
	mail varchar(30) not null,
	phone_num varchar(15),
	PRIMARY KEY(contact_id)
);

CREATE TABLE e_form (
	form_id SERIAL,
	person_id integer not null,
	employee_id integer not null,
	contact_id integer not null,
	PRIMARY KEY(form_id)
)
