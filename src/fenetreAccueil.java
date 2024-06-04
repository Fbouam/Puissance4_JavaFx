import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class fenetreAccueil extends BorderPane{
    
    private Button bjouer;

    public fenetreAccueil(Button bjouer){
        super();
        this.bjouer = bjouer;
        this.setTop(top());
        this.setCenter(center());
        // this.setBottom(bot());
    }

    public BorderPane top(){
        BorderPane pane = new BorderPane();
        Label textTop = new Label("Bienvenue sur le Puissance 4");
        textTop.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        // Bouton sur la droite à rajouter
        pane.setLeft(textTop);
        pane.setPadding(new Insets(15));
        return pane;
    }

    public VBox center(){
        VBox vbox = new VBox();
        Label lj1 = new Label("Joueur 1");
        Label lj2 = new Label("Joueur 2");

        Label labelChoisirNom = new Label("Choisissez un nom");

        HBox j1 = new HBox();
        j1.setSpacing(10);
        TextField tfj1 = new TextField();
        j1.getChildren().addAll(lj1, tfj1);

        HBox j2 = new HBox();
        TextField tfj2 = new TextField();
        j2.getChildren().addAll(lj2, tfj2);
        j2.setSpacing(10);

        Label labelChoisirCouleur = new Label("Choisissez une couleur");

        HBox cj1 = new HBox();
        ColorPicker colorPickerJ1 = new ColorPicker();
        cj1.getChildren().addAll(lj1, colorPickerJ1);
        cj1.setSpacing(10);

        HBox cj2 = new HBox();
        
        ColorPicker colorPickerJ2 = new ColorPicker();
        cj2.getChildren().addAll(lj2, colorPickerJ2);
        cj2.setSpacing(10);
        
        this.bjouer = new Button("Lancer partie");

        vbox.getChildren().addAll(labelChoisirNom, j1, j2, labelChoisirCouleur, cj1, cj2, this.bjouer);
        vbox.setPadding(new Insets(15));
        vbox.setSpacing(10);
        return vbox;
    }

    // public VBox bot(){
    //     VBox bot = new VBox();
        
    //     bot.getChildren().add(this.bjouer);
    //     bot.setAlignment(Pos.CENTER_RIGHT);
    //     return bot;
    // }
}
