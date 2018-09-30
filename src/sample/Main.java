package sample;

import Trainer.FileManager;
import Trainer.Vokabel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static List<Vokabel> vokabeln = new ArrayList<Vokabel>();

    public static FileManager fm = new FileManager("", this);

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static List<Vokabel> getVokabeln() {
        return vokabeln;
    }

    public Main getInstance() {
        return this;
    }

    public static void addVokabel(String deutsch, String englisch) {
        if (deutsch != null && englisch != null) {
            Vokabel v = new Vokabel(deutsch, englisch, 1);
            vokabeln.add(v);
        }
    }

    public static void removeVokabel(String deutsch, String englisch) {
        if (deutsch != null && englisch != null) {
            for (Vokabel v : vokabeln) {
                if (v.getDeutsch().equals(deutsch) || v.getEnglisch().equals(englisch)) {
                    vokabeln.remove(v);
                }
            }
        }
    }
}
