import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import java.util.Optional;

public class ControleurRetourAccueil implements EventHandler<ActionEvent> {
    private Puissance4 vueJeu;

    public ControleurRetourAccueil(Puissance4 vueJeu) {
        this.vueJeu = vueJeu;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (vueJeu.partieEstEnCours()) {
            Alert alert = vueJeu.popUpPartieEnCours();
            alert.getButtonTypes().setAll(new ButtonType("Oui", ButtonBar.ButtonData.YES), new ButtonType("Non", ButtonBar.ButtonData.NO));
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get().getButtonData() == ButtonBar.ButtonData.YES) {
                vueJeu.modeAccueil();
                System.out.println("Retour à l'accueil et partie arrêtée.");
            } else {
                System.out.println("Reste dans la partie.");
            }
        } else {
            vueJeu.modeAccueil();
        }
    }
}
