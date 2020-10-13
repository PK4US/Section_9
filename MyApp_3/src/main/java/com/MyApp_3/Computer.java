package com.MyApp_3;

import java.io.Serializable;

public class Computer implements Serializable {
    private String title;
    private int price;

    public Computer(String title, int price){
        this.title = title;
        this.price = price;
    }

    public String toString(){ return "Название: " + title + "; Цена: " + price + " грн"; }
}
