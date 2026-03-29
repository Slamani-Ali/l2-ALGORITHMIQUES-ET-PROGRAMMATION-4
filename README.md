# l2-ALGORITHMIQUES-ET-PROGRAMMATION-4
#  Analyse de la Complexité des Algorithmes de Tri

Projet réalisé dans le cadre du module **Algorithmes et Programmation 4** à l'Université Le Havre Normandie (ULHN).

##  Auteurs
* **Slamani Ali**
* **Tarzani Yassin**

---

##  Présentation du Projet
L'objectif de ce projet est d'étudier le comportement de différents algorithmes de tri en comparant leurs performances théoriques et réelles. Nous mesurons trois indicateurs clés :
1.  **Temps d'exécution** (en millisecondes).
2.  **Nombre de comparaisons** entre les éléments.
3.  **Nombre d'affectations** (mouvements de données en mémoire).

### Algorithmes implémentés
* **Tri par Insertion (Classique)** : Complexité théorique en $O(n^2)$.
* **Tri par Insertion (Dichotomique)** : Utilise la recherche binaire pour réduire les comparaisons, mais reste en $O(n^2)$ pour les affectations.
* **Tri Fusion (Merge Sort)** : Algorithme récursif performant en $O(n \log n)$.
* **Tri par Dénombrement (Counting Sort)** : Tri linéaire en $O(n + k)$, extrêmement rapide sur des entiers.

---

##  Résultats des Benchmarks

D'après nos tests (basés sur les fichiers `.csv` générés), voici un aperçu des performances pour un tableau de **50 000 éléments** :

| Algorithme | Temps (ms) | Comparaisons | Affectations |
| :--- | :--- | :--- | :--- |
| **Insertion Classique** | ~2104 ms | 624 597 503 | 624 647 513 |
| **Insertion Dicho** | ~2014 ms | 711 372 | 625 189 477 |
| **Tri Fusion** | < 10 ms | ~700 000 | ~1 000 000 |
| **Dénombrement** | < 1 ms | 49 999 | 150 012 |

> **Analyse :** On remarque que le tri par insertion dichotomique divise le nombre de comparaisons par 1000, mais son temps global ne baisse presque pas car le nombre d'**affectations** reste identique au tri classique.

---

##  Structure du Dépôt

* `Element.java` : Définition de l'objet à trier (clé/contenu).
* `tabElement.java` : Contient toutes les méthodes de tri et les compteurs.
* `TestsDesTris.java` : Classe de test qui génère les données aléatoires et exporte les fichiers CSV.
* `*.csv` : Résultats bruts des mesures de performance.

---

##  Installation et Utilisation

1. **Cloner le projet** :
   ```bash
   git clone [https://github.com/VOTRE_NOM_UTILISATEUR/NOM_DU_REPO.git](https://github.com/VOTRE_NOM_UTILISATEUR/NOM_DU_REPO.git)

    Compiler les sources :
    Bash

javac *.java

Lancer les tests :
Bash

    java TestsDesTris

 Conclusion

Ce projet démontre l'importance du choix de l'algorithme selon la taille des données. Alors que le tri par insertion devient inutilisable au-delà de 100 000 éléments, le Tri Fusion et le Tri par Dénombrement restent stables et extrêmement rapides.
