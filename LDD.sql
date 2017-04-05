set autocommit on;

create table ishare_user (
  user_id NUMBER not null,
  prenom VARCHAR2(30) not null,
  nom VARCHAR2(30) not null,
  courriel VARCHAR2(60) not null,
  numtel NUMBER not null,
  code_postal VARCHAR2(10) not null,
  numero NUMBER,
  rue VARCHAR2(60),
  province VARCHAR2(4),
  ville VARCHAR2(60));

ALTER TABLE ishare_user ADD CONSTRAINT pk_ishare_user PRIMARY KEY(user_id);

create table objet (
  objet_id NUMBER not null,
  description VARCHAR2(300),
  disponible NUMBER(1) not null,
  prix NUMBER not null,
  duree_partage NUMBER not null,
  proprietaire NUMBER not null);

ALTER TABLE objet ADD CONSTRAINT pk_objet PRIMARY KEY (objet_id);
ALTER TABLE objet ADD CONSTRAINT fk_proprietaire FOREIGN KEY (proprietaire) REFERENCES ishare_user(user_id);

create table emprunte(
  emprunt_user NUMBER not null,
  emprunt_objet number not null,
  jour_in number not null,
  mois_in number not null,
  annee_in number,
  jour_out number not null,
  mois_out number not null,
  annee_out number);

ALTER TABLE emprunte ADD CONSTRAINT fk_emprunt_user FOREIGN KEY (emprunt_user) REFERENCES ishare_user(user_id);
ALTER TABLE emprunte ADD CONSTRAINT fk_emprunt_objet FOREIGN KEY (emprunt_objet) REFERENCES objet(objet_id);

create table interet(
  interet_user NUMBER not null,
  interet_objet NUMBER not null);

ALTER TABLE interet ADD CONSTRAINT fk_interet_user FOREIGN KEY (interet_user) REFERENCES ishare_user(user_id);
ALTER TABLE interet ADD CONSTRAINT fk_interet_objet FOREIGN KEY (interet_objet) REFERENCES objet(objet_id);

create table maison(
  annee NUMBER,
  superficie NUMBER,
  etage NUMBER,
  chambre NUMBER,
  meuble NUMBER(1) not null,
  stationnement NUMBER(1) not null,
  salle_bain NUMBER);
 
create table velo(
  marque VARCHAR2(30),
  taille_cadre NUMBER,
  vitesse NUMBER,
  frein VARCHAR2(30),
  taille_roue NUMBER,
  type VARCHAR2(30));
 
create table auto(
  annee NUMBER,
  marque VARCHAR2(30),
  km NUMBER,
  transmission_manuel NUMBER(1) not null,
  format VARCHAR2(30),
  consommation NUMBER);

INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values(001,"Simon","Milhomme","smilhomme@gmail.com",4501234567, "H9S3K6", 314, "Mimosa", "QC", "Dorval");
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values(002, "Simone", "Milhomski","milhomski@gmail.com", 5149762534, "H4B2C6", 4572, "Coronation", "QC", "Montreal");
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values(003, "Ginette", "Milou", "sacoche450@gmail.com", 5147284354, "H3T1J4", 2350, "boulevard Montpetit", "QC", "Montreal");
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values(004, "Richard", "Martineau", "rich_money@gmail.com", 5148275454, "J0K2R0", 3031, "rang Saintt-Jacques", "QC", "Saint-Jacques");
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values(005, "Marie", "Framboise", "franframboise@gmail.com", 5147280974, "H3R1L8", 72, "Kenastion", "QC", "Ville Mont-Royal");
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values(006, "Dieudonne", "Conde","chat_cool@gmail.com", 5148340987, "H3S1W6", 3195, "Ellendale", "QC", "Montreal");
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values(007, "Jules", "Poirier", "plus_grand_que_toi@gmail.com", 5147282345, "H3V1E1", 4950, "Coronet", "QC", "Montreal");
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values(008, "Lang","Cerise", "cerise@gmail.com", 5149872847, "H1J2Y4", 7080, "Avenue du Belvedere", "QC", "Anjou");
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values(009, "Choco", "Montana", "montana@gmail.com", 5147297676, "H2A3C9", 7380, "8e avenue", "QC", "Montreal");
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values(010, "Valerie","Zoukini","val@gmail.com", 4188332626, "H3W1R6", 4853, "Lacombe", "QC", "Montreal");
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values(011, "Oli", "Miner", "oli_cool@gmail.com", 5147654321, "H3T1J6", 2747, "boul. Edouard-Montpetit", "QC", "Montreal");
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values(012, "Jet", "Li", "karate@gmail.com", 4182780927, "H3T1J1", 4175, "ave. Saint-Kevin", "QC", "Montreal");
