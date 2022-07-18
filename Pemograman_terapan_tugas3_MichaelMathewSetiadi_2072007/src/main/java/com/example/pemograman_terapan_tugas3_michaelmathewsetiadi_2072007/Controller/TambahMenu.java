package com.example.pemograman_terapan_tugas3_michaelmathewsetiadi_2072007.Controller;

import com.example.pemograman_terapan_tugas3_michaelmathewsetiadi_2072007.CoffeeShopApplication;
import com.example.pemograman_terapan_tugas3_michaelmathewsetiadi_2072007.model.MenuItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class TambahMenu {
    public TextField NamaMenu;
    public TextField HargaMenu;
    public ComboBox<String> DiscountList;
    public Button CustomDiskonID;
    private String ReturnNama;
    private int ReturnHarga;
    private float ReturnDiskon;
    private Stage stage;

    public void initialize() {
        ObservableList<String> dList = FXCollections.observableArrayList("0.0", "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9");
        DiscountList.setItems(dList);
        DiscountList.getSelectionModel().select(0);
        stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
    }
    public void CreateDiscount(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(CoffeeShopApplication.class.getResource("Diskon.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 307, 150);

        Diskon dController = fxmlLoader.getController();

        stage.setTitle("");
        stage.setScene(scene);
        stage.showAndWait();

        CustomDiskonID.setText(String.valueOf(dController.getReturnDiskonBaru()));
    }


    public void AddMenu(ActionEvent actionEvent) {
        setReturnNama(NamaMenu.getText());
        setReturnHarga(Integer.parseInt(HargaMenu.getText()));
        if(CustomDiskonID.getText().equals("Custom Discount")) {
            setReturnDiskon(Float.parseFloat(String.valueOf(DiscountList.getValue())));
        } else {
            float DISKON = Float.parseFloat(CustomDiskonID.getText());
            float realDisc = DISKON / 100;
            setReturnDiskon(realDisc);
        }
    }

    public String getReturnNama() {
        return ReturnNama;
    }

    public void setReturnNama(String returnNama) {
        ReturnNama = returnNama;
    }

    public int getReturnHarga() {
        return ReturnHarga;
    }

    public void setReturnHarga(int returnHarga) {
        ReturnHarga = returnHarga;
    }

    public float getReturnDiskon() {
        return ReturnDiskon;
    }

    public void setReturnDiskon(float returnDiskon) {
        ReturnDiskon = returnDiskon;
    }

}
