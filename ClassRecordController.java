package com.missedclass.system.controller;

import com.missedclass.system.model.ClassRecord;
import com.missedclass.system.service.ClassRecordService;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ClassRecordController {

    private final
    ClassRecordService service;

    public ClassRecordController(
            ClassRecordService service) {

        this.service = service;
    }

    //display home page
    @GetMapping("/")
    public String home(
            Model model) {

        model.addAttribute(
                "records",
                service.getAllRecords()
        );

        model.addAttribute(
                "classRecord",
                new ClassRecord()
        );

        return "index";
    }

    //save rec
    @PostMapping("/save")
    public String saveRecord(

            @ModelAttribute
            ClassRecord classRecord) {

        service.addRecord(
                classRecord
        );

        return "redirect:/";
    }
}
