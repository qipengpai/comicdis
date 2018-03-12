package com.crxl.qpp.comicdis.basics.entity;

import java.io.Serializable;

public class FirstType implements Serializable {
    private String id;

    private String firsttype;

    private String impldate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFirsttype() {
        return firsttype;
    }

    public void setFirsttype(String firsttype) {
        this.firsttype = firsttype == null ? null : firsttype.trim();
    }

    public String getImpldate() {
        return impldate;
    }

    public void setImpldate(String impldate) {
        this.impldate = impldate == null ? null : impldate.trim();
    }
}