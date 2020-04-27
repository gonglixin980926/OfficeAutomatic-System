package com.glx.oa.entity;

import javax.persistence.*;

@Entity
@Table(name = "xmjd", schema = "oa", catalog = "")
public class XmjdEntity {
    private String xmmc;
    private Integer xmjd;
    private int xmId;

    @Basic
    @Column(name = "xmmc")
    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    @Basic
    @Column(name = "xmjd")
    public Integer getXmjd() {
        return xmjd;
    }

    public void setXmjd(Integer xmjd) {
        this.xmjd = xmjd;
    }

    @Id
    @Column(name = "xmId")
    public int getXmId() {
        return xmId;
    }

    public void setXmId(int xmId) {
        this.xmId = xmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XmjdEntity that = (XmjdEntity) o;

        if (xmId != that.xmId) return false;
        if (xmmc != null ? !xmmc.equals(that.xmmc) : that.xmmc != null) return false;
        if (xmjd != null ? !xmjd.equals(that.xmjd) : that.xmjd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = xmmc != null ? xmmc.hashCode() : 0;
        result = 31 * result + (xmjd != null ? xmjd.hashCode() : 0);
        result = 31 * result + xmId;
        return result;
    }
}
