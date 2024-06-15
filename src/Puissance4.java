import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Puissance4 extends Application {
    /**
     * Chronomètre utilisé pour mesurer la durée de la partie.
     */
    private Chronometre chrono;

    /**
     * Bouton pour lancer une nouvelle partie.
     */
    private Button bJouer;

    /**
     * Bouton pour revenir à l'accueil.
     */
    private Button boutonMaison;

    /**
     * Bouton pour accéder aux paramètres du jeu.
     */
    private Button boutonParametres;

    /**
     * Bouton pour afficher les informations du jeu.
     */
    private Button boutonInfo;

    /**
     * Pane principal qui contient les différents éléments de l'interface utilisateur.
     */
    private BorderPane panelCentral;

    /**
     * Champ de texte pour entrer le nom du joueur 1.
     */
    private TextField tfJoueur1;

    /**
     * Champ de texte pour entrer le nom du joueur 2.
     */
    private TextField tfJoueur2;

    /**
     * ComboBox pour sélectionner la couleur du joueur 1.
     */
    private ComboBox<String> comboBoxJoueur1;

    /**
     * ComboBox pour sélectionner la couleur du joueur 2.
     */
    private ComboBox<String> comboBoxJoueur2;

    /**
     * Label pour afficher les erreurs liées au nom du joueur 1.
     */
    private Label errorLabelJoueur1;

    /**
     * Label pour afficher les erreurs liées au nom du joueur 2.
     */
    private Label errorLabelJoueur2;

    /**
     * Label pour afficher les erreurs liées à la couleur du joueur 1.
     */
    private Label errorLabelCouleur1;

    /**
     * Label pour afficher les erreurs liées à la couleur du joueur 2.
     */
    private Label errorLabelCouleur2;

    /**
     * Constante indiquant le nombre de lignes dans la grille de jeu.
     */
    private static final int LIGNES = 6;

    /**
     * Constante indiquant le nombre de colonnes dans la grille de jeu.
     */
    private static final int COLONNES = 7;

    /**
     * Booléen indiquant si une partie est en cours.
     */
    private boolean partieEnCours;

    /**
     * Instance de la classe GestionVue pour gérer l'affichage.
     */
    // private GestionVue gestionVue;

    /**
     * Instance de la classe Jeu pour gérer la logique du jeu.
     */
    private Jeu jeu;

    /**
     * Chaine de caractères indiquant le thème sélectionné (clair ou sombre).
     */
    private String themeCourant = "clair";


    @Override
    public void init() {
        this.panelCentral = new BorderPane();
        this.partieEnCours = false;
        this.jeu = new Jeu();
    }

    private Scene laScene() {
        BorderPane fenetre = new BorderPane();
        fenetre.setTop(this.banniere());
        fenetre.setCenter(this.panelCentral);
        return new Scene(fenetre, 800, 1000);
    }

    private Pane banniere() {
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(30));

        Text titre = new Text("Puissance 4");
        titre.setFont(Font.font("Arial", 40));
        titre.setStyle("-fx-font-weight: bold");

        Image img1 = new Image("file:img/home.png");
        ImageView view1 = new ImageView(img1);
        view1.setFitHeight(30);
        view1.setFitWidth(30);
        this.boutonMaison = new Button();
        this.boutonMaison.setGraphic(view1);
        Tooltip tlp_maison = new Tooltip("Appuyez pour revenir à l'accueil");
        tlp_maison.setShowDelay(Duration.seconds(0));
        this.boutonMaison.setTooltip(tlp_maison);
        this.boutonMaison.setOnAction(new ControleurRetourAccueil(this));

        Image img2 = new Image("file:img/parametres.png");
        ImageView view2 = new ImageView(img2);
        view2.setFitHeight(30);
        view2.setFitWidth(30);
        this.boutonParametres = new Button();
        this.boutonParametres.setGraphic(view2);
        Tooltip tlp_parametre = new Tooltip("Appuyez pour consulter les paramètres du jeu");
        tlp_parametre.setShowDelay(Duration.seconds(0));
        this.boutonParametres.setTooltip(tlp_parametre);
        this.boutonParametres.setOnAction(new ControleurParametre(this));

        Image img3 = new Image("file:img/info.png");
        ImageView view3 = new ImageView(img3);
        view3.setFitHeight(30);
        view3.setFitWidth(30);
        this.boutonInfo = new Button();
        this.boutonInfo.setGraphic(view3);
        Tooltip tlp_info = new Tooltip("Appuyez pour consulter les informations du jeu");
        tlp_info.setShowDelay(Duration.seconds(0));
        this.boutonInfo.setTooltip(tlp_info);
        this.boutonInfo.setOnAction(new ControleurInfos(this));

        bp.setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, null, null)));
        bp.setLeft(titre);

        HBox hb = new HBox(5);
        hb.getChildren().addAll(this.boutonMaison, this.boutonParametres, this.boutonInfo);
        bp.setRight(hb);

        return bp;
    }

    private Pane fenetreAccueil() {
        VBox accueil = new VBox(15);
        accueil.setPadding(new Insets(15));

        GridPane gpParamPartie = new GridPane();
        gpParamPartie.setVgap(10);
        gpParamPartie.setHgap(10);

        Label choix_nom = new Label("Choisissez un nom");
        gpParamPartie.add(choix_nom, 0, 0);

        Label joueur1 = new Label("Joueur 1");
        this.tfJoueur1 = new TextField();
        this.errorLabelJoueur1 = new Label();
        this.errorLabelJoueur1.setTextFill(Color.RED);
        gpParamPartie.add(joueur1, 0, 1);
        gpParamPartie.add(this.tfJoueur1, 1, 1);
        gpParamPartie.add(this.errorLabelJoueur1, 2, 1);

        Label joueur2 = new Label("Joueur 2");
        this.tfJoueur2 = new TextField();
        this.errorLabelJoueur2 = new Label();
        this.errorLabelJoueur2.setTextFill(Color.RED);
        gpParamPartie.add(joueur2, 0, 2);
        gpParamPartie.add(this.tfJoueur2, 1, 2);
        gpParamPartie.add(this.errorLabelJoueur2, 2, 2);

        Label choix_couleur = new Label("Choisissez une couleur");
        gpParamPartie.add(choix_couleur, 0, 3);

        this.comboBoxJoueur1 = new ComboBox<>();
        comboBoxJoueur1.getItems().addAll("", "Rouge", "Jaune");
        this.errorLabelCouleur1 = new Label();
        this.errorLabelCouleur1.setTextFill(Color.RED);
        gpParamPartie.add(new Label("Joueur 1"), 0, 4);
        gpParamPartie.add(comboBoxJoueur1, 1, 4);
        gpParamPartie.add(this.errorLabelCouleur1, 2, 4);

        this.comboBoxJoueur2 = new ComboBox<>();
        comboBoxJoueur2.getItems().addAll("", "Rouge", "Jaune");
        this.errorLabelCouleur2 = new Label();
        this.errorLabelCouleur2.setTextFill(Color.RED);
        gpParamPartie.add(new Label("Joueur 2"), 0, 5);
        gpParamPartie.add(comboBoxJoueur2, 1, 5);
        gpParamPartie.add(this.errorLabelCouleur2, 2, 5);

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

        HBox hboxButtons = new HBox(15);
        hboxButtons.setPadding(new Insets(15));
        hboxButtons.setAlignment(Pos.CENTER);

        Button btnReset = new Button("Reset");
        btnReset.setOnAction(e -> reset());
        hboxButtons.getChildren().add(btnReset);

        this.bJouer = new Button("Lancer Partie");
        bJouer.setOnAction(new ControleurLancerPartie(jeu, this));
        hboxButtons.getChildren().add(bJouer);

        accueil.getChildren().addAll(gpParamPartie, hboxButtons);

        return accueil;
    }

    private void reset() {
        this.tfJoueur1.clear();
        this.tfJoueur2.clear();
        this.comboBoxJoueur1.getSelectionModel().clearSelection();
        this.comboBoxJoueur2.getSelectionModel().clearSelection();
        this.comboBoxJoueur1.getItems().setAll("", "Rouge", "Jaune");
        this.comboBoxJoueur2.getItems().setAll("", "Rouge", "Jaune");
        resoudreErreur();
    }

    public void resoudreErreur() {
        tfJoueur1.setStyle(null);
        tfJoueur2.setStyle(null);
        comboBoxJoueur1.setStyle(null);
        comboBoxJoueur2.setStyle(null);
        errorLabelJoueur1.setText("");
        errorLabelJoueur2.setText("");
        errorLabelCouleur1.setText("");
        errorLabelCouleur2.setText("");
    }

    public Alert popUpPartieEnCours() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "La partie est en cours!\n Etes-vous sûr de l'interrompre ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        alert.setHeaderText("ATTENTION !");
        return alert;
    }

    public Alert popUpReglesDuJeu() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "Règles du Puissance 4 :\n\n" +
                        "1. Objectif : aligner 4 jetons de la même couleur. \n\n" +
                        "2. Déroulement : chaque joueur choisit une couleur. Tour à tour, les joueurs insèrent un jeton dans une colonne.\n\n" +
                        "3. Victoire : aligner 4 jetons horizontalement, verticalement ou en diagonale.\n\n" +
                        "4. Égalité : Grille pleine sans alignement.");
        alert.setWidth(600);
        alert.setTitle("Règle du jeu");
        alert.setHeaderText("Bienvenue au jeu du Puissance 4 !");
        return alert;
    }

    private TitledPane leChrono() {
        TitledPane chrono = new TitledPane("Chronomètre", this.chrono);
        chrono.setCollapsible(false);
        return chrono;
    }

    private Pane fenetreJeu() {
        BorderPane jeu = new BorderPane();
        jeu.setPadding(new Insets(15));
    
        // En-tête avec le texte "En attente de [nom du joueur qui doit jouer]" et le chronomètre
        HBox header = new HBox(15);
        header.setPadding(new Insets(15));
        header.setAlignment(Pos.CENTER);
    
        Label lblEnAttente = new Label("En attente de " + this.jeu.getJoueur1().getNom());
        lblEnAttente.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        header.getChildren().add(lblEnAttente);
    
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        header.getChildren().add(spacer);
    
        TitledPane chronoPane = this.leChrono();
        header.getChildren().add(chronoPane);
    
        // Grille de jeu
        GridPane gpGrilleJeu = new GridPane();
        gpGrilleJeu.setVgap(5);
        gpGrilleJeu.setHgap(5);
        gpGrilleJeu.setAlignment(Pos.CENTER);
        gpGrilleJeu.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, new CornerRadii(20), new Insets(0, 150, 0, 150))));
    
        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                Button cell = new Button();
                cell.setPrefSize(60, 60); // Taille fixe des cellules
                cell.setMaxSize(Double.MAX_VALUE, 60); // Fixe la hauteur mais permet l'extension en largeur
                cell.setStyle("-fx-background-color: lightgrey; -fx-background-radius: 30;");
                gpGrilleJeu.add(cell, j, i);
            }
        }
    
        gpGrilleJeu.setMaxHeight(60 * LIGNES);
        gpGrilleJeu.setMinHeight(60 * LIGNES);
    
        // Boutons en bas
        HBox hboxControls = new HBox(15);
        hboxControls.setPadding(new Insets(15));
        hboxControls.setAlignment(Pos.CENTER);
    
        Button btnRejouer = new Button("Rejouer");
        hboxControls.getChildren().add(btnRejouer);
    
    
        // Ajouter les composants au BorderPane
        jeu.setTop(header);
        BorderPane.setAlignment(header, Pos.CENTER);
    
        jeu.setCenter(gpGrilleJeu);
        BorderPane.setAlignment(gpGrilleJeu, Pos.CENTER);
    
        jeu.setBottom(hboxControls);
        BorderPane.setAlignment(hboxControls, Pos.CENTER);
    
        return jeu;
    }
    



    /**
     * @return la page des paramètres
     */
    private Pane fenetreParamètres(){
        VBox vb_parametres = new VBox(15);
        vb_parametres.setPadding(new Insets(15));
        
        Label titre = new Label("Paramètres du jeu");
        titre.setFont(Font.font("Arial", 20));
        titre.setStyle("-fx-font-weight: bold");

        GridPane gp_parametres = new GridPane();
        gp_parametres.setPadding(new Insets(15));
        gp_parametres.setHgap(20);

        Label choix_theme = new Label("Choix du thème: ");
        choix_theme.setStyle("-fx-font-weight: bold");
        choix_theme.setFont(Font.font("Arial", 15));
        gp_parametres.add(choix_theme, 0, 0);

        ToggleGroup tgp_parametres = new ToggleGroup();

        RadioButton theme_clair = new RadioButton("Clair");
        theme_clair.setToggleGroup(tgp_parametres);
        theme_clair.setOnAction(new ControleurTheme(this, "clair"));
        gp_parametres.add(theme_clair, 1, 0);

        RadioButton theme_sombre = new RadioButton("Sombre");
        theme_sombre.setToggleGroup(tgp_parametres);
        theme_sombre.setOnAction(new ControleurTheme(this, "sombre"));
        gp_parametres.add(theme_sombre, 2, 0);

        if (this.themeCourant.equals("clair")) {
            theme_clair.setSelected(true);
        } else {
            theme_sombre.setSelected(true);
        }

        vb_parametres.getChildren().addAll(titre, gp_parametres);

        return vb_parametres;
    }

    /**
     * Permet de changer le thème du jeu (clair ou sombre)
     * @param theme Une chaîne de caractère indiquant le thème choisi (clair ou sombre)
     */
    public void setThemeJeu(String theme){
        Scene page = this.panelCentral.getScene();
        this.themeCourant = theme;
        if(theme.equals("clair")){
            page.getStylesheets().remove("themeSombre.css");
            page.getStylesheets().add("themeClair.css");
        }
        else{
            page.getStylesheets().remove("themeClair.css");
            page.getStylesheets().add("themeSombre.css");
        }
    }

    public void modeAccueil() {
        this.panelCentral.setCenter(fenetreAccueil());
        this.boutonMaison.setDisable(true);
        this.boutonParametres.setDisable(false);
    }

    public void modeJeu() {
        this.panelCentral.setCenter(fenetreJeu());
        this.boutonMaison.setDisable(false);
        this.boutonParametres.setDisable(true);
    }

    public void modeParametres() {
        this.panelCentral.setCenter(fenetreParamètres());
        this.boutonMaison.setDisable(false);
        this.boutonParametres.setDisable(true);
    }

    public void lancePartie() {
        modeJeu();
        this.chrono.resetTime();
        this.chrono.start();
        this.partieEnCours = true;
    }

    public boolean partieEstEnCours() {
        return this.partieEnCours;
    }

    public TextField getTfJoueur1() {
        return this.tfJoueur1;
    }

    public TextField getTfJoueur2() {
        return this.tfJoueur2;
    }

    public ComboBox<String> getComboBoxJoueur1() {
        return this.comboBoxJoueur1;
    }

    public ComboBox<String> getComboBoxJoueur2() {
        return this.comboBoxJoueur2;
    }

    public Label getErrorLabelJoueur1() {
        return this.errorLabelJoueur1;
    }

    public Label getErrorLabelJoueur2() {
        return this.errorLabelJoueur2;
    }

    public Label getErrorLabelCouleur1() {
        return this.errorLabelCouleur1;
    }

    public Label getErrorLabelCouleur2() {
        return this.errorLabelCouleur2;
    }


    @Override
    public void start(Stage stage) {
        stage.setTitle("IUTEAM'S - La plateforme de jeux de l'IUTO");
        Scene scene = this.laScene();
        stage.setScene(scene);
        this.modeAccueil();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
