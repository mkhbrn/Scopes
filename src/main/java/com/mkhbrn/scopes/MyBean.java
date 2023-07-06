package com.mkhbrn.scopes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyBean {

    private int id;
    private String name;

    public void print(){
        log.info("ID:" + id + " name:" + name);
    }
}
