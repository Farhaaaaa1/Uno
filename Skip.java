package com.company;

public interface Skip {
    default void skip(GameSystem gameSystem)
    {
        gameSystem.setTurn(gameSystem.getTurn()+gameSystem.getRotation());
    }
}
