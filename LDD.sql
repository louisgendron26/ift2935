set autocommit on;

DROP TABLE emprunte;
DROP TABLE interet;
DROP TABLE maison;
DROP TABLE velo;
DROP TABLE auto;
DROP TABLE objet;
DROP TABLE ishare_user;

--
-- CREATE TABLE INTO DATABASE 
--

create table ishare_user(
  user_id NUMBER not null,
  prenom VARCHAR2(30) not null,
  nom VARCHAR2(30) not null,
  courriel VARCHAR2(60) not null,
  numtel NUMBER(20) not null,
  code_postal VARCHAR2(15) not null,
  numero NUMBER(20),
  rue VARCHAR2(60),
  province VARCHAR2(4),
  ville VARCHAR2(60));

ALTER TABLE ishare_user ADD CONSTRAINT pk_ishare_user PRIMARY KEY(user_id);

create table objet(
  objet_id NUMBER not null,
  type VARCHAR2(7) not null,
  description VARCHAR2(500),
  -- 0: non disponible ; 1: disponible
  disponible NUMBER(1) not null,
  -- prix par jour
  prix NUMBER not null,
  -- durée du partage max : en jour
  dureeMax NUMBER not null,
  owner_id NUMBER not null);

ALTER TABLE objet ADD CONSTRAINT pk_objet PRIMARY KEY (objet_id);
ALTER TABLE objet ADD CONSTRAINT fk_owner_id FOREIGN KEY (owner_id) REFERENCES ishare_user(user_id) ON DELETE CASCADE;

create table maison(
  objet_id NUMBER not null,
  annee NUMBER,
  -- superficie en pied carrée
  superficie NUMBER,
  etage NUMBER,
  chambre NUMBER,
  -- 0: non meublé ; 1: meublé
  meuble NUMBER(1) not null,
  -- nombre de stationnements
  stationnement NUMBER(1) not null,
  salle_bain NUMBER);

ALTER TABLE maison ADD CONSTRAINT pk_maison PRIMARY KEY(objet_id);
ALTER TABLE maison ADD CONSTRAINT fk_maison_id FOREIGN KEY (objet_id) REFERENCES objet(objet_id) ON DELETE CASCADE;
 
create table velo(
  objet_id NUMBER not null,
  type_velo VARCHAR2(30),
  marque VARCHAR2(30),
  modele VARCHAR2(30),
  -- matériau du cadre 
  cadre VARCHAR2(30),
  freins VARCHAR2(30),
  -- taille des pneus en mesures métriques
  taille_pneus VARCHAR2(30),
  annee NUMBER,
  -- 0: homme ; 1: femme ; 2: unisexe
  sexe NUMBER);

ALTER TABLE velo ADD CONSTRAINT pk_velo PRIMARY KEY(objet_id);
ALTER TABLE velo ADD CONSTRAINT fk_velo_id FOREIGN KEY (objet_id) REFERENCES objet(objet_id) ON DELETE CASCADE;
 
create table auto(
  objet_id NUMBER not null,
  marque VARCHAR2(30),
  modele VARCHAR2(30),
  couleur VARCHAR2(30),
  annee NUMBER,
  -- 0: automatique ; 1: manuel
  transmission_manuel NUMBER(1) not null,
  nbPortes NUMBER,
  -- nombre de Litre par 100km
  consommation NUMBER);

ALTER TABLE auto ADD CONSTRAINT pk_auto PRIMARY KEY(objet_id);
ALTER TABLE auto ADD CONSTRAINT fk_auto_id FOREIGN KEY (objet_id) REFERENCES objet(objet_id) ON DELETE CASCADE;

create table emprunte(
  user_id NUMBER not null,
  objet_id NUMBER not null,
  -- duree de l'emprunt en jour
  duree NUMBER not null,
  -- format DATE : 'JJ/MM/AAAA'
  date_in DATE not null,
  date_out DATE);

ALTER TABLE emprunte ADD CONSTRAINT pk_emprunt PRIMARY KEY(user_id, objet_id);
ALTER TABLE emprunte ADD CONSTRAINT fk_emprunt_user FOREIGN KEY (user_id) REFERENCES ishare_user(user_id) ON DELETE CASCADE;
ALTER TABLE emprunte ADD CONSTRAINT fk_emprunt_objet FOREIGN KEY (objet_id) REFERENCES objet(objet_id) ON DELETE CASCADE;

