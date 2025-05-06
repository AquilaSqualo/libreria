
CREATE DATABASE libreria
    DEFAULT CHARACTER SET = 'utf8mb4';

create table libreria.autori (
    id_autore int AUTO_INCREMENT,
    nome VARCHAR(30) not null,
    cognome varchar(30) not null,
    compleanno date,
    constraint pk_autore PRIMARY KEY (id_autore)
)

create table libreria.libri (
    id_libro int AUTO_INCREMENT,
    titolo VARCHAR(50) not null,
    id_autore int not null,
    editore varchar(30),
    anno int,
    pagine int,
    segnalibro int DEFAULT 0,
    constraint pk_libro PRIMARY KEY (id_libro),
    constraint fk_LibroAutore Foreign Key (id_autore) REFERENCES libreria.autori(id_autore),
    check(anno >= 0),
    check(pagine >= 0),
    check(segnalibro >= 0)
)

drop table libreria.autori

drop table libreria.libri

insert into libreria.autori(nome,cognome) values ("Sara","Simoni")

insert into libreria.libri(titolo,id_autore,editore,anno,pagine) values ("Dolomites",(select id_autore from libreria.autori where nome = "Sara" and cognome = "Simoni"),"Acheron",2021,480)

update libreria.autori set compleanno = "1992-08-13" where cognome = "Simoni" AND nome = "Sara"

INSERT INTO libreria.autori (nome,cognome,compleanno) values ("Barbara","Manca","1988-05-24");

ALTER TABLE libreria.libri ADD COLUMN sottoTitolo VARCHAR(200) AFTER titolo

SELECT * FROM libreria.libri WHERE titolo = "Sigma"

UPDATE libreria.libri SET segnalibro = 10 where titolo = "Sigma"

CREATE TABLE PROVA (
    ID_PROVA INT AUTO_INCREMENT,
    CALENDARIO DATE,
    CONSTRAINT PK_PROVA PRIMARY KEY (ID_PROVA)
)

INSERT INTO libreria.prova (CALENDARIO) VALUES (NULL);

SELECT * FROM LIBRERIA.PROVA

ALTER TABLE libreria.prova ADD COLUMN pagine INT

UPDATE libreria.prova SET PAGINE = "3" WHERE ID_PROVA = 1

/* Posso inserire una stringa contenente un numero per un campo intero */

alter Table libreria.libri AUTO_INCREMENT = 5

alter Table libreria.libri AUTO_INCREMENT = 7

DELETE FROM prova WHERE `ID_PROVA`= 1