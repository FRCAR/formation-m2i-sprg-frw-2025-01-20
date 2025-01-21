package com.bigcorp.booking.cours.core.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("!production")
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
