import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Université du Québec à Montréal (UQAM) Logiciel de réechantillonage.
 *
 * TP1 Réechantillonage : Cette classe lit et traite les valeurs numeriques d'un fichier et assigne ces valeurs
 * aux variables appropriées.
 *
 * @author Alexandre Laurin (LAUA23108205)
 * @Cours : INF2120 - 020 - Automne 2021
 * @Évaluation: TP1
 * @version 2021-10-07
 */
public class LecteurFichier {

    private final String nomFichier;
    private int k;
    private double x0;
    private double h;
    private double hPrime;
    private final ArrayList<Double> listeYFichier = new ArrayList<>();

    /**
     * Constructeur prenant en argument le nom du fichier a lire
     * Appelle la methode lire.
     *
     * @param nomFichier Le nom du fichier a analyser
     */
    public LecteurFichier(String nomFichier){
        this.nomFichier = nomFichier;
        lire();
    }

    /**
     * Cette methode lit le fichier passe en argument dans le constructeur.
     * Appel des methodes pour extraire les donnees et les mettre dans les variables appropriees.
     * Si une exception est generer par les differentes methodes appelée, un message d'erreur est afficher et le
     * programme se termine avec le statut -1.
     */
    public void lire(){
        try {
            FileReader fr = new FileReader(nomFichier);
            BufferedReader fichier = new BufferedReader(fr);
            Scanner sc = new Scanner(fichier);

            sc.useLocale( Locale.CANADA );

            setK(sc);
            setX0(sc);
            setH(sc);
            setHPrime(sc);
            setListeYFichier(sc);

            sc.close();
        } catch ( FileNotFoundException e ) {
            System.err.println(Constantes.MSG_FICHIER_INTROUVABLE);
            System.exit( -1 );
        } catch ( IOException e ) {
            System.err.println(e.getMessage());
            System.exit( -1 );
        }
    }

    /**
     * Lit un entier dans le fichier et l'assigne a la variable <code>k</code>
     *
     * @param sc L'instance de Scanner qui lit le fichier
     * @throws IOException Une exception est lancee si la valeur n'est pas un entier compris entre 1 et 3.
     */
    private void setK(Scanner sc) throws IOException {
        if(sc.hasNextInt() ) {
            k = sc.nextInt();
            if(k < Constantes.k_MIN || k > Constantes.k_MAX){
                throw new IOException(Constantes.MSG_ERR_LIGNE_UN_BORNES);
            }
        }else{
            throw new IOException(Constantes.MSG_ERR_LIGNE_UN_ENTIER);
        }
    }

    /**
     * Lit un double dans le fichier et l'assigne a la variable <code>x0</code>
     *
     * @param sc L'instance de <code>Scanner</code> qui lit le fichier
     * @throws IOException Une exception est lancee si la valeur n'est pas un nombre positif.
     */
    private void setX0(Scanner sc) throws IOException {
        if( sc.hasNextDouble()) {
            x0 = sc.nextDouble();
            if (x0 < 0){
                throw new IOException(Constantes.MSG_ERR_lIGNE_DEUX);
            }
        }else{
            throw new IOException(Constantes.MSG_ERR_lIGNE_DEUX);
        }

    }

    /**
     * Lit un double dans le fichier et l'assigne a la variable <code>h</code>
     *
     * @param sc L'instance de Scanner qui lit le fichier
     * @throws IOException Une exception est lancee si la valeur n'est pas un nombre positif plus grand que zero.
     */
    private void setH(Scanner sc) throws IOException {
        if( sc.hasNextDouble() ) {
            h = sc.nextDouble();
            if (h <= 0){
                throw new IOException(Constantes.MSG_ERR_LIGNE_TROIS);
            }
        }else{
            throw new IOException(Constantes.MSG_ERR_LIGNE_TROIS);
        }
    }

    /**
     * Lit un double dans le fichier et l'assigne a la variable <code>hPrime</code>
     *
     * @param sc L'instance de Scanner qui lit le fichier
     * @throws IOException Une exception est lancee si la valeur n'est pas un nombre positif plus grand que zero.
     */
    private void setHPrime(Scanner sc) throws IOException {
        if( sc.hasNextDouble() ) {
            hPrime = sc.nextDouble();
            if (hPrime <= 0){
                throw new IOException(Constantes.MSG_ERR_LIGNE_QUATRE);
            }
        }else{
            throw new IOException(Constantes.MSG_ERR_LIGNE_QUATRE);
        }
    }

    /**
     * Lit un les valeurs double restant dans le fichier et les ajoute au ArrayListe <code>yOriginaux</code>.
     *
     * @param sc L'instance de Scanner qui lit le fichier
     * @throws IOException Une exception est lancee une valeur rencontrée n'est pas un nombre.
     */
    private void setListeYFichier(Scanner sc) throws IOException {
        while(sc.hasNext()){
            if(sc.hasNextDouble()){
                listeYFichier.add(sc.nextDouble());
            }else{
                throw new IOException(Constantes.MSG_ERR_STRING);
            }
        }
    }

    public int getK() {
        return k;
    }

    public double getX0() {
        return x0;
    }

    public double getH() {
        return h;
    }

    public double getHPrime() {
        return hPrime;
    }

    public ArrayList<Double> getListeYFichier() {
        return listeYFichier;
    }

    @Override
    public String toString() {
        return "Nom du fichier : " + this.nomFichier +
                "\nk = " + k +
                "\nx0 = " + x0 +
                "\nh = " + h +
                "\ny = " + listeYFichier;
    }
}
