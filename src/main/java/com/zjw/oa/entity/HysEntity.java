package com.zjw.oa.entity;

import javax.persistence.*;

@Entity
@Table(name = "hys", schema = "oa", catalog = "")
public class HysEntity {
    private int hhid;
    private Integer hhzs;

    @Id
    @Column(name = "hhid")
    public int getHhid() {
        return hhid;
    }

    public void setHhid(int hhid) {
        this.hhid = hhid;
    }

    @Basic
    @Column(name = "hhzs")
    public Integer getHhzs() {
        return hhzs;
    }

    public void setHhzs(Integer hhzs) {
        this.hhzs = hhzs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HysEntity hysEntity = (HysEntity) o;

        if (hhid != hysEntity.hhid) return false;
        if (hhzs != null ? !hhzs.equals(hysEntity.hhzs) : hysEntity.hhzs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hhid;
        result = 31 * result + (hhzs != null ? hhzs.hashCode() : 0);
        return result;
    }
}
