package com.zjw.oa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "qjsq", schema = "oa", catalog = "")
public class QjsqEntity {
    private int qjId;
    private String qjyy;
    private String qjms;
    private Timestamp ksTime;
    private Timestamp jsTime;
    private String qjzt;
    private Integer userId;

    @Id
    @Column(name = "qjId")
    public int getQjId() {
        return qjId;
    }

    public void setQjId(int qjId) {
        this.qjId = qjId;
    }

    @Basic
    @Column(name = "qjyy")
    public String getQjyy() {
        return qjyy;
    }

    public void setQjyy(String qjyy) {
        this.qjyy = qjyy;
    }

    @Basic
    @Column(name = "qjms")
    public String getQjms() {
        return qjms;
    }

    public void setQjms(String qjms) {
        this.qjms = qjms;
    }

    @Basic
    @Column(name = "ksTime")
    public Timestamp getKsTime() {
        return ksTime;
    }

    public void setKsTime(Timestamp ksTime) {
        this.ksTime = ksTime;
    }

    @Basic
    @Column(name = "jsTime")
    public Timestamp getJsTime() {
        return jsTime;
    }

    public void setJsTime(Timestamp jsTime) {
        this.jsTime = jsTime;
    }

    @Basic
    @Column(name = "qjzt")
    public String getQjzt() {
        return qjzt;
    }

    public void setQjzt(String qjzt) {
        this.qjzt = qjzt;
    }

    @Basic
    @Column(name = "userId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QjsqEntity that = (QjsqEntity) o;

        if (qjId != that.qjId) return false;
        if (qjyy != null ? !qjyy.equals(that.qjyy) : that.qjyy != null) return false;
        if (qjms != null ? !qjms.equals(that.qjms) : that.qjms != null) return false;
        if (ksTime != null ? !ksTime.equals(that.ksTime) : that.ksTime != null) return false;
        if (jsTime != null ? !jsTime.equals(that.jsTime) : that.jsTime != null) return false;
        if (qjzt != null ? !qjzt.equals(that.qjzt) : that.qjzt != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = qjId;
        result = 31 * result + (qjyy != null ? qjyy.hashCode() : 0);
        result = 31 * result + (qjms != null ? qjms.hashCode() : 0);
        result = 31 * result + (ksTime != null ? ksTime.hashCode() : 0);
        result = 31 * result + (jsTime != null ? jsTime.hashCode() : 0);
        result = 31 * result + (qjzt != null ? qjzt.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
