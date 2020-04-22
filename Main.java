package com.company;

import java.util.Collections;
import java.util.LinkedList;

import static com.company.Color.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int turn;
        Printing printer = new Printing();
        LinkedList<Card> list = new LinkedList<>();
        GameSystem uno = new GameSystem();
        User me = new User();
        PcPlayer pc = new PcPlayer();
        PcPlayer pc1 = new PcPlayer();
        PcPlayer pc2 = new PcPlayer();
        boolean access = false;
        Repository repository = new Repository();
        uno.fillTheCardsAtFirst(repository);
        Player[] players = new Player[]{pc, pc1, pc2, me};
        uno.setNumberOfPlayer(4);
        for (int i = 0; i < 7; ++i) {
            Collections.shuffle(repository.playedCardList);
            me.CardList.add(repository.playedCardList.getFirst());
            repository.playedCardList.removeFirst();
            pc.CardList.add(repository.playedCardList.getFirst());
            repository.playedCardList.removeFirst();

            pc1.CardList.add(repository.playedCardList.getFirst());
            repository.playedCardList.removeFirst();

            pc2.CardList.add(repository.playedCardList.getFirst());
            repository.playedCardList.removeFirst();
        }
        repository.setForfeit(1);
        while (repository.playedCardList.getLast().getNumber() > 9)
            Collections.shuffle(repository.playedCardList);
        int i = 0;
        printer.playWithFour(players[0], players[3], players[2], players[1], repository, uno);

        while (true) {
            System.out.println("forfeit : " + repository.getForfeit());
            turn = uno.realBaghiMande(uno.getTurn());
            System.out.println();
            System.out.println("   turn   : " + turn);
            uno.setTurn(turn);


            if (players[turn] instanceof User) {
                access = false;
                if (((User) players[turn]).playIsValid(repository)) {
                    printer.playWithFour(players[0], players[3], players[2], players[1], repository, uno);
                    ((User) players[turn]).putCard(repository, uno);
                    //Thread.sleep(6000);
                    uno.setTurn(uno.getTurn() + uno.getRotation());
                } else {
                    printer.playWithFour(players[0], players[3], players[2], players[1], repository, uno);
                    Thread.sleep(3000);
                    if (repository.getForfeit() == 1)
                        access = true;
                    else
                        uno.setTurn(uno.getTurn() + uno.getRotation());
                    ((User) players[turn]).getCard(repository);

                    if (((User) players[turn]).playIsValid(repository) && access) {
                        printer.playWithFour(players[0], players[3], players[2], players[1], repository, uno);
                        Thread.sleep(6000);
                        ((User) players[turn]).putCard(repository, uno);
                        uno.setTurn(uno.getTurn() + uno.getRotation());
                        Thread.sleep(6000);
                    }
                }
            }

            if (players[turn] instanceof PcPlayer) {
                access = false;
                if (players[turn].playIsValid(repository)) {
                    printer.playWithFour(players[0], players[3], players[2], players[1], repository, uno);
                    ((PcPlayer) players[turn]).puttingAutomatic(repository, uno);
                    uno.setTurn(uno.getTurn() + uno.getRotation());
                    Thread.sleep(6000);
                } else {
                    if (repository.getForfeit() == 1)
                        access = true;
                    printer.playWithFour(players[0], players[3], players[2], players[1], repository, uno);
                    Thread.sleep(6000);
                    ((PcPlayer) players[turn]).getCard(repository);

                    if (((PcPlayer) players[turn]).playIsValid(repository) && access) {
                        printer.playWithFour(players[0], players[3], players[2], players[1], repository, uno);
                        Thread.sleep(6000);
                        ((PcPlayer) players[turn]).puttingAutomatic(repository, uno);
                        uno.setTurn(uno.getTurn() + uno.getRotation());
                    } else
                        uno.setTurn(uno.getTurn() + uno.getRotation());
                }
            }
            System.out.println();
        }
    }


}
