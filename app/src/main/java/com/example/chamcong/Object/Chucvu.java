package com.example.chamcong.Object;

public class Chucvu {
    private String cv_ten, cv_id;

    public Chucvu(String cv_ten){}

    public Chucvu(String cv_id, String cv_ten) {
        this.cv_id = cv_id;
        this.cv_ten = cv_ten;
    }

    public String getCv_id() {
        return cv_id;
    }

    public void setCv_id(String cv_id) {
        this.cv_id = cv_id;
    }

    public String getCv_ten() {
        return cv_ten;
    }

    public void setCv_ten(String cv_ten) {
        this.cv_ten = cv_ten;
    }
}
