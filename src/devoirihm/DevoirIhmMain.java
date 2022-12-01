
package devoirihm;

import javafx.application.Application;
import javafx.stage.Stage;
public class DevoirIhmMain extends Application{
    @Override
    public void start(Stage stage1){
        Stage stage2=new Stage();
        DevoirIhmModel m1=new DevoirIhmModel();
        DevoirIhmVue v1=new DevoirIhmVue(stage1);
        DevoirIhmViewSpinner vs=new DevoirIhmViewSpinner(stage2);
        DevoirIhmController c1=new DevoirIhmController(m1,v1,vs);
        c1.HandleMV();c1.HandleMVS();
    }
    public static void main(String[] args) {launch(args);}
}
