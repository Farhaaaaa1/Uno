package com.company;

public class GameSystem {
    private int turn;
    private int rotation = 1;
    private int numberOfPlayer;

    public int realBaghiMande(int turn) {
        if (turn < 0) {
            turn = turn % numberOfPlayer + numberOfPlayer;
        } else
            turn = turn % numberOfPlayer;
        return turn;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    /**
     * fill the repos for start the game
     *
     * @param repository
     */
    public void fillTheCardsAtFirst(Repository repository) {
        for (int i = 0; i < 4; ++i) {
            WildDrawCard wilddraw = new WildDrawCard(5, 12);
            repository.playedCardList.add(wilddraw);
            WildCard wild = new WildCard(5, 13);
            repository.playedCardList.add(wild);
        }
        for (int i = 0; i < 8 * 10; ++i) {
            ColorCard card = new ColorCard(i / 20 + 1, i % 10);
            repository.playedCardList.add(card);
        }
        for(int i = 1 ; i < 5 ; ++i) {
            DrawCard card = new DrawCard(i, 12);
            repository.playedCardList.add(card);

            DrawCard card0 = new DrawCard(i, 12);
            repository.playedCardList.add(card0);

            SkipCard card1 = new SkipCard(i, 11);
            repository.playedCardList.add(card1);

            SkipCard card11 = new SkipCard(i, 11);
            repository.playedCardList.add(card11);

            ColorCard card2 = new ColorCard(i, 0);
            repository.playedCardList.add(card2);

            ReversCard card22 = new ReversCard(i, 10);
            repository.playedCardList.add(card22);

            ReversCard card25 = new ReversCard(i, 10);
            repository.playedCardList.add(card25);
        }
    }
}
