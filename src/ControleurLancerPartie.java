import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import java.util.Optional;

/**
 * Contrôleur pour gérer le lancement ou la réinitialisation d'une partie de Puissance4.
 */
public class ControleurLancerPartie implements EventHandler<ActionEvent> {
    private Puissance4 vueJeu; // Vue associée au jeu de Puissance4

    /**
     * Constructeur du contrôleur.
     * @param vueJeu vue du jeu de Puissance4
     */
    public ControleurLancerPartie(Puissance4 vueJeu) {
        this.vueJeu = vueJeu;
    }

    /**
     * Méthode gérant les actions à effectuer lors du clic sur le bouton pour lancer ou redémarrer une partie.
     * @param actionEvent l'événement déclenché par le clic sur le bouton
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        Optional<ButtonType> reponse = this.vueJeu.popUpPartieEnCours().showAndWait(); 
        if (reponse.isPresent() && reponse.get().equals(ButtonType.YES)) {
            System.out.println("Ok !");
            this.vueJeu.modeJeu(); 
        } else {
            System.out.println("D'ac !");
        }
    }
}