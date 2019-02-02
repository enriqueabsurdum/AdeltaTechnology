package com.github.enriqueabsurdum.models;

public class Audit {

    private int id;
    private int idMobile;
    private String date;
    private int minutes;
    private int data;

    public Audit() {
    }

    public Audit(int id, int idMobile, String date, int minutes, int data) {
        this.id = id;
        this.idMobile = idMobile;
        this.date = date;
        this.minutes = minutes;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMobile() {
        return idMobile;
    }

    public void setIdMobile(int idMobile) {
        this.idMobile = idMobile;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Audit{" + "id=" + id + ", idMobile=" + idMobile + ", date=" + date + ", minutes=" + minutes + ", data=" + data + '}';
    }

}
