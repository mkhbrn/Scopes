package com.mkhbrn.scopes.service;

import com.mkhbrn.scopes.MyBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class SingletonScopeService {

    SingletonScopeService(){
        list.add(1);
        list.add(2);
    }

    private MyBean myBean1;

    private MyBean myBean2 = new MyBean();
    private List<Integer> list = new ArrayList<>();
    private List<MyBean> beanList = new ArrayList<>();


//    public void addListElement(int _element){
//        log.info("SingletonListHashCode: " + list.hashCode());
//        list.add(_element);
//    }

    public void addListElement(int _element) throws InterruptedException {
        Thread.sleep(2 * 1000);
        beanList.add(new MyBean(_element, "Name"));
        beanList.forEach(MyBean::print);
        log.info("beanList1: " + beanList.hashCode());
        Thread.sleep(2 * 1000);
        log.error("BeanList");
        beanList.forEach(MyBean::print);
        log.info("beanList2: " + beanList.hashCode());

        var myList = new ArrayList<MyBean>();
        log.info("myList1: " + list.hashCode());
        var newBean = new MyBean(_element, "Hans");
        Thread.sleep(2 * 1000);
        log.info("myList2: " + myList.hashCode());
        myList.add(newBean);
        myList.add(new MyBean(1 + _element, "Gast"));
        Thread.sleep(2 * 1000);
        log.info("myList3: " + myList.hashCode());
        log.error("MyList");
        myList.forEach(MyBean::print);
    }

    public Integer getLastElement() {
        log.info("SingletonListHashCode: " + list.hashCode());
        if(list.size() == 0){
            return  null;
        }

        return list.get(list.size() -1);
    }

    public void setBeanId(int id) throws InterruptedException {
        Thread.sleep(2 * 1000);
        myBean1 = new MyBean();

        Thread.sleep(2 * 1000);
        myBean1.setId(id + id );
        myBean2.setId(id);

        Thread.sleep(2 * 1000);

        myBean1.print();
        myBean2.print();
    }
}
