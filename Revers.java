package com.company;

public interface Revers {
   default void rivers (GameSystem gameSystem){
          gameSystem.setRotation(-gameSystem.getRotation()); ;
    }
}
