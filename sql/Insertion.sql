--------------------------------------------------------------------------------------------------------------------------------
-------------------------------------------- insert POUR LE CSV ----------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------

------------------------ IMMEUBLE ------------------------

INSERT INTO Immeuble (Id_Immeuble, adresse, cp, ville, periode_construction, type_immeuble)
VALUES ('8', '30 Chemin de la Pelude', '31400', 'Toulouse', '1990', 'Immeuble');

----
INSERT INTO Locataire (Id_Locataire, nom, prenom, telephone, mail, date_naissance)
VALUES ('DUDU', 'DUBOIS-DUPUIS', 'Sophie', '0626843030', 'sophie.dudu@gmail.com', TO_DATE('2002-03-15', 'YYYY-MM-DD'));

INSERT INTO Bien (Id_Bien, surface_habitable, nb_pieces, num_etage, date_acquisition, Id_Immeuble, type_bien)
VALUES ('8-RC', 30.00, 1, 0, TO_DATE('2021-08-01', 'YYYY-MM-DD'), '8', 'Appartement');

INSERT INTO Louer (Id_Locataire, Id_Bien, Date_Debut, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, etat_lieux, annee, trimestre)
VALUES ('DUDU', '8-RC', TO_DATE('2021-09-01', 'YYYY-MM-DD'), 500.00, 50.00, 500.00, 'DUDU_8_RC_Bail.pdf', 'DUDU_8_RC_EtatLieu.pdf',  '2023', '4');

----
INSERT INTO Locataire (Id_Locataire, nom, prenom, telephone, mail, date_naissance)
VALUES ('DULA', 'Durand', 'Lucie Amélie', '0726403947', 'lucie.amelie@gmail.com', TO_DATE('1997-03-15', 'YYYY-MM-DD'));

INSERT INTO Bien (Id_Bien, surface_habitable, nb_pieces, num_etage, date_acquisition, Id_Immeuble, type_bien)
VALUES ('8-1er', 60.00, 2, 1, TO_DATE('2021-12-20', 'YYYY-MM-DD'), '8', 'Appartement');

INSERT INTO Louer (Id_Locataire, Id_Bien, Date_Debut, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, etat_lieux, annee, trimestre)
VALUES ('DULA', '8-1er', TO_DATE('2022-01-01', 'YYYY-MM-DD'), 1000.00, 40.00, 1000.00, 'DULA_8_1er_Bail.pdf', 'DUDU_8_1er_EtatLieu.pdf',  '2023', '4');

------------------------ IMMEUBLE ------------------------

INSERT INTO Immeuble (Id_Immeuble, adresse, cp, ville, periode_construction, type_immeuble)
VALUES ('9', '28 Rue Joly', '31400', 'Toulouse', '1890', 'Immeuble');

----
INSERT INTO Locataire (Id_Locataire, nom, prenom, telephone, mail, date_naissance)
VALUES ('DUBO', 'Duval', 'Boris', '0735260949', 'duval.boris@gmail.com', TO_DATE('1988-07-20', 'YYYY-MM-DD'));

INSERT INTO Bien (Id_Bien, surface_habitable, nb_pieces, num_etage, date_acquisition, Id_Immeuble, type_bien)
VALUES ('9-RC-D', 30.00, 2, 0, TO_DATE('2022-05-01', 'YYYY-MM-DD'), '9', 'Appartement');

INSERT INTO Louer (Id_Locataire, Id_Bien, Date_Debut, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, etat_lieux, annee, trimestre)
VALUES ('DUBO', '9-RC-D', TO_DATE('2022-06-01', 'YYYY-MM-DD'), 450.00, 20.00, 450.00, 'DUBO_9-RC-D_Bail.pdf', 'DUBO_9-RC-D_EtatLieu.pdf',  '2023', '4');

----

INSERT INTO Locataire (Id_Locataire, nom, prenom, telephone, mail, date_naissance)
VALUES ('LETE', 'Leroux', 'Thérèse', '0610023648', 'leroux.th@gmail.com', TO_DATE('1969-02-12', 'YYYY-MM-DD'));

INSERT INTO Louer (Id_Locataire, Id_Bien, Date_Debut, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, etat_lieux, annee, trimestre)
VALUES ('LETE', '9-RC-D', TO_DATE('2021-09-01', 'YYYY-MM-DD'), 400.00, 25.00, 400.00, 'LETE_9-RC-D_Bail.pdf', 'LETE_9-RC-D_EtatLieu.pdf',  '2023', '4');

----
INSERT INTO Locataire (Id_Locataire, nom, prenom, telephone, mail, date_naissance)
VALUES ('MART', 'Martin', 'Theo', '0615253647', 'martin.th@gmail.com', TO_DATE('1980-10-19', 'YYYY-MM-DD'));

INSERT INTO Bien (Id_Bien, surface_habitable, nb_pieces, num_etage, date_acquisition, Id_Immeuble, type_bien)
VALUES ('9-RC-G', 35.00, 2, 1, TO_DATE('2021-08-31', 'YYYY-MM-DD'), '9', 'Appartement');

INSERT INTO Louer (Id_Locataire, Id_Bien, Date_Debut, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, etat_lieux, annee, trimestre)
VALUES ('MART', '9-RC-G', TO_DATE('2021-09-01', 'YYYY-MM-DD'), 400.00, 20.00, 400.00, 'MART_9-RC-G_Bail.pdf', 'MART_9-RC-G_EtatLieu.pdf',  '2023', '4');

----
INSERT INTO Locataire (Id_Locataire, nom, prenom, telephone, mail, date_naissance)
VALUES ('DUVE', 'Duchamp', 'Véronique', '0615253647', 'duchamp.ver@gmail.com', TO_DATE('1998-12-12', 'YYYY-MM-DD'));

INSERT INTO Bien (Id_Bien, surface_habitable, nb_pieces, num_etage, date_acquisition, Id_Immeuble, type_bien)
VALUES ('9-1er-D', 40.00, 2, 1, TO_DATE('2021-08-31', 'YYYY-MM-DD'), '9', 'Appartement');

INSERT INTO Louer (Id_Locataire, Id_Bien, Date_Debut, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, etat_lieux, annee, trimestre)
VALUES ('DUVE', '9-1er-D', TO_DATE('2021-09-01', 'YYYY-MM-DD'), 460.00, 30.00, 460.00, 'DUVE_9-1er-D_Bail.pdf', 'DUVE_9-1er-D_EtatLieu.pdf',  '2023', '4');

----
INSERT INTO Locataire (Id_Locataire, nom, prenom, telephone, mail, date_naissance)
VALUES ('DUPA', 'Dumas', 'Pauline-Alice', '0614523648', 'dumas.pauline@gmail.com', TO_DATE('2000-02-12', 'YYYY-MM-DD'));

INSERT INTO Bien (Id_Bien, surface_habitable, nb_pieces, num_etage, date_acquisition, Id_Immeuble, type_bien)
VALUES ('9-1er-G', 42.00, 2, 1, TO_DATE('2021-08-15', 'YYYY-MM-DD'), '9', 'Appartement');

INSERT INTO Louer (Id_Locataire, Id_Bien, Date_Debut, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, etat_lieux, annee, trimestre)
VALUES ('DUPA', '9-1er-G', TO_DATE('2021-09-01', 'YYYY-MM-DD'), 480.00, 35.00, 480.00, 'DUPA_9-1er-G_Bail.pdf', 'DUPA_9-1er-G_EtatLieu.pdf',  '2023', '4');


------------------------ IMMEUBLE ------------------------

INSERT INTO Immeuble (Id_Immeuble, adresse, cp, ville, periode_construction, type_immeuble)
VALUES ('BA', '32 Rue Lucien Cassagne', '31500', 'Toulouse', '1890', 'Immeuble');

----
INSERT INTO Locataire (Id_Locataire, nom, prenom, telephone, mail, date_naissance)
VALUES ('DELA', 'Delacroix', 'Delacroix', '0735260949', 'Delacroix.Delacroix@gmail.com', TO_DATE('2001-11-23', 'YYYY-MM-DD'));

