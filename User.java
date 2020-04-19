package com.company;

import java.util.Collections;
import java.util.Scanner;

public class User extends Player {

    @Override
    void playing(Repository repository, GameSystem game) {
        boolean access = false;
        if (playIsValid(repository))
            putCard(repository, game);
        else {
            if (repository.getForfeit() == 1)
                access = true;
            getCard(repository);
        }
        if (playIsValid(repository) && access)
            putCard(repository, game);
    }

    @Override
    void getCard(Repository repository) {
        int numberOfCard = repository.getForfeit();
        for (int i = 0; i < numberOfCard; ++i) {
            Card temp = repository.playedCardList.getLast();
            repository.playedCardList.removeLast();
            Collections.shuffle(repository.playedCardList);
            repository.playedCardList.addLast(temp);
            this.CardList.add(repository.playedCardList.getFirst());
            repository.playedCardList.removeFirst();
        }
        repository.setForfeit(1);
    }

    public void putCard(Repository repository, GameSystem game) {
        int n;
        System.out.println("Choose your card : ");
        ColorCard copyOfNumericCard;
        do {
            Scanner Input = new Scanner(System.in);
            n = Input.nextInt();
            // change it to index of cards
            n--;
            if (n < CardList.size() && n >= 0) {
                if (repository.getForfeit() == 1) {
                    if (CardList.get(n) instanceof ColorCard) {
                        if (CardList.get(n).getColor() == repository.playedCardList.getLast().getColor()) {
                            afterPut(repository, game, n);
                            break;
                        } else if (repository.playedCardList.getLast() instanceof ColorCard) {
                            if (((ColorCard) CardList.get(n)).getNumber() == ((ColorCard) repository.playedCardList.getLast()).getNumber()) {
                                afterPut(repository, game, n);
                                break;
                            }
                        }
                    } else if (CardList.get(n) instanceof WildCard && !(CardList.get(n) instanceof WildDrawCard)) {
                        afterPut(repository, game, n);
                        break;
                    } else if (CardList.get(n) instanceof WildCard && (CardList.get(n) instanceof WildDrawCard)) {
                        if (isWildsDrawValid(repository)) {
                            afterPut(repository, game, n);
                            break;
                        }
                        System.out.println("\n\n\n\u001b[34m   you have to choose another card (if you have color card or wild card you have to put it first)  try again : \u001b[0m");
                    }
                    else
                        System.out.println("\n\n\n\u001b[34m   you have to choose another card try again : \u001b[0m");
                }
                if (repository.getForfeit() > 1) {
                    if (repository.playedCardList.getLast() instanceof DrawCard) {
                        if (CardList.get(n) instanceof DrawCard) {
                            afterPut(repository, game, n);
                            break;
                        } else if (CardList.get(n) instanceof WildDrawCard && isWildsDrawValid(repository)) {
                            afterPut(repository, game, n);
                            break;
                        } else
                            System.out.println("\n\n\n\u001b[34m   you have to choose another card try again : \u001b[0m");
                    }
                    if (repository.playedCardList.getLast() instanceof WildDrawCard) {
                        if (CardList.get(n) instanceof WildDrawCard) {
                            afterPut(repository, game, n);
                            break;
                        }
                        else
                            System.out.println("you cant put this , try again : ");
                    }
                }
            } else
                System.out.println("\n\n\n\u001b[34m   this is out af range try again  \u001b[0m");
        }
        while (true);

    }

    public boolean isWildsDrawValid(Repository rep) {
        for (Card A :
                CardList) {
            if (A instanceof ColorCard) {
                if (A.getColor() == rep.playedCardList.getLast().getColor())
                    return false;
                if (rep.playedCardList.getLast() instanceof ColorCard)
                    if (((ColorCard) A).getNumber() == ((ColorCard) rep.playedCardList.getLast()).getNumber())
                        return false;

            }
            if (A instanceof WildCard && !(A instanceof WildDrawCard))
                return false;
        }
        return true;
    }

    public void afterPut(Repository repository, GameSystem gameSystem, int n) {
        repository.addToPlayedCard(CardList.get(n));
        if (CardList.get(n) instanceof WildCard)
            ((WildCard) CardList.get(n)).setTheColor();
        actions(CardList.get(n), gameSystem, n);
        CardList.remove(n);
    }

    public void actions(Card card, GameSystem gameSystem, int n) {
        if (card instanceof SkipCard)
            ((SkipCard) card).skip(gameSystem);
        if (card instanceof ReversCard)
            ((ReversCard) card).rivers(gameSystem);

    }
}