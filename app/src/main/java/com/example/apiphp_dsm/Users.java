package com.example.apiphp_dsm;

public class Users {
    public String id;
    public String name;
    public String age;
    public String mobile;
    public String email;


    public Users() {

    }

    public Users(String id, String name, String age, String mobile, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.email = email;
    }

    public String toString(){
        final String s = this.id + " - " + this.name + " - " + this.email;
        return s;
    }
}