INSERT INTO Bien (Id_Bien, surface_habitable, nb_pieces, num_etage, date_acquisition, Id_Immeuble, type_bien)
VALUES ('BA3', 30.00, 2, 0, TO_DATE('2021-07-30', 'YYYY-MM-DD'), 'BA', 'Appartement');

INSERT INTO Louer (Id_Locataire, Id_Bien, Date_Debut, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, etat_lieux, annee, trimestre)
VALUES ('DELA', 'BA3', TO_DATE('2021-09-01', 'YYYY-MM-DD'), 1100.00, 70.00, 1100.00, 'DELA_BA3_Bail.pdf', 'DELA_BA3_EtatLieu.pdf',  '2023', '4');



--------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------ Jeu de données ----------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------



----------------------- LOCATAIRE -----------------------

-- Maisons
INSERT INTO Locataire (Id_Locataire, nom, prenom, telephone, mail, date_naissance)
VALUES ('Dupont_Jean', 'Dupont', 'Jean', '0765716385', 'jean.dupont@mail.com', TO_DATE('1980-03-15', 'YYYY-MM-DD'));

INSERT INTO Locataire (Id_Locataire, nom, prenom, telephone, mail, date_naissance)
VALUES ('Tremblay_Marie', 'Tremblay', 'Marie', '0690576184', 'marie.tremblay@mail.com', TO_DATE('1995-07-20', 'YYYY-MM-DD'));

INSERT INTO Locataire (Id_Locataire, nom, prenom, telephone, mail, date_naissance)
VALUES ('Larouche_Sophie', 'Larouche', 'Sophie', '0665576143', 'sophie.larouche@mail.com', TO_DATE('2002-11-02', 'YYYY-MM-DD'));

-- Appartement & garage
INSERT INTO Locataire (Id_Locataire, nom, prenom, telephone, mail, date_naissance)
VALUES ('Gagnon_Lucie', 'Gagnon', 'Lucie', '0680232502', 'lucie.gagnon@mail.com', TO_DATE('2000-01-10', 'YYYY-MM-DD'));

-- Appartement seul
INSERT INTO Locataire (Id_Locataire, nom, prenom, telephone, mail, date_naissance)
VALUES ('Roy_Anthony', 'Roy', 'Anthony', '0765809030', 'anthony.roy@mail.com', TO_DATE('1992-05-08', 'YYYY-MM-DD'));

-- Appartements & garages
INSERT INTO Locataire (Id_Locataire, nom, prenom, telephone, mail, date_naissance)
VALUES ('Leclerc_Michelle', 'Leclerc', 'Michelle', '0654676789', 'michelle.leclerc@mail.com', TO_DATE('2004-12-30', 'YYYY-MM-DD'));

INSERT INTO Locataire (Id_Locataire, nom, prenom, telephone, mail, date_naissance)
VALUES ('Bertrand_David', 'Bertrand', 'David', '0670899031', 'david.bertrand@mail.com', TO_DATE('1975-08-25', 'YYYY-MM-DD'));

------------------------ IMMEUBLE ------------------------

-- Maisons
INSERT INTO Immeuble (Id_Immeuble, adresse, cp, ville, periode_construction, type_immeuble)
VALUES ('Capitole_1', '1 Place du Capitole', '31000', 'Toulouse', '1670', 'Maison');

INSERT INTO Immeuble (Id_Immeuble, adresse, cp, ville, periode_construction, type_immeuble)
VALUES ('Saint_Sernin_15', '15 Rue Saint-Sernin', '31000', 'Toulouse', '1750',  'Maison');

INSERT INTO Immeuble (Id_Immeuble, adresse, cp, ville, periode_construction, type_immeuble)
VALUES ('Saint_Michel_10', '10 Place Saint-Michel', '31000', 'Toulouse', '1480', 'Maison');


-- Appartements et garages
INSERT INTO Immeuble (Id_Immeuble, adresse, cp, ville, periode_construction,  type_immeuble)
VALUES ('Compans_Caffarelli_8', '8 Boulevard Lascrosses', '31000', 'Toulouse', '1985', 'Immeuble');

INSERT INTO Immeuble (Id_Immeuble, adresse, cp, ville, periode_construction, type_immeuble)
VALUES ('Jean_Jaurès_22', '22 Avenue Jean Jaurès', '31000', 'Toulouse', '1925', 'Immeuble');

INSERT INTO Immeuble (Id_Immeuble, adresse, cp, ville, periode_construction, type_immeuble)
VALUES ('Carmes_12', '12 Rue des Carmes', '31000', 'Toulouse', '1750',  'Immeuble');


----------------------- ENTREPRISE -------------------------

-- assurance des maisons
INSERT INTO Entreprise (SIRET, nom, adresse, cp, ville, mail, telephone, IBAN)
VALUES ('00000000000001', 'Assurance Maisons', '123 Rue de la République', '31000', 'Toulouse', 'contact@entrepriseA.com', '0765716385', 'FR7612345678901234567890123');

-- assurance des appartements
INSERT INTO Entreprise (SIRET, nom, adresse, cp, ville, mail, telephone, IBAN)
VALUES ('00000000000002', 'Assurance Appartements', '456 Avenue des Lilas', '31000', 'Toulouse', 'info@entrepriseB.com', '0765716465', 'FR78909876543210987654321098');

-- travaux 
INSERT INTO Entreprise (SIRET, nom, adresse, cp, ville, mail, telephone, IBAN)
VALUES ('00000000000003', 'travPlomberie', '789 Boulevard du Commerce', '31000', 'Toulouse', 'support@entrepriseC.com', '0665716389', 'FR67845678901234567890123456');

INSERT INTO Entreprise (SIRET, nom, adresse, cp, ville, mail, telephone, IBAN)
VALUES ('00000000000004', 'travPeinture', '567 Place de la Liberté', '31000', 'Toulouse', 'info@entrepriseD.com', '0764016311', 'FR56723456789012345678901234');

INSERT INTO Entreprise (SIRET, nom, adresse, cp, ville, mail, telephone, IBAN)
VALUES ('00000000000005', 'travAscenceur', '890 Rue de la Paix', '31000', 'Toulouse', 'contact@entrepriseE.com', '0665777785', 'FR45678901234567890123456789');

INSERT INTO Entreprise (SIRET, nom, adresse, cp, ville, mail, telephone, IBAN)
VALUES ('00000000000006', 'travElectricité', '123 Avenue des Arts', '31000', 'Toulouse', 'info@entrepriseF.com', '0765711111', 'FR12345678901234567890123456');

-- charge eau
INSERT INTO Entreprise (SIRET, nom, adresse, cp, ville, mail, telephone, IBAN)
VALUES ('00000000000007', 'Eau', '456 Boulevard des Sciences', '31000', 'Toulouse', 'support@entrepriseG.com', '0760016320', 'FR23456789012345678901234567');

-- charge electricité parties communes
INSERT INTO Entreprise (SIRET, nom, adresse, cp, ville, mail, telephone, IBAN)
VALUES ('00000000000008', 'Elec', '789 Place des Technologies', '31000', 'Toulouse', 'contact@entrepriseH.com', '0660016110', 'FR56789012345678901234567890');

-- charge ordures ménagères
INSERT INTO Entreprise (SIRET, nom, adresse, cp, ville, mail, telephone, IBAN)
VALUES ('00000000000009', 'OrduresMénagères', '890 Rue de la Finance', '31000', 'Toulouse', 'info@entrepriseI.com', '0460011120', 'FR12 3456 7890 1234 5678 9012 34');


---------------------- ICC ----------------------------

-- 2023
INSERT INTO ICC (annee, trimestre, indice)
VALUES ('2023', '1', 105.6);

INSERT INTO ICC (annee, trimestre, indice)
VALUES ('2023', '2', 106.2);

