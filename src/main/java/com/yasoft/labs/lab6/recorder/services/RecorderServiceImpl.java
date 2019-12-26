package com.yasoft.labs.lab6.recorder.services;

import com.yasoft.labs.lab6.recorder.interfaces.repositories.RecorderRepository;
import com.yasoft.labs.lab6.recorder.interfaces.services.RecorderService;
import com.yasoft.labs.lab6.recorder.model.Record;
import com.yasoft.labs.lab6.recorder.model.Recorder;
import com.yasoft.labs.lab6.recorder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecorderServiceImpl implements RecorderService {
    private RecorderRepository recorderRepository;

    @Autowired
    public RecorderServiceImpl(RecorderRepository recorderRepository) {
        this.recorderRepository = recorderRepository;
    }

    @Override
    public List<Recorder> findAll() {
        return recorderRepository.findAll();
    }

    @Override
    public List<Recorder> findAllByUser(User user) {
        return recorderRepository.findAllByUser(user);
    }

    @Override
    public Recorder findById(Integer id) {
        Optional<Recorder> recorderOptional = recorderRepository.findById(id);
        return recorderOptional.orElse(null);
    }

    @Override
    public Recorder create(Recorder recorder) {
        Integer id = recorder.getId();
        if (id != null && recorderRepository.existsById(id)) {
            return null;
        }

        return recorderRepository.save(recorder);
    }

    @Override
    public Recorder update(Integer id, Recorder recorder) {
        if (!recorderRepository.existsById(id)) {
            return null;
        }

        return recorderRepository.save(recorder);
    }

    @Override
    public Recorder delete(Integer id) {
        Optional<Recorder> recorderOptional = recorderRepository.findById(id);
        if (!recorderOptional.isPresent()) {
            return null;
        }

        recorderRepository.deleteById(id);
        return recorderOptional.get();
    }
}
