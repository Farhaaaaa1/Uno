package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class User extends Player {
    @Override
    void playing(Repository repository) {
        if(playIsValid(repository))
            putCard(repository);
        else
            getCard(repository);
    }

    @Override
    void getCard(Repository repository) {
        int numberOfCard = repository.getForfeit();
        for (int i = 0; i < numberOfCard; ++i) {
            repository.hiddenCardList.getFirst();
            this.CardList.add(repository.hiddenCardList.getFirst());
            //B
            repository.hiddenCardList.removeFirst();
            //A
            //repository.removeCard(repository.hiddenCardList);
        }
        repository.setForfeit(0);
    }

    public void putCard(Repository repository , ) {
        int n;
        NumericCard copyOfNumericCard;
        do {
            Scanner Input = new Scanner(System.in);
            n=Input.nextInt() ;
            n--;
            if (n < CardList.size() && n >= 0) {
                if (CardList.get(n) instanceof NumericCard) {
                    if (CardList.get(n).getNumber() == repository.playedCardList.getLast().getNumber() ||
                            CardList.get(n).getColor() == repository.playedCardList.getLast().getColor()) {;
                        copyOfNumericCard = (NumericCard) CardList.get(n);
                        CardList.removeLast();
                        if(CardList.get(n) instanceof Skip)
                        CardList.remove(n);
                        break;
                    }


                }
                else if( CardList.get(n)instanceof WildCard )
                {
                    if(isWildsValid(repository))
                    {   ((WildCard) CardList.get(n)).setTheColor();
                        repository.playedCardList.addLast(CardList.get(n));
                        CardList.remove(n);
                        break;
                    }
                }
            } else
                System.out.println("\n\n\n\u001b[34m   this is out af range try again  \u001b[0m");
        }
        while (true);

    }

    public boolean isWildsValid(Repository rep) {
        for (Card A :
                CardList) {
            if (A instanceof NumericCard && (A.getColor() == rep.playedCardList.getLast().getColor() ||
                    A.getNumber() == rep.playedCardList.getLast().getNumber())) {
                    return false ;
            }
        }
        return true ;
    }
}