package com.mkhbrn.scopes.controller;

import com.mkhbrn.scopes.service.PrototypeScopeService;
import com.mkhbrn.scopes.service.RequestScopeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/request")
public class RequestScopeController {
    @Autowired
    RequestScopeService requestScopeService;

    @GetMapping()
    public Integer getLastElement(){
//        var requestScopeService = new RequestScopeService();
        log.info("RequestScopeHashCode:" + requestScopeService.hashCode());
        return requestScopeService.getLastElement();
    }

    @GetMapping("/{value}")
    public void addElement(@PathVariable int value) throws InterruptedException {
//        var requestScopeService = new RequestScopeService();
        log.info("RequestScopeHashCode:" + requestScopeService.hashCode());
        requestScopeService.addListElement(value);
    }

    @GetMapping("/bean/{value}")
    public void addBeanId(@PathVariable int value) throws InterruptedException {
//        var requestScopeService = new RequestScopeService();
        log.info("RequestScopeHashCode:" + requestScopeService.hashCode());
        requestScopeService.setBeanId(value);
    }
}
