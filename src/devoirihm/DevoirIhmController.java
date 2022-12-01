package devoirihm;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class DevoirIhmController {
    private DevoirIhmModel model;
    private DevoirIhmVue vue;
    private DevoirIhmViewSpinner vuespinner;

    public DevoirIhmController(DevoirIhmModel m, DevoirIhmVue v, DevoirIhmViewSpinner vs) {
        model = m;
        vue = v;
        vuespinner = vs;
    }

    public void HandleMV() {//pour la vue des TextFields

        //capter l'event dans le textfield "number1" pour calculer le resultat et envoyer la valeur a spinner 1
        vue.getNumber1TF().setOnKeyTyped(Event -> {
            //pour assurer que le textfield n'est pas vide
            if(!vue.getNumber1TF().getText().isEmpty()) {
                //pour envoyer les valeurs a le model:
                model.setNumbers(vue.getNumber1TF().getText(), vue.getNumber2TF().getText());
                //pour affecter la valeur au spinner 1: de la deuxiéme scene:
                vuespinner.getNumber1TFJ().getValueFactory().setValue(Integer.parseInt(vue.getNumber1TF().getText()));
                //pour faire la somme ou la soustraction dépend du bouton radio sélectionné:
                if (vue.RadioSomme().isSelected()) {
                    vue.GetResultL().setText(model.AddAndGetResult());
                    vuespinner.GetResultLJ().setText(model.AddAndGetResult());
                } else {
                    vue.GetResultL().setText(model.SousAndGetResult());
                    vuespinner.GetResultLJ().setText(model.SousAndGetResult());
                }

            }else{
                //si le textfield est vide on initialise les valeurs de model et de spinner1 a 0
                model.setNumbersInt(0,0);
                vuespinner.getNumber1TFJ().getValueFactory().setValue(0);
            }
        });

        //<<<<<<<<<<<<la méme chose pour TextField "number2">>>>>>>>>>>>>
        //capter l'event dans le tectfield "number2" pour calculer le resultat et envoyer la valeur a spinner 2:
        vue.getNumber2TF().setOnKeyTyped(Event -> {
            if (!vue.getNumber2TF().getText().isEmpty()) {
                model.setNumbers(vue.getNumber1TF().getText(), vue.getNumber2TF().getText());
                vuespinner.getNumber2TFJ().getValueFactory().setValue(Integer.parseInt(vue.getNumber2TF().getText()));
                if (vue.RadioSomme().isSelected()) {
                    vue.GetResultL().setText(model.AddAndGetResult());
                    vuespinner.GetResultLJ().setText(model.AddAndGetResult());
                } else {
                    vue.GetResultL().setText(model.SousAndGetResult());
                    vuespinner.GetResultLJ().setText(model.SousAndGetResult());
                }
            }else{
                //si le textfield est vide on initialise les valeurs de model et de spinner2 a 0
                model.setNumbersInt(0,0);
                vuespinner.getNumber2TFJ().getValueFactory().setValue(0);
            }
        });

        //capter l'événement lorsque en cliquant sur l'un des boutons radio:
        //pour bouton somme:
        vue.RadioSomme().setOnAction(Event0 -> {
            vuespinner.RadioSommeJ().setSelected(true);//selectionner le bouton de l'autre scene
            vue.GetResultL().setText(model.AddAndGetResult());//calculer le resultat
            vuespinner.GetResultLJ().setText(model.AddAndGetResult());//envoyer le resultat dans l'autre scene
        });
        //pour bouton soustraction <<<<la méme chose>>>>>> :
        vue.RadioSoustraction().setOnAction(Event00 -> {
            vuespinner.RadioSoustractionJ().setSelected(true);
            vue.GetResultL().setText(model.SousAndGetResult());
            vuespinner.GetResultLJ().setText(model.SousAndGetResult());
        });

        //frocer le textfield1 pour étre un entier:
        vue.getNumber1TF().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    vue.getNumber1TF().setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        //frocer le textfield2 pour étre un entier:
        vue.getNumber2TF().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    vue.getNumber2TF().setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    public void HandleMVS() {//pour la vue des spinners <<<<<<la meme chose>>>>>>>>

            vuespinner.getNumber1TFJ().setOnMouseClicked(Event -> {
                model.setNumbersInt((Integer) vuespinner.getNumber1TFJ().getValue(), (Integer) vuespinner.getNumber2TFJ().getValue());
                vue.getNumber1TF().setText(Integer.toString((Integer) vuespinner.getNumber1TFJ().getValue()));
                if (vuespinner.RadioSommeJ().isSelected()) {
                    vue.GetResultL().setText(model.AddAndGetResult());
                    vuespinner.GetResultLJ().setText(model.AddAndGetResult());
                } else {
                    vue.GetResultL().setText(model.SousAndGetResult());
                    vuespinner.GetResultLJ().setText(model.SousAndGetResult());
                }
            });

            vuespinner.getNumber2TFJ().setOnMouseClicked(Event -> {
                model.setNumbersInt((Integer) vuespinner.getNumber1TFJ().getValue(),(Integer) vuespinner.getNumber2TFJ().getValue());
                vue.getNumber2TF().setText(Integer.toString((Integer) vuespinner.getNumber2TFJ().getValue()));
                if (vuespinner.RadioSommeJ().isSelected()) {
                    vue.GetResultL().setText(model.AddAndGetResult());
                    vuespinner.GetResultLJ().setText(model.AddAndGetResult());
                } else {
                    vuespinner.GetResultLJ().setText(model.SousAndGetResult());
                    vuespinner.GetResultLJ().setText(model.SousAndGetResult());
                }
            });

            vuespinner.RadioSommeJ().setOnAction(Event0 -> {
                vue.RadioSomme().setSelected(true);
                vue.GetResultL().setText(model.AddAndGetResult());
                vuespinner.GetResultLJ().setText(model.AddAndGetResult());
            });

            vuespinner.RadioSoustractionJ().setOnAction(Event00 -> {
                vue.RadioSoustraction().setSelected(true);
                vue.GetResultL().setText(model.SousAndGetResult());
                vuespinner.GetResultLJ().setText(model.SousAndGetResult());
            });
            //pas besoin de forcer le spinner à être un entier. . .
    }
}