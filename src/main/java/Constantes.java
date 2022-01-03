public class Constantes {

    /**
     * Cette classe contient les constantes utilisée par le programme.
     */

    //Messages d'erreurs
    public static final String MSG_FICHIER_INTROUVABLE = "Le fichier demander est introuvable.";
    public static final String MSG_ERR_LIGNE_UN_ENTIER = "Erreur : La premiere ligne du fichier n'est pas un entier.";
    public static final String MSG_ERR_LIGNE_UN_BORNES = "Erreur : La premiere ligne du fichier doit etre un entier " +
            "entre " + Constantes.k_MIN + " et " + Constantes.k_MAX + " inclusivement";
    public static final String MSG_ERR_lIGNE_DEUX = "Erreur : La ligne deux du fichier doit etre un nombre" +
            " positif representant x0";
    public static final String MSG_ERR_LIGNE_TROIS = "Erreur : La ligne trois du fichier doit etre un nombre" +
            " positif plus grand que zero representant h.";
    public static final String MSG_ERR_LIGNE_QUATRE = "Erreur : La ligne quatre du fichier doit etre un nombre" +
            " positif plus grand que zero representant h'.";
    public static final String MSG_ERR_STRING = "Erreur : Le fichier doit contenir que des nombres.";
    public static final String MSG_ERR_GENERIQUE = "Une erreur s'est produite";

    //valeurs min et max pour k
    public static final int k_MIN = 1;
    public static final int k_MAX = 3;

    //Messages utilisateur
    public static final String MSG_ENTRE_NOM_FICHIER = "Veuillez entrer le nom du fichier a lire : ";
}
