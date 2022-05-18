DROP DATABASE IF EXISTS pizzeria;
CREATE DATABASE pizzeria;
use pizzeria;

CREATE TABLE Pizza(
   idPizza INT AUTO_INCREMENT,
   nomPizza VARCHAR(50),
   taillePizza VARCHAR(50),
   prixPizza DECIMAL(15,2),
   PRIMARY KEY(idPizza)
);

CREATE TABLE Client(
   idClient INT AUTO_INCREMENT,
   nomClient VARCHAR(50),
   prenomClient VARCHAR(50),
   telClient VARCHAR(50),
   PRIMARY KEY(idClient)
);

CREATE TABLE Adresse(
   idAdresse INT AUTO_INCREMENT,
   numRue INT,
   ville VARCHAR(50),
   codePostale INT,
   completementAdresse VARCHAR(50),
   PRIMARY KEY(idAdresse)
);

CREATE TABLE Ingredient(
   idIngredient INT AUTO_INCREMENT,
   nomIngredient VARCHAR(50),
   quantiteIngredient DECIMAL(15,2),
   PRIMARY KEY(idIngredient)
);

CREATE TABLE DateCommande(
   idDate INT AUTO_INCREMENT,
   DateCommande DATE,
   PRIMARY KEY(idDate)
);

CREATE TABLE Cuisinier(
   idCuisinier INT AUTO_INCREMENT,
   nomCuisinier VARCHAR(50),
   prenomCuisinier VARCHAR(50),
   numTel INT,
   PRIMARY KEY(idCuisinier)
);

CREATE TABLE Livreur(
   idLivreur INT AUTO_INCREMENT,
   nomLivreur VARCHAR(50) NOT NULL,
   prenomLivreur VARCHAR(50),
   numTel INT,
   PRIMARY KEY(idLivreur)
);

CREATE TABLE Commande(
   idCommande INT AUTO_INCREMENT,
   HeureArrive VARCHAR(50),
   idAdresse INT NOT NULL,
   idLivreur INT NOT NULL,
   idCuisinier INT NOT NULL,
   idDate INT NOT NULL,
   idClient INT NOT NULL,
   PRIMARY KEY(idCommande),
   FOREIGN KEY(idAdresse) REFERENCES Adresse(idAdresse),
   FOREIGN KEY(idLivreur) REFERENCES Livreur(idLivreur),
   FOREIGN KEY(idCuisinier) REFERENCES Cuisinier(idCuisinier),
   FOREIGN KEY(idDate) REFERENCES DateCommande(idDate),
   FOREIGN KEY(idClient) REFERENCES Client(idClient)
);

CREATE TABLE Comporter(
   idCommande INT,
   idPizza INT,
   PRIMARY KEY(idCommande, idPizza),
   FOREIGN KEY(idCommande) REFERENCES Commande(idCommande),
   FOREIGN KEY(idPizza) REFERENCES Pizza(idPizza)
);

CREATE TABLE Posseder(
   idPizza INT,
   idIngredient INT,
   PRIMARY KEY(idPizza, idIngredient),
   FOREIGN KEY(idPizza) REFERENCES Pizza(idPizza),
   FOREIGN KEY(idIngredient) REFERENCES Ingredient(idIngredient)
);
