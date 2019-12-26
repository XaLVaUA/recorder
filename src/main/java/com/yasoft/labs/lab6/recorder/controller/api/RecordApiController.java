package com.yasoft.labs.lab6.recorder.controller.api;

import com.yasoft.labs.lab6.recorder.interfaces.services.RecordService;
import com.yasoft.labs.lab6.recorder.interfaces.services.RecorderService;
import com.yasoft.labs.lab6.recorder.model.Record;
import com.yasoft.labs.lab6.recorder.model.Recorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/records")
public class RecordApiController {
    private RecordService recordService;

    @Autowired
    public RecordApiController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Record>> get() {
        List<Record> records = recordService.findAll();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Record> get(@PathVariable Integer id) {
        Record record = recordService.findById(id);
        if (record != null) {
            return new ResponseEntity<>(record, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Record> post(@RequestBody Record record) {
        Record recordResult = recordService.create(record);
        if (recordResult != null) {
            return new ResponseEntity<>(recordResult, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Record> put(@PathVariable Integer id, @RequestBody Record record) {
        Record recordResult = recordService.update(id, record);
        if (recordResult != null) {
            return new ResponseEntity<>(recordResult, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Record> delete(@PathVariable Integer id) {
        Record recordResult = recordService.delete(id);
        if (recordResult != null) {
            return new ResponseEntity<>(recordResult, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
