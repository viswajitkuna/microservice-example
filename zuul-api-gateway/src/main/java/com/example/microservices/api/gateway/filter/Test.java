package com.example.microservices.api.gateway.filter;

import java.util.ArrayList;
import java.util.List;

public class Test
{
    public static void main(String[] args) {
        System.out.println("nifty" instanceof String);
        List<Boolean> booleanList = new ArrayList<>();
//        booleanList.add(Boolean.parseBoolean("FalSE"));

        List list = new ArrayList();
        list.add("1");
        list.add("Hello");
        System.out.println(list.get(0) instanceof Integer);
        System.out.println(list.get(1) instanceof Object);
    }
}
