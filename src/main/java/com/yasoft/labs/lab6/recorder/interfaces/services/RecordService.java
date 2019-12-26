package com.yasoft.labs.lab6.recorder.interfaces.services;

import com.yasoft.labs.lab6.recorder.model.Record;
import com.yasoft.labs.lab6.recorder.model.Recorder;

import java.util.Collection;
import java.util.List;

public interface RecordService {
    List<Record> findAll();
    Record findById(Integer id);
    List<Record> findAllByRecorder(Recorder recorder);
    Record create(Record record);
    Record update(Integer id, Record record);
    Record delete(Integer id);
}