INSERT INTO ICC (annee, trimestre, indice)
VALUES ('2023', '3', 107.0);

INSERT INTO ICC (annee, trimestre, indice)
VALUES ('2023', '4', 108.1);

-- 2022
INSERT INTO ICC (annee, trimestre, indice)
VALUES ('2022', '1', 103.5);

INSERT INTO ICC (annee, trimestre, indice)
VALUES ('2022', '2', 104.2);

INSERT INTO ICC (annee, trimestre, indice)
VALUES ('2022', '3', 105.1);

INSERT INTO ICC (annee, trimestre, indice)
VALUES ('2022', '4', 105.9);

-- 2021
INSERT INTO ICC (annee, trimestre, indice)
VALUES ('2021', '1', 100.0);

INSERT INTO ICC (annee, trimestre, indice)
VALUES ('2021', '2', 100.5);

INSERT INTO ICC (annee, trimestre, indice)
VALUES ('2021', '3', 100.7);

INSERT INTO ICC (annee, trimestre, indice)
VALUES ('2021', '4', 90.0);


------------------------ QUOTITE -------------------------

INSERT INTO Quotite (type_quotite)
VALUES ('Ordures ménagères');

INSERT INTO Quotite (type_quotite)
VALUES ('Électricité');

INSERT INTO Quotite (type_quotite)
VALUES ('Eau');

INSERT INTO Quotite (type_quotite)
VALUES ('Entretien');


---------------------- IMPOT -----------------------------

-- auto-incrémenté
--1 -- Maison B001
INSERT INTO Impot (nom, montant, annee)
VALUES ('Taxe foncière', 1400.00, 2023);

--2 -- Maison B002
INSERT INTO Impot (nom, montant, annee)
VALUES ('Taxe foncière', 1280.00, 2022);

--3 -- Maison B002
INSERT INTO Impot (nom, montant, annee)
VALUES ('Taxe foncière', 1280.00, 2023);

--4 -- Appartement B004
INSERT INTO Impot (nom, montant, annee)
VALUES ('Taxe foncière', 780.00, 2021);

--5 -- Appartement B004
INSERT INTO Impot (nom, montant, annee)
VALUES ('Taxe foncière', 780.00, 2022);

--6 -- Appartement B004
INSERT INTO Impot (nom, montant, annee)
VALUES ('Taxe foncière', 780.00, 2023);

--7 -- Appartement B005
INSERT INTO Impot (nom, montant, annee)
VALUES ('Taxe foncière', 980.00, 2023);

--8 -- Appartement B006
INSERT INTO Impot (nom, montant, annee)
VALUES ('Taxe foncière', 1580.00, 2022);

--9 -- Appartement B006
INSERT INTO Impot (nom, montant, annee)
VALUES ('Taxe foncière', 1580.00, 2023);

--10 -- Appartement B007
INSERT INTO Impot (nom, montant, annee)
VALUES ('Taxe foncière', 756.50, 2023);

--11 -- Garage B008
INSERT INTO Impot (nom, montant, annee)
VALUES ('Taxe foncière', 136.50, 2021);

--12 -- Garage B008
INSERT INTO Impot (nom, montant, annee)
VALUES ('Taxe foncière', 136.50, 2022);

--13 -- Garage B008
INSERT INTO Impot (nom, montant, annee)
VALUES ('Taxe foncière', 136.50, 2023);

--14 -- Garage B010
INSERT INTO Impot (nom, montant, annee)
VALUES ('Taxe foncière', 146.70, 2023);

--15
INSERT INTO Impot (nom, montant, annee)
VALUES ('Impôt sur le revenu', 1600.00, 2020);

--16
INSERT INTO Impot (nom, montant, annee)
VALUES ('Impôt sur le revenu', 4000.00, 2021);

--17
INSERT INTO Impot (nom, montant, annee)
VALUES ('Impôt sur le revenu', 8750.00, 2022);

--18
INSERT INTO Impot (nom, montant, annee)
VALUES ('Impôt sur le revenu', 10680.00, 2023);


-------------------------- BIEN -----------------------------

-- Maisons
INSERT INTO Bien (Id_Bien, surface_habitable, nb_pieces, num_etage, date_acquisition, Id_Immeuble, type_bien)
VALUES ('B001', 85.50, 4, 1, TO_DATE('2022-04-15', 'YYYY-MM-DD'), 'Capitole_1', 'Maison');

INSERT INTO Bien (Id_Bien, surface_habitable, nb_pieces, num_etage, date_acquisition, Id_Immeuble, type_bien)
VALUES ('B002', 70.25, 3, 1, TO_DATE('2021-11-10', 'YYYY-MM-DD'), 'Saint_Sernin_15', 'Maison');

INSERT INTO Bien (Id_Bien, surface_habitable, nb_pieces, num_etage, date_acquisition, Id_Immeuble, type_bien)
VALUES ('B003', 120.75, 5, 1, TO_DATE('2023-02-28', 'YYYY-MM-DD'), 'Saint_Michel_10', 'Maison');


-- Appartements
INSERT INTO Bien (Id_Bien, surface_habitable, nb_pieces, num_etage, date_acquisition, Id_Immeuble, type_bien)
VALUES ('B004', 60.75, 3, 1, TO_DATE('2020-09-05', 'YYYY-MM-DD'), 'Compans_Caffarelli_8', 'Appartement');

INSERT INTO Bien (Id_Bien, surface_habitable, nb_pieces, num_etage, date_acquisition, Id_Immeuble, type_bien)
VALUES ('B005', 95.00, 4, 4, TO_DATE('2022-07-22', 'YYYY-MM-DD'), 'Compans_Caffarelli_8', 'Appartement');

INSERT INTO Bien (Id_Bien, surface_habitable, nb_pieces, num_etage, date_acquisition, Id_Immeuble, type_bien)
VALUES ('B006', 110.00, 5, 2, TO_DATE('2021-03-12', 'YYYY-MM-DD'), 'Jean_Jaurès_22', 'Appartement');

INSERT INTO Bien (Id_Bien, surface_habitable, nb_pieces, num_etage, date_acquisition, Id_Immeuble, type_bien)
VALUES ('B007', 75.25, 4, 1, TO_DATE('2022-12-18', 'YYYY-MM-DD'), 'Carmes_12', 'Appartement');


-- Garages
INSERT INTO Bien (Id_Bien, surface_habitable, nb_pieces, num_etage, date_acquisition, Id_Immeuble, type_bien)
VALUES ('B008', 15.50, 1, 0, TO_DATE('2020-05-30', 'YYYY-MM-DD'), 'Compans_Caffarelli_8', 'Garage');

INSERT INTO Bien (Id_Bien, surface_habitable, nb_pieces, num_etage, date_acquisition, Id_Immeuble, type_bien)
VALUES ('B009', 13.75, 1, 0, TO_DATE('2023-08-07', 'YYYY-MM-DD'), 'Jean_Jaurès_22', 'Garage');

INSERT INTO Bien (Id_Bien, surface_habitable, nb_pieces, num_etage, date_acquisition, Id_Immeuble, type_bien)
VALUES ('B010', 14.00, 1, 0, TO_DATE('2022-01-14', 'YYYY-MM-DD'), 'Carmes_12', 'Garage');


-------------------------- ASSURANCE -----------------------

-- assurances maisons
INSERT INTO Assurance (numero_police, montant, Id_Bien, SIRET)
VALUES ('POL001', 20000.00, 'B001', '00000000000001');

INSERT INTO Assurance (numero_police, montant, Id_Bien, SIRET)
VALUES ('POL002', 18000.00, 'B002', '00000000000001');

INSERT INTO Assurance (numero_police, montant, Id_Bien, SIRET)
VALUES ('POL003', 18000.00, 'B003', '00000000000001');

-- assurances appartements
INSERT INTO Assurance (numero_police, montant, Id_Bien, SIRET)
VALUES ('POL004', 20000.00, 'B004', '00000000000002');

