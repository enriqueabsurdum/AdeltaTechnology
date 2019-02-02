package com.github.enriqueabsurdum.models;

public class MobilePlan {

    private int id;
    private int idMobile;
    private int idPlan;

    public MobilePlan() {
    }

    public MobilePlan(int id, int idMobile, int idPlan) {
        this.id = id;
        this.idMobile = idMobile;
        this.idPlan = idPlan;
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

    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

    @Override
    public String toString() {
        return "MobilePlan{" + "id=" + id + ", idMobile=" + idMobile + ", idPlan=" + idPlan + '}';
    }

}
