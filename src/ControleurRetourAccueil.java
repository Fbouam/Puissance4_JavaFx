import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import java.util.Optional;

/**
 * Contrôleur à activer lorsque l'on clique sur le bouton Accueil
 */
public class ControleurRetourAccueil implements EventHandler<ActionEvent> {
    /**
     * modèle du jeu
     */

     /**
     * vue du jeu
     **/
    private Puissance4 vueJeu;

    /**
     * @param modelePendu modèle du jeu
     * @param vueJeu vue du jeu
     */
    public ControleurRetourAccueil(Puissance4 vueJeu) {
        this.vueJeu = vueJeu;
        }


    /**
     * L'action consiste à retourner sur la page d'accueil. Il faut vérifier qu'il n'y avait pas une partie en cours
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        this.vueJeu.modeAccueil();
    }
}