INSERT INTO Assurance (numero_police, montant, Id_Bien, SIRET)
VALUES ('POL005', 18000.00, 'B005', '00000000000002');

INSERT INTO Assurance (numero_police, montant, Id_Bien, SIRET)
VALUES ('POL006', 18000.00, 'B006', '00000000000002');

INSERT INTO Assurance (numero_police, montant, Id_Bien, SIRET)
VALUES ('POL007', 18000.00, 'B007', '00000000000002');

-- assurances garage
INSERT INTO Assurance (numero_police, montant, Id_Bien, SIRET)
VALUES ('POL008', 20000.00, 'B008', '00000000000002');

INSERT INTO Assurance (numero_police, montant, Id_Bien, SIRET)
VALUES ('POL009', 18000.00, 'B009', '00000000000002');

INSERT INTO Assurance (numero_police, montant, Id_Bien, SIRET)
VALUES ('POL010', 18000.00, 'B010', '00000000000002');

------------------------- ECHEANCE ---------------------------

INSERT INTO Echeance (numero_police, date_echeance)
VALUES ('POL001', TO_DATE('2024-01-15', 'YYYY-MM-DD'));

INSERT INTO Echeance (numero_police, date_echeance)
VALUES ('POL002', TO_DATE('2024-02-15', 'YYYY-MM-DD'));

INSERT INTO Echeance (numero_police, date_echeance)
VALUES ('POL003', TO_DATE('2024-03-20', 'YYYY-MM-DD'));

INSERT INTO Echeance (numero_police, date_echeance)
VALUES ('POL004', TO_DATE('2024-01-25', 'YYYY-MM-DD'));

INSERT INTO Echeance (numero_police, date_echeance)
VALUES ('POL005', TO_DATE('2024-04-15', 'YYYY-MM-DD'));

INSERT INTO Echeance (numero_police, date_echeance)
VALUES ('POL006', TO_DATE('2024-05-05', 'YYYY-MM-DD'));

INSERT INTO Echeance (numero_police, date_echeance)
VALUES ('POL007', TO_DATE('2024-03-25', 'YYYY-MM-DD'));

INSERT INTO Echeance (numero_police, date_echeance)
VALUES ('POL008', TO_DATE('2024-06-14', 'YYYY-MM-DD'));

INSERT INTO Echeance (numero_police, date_echeance)
VALUES ('POL009', TO_DATE('2024-07-16', 'YYYY-MM-DD'));

INSERT INTO Echeance (numero_police, date_echeance)
VALUES ('POL010', TO_DATE('2024-04-01', 'YYYY-MM-DD'));


------------------------ DIAGNOSTIC -------------------------

-- maisons
INSERT INTO Diagnostic (date_validite, type_diagnostic, Id_Bien)
VALUES (TO_DATE('2024-12-15', 'YYYY-MM-DD'), 'Plomberie', 'B001');

INSERT INTO Diagnostic (date_validite, type_diagnostic, Id_Bien)
VALUES (TO_DATE('2025-01-05', 'YYYY-MM-DD'), 'Énergétique', 'B001');

INSERT INTO Diagnostic (date_validite, type_diagnostic, Id_Bien)
VALUES (TO_DATE('2024-12-31', 'YYYY-MM-DD'), 'Électrique', 'B002');

INSERT INTO Diagnostic (date_validite, type_diagnostic, Id_Bien)
VALUES (TO_DATE('2024-12-15', 'YYYY-MM-DD'), 'Plomberie', 'B002');

INSERT INTO Diagnostic (date_validite, type_diagnostic, Id_Bien)
VALUES (TO_DATE('2024-02-28', 'YYYY-MM-DD'), 'Structural', 'B003');

INSERT INTO Diagnostic (date_validite, type_diagnostic, Id_Bien)
VALUES (TO_DATE('2024-03-28', 'YYYY-MM-DD'), 'Plomberie', 'B003');

-- appartements
INSERT INTO Diagnostic (date_validite, type_diagnostic, Id_Bien)
VALUES (TO_DATE('2025-01-05', 'YYYY-MM-DD'), 'Énergétique', 'B004');

INSERT INTO Diagnostic (date_validite, type_diagnostic, Id_Bien)
VALUES (TO_DATE('2024-12-31', 'YYYY-MM-DD'), 'Électrique', 'B004');

INSERT INTO Diagnostic (date_validite, type_diagnostic, Id_Bien)
VALUES (TO_DATE('2024-12-31', 'YYYY-MM-DD'), 'Électrique', 'B005');

INSERT INTO Diagnostic (date_validite, type_diagnostic, Id_Bien)
VALUES (TO_DATE('2024-11-10', 'YYYY-MM-DD'), 'Sécurité', 'B005');

INSERT INTO Diagnostic (date_validite, type_diagnostic, Id_Bien)
VALUES (TO_DATE('2024-11-10', 'YYYY-MM-DD'), 'Sécurité', 'B006');

INSERT INTO Diagnostic (date_validite, type_diagnostic, Id_Bien)
VALUES (TO_DATE('2024-02-10', 'YYYY-MM-DD'), 'Structural', 'B006');

INSERT INTO Diagnostic (date_validite, type_diagnostic, Id_Bien)
VALUES (TO_DATE('2025-10-20', 'YYYY-MM-DD'), 'Énergétique', 'B007');

INSERT INTO Diagnostic (date_validite, type_diagnostic, Id_Bien)
VALUES (TO_DATE('2025-09-30', 'YYYY-MM-DD'), 'Sécurité', 'B007');


--------------------------- FACTURE ---------------------------

-- loyers maisons
-- B001
INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement, numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_Bien, SIRET)
VALUES ('FAC001', TO_DATE('2023-10-05', 'YYYY-MM-DD'), TO_DATE('2023-10-07', 'YYYY-MM-DD'),'Virement bancaire',null, 'Loyer', 500.00, 500.00, 0, 'B001', null);

INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_Bien, SIRET)
VALUES ('FAC002', TO_DATE('2023-11-05', 'YYYY-MM-DD'), TO_DATE('2023-11-07', 'YYYY-MM-DD'),'Virement bancaire',null, 'Loyer', 500.00, 500.00, 0, 'B001', null);

-- B002
INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_Bien, SIRET)
VALUES ('FAC003', TO_DATE('2022-08-05', 'YYYY-MM-DD'), TO_DATE('2022-08-08', 'YYYY-MM-DD'),'Virement bancaire',null, 'Loyer', 500.00, 500.00, 0, 'B002', null);

INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_Bien, SIRET)
VALUES ('FAC004', TO_DATE('2022-09-07', 'YYYY-MM-DD'), TO_DATE('2022-09-07', 'YYYY-MM-DD'), 'Carte de crédit', null, 'Loyer', 400.00, 500, 0, 'B002', null);

-- B003
INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_Bien, SIRET)
VALUES ('FAC005', TO_DATE('2023-01-02', 'YYYY-MM-DD'), null, 'Chèque', null, 'Loyer', null, 600.00, 0, 'B003', null);

INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire,  Id_Bien, SIRET)
VALUES ('FAC006', TO_DATE('2023-02-02', 'YYYY-MM-DD'), TO_DATE('2023-02-05', 'YYYY-MM-DD'), 'Carte de crédit', null, 'Loyer', 600.00, 600.00, 0, 'B003', null);


-- loyers appartements
INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_Bien, SIRET)
VALUES ('FAC007', TO_DATE('2023-02-10', 'YYYY-MM-DD'), TO_DATE('2023-02-11', 'YYYY-MM-DD'), 'Virement bancaire', null, 'Loyer', 300.00, 300.00, 0, 'B004', null);

INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire,Id_Bien, SIRET)
VALUES ('FAC008', TO_DATE('2023-03-05', 'YYYY-MM-DD'), TO_DATE('2023-03-25', 'YYYY-MM-DD'), 'Carte de crédit', null, 'Loyer', 300.00, 300.00, 0, 'B004', null);

INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_Bien, SIRET)
VALUES ('FAC009', TO_DATE('2023-02-18', 'YYYY-MM-DD'), TO_DATE('2023-02-18', 'YYYY-MM-DD'), 'Virement bancaire', null, 'Loyer', 500.00, 500.00, 0, 'B005', null);

INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_Bien, SIRET)
VALUES ('FAC010', TO_DATE('2023-03-10', 'YYYY-MM-DD'), null, 'Virement bancaire', null, 'Loyer', null, 500.00, 0, 'B005', null);

INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_Bien, SIRET)
VALUES ('FAC011', TO_DATE('2022-10-01', 'YYYY-MM-DD'), TO_DATE('2022-10-20', 'YYYY-MM-DD'), 'Virement bancaire', null, 'Loyer',  650.00, 650.00, 0, 'B006', null);

INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_Bien, SIRET)
VALUES ('FAC012', TO_DATE('2022-11-01', 'YYYY-MM-DD'), TO_DATE('2022-11-20', 'YYYY-MM-DD'), 'Virement bancaire', null, 'Loyer',  650.00, 650.00, 0, 'B006', null);

INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_Bien, SIRET)
VALUES ('FAC013', TO_DATE('2023-10-01', 'YYYY-MM-DD'), TO_DATE('2023-10-04', 'YYYY-MM-DD'), 'Virement bancaire', null, 'Loyer', 700.00, 700.00, 0, 'B007', null);

INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_Bien, SIRET)
VALUES ('FAC014', TO_DATE('2023-11-01', 'YYYY-MM-DD'), TO_DATE('2023-11-10', 'YYYY-MM-DD'), 'Virement bancaire', null, 'Loyer', 650.00,700.00, 0, 'B007', null);


-- Travaux plomberie immeubles
INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_immeuble, SIRET)
VALUES ('FAC015', TO_DATE('2023-02-18', 'YYYY-MM-DD'), TO_DATE('2023-02-19', 'YYYY-MM-DD'), 'Virement bancaire', 'DEV001', 'Travaux', 1000.00, 1000.00, 0, 'Compans_Caffarelli_8', '00000000000003');

INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_immeuble, SIRET)
VALUES ('FAC016', TO_DATE('2023-02-18', 'YYYY-MM-DD'), TO_DATE('2023-02-18', 'YYYY-MM-DD'), 'Virement bancaire', 'DEV002', 'Travaux', 1100.00, 1100.00, 0, 'Jean_Jaurès_22', '00000000000003');


-- Travaux peinture appartement
INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_Bien, SIRET)
VALUES ('FAC017', TO_DATE('2023-05-08', 'YYYY-MM-DD'), TO_DATE('2023-05-09', 'YYYY-MM-DD'), 'Virement bancaire', 'DEV003', 'Travaux', 150.00, 150.00, 1,'B004', '00000000000004');

INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_Bien, SIRET)
VALUES ('FAC018', TO_DATE('2023-05-08', 'YYYY-MM-DD'), TO_DATE('2023-05-09', 'YYYY-MM-DD'), 'Virement bancaire', 'DEV004', 'Travaux', 155.00, 155.00, 1, 'B006', '00000000000004');


-- Travaux ascenceur immeuble
INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_immeuble, SIRET)
VALUES ('FAC019', TO_DATE('2023-06-08', 'YYYY-MM-DD'), TO_DATE('2023-06-10', 'YYYY-MM-DD'), 'Virement bancaire', 'DEV005', 'Travaux', 1550.00, 1550.00, 0, 'Carmes_12', '00000000000005');


-- Travaux electricité appartement
INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_Bien, SIRET)
VALUES ('FAC020', TO_DATE('2023-05-01', 'YYYY-MM-DD'), TO_DATE('2023-05-09', 'YYYY-MM-DD'), 'Virement bancaire', 'DEV006', 'Travaux', 155.00, 155.00, 1,'B007', '00000000000006');


------------------------------------------------------------------ CHARGES -----------------------------------------------------------------------

-- Charges Eau
INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_immeuble, Id_Bien, SIRET)
VALUES ('FAC021', TO_DATE('2023-02-18', 'YYYY-MM-DD'), TO_DATE('2023-03-10', 'YYYY-MM-DD'), 'Virement bancaire', 'DEV07', 'Eau', 25.00, 25.00, 1, null, 'B010', '00000000000007');

INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_immeuble, Id_Bien, SIRET)
VALUES ('FAC022', TO_DATE('2023-02-18', 'YYYY-MM-DD'), TO_DATE('2023-03-10', 'YYYY-MM-DD'), 'Virement bancaire', 'DEV08', 'Eau', 25.00, 25.00, 1, null, 'B010', '00000000000007');


-- Charges Electricité parties communes
INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_immeuble, Id_Bien, SIRET)
VALUES ('FAC023', TO_DATE('2023-02-18', 'YYYY-MM-DD'), TO_DATE('2023-03-10', 'YYYY-MM-DD'), 'Virement bancaire', 'DEV09', 'Electricité', 20.00, 20.00, 1, 'Compans_Caffarelli_8',null, '00000000000008');

INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_immeuble, Id_Bien, SIRET)
VALUES ('FAC024', TO_DATE('2023-02-18', 'YYYY-MM-DD'), TO_DATE('2023-03-10', 'YYYY-MM-DD'), 'Virement bancaire', 'DEV010', 'Electricité', 20.00, 20.00, 1, 'Compans_Caffarelli_8',null, '00000000000008');


-- Charges Ordures ménagères
INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_immeuble, Id_Bien, SIRET)
VALUES ('FAC025', TO_DATE('2023-02-18', 'YYYY-MM-DD'), TO_DATE('2023-03-10', 'YYYY-MM-DD'), 'Virement bancaire', 'DEV011', 'Ordures ménagères', 15.00, 15.00, 1, null, 'B010', '00000000000009');

INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_immeuble, Id_Bien, SIRET)
VALUES ('FAC026', TO_DATE('2023-02-18', 'YYYY-MM-DD'), TO_DATE('2023-03-10', 'YYYY-MM-DD'), 'Virement bancaire', 'DEV012', 'Ordures ménagères', 15.00, 15.00, 1, null, 'B010', '00000000000009');


-- Loyer garage
INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_Bien, SIRET)
VALUES ('FAC027', TO_DATE('2023-02-01', 'YYYY-MM-DD'), TO_DATE('2023-02-10', 'YYYY-MM-DD'), 'Virement bancaire', null, 'Loyer', 15.00,15.00, 0,'B008', null);

INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_Bien, SIRET)
VALUES ('FAC028', TO_DATE('2023-10-01', 'YYYY-MM-DD'), TO_DATE('2023-10-10', 'YYYY-MM-DD'), 'Virement bancaire', null, 'Loyer', 15.00,15.00, 0,'B009', null);

INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement,numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_Bien, SIRET)
VALUES ('FAC029', TO_DATE('2023-10-01', 'YYYY-MM-DD'), TO_DATE('2023-10-10', 'YYYY-MM-DD'), 'Virement bancaire', null, 'Loyer', 15.00,15.00, 0,'B010', null);

-- Génération de la facture pour le compteur d'eau de la maison Capitole_1
INSERT INTO Facture (numero, date_emission, designation, montant, imputable_locataire, Id_immeuble, Id_Bien, SIRET)
VALUES ('FAC031', TO_DATE('2022-10-15', 'YYYY-MM-DD'), 'Eau', (240 - 10) * 15, 1, 'Capitole_1', NULL, NULL);

-- Génération de la facture pour le compteur d'électricité de la maison Capitole_1
INSERT INTO Facture (numero, date_emission, designation, montant, imputable_locataire, Id_immeuble, Id_Bien, SIRET)
VALUES ('FAC032', TO_DATE('2023-09-10', 'YYYY-MM-DD'), 'Électricité', (5390 - 4540) * 30, 1, 'Capitole_1', NULL, NULL);

