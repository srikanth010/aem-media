package com.adobe.aem.media.core.services;

import com.adobe.xfa.Int;


public class People {

    private String first_name;
    private String last_name;
    private int birth_year;

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getBirth_year(){
        return birth_year;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setBirth_Year(int birth_year) {
        this.birth_year = birth_year;
    }
}
