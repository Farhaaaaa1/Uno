package com.company;

public interface Skip {
    default int skip(int turn , int direction)
    {
        turn += direction ;
        return turn ;
    }
}
