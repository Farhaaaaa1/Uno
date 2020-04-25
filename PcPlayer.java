package com.company;

import java.util.Random;

public class PcPlayer extends Player {
    public PcPlayer(String name) {
        super(name);
    }

    /**
     * put the cards automatically
     * @param repository where we keep played cards
     * @param gameSystem system of the game LOL
     */
    public void puttingAutomatic(Repository repository, GameSystem gameSystem ) {
        for (Card A :
                CardList) {
            if (repository.getForfeit() == 1) {
                if ((A.getColor() == repository.playedCardList.getLast().getColor()) &&
                        !(A instanceof WildDrawCard)) {
                    afterPut(repository, gameSystem, CardList.indexOf(A));
                    break;
                }
                if ((A.getNumber() == repository.playedCardList.getLast().getNumber() ||
                        A.getNumber() == 13) && !(A instanceof WildDrawCard)) {
                    afterPut(repository, gameSystem, CardList.indexOf(A));
                    break;
                }
                if (A instanceof WildCard && (A instanceof WildDrawCard)) {
                    if (isWildsDrawValid(repository)) {
                        afterPut(repository, gameSystem, CardList.indexOf(A));
                        break;
                    }
                }
            } else if (repository.getForfeit() > 1) {
                if (repository.playedCardList.getLast() instanceof WildDrawCard && A instanceof WildDrawCard) {
                    afterPut(repository, gameSystem, CardList.indexOf(A));
                    break;
                }
                else if (repository.playedCardList.getLast() instanceof DrawCard && A instanceof DrawCard) {
                    afterPut(repository, gameSystem, CardList.indexOf(A));
                    break;
                }
            }
        }
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
        if (CardList.get(n) instanceof WildCard) {
            int aim = new Random().nextInt(4)+1 ;
            ((WildCard) CardList.get(n)).setColor(aim);
        }
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

