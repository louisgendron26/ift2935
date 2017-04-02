Voici les command line utilisee pour implanter la base de donnees sur ma session d'oracle


create table ishare_user (
USER_ID NUMBER not null,
PRENOM VARCHAR2(20) not null,
NOM VARCHAR2(20) not null,
COURRIEL VARCHAR2(40) not null,
NUMTEL NUMBER not null,
CODE_POSTAL VARCHAR2(10) not null,
NUMERO NUMBER,
RUE VARCHAR2(20),
PROVINCE VARCHAR2(4),
VILLE VARCHAR2(20));

#de memoire j'avais utiliser le terme PK_USER_ID
ALTER TABLE ishare_user ADD CONSTRAINT PK_USER_ID PRIMARY KEY(USER_ID);


create table objet (
  OBJET_ID NUMBER not null,
  DESCRIPTION VARCHAR2(150),
  DISPONIBLE NUMBER not null,
  PRIX NUMBER not null,
  DUREE_PARTAGE NUMBER not null,
  PROPRIETAIRE NUMBER not null);

ALTER TABLE objet ADD CONSTRAINT PK_OBJET PRIMARY KEY (OBJET_ID)
ALTER TABLE objet ADD CONSTRAINT FK_PROPRIETAIRE FOREIGN KEY (PROPRIETAIRE) REFERENCES ishare_user(user_id);

#Devrais-on utiliser le format 'date' de SQL pour faire nos date de in et out ??
create table emprunte(
  emprunt_user_id NUMBER not null,
  objet_id number not null,
  jour_in number,
  mois_in number,
  annee_in number,
  jour_out number,
  mois_out number,
  annee_out number);

ALTER TABLE emprunte ADD CONSTRAINT FK_EMPRUNT_USER_ID FOREIGN KEY (emprunt_user_id) REFERENCES ishare_user(user_id);
ALTER TABLE emprunte ADD CONSTRAINT FK_OBJET_ID FOREIGN KEY (objet_id) REFERENCES objet(objet_id);
