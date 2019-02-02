package com.github.enriqueabsurdum.models;

public class User {

    private int id;
    private String run;
    private String name;
    private String lastName;
    private Profile profile;
    private String email;
    private String password;

    public User() {
    }

    public User(int id, String run, String name, String lastName, Profile profile, String email, String password) {
        this.id = id;
        this.run = run;
        this.name = name;
        this.lastName = lastName;
        this.profile = profile;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", run=" + run + ", name=" + name + ", lastName=" + lastName + ", profile=" + profile + ", email=" + email + ", password=" + password + '}';
    }

}
