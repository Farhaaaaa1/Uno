package com.company;

public class DrawCard extends ColorCard {
    public DrawCard(int color, int number) {
        super(color, number);
        setForfeit(2);
    }
}