create table interet(
  user_id NUMBER not null,
  objet_id NUMBER not null);

ALTER TABLE interet ADD CONSTRAINT pk_interet PRIMARY KEY(user_id, objet_id);
ALTER TABLE interet ADD CONSTRAINT fk_interet_user FOREIGN KEY (user_id) REFERENCES ishare_user(user_id) ON DELETE CASCADE;
ALTER TABLE interet ADD CONSTRAINT fk_interet_objet FOREIGN KEY (objet_id) REFERENCES objet(objet_id) ON DELETE CASCADE;

-- FIN CREATE TABLE

--
-- INSERT INTO ishare_user (30 users)
--
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (001, 'Simon','Milhomme','smilhomme@gmail.com',4501234567, 'H9S3K6', 314, 'Mimosa', 'QC', 'Dorval');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (002, 'Simone', 'Milhomski','milhomski@gmail.com', 5149762534, 'H4B2C6', 4572, 'Coronation', 'QC', 'Montreal');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (003, 'Ginette', 'Milou', 'acoche450@gmail.com', 5147284354, 'H3T1J4', 2350, 'boulevard Montpetit', 'QC', 'Montreal');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (004, 'Richard', 'Martineau', 'rich_money@gmail.com', 5148275454, 'J0K2R0', 3031, 'rang Saint-Jacques', 'QC', 'Saint-Jacques');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (005, 'Marie', 'Framboise', 'franframboise@gmail.com', 5147280974, 'H3R1L8', 72, 'Kenastion', 'QC', 'Ville Mont-Royal');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (006, 'Dieudonne', 'Conde', 'chat_cool@gmail.com', 5148340987, 'H3S1W6', 3195, 'Ellendale', 'QC', 'Montreal');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (007, 'Jules', 'Poirier', 'plus_grand_que_toi@gmail.com', 5147282345, 'H3V1E1', 4950, 'Coronet', 'QC', 'Montreal');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (008, 'Lang', 'Cerise', 'cerise@gmail.com', 5149872847, 'H1J2Y4', 7080, 'avenue du Belvedere', 'QC', 'Anjou');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (009, 'Choco', 'Montana', 'montana@gmail.com', 5147297676, 'H2A3C9', 7380, '8e avenue', 'QC', 'Montreal');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (010, 'Valerie','Zoukini','val@gmail.com', 4188332626, 'H3W1R6', 4853, 'Lacombe', 'QC', 'Montreal');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (011, 'Oli', 'Miner', 'oli_cool@gmail.com', 5147654321,'H3T1J6', 2747, 'boul. Edouard-Montpetit', 'QC', 'Montreal');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (012, 'Jet', 'Li', 'karate@gmail.com', 4182780927, 'H3T1J1', 4175, 'ave. Saint-Kevin', 'QC', 'Montreal');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (013, 'Agathe', 'Casgrain', 'agathe.ccyr@outlook.com', 5148044737, 'J3V2V2', 1543, 'Nelligan', 'QC', 'Saint-Bruno-de-Montarville');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (014, 'Jasper', 'Egan', 'jasper420@hotmail.com', 5147721829, 'H4E2W2', 5951, 'Jogues', 'QC', 'Montreal');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (015, 'Julia', 'Gobeil', 'jbobeil@hotmail.com', 5148872938, 'J4B7S4', 678, 'des Vikings', 'QC', 'Boucherville');  
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (016, 'Alexandra', 'Gobeil', 'agobail@hotmail.com', 5146698362, 'J4B7S4', 678, 'des Vikings', 'QC', 'Boucherville'); 
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (017, 'Paul', 'Arsenault', 'paula25@hotmail.com', 4189982301, 'H4E3W4', 5702, 'Laurendeau', 'QC', 'Montreal');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (018, 'Thomas', 'Gagnon', 'thomthom111@hotmail.com', 4182347766, 'H3Z1N8', 111, 'Sainte-Catherine', 'QC', 'Westmount'); 
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (019, 'Vincent', 'Tremblay', 'vinc_tremb@videotron.ca', 4502346754, 'J3V3W5', 1047, 'Galinée', 'QC', 'Saint-Bruno-de-Montarville');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (020, 'Vincent', 'Tremblay', 'tremblay_vincent@hotmail.com', 5146658877, 'J4B2E1', 202, 'le Baron', 'QC', 'Boucherville');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (021, 'Cédric', 'Roux', 'rouxced1234@hotmail.com', 5142238745, 'J4B2T9', 177, 'Tailhandier', 'QC', 'Boucherville');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (022, 'Catherine', 'Richie', 'cathriche99@hotmail.com', 5148845967, 'J4N1B3', 2240, 'Bédard', 'QC', 'Longueuil');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (023, 'Mathieu', 'St-Onge', 'smathieu@hotmail.com', 5148892344, 'J4N1S3', 1239, 'des Feuillus', 'QC', 'Longueuil');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (024, 'Patrick', 'Beaulieu', 'beaulieupat@hotmail.com', 5147762377, 'J4M2N6', 2583, 'Cantin', 'QC', 'Longueuil');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (025, 'James', 'Carrier', 'jamescarrier@hotmail.com', 5146671234, 'J3V6J9', 4045, 'Orchidée', 'QC', 'Saint-Bruno-de-Montarville');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (026, 'Charline', 'Patry', 'patry_charline@gmail.com', 5144188898, 'J3Y3V2', 4494, 'Shirley', 'QC', 'Saint-Hubert');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (027, 'Naomi', 'Simon', 'naoyolosimon@hotmail.com', 5145548766, 'J4T2J3', 3109, 'Mance', 'QC', 'Saint-Hubert');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (028, 'Jade', 'Lavigne', 'jadioselav@gmail.com', 5147762344, 'H2K3X5', 2901, 'avenue de Lorimier', 'QC', 'Montreal');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (029, 'Virginie', 'Lapointe', 'virglapointe@hotmail.com', 5147642299, 'J4K4B8', 446, 'Cartier', 'QC', 'Longueuil');
INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) Values (030, 'Lucie', 'Regard', 'regardlucie4@videotron.ca', 4509992222, 'J4R1B2', 180, 'Osborne', 'QC', 'Saint-Lambert');

