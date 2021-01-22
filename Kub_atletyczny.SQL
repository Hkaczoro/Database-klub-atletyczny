/*
Created: 1/17/2021
Modified: 1/17/2021
Model: Klub_Atletyczny_pop
Database: Oracle 19c
*/


-- Create sequences section -------------------------------------------------

CREATE SEQUENCE ZawSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE TrenerSeq2
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE AdresySeq3
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE ZawodySeq4
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE SponsSeq5
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE KatSeq6
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE PoczSeq7
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE TrenSeq8
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE TermSeq9
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE CzasSeq10
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

-- Create tables section -------------------------------------------------

-- Table Zawodnicy

CREATE TABLE Zawodnicy(
  Nr_zawodnika Integer NOT NULL,
  Imie Varchar2(30 ) NOT NULL,
  Nazwisko Varchar2(60 ) NOT NULL,
  Plec Char(1 ) NOT NULL
        CHECK (Plec IN ('K', 'M')),
  Wzrost Float(126),
  Waga Float(126),
  Data_urodzenia Date NOT NULL,
  Narodowosc Varchar2(40 ) NOT NULL,
  Pesel Varchar2(15 ) NOT NULL,
  Nr_kategorii Integer NOT NULL,
  Nr_adresu Integer NOT NULL
)
/

-- Create indexes for table Zawodnicy

CREATE INDEX IX_Posiada ON Zawodnicy (Nr_kategorii)
/

CREATE INDEX IX_Relationship1 ON Zawodnicy (Nr_adresu)
/

-- Add keys for table Zawodnicy

ALTER TABLE Zawodnicy ADD CONSTRAINT Zawodnik_PK PRIMARY KEY (Nr_zawodnika)
/

-- Table Trenerzy

CREATE TABLE Trenerzy(
  Nr_trenera Integer NOT NULL,
  Imie Varchar2(30 ) NOT NULL,
  Nazwisko Varchar2(60 ) NOT NULL,
  Dyscyplina Varchar2(30 ) NOT NULL,
  Pesel Varchar2(15 ) NOT NULL,
  Pensja Number(8,2) NOT NULL
)
/

-- Add keys for table Trenerzy

ALTER TABLE Trenerzy ADD CONSTRAINT Trener_PK PRIMARY KEY (Nr_trenera)
/

-- Table and Columns comments section

COMMENT ON COLUMN Trenerzy.Pensja IS 'Wartość pensji'
/

-- Table Treningi

CREATE TABLE Treningi(
  Nr_treningu Integer NOT NULL,
  Rodzaj_treningu Varchar2(30 ) NOT NULL,
  Miejsce Varchar2(40 ) NOT NULL
)
/

-- Add keys for table Treningi

ALTER TABLE Treningi ADD CONSTRAINT Trening_PK PRIMARY KEY (Nr_treningu)
/

-- Table Czas

CREATE TABLE Czas(
  Nr_czasu Integer NOT NULL,
  Dzien_tygodnia Varchar2(40 ) NOT NULL,
  Godzina_rozpoczenia Varchar2(5 ) NOT NULL
)
/

-- Add keys for table Czas

ALTER TABLE Czas ADD CONSTRAINT Czas_PK PRIMARY KEY (Nr_czasu)
/

-- Table Adresy

CREATE TABLE Adresy(
  Nr_adresu Integer NOT NULL,
  Ulica Varchar2(30 ) NOT NULL,
  Nr_domu Varchar2(10 ) NOT NULL,
  Nr_mieszkania Varchar2(10 ) NOT NULL,
  Miasto Varchar2(30 ) NOT NULL,
  Nr_poczty Integer NOT NULL
)
/

-- Create indexes for table Adresy

CREATE INDEX IX_Relationship2 ON Adresy (Nr_poczty)
/

-- Add keys for table Adresy

ALTER TABLE Adresy ADD CONSTRAINT Adres_PK PRIMARY KEY (Nr_adresu)
/

-- Table Terminy

CREATE TABLE Terminy(
  Nr_terminu Integer NOT NULL,
  Poczatek Varchar2(30 ) NOT NULL,
  Koniec Varchar2(30 ) NOT NULL,
  Data Date NOT NULL
)
/

-- Add keys for table Terminy

ALTER TABLE Terminy ADD CONSTRAINT Termin_PK PRIMARY KEY (Nr_terminu)
/

-- Table Zawody

