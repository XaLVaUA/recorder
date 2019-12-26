package com.yasoft.labs.lab6.recorder.interfaces.repositories;

import com.yasoft.labs.lab6.recorder.model.Record;
import com.yasoft.labs.lab6.recorder.model.Recorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {
    List<Record> findAllByRecorder(Recorder recorder);
    Optional<Record> findByRecorderAndNumber(Recorder recorder, int number);
}
