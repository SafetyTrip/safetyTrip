/* Drop Triggers */

DROP TRIGGER TRI_CITY_cityno;
DROP TRIGGER TRI_COUNTRY_couno;
DROP TRIGGER TRI_HOTEL_hno;
DROP TRIGGER TRI_QNA_qno;
DROP TRIGGER TRI_RESERVATION_resno;
DROP TRIGGER TRI_REVIEW_revno;
DROP TRIGGER TRI_REV_COMMENT_comno;
DROP TRIGGER TRI_REV_HOTEL_rhno;
DROP TRIGGER TRI_ROOM_roomno;
DROP TRIGGER TRI_SAFETY_sno;
DROP TRIGGER TRI_USERS_uno;



/* Drop Tables */

DROP TABLE QNA CASCADE CONSTRAINTS;
DROP TABLE REV_HOTEL CASCADE CONSTRAINTS;
DROP TABLE RESERVATION CASCADE CONSTRAINTS;
DROP TABLE ROOM CASCADE CONSTRAINTS;
DROP TABLE HOTEL CASCADE CONSTRAINTS;
DROP TABLE REV_COMMENT CASCADE CONSTRAINTS;
DROP TABLE REVIEW CASCADE CONSTRAINTS;
DROP TABLE CITY CASCADE CONSTRAINTS;
DROP TABLE SAFETY CASCADE CONSTRAINTS;
DROP TABLE COUNTRY CASCADE CONSTRAINTS;
DROP TABLE USERS CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_CITY_cityno;
DROP SEQUENCE SEQ_COUNTRY_couno;
DROP SEQUENCE SEQ_HOTEL_hno;
DROP SEQUENCE SEQ_QNA_qno;
DROP SEQUENCE SEQ_RESERVATION_resno;
DROP SEQUENCE SEQ_REVIEW_revno;
DROP SEQUENCE SEQ_REV_COMMENT_comno;
DROP SEQUENCE SEQ_REV_HOTEL_rhno;
DROP SEQUENCE SEQ_ROOM_roomno;
DROP SEQUENCE SEQ_SAFETY_sno;
DROP SEQUENCE SEQ_USERS_uno;




/* Create Sequences */

CREATE SEQUENCE SEQ_CITY_cityno INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_COUNTRY_couno INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_HOTEL_hno INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_QNA_qno INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_RESERVATION_resno INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_REVIEW_revno INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_REV_COMMENT_comno INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_REV_HOTEL_rhno INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_ROOM_roomno INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_SAFETY_sno INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_USERS_uno INCREMENT BY 1 START WITH 1;


/* Create Tables */

CREATE TABLE CITY
(
	cityno number(10,0) constraint city_cityno_nn NOT NULL,
	couno number(3,0) constraint city_cunno_nn NOT NULL,
	cityname varchar2(50) constraint city_cityname_nn NOT NULL,
	cityename varchar2(50) constraint city_cityename_nn NOT NULL,
	constraint city_cityno_pk PRIMARY KEY (cityno)
);




CREATE TABLE COUNTRY
(
	couno number(3,0) constraint country_couno_nn NOT NULL,
	cname varchar2(50) constraint country_cname_nn NOT NULL constraint country_cname_uk UNIQUE,
	cename varchar2(50) constraint country_cename_nn NOT NULL constraint country_cename_uk UNIQUE,
	continent varchar2(10) constraint country_continent_nn NOT NULL, 
	constraint country_couno_pk PRIMARY KEY (couno)
);


CREATE TABLE HOTEL
(
	hno number(7,0) constraint hotel_hno_nn NOT NULL,
	cityno number(10,0) constraint hotel_cityno_nn NOT NULL,
	hname varchar2(100) constraint hotel_hname_nn NOT NULL,
	good number(10,0) DEFAULT 0,
	address varchar2(100) constraint hotel_address_nn NOT NULL,
	lat varchar2(20) constraint hotel_lat_nn NOT NULL,
	lng varchar2(20) constraint hotel_lng_nn NOT NULL,
	constraint hotel_hno_pk PRIMARY KEY (hno)
);