-- Génération de la facture pour le compteur d'eau de la maison Saint_Sernin_15
INSERT INTO Facture (numero, date_emission, designation, montant, imputable_locataire, Id_immeuble, Id_Bien, SIRET)
VALUES ('FAC033', TO_DATE('2023-03-10', 'YYYY-MM-DD'), 'Eau', (340 - 110) * 20, 1, 'Saint_Sernin_15', NULL, NULL);

-- Génération de la facture pour le compteur d'électricité de la maison Saint_Sernin_15
INSERT INTO Facture (numero, date_emission, designation, montant, imputable_locataire, Id_immeuble, Id_Bien, SIRET)
VALUES ('FAC034', TO_DATE('2023-09-10', 'YYYY-MM-DD'), 'Électricité', (5390 - 4541) * 45, 1, 'Saint_Sernin_15', NULL, NULL);

-- Génération de la facture pour le compteur d'eau de la maison Saint_Michel_10
INSERT INTO Facture (numero, date_emission, designation, montant, imputable_locataire, Id_immeuble, Id_Bien, SIRET)
VALUES ('FAC035', TO_DATE('2023-03-10', 'YYYY-MM-DD'), 'Eau', (348 - 117) * 15, 1, 'Saint_Michel_10', NULL, NULL);

-- Génération de la facture pour le compteur d'électricité de la maison Saint_Michel_10
INSERT INTO Facture (numero, date_emission, designation, montant, imputable_locataire, Id_immeuble, Id_Bien, SIRET)
VALUES ('FAC036', TO_DATE('2023-09-10', 'YYYY-MM-DD'), 'Électricité', (5390 - 4541) * 30, 1, 'Saint_Michel_10', NULL, NULL);

-- Génération de la facture pour le compteur d'eau de l'immeuble Compans_Caffarelli_8
INSERT INTO Facture (numero, date_emission, designation, montant, imputable_locataire, Id_immeuble, Id_Bien, SIRET)
VALUES ('FAC037', TO_DATE('2023-03-10', 'YYYY-MM-DD'), 'Eau', (348 - 117) * 20, 1, 'Compans_Caffarelli_8', NULL, NULL);

-- Génération de la facture pour le compteur d'électricité de l'immeuble Compans_Caffarelli_8
INSERT INTO Facture (numero, date_emission, designation, montant, imputable_locataire, Id_immeuble, Id_Bien, SIRET)
VALUES ('FAC038', TO_DATE('2023-09-10', 'YYYY-MM-DD'), 'Électricité', (5390 - 4541) * 25, 1, 'Compans_Caffarelli_8', NULL, NULL);


------------------------ LOUER ------------------------------

-- maisons
INSERT INTO Louer (Id_Locataire, Id_Bien, Date_Debut, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, loyer_paye, annee, trimestre, montant_reel_paye, etat_lieux)
VALUES ('Dupont_Jean', 'B001', TO_DATE('2023-10-01', 'YYYY-MM-DD'), 500.00, 50.00, 400.00, 'Dupont_Jean_Bail.pdf', null,  '2023', '3', null, 'Dupont_Jean_etatLieu.pdf');

INSERT INTO Louer (Id_Locataire, Id_Bien, Date_Debut, nb_mois, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, date_derniere_reg, loyer_paye,  annee, trimestre, etat_lieux)
VALUES ('Tremblay_Marie', 'B002', TO_DATE('2022-08-15', 'YYYY-MM-DD'), null, 500.00, 100.00, 400.00, 'Tremblay_Marie_Bail.pdf', null, 1,  '2022', '3', 'Tremblay_Marie_etatLieu.pdf');

INSERT INTO Louer (Id_Locataire, Id_Bien, Date_Debut, nb_mois, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, date_derniere_reg, loyer_paye,  annee, trimestre, montant_reel_paye, etat_lieux)
VALUES ('Larouche_Sophie', 'B003', TO_DATE('2023-01-01', 'YYYY-MM-DD'), null, 600.00, 40.00, 500.00, 'Larouche_Sophie_Bail.pdf', null, 1,  '2023', '1', null, 'Larouche_Sophie_etatLieu.pdf');


-- appartement Compans
INSERT INTO Louer (Id_Locataire, Id_Bien, Date_Debut, nb_mois, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, date_derniere_reg, loyer_paye,  annee, trimestre, montant_reel_paye, etat_lieux)
VALUES ('Gagnon_Lucie', 'B004', TO_DATE('2023-02-10', 'YYYY-MM-DD'), null, 300.00, 20.00, 200.00, 'Gagnon_Lucie_Bail.pdf', null, 1, '2023', '1', null, 'Gagnon_Lucie_etatLieu.pdf');
-- garage Compans
INSERT INTO Louer (Id_Locataire, Id_Bien, Date_Debut, nb_mois, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, date_derniere_reg, loyer_paye,  annee, trimestre, montant_reel_paye, etat_lieux)
VALUES ('Gagnon_Lucie', 'B008', TO_DATE('2023-02-15', 'YYYY-MM-DD'), null, 15.00, 2.0, 15.00, 'Gagnon_Lucie_Bail.pdf',null, 1, '2023', '1', null, 'Gagnon_Lucie_etatLieu.pdf');

-- appartement Compans
INSERT INTO Louer (Id_Locataire, Id_Bien, Date_Debut, nb_mois, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, date_derniere_reg, loyer_paye,  annee, trimestre, montant_reel_paye, etat_lieux)
VALUES ('Roy_Anthony', 'B005', TO_DATE('2023-02-05', 'YYYY-MM-DD'), null, 500.00, 100.00, 300.00, 'Roy_Anthony_Bail.pdf', null, 1, '2023', '1', null, 'Roy_Anthony_etatLieu.pdf');

-- appartememts et garages Jean Jaures
INSERT INTO Louer (Id_Locataire, Id_Bien, Date_Debut, nb_mois, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, date_derniere_reg, loyer_paye,  annee, trimestre, montant_reel_paye, etat_lieux)
VALUES ('Leclerc_Michelle', 'B006', TO_DATE('2022-10-01', 'YYYY-MM-DD'), null, 650.00, 150.00, 200.00, 'Leclerc_Michelle_Bail.pdf', null, 1, '2022', '2', null, 'Leclerc_Michelle_etatLieu.pdf');

INSERT INTO Louer (Id_Locataire, Id_Bien, Date_Debut, nb_mois, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, date_derniere_reg, loyer_paye,  annee, trimestre, montant_reel_paye, etat_lieux)
VALUES ('Leclerc_Michelle', 'B009', TO_DATE('2022-10-20', 'YYYY-MM-DD'), null, 15.00, 3.0, 15.00, 'Leclerc_Michelle_Bail.pdf', null, 1, '2022', '2', null, 'Leclerc_Michelle_etatLieu.pdf');

-- appartememts et garages Jean Jaures
INSERT INTO Louer (Id_Locataire, Id_Bien, Date_Debut, nb_mois, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, date_derniere_reg, loyer_paye,  annee, trimestre, montant_reel_paye, etat_lieux)
VALUES ('Bertrand_David', 'B007', TO_DATE('2023-10-10', 'YYYY-MM-DD'), null, 700.00, 150.00, 750.00, 'Bertrand_David_Bail.pdf', null, 1, '2023', '2', null, 'Bertrand_David_etatLieu.pdf');

INSERT INTO Louer (Id_Locataire, Id_Bien, Date_Debut, nb_mois, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, date_derniere_reg, loyer_paye,  annee, trimestre, montant_reel_paye, etat_lieux)
VALUES ('Bertrand_David', 'B010', TO_DATE('2023-10-01', 'YYYY-MM-DD'), null, 15.00,  3.0, 15.00, 'Bertrand_David_Bail.pdf', null, 0, '2023', '2',null, 'Bertrand_David_etatLieu.pdf');


------------------------- COMPTEUR --------------------------

-- maison Capitole_1
INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('CompMaisonCapitole_Eau', 'Eau', 15, 'Capitole_1', NULL); -- compteur general Eau

INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('CompMaisonCapitole_Electr', 'Électricité', 30, 'Capitole_1', NULL); -- compteur general Électricité

INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('CompMaisonCapitole_Gaz', 'Gaz', 25, 'Capitole_1', NULL); -- compteur general Gaz

-- maison Saint_Sernin_15
INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('ComptMaisonSTSernin_Eau', 'Eau', 20, 'Saint_Sernin_15', NULL); -- compteur general Eau

INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('ComptMaisonSTSernin_El', 'Électricité', 45, 'Saint_Sernin_15', NULL); -- compteur general Électricité

-- maison Saint_Michel_10
INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('ComptMaisonSTMichel_Eau', 'Eau', 15, 'Saint_Michel_10', NULL); -- compteur general Eau

INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('ComptMaisonSTMichel_El', 'Électricité', 30, 'Saint_Michel_10', NULL); -- compteur general Électricité

INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('ComptMaisonSTMichel_Gaz', 'Gaz', 25, 'Saint_Michel_10', NULL); -- compteur general Gaz

-- immeuble Compans_Caffarelli_8
INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('ComptImmCompans_EauGeneral', 'Eau', 20, 'Compans_Caffarelli_8', NULL); -- compteur general Eau

INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('ComptImmCompans_ElGeneral', 'Électricité', 25, 'Compans_Caffarelli_8', NULL); -- compteur general Électricité

INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('ComptImmCompans_GazGeneral', 'Gaz', 25, 'Compans_Caffarelli_8', NULL); -- compteur general Gaz

-- immeuble Jean_Jaurès_22
INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('ComptImmJJaures_EauGeneral', 'Eau', 20, 'Jean_Jaurès_22', NULL); -- compteur general Eau

INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('ComptImmJJaures_ElGeneral', 'Électricité', 25, 'Jean_Jaurès_22', NULL); -- compteur general Électricité

INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('ComptImmJJaures_GazGeneral', 'Gaz', 25, 'Jean_Jaurès_22', NULL); -- compteur general Gaz

-- immeuble Carmes_12
INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('ComptImmCarmes_EauGeneral', 'Eau', 20, 'Carmes_12', NULL); -- compteur general Eau

INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('ComptImmCarmes_ElGeneral', 'Électricité', 25, 'Carmes_12', NULL); -- compteur general Électricité

-- appartement B004 : compteur d'eau et d'electricite propres au bien
INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('ComptBien4Eau', 'Eau', 10, NULL, 'B004'); -- compteur Eau

INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('ComptBien4El', 'Électricité', 14, NULL, 'B004'); -- compteur Électricité

-- appartement B005 : compteur d'eau general et compteur d'electricite propre au bien
INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('ComptBien5El', 'Électricité', 10, NULL, 'B005'); -- compteur Électricité

-- appartement B006 : compteurs generals d'eau et d'electricite

-- appartement B007 : compteur d'eau et d'electricite propres au bien
INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('ComptBien7Eau', 'Eau', 10, NULL, 'B007'); -- compteur Eau

INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
VALUES ('ComptBien7El', 'Électricité', 14, NULL, 'B007'); -- compteur Électricité


------------------------- RELEVE ------------------------

------ maison Capitole_1
-- CompMaisonCapitole_Eau
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('CompMaisonCapitole_Eau', TO_DATE('2022-10-15', 'YYYY-MM-DD'), 10);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('CompMaisonCapitole_Eau', TO_DATE('2023-03-15', 'YYYY-MM-DD'), 110);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('CompMaisonCapitole_Eau', TO_DATE('2023-08-15', 'YYYY-MM-DD'), 240);

-- CompMaisonCapitole_Electr
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('CompMaisonCapitole_Electr', TO_DATE('2023-09-10', 'YYYY-MM-DD'), 4540);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('CompMaisonCapitole_Electr', TO_DATE('2023-10-10', 'YYYY-MM-DD'), 4640);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('CompMaisonCapitole_Electr', TO_DATE('2023-11-10', 'YYYY-MM-DD'), 4845);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('CompMaisonCapitole_Electr', TO_DATE('2023-12-10', 'YYYY-MM-DD'), 5123);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('CompMaisonCapitole_Electr', TO_DATE('2024-01-10', 'YYYY-MM-DD'), 5390);

-- CompMaisonCapitole_Gaz
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('CompMaisonCapitole_Gaz', TO_DATE('2023-12-10', 'YYYY-MM-DD'), 300);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('CompMaisonCapitole_Gaz', TO_DATE('2024-01-10', 'YYYY-MM-DD'), 400);

------ maison Saint_Sernin_15
-- ComptMaisonSTSernin_Eau
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTSernin_Eau', TO_DATE('2023-03-10', 'YYYY-MM-DD'), 110);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTSernin_Eau', TO_DATE('2023-08-10', 'YYYY-MM-DD'), 240);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTSernin_Eau', TO_DATE('2023-01-10', 'YYYY-MM-DD'), 340);

-- ComptMaisonSTSernin_El
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTSernin_El', TO_DATE('2023-09-10', 'YYYY-MM-DD'), 4541);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTSernin_El', TO_DATE('2023-10-10', 'YYYY-MM-DD'), 4647);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTSernin_El', TO_DATE('2023-11-10', 'YYYY-MM-DD'), 4846);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTSernin_El', TO_DATE('2023-12-10', 'YYYY-MM-DD'), 5123);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTSernin_El', TO_DATE('2024-01-10', 'YYYY-MM-DD'), 5390);

------ maison Saint_Michel_10
-- ComptMaisonSTMichel_Eau
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTMichel_Eau', TO_DATE('2023-03-10', 'YYYY-MM-DD'), 117);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTMichel_Eau', TO_DATE('2023-08-10', 'YYYY-MM-DD'), 249);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTMichel_Eau', TO_DATE('2023-01-10', 'YYYY-MM-DD'), 348);

-- ComptMaisonSTMichel_El
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTMichel_El', TO_DATE('2023-09-10', 'YYYY-MM-DD'), 4541);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTMichel_El', TO_DATE('2023-10-10', 'YYYY-MM-DD'), 4647);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTMichel_El', TO_DATE('2023-11-10', 'YYYY-MM-DD'), 4846);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTMichel_El', TO_DATE('2023-12-10', 'YYYY-MM-DD'), 5123);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTMichel_El', TO_DATE('2024-01-10', 'YYYY-MM-DD'), 5390);

-- ComptMaisonSTMichel_Gaz
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTMichel_Gaz', TO_DATE('2023-11-10', 'YYYY-MM-DD'), 210);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTMichel_Gaz', TO_DATE('2023-12-10', 'YYYY-MM-DD'), 310);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptMaisonSTMichel_Gaz', TO_DATE('2024-01-10', 'YYYY-MM-DD'), 456);

------ immeuble Compans_Caffarelli_8
-- ComptImmCompans_EauGeneral
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCompans_EauGeneral', TO_DATE('2023-03-10', 'YYYY-MM-DD'), 117);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCompans_EauGeneral', TO_DATE('2023-08-10', 'YYYY-MM-DD'), 249);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCompans_EauGeneral', TO_DATE('2023-01-10', 'YYYY-MM-DD'), 348);

-- ComptImmCompans_ElGeneral
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCompans_ElGeneral', TO_DATE('2023-09-10', 'YYYY-MM-DD'), 4541);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCompans_ElGeneral', TO_DATE('2023-10-10', 'YYYY-MM-DD'), 4647);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCompans_ElGeneral', TO_DATE('2023-11-10', 'YYYY-MM-DD'), 4846);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCompans_ElGeneral', TO_DATE('2023-12-10', 'YYYY-MM-DD'), 5123);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCompans_ElGeneral', TO_DATE('2024-01-10', 'YYYY-MM-DD'), 5390);

