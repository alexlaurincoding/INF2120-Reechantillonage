import java.util.ArrayList;
import java.util.Arrays;

/**
 * Université du Québec à Montréal (UQAM) Logiciel de réechantillonage.
 *
 * TP1 Réechantillonage : Cette classe calcul le reechantillonage de degree 1 du fichier entree.
 *
 * @author Alexandre Laurin (LAUA23108205)
 * @Cours : INF2120 - 020 - Automne 2021
 * @Évaluation: TP1
 * @version 2021-10-07
 */

public class ReechantillonDegreUn extends Reechantillonage{
    ArrayList <Double> delta = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0));
    protected double a = 0;
    protected double b = 0;

    /**
     * Constructeur prenant en argument l'instance du fichier lu.
     * La classe mere Reechantillonage extrait les valeurs necessaires au calcul du reechantillonage.
     * @param fichier L'instance du fichier a traiter
     */
    public ReechantillonDegreUn(LecteurFichier fichier) {
        super(fichier);
    }

    /**
     * Calculer les valeurs <code>delta</code> <code>a</code> et <code>b</code> necessaire au polynome de calcul
     * de l'aproximation de degre 1 des y'.
     * Les valeurs de <code>x</code>, <code>y</code> et <code>h</code> sont recupere de la classe mere.
     * Appel de la methode de calcul du y' du polynome resultant.
     */
    public void calculerYPrime() {
        for (int i = 0; i < yOriginaux.size() -1; i++) {
            delta.set(0, getDelta(yOriginaux, i));
            a = delta.get(0) / h;
            b = yOriginaux.get(i) - ( a * xOriginaux.get(i) );
            calculPolynome(i);
        }
    }

    /**
     * Calcul du delta de niveau 1
     * @param valeurs La liste des valeurs nesessaire au calcul.
     * @param index L'index de la premiere valeur du tableau necesaire au calcul.
     * @return la valeur du delta
     */
    protected double getDelta(ArrayList<Double> valeurs, int index) {

        return valeurs.get(index + 1) - valeurs.get(index);
    }

    /**
     * Determine les valeurs de x' valide a ajouter a l'interval en cours de calcul.
     * Calcul du y' a l'aide du polynome resultant.
     * @param index l'indice du x minimum de l'interval en cours de calcul.
     */
    protected void calculPolynome(int index) {
        for (int j = 0; j < m; j++) {
            if(nouveauxX.get(j) < xOriginaux.get(index +1) && nouveauxX.get(j) >= xOriginaux.get(index)){
                nouveauxY.add((a * nouveauxX.get(j)) + b);
            }
        }
    }

    @Override
    public String toString() {
        return "ReechantillonDegreUn : " +
                "\ny = " + nouveauxY.toString() + "\nx = " + nouveauxX.toString();
    }
}
