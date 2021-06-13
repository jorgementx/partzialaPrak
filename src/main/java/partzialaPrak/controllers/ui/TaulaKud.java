package partzialaPrak.controllers.ui;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.event.ActionEvent;
import partzialaPrak.Main;
import partzialaPrak.controllers.db.Md5DBKud;
import partzialaPrak.models.TaulaModel;
import partzialaPrak.utils.MessageDigestForUrl;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

public class TaulaKud implements Initializable {

    @FXML
    private TableView<TaulaModel> table;

    @FXML
    private TableColumn<TaulaModel, String> url;

    @FXML
    private TableColumn<TaulaModel, String> md5;

    @FXML
    private TableColumn<TaulaModel, String> version;

    @FXML
    private TextField urltxt;

    @FXML
    private Button checkbtn;

    @FXML
    private Label labelGuapa;

    private Main main;

    @FXML
    void onClick(ActionEvent event) {
        String url = urltxt.getText();
        String md5 = null;
        try {
            md5 = MessageDigestForUrl.getInstance().getMd5(url);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String version = Md5DBKud.getMd5DBKud().getVersion(md5);

        TaulaModel element = new TaulaModel(url,md5,version);
        table.getItems().add(element);

        if (version=="") labelGuapa.setText("Ez da aurkitu datubasean");
        else labelGuapa.setText("Datubasean zegoen");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table.setEditable(true);//probar a quitar esto
        url.setCellValueFactory(new PropertyValueFactory<>("URL"));
        md5.setCellValueFactory(new PropertyValueFactory<>("md5"));
        version.setCellValueFactory(new PropertyValueFactory<>("version"));

        version.setCellFactory(TextFieldTableCell.forTableColumn());

        version.setOnEditCommit((TableColumn.CellEditEvent<TaulaModel, String> event) -> {
            TablePosition<TaulaModel, String> pos = event.getTablePosition();
            int row = pos.getRow();
            TaulaModel taulaModel = event.getTableView().getItems().get(row);
            String newVersion = event.getNewValue();

            taulaModel.setVersion(newVersion);
            //datu basean eguneratu
        });

    }

    public void setMainApp (Main main){
        this.main = main;
    }
}

