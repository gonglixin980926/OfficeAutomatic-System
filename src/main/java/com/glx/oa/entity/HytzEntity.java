package com.glx.oa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "hytz", schema = "oa", catalog = "")
public class HytzEntity {
    private int hyId;
    private String hynr;
    private Timestamp hyTime;
    private String hydd;
    private Integer hybtzr;
    private Integer hyztr;

    @Id
    @Column(name = "hyId")
    public int getHyId() {
        return hyId;
    }

    public void setHyId(int hyId) {
        this.hyId = hyId;
    }

    @Basic
    @Column(name = "hynr")
    public String getHynr() {
        return hynr;
    }

    public void setHynr(String hynr) {
        this.hynr = hynr;
    }

    @Basic
    @Column(name = "hyTime")
    public Timestamp getHyTime() {
        return hyTime;
    }

    public void setHyTime(Timestamp hyTime) {
        this.hyTime = hyTime;
    }

    @Basic
    @Column(name = "hydd")
    public String getHydd() {
        return hydd;
    }

    public void setHydd(String hydd) {
        this.hydd = hydd;
    }

    @Basic
    @Column(name = "hybtzr")
    public Integer getHybtzr() {
        return hybtzr;
    }

    public void setHybtzr(Integer hybtzr) {
        this.hybtzr = hybtzr;
    }

    @Basic
    @Column(name = "hyztr")
    public Integer getHyztr() {
        return hyztr;
    }

    public void setHyztr(Integer hyztr) {
        this.hyztr = hyztr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HytzEntity that = (HytzEntity) o;

        if (hyId != that.hyId) return false;
        if (hynr != null ? !hynr.equals(that.hynr) : that.hynr != null) return false;
        if (hyTime != null ? !hyTime.equals(that.hyTime) : that.hyTime != null) return false;
        if (hydd != null ? !hydd.equals(that.hydd) : that.hydd != null) return false;
        if (hybtzr != null ? !hybtzr.equals(that.hybtzr) : that.hybtzr != null) return false;
        if (hyztr != null ? !hyztr.equals(that.hyztr) : that.hyztr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hyId;
        result = 31 * result + (hynr != null ? hynr.hashCode() : 0);
        result = 31 * result + (hyTime != null ? hyTime.hashCode() : 0);
        result = 31 * result + (hydd != null ? hydd.hashCode() : 0);
        result = 31 * result + (hybtzr != null ? hybtzr.hashCode() : 0);
        result = 31 * result + (hyztr != null ? hyztr.hashCode() : 0);
        return result;
    }
}
