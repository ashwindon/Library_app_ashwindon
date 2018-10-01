package com.example.ashwin.library;

public class data {

    public int uid;
    private String name, email;
    private books b1[];

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public books[] getB1() {
        return b1;
    }

    public void setB1(books[] b1) {
        this.b1 = b1;
    }
}
