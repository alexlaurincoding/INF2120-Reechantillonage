import java.util.ArrayList;
import java.util.Arrays;

/**
 * Université du Québec à Montréal (UQAM) Logiciel de réechantillonage.
 *
 * TP1 Réechantillonage : Cette classe calcul le reechantillonage de degree 2 du fichier entree.
 *
 * @author Alexandre Laurin (LAUA23108205)
 * @Cours : INF2120 - 020 - Automne 2021
 * @Évaluation: TP1
 * @version 2021-10-07
 */

public class ReechantillonDegreDeux extends ReechantillonDegreUn{

    protected double c = 0;
    ArrayList <Double> delta2 = new ArrayList<>(Arrays.asList(0.0, 0.0));

    /**
     * Constructeur prenant en argument l'instance du fichier lu.
     * La classe mere <code>Reechantillonage</code> extrait les valeurs necessaires au calcul du reechantillonage.
     *
     * @param fichier L'instance du fichier a traiter
     */
    public ReechantillonDegreDeux(LecteurFichier fichier) {
        super(fichier);
    }

    /**
     * Calculer les valeurs <code>delta</code>, <code>delta2</code>, <code>a</code>, <code>b</code> et <code>c</code>
     * necessaire au polynome de calcul de l'aproximation de degre 2 des y'.
     * Les valeurs de <code>x</code>, <code>y</code> et <code>h</code> sont recupere de la classe mere Reechantillonage.
     * Les valeurs <code>delta</code>, <code>a</code> et <code>b</code> sont declarer dans la classe
     * mere <code>ReechantillonDegreUn</code>.
     * Appel de la methode de calcul de <code>delta2</code>.
     * Appel de la methode de calcul du y' du polynome resultant.
     */
    public void calculerYPrime() {
        for (int i = 0; i < yOriginaux.size() -2; i++) {
            delta2.set(0, getDelta2(i, 2));
            a = delta2.get(0) / (2  * ( h * h));
            b = (delta.get(0) / h) - (a* (xOriginaux.get(i) + xOriginaux.get(i + 1)));
            c = yOriginaux.get(i) - (b * xOriginaux.get(i)) - (a * xOriginaux.get(i) * xOriginaux.get(i));
            calculPolynome(i);
        }
        for (int i = yOriginaux.size() -2 ; i < yOriginaux.size() -1; i++) {
            calculPolynome(i);
        }
    }


    /**
     * Calcul du delta de niveau 2
     * Les valeurs du tableaux <code>delta</code> sont ecraser a chaque appel de methode.
     * Le methode de calcul <code>getDelta</code> est reutilise de la classe mere.
     *
     * @param index L'index de la premiere valeur du tableau <code>yOriginaux</code> nécessaire au calcul.
     * @param nombreValeurs Le nombre de valeurs <code>delta</code> a calculer.
     * @return La valeur du <code>delta2</code>
     */
    protected double getDelta2(int index, int nombreValeurs) {
        double delta2;
        for (int j = 0; j < nombreValeurs; j++) {
            delta.set(j, getDelta(yOriginaux, index + j));
        }
        delta2 = getDelta(delta, 0);
        return delta2;
    }

    /**
     * Determine les valeurs de x' valide a ajouter l'interval en cours de calcul.
     * Calcul du y' a l'aide du polynome resultant.
     *
     * @param index l'indice du x minimum de l'interval en cours de calcul.
     */
    protected void calculPolynome(int index) {
        for (int j = 0; j < m; j++) {
            if (nouveauxX.get(j) < xOriginaux.get(index + 1) && nouveauxX.get(j) >= xOriginaux.get(index)) {
                double xPrime = nouveauxX.get(j);
                nouveauxY.add((a * (xPrime * xPrime)) + (b * xPrime) + c);
            }
        }
    }


    @Override
    public String toString() {
        return "ReechantillonDegreDeux : " +
                "\ny = " + nouveauxY.toString() + "\nx = " + nouveauxX.toString();
    }
}
