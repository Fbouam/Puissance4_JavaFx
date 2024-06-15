public class Jeu {
    private Joueur joueur1;
    private Joueur joueur2;

    public void setJoueurs(String nomJoueur1, String nomJoueur2, String couleurJoueur1, String couleurJoueur2) {
        this.joueur1 = new Joueur(nomJoueur1, couleurJoueur1);
        this.joueur2 = new Joueur(nomJoueur2, couleurJoueur2);
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public boolean areNomsDifferents() {
        return !joueur1.getNom().equals(joueur2.getNom());
    }
}
