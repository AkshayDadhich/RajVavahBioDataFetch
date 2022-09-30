package com.example.rajvivah.modal;

public class DataModal {
    public String registeruser_id ,name,register_uid,registeruser_mob;

    public DataModal(String registeruser_id, String name, String register_uid, String registeruser_mob) {
        this.registeruser_id = registeruser_id;
        this.name = name;
        this.register_uid = register_uid;
        this.registeruser_mob = registeruser_mob;
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

    public String getRegister_uid() {
        return register_uid;
    }

    public void setRegister_uid(String register_uid) {
        this.register_uid = register_uid;
    }

    public String getRegisteruser_mob() {
        return registeruser_mob;
    }

    public void setRegisteruser_mob(String registeruser_mob) {
        this.registeruser_mob = registeruser_mob;
    }
}
