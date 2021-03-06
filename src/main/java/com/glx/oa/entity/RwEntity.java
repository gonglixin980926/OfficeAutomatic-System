package com.glx.oa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "rw", schema = "oa", catalog = "")
public class RwEntity {
    private int rwId;
    private String rwmc;
    private String rwms;
    private Timestamp rwTime;
    private String jsUserName;
    private String fbUserName;
    private Integer jjcd;
    private String state;

    @Id
    @Column(name = "rwId")
    public int getRwId() {
        return rwId;
    }

    public void setRwId(int rwId) {
        this.rwId = rwId;
    }

    @Basic
    @Column(name = "rwmc")
    public String getRwmc() {
        return rwmc;
    }

    public void setRwmc(String rwmc) {
        this.rwmc = rwmc;
    }

    @Basic
    @Column(name = "rwms")
    public String getRwms() {
        return rwms;
    }

    public void setRwms(String rwms) {
        this.rwms = rwms;
    }

    @Basic
    @Column(name = "rwTime")
    public Timestamp getRwTime() {
        return rwTime;
    }

    public void setRwTime(Timestamp rwTime) {
        this.rwTime = rwTime;
    }

    @Basic
    @Column(name = "jsUserName")
    public String getJsUserName() {
        return jsUserName;
    }

    public void setJsUserName(String jsUserName) {
        this.jsUserName = jsUserName;
    }

    @Basic
    @Column(name = "fbUserName")
    public String getFbUserName() {
        return fbUserName;
    }

    public void setFbUserName(String fbUserName) {
        this.fbUserName = fbUserName;
    }

    @Basic
    @Column(name = "jjcd")
    public Integer getJjcd() {
        return jjcd;
    }

    public void setJjcd(Integer jjcd) {
        this.jjcd = jjcd;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RwEntity rwEntity = (RwEntity) o;

        if (rwId != rwEntity.rwId) return false;
        if (rwmc != null ? !rwmc.equals(rwEntity.rwmc) : rwEntity.rwmc != null) return false;
        if (rwms != null ? !rwms.equals(rwEntity.rwms) : rwEntity.rwms != null) return false;
        if (rwTime != null ? !rwTime.equals(rwEntity.rwTime) : rwEntity.rwTime != null) return false;
        if (jsUserName != null ? !jsUserName.equals(rwEntity.jsUserName) : rwEntity.jsUserName != null) return false;
        if (fbUserName != null ? !fbUserName.equals(rwEntity.fbUserName) : rwEntity.fbUserName != null) return false;
        if (jjcd != null ? !jjcd.equals(rwEntity.jjcd) : rwEntity.jjcd != null) return false;
        if (state != null ? !state.equals(rwEntity.state) : rwEntity.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rwId;
        result = 31 * result + (rwmc != null ? rwmc.hashCode() : 0);
        result = 31 * result + (rwms != null ? rwms.hashCode() : 0);
        result = 31 * result + (rwTime != null ? rwTime.hashCode() : 0);
        result = 31 * result + (jsUserName != null ? jsUserName.hashCode() : 0);
        result = 31 * result + (fbUserName != null ? fbUserName.hashCode() : 0);
        result = 31 * result + (jjcd != null ? jjcd.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
