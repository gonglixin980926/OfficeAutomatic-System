package com.glx.oa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "gc", schema = "oa", catalog = "")
public class GcEntity {
    private int gcId;
    private String applyName;
    private String proxyName;
    private String applyTitle;
    private Timestamp startTime;
    private Integer days;
    private String state;
    private Timestamp endTime;
    private String proxyThings;
    private String reMarks;

    @Id
    @Column(name = "gcId")
    public int getGcId() {
        return gcId;
    }

    public void setGcId(int gcId) {
        this.gcId = gcId;
    }

    @Basic
    @Column(name = "applyName")
    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    @Basic
    @Column(name = "proxyName")
    public String getProxyName() {
        return proxyName;
    }

    public void setProxyName(String proxyName) {
        this.proxyName = proxyName;
    }

    @Basic
    @Column(name = "applyTitle")
    public String getApplyTitle() {
        return applyTitle;
    }

    public void setApplyTitle(String applyTitle) {
        this.applyTitle = applyTitle;
    }

    @Basic
    @Column(name = "startTime")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "days")
    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "endTime")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GcEntity gcEntity = (GcEntity) o;

        if (gcId != gcEntity.gcId) return false;
        if (applyName != null ? !applyName.equals(gcEntity.applyName) : gcEntity.applyName != null) return false;
        if (proxyName != null ? !proxyName.equals(gcEntity.proxyName) : gcEntity.proxyName != null) return false;
        if (applyTitle != null ? !applyTitle.equals(gcEntity.applyTitle) : gcEntity.applyTitle != null) return false;
        if (startTime != null ? !startTime.equals(gcEntity.startTime) : gcEntity.startTime != null) return false;
        if (days != null ? !days.equals(gcEntity.days) : gcEntity.days != null) return false;
        if (state != null ? !state.equals(gcEntity.state) : gcEntity.state != null) return false;
        if (endTime != null ? !endTime.equals(gcEntity.endTime) : gcEntity.endTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gcId;
        result = 31 * result + (applyName != null ? applyName.hashCode() : 0);
        result = 31 * result + (proxyName != null ? proxyName.hashCode() : 0);
        result = 31 * result + (applyTitle != null ? applyTitle.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (days != null ? days.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "proxyThings")
    public String getProxyThings() {
        return proxyThings;
    }

    public void setProxyThings(String proxyThings) {
        this.proxyThings = proxyThings;
    }

    @Basic
    @Column(name = "reMarks")
    public String getReMarks() {
        return reMarks;
    }

    public void setReMarks(String reMarks) {
        this.reMarks = reMarks;
    }
}
