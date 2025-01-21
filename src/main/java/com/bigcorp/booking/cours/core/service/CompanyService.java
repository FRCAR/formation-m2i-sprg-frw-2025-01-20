package com.bigcorp.booking.cours.core.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Value("${companyservice.maxcompanyid}")
    private Integer maxCompanyId;

    @Autowired
    private OrderService orderService;

    private String name;

    public String getName() {
        try {
            Thread.sleep(4_000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public Integer getMaxCompanyId() {
        return maxCompanyId;
    }

    public void setMaxCompanyId(Integer maxCompanyId) {
        this.maxCompanyId = maxCompanyId;
    }

    public Integer generateRandom(){
        return new Random().nextInt(555);
    }

}
