/*
Vu que nous avons réalisé toutes les vérifications des paramètres de chaque table avec des contraintes NOT NULL, CHECK, UNIQUE, etc., 
nous avons choisi de ne pas répéter les mêmes vérifications dans les procédures d'insertion. 
C'est pourquoi ces procédures d'insertion effectuent l'insertion dans la base de données sans aucune vérification supplémentaire.
*/
-------------------------- LOCATAIRE —-----------------------------------------------

CREATE OR REPLACE PROCEDURE Inserer_Locataire(
    p_Id_Locataire IN LOCATAIRE.Id_Locataire%TYPE,
    p_Nom IN LOCATAIRE.Nom%TYPE,
    p_Prenom IN LOCATAIRE.Prenom%TYPE,
    p_Telephone IN LOCATAIRE.Telephone%TYPE,
    p_Mail IN LOCATAIRE.Mail%TYPE,
    p_Date_Naissance IN LOCATAIRE.Date_Naissance%TYPE
) AS
BEGIN
    INSERT INTO Locataire (Id_Locataire, nom, prenom, telephone, mail, date_naissance)
    VALUES (p_Id_Locataire, p_Nom, p_Prenom, p_Telephone, p_Mail, p_Date_Naissance);
END;
/

-------------------------- ARCHIVE LOCATAIRE —-----------------------------------------------

CREATE OR REPLACE PROCEDURE Inserer_Archivage_Locataire(
    p_Id_Locataire IN LOCATAIRE.Id_Locataire%TYPE,
    p_Nom IN LOCATAIRE.Nom%TYPE,
    p_Prenom IN LOCATAIRE.Prenom%TYPE,
    p_Telephone IN LOCATAIRE.Telephone%TYPE,
    p_Mail IN LOCATAIRE.Mail%TYPE,
    p_Date_Naissance IN LOCATAIRE.Date_Naissance%TYPE
) AS
BEGIN
    INSERT INTO Archivage_Locataire(Id_Locataire , nom, prenom, telephone, mail, date_naissance)
    VALUES (p_Id_Locataire, p_Nom, p_Prenom, p_Telephone, p_Mail, p_Date_Naissance);
END;
/

-------------------------- IMMEUBLE -------------------------------------

CREATE OR REPLACE PROCEDURE Inserer_Immeuble(
    p_Id_Immeuble IN IMMEUBLE.Id_Immeuble%TYPE,
    p_Adresse IN IMMEUBLE.Adresse%TYPE,
    p_CP IN IMMEUBLE.CP%TYPE,
    p_Ville IN IMMEUBLE.Ville%TYPE,
    p_Periode_Construction IN IMMEUBLE.Periode_Construction%TYPE,
    p_type_immeuble IN IMMEUBLE.type_immeuble%TYPE
) AS
BEGIN
    INSERT INTO Immeuble (Id_Immeuble, adresse, cp, ville, periode_construction, type_immeuble)
    VALUES (p_Id_Immeuble, p_Adresse, p_CP, p_Ville, p_Periode_Construction, p_type_immeuble);
END;
/

-------------------------- ENTREPRISE -------------------------------------

CREATE OR REPLACE PROCEDURE INSERER_ENTREPRISE(
    p_SIRET IN entreprise.siret%TYPE,
    p_NOM IN entreprise.nom%TYPE,
    p_ADRESSE IN entreprise.adresse%TYPE,
    p_CP IN entreprise.cp%TYPE,
    p_Ville IN entreprise.ville%TYPE,
    p_MAIL IN entreprise.mail%TYPE,
    p_TELEPHONE IN entreprise.telephone%TYPE,
    p_IBAN IN entreprise.IBAN%TYPE
) AS

BEGIN
    INSERT INTO entreprise (siret, nom, adresse, cp, ville, mail, telephone, iban)
    VALUES (p_SIRET, p_NOM, p_ADRESSE, p_CP, p_Ville, p_MAIL, p_TELEPHONE, p_IBAN);
END INSERER_ENTREPRISE;
/

-------------------------- ICC -------------------------------------

