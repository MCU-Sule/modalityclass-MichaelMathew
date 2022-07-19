package com.example.pemograman_terapan_tugas3_michaelmathewsetiadi_2072007.Controller;

import com.example.pemograman_terapan_tugas3_michaelmathewsetiadi_2072007.CoffeeShopApplication;
import com.example.pemograman_terapan_tugas3_michaelmathewsetiadi_2072007.model.MenuItems;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Comparator;

public class MenuController {

    public ListView ListMenu;

    private ObservableList<MenuItems> oList;
    private Stage stage;
    private int index;

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

        TambahMenuCtrl tController = fxmlLoader.getController();

        stage.setTitle("");
        stage.setScene(scene);
        stage.showAndWait();

        if(tController.getReturnNama() != null || tController.getReturnHarga() != 0) {
            oList.add(new MenuItems(tController.getReturnNama(), tController.getReturnHarga(), tController.getReturnDiskon()));
            Comparator<MenuItems> comparator = Comparator.comparing(MenuItems::getNama);
            FXCollections.sort(oList,comparator);
        }
    }

    public void Selected(MouseEvent mouseEvent) {
        if (!ListMenu.getSelectionModel().getSelectedItems().isEmpty()) {
            ContextMenu contextMenu = new ContextMenu();
            MenuItem menuItem = new MenuItem("Delete");
            contextMenu.getItems().add(menuItem);
            ListMenu.setContextMenu(contextMenu);
            index = ListMenu.getSelectionModel().getSelectedIndex();
            menuItem.setOnAction((Delete) -> {
                ListMenu.getItems().remove(index);
            });
        }
    }
}
