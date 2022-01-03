import java.util.Scanner;

/**
 * Université du Québec à Montréal (UQAM) Logiciel de réechantillonage.
 *
 * TP1 Réechantillonage : Classe principale de l'application de réechantillonage.
 * Ce programme lit un fichier de  valeurs  qui  représente  une  courbe.
 * Ensuite,  le  logiciel  va  rééchantillonner  les  points  sur  la  courbe  en
 * utilisant une méthode d’approximation.  Finalement, la nouvelle séquence de valeurs est affichée sur la console.
 *
 * @author Alexandre Laurin (LAUA23108205)
 * @Cours : INF2120 - 020 - Automne 2021
 * @Évaluation: TP1
 * @version 2021-10-07
 */

public class Principale {

    /**
     * Porte d'entree du programme de réechantillonage.
     * Lit un fichier, génère un échantillonage et affiche les valeurs des y réechantillonées.
     *
     * @param args tableau de String
     */
    public static void main(String[] args) {
        LecteurFichier valeursFichier = lireFichier();
        Reechantillonage reechantillonage = getReechantillonage(valeursFichier);
        reechantillonage.calculerYPrime();
        reechantillonage.afficherNouveauxY();
    }

    /**
     * Genere un reechantillonage selons le degree <code>k</code>.
     * La valeur <code>k</code> doit etre un entier entre 1 et 3 inclusivement.
     * Genere un message d'erreur et quitte le programme si <code>k</code> est introuvable ou invalide.
     *
     * @param valeursFichier instance du fichier a analyser.
     * @return Le reechantillonage generee.
     */
    private static Reechantillonage getReechantillonage(LecteurFichier valeursFichier) {
        Reechantillonage reechantillonage = null;
        switch (valeursFichier.getK()) {
            case 1 -> reechantillonage = new ReechantillonDegreUn(valeursFichier);
            case 2 -> reechantillonage = new ReechantillonDegreDeux(valeursFichier);
            case 3 -> reechantillonage = new ReechantillonDegreTrois(valeursFichier);
            default -> {
                System.err.println(Constantes.MSG_ERR_GENERIQUE);
                System.exit(-1);
            }
        }
        return reechantillonage;
    }

    /**
     * Lire le fichier de valeurs pour le reechantillonage.
     * L'utilisateur doit entrer le nom du fichier a lire.
     *
     * @return L'instance du fichier lu.
     */
    public static LecteurFichier lireFichier(){
        System.out.println(Constantes.MSG_ENTRE_NOM_FICHIER);
        Scanner clavier = new Scanner( System.in );
        LecteurFichier fichier = new LecteurFichier(clavier.nextLine());
        clavier.close();
        return fichier;
    }

}
