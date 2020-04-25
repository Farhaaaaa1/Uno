package com.company;

import java.util.LinkedList;
import java.util.Random;

public abstract class Player {
    LinkedList<Card> CardList = new LinkedList();
    public String name ;

    public Player(String name) {
        this.name = name;
    }

    /**
     * @param repository repository that keep the cards
     */
    public void getCard(Repository repository) {

        int numberOfCard = repository.getForfeit();
        int givenCard;
        for (int i = 0; i < numberOfCard; ++i) {
            Card temp = repository.playedCardList.getLast();
            repository.playedCardList.removeLast();
            givenCard = new Random().nextInt(repository.playedCardList.size());
            repository.playedCardList.addLast(temp);
            if (repository.playedCardList.get(givenCard) instanceof WildCard)
                repository.playedCardList.get(givenCard).setColor(5);
            this.CardList.add(repository.playedCardList.get(givenCard));
            repository.playedCardList.remove(givenCard);
        }
        repository.setForfeit(1);
    }


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
                System.out.println(repository.playedCardList.getLast().getColor());
                System.out.println(card.getNumber());
                return true;
            }
            if (repository.playedCardList.getLast().getNumber() == card.getNumber()) {

                return true;
            }
            if (card instanceof WildCard) {
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
    /**
     *
     * @return score of every player
     */
    public int getScore()
    {   int score = 0 ;
        for (Card card:
                this.CardList ) {
            if(card.getNumber()<10)
                score+=card.getNumber();
            else if(card.getNumber()>9 && card instanceof ColorCard)
                score+=20 ;
            else if (card instanceof WildCard)
                score+=50 ;
        }
        return score ;
    }

}


