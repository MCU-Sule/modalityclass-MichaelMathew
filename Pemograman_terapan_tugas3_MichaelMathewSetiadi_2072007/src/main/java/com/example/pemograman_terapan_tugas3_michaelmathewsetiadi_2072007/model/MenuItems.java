package com.example.pemograman_terapan_tugas3_michaelmathewsetiadi_2072007.model;

public class MenuItems {
    private String nama;
    private int harga;
    private float diskon;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public float getDiskon() {
        return diskon;
    }

    public void setDiskon(float diskon) {
        this.diskon = diskon;
    }

    public MenuItems(String nama, int harga, float diskon) {
        this.nama = nama;
        this.harga = harga;
        this.diskon = diskon;
    }

    @Override
    public String toString() {
        if(diskon != 0.0) {
            return nama +" " + (harga - (harga*diskon)) + " (original price : " + harga + " )" + " Diskon : " + (diskon*100) + "%";
        } else {
            return nama + " " + harga;
        }
    }
}
