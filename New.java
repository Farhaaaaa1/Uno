package com.company;

import java.util.LinkedList;

public class New {

    public static void main(String[] args) {
        Card card[] = new Card[52] ;
        int i = 2 ;
        DrawCard salam = new DrawCard(3 , 5);
        System.out.println(salam.getForfeit());
        LinkedList<Card> A = new LinkedList();
        LinkedList<Card> B = new LinkedList();
        Repository rep = new Repository(A,B) ;
        for( i = 1 ; i <card.length ; ++ i ) {
            card[i] = new NumericCard(i/13+1 ,i%13);
            B.add(card[i]) ;
        }
        rep.movePlayedToHidden();
        System.out.println(A.size());

    }
}
