import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Contrôleur à activer lorsque l'on clique sur le bouton paramètres
 */
public class ControleurParametre implements EventHandler<ActionEvent> {

    private Puissance4 appliP4;

    /**
     * @param p vue du jeu
     */
    public ControleurParametre(Puissance4 appliP4) {
        this.appliP4 = appliP4;
    }

    /**
     * L'action consiste à afficher la page des paramètres.
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        this.appliP4.modeParametre();
    }
}
