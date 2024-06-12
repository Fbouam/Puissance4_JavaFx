public class Grille {
    private Jeton[][] grille;
    private int lignes;
    private int colonnes;

    public Grille(int lignes, int colonnes){
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.grille = new Jeton[lignes][colonnes];
    }

    public boolean ajouterJeton(int colonne, Jeton jeton){
        for (int i = lignes - 1; i >= 0; i--){
            if (grille[i][colonne] == null){
                grille[i][colonne] = jeton;
                return true;
            }
        }
        return false;
    }
    
    public boolean detecteAlignement(){
        return verifierAlignementHorizontal() || verifierAlignementVertical() || verifierAlignementDiagonale();
    }

    private boolean verifierAlignementHorizontal(){
        for (int i = 0; i < lignes; i++){
            for (int j = 0; j < colonnes - 3; j++){
                if (grille[i][j] != null && 
                    grille[i][j].getSymbole() == grille[i][j + 1].getSymbole() &&
                    grille[i][j].getSymbole() == grille[i][j + 2].getSymbole() &&
                    grille[i][j].getSymbole() == grille[i][j + 3].getSymbole()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verifierAlignementVertical() {
        for (int j = 0; j < colonnes; j++) {
            for (int i = 0; i < lignes - 3; i++) {
                if (grille[i][j] != null && 
                    grille[i][j].getSymbole() == grille[i + 1][j].getSymbole() &&
                    grille[i][j].getSymbole() == grille[i + 2][j].getSymbole() &&
                    grille[i][j].getSymbole() == grille[i + 3][j].getSymbole()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verifierAlignementDiagonale() {
        // Diagonale de haut à gauche à bas à droite
        for (int i = 0; i < lignes - 3; i++) {
            for (int j = 0; j < colonnes - 3; j++) {
                if (grille[i][j] != null && 
                    grille[i][j].getSymbole() == grille[i + 1][j + 1].getSymbole() &&
                    grille[i][j].getSymbole() == grille[i + 2][j + 2].getSymbole() &&
                    grille[i][j].getSymbole() == grille[i + 3][j + 3].getSymbole()) {
                    return true;
                }
            }
        }

        // Diagonale de bas à gauche à haut à droite
        for (int i = 3; i < lignes; i++) {
            for (int j = 0; j < colonnes - 3; j++) {
                if (grille[i][j] != null && 
                    grille[i][j].getSymbole() == grille[i - 1][j + 1].getSymbole() &&
                    grille[i][j].getSymbole() == grille[i - 2][j + 2].getSymbole() &&
                    grille[i][j].getSymbole() == grille[i - 3][j + 3].getSymbole()) {
                    return true;
                }
            }
        }
        return false;
    }

     public Jeton getSymbole(int ligne, int colonne) {
        return grille[ligne][colonne];
    }
}