CREATE TABLE Zawody(
  Nr_zawodow Integer NOT NULL,
  Dyscyplina Varchar2(40 ) NOT NULL,
  Nazwa Varchar2(60 ) NOT NULL,
  Miasto Varchar2(30 ) NOT NULL,
  Miejsce_zwodnika Integer NOT NULL
)
/

-- Add keys for table Zawody

ALTER TABLE Zawody ADD CONSTRAINT Zawody_PK PRIMARY KEY (Nr_zawodow)
/

-- Table Sponsorzy

CREATE TABLE Sponsorzy(
  Nr_sponsora Integer NOT NULL,
  Nazwa Varchar2(60 ) NOT NULL,
  Kwota Float(126) NOT NULL,
  Czas_umowy Varchar2(30 ) NOT NULL
)
/

-- Add keys for table Sponsorzy

ALTER TABLE Sponsorzy ADD CONSTRAINT Sponsor_PK PRIMARY KEY (Nr_sponsora)
/

-- Table Kategorie_wiekowe

CREATE TABLE Kategorie_wiekowe(
  Nr_kategorii Integer NOT NULL,
  Kategoria Varchar2(30 ) NOT NULL,
  Minimalny_wiek Integer NOT NULL,
  Maksymalny_wiek Integer NOT NULL
)
/

-- Add keys for table Kategorie_wiekowe

ALTER TABLE Kategorie_wiekowe ADD CONSTRAINT Kategoria_PK PRIMARY KEY (Nr_kategorii)
/

-- Table Zawodnik_Trener

CREATE TABLE Zawodnik_Trener(
  Nr_zawodnika Integer NOT NULL,
  Nr_trenera Integer NOT NULL
)
/

-- Table Zawodnik_Zawody

CREATE TABLE Zawodnik_Zawody(
  Nr_zawodnika Integer NOT NULL,
  Nr_zawodow Integer NOT NULL
)
/

-- Table Zawodnik_Sponsor

CREATE TABLE Zawodnik_Sponsor(
  Nr_zawodnika Integer NOT NULL,
  Nr_sponsora Integer NOT NULL
)
/

-- Table Zawody_Termin

CREATE TABLE Zawody_Termin(
  Nr_zawodow Integer NOT NULL,
  Nr_terminu Integer NOT NULL
)
/

-- Table Trener_Trening

CREATE TABLE Trener_Trening(
  Nr_trenera Integer NOT NULL,
  Nr_treningu Integer NOT NULL
)
/

-- Table Trening_Czas

CREATE TABLE Trening_Czas(
  Nr_treningu Integer NOT NULL,
  Nr_czasu Integer NOT NULL
)
/

-- Table Poczty

CREATE TABLE Poczty(
  Nr_poczty Integer NOT NULL,
  Kod_poczty Char(6 ) NOT NULL,
  Poczta Varchar2(30 ) NOT NULL
)
/

-- Add keys for table Poczty

ALTER TABLE Poczty ADD CONSTRAINT PK_Poczty PRIMARY KEY (Nr_poczty)
/

ALTER TABLE Poczty ADD CONSTRAINT Kod poczty UNIQUE (Kod_poczty)
/

-- Table and Columns comments section

COMMENT ON COLUMN Poczty.Nr_poczty IS 'Unikatowy identyfikator'
/
COMMENT ON COLUMN Poczty.Kod_poczty IS 'Kod poczty'
/

-- Trigger for sequence ZawSeq1 for column Nr_zawodnika in table Zawodnicy ---------
CREATE OR REPLACE TRIGGER ts_Zawodnicy_ZawSeq1 BEFORE INSERT
ON Zawodnicy FOR EACH ROW
BEGIN
  :new.Nr_zawodnika := ZawSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Zawodnicy_ZawSeq1 AFTER UPDATE OF Nr_zawodnika
ON Zawodnicy FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_zawodnika in table Zawodnicy as it uses sequence.');
END;
/

-- Trigger for sequence TrenerSeq2 for column Nr_trenera in table Trenerzy ---------
CREATE OR REPLACE TRIGGER ts_Trenerzy_TrenerSeq2 BEFORE INSERT
ON Trenerzy FOR EACH ROW
BEGIN
  :new.Nr_trenera := TrenerSeq2.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Trenerzy_TrenerSeq2 AFTER UPDATE OF Nr_trenera
ON Trenerzy FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_trenera in table Trenerzy as it uses sequence.');
END;
/

