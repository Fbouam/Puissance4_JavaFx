import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurInfos implements EventHandler<ActionEvent> {
    private Puissance4 vueJeu;

    public ControleurInfos(Puissance4 vueJeu) {
        this.vueJeu = vueJeu;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.vueJeu.popUpReglesDuJeu().showAndWait();
    }
}
