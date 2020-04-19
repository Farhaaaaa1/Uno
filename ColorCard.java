package com.company;

public class ColorCard extends Card {
    private int number ;
    public ColorCard(int color , int number) {
        super(color);
        this.number = number ;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ColorCard{" +
                "number=" + number +
                '}';
    }
}
