package partzialaPrak;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import partzialaPrak.controllers.ui.TaulaKud;

import java.io.IOException;

public class Main extends Application {

    private Parent taulaUI;
    private Stage stage;
    private TaulaKud taulaKud;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        stage.setResizable(false);
        stage.setTitle("phpMyAdmin bertsioak");

        this.taulaPantailaKargatu();
        stage.setScene(new Scene(taulaUI, 600, 400));
        stage.show();
    }

    private void taulaPantailaKargatu() throws IOException {
        FXMLLoader loaderTaula = new FXMLLoader(getClass().getResource("/checkphpversion.fxml"));
        taulaUI = (Parent) loaderTaula.load();
        taulaKud = loaderTaula.getController();
        taulaKud.setMainApp(this);
    }
}
