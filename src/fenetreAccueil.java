import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class fenetreAccueil extends BorderPane{
    
    private Button bjouer;

    public fenetreAccueil(Button bjouer){
        super();
        this.bjouer = bjouer;

    }

    public BorderPane top(){
        BorderPane pane = new BorderPane();
        Label textTop = new Label("Bienvenue sur le Puissance 4");
        // Bouton sur la droite à rajouter
        pane.setLeft(textTop);
        return pane;
    }

    public VBox center(){
        VBox vbox = new VBox();
        Label labelChoisirNom = new Label("Choisissez un nom");
        HBox j1 = new HBox();
        HBox 
        return vbox;
    }
}
