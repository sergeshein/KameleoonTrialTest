package com.shein.KameleoonTrialTest.controller;

import com.shein.KameleoonTrialTest.entity.DelEntity;
import com.shein.KameleoonTrialTest.reository.DelEntRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "", produces = "application/json")
public class DelEntityController {
    @Autowired
    private DelEntRepo delEntRepo;
    @RequestMapping("t")
    public DelEntity createDel(){
       return delEntRepo.save( new DelEntity());

    }
}
