package com.yasoft.labs.lab6.recorder.controller;

import com.yasoft.labs.lab6.recorder.interfaces.services.RecordService;
import com.yasoft.labs.lab6.recorder.interfaces.services.RecorderService;
import com.yasoft.labs.lab6.recorder.model.Record;
import com.yasoft.labs.lab6.recorder.model.Recorder;
import com.yasoft.labs.lab6.recorder.model.User;
import com.yasoft.labs.lab6.recorder.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

@Controller
public class RecorderController {
    private RecordService recordService;
    private RecorderService recorderService;

    @Autowired
    public RecorderController(RecordService recordService, RecorderService recorderService) {
        this.recordService = recordService;
        this.recorderService = recorderService;
    }

    @GetMapping("recorder/{id}")
    public String recorder(@PathVariable int id, Authentication authentication, Model model) {
        Recorder recorder = recorderService.findById(id);
        if (recorder == null) {
            return "redirect:/recorders";
        }

        User user = Util.getUser(authentication);
        if (!(recorder.getUser().getId().equals(user.getId()))) {
            return "redirect:/recorders";
        }

        Collection<Record> records = recordService.findAllByRecorder(recorder);
        model.addAttribute("recorder", recorder);
        model.addAttribute("records", records);
        return "recorder";
    }

    @PostMapping("recordDelete")
    public String recordDelete(int recordId, int recorderId) {
        recordService.delete(recordId);
        return "redirect:/recorder/" + recorderId;
    }

    @PostMapping("recordAdd")
    public String recordAdd(String data, int number, int recorderId) {
        Record record = new Record();
        record.setData(data);
        record.setNumber(number);
        record.setRecorder(recorderService.findById(recorderId));
        recordService.create(record);
        return "redirect:/recorder/" + recorderId;
    }
}
