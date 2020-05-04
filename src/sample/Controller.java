import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    //VARIABLE FXML
    @FXML
    private TextField nbr1 ;
    @FXML
    private TextField nbr2 ;
    @FXML
    private Label resultat ;
    @FXML
    private Label err ;
    @FXML
    private javafx.scene.control.Button closeButton;

    //ACTION EVENT OF BUTTONS

    @FXML
    public void Somme(ActionEvent event){
        //POUR LA SOMME
        try {
        //NOMBRES
        int nb1=Integer.parseInt(nbr1.getText().toString());
        int nb2=Integer.parseInt(nbr2.getText().toString());

            //code

        //RESULTAT
        resultat.setText("Result de la somme");

        } catch (Exception exc) {
            System.out.println(exc);
            err.setText("Les champs doivent contenir un nombre !!!");
        }
    }

    @FXML
    public void Produit(ActionEvent event){
        //POUR LE PRODUIT
        try{
        //NOMBRES
        int nb1=Integer.parseInt(nbr1.getText().toString());
        int nb2=Integer.parseInt(nbr2.getText().toString());

        //code

        //RESULTAT
        resultat.setText("Result du produit");
    } catch (Exception exc) {
        System.out.println(exc);
        err.setText("Les champs doivent contenir un nombre !!!");
    }

    }

    @FXML
    public void Factoriel(ActionEvent event){
        //POUR LE FACTORIEL
        try {
        //NOMBRES
        int nb1=Integer.parseInt(nbr1.getText().toString());

            //code

        //RESULTAT
        resultat.setText("Result du factoriel");
    } catch (Exception exc) {
        System.out.println(exc);
        err.setText("Entrez un nombre dans le champ -Nombre1- !!!");
    }
    }

    @FXML
    public void Quitter(ActionEvent event){
        //POUR QUITTER
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    public void Trace(ActionEvent event){
        //POUR LA TRACE

        //code
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
