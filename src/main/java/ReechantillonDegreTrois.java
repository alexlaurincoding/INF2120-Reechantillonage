/**
 * Université du Québec à Montréal (UQAM) Logiciel de réechantillonage.
 *
 * TP1 Réechantillonage : Cette classe calcul le reechantillonage de degree 3 du fichier entree.
 *
 * @author Alexandre Laurin (LAUA23108205)
 * @Cours : INF2120 - 020 - Automne 2021
 * @Évaluation: TP1
 * @version 2021-10-07
 */
public class ReechantillonDegreTrois extends ReechantillonDegreDeux{
    double delta3;
    private double d = 0;

    /**
     * Constructeur prenant en argument l'instance du fichier lu.
     * La classe mere <code>Reechantillonage</code> extrait les valeurs necessaires au calcul du reechantillonage.
     *
     * @param fichier L'instance du fichier a traiter
     */
    public ReechantillonDegreTrois(LecteurFichier fichier) {
        super(fichier);
    }

    /**
     * Calculer les valeurs <code>delta</code>, <code>delta2</code>, <code>delta3</code> <code>a</code>,
     * <code>b</code>, <code>c</code> et <code>d</code> necessaire au polynome de calcul de l'aproximation
     * de degre 3 des y'.
     * Les valeurs de <code>x</code>, <code>y</code> et <code>h</code> sont recupere de la classe mere Reechantillonage.
     * Les valeurs <code>delta</code>, <code>a</code> et <code>b</code> sont declarer dans la classe
     * mere <code>ReechantillonDegreUn</code>.
     * Les valeurs <code>delta2</code> et <code>c</code> sont declarer dans la classe
     * mere <code>ReechantillonDegreDeux</code>.
     * Appel de la methode de calcul de <code>delta3</code>.
     * Appel de la methode de calcul du y' du polynome resultant.
     */

    public void calculerYPrime() {
        for (int i = 0; i < yOriginaux.size() -3; i++) {
            delta3 = getDelta3(i);
            a = delta3 / (6  *  Math.pow(h, 3));
            b = (delta2.get(0) / (2 * Math.pow(h, 2))) - (a * (xOriginaux.get(i) + xOriginaux.get(i + 1)
                    + xOriginaux.get(i + 2)));
            c = (delta.get(0) / h) - (b * (xOriginaux.get(i) + xOriginaux.get(i + 1))) - ( a *
                    (Math.pow(xOriginaux.get(i), 2) + (xOriginaux.get(i) * xOriginaux.get(i+1)) +
                            Math.pow(xOriginaux.get(i+1), 2) ));
            d = yOriginaux.get(i) - (c * xOriginaux.get(i)) - (b * Math.pow(xOriginaux.get(i), 2)) -
                    (a * Math.pow(xOriginaux.get(i), 3));
            calculPolynome(i);
        }
        for (int i = yOriginaux.size() -3 ; i < yOriginaux.size() -1; i++) {
            calculPolynome(i);
        }
    }

    /**
     * Calcul du delta de niveau 3
     * Les valeurs des tableaux <code>delta</code> et <code>delta2</code> sont ecraser a chaque appel de methode.
     * Les methodes <code>getDelta</code> et <code>getDelta2</code> des classes meres sont réutiliser pour le calcul.
     *
     * @param index L'index de la premiere valeur du tableau <code>yOriginaux</code> nécessaire au calcul.
     * @return La valeur du delta 3
     */
    private double getDelta3( int index ) {
        getDelta2(index, 3);
        for (int j = 0; j < 2; j++) {
            delta2.set(j, getDelta(delta, j));
        }
        delta3 = getDelta(delta2, 0);
        return delta3;
    }

    /**
     * Determine les valeurs de x' valide a ajouter a l'interval en cours de calcul.
     * Calcul du y' correspondant au x' a l'aide du polynome resultant.
     *
     * @param index l'indice du x minimum de l'interval en cours de calcul.
     */
    protected void calculPolynome( int index ) {
        for (int j = 0; j < m; j++) {
            if (nouveauxX.get(j) < xOriginaux.get(index + 1) && nouveauxX.get(j) >= xOriginaux.get(index)) {
                double xPrime = nouveauxX.get(j);
                nouveauxY.add((a * Math.pow(xPrime, 3)) + (b * Math.pow(xPrime, 2)) + (c * xPrime) + d);
            }
        }
    }

    @Override
    public String toString() {
        return "ReechantillonDegreTrois : " +
                "\ny = " + nouveauxY.toString() + "\nx = " + nouveauxX.toString();
    }

}
