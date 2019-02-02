package com.github.enriqueabsurdum.models;

public class Employee {

    private Integer id;
    private String run;
    private String name;
    private String lastName;
    private String department;
    private String position;
    private String email;
    private String address;
    private String city;
    private String incorporation;
    private Mobile mobile;

    public Employee() {
    }

    public Employee(Integer id, String run, String name, String lastName, String department, String position, String email, String address, String city, String incorporation, Mobile mobile) {
        this.id = id;
        this.run = run;
        this.name = name;
        this.lastName = lastName;
        this.department = department;
        this.position = position;
        this.email = email;
        this.address = address;
        this.city = city;
        this.incorporation = incorporation;
        this.mobile = mobile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIncorporation() {
        return incorporation;
    }

    public void setIncorporation(String incorporation) {
        this.incorporation = incorporation;
    }

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", run=" + run + ", name=" + name + ", lastName=" + lastName + ", department=" + department + ", position=" + position + ", email=" + email + ", address=" + address + ", city=" + city + ", incorporation=" + incorporation + ", mobile=" + mobile + '}';
    }

}
