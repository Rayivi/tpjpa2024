# TP JPA 2024 UniR

## Auteur
- @author Ayivi Ruth
- @author ASSOUGNON K Samuel 

## État d'avancement
Nous avons implémenté les fonctionnalités de base de l'application, y compris la gestion des concerts et des tickets.
Nous avons également ajouté une hiérarchie de classes pour différents types de tickets (PremiumTicket et LastMinuteTicket) et une requête nommée pour récupérer les tickets d'un concert donné.
Une partie de DAO fait. Pas encore de DTO.
Création de Servlet qui consomme les données d’un formulaire.

## Fonctionnalités
### Fonctionnalités qui marchent
- Création et persistance des artistes et des concerts en exécutant le fichier `EventTest.java`.
- Création et persistance des tickets, y compris les tickets premium et les tickets de dernière minute.
- Requête nommée pour récupérer les tickets d'un concert donné.
- Utilisation des Criteria Queries pour effectuer des requêtes.

### Fonctionnalités qui ne marchent pas encore
- Gestion des exceptions et des erreurs après une première exécution de l' `EvenTest.java`.
- Ajout des éléments dans la base de données via formulaire.

## Démarrage du projet
### Prérequis
- Java 11 ou supérieur
- Maven
- Une base de données relationnelle (par exemple, PostgreSQL)

### Instructions
1. Cloner le dépôt :
    ```bash
    git clone https://github.com/Rayivi/tpjpa2024
    cd tpjpa2024
    ```

2. Configurer la base de données :
    Démarrage de la base de données
    - windows :
- exécuter le script `run-hsqldb-server.bat` pour démarrer la base de donnée.
- exécuter le script `show-hsqldb-server.bat` pour démarrer le Manager.
    - linux :
- exécuter le script `run-hsqldb-server.sh` pour démarrer la base de donnée.
- exécuter le script `show-hsqldb-server.sh` pour démarrer le Manager.

    ou 

- Créer une base de données PostgreSQL.
- Mettre à jour le fichier `persistence.xml` avec les informations de connexion à la base de données.

3. Lancer l'application web :
    ```bash
    mvn compile jetty:run
    ```
    Ensuite dans le navigateur de votre choix : http://localhost:8080 .

## Prochaines tâches
- Mettre en place d'autres héritages
- DAO et DTO
- Retour des informations issues de la base de données via page web.
- Faire la partie 2 JaxRS et OpenAPI du TP5