--
-- INSERT INTO objet AND INSERT INTO auto (20 autos/60 objets) 
--
INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (001, 'auto', 'Une petite Smart électrique nouvelle génération!', 1, 50, 40, 001);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (001, 'Smart', 'fortwo', 'Bleu', 2016, 0, 2, NULL);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (002, 'auto', NULL, 1, 90, 7, 004);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (002, 'BMW', '335i', 'Blanc', 2009, 0, 2, 10);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (003, 'auto', NULL, 1, 45, 30, 007);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (003, 'Volkswagen', 'Golf', 'Noir', 2004, 1, 4, 10);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (004, 'auto', NULL, 1, 55, 30, 010);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (004, 'Mazda', 'MAZDA6', 'Rouge', 2015, 0, 4, 8);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (005, 'auto', NULL, 1, 70, 14, 013);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (005, 'Jeep', 'Grand Cherokee SRT', 'Gris', 2014, 0, 4, 14);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (006, 'auto', NULL, 1, 40, 60, 016);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (006, 'Nissan', '350Z', 'Gris', 2008, 0, 2, 11);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (007, 'auto', 'Expérience de conduite exeptionnelle garantie', 1, 40, 14, 019);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (007, 'Nissan', 'Figaro', 'Vert', 1991, 1, 2, NULL);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (008, 'auto', NULL, 1, 55, 30, 022);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (008, 'Jeep', 'Renegade', 'Bleu', 2015, 0, 4, NULL);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (009, 'auto', 'Auto décapotable', 1, 33, 60, 025);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (009, 'Volkswagen', 'Cabrio', 'Jaune', 1998, 0, 2, NULL);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (010, 'auto', NULL, 1, 42, 90, 028);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (010, 'Volkswagen', 'Jetta', 'Noir', 2014, 0, 4, 7);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (011, 'auto', NULL, 1, 52, 30, 002);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (011, 'Mazda', 'MAZDA5', 'Gris', 2012, 0, 4, 8);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (012, 'auto', NULL, 1, 68, 20, 005);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (012, 'Fiat', '500X', 'Rouge', 2016, 0, 4, NULL);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (013, 'auto', NULL, 1, 70, 14, 008);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (013, 'Fiat', '500X', 'Gris', 2016, 0, 4, NULL);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (014, 'auto', NULL, 1, 45, 50, 011);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (014, 'Toyota', 'Matrix', 'Noir', 2013, 0, 4, 7);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (015, 'auto', NULL, 1, 40, 60, 014);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (015, 'Toyota', 'Echo', 'Bleu', 2005, 0, 2, NULL);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (016, 'auto', NULL, 1, 58, 30, 017);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (016, 'Kia', 'Forte5', 'Blanc', 2014, 0, 4, 7);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (017, 'auto', NULL, 1, 67, 14, 020);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (017, 'Kia', 'Forte5', 'Blanc', 2017, 0, 4, NULL);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (018, 'auto', NULL, 1, 55, 30, 023);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (018, 'Mazda', 'MAZDA5', 'Gris', 2016, 0, 4, 9);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (019, 'auto', NULL, 1, 45, 40, 026);
INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) Values (019, 'Mazda', 'MAZDA5', 'Noir', 2012, 0, 4, 7);

