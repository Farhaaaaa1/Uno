package com.company;

import java.util.LinkedList;

public class User extends Player {

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

    public Card putCard(int number, int color) {
        int n;
        NumericCard copyOfNumericCard;
        do {
            scan kardan;
            n--;
            if (n < CardList.size() && n >= 0) {
                if (CardList.get(n).getNumber() == number || CardList.get(n).getColor() == color) {
                    if (CardList.get(n) instanceof NumericCard) {
                        copyOfNumericCard = (NumericCard) CardList.get(n);
                        CardList.remove(n);
                        return copyOfNumericCard;
                    }

                } else
                    System.out.println("\n\n\n\u001b[34m   not matching try agayn   \u001b[0m");
            } else
                System.out.println("\n\n\n\u001b[34m   this is out af range try again  \u001b[0m");
        }
        while (true);

    }
    public boolean isWildsValid(Repository rep )
    {
        for (Card A:
             CardList) {
            if(A instanceof NumericCard && A.getColor() == rep.playedCardList.
        }
    }
}