CREATE OR REPLACE PROCEDURE Inserer_ICC(
    p_annee IN ICC.annee%TYPE,
    p_trimestre IN ICC.trimestre%TYPE,
    p_indice IN ICC.indice%TYPE
) AS
BEGIN
    INSERT INTO ICC (annee, trimestre, indice)
    VALUES (p_annee, p_trimestre, p_indice);
END;
/

-------------------------- QUOTITE -------------------------------------

CREATE OR REPLACE PROCEDURE Inserer_Quotite(
    p_typeQuotite IN Quotite.type_quotite%TYPE
) AS
BEGIN
    INSERT INTO Quotite (type_quotite)
    VALUES (p_typeQuotite);
END;
/

-------------------------- IMPOT -------------------------------------

CREATE OR REPLACE PROCEDURE Inserer_Impot(
    p_nom IN Impot.nom%TYPE,
    p_montant IN Impot.montant%TYPE,
    p_annee IN Impot.annee%TYPE,
    p_id_impot OUT Impot.id_impot%TYPE
) AS
BEGIN
    INSERT INTO Impot (nom, montant, annee)
    VALUES (p_nom, p_montant, p_annee)
    RETURNING id_impot INTO p_id_impot;
END;
/

-------------------------- BIEN -------------------------------------

CREATE OR REPLACE PROCEDURE Inserer_Bien(
    p_IdBien IN BIEN.Id_Bien%TYPE,
    p_surfaceHabitable IN BIEN.surface_habitable%TYPE,
    p_nb_pieces IN BIEN.nb_pieces%TYPE,
    p_num_etage IN BIEN.num_etage%TYPE,
    p_date_acquisition IN BIEN.date_acquisition%TYPE,
    p_Id_Immeuble IN BIEN.Id_Immeuble%TYPE,
    p_type_bien IN BIEN.type_bien%TYPE
) AS
BEGIN
    INSERT INTO Bien (Id_Bien, surface_habitable, nb_pieces, num_etage, date_acquisition, Id_Immeuble, type_bien)
    VALUES (p_IdBien, p_surfaceHabitable, p_nb_pieces, p_num_etage, p_date_acquisition, p_Id_Immeuble,p_type_bien);
END;
/

-------------------------- ASSURANCE -------------------------------------

CREATE OR REPLACE PROCEDURE INSERER_ASSURANCE(
    p_NUMERO_POLICE IN assurance.numero_police%type,
    p_MONTANT IN assurance.montant%type,
    p_ID_BIEN IN assurance.id_bien%type,
    p_SIRET IN assurance.siret%type) 
AS    
BEGIN
    INSERT INTO Assurance (numero_police, montant, Id_Bien, SIRET)
    VALUES (p_NUMERO_POLICE, p_MONTANT, p_ID_BIEN, p_SIRET);
END;
/

-------------------------- ECHEANCE -------------------------------------

CREATE OR REPLACE PROCEDURE INSERER_ECHEANCE(
    p_NUMERO_POLICE IN echeance.numero_police%type,
    p_DATE_ECHEANCE IN echeance.date_echeance%type)
AS
BEGIN 
    INSERT INTO echeance (numero_police, date_echeance)
    VALUES (p_NUMERO_POLICE, p_DATE_ECHEANCE);
END;
/

-------------------------- DIAGNOSTIC -------------------------------------

CREATE OR REPLACE PROCEDURE Inserer_Diagnostic(
    p_date_validite IN Diagnostic.date_validite%TYPE,
    p_type_diagnostic IN Diagnostic.type_diagnostic%TYPE,
    p_id_bien IN Diagnostic.id_bien%TYPE,
    p_id_diagnostic OUT Diagnostic.id_diagnostic%TYPE
) AS
BEGIN
    INSERT INTO Diagnostic (date_validite, type_diagnostic, id_bien)
    VALUES (p_date_validite, p_type_diagnostic, p_id_bien)
    RETURNING id_diagnostic INTO p_id_diagnostic;
END;
/

-------------------------- FACTURE -------------------------------------