--
-- INSERT INTO objet AND INSERT INTO velo (20 velos/60 objets) 
--
INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (020, 'velo', NULL, 1, 20, 30, 002);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (020, 'Route', 'DCO', 'CRONO C', 'Aluminium', 'Étrier mécanique','700x23c', 2016, 2);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (021, 'velo', NULL, 1, 30, 30, 005);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (021, 'Route', 'Specialized', 'DOLCE', 'Aluminium', 'Étrier mécanique', NULL, 2015, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (022, 'velo', 'Les composantes Shimano Sora assemblées sur ce cadre en alliage monté sur fourche en carbone offrent une performance routière surprenante.', 1, 25, 20, 008);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (022, 'Route', 'DCO','CRONO S', 'Aluminium', 'Étrier mécanique', '700x23c', 2016, 2);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (023, 'velo', 'Le Dolce est spécialement conçu pour vous emmener loin, physiquement et géographiquement, et dans les meilleures conditions.', 1, 30, 60, 011);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (023, 'Route', 'Specialized', 'DOLCE', 'Aluminium', 'Étrier mécanique', NULL, 2017, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (024, 'velo', NULL, 1, 40, 30, 014);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (024, 'Route', 'Specialized', 'DOLCE SPORT', 'Aluminium', 'Étrier mécanique', NULL, 2017, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (025, 'velo', NULL, 1, 20, 60, 017);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (025, 'Montagne', 'Specialized', 'MYKA V 650B', 'Aluminium', 'V-Brake', '650b', 2016, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (026, 'velo', NULL, 1, 15, 40, 020);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (026, 'Montagne', 'DCO', 'REALFAT 20"', 'Aluminium', 'Disque mécanique', NULL, 2017, 2);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (027, 'velo', NULL, 1, 22, 90, 023);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (027, 'Montagne', 'Specialized', 'HARDROCK DISC 650B', 'Aluminium', 'Disque mécanique', '650b', 2017, 2);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (028, 'velo', 'Classe, raffinement et bien sûr légèreté, le vélo Élégance 701 est le vélo hybride confort par excellence.', 1, 15, 90, 026);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (028, 'Urbain', 'DCO', 'ELEGANCE 701', 'Aluminium', 'V-Brake', NULL, 2016, 2);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (029, 'velo', NULL, 1, 20, 60, 029);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (029, 'Urbain', 'Specialized', 'SIRRUS', 'Aluminium', 'V-Brake', '700x32c', 2016, 0);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (030, 'velo', 'Le VFR est un vélo confortable destiné au cycliste en bonne forme qui désire se rendre à destination rapidement.', 1, 22, 20, 003);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (030, 'Urbain', 'Norco', 'VFR 6','Aluminium', 'V-Brake', '700c', 2017, 0);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (031, 'velo', 'Vélo à une vitesse.', 1, 16, 120, 006);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (031, 'Urbain', 'Damco', NULL, 'Acier', NULL, '700', NULL, NULL);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (032, 'velo', NULL, 1, 10, 120, 009);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (032, 'Route', 'Marinoni', NULL, 'Carbone', NULL, NULL, NULL, NULL);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (033, 'velo', 'Vélo de triathlon en excellente condition.', 1, 40, 14, 012);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (033, 'Route', 'Dedacciai', 'Strada Chrono', 'Carbone', NULL, NULL, 2013, 2);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (034, 'velo', NULL, 1, 40, 20, 015);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (034, 'Route', 'Specialized', 'SHIV ELITE 105', 'Carbone', 'Étrier mécanique', NULL, 2016, 2);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (035, 'velo', NULL, 1, 12, 120, 018);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (035, 'Route', 'Free spirit', NULL, NULL, NULL, NULL, 2013, 2);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (036, 'velo', NULL, 1, 15, 60, 021);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (036, 'Route', 'Louis Garneau', 'AXIS 1-0', NULL, NULL, NULL, 2014, 0);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (037, 'velo', 'Vélo Urbain Fixie SingleSpeed cadre Large 20" en excellente condition.', 1, 22, 50, 024);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (037, 'Urbain', NULL, NULL, NULL, 'V-Brake', NULL, 2014, 0);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (038, 'velo', NULL, 1, 10, 120, 027);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (038, 'Urbain', 'Louis Garneau', NULL, NULL, NULL, NULL, 2012, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (039, 'velo', 'Velo de stype BMX, parfait pour les sauts de terre ou le street riding.', 1, 20, 30, 030);
INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) Values (039, 'BMX', 'DCO', 'PHANTOM', 'Acier', 'U-Brake', NULL, 2015, 2);

--
-- INSERT INTO objet AND INSERT INTO maison (20 maisons/60 objets) 
--
INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (040, 'maison', NULL, 1, 40, 60, 003);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (040, 1995, 2000, 2, 3, 2, 1, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (041, 'maison', NULL, 1, 35, 30, 006);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (041, 2010, 1100, 1, 2, 1, 1, 2);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (042, 'maison', 'chaleureuse maison à louer', 1, 70, 7, 009);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (042, NULL, 3200, 3, 3, 2, 1, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (043, 'maison',NULL, 1, 35, 120, 012);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (043, NULL, 3000, 3, 4, 3, 1, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (044, 'maison',NULL, 1, 45, 60, 015);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (044, NULL, 1000, 1, 2, 1, 1, 0);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (045, 'maison',NULL, 1, 30, 365, 018);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (045, NULL, 1500, 2, 3, 1, 0, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (046, 'maison', NULL, 1, 50, 14, 021);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (046, NULL, 3300, 3, 2, 2, 1, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (047, 'maison', NULL, 1, 45, 14, 024);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (047, NULL, 3500, 3, 3, 3, 1, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (048, 'maison',NULL, 1, 35, 60, 027);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (048, NULL, 1200, 1, 2, 1, 0, 0);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (049, 'maison',NULL, 1, 30, 120, 030);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (049, NULL, 1100, 1, 1, 1, 0, 0);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (050, 'maison',NULL, 1, 60, 7, 001);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (050, NULL, 4100, 4, 4, 3, 1, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (051, 'maison',NULL, 1, 70, 7, 004);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (051, NULL, 3100, 3, 2, 3, 1, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (052, 'maison',NULL, 1, 42, 30, 007);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (052, NULL, 2200, 2, 2, 1, 1, 0);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (053, 'maison',NULL, 1, 45, 20, 010);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (053, NULL, 2500, 2, 2, 1, 1, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (054, 'maison',NULL, 1, 62, 14, 013);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (054, NULL, 3700, 4, 5, 4, 1, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (055, 'maison',NULL, 1, 42, 60, 016);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (055, NULL, 1000, 1, 3, 1, 0, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (056, 'maison',NULL, 1, 38, 120, 019);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (056, NULL, 1200, 1, 4, 2, 1, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (057, 'maison',NULL, 1, 42, 60, 019);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (057, NULL, 1750, 2, 4, 2, 1, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (058, 'maison',NULL, 1, 55, 14, 022);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (058, NULL, 2700, 3, 4, 3, 1, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (059, 'maison',NULL, 1, 70, 7, 025);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (059, NULL, 4500, 4, 5, 4, 1, 1);

INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values (060, 'maison',NULL, 1, 48, 20, 028);
INSERT INTO maison (objet_id, annee, superficie, etage, chambre, salle_bain, meuble, stationnement) Values (060, NULL, 2000, 2, 4, 2, 1, 0);

INSERT INTO emprunte(user_id, objet_id, duree, date_in, date_out) Values (011, 021, 14, TO_DATE('01/04/2017', 'DD/MM/YYYY'), TO_DATE('15/04/2017', 'DD/MM/YYYY'));
INSERT INTO emprunte(user_id, objet_id, duree, date_in, date_out) Values (022, 001, 10, TO_DATE('06/05/2017', 'DD/MM/YYYY'), NULL);

INSERT INTO interet(user_id, objet_id) Values (025, 001);
INSERT INTO interet(user_id, objet_id) Values (009, 040);
INSERT INTO interet(user_id, objet_id) Values (017, 040);
INSERT INTO interet(user_id, objet_id) Values (009, 002);
