package com.company;

import java.util.LinkedList;

public abstract class Player {
    LinkedList<Card> CardList = new LinkedList();

    /**
     * @param repository repository that keep the cards
     */
    abstract void getCard(Repository repository);

    /**
     * @param repository repository that keep the cards
     * @param game       game system
     */
    abstract void playing(Repository repository, GameSystem game);

    /**
     * check player can put any card or not .
     *
     * @param repository repository that keep the cards
     * @return boolean that show access to put card .
     */
    public boolean playIsValid(Repository repository) {
        if (repository.getForfeit() > 1) {
            return playIsValid1(repository);
        } else if (repository.getForfeit() == 1) {
            return playIsValid2(repository);
        }
        return false;
    }

    /**
     * @param repository where we keep all the played and hidden cards
     * @return can we do it or not
     */
    // when , if we don't have any card to put we have to get more than one card .
    public boolean playIsValid1(Repository repository) {
        if (repository.playedCardList.getLast() instanceof WildDrawCard) {
            for (Card card :
                    this.CardList) {
                if (card instanceof WildDrawCard)
                    return true;
            }
        } else if (repository.playedCardList.getLast() instanceof DrawCard)
            for (Card card :
                    this.CardList) {
                if (card instanceof DrawCard)
                    return true;
            }
        return false;
    }

    /**
     * @param repository where we keep all the played and hidden cards
     * @return can we do it or not
     */
    // when , if we don't have any card to put ,  we have to get one card .
    public boolean playIsValid2(Repository repository) {
        for (Card card :
                CardList) {
            if (card.getColor() == repository.playedCardList.getLast().getColor()) {
                System.out.println(1.);
                System.out.println(repository.playedCardList.getLast().getColor());
                System.out.println(card.getNumber());
                return true;
            }
            if (repository.playedCardList.getLast().getNumber() == card.getNumber())
            {                System.out.println(2.);

                return true;
            }
            if (card instanceof WildCard) {
                System.out.println(3.);
                return true;
            }
        }
        return false;

    }
    public boolean isWildsDrawValid(Repository rep) {
        for (Card A :
                CardList)
            if (!(A instanceof WildDrawCard)) {
                if (A.getColor() == rep.playedCardList.getLast().getColor())
                    return false;
                if ((A.getNumber() == rep.playedCardList.getLast().getNumber()) || A.getNumber() == 13)
                    return false;
            }
        return true;
    }

}


