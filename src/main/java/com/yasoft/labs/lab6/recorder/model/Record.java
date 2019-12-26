package com.yasoft.labs.lab6.recorder.model;

import javax.persistence.*;

@Entity
@Table
public class Record {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Recorder recorder;

    private String data;

    private Integer number;

    private Integer size;

    public Record() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Recorder getRecorder() {
        return recorder;
    }

    public void setRecorder(Recorder recorder) {
        this.recorder = recorder;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
