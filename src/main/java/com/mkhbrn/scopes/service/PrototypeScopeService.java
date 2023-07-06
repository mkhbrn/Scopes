package com.mkhbrn.scopes.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequestScope
@Slf4j
public class PrototypeScopeService {

    PrototypeScopeService(){
        list.add(1);
        list.add(10);
    }

    private List<Integer> list = new ArrayList<>();


    public void addListElement(int _element){
        log.info("PrototypeListHashCode: " + list.hashCode());
        list.add(_element);
    }

    public Integer getLastElement() {
        log.info("PrototypeListHashCode: " + list.hashCode());
        if(list.size() == 0){
            return  null;
        }

        return list.get(list.size() -1);
    }
}
