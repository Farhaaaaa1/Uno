package com.company;

public interface Skip {
    default void skip(GameSystem gameSystem) {
        int newTurn = gameSystem.getTurn() + gameSystem.getRotation() ;
        gameSystem.setTurn(newTurn);
    }
}
