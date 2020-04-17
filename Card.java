package com.company;

/**
 * for colors :
 * 1 : Blue   /   2 : Green
 * 3 : Yellow   / 7u 4 : Red
 */
public abstract class Card {
    private int color;
    private int number;
    protected int forfeit;

    /**
     * @return color of the card
     */
    public int getColor() {
        return color;
    }

    /**
     * @return number of card
     */
    public int getNumber() {
        return number;
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

    public Card(int color, int number) {
        this.color = color;
        this.number = number;
    }

    /**
     * @param color color of the card .
     */
    void setColor(int color) {
        this.color = color ;
    }
}
