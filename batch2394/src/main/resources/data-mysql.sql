CREATE TABLE PERSON
(
  person_id INT NOT NULL PRIMARY KEY,
  name VARCHAR(20),
  address_id INT -- can add foreign key but not necessary IMO
);

CREATE TABLE ADDRESS
(
  address_id INT NOT NULL PRIMARY KEY,
  name VARCHAR(20)
);

insert into ADDRESS values (1, 'oxford street1');
insert into ADDRESS values (2, 'oxford street2');
insert into ADDRESS values (3, 'oxford street3');
insert into ADDRESS values (4, 'oxford street4');

insert into PERSON values (1, 'foo', 1);
insert into PERSON values (2, 'bar', 2);
insert into PERSON values (3, 'toto', 3);
insert into PERSON values (4, 'titi', 4);




