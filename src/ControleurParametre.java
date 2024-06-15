import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurParametre implements EventHandler<ActionEvent> {
    private Puissance4 appliP4;

    public ControleurParametre(Puissance4 appliP4) {
        this.appliP4 = appliP4;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.appliP4.modeParametres();
    }
}
