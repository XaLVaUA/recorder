package com.yasoft.labs.lab6.recorder.services;

import com.yasoft.labs.lab6.recorder.interfaces.repositories.RecordRepository;
import com.yasoft.labs.lab6.recorder.interfaces.repositories.RecorderRepository;
import com.yasoft.labs.lab6.recorder.interfaces.services.RecordService;
import com.yasoft.labs.lab6.recorder.model.Record;
import com.yasoft.labs.lab6.recorder.model.Recorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordServiceImpl implements RecordService {
    private RecordRepository recordRepository;

    @Autowired
    public RecordServiceImpl(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public List<Record> findAll() {
        return recordRepository.findAll();
    }

    @Override
    public Record findById(Integer id) {
        Optional<Record> recordOptional = recordRepository.findById(id);
        return recordOptional.orElse(null);
    }

    @Override
    public List<Record> findAllByRecorder(Recorder recorder) {
        return recordRepository.findAllByRecorder(recorder);
    }

    @Override
    public Record create(Record record) {
        Integer id = record.getId();
        if (id != null && recordRepository.existsById(id)) {
            return null;
        }

        record.setSize(record.getData().length());
        Recorder recorder = record.getRecorder();
        if (recorder.getMemoryTotal() - recorder.getMemoryCurrent() < record.getSize()) {
            return null;
        }

        if (record.getNumber() < 1 || record.getNumber() > recorder.getRecordLimit()) {
            return null;
        }

        if (recordRepository.findByRecorderAndNumber(recorder, record.getNumber()).isPresent()) {
            return null;
        }

        recorder.setRecordCurrent(recorder.getRecordCurrent() + 1);
        recorder.setMemoryCurrent(recorder.getMemoryCurrent() + record.getSize());

        return recordRepository.save(record);
    }

    @Override
    public Record update(Integer id, Record record) {
        if (!recordRepository.existsById(id)) {
            return null;
        }

        return recordRepository.save(record);
    }

    @Override
    public Record delete(Integer id) {
        Optional<Record> recordOptional = recordRepository.findById(id);
        if (!recordOptional.isPresent()) {
            return null;
        }

        Record record = recordOptional.get();
        Recorder recorder = record.getRecorder();
        recorder.setMemoryCurrent(recorder.getMemoryCurrent() - record.getSize());
        recorder.setRecordCurrent(recorder.getRecordCurrent() - 1);

        recordRepository.deleteById(id);
        return record;
    }
}