CREATE OR REPLACE PROCEDURE Inserer_Facture(
    p_numero IN Facture.numero%TYPE,
    p_date_emission IN Facture.date_emission%TYPE,
    p_date_paiement IN Facture.date_paiement%TYPE,
    p_mode_paiement IN Facture.mode_paiement%TYPE,
    p_numero_devis IN Facture.numero_devis%TYPE,
    p_designation IN Facture.designation%TYPE,
    p_montant_reel_paye IN Facture.montant_reel_paye%TYPE,
    p_montant IN Facture.montant%TYPE,
    p_imputable_locataire IN Facture.imputable_locataire%TYPE,
    p_Id_immeuble IN Facture.Id_immeuble%TYPE,
    p_Id_Bien IN Facture.Id_Bien%TYPE,
    p_SIRET IN Facture.SIRET%TYPE
) AS
BEGIN
    INSERT INTO Facture (numero, date_emission, date_paiement, mode_paiement, numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_immeuble, Id_Bien, SIRET)
    VALUES(p_numero, p_date_emission, p_date_paiement, p_mode_paiement, p_numero_devis, p_designation, p_montant_reel_paye, p_montant, p_imputable_locataire, p_Id_immeuble, p_Id_Bien, p_SIRET);
END;
/

---------------------- ARCHIVAGE FACTURE -----------------------------------

CREATE OR REPLACE PROCEDURE Inserer_Archivage_Facture(
    p_numero IN Facture.numero%TYPE,
    p_date_emission IN Facture.date_emission%TYPE,
    p_date_paiement IN Facture.date_paiement%TYPE,
    p_mode_paiement IN Facture.mode_paiement%TYPE,
    p_numero_devis IN Facture.numero_devis%TYPE,
    p_designation IN Facture.designation%TYPE,
    p_montant_reel_paye IN Facture.montant_reel_paye%TYPE,
    p_montant IN Facture.montant%TYPE,
    p_imputable_locataire IN Facture.imputable_locataire%TYPE,
    p_Id_immeuble IN Facture.Id_immeuble%TYPE,
    p_Id_Bien IN Facture.Id_Bien%TYPE,
    p_SIRET IN Facture.SIRET%TYPE
) AS
BEGIN
    INSERT INTO Archivage_Facture(numero, date_emission, date_paiement, mode_paiement, numero_devis, designation, montant_reel_paye, montant, imputable_locataire, Id_immeuble, Id_Bien, SIRET)
    VALUES(p_numero, p_date_emission, p_date_paiement, p_mode_paiement, p_numero_devis, p_designation, p_montant_reel_paye, p_montant, p_imputable_locataire, p_Id_immeuble, p_Id_Bien, p_SIRET);
END;
/

-------------------------- LOUER -------------------------------------

CREATE OR REPLACE PROCEDURE Inserer_Louer(
    p_Id_Locataire IN Louer.Id_Locataire%TYPE,
    p_Id_Bien IN Louer.Id_Bien%TYPE,
    p_Date_Debut IN Louer.Date_Debut%TYPE,
    p_nb_mois IN Louer.nb_mois%TYPE,
    p_loyer_TTC IN Louer.loyer_TTC%TYPE,
    p_provision_chargeMens IN Louer.provision_chargeMens_TTC%TYPE,
    p_caution_TTC IN Louer.caution_TTC%TYPE,
    p_bail IN Louer.bail%TYPE,
    p_etatLieux IN Louer.etat_lieux%TYPE,
    p_date_derniere_reg IN Louer.date_derniere_reg%TYPE,
    p_loyer_paye IN Louer.loyer_paye%TYPE,
    p_annee IN Louer.annee%TYPE,
    p_trimestre IN Louer.trimestre%TYPE,
    p_montant_reel_paye IN Louer.montant_reel_paye%TYPE) AS
BEGIN
    INSERT INTO Louer(Id_Locataire, Id_Bien, Date_Debut, nb_mois, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, etat_lieux, date_derniere_reg, loyer_paye, annee, trimestre, montant_reel_paye)
    VALUES(p_Id_Locataire, p_Id_Bien, p_Date_Debut, p_nb_mois, p_loyer_TTC, p_provision_chargeMens, p_caution_TTC, p_bail, p_etatLieux, p_date_derniere_reg, p_loyer_paye, p_annee, p_trimestre, p_montant_reel_paye);
END;
/

-------------------------- ARCHIVAGE LOUER -------------------------------------

