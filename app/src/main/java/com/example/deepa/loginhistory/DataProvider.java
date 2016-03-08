package com.example.deepa.loginhistory;

/**
 * Created by Deepa on 3/5/2016.
 */
public class DataProvider {
    private String name="";
    private String pwd="";

    public DataProvider(String str,String s){
        this.name=str;
        this.pwd=s;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
