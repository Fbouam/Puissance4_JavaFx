import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Puissance4 extends Application{
    /**
     * le chronomètre qui sera géré par une clasee à implémenter
     */
    private Chronometre chrono;
    /**
     * le bouton qui permet de (lancer ou relancer une partie
     */ 
    private Button bJouer;
    /**
     * le bouton Accueil / Maison
     */    
    private Button boutonMaison;
    /**
     * le bouton Paramètre / Engrenage
     */
    private Button boutonParametres;

    /**
     * le bouton Info
     */    
    private Button boutonInfo;
    /**
     * le panel Central qui pourra être modifié selon le mode (accueil ou jeu)
     */
    private BorderPane panelCentral;
    /**
     * le champs où le joueur1 renseigne son nom
     */
    private TextField tfJoueur1;
    /**
     * le champs où le joueur2 renseigne son nom
     */
    private TextField tfJoueur2;
        /**
     * la liste déroulante permettant le choix d'une couleur
     */
    private ComboBox<String> comboBoxJoueur1;
    /**
     * la liste déroulante permettant le choix d'une couleur
     */
    private ComboBox<String> comboBoxJoueur2;


    
    @Override
    public void init(){
        this.panelCentral = new BorderPane();
    }

    /**
     * @return le graphe de scène de la vue à partir de methodes précédantes
     */
    private Scene laScene(){
        BorderPane fenetre = new BorderPane();
        fenetre.setTop(this.banniere());
        fenetre.setCenter(this.panelCentral);
        return new Scene(fenetre, 800, 1000);
    }


    private Pane banniere(){
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(30));
    
        // Titre
        Text titre = new Text("Puissance 4");
        titre.setFont(Font.font("Arial", 40));
        titre.setStyle("-fx-font-weight: bold");
    
        // Bouton "Accueil"
        Image img1 = new Image("file:img/home.png");
        ImageView view1 = new ImageView(img1);
        view1.setFitHeight(30);
        view1.setFitWidth(30);
        this.boutonMaison = new Button();
        this.boutonMaison.setGraphic(view1);
        Tooltip tlp_maison = new Tooltip("Appuyez pour revenir à l'accueil");
        tlp_maison.setShowDelay(Duration.seconds(0));
        this.boutonMaison.setTooltip(tlp_maison);
        // this.boutonMaison.setOnAction(new RetourAccueil(null, this));
    
        // Bouton "Paramètres"
        Image img2 = new Image("file:img/parametres.png");
        ImageView view2 = new ImageView(img2);
        view2.setFitHeight(30);
        view2.setFitWidth(30);
        this.boutonParametres = new Button();
        this.boutonParametres.setGraphic(view2);
        Tooltip tlp_parametre = new Tooltip("Appuyez pour consulter les paramètres du jeu");
        tlp_parametre.setShowDelay(Duration.seconds(0));
        this.boutonParametres.setTooltip(tlp_parametre);
        // this.boutonParametres.setOnAction(new ControleurParametres(this));
    
        // Bouton "Info"
        Image img3 = new Image("file:img/info.png");
        ImageView view3 = new ImageView(img3);
        view3.setFitHeight(30);
        view3.setFitWidth(30);
        this.boutonInfo = new Button();
        this.boutonInfo.setGraphic(view3);
        Tooltip tlp_info = new Tooltip("Appuyez pour consulter les informations du jeu");
        tlp_info.setShowDelay(Duration.seconds(0));
        this.boutonInfo.setTooltip(tlp_info);
        // this.boutonInfo.setOnAction(new ControleurInfos(this));
    
        // Couleur de la bannière
        bp.setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE,null,null)));
        bp.setLeft(titre);
    
        // Hbox pour les trois boutons
        HBox hb = new HBox(5);
        hb.getChildren().addAll(this.boutonMaison, this.boutonParametres, this.boutonInfo);
        bp.setRight(hb);
    
        return bp;
    }


    /**
     * @return la fenêtre d'accueil sur laquelle on peut choisir les paramètres de jeu
     */
    private Pane fenetreAccueil() {
        VBox accueil = new VBox(15);
        accueil.setPadding(new Insets(15));

        GridPane gpParamPartie = new GridPane();
        gpParamPartie.setVgap(10);
        gpParamPartie.setHgap(10);

        Label choix_nom = new Label("Choisissez un nom");
        choix_nom.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gpParamPartie.add(choix_nom, 0, 0);

        Label joueur1 = new Label("Joueur 1");
        this.tfJoueur1 = new TextField();
        gpParamPartie.add(joueur1, 0, 1);
        gpParamPartie.add(this.tfJoueur1, 1, 1);

        Label joueur2 = new Label("Joueur 2");
        this.tfJoueur2 = new TextField();
        gpParamPartie.add(joueur2, 0, 2);
        gpParamPartie.add(this.tfJoueur2, 1, 2);

        Label choix_couleur = new Label("Choisissez une couleur");
        choix_couleur.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gpParamPartie.add(choix_couleur, 0, 3);

        ComboBox<String> comboBoxJoueur1 = new ComboBox<>();
        comboBoxJoueur1.getItems().addAll("","Rouge", "Jaune");
        gpParamPartie.add(new Label("Joueur 1"), 0, 4);
        gpParamPartie.add(comboBoxJoueur1, 1, 4);

        ComboBox<String> comboBoxJoueur2 = new ComboBox<>();
        comboBoxJoueur2.getItems().addAll("","Rouge", "Jaune");
        gpParamPartie.add(new Label("Joueur 2"), 0, 5);
        gpParamPartie.add(comboBoxJoueur2, 1, 5);

        comboBoxJoueur1.valueProperty().addListener((observable, ancienChoix, nouveauChoix) -> {
            if (nouveauChoix != null) {
                comboBoxJoueur2.getItems().remove(nouveauChoix);
                if (ancienChoix != null) {
                    comboBoxJoueur2.getItems().add(ancienChoix);
                }
            }
        });

        comboBoxJoueur2.valueProperty().addListener((observable, ancienChoix, nouveauChoix) -> {
            if (nouveauChoix != null) {
                comboBoxJoueur1.getItems().remove(nouveauChoix);
                if (ancienChoix != null) {
                    comboBoxJoueur1.getItems().add(ancienChoix);
                }
            }
        });

        //Boutons lancer partie et Reset
        HBox hboxButtons = new HBox(15);
        hboxButtons.setPadding(new Insets(15));
        hboxButtons.setAlignment(Pos.CENTER);

        Button btnReset = new Button("Reset");
        btnReset.setOnAction(e -> reset());
        hboxButtons.getChildren().add(btnReset);

        Button btnLancerPartie = new Button("Lancer Partie");
        hboxButtons.getChildren().add(btnLancerPartie);

        accueil.getChildren().addAll(gpParamPartie, hboxButtons);


        accueil.getChildren().add(gpParamPartie);
        return accueil;
    }

    private void reset(){
        this.tfJoueur1.clear();
        this.tfJoueur2.clear();
        this.comboBoxJoueur1.getSelectionModel().clearSelection();
        this.comboBoxJoueur2.getSelectionModel().clearSelection();
        this.comboBoxJoueur1.getItems().setAll("", "Rouge", "Jaune");
        this.comboBoxJoueur2.getItems().setAll("", "Rouge", "Jaune");
    }

    /**
     * Affiche la page d'accueil
     */
    public void modeAccueil() {
        this.panelCentral.setCenter(fenetreAccueil());
        this.boutonMaison.setDisable(true);
        this.boutonParametres.setDisable(false);
    }


    /**
     * @return le panel du chronomètre
     */
    private TitledPane leChrono(){
        TitledPane chrono = new TitledPane("Chronomètre", this.chrono);
        chrono.setCollapsible(false);
        return chrono;
    }


    /**
     * créer le graphe de scène et lance le jeu
     * @param stage la fenêtre principale
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("IUTEAM'S - La plateforme de jeux de l'IUTO");
        Scene scene = this.laScene();
        stage.setScene(scene);
        this.modeAccueil();
        stage.show();
    }

    /**
     * Programme principal
     * @param args inutilisé
     */
    public static void main(String[] args) {
        launch(args);
    }    
}