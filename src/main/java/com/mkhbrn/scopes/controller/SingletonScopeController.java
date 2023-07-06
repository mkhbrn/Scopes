package com.mkhbrn.scopes.controller;


import com.mkhbrn.scopes.service.PrototypeScopeService;
import com.mkhbrn.scopes.service.SingletonScopeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/singleton")
public class SingletonScopeController {

    @Autowired
    SingletonScopeService singletonScopeService;

    @GetMapping()
    public Integer getLastElement(){
//        var singletonScopeService = new SingletonScopeService();
        log.info("SingletonScopeHashCode:" + singletonScopeService.hashCode());
        return singletonScopeService.getLastElement();
    }

    @GetMapping("/{value}")
    public void addElement(@PathVariable int value) throws InterruptedException {
//        var singletonScopeService = new SingletonScopeService();
        log.info("SingletonScopeHashCode:" + singletonScopeService.hashCode());
        singletonScopeService.addListElement(value);
    }

    @GetMapping("/bean/{value}")
    public void addBeanId(@PathVariable int value) throws InterruptedException {
//        var requestScopeService = new RequestScopeService();
        log.info("RequestScopeHashCode:" + singletonScopeService.hashCode());
        singletonScopeService.setBeanId(value);
    }
}