CREATE TABLE QNA
(
	qno number(7,0) constraint qna_qno_nn NOT NULL,
	uno number(7,0) constraint qna_uno_nn NOT NULL,
	hno number(10,0) constraint qna_hno_nn NOT NULL,
	title varchar2(1000) constraint qna_title_nn NOT NULL,
	question clob constraint qna_question_nn NOT NULL,
	answer clob,
	qopen number(1) 
    DEFAULT 1 
    constraint qna_qopen_nn NOT NULL 
    constraint qna_qopen_ck CHECK(qopen = 0 or qopen = 1),
	createdate date DEFAULT SYSDATE 
  constraint qna_createdate_nn NOT NULL,
	constraint qna_qno_pk PRIMARY KEY (qno)
);


CREATE TABLE RESERVATION
(
	resno number(8) constraint reservation_resno_nn NOT NULL,
	uno number(7,0) constraint reservation_uno_nn NOT NULL,
	roomno number(10,0) constraint reservation_roomno_nn NOT NULL,
	room number(4,0) constraint reservation_room_nn NOT NULL,
	sdate date constraint reservation_sdate_nn NOT NULL,
	edate date constraint reservation_edate_nn NOT NULL,
	createdate date DEFAULT SYSDATE constraint reservation_createdate_nn NOT NULL,
	constraint reservation_resno_pk PRIMARY KEY (resno)
);


CREATE TABLE REVIEW
(
	revno number(7,0) constraint review_revno_nn NOT NULL,
	uno number(7,0) constraint review_uno_nn NOT NULL,
	cityno number(10,0) constraint review_cityno_nn NOT NULL,
	title varchar2(1000) constraint review_title_nn NOT NULL,
	content clob constraint review_content_nn NOT NULL,
	viewscount number(10,0) DEFAULT 0 constraint review_viewscount_nn NOT NULL,
	good number(10,0) DEFAULT 0 constraint review_good_nn NOT NULL,
	createdate date DEFAULT SYSDATE constraint review_createdate_nn NOT NULL,
	constraint review_revno_pk PRIMARY KEY (revno)
);

select * from tab;

CREATE TABLE REV_COMMENT
(
	comno number(10,0) constraint rev_comment_comno_nn NOT NULL,
	revno number(7,0) constraint rev_comment_revno__nn NOT NULL,
	uno number(7,0) constraint rev_comment_uno_nn NOT NULL,
	comcontent varchar2(1000),
	createdate date DEFAULT SYSDATE constraint rev_comment_createdate_nn NOT NULL,
	constraint rev_comment_comno_pk PRIMARY KEY (comno)
);


CREATE TABLE REV_HOTEL
(
	rhno number(10,0) constraint rev_hotel_rhno_nn NOT NULL,
	revno number(7,0) constraint rev_hotel_revno_nn NOT NULL,
	hno number(7,0) constraint rev_hotel_hno_nn NOT NULL,
	constraint rev_hotel_rhno_pk PRIMARY KEY (rhno)
);

CREATE TABLE ROOM
(
	roomno number(10,0) constraint room_roomno_nn NOT NULL,
	hno number(7,0) constraint room_hno_nn NOT NULL,
	num number(4,0) constraint room_num_nn NOT NULL,
	constraint room_roomno_pk PRIMARY KEY (roomno)
);

CREATE TABLE SAFETY
(
	sno number(4,0) constraint safety_sno_nn NOT NULL,
	couno number(3,0) constraint safety_couno_nn NOT NULL,
	title varchar2(1000) constraint safety_title_nn NOT NULL,
	content clob constraint safety_content_nn NOT NULL,
	id varchar2(20) constraint safety_id_nn NOT NULL,
	createdate date DEFAULT SYSDATE constraint safety_createdate_nn NOT NULL,
	constraint safety_sno_pk PRIMARY KEY (sno)
);


