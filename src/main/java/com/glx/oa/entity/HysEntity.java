package com.glx.oa.entity;

import javax.persistence.*;

@Entity
@Table(name = "hys", schema = "oa", catalog = "")
public class HysEntity {
    private int hyid;
    private String hysbh;
    private String hyszt;
    private String bz;

    @Id
    @Column(name = "hyid")
    public int getHyid() {
        return hyid;
    }

    public void setHyid(int hyid) {
        this.hyid = hyid;
    }

    @Basic
    @Column(name = "hysbh")
    public String getHysbh() {
        return hysbh;
    }

    public void setHysbh(String hysbh) {
        this.hysbh = hysbh;
    }

    @Basic
    @Column(name = "hyszt")
    public String getHyszt() {
        return hyszt;
    }

    public void setHyszt(String hyszt) {
        this.hyszt = hyszt;
    }

    @Basic
    @Column(name = "bz")
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HysEntity hysEntity = (HysEntity) o;

        if (hyid != hysEntity.hyid) return false;
        if (hysbh != null ? !hysbh.equals(hysEntity.hysbh) : hysEntity.hysbh != null) return false;
        if (hyszt != null ? !hyszt.equals(hysEntity.hyszt) : hysEntity.hyszt != null) return false;
        if (bz != null ? !bz.equals(hysEntity.bz) : hysEntity.bz != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hyid;
        result = 31 * result + (hysbh != null ? hysbh.hashCode() : 0);
        result = 31 * result + (hyszt != null ? hyszt.hashCode() : 0);
        result = 31 * result + (bz != null ? bz.hashCode() : 0);
        return result;
    }
}
