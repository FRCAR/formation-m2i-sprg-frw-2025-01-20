package com.bigcorp.booking.cours.core.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Classe de Service, sera instanciée par Spring
 * car elle est annotée avec @Service (interchangeable avec @Component)
 */
@Service
public class CompanyService {

    //${} demande à Spring de transformer la chaîne de caractères
    //(une clé) en sa valeur, qui vient sans doute d'un fichier de propriétés
    @Value("${companyservice.maxcompanyid}")
    private Integer maxCompanyId;

    @Autowired
    private OrderService orderService;

    private String name;

    public String getName() {
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
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
