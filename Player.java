package com.company;

import java.util.LinkedList;

public abstract class Player {
    LinkedList<Card> CardList = new LinkedList();
    abstract void getCard(Repository repository);
}
