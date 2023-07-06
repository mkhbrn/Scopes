package com.mkhbrn.scopes.controller;

import com.mkhbrn.scopes.service.PrototypeScopeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/prototype")
public class PrototypeScopeController {

    @Autowired
    PrototypeScopeService prototypeScopeService;

    @GetMapping()
    public Integer getLastElement(){
//        var prototypeScopeService = new PrototypeScopeService();
        log.info("PrototypeScopeHashCode:" + prototypeScopeService.hashCode());
        return prototypeScopeService.getLastElement();
    }

    @GetMapping("/{value}")
    public void addElement(@PathVariable int value){
//        var prototypeScopeService = new PrototypeScopeService();
        log.info("PrototypeScopeHashCode:" + prototypeScopeService.hashCode());
        prototypeScopeService.addListElement(value);
    }

}
