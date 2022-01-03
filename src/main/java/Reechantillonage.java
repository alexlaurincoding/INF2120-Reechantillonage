import java.util.ArrayList;

/**
 * Université du Québec à Montréal (UQAM) Logiciel de réechantillonage.
 *
 * TP1 Réechantillonage : Cette classe est la classe mere abstraite des classes de reechantillonages.
 * Les valeurs nesessaires pour generer un reechantillonage sont recoltee a partir des valeurs lu dans le fichier.
 *
 * @author Alexandre Laurin (LAUA23108205)
 * @Cours : INF2120 - 020 - Automne 2021
 * @Évaluation: TP1
 * @version 2021-10-07
 */

public abstract class Reechantillonage {
    protected int k;
    protected int m;
    protected double h;
    protected double x0;
    protected ArrayList<Double> xOriginaux;
    protected ArrayList<Double> nouveauxX;
    protected ArrayList<Double> yOriginaux;
    protected ArrayList<Double> nouveauxY = new ArrayList<>();

    /**
     * Constructeur prenant en argument l'instance du fichier lu.
     * Extrait les valeurs necessaires au calcul du reechantillonage.
     *
     * @param fichier L'instance du fichier a traiter
     */
    public Reechantillonage(LecteurFichier fichier) {
        double hPrime = fichier.getHPrime();
        k = fichier.getK();
        yOriginaux = fichier.getListeYFichier();
        h = fichier.getH();
        x0 = fichier.getX0();
        m = calculerM(yOriginaux.size(), h, hPrime);
        xOriginaux = calculerX(x0, h, yOriginaux.size());
        nouveauxX = calculerX(x0, hPrime, m);
    }

    public abstract void calculerYPrime();
    protected abstract void calculPolynome(int index);

    /**
     * Calcul des valeurs de x selons les valeurs du fichier.
     *
     * @param x0 La valeur du premier x.
     * @param h La distance entre les x.
     * @param nombreX Le nombre de x voulu.
     * @return Un tableau des valeurs de x sous forme de ArrayListe.
     */
    private ArrayList<Double> calculerX(double x0, double h, int nombreX) {
        ArrayList<Double> listeX = new ArrayList<>();
        listeX.add(x0);
        for (int i = 0; i < nombreX -1 ; i++) {
            listeX.add(listeX.get(i) + h);
        }
        return listeX;
    }

    /**
     * Affiche a la console les valeurs de y' apres le reechantillonage.
     */
    public void afficherNouveauxY(){
        for (Double aDouble : nouveauxY) {
            System.out.println(aDouble);
        }
    }

    /**
     * Calculer la valeur de <code>m</code> correspondant au nombre de valeurs attendue de x' et de y' apres
     * le reechantillonage.
     *
     * @param n le nombre de y present dans le fichier d'origine.
     * @param h La distance entre les x originaux.
     * @param hPrime La distance entre les x' apres reechantillonage.
     * @return La valeur de m
     */
    private int calculerM(int n, double h, double hPrime) {

        return (int)((( n - 1 ) * h ) / hPrime ) + 1;
    }

}
