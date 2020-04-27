package com.glx.oa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sb", schema = "oa", catalog = "")
public class SbEntity {
    private int sbId;
    private String applyName;
    private String applyType;
    private String applyReason;
    private Timestamp createTime;
    private String reMarksOne;
    private String reMarksTwo;
    private String state;

    @Id
    @Column(name = "sbId")
    public int getSbId() {
        return sbId;
    }

    public void setSbId(int sbId) {
        this.sbId = sbId;
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
    @Column(name = "applyType")
    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
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
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "reMarksOne")
    public String getReMarksOne() {
        return reMarksOne;
    }

    public void setReMarksOne(String reMarksOne) {
        this.reMarksOne = reMarksOne;
    }

    @Basic
    @Column(name = "reMarksTwo")
    public String getReMarksTwo() {
        return reMarksTwo;
    }

    public void setReMarksTwo(String reMarksTwo) {
        this.reMarksTwo = reMarksTwo;
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

        SbEntity sbEntity = (SbEntity) o;

        if (sbId != sbEntity.sbId) return false;
        if (applyName != null ? !applyName.equals(sbEntity.applyName) : sbEntity.applyName != null) return false;
        if (applyType != null ? !applyType.equals(sbEntity.applyType) : sbEntity.applyType != null) return false;
        if (applyReason != null ? !applyReason.equals(sbEntity.applyReason) : sbEntity.applyReason != null)
            return false;
        if (createTime != null ? !createTime.equals(sbEntity.createTime) : sbEntity.createTime != null) return false;
        if (reMarksOne != null ? !reMarksOne.equals(sbEntity.reMarksOne) : sbEntity.reMarksOne != null) return false;
        if (reMarksTwo != null ? !reMarksTwo.equals(sbEntity.reMarksTwo) : sbEntity.reMarksTwo != null) return false;
        if (state != null ? !state.equals(sbEntity.state) : sbEntity.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sbId;
        result = 31 * result + (applyName != null ? applyName.hashCode() : 0);
        result = 31 * result + (applyType != null ? applyType.hashCode() : 0);
        result = 31 * result + (applyReason != null ? applyReason.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (reMarksOne != null ? reMarksOne.hashCode() : 0);
        result = 31 * result + (reMarksTwo != null ? reMarksTwo.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
