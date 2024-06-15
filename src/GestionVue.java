// import javafx.scene.control.ComboBox;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;

// public class GestionVue {
//     private TextField tfJoueur1;
//     private TextField tfJoueur2;
//     private ComboBox<String> comboBoxJoueur1;
//     private ComboBox<String> comboBoxJoueur2;
//     private Label errorLabelJoueur1;
//     private Label errorLabelJoueur2;
//     private Label errorLabelCouleur1;
//     private Label errorLabelCouleur2;

//     public GestionVue(TextField tfJoueur1, TextField tfJoueur2, ComboBox<String> comboBoxJoueur1, ComboBox<String> comboBoxJoueur2, Label errorLabelJoueur1, Label errorLabelJoueur2, Label errorLabelCouleur1, Label errorLabelCouleur2) {
//         this.tfJoueur1 = tfJoueur1;
//         this.tfJoueur2 = tfJoueur2;
//         this.comboBoxJoueur1 = comboBoxJoueur1;
//         this.comboBoxJoueur2 = comboBoxJoueur2;
//         this.errorLabelJoueur1 = errorLabelJoueur1;
//         this.errorLabelJoueur2 = errorLabelJoueur2;
//         this.errorLabelCouleur1 = errorLabelCouleur1;
//         this.errorLabelCouleur2 = errorLabelCouleur2;
//     }

//     public void afficherErreur1(TextField field, Label label, String message) {
//         field.setStyle("-fx-border-color: red;");
//         label.setText(message);
//     }

//     public void afficherErreur2(ComboBox<String> comboBox, Label label, String message) {
//         comboBox.setStyle("-fx-border-color: red;");
//         label.setText(message);
//     }

//     public void clearErreurs() {
//         tfJoueur1.setStyle(null);
//         tfJoueur2.setStyle(null);
//         comboBoxJoueur1.setStyle(null);
//         comboBoxJoueur2.setStyle(null);
//         errorLabelJoueur1.setText("");
//         errorLabelJoueur2.setText("");
//         errorLabelCouleur1.setText("");
//         errorLabelCouleur2.setText("");
//     }

//     public TextField getTfJoueur1() {
//         return tfJoueur1;
//     }

//     public TextField getTfJoueur2() {
//         return tfJoueur2;
//     }

//     public ComboBox<String> getComboBoxJoueur1() {
//         return comboBoxJoueur1;
//     }

//     public ComboBox<String> getComboBoxJoueur2() {
//         return comboBoxJoueur2;
//     }

//     public Label getErrorLabelJoueur1() {
//         return errorLabelJoueur1;
//     }

//     public Label getErrorLabelJoueur2() {
//         return errorLabelJoueur2;
//     }

//     public Label getErrorLabelCouleur1() {
//         return errorLabelCouleur1;
//     }

//     public Label getErrorLabelCouleur2() {
//         return errorLabelCouleur2;
//     }

//     public void maj(Jeu jeu) {
//         jeu.getJoueur1().setNom(tfJoueur1.getText().trim());
//         jeu.getJoueur1().setCouleur(comboBoxJoueur1.getValue());
//         jeu.getJoueur2().setNom(tfJoueur2.getText().trim());
//         jeu.getJoueur2().setCouleur(comboBoxJoueur2.getValue());
//     }
// }
