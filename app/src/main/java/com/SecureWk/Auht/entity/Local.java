package com.SecureWk.Auht.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Local extends RealmObject {

    @PrimaryKey
    @Required
    private String empID;
    @Required
    private String ename;
    @Required
    private String jDate;
    @Required
    private String ldate;

    public Local() {

    }

    public Local(String ename, String jDate, String ldate) {
        this.ename = ename;
        this.jDate = jDate;
        this.ldate = ldate;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getjDate() {
        return jDate;
    }

    public void setjDate(String jDate) {
        this.jDate = jDate;
    }

    public String getLdate() {
        return ldate;
    }

    public void setLdate(String ldate) {
        this.ldate = ldate;
    }
}

