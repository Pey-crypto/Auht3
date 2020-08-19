package com.SecureWk.Auht.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Local extends RealmObject {

    @PrimaryKey
    @Required
    //Thinking of two Options
    //SHA-256 Generated Hash(Unique)
    //Unix Epoch
    private String Date_hash;
    @Required
    private String Date_time;
    @Required
    private String Staff_name;
    @Required
    private int Total_Days;
    @Required
    private int Absent_Days;


    public Local() {

    }

    public Local(String date_time, String staff_name, int total_Days, int absent_Days) {
        this.Date_time = date_time;
        this.Staff_name = staff_name;
        this.Total_Days = total_Days;
        this.Absent_Days = absent_Days;
    }

    public String getDate_hash() {
        return Date_hash;
    }

    public void setDate_hash(String date_hash) {
        Date_hash = date_hash;
    }

    public String getDate_time() {
        return Date_time;
    }

    public void setDate_time(String date_time) {
        Date_time = date_time;
    }

    public String getStaff_name() {
        return Staff_name;
    }

    public void setStaff_name(String staff_name) {
        Staff_name = staff_name;
    }

    public int getTotal_Days() {
        return Total_Days;
    }

    public void setTotal_Days(int total_Days) {
        Total_Days = total_Days;
    }

    public int getAbsent_Days() {
        return Absent_Days;
    }

    public void setAbsent_Days(int absent_Days) {
        Absent_Days = absent_Days;
    }
}
