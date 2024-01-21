-------------------------- LOCATAIRE -------------------------------------

-- Déclencheur pour vérifier la date de naissance du locataire
CREATE OR REPLACE TRIGGER trg_check_date_naissance
BEFORE INSERT OR UPDATE ON Locataire
FOR EACH ROW
BEGIN
   -- Vérifier si la date de naissance est postérieure ou égale à la date actuelle
   IF :NEW.date_naissance >= SYSDATE THEN
      -- Si la condition est vraie, déclencher une erreur d'application avec le code -20001
      RAISE_APPLICATION_ERROR(-20001, 'La date de naissance ne peut pas être égale ou ultérieure à la date actuelle.');
   END IF;
END;
/

-- Déclencheur pour vérifier si le locataire est majeur
CREATE OR REPLACE TRIGGER trg_check_majeur
BEFORE INSERT OR UPDATE ON Locataire
FOR EACH ROW
BEGIN
   -- Calculer la différence en mois entre la date actuelle et la date de naissance du locataire
   IF MONTHS_BETWEEN(SYSDATE, :NEW.date_naissance) < 216 THEN
      -- Si la condition est vraie, déclencher une erreur d'application avec le code -20002
      RAISE_APPLICATION_ERROR(-20002, 'Le locataire doit être majeur');
   END IF;
END;
/

-------------------------- IMMEUBLE --------------------------------------

-------------------------- ENTREPRISE ------------------------------------

-------------------------- ICC -------------------------------------

-- Déclencheur pour vérifier la validité de l'année de l'ICC lors de l'insertion ou de la mise à jour
CREATE OR REPLACE TRIGGER icc_check_date
BEFORE INSERT OR UPDATE ON ICC
FOR EACH ROW
BEGIN
   -- Vérifier si l'année de l'ICC est antérieure à 1900 ou supérieure à l'année actuelle
   IF :NEW.annee <= '1900' OR :NEW.annee > TO_CHAR(SYSDATE, 'YYYY') THEN
      -- Si la condition est vraie, déclencher une erreur d'application avec le code -20001
      RAISE_APPLICATION_ERROR(-20001, 'L''année de l''ICC doit être supérieure à 1900 et inférieure ou égale à l''année actuelle.');
   END IF;
END;
/

-------------------------- BIEN -------------------------------------

-- Déclencheur pour vérifier que la date d'acquisition du bien n'est pas ultérieure à la date actuelle
CREATE OR REPLACE TRIGGER bien_check_date_acquisition
BEFORE INSERT OR UPDATE ON Bien
FOR EACH ROW
BEGIN
   -- Vérifier si la date d'acquisition est postérieure à la date actuelle
   IF :NEW.date_acquisition > SYSDATE THEN
      -- Si la condition est vraie, déclencher une erreur d'application avec le code -20001
      RAISE_APPLICATION_ERROR(-20001, 'La date d''acquisition ne peut pas être ultérieure à la date actuelle.');
   END IF;
END;
/

-- Déclencheur pour vérifier le type de bien en fonction du type d'immeuble associé
CREATE OR REPLACE TRIGGER check_type_bien
BEFORE INSERT OR UPDATE ON Bien
FOR EACH ROW
DECLARE
    v_imm_type VARCHAR2(30);
BEGIN
    -- Récupérer le type de l'immeuble associé au bien
    SELECT type_immeuble INTO v_imm_type
    FROM Immeuble
    WHERE Id_Immeuble = (SELECT Id_Immeuble FROM Immeuble WHERE Id_Immeuble = :NEW.Id_Immeuble);

    -- Vérifier les conditions
     IF (v_imm_type = 'Immeuble' AND (:NEW.type_bien <> 'Appartement' AND :NEW.type_bien <> 'Garage')) OR
       (v_imm_type = 'Maison' AND :NEW.type_bien <> 'Maison') THEN
        -- Si la condition est vraie, déclencher une erreur d'application avec le code -20022
        RAISE_APPLICATION_ERROR(-20022, 'Un immeuble ne peut contenir que des appartements et des garages');
    END IF;
END;
/

