package DevoirIhmWithObservers;

import javafx.application.Application;
import javafx.stage.Stage;

public class DevoirMainMethod extends Application {
    @Override
    public void start(Stage primaryStage) {
        Stage PrimaryStage0=new Stage();
DevoirIhmViewText DVT=new DevoirIhmViewText(primaryStage);
        DevoirIhmViewSpinner DVS=new DevoirIhmViewSpinner(PrimaryStage0);
        DevoirIhmModel model =new DevoirIhmModel();
        DevoirIhmController DIC = new DevoirIhmController(DVS,DVT,model);
        DIC.ControlSlidersNumbers();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
