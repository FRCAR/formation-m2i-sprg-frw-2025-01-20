package com.bigcorp.booking.cours.core.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private Integer maxOrderNumber = 4;

    public Integer getMaxOrderNumber() {
        return maxOrderNumber;
    }

    public void setMaxOrderNumber(Integer maxOrderName) {
        this.maxOrderNumber = maxOrderName;
    }

}
