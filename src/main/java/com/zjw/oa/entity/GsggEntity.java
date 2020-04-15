package com.zjw.oa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "gsgg", schema = "oa", catalog = "")
public class GsggEntity {
    private int ggId;
    private String ggTitle;
    private String ggNr;
    private Timestamp ggTime;
    private Integer isZs;

    @Id
    @Column(name = "ggId")
    public int getGgId() {
        return ggId;
    }

    public void setGgId(int ggId) {
        this.ggId = ggId;
    }

    @Basic
    @Column(name = "ggTitle")
    public String getGgTitle() {
        return ggTitle;
    }

    public void setGgTitle(String ggTitle) {
        this.ggTitle = ggTitle;
    }

    @Basic
    @Column(name = "ggNr")
    public String getGgNr() {
        return ggNr;
    }

    public void setGgNr(String ggNr) {
        this.ggNr = ggNr;
    }

    @Basic
    @Column(name = "ggTime")
    public Timestamp getGgTime() {
        return ggTime;
    }

    public void setGgTime(Timestamp ggTime) {
        this.ggTime = ggTime;
    }

    @Basic
    @Column(name = "isZs")
    public Integer getIsZs() {
        return isZs;
    }

    public void setIsZs(Integer isZs) {
        this.isZs = isZs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GsggEntity that = (GsggEntity) o;

        if (ggId != that.ggId) return false;
        if (ggTitle != null ? !ggTitle.equals(that.ggTitle) : that.ggTitle != null) return false;
        if (ggNr != null ? !ggNr.equals(that.ggNr) : that.ggNr != null) return false;
        if (ggTime != null ? !ggTime.equals(that.ggTime) : that.ggTime != null) return false;
        if (isZs != null ? !isZs.equals(that.isZs) : that.isZs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ggId;
        result = 31 * result + (ggTitle != null ? ggTitle.hashCode() : 0);
        result = 31 * result + (ggNr != null ? ggNr.hashCode() : 0);
        result = 31 * result + (ggTime != null ? ggTime.hashCode() : 0);
        result = 31 * result + (isZs != null ? isZs.hashCode() : 0);
        return result;
    }
}
