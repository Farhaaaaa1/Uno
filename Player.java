package com.company;

import java.util.LinkedList;

public abstract class Player {
    LinkedList<Card> CardList = new LinkedList();
    abstract void getCard(Repository repository);

  abstract void playing(Repository repository);

    public boolean playIsValid(Repository repository)
    {
        int aimColor = repository.playedCardList.getLast().getColor() ;
        int aimNumber = repository.playedCardList.getLast().getNumber() ;
        for (Card card:
          this.CardList   ) {
            if(card instanceof NumericCard)
            if(card.getColor() == aimColor || card.getNumber() == aimNumber)
                return true ;
            if(card instanceof WildCard)
                return true ;
        }
        return false ;
    }

}
