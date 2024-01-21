
---------------------------LOCATAIRE-------------------------------------

CREATE TABLE Locataire(
   Id_Locataire VARCHAR2(30) constraint pk_locataire primary key,
   nom VARCHAR2(30) constraint nn_loca_nom not null,
   prenom VARCHAR2(30) constraint nn_loca_prenom not null,
   telephone CHAR(15) constraint nn_loca_telephone not null,
   mail VARCHAR2(50),
   date_naissance DATE constraint nn_loca_dn not null,
   constraint un_loca_nom_prenom_d_n unique (nom,prenom,date_naissance),
   constraint ck_loca_mail CHECK (REGEXP_LIKE(mail, '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}$')),
   constraint ck_loca_telephone CHECK (REGEXP_LIKE(telephone, '(0|\\+33|0033)[1-9][0-9]{8}'))
   );

-------------------------- ARCHIVAGE LOCATAIRE-------------------------------------

CREATE TABLE Archivage_Locataire(
   Id_Locataire VARCHAR2(30) constraint pk_archiv_locataire primary key,
   nom VARCHAR2(30) constraint nn_archiv_loca_nom not null,
   prenom VARCHAR2(30) constraint nn_archiv_loca_prenom not null,
   telephone CHAR(15) constraint nn_archiv_loca_telephone not null,
   mail VARCHAR2(50) constraint nn_archiv_loca_mail not null,
   date_naissance DATE constraint nn_archiv_loca_dn not null,
   constraint un_archiv_loca_nom_prenom_d_n unique (nom,prenom,date_naissance),
   constraint ck_archiv_loca_mail CHECK (REGEXP_LIKE(mail, '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}$')),
   constraint ck_archiv_loca_telephone CHECK (REGEXP_LIKE(telephone, '(0|\\+33|0033)[1-9][0-9]{8}'))
);

--------------------------IMMEUBLE-------------------------------------

CREATE TABLE Immeuble(
   Id_Immeuble VARCHAR2(30) constraint pk_imm PRIMARY KEY,
   adresse VARCHAR2(50) constraint nn_imm_adresse NOT NULL,
   cp CHAR(5) constraint nn_imm_cp NOT NULL,
   ville VARCHAR2(50) constraint nn_imm_ville NOT NULL,
   periode_construction VARCHAR2(15),  -- s'il connait pas l'annee, il va ecrire une periode
   type_immeuble VARCHAR2(30) constraint nn_imm_type NOT NULL,
   constraint un_imm_adresse UNIQUE(adresse, cp, ville),
   constraint ck_imm_cp CHECK (REGEXP_LIKE(cp, '^((0[1-9])|([1-8][0-9])|(9[0-8])|(2A)|(2B))[0-9]{3}$'))
);

--------------------------ENTREPRISE-------------------------------------

CREATE TABLE Entreprise(
   SIRET CHAR(14) constraint pk_entreprise_siret primary key,
   nom VARCHAR2(50) constraint nn_entreprise_nom not null,
   adresse VARCHAR2(50)  constraint nn_entreprise_adresse not null,
   cp CHAR(5) constraint nn_entreprise_cp not null,
   ville VARCHAR2(50) constraint nn_entreprise_ville not null,
   mail VARCHAR2(50),
   telephone CHAR(15) constraint nn_entreprise_telephone not null,
   IBAN CHAR(34) constraint nn_entreprise_iban not null,
   constraint un_entrerpise_iban unique (IBAN),
   constraint un_entreprise_adresse unique(adresse, cp, ville),
   constraint ck_entreprise_siret CHECK (REGEXP_LIKE(SIRET, '^[0-9]{14}$')),
   constraint ck_entreprise_cp CHECK (REGEXP_LIKE(cp, '^((0[1-9])|([1-8][0-9])|(9[0-8])|(2A)|(2B))[0-9]{3}$')),
   constraint ck_entreprise_mail CHECK (REGEXP_LIKE(mail, '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}$')),
   constraint ck_entreprise_telephone CHECK (REGEXP_LIKE(telephone, '(0|\\+33|0033)[1-9][0-9]{8}')),
   constraint ck_entreprise_iban CHECK (REGEXP_LIKE(IBAN, '^[A-Z]{2}[A-Z0-9 ]{25,34}$'))
 );

--------------------------ICC-------------------------------------

CREATE TABLE ICC (
   annee CHAR(4),  
   trimestre CHAR(1),
   indice NUMBER constraint nn_icc_indice not null,
   constraint pk_icc primary key (annee, trimestre)
);

