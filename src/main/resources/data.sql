insert into SPECIES(NAME, LANGUAGE) values ('Human','Common');
insert into SPECIES(NAME, LANGUAGE) values ('Droid', 'n/a');

insert into FILM(ID, DIRECTOR, RELEASE_DATE, TITLE) values (1, 'George Lucas', '1977-05-25', 'A New Hope');
insert into FILM(ID, DIRECTOR, RELEASE_DATE, TITLE) values (2, 'Irvin Kershner', '1980-05-17', 'The Empire Strikes Back');
insert into FILM(ID, DIRECTOR, RELEASE_DATE, TITLE) values (3, 'Richard Marquand', '1983-05-25', 'Return of the Jedi');
insert into FILM(ID, DIRECTOR, RELEASE_DATE, TITLE) values (4, 'George Lucas', '1999-05-19', 'The Phantom Menace');

insert into PERSON(ID, NAME, GENDER, SPECIES) values(1,	'Luke Skywalker','MALE','Human');
insert into PERSON(ID, NAME, GENDER, SPECIES) values(2,	'C-3PO','UNKNOWN','Droid');
insert into PERSON(ID, NAME, GENDER, SPECIES) values(3,	'R2-D2','UNKNOWN','Droid');
insert into PERSON(ID, NAME, GENDER, SPECIES) values(4,	'Darth Vader','MALE','Human');
insert into PERSON(ID, NAME, GENDER, SPECIES) values(5,	'Leia Organa','FEMALE','Human');

insert into PERSON_FILM(PERSON_ID, FILM_ID) values(1,1);
insert into PERSON_FILM(PERSON_ID, FILM_ID) values(1,2);
insert into PERSON_FILM(PERSON_ID, FILM_ID) values(1,3);
insert into PERSON_FILM(PERSON_ID, FILM_ID) values(1,4);
insert into PERSON_FILM(PERSON_ID, FILM_ID) values(2,1);
insert into PERSON_FILM(PERSON_ID, FILM_ID) values(2,3);
insert into PERSON_FILM(PERSON_ID, FILM_ID) values(3,3);
insert into PERSON_FILM(PERSON_ID, FILM_ID) values(4,1);
insert into PERSON_FILM(PERSON_ID, FILM_ID) values(4,2);
insert into PERSON_FILM(PERSON_ID, FILM_ID) values(4,3);
insert into PERSON_FILM(PERSON_ID, FILM_ID) values(4,4);
insert into PERSON_FILM(PERSON_ID, FILM_ID) values(5,1);
insert into PERSON_FILM(PERSON_ID, FILM_ID) values(5,3);