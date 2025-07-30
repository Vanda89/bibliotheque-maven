# 📚 Application Java JPA - Gestion de Livres

Ce projet est une application Java simple qui utilise **JPA (Hibernate)** pour gérer des livres dans une base de données **MariaDB**.

## 📦 Fonctionnalités

- Connexion à une base de données MariaDB via JPA
- Insertion de nouveaux livres
- Recherche d’un livre par son identifiant

## 🛠️ Technologies utilisées

- Java 17+ (ou 11+)
- JPA avec Hibernate
- MariaDB
- Maven (optionnel, selon ton projet)

## 🗃️ Base de données

La base utilisée est appelée `bibliotheque`, avec une table `LIVRE`.

### 🧱 Structure de la table `LIVRE`

```sql
CREATE TABLE LIVRE (
  ID INT AUTO_INCREMENT PRIMARY KEY,
  TITRE VARCHAR(255),
  AUTEUR VARCHAR(255)
);
