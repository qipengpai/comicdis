package com.crxl.qpp.comicdis.basics.entity;

import java.io.Serializable;

public class VeryOk  implements Serializable {
    private String id;

    private String cartoonsetid;

    private String okdate;

    private Integer okstate;

    private String userid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCartoonsetid() {
        return cartoonsetid;
    }

    public void setCartoonsetid(String cartoonsetid) {
        this.cartoonsetid = cartoonsetid == null ? null : cartoonsetid.trim();
    }

    public String getOkdate() {
        return okdate;
    }

    public void setOkdate(String okdate) {
        this.okdate = okdate == null ? null : okdate.trim();
    }

    public Integer getOkstate() {
        return okstate;
    }

    public void setOkstate(Integer okstate) {
        this.okstate = okstate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}