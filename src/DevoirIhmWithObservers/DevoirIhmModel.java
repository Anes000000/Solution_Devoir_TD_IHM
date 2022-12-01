package DevoirIhmWithObservers;

import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class DevoirIhmModel {
    private int number1=0;
    private int number2=0;
    public void SetNumber1T(TextField textfield){
       number1 = Integer.parseInt(textfield.getText());
    }
    public void SetNumber2T(TextField textfield){
        number2 = Integer.parseInt(textfield.getText());
    }
 public void init(){
        number1=0;number2=0;
 }
    public void SetNumber1S(Spinner spinner){
        number1 = (int) spinner.getValue();
    }
    public void SetNumber2S(Spinner spinner){
        number2 = (int) spinner.getValue();
    }
    public int getNumber1(){
        return(number1);
    }
    public int getNumber2(){
        return(number2);
    }
    public int Add(){
        return(number1+number2);
    }
    public int Substract(){
        return(number1-number2);
    }
}
