package com.company;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class User extends Player {
    public User(String name) {
        super(name);
    }

    /**
     * put the cards automaticly
     * @param repository
     * @param game
     */
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
                    if ((CardList.get(n).getColor() == repository.playedCardList.getLast().getColor()) &&
                            !(CardList.get(n) instanceof WildDrawCard)) {
                        afterPut(repository, game, n);
                        break;
                    }
                    if ((CardList.get(n).getNumber() == repository.playedCardList.getLast().getNumber() ||
                            CardList.get(n).getNumber() == 13) && !(CardList.get(n) instanceof WildDrawCard)) {
                        afterPut(repository, game, n);
                        break;
                    }

                    if (CardList.get(n) instanceof WildCard && (CardList.get(n) instanceof WildDrawCard)) {
                        if (isWildsDrawValid(repository)) {
                            afterPut(repository, game, n);
                            break;
                        }
                        System.out.println("\n\n\n\u001b[34m   you have to choose another card (if you have color card or wild card you have to put it first)  try again : \u001b[0m");
                    }
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
                        } else
                            System.out.println("you cant put this , try again : ");
                    }
                }
            } else
                System.out.println("\n\n\n\u001b[34m   this is out af range try again  \u001b[0m");
        }
        while (true);

    }


    /**
     * do what happen after putting the card
     * @param repository keep all the cards
     * @param gameSystem system of game LOL
     * @param n index of Card list
     */
    public void afterPut(Repository repository, GameSystem gameSystem, int n) {
        // for draw and wild draw
        repository.addToPlayedCard(CardList.get(n));
        // to setting the color
        if (CardList.get(n) instanceof WildCard)
            ((WildCard) CardList.get(n)).setTheColor();
        // to skip or rivers
        actions(CardList.get(n), gameSystem, n);
        CardList.remove(n);
    }

    /**
     * show what happen after putting the card
     * @param card card that do sth
     * @param gameSystem system of game LOL
     * @param n index of Card list
     */
    public void actions(Card card, GameSystem gameSystem, int n) {
        if (card instanceof SkipCard)
            ((SkipCard) card).skip(gameSystem);
        if (card instanceof ReversCard)
            ((ReversCard) card).rivers(gameSystem);

    }


}