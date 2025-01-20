package com.bigcorp.booking.cours.core.service;

public class EmployeeService {

    private String etage;

    public void sayHello(){
        System.out.println("Coucou de EmployeeService");
    }

    public String getEtage() {
        return etage;
    }

    public void setEtage(String etage) {
        this.etage = etage;
    }
}
