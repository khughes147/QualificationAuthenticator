package com.example.QualificationAuthenticator;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class University {


    private long id;
    private String email;
    private String uniName;
    private String adminName;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getUniName(){
        return uniName;
    }

    public void setUniName(String uniName){
        this.uniName = uniName;
    }

    public String getAdminName(){
        return adminName;
    }

    public void setAdminName(String adminName){
        this.adminName = adminName;
    }


}
