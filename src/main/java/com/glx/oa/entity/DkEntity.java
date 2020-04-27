package com.glx.oa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "dk", schema = "oa", catalog = "")
public class DkEntity {
    private Integer userId;
    private Timestamp dkTime;

    @Id
    @Basic
    @Column(name = "userId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "dkTime")
    public Timestamp getDkTime() {
        return dkTime;
    }

    public void setDkTime(Timestamp dkTime) {
        this.dkTime = dkTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DkEntity dkEntity = (DkEntity) o;

        if (userId != null ? !userId.equals(dkEntity.userId) : dkEntity.userId != null) return false;
        if (dkTime != null ? !dkTime.equals(dkEntity.dkTime) : dkEntity.dkTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (dkTime != null ? dkTime.hashCode() : 0);
        return result;
    }
}