-- Trigger for sequence TrenSeq8 for column Nr_treningu in table Treningi ---------
CREATE OR REPLACE TRIGGER ts_Treningi_TrenSeq8 BEFORE INSERT
ON Treningi FOR EACH ROW
BEGIN
  :new.Nr_treningu := TrenSeq8.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Treningi_TrenSeq8 AFTER UPDATE OF Nr_treningu
ON Treningi FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_treningu in table Treningi as it uses sequence.');
END;
/

-- Trigger for sequence CzasSeq10 for column Nr_czasu in table Czas ---------
CREATE OR REPLACE TRIGGER ts_Czas_CzasSeq10 BEFORE INSERT
ON Czas FOR EACH ROW
BEGIN
  :new.Nr_czasu := CzasSeq10.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Czas_CzasSeq10 AFTER UPDATE OF Nr_czasu
ON Czas FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_czasu in table Czas as it uses sequence.');
END;
/

-- Trigger for sequence AdresySeq3 for column Nr_adresu in table Adresy ---------
CREATE OR REPLACE TRIGGER ts_Adresy_AdresySeq3 BEFORE INSERT
ON Adresy FOR EACH ROW
BEGIN
  :new.Nr_adresu := AdresySeq3.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Adresy_AdresySeq3 AFTER UPDATE OF Nr_adresu
ON Adresy FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_adresu in table Adresy as it uses sequence.');
END;
/

-- Trigger for sequence TermSeq9 for column Nr_terminu in table Terminy ---------
CREATE OR REPLACE TRIGGER ts_Terminy_TermSeq9 BEFORE INSERT
ON Terminy FOR EACH ROW
BEGIN
  :new.Nr_terminu := TermSeq9.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Terminy_TermSeq9 AFTER UPDATE OF Nr_terminu
ON Terminy FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_terminu in table Terminy as it uses sequence.');
END;
/

-- Trigger for sequence ZawodySeq4 for column Nr_zawodow in table Zawody ---------
CREATE OR REPLACE TRIGGER ts_Zawody_ZawodySeq4 BEFORE INSERT
ON Zawody FOR EACH ROW
BEGIN
  :new.Nr_zawodow := ZawodySeq4.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Zawody_ZawodySeq4 AFTER UPDATE OF Nr_zawodow
ON Zawody FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_zawodow in table Zawody as it uses sequence.');
END;
/

-- Trigger for sequence SponsSeq5 for column Nr_sponsora in table Sponsorzy ---------
CREATE OR REPLACE TRIGGER ts_Sponsorzy_SponsSeq5 BEFORE INSERT
ON Sponsorzy FOR EACH ROW
BEGIN
  :new.Nr_sponsora := SponsSeq5.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Sponsorzy_SponsSeq5 AFTER UPDATE OF Nr_sponsora
ON Sponsorzy FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_sponsora in table Sponsorzy as it uses sequence.');
END;
/

-- Trigger for sequence KatSeq6 for column Nr_kategorii in table Kategorie_wiekowe ---------
CREATE OR REPLACE TRIGGER ts_Kategorie_wiekowe_KatSeq6 BEFORE INSERT
ON Kategorie_wiekowe FOR EACH ROW
BEGIN
  :new.Nr_kategorii := KatSeq6.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Kategorie_wiekowe_KatSeq6 AFTER UPDATE OF Nr_kategorii
ON Kategorie_wiekowe FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_kategorii in table Kategorie_wiekowe as it uses sequence.');
END;
/

-- Trigger for sequence PoczSeq7 for column Nr_poczty in table Poczty ---------
CREATE OR REPLACE TRIGGER ts_Poczty_PoczSeq7 BEFORE INSERT
ON Poczty FOR EACH ROW
BEGIN
  :new.Nr_poczty := PoczSeq7.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Poczty_PoczSeq7 AFTER UPDATE OF Nr_poczty
ON Poczty FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_poczty in table Poczty as it uses sequence.');
END;
/


-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE Zawodnicy ADD CONSTRAINT Posiada FOREIGN KEY (Nr_kategorii) REFERENCES Kategorie_wiekowe (Nr_kategorii)
/



ALTER TABLE Zawodnicy ADD CONSTRAINT Mieszka FOREIGN KEY (Nr_adresu) REFERENCES Adresy (Nr_adresu)
/



ALTER TABLE Adresy ADD CONSTRAINT Adres_ma_poczte FOREIGN KEY (Nr_poczty) REFERENCES Poczty (Nr_poczty)
/





