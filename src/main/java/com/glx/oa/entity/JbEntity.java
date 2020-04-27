package com.glx.oa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "jb", schema = "oa", catalog = "")
public class JbEntity {
    private int jbId;
    private String jbTitle;
    private Timestamp startTime;
    private Timestamp endTime;
    private String workContent;
    private String state;
    private String applyName;
    private String reMarks;

    @Id
    @Column(name = "jbId")
    public int getJbId() {
        return jbId;
    }

    public void setJbId(int jbId) {
        this.jbId = jbId;
    }

    @Basic
    @Column(name = "jbTitle")
    public String getJbTitle() {
        return jbTitle;
    }

    public void setJbTitle(String jbTitle) {
        this.jbTitle = jbTitle;
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

    @Basic
    @Column(name = "workContent")
    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
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

        JbEntity jbEntity = (JbEntity) o;

        if (jbId != jbEntity.jbId) return false;
        if (jbTitle != null ? !jbTitle.equals(jbEntity.jbTitle) : jbEntity.jbTitle != null) return false;
        if (startTime != null ? !startTime.equals(jbEntity.startTime) : jbEntity.startTime != null) return false;
        if (endTime != null ? !endTime.equals(jbEntity.endTime) : jbEntity.endTime != null) return false;
        if (workContent != null ? !workContent.equals(jbEntity.workContent) : jbEntity.workContent != null)
            return false;
        if (state != null ? !state.equals(jbEntity.state) : jbEntity.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jbId;
        result = 31 * result + (jbTitle != null ? jbTitle.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (workContent != null ? workContent.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
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
    @Column(name = "reMarks")
    public String getReMarks() {
        return reMarks;
    }

    public void setReMarks(String reMarks) {
        this.reMarks = reMarks;
    }
}
