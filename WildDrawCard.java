package com.company;

public class WildDrawCard extends WildCard implements Skip {
    public WildDrawCard(int color, int number) {
        super(color, number);
        setForfeit(4);
    }

}
