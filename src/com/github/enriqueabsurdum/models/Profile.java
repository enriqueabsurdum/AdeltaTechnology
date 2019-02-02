package com.github.enriqueabsurdum.models;

public class Profile {

    private int id;
    private String profile;

    public Profile() {
    }

    public Profile(int id, String profile) {
        this.id = id;
        this.profile = profile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Profile{" + "id=" + id + ", profile=" + profile + '}';
    }
}
