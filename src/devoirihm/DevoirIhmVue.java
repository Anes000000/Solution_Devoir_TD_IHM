
package devoirihm;

import javafx.scene.text.Font;
import javafx.geometry.Pos;
import static javafx.geometry.Pos.CENTER;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DevoirIhmVue {
    private Label Result;
    private TextField N1,N2;
    RadioButton Soustraction,Somme;
    public DevoirIhmVue(Stage primaryStage) {
        VBox root0=new VBox();
        root0.setSpacing(10);
        root0.setAlignment(Pos.CENTER);

        GridPane root=new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        Label Number1=new Label("Number 1:");
        N1=new TextField("0");
        Label Number2=new Label("Number 2:");
        N2=new TextField("0");
        root.add(Number1, 1, 1);
        root.add(N1, 2, 1);
        root.add(Number2, 1, 2);
        root.add(N2, 2, 2);

        HBox choice=new HBox();
        choice.setSpacing(10);
        choice.setAlignment(CENTER);
        ToggleGroup tg=new ToggleGroup();
        Soustraction=new RadioButton("Soustraction");
        Somme=new RadioButton("Somme");
        Soustraction.setToggleGroup(tg);
        Somme.setToggleGroup(tg);
        choice.getChildren().addAll(Soustraction,Somme);

        Result=new Label("0");
        Result.setFont(new Font("Arial",20));

        root0.getChildren().addAll(root,choice,Result);
        Scene scene = new Scene(root0,250,150);
        primaryStage.setTitle("Devoir Ihm");
        primaryStage.setX(700);
        primaryStage.setY(300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public TextField getNumber1TF(){
        return this.N1;
    }
    public TextField getNumber2TF(){
        return this.N2;
    }
    public Label GetResultL(){
        return this.Result;
    }
    public RadioButton RadioSoustraction(){
        return this.Soustraction;
    }
     public RadioButton RadioSomme(){
        return this.Somme;
    }
}
