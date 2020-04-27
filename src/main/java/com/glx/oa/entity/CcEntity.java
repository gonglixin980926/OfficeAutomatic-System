package com.glx.oa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "cc", schema = "oa", catalog = "")
public class CcEntity {
    private int ccId;
    private String applyName;
    private String dest;
    private String customer;
    private String applyReason;
    private String reMark;
    private String state;
    private Timestamp startTime;
    private Timestamp endTime;

    @Id
    @Column(name = "ccId")
    public int getCcId() {
        return ccId;
    }

    public void setCcId(int ccId) {
        this.ccId = ccId;
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
    @Column(name = "dest")
    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    @Basic
    @Column(name = "customer")
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Basic
    @Column(name = "applyReason")
    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    @Basic
    @Column(name = "reMark")
    public String getReMark() {
        return reMark;
    }

    public void setReMark(String reMark) {
        this.reMark = reMark;
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
    @Column(name = "startTime")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
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

        CcEntity ccEntity = (CcEntity) o;

        if (ccId != ccEntity.ccId) return false;
        if (applyName != null ? !applyName.equals(ccEntity.applyName) : ccEntity.applyName != null) return false;
        if (dest != null ? !dest.equals(ccEntity.dest) : ccEntity.dest != null) return false;
        if (customer != null ? !customer.equals(ccEntity.customer) : ccEntity.customer != null) return false;
        if (applyReason != null ? !applyReason.equals(ccEntity.applyReason) : ccEntity.applyReason != null)
            return false;
        if (reMark != null ? !reMark.equals(ccEntity.reMark) : ccEntity.reMark != null) return false;
        if (state != null ? !state.equals(ccEntity.state) : ccEntity.state != null) return false;
        if (startTime != null ? !startTime.equals(ccEntity.startTime) : ccEntity.startTime != null) return false;
        if (endTime != null ? !endTime.equals(ccEntity.endTime) : ccEntity.endTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ccId;
        result = 31 * result + (applyName != null ? applyName.hashCode() : 0);
        result = 31 * result + (dest != null ? dest.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (applyReason != null ? applyReason.hashCode() : 0);
        result = 31 * result + (reMark != null ? reMark.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }
}
