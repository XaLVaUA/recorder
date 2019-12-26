package com.yasoft.labs.lab6.recorder.controller.api;

import com.sun.deploy.net.HttpResponse;
import com.yasoft.labs.lab6.recorder.interfaces.services.RecorderService;
import com.yasoft.labs.lab6.recorder.model.Recorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/recorders")
public class RecorderApiController {
    private RecorderService recorderService;

    @Autowired
    public RecorderApiController(RecorderService recorderService) {
        this.recorderService = recorderService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Recorder>> get() {
        List<Recorder> recorders = recorderService.findAll();
        return new ResponseEntity<>(recorders, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Recorder> get(@PathVariable Integer id) {
        Recorder recorder = recorderService.findById(id);
        if (recorder != null) {
            return new ResponseEntity<>(recorder, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Recorder> post(@RequestBody Recorder recorder) {
        Recorder recorderResult = recorderService.create(recorder);
        if (recorderResult != null) {
            return new ResponseEntity<>(recorderResult, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recorder> put(@PathVariable Integer id, @RequestBody Recorder recorder) {
        Recorder recorderResult = recorderService.update(id, recorder);
        if (recorderResult != null) {
            return new ResponseEntity<>(recorderResult, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Recorder> delete(@PathVariable Integer id) {
        Recorder recorderResult = recorderService.delete(id);
        if (recorderResult != null) {
            return new ResponseEntity<>(recorderResult, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
