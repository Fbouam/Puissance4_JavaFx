import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Contrôleur à activer lorsque l'on clique sur le bouton info
 */
public class ControleurInfo implements EventHandler<ActionEvent> {

    private Puissance4 appliP4;

    /**
     * @param p vue du jeu
     */
    public ControleurInfo(Puissance4 appliP4) {
        this.appliP4 = appliP4;
    }

    /**
     * L'action consiste à afficher une fenêtre popup précisant les règles du jeu.
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        this.appliP4.popUpReglesDuJeu().showAndWait();
    }
}