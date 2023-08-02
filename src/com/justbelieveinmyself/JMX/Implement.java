package com.justbelieveinmyself.JMX;

import java.util.Date;

public class Implement implements MBean {
    private String name = "Vadim";
    @Override
    public void sayHello() {
        System.out.println("Hello from bean");
    }

    @Override
    public int addNumbers(int a, int b) {
        return a+b;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Date getDate() {
        return new Date();
    }
}
