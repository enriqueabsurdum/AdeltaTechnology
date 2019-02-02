package com.github.enriqueabsurdum.models;

public class Plan {

    private int id;
    private String plan;
    private String description;
    private PlanType planType;

    public Plan() {
    }

    public Plan(int id, String plan, String description, PlanType planType) {
        this.id = id;
        this.plan = plan;
        this.description = description;
        this.planType = planType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PlanType getPlanType() {
        return planType;
    }

    public void setPlanType(PlanType planType) {
        this.planType = planType;
    }

    @Override
    public String toString() {
        return "Plan{" + "id=" + id + ", plan=" + plan + ", description=" + description + ", planType=" + planType + '}';
    }

}
