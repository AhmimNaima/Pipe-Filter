package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

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
        String nb1=nbr1.getText();
        String nb2=nbr2.getText();
            Pipe p1 = new BlockingQueue();
            Pipe p2 = new BlockingQueue();
            Pipe p3 = new BlockingQueue();
            p1.dataIN("+");
            p1.dataIN(nb1);
            p1.dataIN(nb2);
            Filter a1 = new GUI(null,p1);
            Filter b1 = new Calcul(p1,p2);
            Filter d1 = new Trace(p2,p3);
            Thread th1 = new Thread( a1 );
            Thread th2 = new Thread( b1 );
            Thread th4 = new Thread( d1 );
            th1.start();
            th2.start();
            th4.start();



            //code

        //RESULTAT
        resultat.setText(p3.dataOUT());

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
            String nb1=nbr1.getText();
            String nb2=nbr2.getText();
            Pipe p1 = new BlockingQueue();
            Pipe p2 = new BlockingQueue();
            Pipe p3 = new BlockingQueue();
            p1.dataIN("*");
            p1.dataIN(nb1);
            p1.dataIN(nb2);
            Filter a1 = new GUI(null,p1);
            Filter b1 = new Calcul(p1,p2);
            Filter d1 = new Trace(p2,p3);
            Thread th1 = new Thread( a1 );
            Thread th2 = new Thread( b1 );
            Thread th4 = new Thread( d1 );
            th1.start();
            th2.start();
            th4.start();

            //code

            //RESULTAT
            resultat.setText(p3.dataOUT());

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
            String nb1=nbr1.getText();
            Pipe p1 = new BlockingQueue();
            Pipe p2 = new BlockingQueue();
            Pipe p3 = new BlockingQueue();
            p1.dataIN("!");
            p1.dataIN(nb1);
            Filter a1 = new GUI(null,p1);
            Filter b1 = new Calcul(p1,p2);
            Filter d1 = new Trace(p2,p3);
            Thread th1 = new Thread( a1 );
            Thread th2 = new Thread( b1 );
            Thread th4 = new Thread( d1 );
            th1.start();
            th2.start();
            th4.start();



            //code

            //RESULTAT
            resultat.setText(p3.dataOUT());

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
    public void Trace(ActionEvent event) throws IOException {
        //POUR LA TRACE
        String file="..\\..\\fichier.txt";
        try {
            Runtime.getRuntime().exec("cmd /c start" + file);
        }
        catch (IOException e)
        {  e.printStackTrace();}  }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
