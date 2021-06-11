CREATE TABLE CONTACT
(
    ID        SERIAL,
    FIRSTNAME TEXT,
    LASTNAME  TEXT,
    EMAIL     TEXT,
    CONSTRAINT PK_CONTACT PRIMARY KEY (ID)
);

INSERT INTO CONTACT(FIRSTNAME, LASTNAME, EMAIL)
VALUES ('jean', 'perrier', 'jp@example.com');
INSERT INTO CONTACT(FIRSTNAME, LASTNAME, EMAIL)
VALUES ('paul', 'chapuis', 'pc@example.com');
INSERT INTO CONTACT(FIRSTNAME, LASTNAME, EMAIL)
VALUES ('jeannine', 'laberge', 'jl@example.com');
INSERT INTO CONTACT(FIRSTNAME, LASTNAME, EMAIL)
VALUES ('arnaud', 'gabriaux', 'ag@example.com');
INSERT INTO CONTACT(FIRSTNAME, LASTNAME, EMAIL)
VALUES ('patricia', 'poulin', 'pp@example.com');