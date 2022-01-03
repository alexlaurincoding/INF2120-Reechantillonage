# INF2120-Reechantillonage

## Ce programme va recevoir en entrées une suite 
de valeurs qui représente une courbe. Ensuite, le logiciel va rééchantillonner les points sur la courbe en 
utilisant une méthode d’approximation. Finalement, la nouvelle séquence de valeurs est affichée sur la console. 
Les points en entrées sont équidistants sur l'axe des x, cette distance sera dénotée ℎ. Les points en sorties 
seront aussi équidistants, la distance entre deux points en sortie sera dénotée ℎ′.

### Dans un premier temps, votre application devra lire le nom d’un fichier au clavier. Ensuite, il devra lire les 
entrées dans ce fichier. Le fichier va contenir une valeur par ligne. La première valeur (𝜅𝜅) sera un entier entre 
1 et 3 inclusivement. Il représente le degré de l’équation utilisé pour trouver les valeurs du rééchantillonnage. 
Ces équations sont décrites plus loin dans le texte.
Les valeurs suivantes sont de type double. Elle représente la valeur : 𝑥𝑥0. Elle est suivi de la distance (ℎ) sur 
l’axe des 𝑥𝑥 entre deux valeurs avant rééchantillonnage. Ensuite, il y a une valeur représentant la distance (ℎ′) 
sur l’axe des 𝑥𝑥 entre deux valeurs après rééchantillonnage.
Finalement, il y aura une suite de n valeurs, toutes de type double, qui représente les échantillons (𝑦𝑦𝑖𝑖 | 0 ≤
i < n). Maintenant que nous connaissons ces valeurs, nous pouvons déduire les valeurs des xi = x0 + i × ℎ.
Exemple de valeurs dans un fichier :
```
2
1.0
5.0
2.0
3.0
4.0
8.5
9.1
1.2
```
Explications des valeur du fichier
```
k=2
x0=1.0
ℎ =5.0
ℎ′=2.0
y0=3.0
y1=4.0
y2=8.5
y3=9.1
y4=1.2
```
Toute information incorrecte implique l’affichage d’un message d’erreur et la fin du programme