--------------------------QUOTITE-------------------------------------

CREATE TABLE Quotite(
  type_quotite VARCHAR2(50) constraint pk_quotite primary key
);

--------------------------IMPOT-------------------------------------
 
CREATE SEQUENCE compteur_Impot
  START WITH 1
  INCREMENT BY 1;

CREATE TABLE Impot(
   Id_Impot INT DEFAULT compteur_Impot.NEXTVAL primary key,
   nom VARCHAR2(30) constraint nn_impot_nom not null,
   montant NUMBER constraint nn_impot_montant not null,
   annee CHAR(4) constraint nn_impot_annee not null,
   constraint ck_montant check (montant > 0),
   constraint uu_impot unique(Id_Impot,nom,montant)
);

--------------------------BIEN-------------------------------------

CREATE TABLE Bien (
   Id_Bien VARCHAR2(30) constraint pk_bien PRIMARY KEY,
   surface_habitable NUMBER constraint nn_bien_surface_habitable NOT NULL,
   nb_pieces NUMBER(2) constraint nn_bien_nb_pieces NOT NULL,
   num_etage NUMBER(2) constraint nn_bien_num_etage NOT NULL,
   date_acquisition DATE constraint nn_bien_date_acquisition NOT NULL,
   type_bien VARCHAR2(30) constraint nn_bien_type not null,
   Id_Immeuble VARCHAR2(30) constraint nn_bien_id_immeuble NOT NULL,
   constraint fk_bien_id_immeuble FOREIGN KEY(Id_Immeuble) REFERENCES Immeuble,
   constraint ck_surface check (surface_habitable > 0),
   constraint ck_nb_pieces check (nb_pieces > 0),
   constraint ck_num_etage check (num_etage >= 0)
);


--------------------------ASSURANCE-------------------------------------

CREATE TABLE Assurance(
   numero_police VARCHAR2(50) constraint pk_assurance primary key,
   montant NUMBER constraint nn_assurance_montant not null,
   Id_Bien VARCHAR2(30),
   SIRET CHAR(14) constraint nn_assurance_siret not null,
   constraint fk_assurance_id_bien foreign key(Id_Bien) references Bien,
   constraint fk_assurance_siret foreign key(siret) references Entreprise,
   constraint ck_montantInitial check (montant > 0)
);

--------------------------ECHEANCE-------------------------------------

CREATE TABLE Echeance(
   numero_police VARCHAR2(50),
   date_echeance DATE constraint nn_echeance_date not null,
   constraint pk_echeance primary key(numero_police, date_echeance),
   constraint fk_echeance_numero_police foreign key(numero_police) references Assurance
);

--------------------------DIAGNOSTIC-------------------------------------

CREATE SEQUENCE compteur_Diagnostic
  START WITH 1
  INCREMENT BY 1;

CREATE TABLE Diagnostic(
   Id_Diagnostic INT DEFAULT compteur_Diagnostic.NEXTVAL PRIMARY KEY,
   date_validite DATE constraint nn_diagnostic_date not null,
   type_diagnostic VARCHAR2(50) constraint nn_diagnostic_type not null,
   Id_Bien VARCHAR2(30) constraint nn_id_bien not null,
   constraint fk_diagnostic_id_bien foreign key(Id_Bien) references Bien,
   constraint uu_diagnostic unique(date_validite, type_diagnostic, Id_Bien)
);

--------------------------FACTURE-------------------------------------

CREATE TABLE Facture(
   numero VARCHAR2(30) PRIMARY KEY,
   date_emission DATE constraint nn_facture_date_emission NOT NULL,
   date_paiement DATE ,
   mode_paiement VARCHAR2(30),
   numero_devis VARCHAR2(50),
   designation VARCHAR2(50) constraint nn_facture_designation NOT NULL,
   montant_reel_paye NUMBER,
   montant NUMBER constraint nn_facture_montant NOT NULL,
   imputable_locataire NUMBER(1,0) constraint nn_facture_imputable_locataire NOT NULL,
   Id_immeuble VARCHAR2(30),
   Id_Bien VARCHAR2(30),
   SIRET CHAR(14),
   constraint fk_facture_id_immeuble FOREIGN KEY(Id_immeuble) REFERENCES Immeuble,
   constraint fk_facture_id_bien FOREIGN KEY(Id_Bien) REFERENCES Bien,
   constraint fk_facture_siret FOREIGN KEY(SIRET) REFERENCES Entreprise,
   constraint ck_facture_accompte CHECK (montant_reel_paye >= 0),
   constraint ck_facture_montant CHECK (montant > 0),
   constraint ck_facture_imputable_locataire CHECK (imputable_locataire IN (0,1)),
   constraint uu_facture_numero_devis UNIQUE(numero_devis),
   constraint uu_facture check (not((Id_immeuble is null and Id_Bien is null) or
                        (Id_immeuble is not null and Id_Bien is not null)))
);