-- Déclencheur pour vérifier qu'un immeuble de type "maison" ne contient qu'un seul logement
CREATE OR REPLACE TRIGGER verif_maison_solo
BEFORE INSERT OR UPDATE ON Bien
FOR EACH ROW
DECLARE
    v_imm_type VARCHAR(15);
    v_nb_logements NUMBER;
BEGIN
    -- Récupérer le type de l'immeuble associé au bien
    SELECT type_immeuble INTO v_imm_type
    FROM Immeuble
    WHERE Id_Immeuble = (SELECT Id_Immeuble FROM Immeuble WHERE Id_Immeuble = :NEW.Id_Immeuble);
    
    -- Vérifier si l'immeuble est de type "maison"
    IF v_imm_type = 'Maison' THEN
        -- Compter le nombre de logements de type "maison" dans l'immeuble
        SELECT COUNT(*) INTO v_nb_logements
        FROM Bien
        WHERE Id_Immeuble = :NEW.Id_Immeuble AND type_bien = 'Maison';
        
        -- Si le nombre de logements est supérieur à 0, déclencher une erreur d'application avec le code -20023
        IF v_nb_logements > 0 THEN
            RAISE_APPLICATION_ERROR(-20023, 'Un immeuble de type "maison" ne peut contenir qu''un seul logement.');
        END IF;
    END IF;
END;
/

-- Déclencheur pour vérifier si le nombre de pièces est proportionnel à la surface habitable
CREATE OR REPLACE TRIGGER verif_nb_pieces
BEFORE INSERT OR UPDATE ON Bien
FOR EACH ROW
BEGIN
    -- Vérifier si le nombre de pièces est proportionnel à la surface habitable
    IF :NEW.nb_pieces * 10 > :NEW.surface_habitable THEN
        -- Si la condition est vraie, déclencher une erreur d'application avec le code -20001
        RAISE_APPLICATION_ERROR(-20001, 'Le nombre de pièces doit être proportionnel à la surface.');
    END IF;
END;
/

-------------------------- DIAGNOSTIC -------------------------------------

-- Déclencheur pour vérifier que la date de validité du diagnostic est ultérieure à la date actuelle
CREATE OR REPLACE TRIGGER diagnostic_check_date
BEFORE INSERT OR UPDATE ON Diagnostic
FOR EACH ROW
BEGIN
   -- Vérifier si la date de validité est antérieure ou égale à la date actuelle
   IF :NEW.date_validite <= SYSDATE THEN
      -- Si la condition est vraie, déclencher une erreur d'application avec le code -20001
      RAISE_APPLICATION_ERROR(-20001, 'La date de validité doit être ultérieure à la date actuelle.');
   END IF;
END;
/

-------------------------- LOUER -------------------------------------

-- Déclencheur pour attribuer une valeur par défaut à la date de la dernière régularisation si elle est NULL lors de l'insertion
CREATE OR REPLACE TRIGGER louer_datedr_defaut
BEFORE INSERT ON Louer
FOR EACH ROW
BEGIN
  -- Vérifier si la date de la dernière régularisation est NULL
  IF :NEW.date_derniere_reg IS NULL THEN
    -- Si c'est le cas, attribuer la valeur de la date de début de location à la date de la dernière régularisation
    :NEW.date_derniere_reg := :NEW.Date_Debut;
  END IF;
END;
/

-- Déclencheur pour vérifier que la date de début de location n'est pas ultérieure à la date actuelle lors de l'insertion ou de la mise à jour
CREATE OR REPLACE TRIGGER louer_check_dateDebut
BEFORE INSERT OR UPDATE ON Louer
FOR EACH ROW
BEGIN
   -- Vérifier si la date de début de location est postérieure à la date actuelle
   IF :NEW.Date_Debut > SYSDATE THEN
      -- Si la condition est vraie, déclencher une erreur d'application avec le code -20001
      RAISE_APPLICATION_ERROR(-20001, 'La date de début de location ne peut pas être ultérieure à la date actuelle.');
   END IF;
END;
/

-- Déclencheur pour vérifier que la date de la dernière régularisation n'est pas ultérieure à la date actuelle lors de l'insertion ou de la mise à jour
CREATE OR REPLACE TRIGGER louer_check_date_dern_reg
BEFORE INSERT OR UPDATE ON Louer
FOR EACH ROW
BEGIN
   -- Vérifier si la date de la dernière régularisation est postérieure à la date actuelle
   IF :NEW.date_derniere_reg > SYSDATE THEN
      -- Si la condition est vraie, déclencher une erreur d'application avec le code -20002
      RAISE_APPLICATION_ERROR(-20002, 'La date de la dernière régularisation ne peut pas être ultérieure à la date actuelle.');
   END IF;
