package devoirihm;

import javafx.geometry.Pos;
import static javafx.geometry.Pos.CENTER;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DevoirIhmViewSpinner {
             private Label ResultJ;
    private Spinner N1J,N2J;
    RadioButton SoustractionJ,SommeJ;
    public DevoirIhmViewSpinner(Stage stage){

        VBox root0=new VBox();//le noeud principale root0
        root0.setSpacing(10);
        root0.setAlignment(Pos.CENTER);

        GridPane root=new GridPane();// le noeud secondaire root
        root.setVgap(10);
        root.setHgap(10);
        Label Number1=new Label("Number 1:");//les labels et les spinners
        N1J=new Spinner(-100000000,1000000000,0);
        Label Number2=new Label("Number 2:");
        N2J=new Spinner(-100000000,1000000000,0);
        root.add(Number1, 1, 1);//ajouter les composants dans le noeud root
        root.add(N1J, 2, 1);
        root.add(Number2, 1, 2);
        root.add(N2J, 2, 2);

        HBox choice=new HBox();//le noeud secondaire choice
        choice.setSpacing(10);
        choice.setAlignment(CENTER);
        ToggleGroup tg=new ToggleGroup();//"toggleGroup" pour selectionner un seul bouton radio
        SoustractionJ=new RadioButton("Soustraction");//les boutons radio
        SommeJ=new RadioButton("Somme");
        SoustractionJ.setToggleGroup(tg);
        SommeJ.setToggleGroup(tg);
        choice.getChildren().addAll(SoustractionJ,SommeJ);//ajouter les bouttons radio dans le noeud choise

        ResultJ=new Label("0");//ajouter un label pour l'affichage
        ResultJ.setFont(new Font("Arial",20));

        root0.getChildren().addAll(root,choice,ResultJ);//ajouter les deux noeuds secondaires et le composant resultat dans le noeud principale
        Scene scene = new Scene(root0,250,150);
        stage.setTitle("Devoir Ihm Spinner");
        stage.setX(400);
        stage.setY(300);
        stage.setScene(scene);
       stage.show();
    }
      public <integer> Spinner  getNumber1TFJ(){
        return this.N1J;
    }
    public <integer> Spinner getNumber2TFJ(){
        return this.N2J;
    }
    public Label GetResultLJ(){
        return this.ResultJ;
    }
    public RadioButton RadioSoustractionJ(){
        return this.SoustractionJ;
    }
     public RadioButton RadioSommeJ(){
        return this.SommeJ;
    }
}
