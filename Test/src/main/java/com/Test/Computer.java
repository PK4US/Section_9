package com.Test;

public class Computer {
    private String title;
    private int price;

    public Computer(String title, int price){
        this.title = title;
        this.price = price;
    }

    public String toString(){
        return "Название: " + title + "; Цена: " + price + " грн";
    }
}