CREATE OR REPLACE PROCEDURE Inserer_Archivage_Louer(
    p_Id_Locataire IN Archivage_Louer.Id_Locataire%TYPE,
    p_Id_Bien IN Archivage_Louer.Id_Bien%TYPE,
    p_Date_Debut IN Archivage_Louer.Date_Debut%TYPE,
    p_nb_mois IN Archivage_Louer.nb_mois%TYPE,
    p_loyer_TTC IN Archivage_Louer.loyer_TTC%TYPE,
    p_provision_chargeMens IN Archivage_Louer.provision_chargeMens_TTC%TYPE,
    p_caution_TTC IN Archivage_Louer.caution_TTC%TYPE,
    p_bail IN Archivage_Louer.bail%TYPE,
    p_etatLieux IN Archivage_Louer.etat_lieux%TYPE,
    p_date_derniere_reg IN Archivage_Louer.date_derniere_reg%TYPE,
    p_loyer_paye IN Archivage_Louer.loyer_paye%TYPE,
    p_annee IN Archivage_Louer.annee%TYPE,
    p_trimestre IN Archivage_Louer.trimestre%TYPE,
    p_montant_reel_paye IN Archivage_Louer.montant_reel_paye%TYPE) AS
BEGIN
    INSERT INTO Archivage_Louer(Id_Locataire, Id_Bien, Date_Debut, nb_mois, loyer_TTC, provision_chargeMens_TTC, caution_TTC, bail, etat_lieux, date_derniere_reg, loyer_paye, annee, trimestre, montant_reel_paye)
    VALUES(p_Id_Locataire, p_Id_Bien, p_Date_Debut, p_nb_mois, p_loyer_TTC, p_provision_chargeMens, p_caution_TTC, p_bail, p_etatLieux, p_date_derniere_reg, p_loyer_paye, p_annee, p_trimestre, p_montant_reel_paye);
END;
/

-------------------------- COMPTEUR -------------------------------------

CREATE OR REPLACE PROCEDURE Inserer_Compteur(
    p_id_compteur IN COMPTEUR.id_compteur%TYPE,
    p_TypeComp IN COMPTEUR.typeComp%TYPE,
    p_prix_abonnement IN COMPTEUR.prix_abonnement%TYPE,
    p_Id_immeuble IN COMPTEUR.Id_immeuble%TYPE,
    p_Id_Bien IN COMPTEUR.Id_Bien%TYPE
) AS
BEGIN
    INSERT INTO Compteur (id_compteur, typeComp, prix_abonnement, Id_immeuble, Id_Bien)
    VALUES (p_id_compteur, p_TypeComp,p_prix_abonnement,p_Id_immeuble,p_Id_Bien);
END;
/

--------------------------RELEVE-------------------------------------

CREATE OR REPLACE PROCEDURE Inserer_Relevé(
    p_Id_Compteur IN Relevé.Id_Compteur%TYPE,
    p_date_relevé IN Relevé.date_relevé%TYPE,
    p_indexComp IN Relevé.indexComp%TYPE
) AS
BEGIN
    INSERT INTO Relevé (Id_Compteur, date_relevé, indexComp)
    VALUES (p_Id_Compteur, p_date_relevé,p_indexComp);
END;
/

--------------------------QUOTTER-------------------------------------

CREATE OR REPLACE PROCEDURE Inserer_Quotter(
    p_Id_Bien IN Quotter.Id_Bien%TYPE,
    p_type_quotite IN Quotter.type_quotite%TYPE,
    p_pourcentage IN Quotter.pourcentage%TYPE
) AS
BEGIN
    INSERT INTO Quotter (Id_Bien, type_quotite, pourcentage)
    VALUES (p_Id_Bien, p_type_quotite,p_pourcentage);
END;
/

--------------------------IMPOSER-------------------------------------

CREATE OR REPLACE PROCEDURE Inserer_Imposer(
    p_Id_Bien IN Imposer.Id_Bien%TYPE,
    p_id_Impot IN Imposer.Id_Impot%TYPE
) AS
BEGIN
    INSERT INTO Imposer (Id_Bien, Id_Impot)
    VALUES (p_Id_Bien, p_id_Impot);
END;
/

