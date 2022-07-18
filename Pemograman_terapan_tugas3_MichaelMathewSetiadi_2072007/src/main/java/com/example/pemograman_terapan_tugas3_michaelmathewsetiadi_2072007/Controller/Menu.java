package com.example.pemograman_terapan_tugas3_michaelmathewsetiadi_2072007.Controller;

import com.example.pemograman_terapan_tugas3_michaelmathewsetiadi_2072007.CoffeeShopApplication;
import com.example.pemograman_terapan_tugas3_michaelmathewsetiadi_2072007.model.MenuItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {

    public ListView ListMenu;

    private ObservableList<MenuItem> oList;
    private Stage stage;

    public void initialize() {
        oList = FXCollections.observableArrayList();
        stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        ListMenu.setItems(oList);
    }

    public void GoToAddMenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(CoffeeShopApplication.class.getResource("TambahMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 286, 273);

        TambahMenu tController = fxmlLoader.getController();

        stage.setTitle("");
        stage.setScene(scene);
        stage.showAndWait();

        if(tController.getReturnNama() != null || tController.getReturnHarga() != 0) {
            oList.add(new MenuItem(tController.getReturnNama(), tController.getReturnHarga(), tController.getReturnDiskon()));
        } 
    }
}
