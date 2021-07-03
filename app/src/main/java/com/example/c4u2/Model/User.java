package com.example.c4u2.Model;

public class User {
    public String nAme,eMail,pHone;

    public User(){

    }
    public User(String nAme, String eMail, String pHone) {
        this.nAme = nAme;
        this.eMail = eMail;
        this.pHone = pHone;
    }

    public String getnAme() {
        return nAme;
    }

    public void setnAme(String nAme) {
        this.nAme = nAme;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getpHone() {
        return pHone;
    }

    public void setpHone(String pHone) {
        this.pHone = pHone;
    }
}
