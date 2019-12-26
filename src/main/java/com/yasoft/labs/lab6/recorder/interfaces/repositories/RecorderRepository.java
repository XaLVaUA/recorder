package com.yasoft.labs.lab6.recorder.interfaces.repositories;

import com.yasoft.labs.lab6.recorder.model.Recorder;
import com.yasoft.labs.lab6.recorder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecorderRepository extends JpaRepository<Recorder, Integer> {
    List<Recorder> findAllByUser(User user);
}