---------------- ARCHIVAGE FACTURE -------------------------------------

CREATE TABLE Archivage_Facture(
   numero VARCHAR2(30) PRIMARY KEY,
   date_emission DATE constraint nn_arch_fact_date_emiss NOT NULL,
   date_paiement DATE ,
   mode_paiement VARCHAR2(30),
   numero_devis VARCHAR2(50),
   designation VARCHAR2(50) constraint nn_arch_fact_designation NOT NULL,
   montant_reel_paye NUMBER(15,2),
   montant NUMBER(15,2) constraint nn_arch_facture_montant NOT NULL,
   imputable_locataire NUMBER(1,0) constraint nn_arch_fact_imput_locat NOT NULL,
   Id_immeuble VARCHAR2(30),
   Id_Bien VARCHAR2(30),
   SIRET CHAR(14),
   constraint ck_arch_facture_accompte CHECK (montant_reel_paye >= 0),
   constraint ck_arch_facture_montant CHECK (montant > 0),
   constraint ck_arch_fact_imput_locat CHECK (imputable_locataire IN (0,1)),
   constraint uu_arch_facture_numero_devis UNIQUE(numero_devis),
   constraint uu_arch_facture check (not((Id_immeuble is null and Id_Bien is null) or
                        (Id_immeuble is not null and Id_Bien is not null)))
);

-------------------------- LOUER -------------------------------------

CREATE TABLE Louer (
   Id_Locataire VARCHAR2(30) constraint nn_louer_Id_Locataire NOT NULL,
   Id_Bien VARCHAR2(30) constraint nn_louer_Id_Bien NOT NULL,
   Date_Debut DATE constraint nn_louer_date NOT NULL,
   nb_mois NUMBER(3),
   loyer_TTC NUMBER constraint nn_louer_loyer NOT NULL,
   provision_chargeMens_TTC NUMBER(10,2) constraint nn_louer_provisionCharge NOT NULL,
   caution_TTC NUMBER constraint nn_louer_caution NOT NULL,
   bail VARCHAR2(200) constraint nn_louer_bail NOT NULL,
   etat_lieux VARCHAR2(200) constraint nn_louer_etat_lieux NOT NULL,
   date_derniere_reg DATE,
   loyer_paye NUMBER(1),
   annee CHAR(4) constraint nn_louer_annee NOT NULL,
   trimestre CHAR(1) constraint nn_louer_trimestre NOT NULL,
   montant_reel_paye NUMBER,
   constraint pk_louer PRIMARY KEY (Id_Locataire, Id_Bien, Date_Debut),
   constraint fk_louer_id_locataire FOREIGN KEY (Id_Locataire) REFERENCES Locataire,
   constraint fk_louer_id_bien FOREIGN KEY (Id_Bien) REFERENCES Bien,                           
   constraint fk_louer_annee_trimestre FOREIGN KEY (annee, trimestre) REFERENCES ICC,
   constraint ck_louer_nb_mois check (nb_mois > 0),
   constraint ck_louer_loyer_TTC check (loyer_TTC > 0),
   constraint ck_louer_provision_charge check (provision_chargeMens_TTC  > 0 and provision_chargeMens_TTC < loyer_TTC/4),
   constraint ck_louer_caution_TTC  check (caution_TTC  > 0),
   constraint ck_louer_caution_loyer  check (caution_TTC  <= loyer_TTC + provision_chargeMens_TTC),
   constraint ck_louer_montant_reel_paye  check (montant_reel_paye  >= 0),
   constraint ck_loyer_paye_bool check (loyer_paye in (1,0))
);

-------------------------- ARCHIVAGE LOUER -------------------------------------

