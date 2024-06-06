public class Jeton {
    private char symbole; 
    private Joueur proprietaire; 

    public Jeton(char symbole, Joueur proprietaire) {
        this.symbole = symbole;
        this.proprietaire = proprietaire;
    }

    public char getSymbole() {
        return symbole;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    @Override
    public String toString() {
        return "Jeton{" +
                "symbole=" + symbole +
                ", proprietaire=" + proprietaire +
                '}';
    }
}
