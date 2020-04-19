package com.company;

public class GameSystem {
    private int turn ;
    private int rotation = 1;
    private int numberOfPlayer ;
    public int realBaghiMande(int turn)
    {
        if(turn%numberOfPlayer<0)
            turn+=numberOfPlayer ;
        return turn ;
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
}
