package com.yasoft.labs.lab6.recorder.interfaces.services;

import com.yasoft.labs.lab6.recorder.model.Recorder;
import com.yasoft.labs.lab6.recorder.model.User;

import java.util.List;

public interface RecorderService {
    List<Recorder> findAll();
    List<Recorder> findAllByUser(User user);
    Recorder findById(Integer id);
    Recorder create(Recorder recorder);
    Recorder update(Integer id, Recorder recorder);
    Recorder delete(Integer id);
}
