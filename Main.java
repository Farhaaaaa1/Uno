package com.company;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import static com.company.Color.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int turn;
        Printing printer = new Printing();
        LinkedList<Card> list = new LinkedList<>();
        GameSystem uno = new GameSystem();
        Repository repository = new Repository();
        boolean first = true;
        repository.setForfeit(1);
        User me = new User("You");
        PcPlayer pc = new PcPlayer("player1");
        PcPlayer pc1 = new PcPlayer("Player3");
        PcPlayer pc2 = new PcPlayer("player4");
        PcPlayer pc3 = new PcPlayer("player5");
        PcPlayer pc4 = new PcPlayer("player6");
        Player[] players = new Player[]{pc, me, pc1, pc2, pc3, pc4};
        int i = new Random().nextInt(1000);
        int nobat = i % 4;
        int kind = 0;
        System.out.println("how many player you want ?   ");
        while (kind < 3 || kind > 5) {
            Scanner Input = new Scanner(System.in);

            kind = Input.nextInt();
            if (kind >= 3 && kind <= 5)
                break;
            System.out.println("it is put of range , try again :");
        }
        while (true) {
            if (kind == 4) {
                if (first) {
                    uno.fillTheCardsAtFirst(repository);
                    for (int k = 0; k < 7; ++k) {
                        Collections.shuffle(repository.playedCardList);
                        me.CardList.add(repository.playedCardList.getFirst());
                        repository.playedCardList.removeFirst();
                        pc.CardList.add(repository.playedCardList.getFirst());
                        repository.playedCardList.removeFirst();

                        pc1.CardList.add(repository.playedCardList.getFirst());
                        repository.playedCardList.removeFirst();

                        pc2.CardList.add(repository.playedCardList.getFirst());
                        repository.playedCardList.removeFirst();
                        uno.setNumberOfPlayer(4);
                    }
                    turn = uno.realBaghiMande(i);
                    uno.setTurn(turn);
                    printer.playWithFour(players[0], players[1], players[2], players[3], repository, uno);
                    first = false;
                    while (repository.playedCardList.getLast().getNumber() > 9)
                        Collections.shuffle(repository.playedCardList);
                }
                turn = uno.realBaghiMande(i);
                uno.setTurn(turn);
                nobat = turn ;
                if (players[nobat].playIsValid(repository)) {
                    if (players[nobat] instanceof User)
                        ((User) players[nobat]).putCard(repository, uno);
                    else if (players[nobat] instanceof PcPlayer)
                        ((PcPlayer) players[nobat]).puttingAutomatic(repository, uno);
                } else if (repository.getForfeit() == 1 && !players[nobat].playIsValid(repository)) {
                    players[nobat].getCard(repository);
                    printer.playWithFour(players[0], players[1], players[2], players[3], repository, uno);
                    Thread.sleep(5000);
                    if (players[nobat].playIsValid(repository)) {
                        if (players[nobat] instanceof User)
                            ((User) players[nobat]).putCard(repository, uno);
                        else if (players[nobat] instanceof PcPlayer)
                            ((PcPlayer) players[nobat]).puttingAutomatic(repository, uno);
                    }
                } else if (repository.getForfeit() > 1 && !players[turn].playIsValid(repository)) {
                    players[nobat].getCard(repository);
                }
                if (players[0].CardList.size() == 0) {
                    printer.score(players[0], players[1], players[2], players[3]);
                    break;
                }
                if (players[1].CardList.size() == 0) {
                    printer.score(players[0], players[1], players[2], players[3]);
                    break;
                }
                if (players[2].CardList.size() == 0) {
                    printer.score(players[0], players[1], players[2], players[3]);
                    break;
                }
                if (players[3].CardList.size() == 0) {
                    printer.score(players[0], players[1], players[2], players[3]);
                    break;
                }
                i = uno.getTurn();
                i += uno.getRotation();
                turn = uno.realBaghiMande(i);
                uno.setTurn(turn);
                nobat = uno.getTurn();
                printer.playWithFour(players[0], players[1], players[2], players[3], repository, uno);
                Thread.sleep(5000);
            }


            if (kind == 3) {
                if (first) {
                    uno.fillTheCardsAtFirst(repository);
                    for (int k = 0; k < 7; ++k) {
                        Collections.shuffle(repository.playedCardList);
                        me.CardList.add(repository.playedCardList.getFirst());
                        repository.playedCardList.removeFirst();
                        pc.CardList.add(repository.playedCardList.getFirst());
                        repository.playedCardList.removeFirst();
                        pc1.CardList.add(repository.playedCardList.getFirst());
                        repository.playedCardList.removeFirst();
                        uno.setNumberOfPlayer(3);
                    }
                    turn = uno.realBaghiMande(i);
                    uno.setTurn(turn);
                    printer.playWithThree(players[0], players[1], players[2], repository, uno);
                    first = false;
                    while (repository.playedCardList.getLast().getNumber() > 9)
                        Collections.shuffle(repository.playedCardList);
                }
                turn = uno.realBaghiMande(i);
                uno.setTurn(turn);
                if (players[nobat].playIsValid(repository)) {
                    if (players[nobat] instanceof User)
                        ((User) players[nobat]).putCard(repository, uno);
                    else if (players[nobat] instanceof PcPlayer)
                        ((PcPlayer) players[nobat]).puttingAutomatic(repository, uno);
                } else if (repository.getForfeit() == 1 && !players[nobat].playIsValid(repository)) {
                    players[nobat].getCard(repository);
                    printer.playWithThree(players[0], players[1], players[2], repository, uno);
                    Thread.sleep(5000);
                    if (players[nobat].playIsValid(repository)) {
                        if (players[nobat] instanceof User)
                            ((User) players[nobat]).putCard(repository, uno);
                        else if (players[nobat] instanceof PcPlayer)
                            ((PcPlayer) players[nobat]).puttingAutomatic(repository, uno);
                    }
                } else if (repository.getForfeit() > 1 && !players[turn].playIsValid(repository)) {
                    players[nobat].getCard(repository);
                }
                if (players[0].CardList.size() == 0) {
                    printer.score(players[0], players[1], players[2]);
                    break;
                }
                if (players[1].CardList.size() == 0) {
                    printer.score(players[0], players[1], players[2]);
                    break;
                }
                if (players[2].CardList.size() == 0) {
                    printer.score(players[0], players[1], players[2]);
                    break;
                }

                i = uno.getTurn();
                i += uno.getRotation();
                turn = uno.realBaghiMande(i);
                uno.setTurn(turn);
                nobat = uno.getTurn();
                printer.playWithThree(players[0], players[1], players[2], repository, uno);
                Thread.sleep(5000);
            }
            if (kind == 5) {
                if (first) {
                    uno.fillTheCardsAtFirst(repository);
                    for (int k = 0; k < 7; ++k) {
                        Collections.shuffle(repository.playedCardList);
                        me.CardList.add(repository.playedCardList.getFirst());
                        repository.playedCardList.removeFirst();
                        pc.CardList.add(repository.playedCardList.getFirst());
                        repository.playedCardList.removeFirst();
                        pc1.CardList.add(repository.playedCardList.getFirst());
                        repository.playedCardList.removeFirst();
                        pc2.CardList.add(repository.playedCardList.getFirst());
                        repository.playedCardList.removeFirst();
                        pc3.CardList.add(repository.playedCardList.getFirst());
                        repository.playedCardList.removeFirst();
                        uno.setNumberOfPlayer(5);
                    }
                    printer.printing5(players[0], players[1], players[2], players[4], players[3], repository, uno);
                    first = false;
                    while (repository.playedCardList.getLast().getNumber() > 9)
                        Collections.shuffle(repository.playedCardList);
                    nobat = uno.realBaghiMande(i);
                    uno.setTurn(nobat);
                }
                turn = uno.realBaghiMande(i);
                uno.setTurn(turn);
                if (players[nobat].playIsValid(repository)) {
                    if (players[nobat] instanceof User)
                        ((User) players[nobat]).putCard(repository, uno);
                    else if (players[nobat] instanceof PcPlayer)
                        ((PcPlayer) players[nobat]).puttingAutomatic(repository, uno);
                } else if (repository.getForfeit() == 1 && !players[nobat].playIsValid(repository)) {
                    players[nobat].getCard(repository);
                    printer.printing5(players[0], players[1], players[2], players[3], players[4], repository, uno);
                    Thread.sleep(5000);
                    if (players[nobat].playIsValid(repository)) {
                        if (players[nobat] instanceof User)
                            ((User) players[nobat]).putCard(repository, uno);
                        else if (players[nobat] instanceof PcPlayer)
                            ((PcPlayer) players[nobat]).puttingAutomatic(repository, uno);
                    }
                } else if (repository.getForfeit() > 1 && !players[i % 4].playIsValid(repository)) {
                    players[nobat].getCard(repository);
                }
                i = uno.getTurn();
                i += uno.getRotation();
                turn = uno.realBaghiMande(i);
                uno.setTurn(turn);
                nobat = uno.getTurn();

                if (players[0].CardList.size() == 0) {
                    printer.score(players[0], players[1], players[2], players[3], players[4]);
                    break;
                }
                if (players[1].CardList.size() == 0) {
                    printer.score(players[0], players[1], players[2], players[3], players[4]);
                    break;
                }
                if (players[2].CardList.size() == 0) {
                    printer.score(players[0], players[1], players[2], players[3], players[4]);
                    break;
                }
                if (players[3].CardList.size() == 0) {
                    printer.score(players[0], players[1], players[2], players[3], players[4]);
                    break;
                }
                if (players[4].CardList.size() == 0) {
                    printer.score(players[0], players[1], players[2], players[3], players[4]);
                    break;
                }

                printer.printing5(players[0], players[1], players[2], players[3], players[4], repository, uno);
                Thread.sleep(5000);
            }
        }
    }
}