-- ComptImmCompans_GazGeneral
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCompans_GazGeneral', TO_DATE('2023-11-10', 'YYYY-MM-DD'), 210);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCompans_GazGeneral', TO_DATE('2023-12-10', 'YYYY-MM-DD'), 310);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCompans_GazGeneral', TO_DATE('2024-01-10', 'YYYY-MM-DD'), 456);

------ immeuble Jean_Jaurès_22
-- ComptImmJJaures_EauGeneral
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmJJaures_EauGeneral', TO_DATE('2023-03-10', 'YYYY-MM-DD'), 118);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmJJaures_EauGeneral', TO_DATE('2023-08-10', 'YYYY-MM-DD'), 251);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmJJaures_EauGeneral', TO_DATE('2023-01-10', 'YYYY-MM-DD'), 350);

-- ComptImmJJaures_ElGeneral
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmJJaures_ElGeneral', TO_DATE('2023-09-10', 'YYYY-MM-DD'), 4542);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmJJaures_ElGeneral', TO_DATE('2023-10-10', 'YYYY-MM-DD'), 4648);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmJJaures_ElGeneral', TO_DATE('2023-11-10', 'YYYY-MM-DD'), 4847);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmJJaures_ElGeneral', TO_DATE('2023-12-10', 'YYYY-MM-DD'), 5124);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmJJaures_ElGeneral', TO_DATE('2024-01-10', 'YYYY-MM-DD'), 5391);

-- ComptImmJJaures_GazGeneral
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmJJaures_GazGeneral', TO_DATE('2023-11-10', 'YYYY-MM-DD'), 211);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmJJaures_GazGeneral', TO_DATE('2023-12-10', 'YYYY-MM-DD'), 311);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmJJaures_GazGeneral', TO_DATE('2024-01-10', 'YYYY-MM-DD'), 457);

----- immeuble Carmes_12
-- ComptImmCarmes_EauGeneral
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCarmes_EauGeneral', TO_DATE('2023-03-10', 'YYYY-MM-DD'), 118);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCarmes_EauGeneral', TO_DATE('2023-08-10', 'YYYY-MM-DD'), 250);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCarmes_EauGeneral', TO_DATE('2023-01-10', 'YYYY-MM-DD'), 349);

-- ComptImmCarmes_ElGeneral
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCarmes_ElGeneral', TO_DATE('2023-09-10', 'YYYY-MM-DD'), 4542);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCarmes_ElGeneral', TO_DATE('2023-10-10', 'YYYY-MM-DD'), 4648);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCarmes_ElGeneral', TO_DATE('2023-11-10', 'YYYY-MM-DD'), 4847);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCarmes_ElGeneral', TO_DATE('2023-12-10', 'YYYY-MM-DD'), 5124);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptImmCarmes_ElGeneral', TO_DATE('2024-01-10', 'YYYY-MM-DD'), 5391);

----- appartement B004
-- ComptBien4Eau
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien4Eau', TO_DATE('2023-03-10', 'YYYY-MM-DD'), 2544);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien4Eau', TO_DATE('2023-08-10', 'YYYY-MM-DD'), 2580);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien4Eau', TO_DATE('2023-01-10', 'YYYY-MM-DD'), 2600);

-- ComptBien4El
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien4El', TO_DATE('2023-09-10', 'YYYY-MM-DD'), 600);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien4El', TO_DATE('2023-10-10', 'YYYY-MM-DD'), 626);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien4El', TO_DATE('2023-11-10', 'YYYY-MM-DD'), 700);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien4El', TO_DATE('2023-12-10', 'YYYY-MM-DD'), 756);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien4El', TO_DATE('2024-01-10', 'YYYY-MM-DD'), 830);

----- appartement B005
-- ComptBien5El
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien5El', TO_DATE('2023-09-10', 'YYYY-MM-DD'), 9038);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien5El', TO_DATE('2023-10-10', 'YYYY-MM-DD'), 9138);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien5El', TO_DATE('2023-11-10', 'YYYY-MM-DD'), 9238);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien5El', TO_DATE('2023-12-10', 'YYYY-MM-DD'), 9338);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien5El', TO_DATE('2024-01-10', 'YYYY-MM-DD'), 9438);

----- appartement B007
-- ComptBien4Eau
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien7Eau', TO_DATE('2023-03-10', 'YYYY-MM-DD'), 2544);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien7Eau', TO_DATE('2023-08-10', 'YYYY-MM-DD'), 2580);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien7Eau', TO_DATE('2023-01-10', 'YYYY-MM-DD'), 2600);

-- ComptBien7El
INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien7El', TO_DATE('2023-09-10', 'YYYY-MM-DD'), 600);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien7El', TO_DATE('2023-10-10', 'YYYY-MM-DD'), 626);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien7El', TO_DATE('2023-11-10', 'YYYY-MM-DD'), 700);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien7El', TO_DATE('2023-12-10', 'YYYY-MM-DD'), 756);

INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
VALUES ('ComptBien7El', TO_DATE('2024-01-10', 'YYYY-MM-DD'), 830);


------------------------- QUOTTER ------------------------

----- appartement B004
INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B004', 'Électricité', 30.0);

INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B004', 'Eau', 40.0);

INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B004', 'Ordures ménagères', 15.0);

----- appartement B005
INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B005', 'Électricité', 30.0);

INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B005', 'Eau', 40.0);

INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B005', 'Ordures ménagères', 15.0);

----- appartement B006
INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B006', 'Électricité', 30.0);

INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B006', 'Eau', 40.0);

INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B006', 'Ordures ménagères', 15.0);

----- appartement B007
INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B007', 'Électricité', 30.0);

INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B007', 'Eau', 40.0);

INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B007', 'Ordures ménagères', 15.0);

----- garage B008
INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B008', 'Électricité', 10.0);

INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B008', 'Eau', 10.0);

INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B008', 'Ordures ménagères', 20.0);

----- garage B009
INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B009', 'Électricité', 10.0);

INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B009', 'Eau', 10.0);

INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B009', 'Ordures ménagères', 20.0);

----- garage B010
INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B010', 'Électricité', 10.0);

INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B010', 'Eau', 10.0);

INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
VALUES ('B010', 'Ordures ménagères', 20.0);


------------------------- IMPOSER ------------------------
-- Maison B001
INSERT INTO Imposer (Id_Bien, Id_Impot)
VALUES ('B001', 1);

-- Maison B002
INSERT INTO Imposer (Id_Bien, Id_Impot)
VALUES ('B002', 2);

INSERT INTO Imposer (Id_Bien, Id_Impot)
VALUES ('B002', 3);

-- Maison B003 -- pas encore recu 

-- Appartement B004
INSERT INTO Imposer (Id_Bien, Id_Impot)
VALUES ('B004', 4);

INSERT INTO Imposer (Id_Bien, Id_Impot)
VALUES ('B004', 5);

INSERT INTO Imposer (Id_Bien, Id_Impot)
VALUES ('B004', 6);

-- Appartement B005
INSERT INTO Imposer (Id_Bien, Id_Impot)
VALUES ('B005', 7);

-- Appartement B006
INSERT INTO Imposer (Id_Bien, Id_Impot)
VALUES ('B006', 8);

INSERT INTO Imposer (Id_Bien, Id_Impot)
VALUES ('B006', 9);

-- Appartement B007
INSERT INTO Imposer (Id_Bien, Id_Impot)
VALUES ('B007', 10);

-- Garage B008
INSERT INTO Imposer (Id_Bien, Id_Impot)
VALUES ('B008', 11);

INSERT INTO Imposer (Id_Bien, Id_Impot)
VALUES ('B008', 12);

INSERT INTO Imposer (Id_Bien, Id_Impot)
VALUES ('B008', 13);

-- Garage B009 -- pas encore recu

-- Garage B010
INSERT INTO Imposer (Id_Bien, Id_Impot)
VALUES ('B010', 14);

