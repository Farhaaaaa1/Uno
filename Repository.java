package com.company;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * repository class for keep our cards and
 * also penalize the users .
 */
public class Repository {
    //A
   // LinkedList<Card> hiddenCardList = new LinkedList();
    LinkedList<Card> playedCardList = new LinkedList();
    private int forfeit;

//    public Repository(LinkedList<Card> hiddenCardList, LinkedList<Card> playedCardList) {
//        this.hiddenCardList = hiddenCardList;
//        this.playedCardList = playedCardList;
//    }

    public Repository(LinkedList<Card> playedCardList) {
        this.playedCardList = playedCardList;
    }

    /**
     * @param card new card that we put it .
     */
    public void addToPlayedCard(Card card) {
        playedCardList.addLast(card);
        setForfeit(card);
    }
    /**
     * get the forfeit of this turn .
     * @return forfeit of this turn .
     */
    public int getForfeit() {
        return forfeit;
    }

    /**
     * set the forfeit of this turn by card .
     * @param card forfeit of this turn .
     */
    public void setForfeit(Card card) {
        if (this.forfeit == 1)
            this.forfeit = card.getForfeit();
        if (this.forfeit > 1)
            this.forfeit += card.getForfeit();
    }

    /**
     * set the forfeit for this turn .
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
//    public void movePlayedToHidden() {
//        LinkedList<Card> temp = new LinkedList();
//        temp.add(playedCardList.getLast());
//        playedCardList.removeLast();
//        // to be on the safe side   LOL !
//        hiddenCardList.clear();
//        hiddenCardList.addAll(playedCardList);
//        playedCardList.clear();
//        playedCardList.add(temp.getFirst());
//        Collections.shuffle(hiddenCardList);
//    }

}
