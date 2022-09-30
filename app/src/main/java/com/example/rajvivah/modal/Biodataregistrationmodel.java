package com.example.rajvivah.modal;

public class Biodataregistrationmodel {
    String  registeruser_id, name, fathername, mothername;

    public Biodataregistrationmodel(String registeruser_id, String name, String fathername, String mothername) {
        this.registeruser_id = registeruser_id;
        this.name = name;
        this.fathername = fathername;
        this.mothername = mothername;
    }

    public String getRegisteruser_id() {
        return registeruser_id;
    }

    public void setRegisteruser_id(String registeruser_id) {
        this.registeruser_id = registeruser_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }
}
