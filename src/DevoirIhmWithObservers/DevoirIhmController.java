package DevoirIhmWithObservers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class DevoirIhmController {
    public DevoirIhmViewSpinner ViewSpinner;
    public DevoirIhmViewText ViewText;
    public DevoirIhmModel model;
    public DevoirIhmController(DevoirIhmViewSpinner VSlider, DevoirIhmViewText VText, DevoirIhmModel Model){
    ViewSpinner=VSlider;
    ViewText=VText;
    model=Model;
    }
    public void ControlSlidersNumbers(){
        //selectionnement par default des boutons radio pour la premiére et la deusiémme vue:
            ViewSpinner.getAddS().setSelected(true);
            ViewText.getAddT().setSelected(true);

            //initialiser les textfield a 0:
            ViewText.GetTextField1().setText("0");
            ViewText.GetTextField2().setText("0");

            //ajouter un ecouteur dans le spinner N°1:
        ViewSpinner.GetSpinner1().valueProperty().addListener((Observale,OldValue,NewValue)->{
                    model.SetNumber1S(ViewSpinner.GetSpinner1());//affecter la valeur de spinner N°1 au model
             ViewText.GetTextField1().setText(Integer.toString(model.getNumber1()));//et au textfield N°1
                    if (ViewSpinner.getAddS().isSelected()) {
                        //affecter le resultat au label 'result' de la vue 'ViewText' et 'ViewSpinner' :
                        ViewSpinner.GetResultS().setText(Integer.toString(model.Add()));
                        ViewText.GetResultT().setText(Integer.toString(model.Add()));
                    } else {
                        //la meme chose avec la soustraction:
                        ViewSpinner.GetResultS().setText(Integer.toString(model.Substract()));
                        ViewText.GetResultT().setText(Integer.toString(model.Substract()));
                    }

            });

        //ajouter un ecouteur dans le spinner N°2 'la meme chose' :
        ViewSpinner.GetSpinner2().valueProperty().addListener((Observale,OldValue,NewValue)->{
                    model.SetNumber2S(ViewSpinner.GetSpinner2());
                    ViewText.GetTextField2().setText(Integer.toString(model.getNumber2()));
                    if (ViewSpinner.getAddS().isSelected()) {
                        ViewSpinner.GetResultS().setText(Integer.toString(model.Add()));
                        ViewText.GetResultT().setText(Integer.toString(model.Add()));
                    } else {
                        ViewSpinner.GetResultS().setText(Integer.toString(model.Substract()));
                        ViewText.GetResultT().setText(Integer.toString(model.Substract()));
                    }
            });

            //ajouter un ecouteur dans le textfield N°1
            ViewText.GetTextField1().textProperty().addListener((Observable,OldValue,NewValue)->{
                if(ViewText.GetTextField1().getText().isEmpty()||ViewText.GetTextField2().getText().isEmpty())
               //initialiser les valeurs de model a 0 dans le cas ou le textfield est vide "null"
                    model.init();
                else{
                    //sinon:
                    //affecter le resultat au label 'result' de la vue 'ViewText' et 'ViewSpinner' :
                model.SetNumber1T(ViewText.GetTextField1());
                ViewSpinner.GetSpinner1().getValueFactory().setValue(model.getNumber1());
                }
            });
         //ajouter un ecouteur dans le textfield N°2 'la meme chose' :
        ViewText.GetTextField2().textProperty().addListener((Observable,OldValue,NewValue)->{
            if(ViewText.GetTextField1().getText().isEmpty()||ViewText.GetTextField2().getText().isEmpty())
                model.init();
            else{
            model.SetNumber2T(ViewText.GetTextField2());
            ViewSpinner.GetSpinner2().getValueFactory().setValue(model.getNumber2());
            }
        });
               //synchroniser    les  boutons     radio    de   "ViewText"   et   "ViewSpinner"   :

        //bouton radio de la somme dans la vue 'ViewText':
        ViewText.getAddT().setOnAction(Event-> {
            ViewSpinner.getAddS().setSelected(true);
            ViewText.GetResultT().setText(Integer.toString(model.Add()));
            ViewSpinner.GetResultS().setText(Integer.toString(model.Add()));
        });
        //bouton radio de la soustraction dans la vue 'ViewText':
        ViewText.getSubstractT().setOnAction(Event-> {
           ViewSpinner.getSubstractS().setSelected(true);
            ViewText.GetResultT().setText(Integer.toString(model.Add()));
            ViewSpinner.GetResultS().setText(Integer.toString(model.Add()));
        });
        //bouton radio de la somme dans la vue 'ViewSpinner':
        ViewSpinner.getAddS().setOnAction(Event-> {
            ViewText.getAddT().setSelected(true);
            ViewSpinner.GetResultS().setText(Integer.toString(model.Add()));
            ViewText.GetResultT().setText(Integer.toString(model.Add()));
        });
        //bouton radio de la soustraction dans la vue 'ViewSpinner':
        ViewSpinner.getSubstractS().setOnAction(Event-> {
            ViewText.getSubstractT().setSelected(true);
            ViewSpinner.GetResultS().setText(Integer.toString(model.Substract()));
            ViewText.GetResultT().setText(Integer.toString(model.Substract()));
        });

         //ceci est pour forcer la valeur de textfield1 pour etre un entier
        ViewText.GetTextField1().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    ViewText.GetTextField1().setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        //ceci est pour forcer la valeur de textfield2 pour etre un entier
        ViewText.GetTextField2().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    ViewText.GetTextField2().setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        }
    }
