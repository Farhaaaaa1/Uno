package com.company;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * repository class for keep our cards and
 * also penalize the users .
 */
public class Repository {
    LinkedList<Card> hiddenCardList = new LinkedList();
    //A
    LinkedList<Card> playedCardList = new LinkedList();
    private int forfeit;
//    private int color;
//    private int number;
//
//    /**
//     * @return color of the card that we should put like that .
//     */
//    public int getColor() {
//        return color;
//    }
//
//    /**
//     * @param color get color of the card that we shout put like that .
//     */
//    public void setColor(int color) {
//        this.color = color;
//    }
//
//    /**
//     * @return number of the card that we should put like that
//     */
//    public int getNumber() {
//        return number;
//    }
//
//    /**
//     * set number of the card that we should put like that
//     *
//     * @param number
//     */
//    public void setNumber(int number) {
    //      this.number = number;
    //   }

    public Repository(LinkedList<Card> hiddenCardList, LinkedList<Card> playedCardList) {
        this.hiddenCardList = hiddenCardList;
        this.playedCardList = playedCardList;
    }

    public Repository(LinkedList<Card> hiddenCardList) {
        this.hiddenCardList = hiddenCardList;
    }

    /**
     * use this method to know we can put this card or not .
     * @param card card that we want to put it .
     * @return result ( we can put this card or not )
     */
    public boolean checkTheCard(Card card) {
        return card.getColor() == playedCardList.getLast().getColor() ||
                card.getNumber() == playedCardList.getLast().getNumber();
    }

    public void addToPlayedCard(Card card) {
        playedCardList.add(card);
    }

    /**
     * get the forfeit of this turn .
     *
     * @return forfeit of this turn .
     */
    public int getForfeit() {
        return forfeit;
    }

    /**
     * set the forfeit of this turn .
     *
     * @param card forfeit of this turn .
     */
    public void setForfeit(Card card) {
        this.forfeit += card.getForfeit();
    }

    /**
     * set the forfeit for this turn .
     *
     * @param forfeit forfeit of this turn .
     */
    public void setForfeit(int forfeit) {
        this.forfeit = forfeit;
    }

    /**
     * A
     * remove card
     * @param list list of card .
     */
//    public  void removeCard(LinkedList<Card> list)
//    {
//        if(!list.isEmpty()){
//            list.removeLast() ;
//        }
//        else
//            movePlayedToHidden();
//}

    /**
     * A
     * moving card from played list to hidden list .
     */
    public void movePlayedToHidden() {
        System.out.println("size of B : " + playedCardList.size());
        LinkedList<Card> temp = new LinkedList();
        temp.add(playedCardList.getLast());
        playedCardList.removeLast();
        // to be on the safe side   LOL !
        hiddenCardList.clear();
        hiddenCardList.addAll(playedCardList);
        playedCardList.clear();
        playedCardList.add(temp.getFirst());
        Collections.shuffle(hiddenCardList);
    }

}