END;
/

-------------------------- FACTURE -------------------------------------

-- Déclencheur pour vérifier que la date d'émission de la facture n'est pas ultérieure à la date actuelle lors de l'insertion ou de la mise à jour
CREATE OR REPLACE TRIGGER facture_date_emission_trigger
BEFORE INSERT OR UPDATE ON Facture
FOR EACH ROW
BEGIN
   -- Vérifier si la date d'émission de la facture est postérieure à la date actuelle
   IF :NEW.date_emission > SYSDATE THEN
      -- Si la condition est vraie, déclencher une erreur d'application avec le code -20001
      RAISE_APPLICATION_ERROR(-20001, 'La date d''émission de la facture ne peut pas être ultérieure à la date actuelle.');
   END IF;
END;
/

-- Déclencheur pour vérifier que la date de paiement de la facture n'est pas ultérieure à la date actuelle lors de l'insertion ou de la mise à jour
CREATE OR REPLACE TRIGGER facture_date_paiement_trigger
BEFORE INSERT OR UPDATE ON Facture
FOR EACH ROW
BEGIN
   -- Vérifier si la date de paiement de la facture est postérieure à la date actuelle
   IF :NEW.date_paiement > SYSDATE THEN
      -- Si la condition est vraie, déclencher une erreur d'application avec le code -20001
      RAISE_APPLICATION_ERROR(-20001, 'La date de paiement ne peut pas être ultérieure à la date actuelle.');
   END IF;
END;
/

-- Déclencheur pour vérifier que la date d'émission de la facture n'est pas ultérieure à la date de paiement lors de l'insertion ou de la mise à jour
CREATE OR REPLACE TRIGGER facture_d_emission_p_trigger
BEFORE INSERT OR UPDATE ON Facture
FOR EACH ROW
BEGIN
   -- Vérifier si la date d'émission de la facture est postérieure à la date de paiement
   IF :NEW.date_emission > :NEW.date_paiement THEN
      -- Si la condition est vraie, déclencher une erreur d'application avec le code -20002
      RAISE_APPLICATION_ERROR(-20002, 'La date d''émission ne peut pas être ultérieure à la date de paiement.');
   END IF;
END;
/

-------------------------- RELEVE -------------------------------------

-- Déclencheur pour vérifier que la date du relevé n'est pas ultérieure à la date actuelle lors de l'insertion ou de la mise à jour
CREATE OR REPLACE TRIGGER releve_date_releve_trigger
BEFORE INSERT OR UPDATE ON Relevé
FOR EACH ROW
BEGIN
   -- Vérifier si la date du relevé est postérieure à la date actuelle
   IF :NEW.date_relevé > SYSDATE THEN
      -- Si la condition est vraie, déclencher une erreur d'application avec le code -20001
      RAISE_APPLICATION_ERROR(-20001, 'La date du relevé ne peut pas être ultérieure à la date actuelle.');
   END IF;
END;
/

-------------------------- IMPOT -------------------------------------

-- Déclencheur pour vérifier que l'année de l'impôt n'est pas supérieure à l'année actuelle moins un an lors de l'insertion
CREATE OR REPLACE TRIGGER checkAnneeImpot
BEFORE INSERT ON Impot
FOR EACH ROW
DECLARE
    v_AnneeActuelle NUMBER;
BEGIN
    -- Obtenir l'année actuelle
    SELECT EXTRACT(YEAR FROM SYSDATE) - 1 INTO v_AnneeActuelle FROM dual;

    -- Vérifier si l'année de l'impôt est supérieure à l'année actuelle moins un an
    IF :new.annee > v_AnneeActuelle THEN
        -- Si la condition est vraie, annuler l'insertion en levant une exception avec le code -20001
        RAISE_APPLICATION_ERROR(-20001, 'L''année de l''impôt ne peut pas être supérieure à l''année actuelle moins un an.');
    END IF;
END checkAnneeImpot;
/
