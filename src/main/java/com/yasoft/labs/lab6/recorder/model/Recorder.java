package com.yasoft.labs.lab6.recorder.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Recorder {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer memoryTotal;

    private Integer memoryCurrent;

    private Integer recordLimit;

    private Integer recordCurrent;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Record> recordList;

    public Recorder() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemoryTotal() {
        return memoryTotal;
    }

    public void setMemoryTotal(Integer memoryTotal) {
        this.memoryTotal = memoryTotal;
    }

    public Integer getRecordLimit() {
        return recordLimit;
    }

    public void setRecordLimit(Integer recordLimit) {
        this.recordLimit = recordLimit;
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getMemoryCurrent() {
        return memoryCurrent;
    }

    public void setMemoryCurrent(Integer memoryCurrent) {
        this.memoryCurrent = memoryCurrent;
    }

    public Integer getRecordCurrent() {
        return recordCurrent;
    }

    public void setRecordCurrent(Integer recordCurrent) {
        this.recordCurrent = recordCurrent;
    }
}
