package com.crxl.qpp.comicdis.basics.entity;

import java.io.Serializable;
import java.util.Date;

public class PhoneVerification implements Serializable {
    private String id;

    private String code;

    private Date impl;

    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Date getImpl() {
        return impl;
    }

    public void setImpl(Date impl) {
        this.impl = impl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}