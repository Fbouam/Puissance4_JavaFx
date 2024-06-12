public class Joueur {
    private String nom;
    private char symbole; 
    private int score;

    public Joueur(String nom, char symbole) {
        this.nom = nom;
        this.symbole = symbole;
        this.score = 0;
    }

    public String getNom() {
        return nom;
    }

    public char getSymbole() {
        return symbole;
    }

    public int getScore() {
        return score;
    }

    public void incrementerScore() {
        this.score++;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                ", symbole=" + symbole +
                ", score=" + score +
                '}';
    }
}
