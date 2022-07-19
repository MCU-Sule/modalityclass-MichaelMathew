package com.example.pemograman_terapan_tugas3_michaelmathewsetiadi_2072007.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class DiskonController {
    public TextField Diskon;
    private float returnDiskonBaru ;

    public void AddDiskon(ActionEvent actionEvent) {
        setReturnDiskonBaru(Float.parseFloat(Diskon.getText()));
        Diskon.getScene().getWindow().hide();
    }

    public float getReturnDiskonBaru() {
        return returnDiskonBaru;
    }

    public void setReturnDiskonBaru(float returnDiskonBaru) {
        this.returnDiskonBaru = returnDiskonBaru;
    }
}
