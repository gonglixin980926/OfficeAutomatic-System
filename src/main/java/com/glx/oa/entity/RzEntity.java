package com.glx.oa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "rz", schema = "oa", catalog = "")
public class RzEntity {
    private int rzId;
    private String rdnr;
    private Timestamp rzTime;
    private Integer userId;
    private String userName;

    @Id
    @Column(name = "rzId")
    public int getRzId() {
        return rzId;
    }

    public void setRzId(int rzId) {
        this.rzId = rzId;
    }

    @Basic
    @Column(name = "rdnr")
    public String getRdnr() {
        return rdnr;
    }

    public void setRdnr(String rdnr) {
        this.rdnr = rdnr;
    }

    @Basic
    @Column(name = "rzTime")
    public Timestamp getRzTime() {
        return rzTime;
    }

    public void setRzTime(Timestamp rzTime) {
        this.rzTime = rzTime;
    }

    @Basic
    @Column(name = "userId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RzEntity rzEntity = (RzEntity) o;

        if (rzId != rzEntity.rzId) return false;
        if (rdnr != null ? !rdnr.equals(rzEntity.rdnr) : rzEntity.rdnr != null) return false;
        if (rzTime != null ? !rzTime.equals(rzEntity.rzTime) : rzEntity.rzTime != null) return false;
        if (userId != null ? !userId.equals(rzEntity.userId) : rzEntity.userId != null) return false;
        if (userName != null ? !userName.equals(rzEntity.userName) : rzEntity.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rzId;
        result = 31 * result + (rdnr != null ? rdnr.hashCode() : 0);
        result = 31 * result + (rzTime != null ? rzTime.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }
}
