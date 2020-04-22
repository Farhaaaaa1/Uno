package com.company;

import java.util.Random;

public class PcPlayer extends Player {

    @Override
    void getCard(Repository repository) {
        int numberOfCard = repository.getForfeit();
        int givenCard;
        for (int i = 0; i < numberOfCard; ++i) {
            Card temp = repository.playedCardList.getLast();
            repository.playedCardList.removeLast();
            givenCard = new Random().nextInt(repository.playedCardList.size());
            if(repository.playedCardList.get(givenCard) instanceof WildCard)
                repository.playedCardList.get(givenCard).setColor(5);
            repository.playedCardList.addLast(temp);
            this.CardList.add(repository.playedCardList.get(givenCard));
            repository.playedCardList.remove(givenCard);
        }
        repository.setForfeit(1);
    }

    @Override
    void playing(Repository repository, GameSystem game) {
        boolean access = false;
        if (playIsValid(repository))
            puttingAutomatic(repository, game);
        else {
            if (repository.getForfeit() == 1)
                access = true;
            getCard(repository);
        }
        if (playIsValid(repository) && access)
            puttingAutomatic(repository, game);
    }

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