CREATE TABLE USERS
(
	uno number(7,0) constraint users_uno_nn NOT NULL,
	userid varchar2(20)  constraint users_userid_nn NOT NULL constraint users_userid_uk UNIQUE,
	passwd varchar2(20) constraint users_passwd_nn NOT NULL,
	email varchar2(30) constraint users_email_nn NOT NULL constraint users_email_uk UNIQUE,
	uname varchar2(20) constraint users_uname_nn NOT NULL constraint users_uname_uk UNIQUE,
	name varchar2(20) constraint users_name_nn NOT NULL,
	passport varchar2(20) constraint users_passport_nn NOT NULL,
	sex nchar constraint users_sex_nn NOT NULL constraint users_sex_ck CHECK(sex = 'M' or sex = 'F'),
	birth date constraint users_birth_nn NOT NULL,
	post varchar2(5) constraint users_post_nn NOT NULL,
	address1 varchar2(500) constraint users_address1_nn NOT NULL,
	address2 varchar2(500) constraint users_address2_nn NOT NULL,
	createdate date DEFAULT SYSDATE constraint users_createdate_nn NOT NULL,
	eaccess number(1) DEFAULT 0 constraint users_eaccess_nn NOT NULL constraint users_eaccess_ck CHECK(eaccess = 0 or eaccess = 1),
	constraint users_uno_pk PRIMARY KEY (uno)
);



/* Create Foreign Keys */

ALTER TABLE HOTEL
	ADD constraint hotel_cityno_fk
    FOREIGN KEY (cityno)
	REFERENCES CITY (cityno)
;


ALTER TABLE REVIEW
	ADD constraint review_cityno_fk
	FOREIGN KEY (cityno)
	REFERENCES CITY (cityno)
;


ALTER TABLE CITY
	ADD constraint city_couno_fk
	FOREIGN KEY (couno)
	REFERENCES COUNTRY (couno)
;


ALTER TABLE SAFETY
	ADD constraint safety_couno_fk
	FOREIGN KEY (couno)
	REFERENCES COUNTRY (couno)
;


ALTER TABLE QNA
	ADD constraint qna_hno_fk
    FOREIGN KEY (hno)
	REFERENCES HOTEL (hno)
;


ALTER TABLE RESERVATION
	ADD constraint reservation_roomno_fk
	FOREIGN KEY (roomno)
	REFERENCES ROOM (roomno)
;


ALTER TABLE REV_HOTEL
	ADD constraint rev_hotel_hno_fk
	FOREIGN KEY (hno)
	REFERENCES HOTEL (hno)
;


ALTER TABLE REV_COMMENT
	ADD constraint rev_comment_revno_fk
	FOREIGN KEY (revno)
	REFERENCES REVIEW (revno)
;


ALTER TABLE REV_HOTEL
	ADD constraint rev_hotel_revno_fk
	FOREIGN KEY (revno)
	REFERENCES REVIEW (revno)
;


ALTER TABLE QNA
	ADD constraint qna_uno_fk
	FOREIGN KEY (uno)
	REFERENCES USERS (uno)
;


ALTER TABLE RESERVATION
	ADD constraint reservation_uno_fk
	FOREIGN KEY (uno)
	REFERENCES USERS (uno)
;


ALTER TABLE REVIEW
	ADD constraint review_uno_fk
	FOREIGN KEY (uno)
	REFERENCES USERS (uno)
;


ALTER TABLE REV_COMMENT
	ADD constraint rev_comment_uno_fk
	FOREIGN KEY (uno)
	REFERENCES USERS (uno)
;



