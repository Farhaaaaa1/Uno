package com.company;

/**
 * for colors :
 * 1 : Blue   /   2 : Green
 * 3 : Yellow   / 7u 4 : Red
 */
public abstract class Card {
    private int color;
    protected int forfeit = 0 ;

    /**
     * @return color of the card
     */
    public int getColor() {
        return color;
    }



    /**
     * @return forfeit of this card .
     */
    public int getForfeit() {
        return forfeit;
    }

    /**
     * set the forfeit of this cards .
     *
     * @param forfeit forfeit of this card .
     */
    public void setForfeit(int forfeit) {
        this.forfeit = forfeit;
    }

    public Card(int color) {
        this.color = color;
    }

    /**
     * @param color color of the card .
     */
    void setColor(int color) {
        this.color = color ;
    }
}
