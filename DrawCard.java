package com.company;

public class DrawCard extends ColorCard {
    public DrawCard(int color, int number) {
        super(color, number);
        // set the forfeit of this card .
        setForfeit(2);
    }
}
