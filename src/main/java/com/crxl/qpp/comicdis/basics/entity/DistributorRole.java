package com.crxl.qpp.comicdis.basics.entity;

import java.io.Serializable;

public class DistributorRole implements Serializable {
    private String id;

    private String distributorid;

    private String roleid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDistributorid() {
        return distributorid;
    }

    public void setDistributorid(String distributorid) {
        this.distributorid = distributorid == null ? null : distributorid.trim();
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }
}