/* Create Triggers */
/*
CREATE OR REPLACE TRIGGER TRI_CITY_cityno BEFORE INSERT ON CITY
FOR EACH ROW
BEGIN
	SELECT SEQ_CITY_cityno.nextval
	INTO :new.cityno
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_COUNTRY_couno BEFORE INSERT ON COUNTRY
FOR EACH ROW
BEGIN
	SELECT SEQ_COUNTRY_couno.nextval
	INTO :new.couno
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_HOTEL_hno BEFORE INSERT ON HOTEL
FOR EACH ROW
BEGIN
	SELECT SEQ_HOTEL_hno.nextval
	INTO :new.hno
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_QNA_qno BEFORE INSERT ON QNA
FOR EACH ROW
BEGIN
	SELECT SEQ_QNA_qno.nextval
	INTO :new.qno
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_RESERVATION_resno BEFORE INSERT ON RESERVATION
FOR EACH ROW
BEGIN
	SELECT SEQ_RESERVATION_resno.nextval
	INTO :new.resno
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_REVIEW_revno BEFORE INSERT ON REVIEW
FOR EACH ROW
BEGIN
	SELECT SEQ_REVIEW_revno.nextval
	INTO :new.revno
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_REV_COMMENT_comno BEFORE INSERT ON REV_COMMENT
FOR EACH ROW
BEGIN
	SELECT SEQ_REV_COMMENT_comno.nextval
	INTO :new.comno
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_REV_HOTEL_rhno BEFORE INSERT ON REV_HOTEL
FOR EACH ROW
BEGIN
	SELECT SEQ_REV_HOTEL_rhno.nextval
	INTO :new.rhno
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_SAFETY_sno BEFORE INSERT ON SAFETY
FOR EACH ROW
BEGIN
	SELECT SEQ_SAFETY_sno.nextval
	INTO :new.sno
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_USERS_uno BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
	SELECT SEQ_USERS_uno.nextval
	INTO :new.uno
	FROM dual;
END;

/
*/


insert into country(couno, cname, cename, continent)
values(SEQ_COUNTRY_couno.nextval, '영국', 'United Kingdom', 'Europe');

insert into country(couno, cname, cename, continent)
values(SEQ_COUNTRY_couno.nextval, '프랑스', 'France', 'Europe');

insert into country(couno, cname, cename, continent)
values(SEQ_COUNTRY_couno.nextval, '독일', 'Germany', 'Europe');

insert into country(couno, cname, cename, continent)
values(SEQ_COUNTRY_couno.nextval, '스페인', 'Spain', 'Europe');

insert into country(couno, cname, cename, continent)
values(SEQ_COUNTRY_couno.nextval, '이탈리아', 'Italy', 'Europe');

insert into country(couno, cname, cename, continent)
values(SEQ_COUNTRY_couno.nextval, '일본', 'Japan', 'Asia');

insert into country(couno, cname, cename, continent)
values(SEQ_COUNTRY_couno.nextval, '중국', 'China', 'Asia');

insert into country(couno, cname, cename, continent)
values(SEQ_COUNTRY_couno.nextval, '대만', 'Taiwan', 'Asia');

insert into country(couno, cname, cename, continent)
values(SEQ_COUNTRY_couno.nextval, '미국', 'United States of America', 'America');

insert into country(couno, cname, cename, continent)
values(SEQ_COUNTRY_couno.nextval, '캐나다', 'Canada', 'America');

commit;

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 1, '런던', 'London');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 1, '맨체스터', 'Manchester');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 1, '리버풀', 'Liverpool');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 2, '파리', 'Paris');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 2, '리옹', 'Lyon');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 2, '마르세유', 'Marseille');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 3, '베를린', 'Berlin');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 3, '뮌헨', 'München');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 4, '마드리드', 'Madrid');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 4, '바르셀로나', 'Barcelona');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 5, '로마', 'Roma');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 5, '밀라노', 'Millan');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 6, '도쿄', 'Tokyo');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 6, '쿄토', 'Kyoto');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 6, '오사카', 'Osaka');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 7, '베이징', 'Beijing');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 7, '상하이', 'Shanghai');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 8, '타이베이', 'Taipei');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 9, '뉴욕', 'New York');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 9, '워싱턴', 'Washington');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 9, '로스앤젤레스', 'Los Angeles');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 10, '토론토', 'Toronto');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 10, '몬토리올', 'Montreal');

insert into city(cityno, couno, cityname, cityename)
values (SEQ_CITY_cityno.nextval, 10, '오타와', 'Ottawa');

commit;


select * from country;
select * from city;
select * from hotel;
select * from safety;