CREATE TABLE Archivage_Louer (
   Id_Locataire VARCHAR2(30) constraint nn_archv_louer_Id_Locataire NOT NULL,
   Id_Bien VARCHAR2(30) constraint nn_archv_louer_Id_Bien NOT NULL,
   Date_Debut DATE constraint nn_archv_louer_date NOT NULL,
   nb_mois NUMBER(3),
   loyer_TTC NUMBER(10,2) constraint nn_archv_louer_loyer NOT NULL,
   provision_chargeMens_TTC NUMBER(10,2) constraint nn_archv_louer_provisCharge NOT NULL,
   caution_TTC NUMBER(10,2) constraint nn_archv_louer_caution NOT NULL,
   bail VARCHAR2(200) constraint nn_archv_louer_bail NOT NULL,
   etat_lieux VARCHAR2(200) constraint nn_archv_louer_etat_lieux NOT NULL,
   date_derniere_reg DATE,
   loyer_paye NUMBER(1),
   annee CHAR(4) constraint nn_archv_louer_annee NOT NULL,
   trimestre CHAR(1) constraint nn_archv_louer_trim NOT NULL,
   montant_reel_paye NUMBER(15,2),
   constraint pk_archv_louer PRIMARY KEY (Id_Locataire, Id_Bien, Date_Debut),
   constraint ck_archv_louer_nb_mois check (nb_mois > 0),
   constraint ck_archv_louer_loyer_TTC check (loyer_TTC > 0),
   constraint ck_archv_louer_prov_charge check (provision_chargeMens_TTC  > 0 and provision_chargeMens_TTC < loyer_TTC/4),
   constraint ck_archv_louer_caution_TTC  check (caution_TTC  > 0),
   constraint ck_archv_louer_caution  check (caution_TTC  <= loyer_TTC + provision_chargeMens_TTC),
   constraint ck_archv_montant_reel_paye  check (montant_reel_paye  >= 0),
   constraint ck_archv_loyer_paye_bool check (loyer_paye in (1,0))
);

--------------------------COMPTEUR-------------------------------------

CREATE TABLE Compteur (
   id_compteur VARCHAR2(50) PRIMARY KEY,
   typeComp VARCHAR2(50) constraint nn_compteur_type not null,
   prix_abonnement NUMBER constraint nn_compteur_abonnement not null,
   Id_immeuble VARCHAR2(30),
   Id_Bien VARCHAR2(30),
   constraint fk_compteur_id_immeuble FOREIGN KEY(Id_immeuble) REFERENCES Immeuble,
   constraint fk_compteur_id_bien FOREIGN KEY(Id_Bien) REFERENCES Bien,
   constraint un_IDcompteur_type unique (id_compteur, typeComp),
   constraint un_compteur_IdImmeuble unique (id_compteur, typeComp, Id_Immeuble), -- unicite du compteur general
   constraint uu_compteur check (not((Id_immeuble is null and Id_Bien is null) or
                        (Id_immeuble is not null and Id_Bien is not null)))
);

--------------------------RELEVE-------------------------------------

CREATE TABLE Relevé(
   Id_Compteur VARCHAR2(50),
   date_relevé DATE,
   indexComp  NUMBER constraint nn_reeve_idexCom not null,
   constraint pk_releve PRIMARY KEY(Id_Compteur, date_relevé),
   constraint fk_releve_id_bien FOREIGN KEY(Id_Compteur) REFERENCES Compteur(Id_Compteur),
   constraint uu_releve unique(Id_Compteur,date_relevé,indexComp)
);

--------------------------QUOTTER-------------------------------------

CREATE TABLE Quotter(
   Id_Bien VARCHAR2(30) ,
   type_quotite VARCHAR2(50) ,
   pourcentage NUMBER,
   constraint pk_quotter PRIMARY KEY(Id_Bien, type_quotite),
   constraint fk_quotter_id_bien FOREIGN KEY(Id_Bien) REFERENCES Bien(Id_Bien),
   constraint fk_quotter_type_quotite FOREIGN KEY(type_quotite) REFERENCES Quotite(type_quotite),
   constraint ck_quotter_pourcentage check (pourcentage > 0 AND pourcentage <= 100),
   constraint uu_quotter unique(Id_Bien,type_quotite,pourcentage)
);

--------------------------IMPOSER-------------------------------------

CREATE TABLE Imposer(
   Id_Bien VARCHAR2(30) ,
   Id_Impot NUMBER(10),
   constraint pk_imposer PRIMARY KEY(Id_Bien, Id_Impot),
   constraint fk_imposer_idBien FOREIGN KEY(Id_Bien) REFERENCES Bien(Id_Bien),
   constraint fk_imposer_idImpot FOREIGN KEY(Id_Impot) REFERENCES Impot(Id_Impot)
);







