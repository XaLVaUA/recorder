package com.yasoft.labs.lab6.recorder.controller;

import com.yasoft.labs.lab6.recorder.interfaces.services.RecordService;
import com.yasoft.labs.lab6.recorder.interfaces.services.RecorderService;
import com.yasoft.labs.lab6.recorder.model.Record;
import com.yasoft.labs.lab6.recorder.model.Recorder;
import com.yasoft.labs.lab6.recorder.model.User;
import com.yasoft.labs.lab6.recorder.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Controller
public class RecordersController {
    private RecorderService recorderService;
    private RecordService recordService;

    @Autowired
    public RecordersController(RecorderService recorderService, RecordService recordService) {
        this.recorderService = recorderService;
        this.recordService = recordService;
    }

    @GetMapping("/recorders")
    public String recorders(Authentication authentication, Model model) {
        User user = Util.getUser(authentication);
        model.addAttribute("recorders", recorderService.findAllByUser(user));
        return "recorders";
    }

    @PostMapping("/recorderAdd")
    public String recorderAdd(int recordLimit, int memoryTotal, Authentication authentication, Model model) {
        User user = Util.getUser(authentication);
        Recorder recorder = new Recorder();
        recorder.setRecordLimit(recordLimit);
        recorder.setMemoryTotal(memoryTotal);
        recorder.setMemoryCurrent(0);
        recorder.setRecordCurrent(0);
        recorder.setUser(user);
        recorderService.create(recorder);
        return "redirect:/recorders";
    }

    @PostMapping("/recorderDelete")
    public String recorderDelete(int recorderId, Authentication authentication, Model model) {
        recorderService.delete(recorderId);
        return "redirect:/recorders";
    }
}
