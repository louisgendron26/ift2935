--
-- REQUÊTES 
--

-- 1. Recherche de tous les ID des objets (objet_id) ou de toutes les infos des objets (*)
----- a) selon le type
SELECT objet_id FROM objet WHERE type = 'velo';
SELECT objet_id FROM velo;
SELECT * FROM objet WHERE type = 'velo';
SELECT * FROM velo;

----- b) selon la disponibilité (et le type)
SELECT objet_id FROM objet WHERE disponible = '1';
SELECT * FROM objet WHERE disponible = '1';
SELECT objet_id FROM objet WHERE (disponible = '1' AND type = 'velo');

----- c) selon un interval de prix (et le type)
SELECT objet_id FROM objet WHERE (prix BETWEEN 0 AND 500);
SELECT objet_id FROM objet WHERE (prix BETWEEN 0 AND 500 AND type = 'velo');

----- d) selon la proximité entre le owner de l'objet et un utilisateur

----- e) selon la proximité entre le owner de l'objet et un code postal rentré par l'utilisateur


-- 2. Ajout/Mise à jour de la base de donnée
----- a) ajout d'un objet d'un certain type à partager par un utilisateur (owner_id)
INSERT INTO objet (objet_id, type, description, disponible, prix, duree_partage, owner_id) Values (002, 'auto', NULL, 1, 250, 14, 004);
SELECT 
INSERT INTO auto (objet_id, annee, marque, km, transmission_manuel, format, consommation) Values (002, 2009, 'BMW', NULL, 0, NULL, NULL);

----- b) modifier un attribut (ex: disponibilite, duree_partage) d'un objet (objet_id) 
UPDATE objet SET disponible = '0' WHERE objet_id = '001';
UPDATE objet SET duree_partage = '20' WHERE objet_id = '021';




-- 3. Modification apportée lorsqu'un utilisateur (user_id) 
----- a) est interessé à un objet (objet_id) 
INSERT INTO interet(user_id, objet_id) Values (009, 040);

----- b) n'est plus interessé à un objet (objet_id)
DELETE FROM interet WHERE (user_id = '009' AND objet_id = '040');

----- c) emprunte un objet (objet_id) une certaine date (date_in)
INSERT INTO emprunte(user_id, objet_id, date_in, date_out) Values (014, 020, TO_DATE('06/05/2017', 'DD/MM/YYYY'), NULL);
UPDATE objet SET disponible = '0' WHERE objet_id = '020';

----- d) retourne un objet (objet_id) une certaine date (date_out)
UPDATE emprunte SET date_out = TO_DATE('06/06/2017', 'DD/MM/YYYY') WHERE (user_id = '014' AND objet_id = '020');



-- 4. Informations sur l'utilisation 
----- a) connaître les utilisateurs (user_id) (et leurs informations personnels) qui sont intérerssés par un objet (id_objet)
SELECT user_id FROM interet WHERE objet_id = '040';
SELECT i.user_id, u.nom, u.prenom, u.numtel, u.courriel FROM interet i, ishare_user u WHERE (i.objet_id = '040' AND i.user_id = u.user_id);

----- b) connaître tous les utilisateurs (user_id, nom, prenom) qui ont emprunté un objet (id_objet)
SELECT e.user_id, u.nom, u.prenom FROM emprunte e, ishare_user u WHERE (e.objet_id = '021' AND e.user_id = u.user_id);

---- c) connaître tous les objets (objet_id et autres infos) partagés par un utilisateur (owner_id)
SELECT objet_id FROM objet WHERE owner_id = '008';
SELECT o.* FROM objet o, o.type WHERE o.owner_id = '008';


-- 5. Toutes les infos sur :
----- a) l'utilisateur sachant son id (user_id):
SELECT * FROM ishare_user WHERE user_id = 'user_id';

----- b) l'objet sachant son id (objet_id):
SELECT * FROM objet WHERE objet_id = 'objet_id';

-- 6. AUTRES :
----- a) Sachant objet_id trouver adresse du owner
SELECT b.code_postal, b.numero, b.rue, b.province, b.ville FROM objet a, ishare_user b WHERE (a.owner_id = b.user_id) AND a.objet_id = '008';

----- b) Sachant user_id trouver code postale
SELECT code_postal FROM ishare_user WHERE user_id = 'user_id';

---- c) retourne combien d'objet dans table objet et combien de user dans table ishare_user;
SELECT COUNT(objet_id) FROM objet;
SELECT COUNT(user_id) FROM ishare_user;

---- d) retourne tous infos sur l'objet dans table objet ET table spécifique au type d'objet;
TYPE = SELECT type FROM objet WHERE objet_id = '008'
RESULTAT = SELECT * FROM objet NATURAL JOIN TYPE WHERE objet_id = '008'; 
