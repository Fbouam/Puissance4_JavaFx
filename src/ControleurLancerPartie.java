import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurLancerPartie implements EventHandler<ActionEvent> {
    private Jeu jeu;
    private Puissance4 vue;

    public ControleurLancerPartie(Jeu jeu, Puissance4 vue) {
        this.jeu = jeu;
        this.vue = vue;
    }

    @Override
    public void handle(ActionEvent event) {
        if (verifierInformationsJoueurs()) {
            jeu.setJoueurs(vue.getTfJoueur1().getText(), vue.getTfJoueur2().getText(),
                vue.getComboBoxJoueur1().getValue(), vue.getComboBoxJoueur2().getValue());
            vue.lancePartie();
        }
    }

    private boolean verifierInformationsJoueurs() {
        boolean valid = true;

        if (vue.getTfJoueur1().getText().trim().isEmpty()) {
            vue.getErrorLabelJoueur1().setText("Nom requis");
            vue.getTfJoueur1().setStyle("-fx-border-color: red;");
            valid = false;
        } else {
            vue.getErrorLabelJoueur1().setText("");
            vue.getTfJoueur1().setStyle(null);
        }

        if (vue.getTfJoueur2().getText().trim().isEmpty()) {
            vue.getErrorLabelJoueur2().setText("Nom requis");
            vue.getTfJoueur2().setStyle("-fx-border-color: red;");
            valid = false;
        } else {
            vue.getErrorLabelJoueur2().setText("");
            vue.getTfJoueur2().setStyle(null);
        }

        if (vue.getComboBoxJoueur1().getValue() == null || vue.getComboBoxJoueur1().getValue().isEmpty()) {
            vue.getErrorLabelCouleur1().setText("Couleur requise");
            vue.getComboBoxJoueur1().setStyle("-fx-border-color: red;");
            valid = false;
        } else {
            vue.getErrorLabelCouleur1().setText("");
            vue.getComboBoxJoueur1().setStyle(null);
        }

        if (vue.getComboBoxJoueur2().getValue() == null || vue.getComboBoxJoueur2().getValue().isEmpty()) {
            vue.getErrorLabelCouleur2().setText("Couleur requise");
            vue.getComboBoxJoueur2().setStyle("-fx-border-color: red;");
            valid = false;
        } else {
            vue.getErrorLabelCouleur2().setText("");
            vue.getComboBoxJoueur2().setStyle(null);
        }

        if (vue.getComboBoxJoueur1().getValue().equals(vue.getComboBoxJoueur2().getValue())) {
            vue.getErrorLabelCouleur1().setText("Couleurs identiques");
            vue.getErrorLabelCouleur2().setText("Couleurs identiques");
            vue.getComboBoxJoueur1().setStyle("-fx-border-color: red;");
            vue.getComboBoxJoueur2().setStyle("-fx-border-color: red;");
            valid = false;
        }

        return valid;
    }
}
