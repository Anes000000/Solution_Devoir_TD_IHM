package DevoirIhmWithObservers;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DevoirIhmViewText {
    private TextField Number1;
    private TextField Number2;
    private Label resultT;

    private RadioButton Add,Substract;
    public DevoirIhmViewText (Stage primaryStage) {
        VBox root0=new VBox();root0.setAlignment(Pos.CENTER); root0.setSpacing(10);//principal node
        Scene scene=new Scene(root0,300,150);

        HBox root1=new HBox();root1.setAlignment(Pos.CENTER); root1.setSpacing(10);//number1 node
        Label label1=new Label("Number1:");
        Number1=new TextField();
        root1.getChildren().addAll(label1, Number1);

        HBox root2=new HBox();root2.setAlignment(Pos.CENTER); root2.setSpacing(10);//number2 node
        Label label2=new Label("Number2:");
        Number2=new TextField();
        root2.getChildren().addAll(label2,Number2);

        HBox root3=new HBox();
        ToggleGroup tg=new ToggleGroup();                //Radio Buttons
        Substract=new RadioButton("Soustraction");
        Add=new RadioButton("Somme");
        Substract.setToggleGroup(tg);
        Add.setToggleGroup(tg);
        root3.setAlignment(Pos.CENTER);
        root3.getChildren().addAll(Add,Substract);//adding the radio buttons in the root3

         resultT=new Label("0");//result item
        resultT.setFont(new Font("Arial",20));

        root0.getChildren().addAll(root1,root2,root3,resultT);//joining the 3 nodes and the result in the principale node

        primaryStage.setScene(scene);//associating the scene to the stage
        primaryStage.setTitle("Text View");
        primaryStage.show();
    }
    public TextField GetTextField1(){
        return(Number1);
    }
    public TextField GetTextField2(){
        return(Number2);
    }
    public Label GetResultT(){
        return(resultT);
    }
    public RadioButton getAddT(){return(Add);}
    public RadioButton getSubstractT(){return(Substract);}
}
