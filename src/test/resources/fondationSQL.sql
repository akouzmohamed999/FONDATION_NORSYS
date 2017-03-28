


DROP TABLE IF EXISTS COLLABORATEUR;

CREATE TABLE COLLABORATEUR (
  TYPE_COLLABORATEUR varchar(31) NOT NULL,
  ID_COLLABORATEUR int(11) NOT NULL AUTO_INCREMENT,
  CIN varchar(255) DEFAULT NULL,
  ADRESSE varchar(255) DEFAULT NULL,
  DATE_NAISSANCE date DEFAULT NULL,
  EMAIL varchar(255) DEFAULT NULL,
  LIEU_NAISSANCE varchar(255) DEFAULT NULL,
  NOM varchar(255) DEFAULT NULL,
  NUMERO_TELEPHONE varchar(255) DEFAULT NULL,
  PRENOM varchar(255) DEFAULT NULL,
  PRIMARY KEY (ID_COLLABORATEUR)
);


DROP TABLE IF EXISTS PORTEUR_PROJET;

CREATE TABLE PORTEUR_PROJET (
  ID_PORTEUR int(11) NOT NULL AUTO_INCREMENT,
  EMAIL varchar(255) DEFAULT NULL,
  NOM varchar(255) DEFAULT NULL,
  NUMERO_TELEPHONE varchar(255) DEFAULT NULL,
  PRENOM varchar(255) DEFAULT NULL,
  PRIMARY KEY (ID_PORTEUR)
);


DROP TABLE IF EXISTS PROPOSITION;

CREATE TABLE PROPOSITION (
  ID_PROPOSITION int(11) NOT NULL AUTO_INCREMENT,
  BUDGET_PREVISIONNEL varchar(255) DEFAULT NULL,
  DATE_PREVISION date DEFAULT NULL,
  DUREE_ACTION varchar(255) DEFAULT NULL,
  OBJECTIF varchar(255) DEFAULT NULL,
  POPULATION_CIBLE varchar(255) DEFAULT NULL,
  THEMATIQUE varchar(255) DEFAULT NULL,
  TYPE_ACTION varchar(255) DEFAULT NULL,
  TYPE_SOUTIEN varchar(255) DEFAULT NULL,
  ZONE_GEOGRAPHIQUE varchar(255) DEFAULT NULL,
  ID_PORTEUR_PROJET int(11) DEFAULT NULL,
  ID_PROJET int(11) DEFAULT NULL,
  PRIMARY KEY (ID_PROPOSITION),
  CONSTRAINT FKE354E2B670382C16 FOREIGN KEY (ID_PORTEUR_PROJET) REFERENCES PORTEUR_PROJET (ID_PORTEUR)
);


DROP TABLE IF EXISTS CONTACT;

CREATE TABLE CONTACT (
  ID_CONTACT int(11) NOT NULL AUTO_INCREMENT,
  CIN varchar(255) DEFAULT NULL,
  ADRESSe varchar(255) DEFAULT NULL,
  DATE_NAISSANCE date DEFAULT NULL,
  LIEU_NAISSANCE varchar(255) DEFAULT NULL,
  NOM varchar(255) DEFAULT NULL,
  NUM_TELEPHONE varchar(255) DEFAULT NULL,
  PAYS varchar(255) DEFAULT NULL,
  PRENOM varchar(255) DEFAULT NULL,
  TYPE_CONTACT varchar(255) DEFAULT NULL,
  PRIMARY KEY (ID_CONTACT)
);

DROP TABLE IF EXISTS PROJET;

CREATE TABLE PROJET (
  ID_PROJET int(11) NOT NULL AUTO_INCREMENT,
  CATEGORIE varchar(255) DEFAULT NULL,
  DATE_DEBUT date DEFAULT NULL,
  DATE_FIN date DEFAULT NULL,
  DESCRIPTION varchar(255) DEFAULT NULL,
  INTITULE varchar(255) DEFAULT NULL,
  ID_ADMINISTRATEUR int(11) DEFAULT NULL,
  ID_PROPOSITION int(11) DEFAULT NULL,
  ID_RESPONSABLE int(11) DEFAULT NULL,
  PRIMARY KEY (ID_PROJET),
  CONSTRAINT FK8D2C40CC1296B13 FOREIGN KEY (ID_RESPONSABLE) REFERENCES COLLABORATEUR (ID_COLLABORATEUR),
  CONSTRAINT FK8D2C40CC31F655B9 FOREIGN KEY (ID_ADMINISTRATEUR) REFERENCES COLLABORATEUR (ID_COLLABORATEUR),
  CONSTRAINT FK8D2C40CCEAF0C0C3 FOREIGN KEY (ID_PROPOSITION) REFERENCES PROPOSITION (ID_PROPOSITION)
);

DROP TABLE IF EXISTS ACTIVITE;

CREATE TABLE ACTIVITE (
  ID_ACTIVITE int(11) NOT NULL AUTO_INCREMENT,
  DATE_ACTIVITE date DEFAULT NULL,
  DUREE_ACTIVITE varchar(255) DEFAULT NULL,
  ETAT varchar(255) DEFAULT NULL,
  INTITULE varchar(255) DEFAULT NULL,
  LIEU varchar(255) DEFAULT NULL,
  ID_GERANT int(11) DEFAULT NULL,
  ID_PROJET int(11) DEFAULT NULL,
  PRIMARY KEY (ID_ACTIVITE),
  CONSTRAINT FKCBF1E2FB7282A421 FOREIGN KEY (ID_PROJET) REFERENCES PROJET (ID_PROJET),
  CONSTRAINT FKCBF1E2FB94D1731 FOREIGN KEY (ID_GERANT) REFERENCES COLLABORATEUR (ID_COLLABORATEUR)
);


DROP TABLE IF EXISTS COLLABORATEUR_ACTIVITE;

CREATE TABLE COLLABORATEUR_ACTIVITE (
  ID_ACTIVITE int(11) NOT NULL,
  ID_COLLABORATEUR int(11) NOT NULL,
  CONSTRAINT FK33F1FB5B8E0F723F FOREIGN KEY (ID_ACTIVITE) REFERENCES ACTIVITE (ID_ACTIVITE),
  CONSTRAINT FK33F1FB5BDA599155 FOREIGN KEY (ID_COLLABORATEUR) REFERENCES COLLABORATEUR (ID_COLLABORATEUR)
); 

DROP TABLE IF EXISTS CONATCT_ACTIVITE;
CREATE TABLE CONATCT_ACTIVITE (
  activites_ID_ACTIVITE int(11) NOT NULL,
  contatcs_ID_CONTACT int(11) NOT NULL,
  CONSTRAINT FK9C502ED43F79B958 FOREIGN KEY (activites_ID_ACTIVITE) REFERENCES ACTIVITE (ID_ACTIVITE),
  CONSTRAINT FK9C502ED46E541741 FOREIGN KEY (contatcs_ID_CONTACT) REFERENCES CONTACT (ID_CONTACT)
);










