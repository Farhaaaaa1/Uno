package com.company;

import java.util.LinkedList;

import static com.company.Color.*;

public class Printing {
    public static void printChangeColor() {
        // hashie ye bala
        final char c = '\u2573';
        for (int i = 0; i < 4; ++i) {
            System.out.print("\t\u001b[47m\t\t\t\t\t\t\t\t \u001b[0m");
            System.out.print("\t");
        }

        System.out.println();
        // badane balayi
        for (int i = 1; i < 7; ++i) {
            System.out.print("\t\u001b[47m  \u001b[44m\u001b[37m\t\t\t   \u001b[0m   \u001b[42m\u001b[37m" + c + c + c + c + c + c + c + c + c + c + c + c + c + "\u001b[0m\u001b[47m  \u001b[0m\t");
            System.out.print("\t\u001b[47m  \u001b[44m\u001b[37m" + c + c + c + c + c + c + c + c + c + c + c + c + c + "\u001b[0m   \u001b[42m\u001b[37m\t\t\t   \u001b[0m\u001b[47m  \u001b[0m\t");
            System.out.print("\t\u001b[47m  \u001b[44m\u001b[37m" + c + c + c + c + c + c + c + c + c + c + c + c + c + "\u001b[0m   \u001b[42m\u001b[37m" + c + c + c + c + c + c + c + c + c + c + c + c + c + "\u001b[0m\u001b[47m  \u001b[0m\t");
            System.out.print("\t\u001b[47m  \u001b[44m\u001b[37m" + c + c + c + c + c + c + c + c + c + c + c + c + c + "\u001b[0m   \u001b[42m\u001b[37m" + c + c + c + c + c + c + c + c + c + c + c + c + c + "\u001b[0m\u001b[47m  \u001b[0m\t");
            // hashie beyn e do ta
            System.out.println();
        }
        // hashie ye bein
        for (int i = 0; i < 4; ++i)
            System.out.print("\t\u001b[47m  \u001b[0m\t\t\t\t\t\t\t   \u001b[47m  \u001b[0m\t");
        System.out.println();
        //badaneye dovvom
        for (int i = 1; i < 7; ++i) {
            System.out.print("\t\u001b[47m  \u001b[43m\u001b[37m" + c + c + c + c + c + c + c + c + c + c + c + c + c + "\u001b[0m   \u001b[41m\u001b[37m" + c + c + c + c + c + c + c + c + c + c + c + c + c + "\u001b[0m\u001b[47m  \u001b[0m\t");
            System.out.print("\t\u001b[47m  \u001b[43m\u001b[37m" + c + c + c + c + c + c + c + c + c + c + c + c + c + "\u001b[0m   \u001b[41m\u001b[37m" + c + c + c + c + c + c + c + c + c + c + c + c + c + "\u001b[0m\u001b[47m  \u001b[0m\t");
            System.out.print("\t\u001b[47m  \u001b[43m\u001b[37m" + c + c + c + c + c + c + c + c + c + c + c + c + c + "\u001b[0m   \u001b[41m\u001b[37m\t\t\t   \u001b[0m\u001b[47m  \u001b[0m\t");
            System.out.print("\t\u001b[47m  \u001b[43m\u001b[37m\t\t\t   \u001b[0m   \u001b[41m\u001b[37m" + c + c + c + c + c + c + c + c + c + c + c + c + c + "\u001b[0m\u001b[47m  \u001b[0m\t");
            System.out.println();
        }
        // hashie ye bala
        for (int i = 0; i < 4; ++i) {
            System.out.print("\t\u001b[47m\t\t\t\t\t\t\t\t \u001b[0m\t");
        }
        System.out.println("\n\n\t\t\t\t   \u001b[47m 1 \u001b[0m\t\t\t\t\t\t\t\t\t   \u001b[47m 2 \u001b[0m" +
                "\t\t\t\t\t\t\t\t\t   \u001b[47m 3 \u001b[0m\t\t\t\t\t\t\t\t\t   \u001b[47m 4 \u001b[0m");
        System.out.print("\n  choose the color : ");
    }

    public void playWithFour(Player number1, Player number2, Player number3, Player number4, Repository repository, GameSystem gameSystem) {
        createPc(number4.CardList);
        if(gameSystem.getTurn()==1)
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+YELLOW_BACKGROUND_BRIGHT+"\t"+RESET);
        printSides(number1.CardList, number3.CardList, repository, gameSystem.getTurn());
        if (gameSystem.getRotation() > 0)
            System.out.println("                                                  " +
                    "                                       " + "  Clock Wise\n");
        if (gameSystem.getRotation() < 0)
            System.out.println("                                                  " +
                    "                                       " + " counter Clock Wise\n");
        createMine(number2.CardList);
        System.out.println();
    }

    public void playWithThree(Player number1, Player number2, Player number3, Repository repository, GameSystem gameSystem) {
        printSides(number1.CardList, number2.CardList, repository, gameSystem.getTurn());
        System.out.println("                                                  " +
                "                                       " + "  Clock Wise\n");
        if (gameSystem.getRotation() < 0)
            System.out.println("                                                  " +
                    "                                       " + " counter Clock Wise\n");
        createMine(number3.CardList);
    }

    public void createMine(LinkedList<Card> cardList) {
        int i = 1;
        boolean seccondRow = false;
        LinkedList<Card> firstRow = new LinkedList();
        LinkedList<Card> supRow = new LinkedList();
        if (cardList.size() > 19) {
            firstRow.clear();
            for (Card A :
                    cardList) {
                i++;
                firstRow.add(A);
                if (i == 20)
                    break;
            }
            for (int k = 19; k < cardList.size(); ++k) {
                supRow.add(cardList.get(k));
            }
            i = 1;
            seccondRow = true;
        } else
            firstRow.addAll(cardList);
        upperSide1(firstRow);
        edgeNumber(firstRow);
        edge1(firstRow);
        upperSide1(firstRow);
        System.out.print("\t\t\t\t\t\t\t   ");
        while (i <= firstRow.size()) {
            System.out.print(i + "\t   ");
            i++;
        }
        if (seccondRow) {
            System.out.println();
            upperSide1(supRow);
            edgeNumber(supRow);
            edge1(supRow);
            upperSide1(supRow);
            System.out.print("\t\t\t\t\t\t\t   ");
            i = 1;
            while (i <= supRow.size()) {
                System.out.print(i + 19 + "\t   ");
                i++;
            }
        }
    }

    public void createPc(LinkedList<Card> cards) {
        upDown2(cards);
        edge2(cards.size());
        upDown2(cards);

    }

    public void printSides(LinkedList<Card> cards1, LinkedList<Card> cards2, Repository repository, int turn) {
        int width = 18;
        int fakeNumber1 = cards1.size();
        int fakeNumber2 = cards2.size();
        if (cards1.size() > 5)
            fakeNumber1 = 5;
        if (cards2.size() > 5)
            fakeNumber2 = 5;
        // top of the complete card
        upDown3(fakeNumber1, fakeNumber2, 10, repository);
        //just block
        block(turn);
        // print number of the card
        edge3Number(cards1.size(), cards2.size());
        //just block give kind of number that not involve in color or etc
        block(100);
        // down of the complete card
        upDown3(fakeNumber1, fakeNumber2, 10, repository);
        colorInTheSide(repository);
        edge3(fakeNumber1, fakeNumber2, repository);
        System.out.println();
    }


    public void upperSide1(LinkedList<Card> cards) {
        int color;
        boolean flag = true;
        System.out.print("\t\t\t\t\t\t ");
        for (int i = 0; i < cards.size(); ++i) {
            color = cards.get(i).getColor();

            if (color == 1) {
                System.out.print(BLUE_BACKGROUND);
            } else if (color == 2) {
                System.out.print(RED_BACKGROUND);
            } else if (color == 3) {
                System.out.print(YELLOW_BACKGROUND);
            } else if (color == 4) {
                System.out.print(GREEN_BACKGROUND);
            } else if (color == 5) {
                System.out.print(CYAN_BACKGROUND_BRIGHT);
            }

            System.out.print("\t      " + RESET);


            if (i + 1 == cards.size() && flag) {
                flag = false;
                if (color == 1) {
                    System.out.print(BLUE_BACKGROUND + "\t\t   " + RESET);
                } else if (color == 2) {
                    System.out.print(RED_BACKGROUND + "\t\t   " + RESET);
                } else if (color == 3) {
                    System.out.print(YELLOW_BACKGROUND + "\t\t   " + RESET);
                } else if (color == 4) {
                    System.out.print(GREEN_BACKGROUND + "\t\t   " + RESET);
                } else if (color == 5) {
                    System.out.print(CYAN_BACKGROUND_BRIGHT + "\t\t   " + RESET);
                }
            } else
                System.out.print(" ");
        }
        System.out.println();

    }


    public void edge1(LinkedList<Card> cards) {
        boolean flag = true;
        int height = 4;
        for (int j = 0; j < height; ++j) {
            for (int i = 0; i < cards.size(); ++i) {
                int color = cards.get(i).getColor();
                if (i == 0) {
                    if (color < 5) {
                        System.out.print("\t\t\t\t\t\t ");
                        if (color == 1) {
                            System.out.print(BLUE_BACKGROUND);
                        } else if (color == 2) {
                            System.out.print(RED_BACKGROUND);
                        } else if (color == 3) {
                            System.out.print(YELLOW_BACKGROUND);
                        } else if (color == 4) {
                            System.out.print(GREEN_BACKGROUND);
                        }
                        System.out.print("\t" + WHITE_BACKGROUND_BRIGHT + "\t  " + RESET);
                    } else if (color == 5) {
                        System.out.print("\t\t\t\t\t\t ");
                        System.out.print(CYAN_BACKGROUND_BRIGHT);
                        System.out.print("\t" + BLACK_BACKGROUND_BRIGHT + "\t  " + RESET);
                    }
                } else {
                    if (color < 5) {
                        if (color == 1) {
                            System.out.print(BLUE_BACKGROUND);
                        } else if (color == 2) {
                            System.out.print(RED_BACKGROUND);
                        } else if (color == 3) {
                            System.out.print(YELLOW_BACKGROUND);
                        } else if (color == 4) {
                            System.out.print(GREEN_BACKGROUND);
                        }
                        System.out.print("   " + WHITE_BACKGROUND_BRIGHT + "    " + RESET);
                    } else if (color == 5)
                        System.out.print(CYAN_BACKGROUND_BRIGHT + "   " + BLACK_BACKGROUND_BRIGHT + "    " + RESET);

                }
                if (i + 1 == cards.size()) {
                    lastCardEdge(color);
                } else
                    System.out.print(" ");

            }
            System.out.println();
        }
    }

    public void edgeNumber(LinkedList<Card> cards) {
        int sign[] = new int[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 8635, 10005, 9112, (int) ' '};
        boolean flag = true;
        for (int i = 0; i < cards.size(); ++i) {
            int color = cards.get(i).getColor();
            if (i == 0) {
                System.out.print("\t\t\t\t\t\t ");
                if (color < 5) {
                    if (color == 1) {
                        System.out.print(BLUE_BACKGROUND);
                    } else if (color == 2) {
                        System.out.print(RED_BACKGROUND);
                    } else if (color == 3) {
                        System.out.print(YELLOW_BACKGROUND);
                    } else if (color == 4) {
                        System.out.print(GREEN_BACKGROUND);
                    }
                    System.out.print("   " + WHITE_BACKGROUND_BRIGHT + BLACK_BOLD_BRIGHT + "" + (char) sign[cards.get(i).getNumber()] + "\t  " + RESET + "");
                } else if (color == 5) {
                    System.out.print(CYAN_BACKGROUND_BRIGHT);
                    System.out.print("   " + BLACK_BACKGROUND_BRIGHT + WHITE_BOLD_BRIGHT + "" + (char) sign[cards.get(i).getNumber()] + "\t  " + RESET + "");
                }
            } else {
                if (color < 5) {
                    if (color == 1) {
                        System.out.print(BLUE_BACKGROUND);
                    } else if (color == 2) {
                        System.out.print(RED_BACKGROUND);
                    } else if (color == 3) {
                        System.out.print(YELLOW_BACKGROUND);
                    } else if (color == 4) {
                        System.out.print(GREEN_BACKGROUND);
                    }
                    System.out.print("   " + WHITE_BACKGROUND_BRIGHT + BLACK_BOLD_BRIGHT + " " + (char) sign[cards.get(i).getNumber()] + "  " + RESET);
                } else if (color == 5)
                    System.out.print(CYAN_BACKGROUND_BRIGHT + "   " + BLACK_BACKGROUND_BRIGHT + WHITE_BOLD_BRIGHT + " " + (char) sign[cards.get(i).getNumber()] + "  " + RESET);

            }

            if (i + 1 == cards.size() && flag) {
                flag = false;
                lastCardEdge(color);
            } else
                System.out.print(" ");
        }

        System.out.println();
    }

    public void lastCardEdge(int color) {
        if (color == 1) {
            System.out.print(WHITE_BACKGROUND_BRIGHT + "\t\t" + RESET + BLUE_BACKGROUND + "   " + RESET + " ");
        } else if (color == 2) {
            System.out.print(WHITE_BACKGROUND_BRIGHT + "\t\t" + RESET + RED_BACKGROUND + "   " + RESET + " ");
        } else if (color == 3) {
            System.out.print(WHITE_BACKGROUND_BRIGHT + "\t\t" + RESET + YELLOW_BACKGROUND + "   " + RESET);
        } else if (color == 4) {
            System.out.print(WHITE_BACKGROUND_BRIGHT + "\t\t" + RESET + GREEN_BACKGROUND + "   " + RESET + " ");
        } else if (color == 5) {
            System.out.print(BLACK_BACKGROUND_BRIGHT + "\t\t" + RESET + CYAN_BACKGROUND_BRIGHT + "   " + RESET + " ");
        }
    }

    public void upDown2(LinkedList<Card> list) {
        int color;
        int N = list.size();
        if (list.size() > 11)
            N = 11;
        System.out.print("\t\t\t\t\t\t\t\t\t ");
        for (int i = 0; i < N + 1; ++i) {
            color = (i + 14) % 4 + 1;
            if (i == 0) {
                System.out.print(BLUE_BACKGROUND + "\t       " + RESET);
            } else {
                System.out.print(BLUE_BACKGROUND + "\t      " + RESET);
                System.out.print(" ");
            }
        }
        System.out.println();

    }

    public void edge2(int n) {
        int N = n;
        if (n > 11)
            N = 11;
        boolean flag = false;
        int a = 3664;
        char b = (char) a;
        int height = 5;
        for (int j = 0; j < height; ++j) {
            for (int i = 0; i < N; ++i) {
                int color = (i + 14) % 4 + 1;
                if (i == 0) {
                    System.out.print("\t\t\t\t\t\t\t\t\t ");
                    if (j == 1 && n != N)
                        flag = true;
                    else
                        flag = false;
                    lastCardEdge2(color, flag);
                    if (j == 1 && n != N) {
                        System.out.print(BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + "" + n + "  " + BLUE_BACKGROUND + "\t  " + RESET + " ");
                    } else
                        System.out.print(BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + " " + b + " " + b + BLUE_BACKGROUND + "\t  " + RESET + " ");

                } else {
                    System.out.print(BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + b + " " + b + " " + BLUE_BACKGROUND + "   " + RESET);

                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void lastCardEdge2(int color, boolean flag) {
        int a = 3664;
        char b = (char) a;
        if (flag)
            System.out.print(RESET + BLUE_BACKGROUND_BRIGHT + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + "  NO." + " " + RESET + "");
        else
            System.out.print(RESET + BLUE_BACKGROUND_BRIGHT + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + b + " " + b + " " + b + " " + RESET + "");
    }


    public void upDown3(int number1, int number2, int row, Repository repository) {
        int width = 18;
        if (number1 > 0) {
            System.out.print(BLUE_BACKGROUND + "\t\t\t\t\t\t" + RESET);
        } else
            System.out.print("\t\t\t\t\t\t");
        if (row < 2)
            colorInMiddle(repository);
        else
            for (int i = 0; i < width; ++i) {
                System.out.print("\t\t");
            }

        if (number2 >= 1) {
            System.out.println(BLUE_BACKGROUND + "\t\t\t\t\t\t" + RESET);
        } else
            System.out.println("\t\t\t\t\t\t");
    }


    public void edge3(int number1, int number2, Repository repository) {
        // pattern of the cards
        int a = 3664;
        char b = (char) a;
        // width of the cards
        int width = 18;
        //k = row of the cards may be height of the card
        for (int k = 0; k < 4; ++k) {
            if (number1 > 1) {
                System.out.print(BLUE_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + " " + b + " " + b + " " + b + " "
                        + b + " " + b + " " + b + " " + b + " " + b + " " + b + BLUE_BACKGROUND + "   " + RESET);
                number1--;
            } else {
                System.out.print("\t\t\t\t\t\t ");
                number1--;
            }

            if (k == 0)
                colorInMiddleNumber(repository);
            else if (k == 1)
                colorInMiddle(repository);
            else
                for (int i = 0; i < width; ++i) {
                    System.out.print("\t\t");
                }

            if (number2 > 1) {
                System.out.println(BLUE_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + " " + b + " " + b + " " + b + " "
                        + b + " " + b + " " + b + " " + b + " " + b + " " + b + BLUE_BACKGROUND + "   " + RESET);
                number2--;
            } else {
                System.out.println("\t\t\t\t\t\t ");
                number2--;
            }
            upDown3(number1, number2, k, repository);
            if (k < 1) {
                System.out.print("\t\t\t\t\t\t");
                colorInMiddle(repository);
                System.out.println();
            } else if (k == 1) {
                colorInTheSide(repository);
            } else
                System.out.println();
        }
    }

    public void edge3Number(int number1, int number2) {
        int a = 3664;
        char b = (char) a;
        int width = 18;

        if (number1 > 10) {
            System.out.print(BLUE_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + "     NO.  " + " " + number1 + "     " + BLUE_BACKGROUND + "   " + RESET);
        } else
            System.out.print(BLUE_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + "     NO.  " + " " + number1 + "      " + BLUE_BACKGROUND + "   " + RESET);

        for (int i = 0; i < width; ++i)
            System.out.print("\t\t");

        if (number2 > 10) {
            System.out.println(BLUE_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + "     NO.  " + " " + number2 + "     " + BLUE_BACKGROUND + "   " + RESET);
        } else
            System.out.println(BLUE_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + "     NO.  " + " " + number2 + "      " + BLUE_BACKGROUND + "   " + RESET);
    }

    public void block(int light) {
        int a = 3664;
        char b = (char) a;
        int width = 18;
        System.out.print(BLUE_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + BLUE_BACKGROUND + "   " + RESET);
        if (light == 0)
            System.out.print(" " + YELLOW_BACKGROUND_BRIGHT + "\t" + RESET);
        else
            System.out.print("\t" + RESET);
        for (int i = 0; i < width - 2; ++i)
            System.out.print("\t\t");
        if (light == 2)
            System.out.print("\t\t" + YELLOW_BACKGROUND_BRIGHT + "   " + RESET + " ");
        else
            System.out.print("\t\t    ");

        System.out.println(BLUE_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + BLUE_BACKGROUND + "   " + RESET);
    }


    public void colorInTheSide(Repository repository) {
        int width = 18;
        int color = repository.playedCardList.getLast().getColor();
        for (int i = 0; i < width - 9; ++i)
            System.out.print("\t\t");
        System.out.print(BLUE_BACKGROUND + "   \t\t\t     " + RESET);
        System.out.print("\t");
        if (color == 1)
            System.out.print(BLUE_BACKGROUND + "   \t\t\t     " + RESET);
        if (color == 2)
            System.out.print(RED_BACKGROUND + "   \t\t\t     " + RESET);
        if (color == 3)
            System.out.print(YELLOW_BACKGROUND + "   \t\t\t     " + RESET);
        if (color == 4)
            System.out.print(GREEN_BACKGROUND + "   \t\t\t     " + RESET);
        if (color == 5)
            System.out.print(CYAN_BACKGROUND_BRIGHT + "   \t\t\t     " + RESET);
        for (int i = 0; i < width - 12; ++i)
            System.out.print("\t\t");
        System.out.println();
    }


    public void colorInMiddle(Repository repository) {
        int width = 18;
        int a = 3664;
        int color = repository.playedCardList.getLast().getColor();
        char b = (char) a;
        for (int i = 0; i < width - 12; ++i)
            System.out.print("\t\t");
        System.out.print(BLUE_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + " " + b + " " + b + " " + b + " " + b + " " + b + " " + BLUE_BACKGROUND + "   " + RESET);
        System.out.print("\t");
        if (repository.playedCardList.getLast() instanceof WildCard) {
            if (color == 1)
                System.out.print(BLUE_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + "\t\t\t  " + BLUE_BACKGROUND + "   " + RESET);
            else if (color == 2)
                System.out.print(RED_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + "\t\t\t  " + RED_BACKGROUND + "   " + RESET);
            else if (color == 3)
                System.out.print(YELLOW_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + "\t\t\t  " + YELLOW_BACKGROUND + "   " + RESET);
            else if (color == 4)
                System.out.print(GREEN_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + "\t\t\t  " + GREEN_BACKGROUND + "   " + RESET);
        } else if (color == 1)
            System.out.print(BLUE_BACKGROUND + "   " + WHITE_BACKGROUND_BRIGHT + "\t\t\t  " + BLUE_BACKGROUND + "   " + RESET);
        else if (color == 2)
            System.out.print(RED_BACKGROUND + "   " + WHITE_BACKGROUND_BRIGHT + "\t\t\t  " + RED_BACKGROUND + "   " + RESET);
        else if (color == 3)
            System.out.print(YELLOW_BACKGROUND + "   " + WHITE_BACKGROUND_BRIGHT + "\t\t\t  " + YELLOW_BACKGROUND + "   " + RESET);
        else if (color == 4)
            System.out.print(GREEN_BACKGROUND + "   " + WHITE_BACKGROUND_BRIGHT + "\t\t\t  " + GREEN_BACKGROUND + "   " + RESET);

        for (int i = 0; i < width - 12; ++i)
            System.out.print("\t\t ");
        System.out.print("\t\t\t");
    }

    public void colorInMiddleNumber(Repository repository) {
        int width = 18;
        int a = 3664;
        char b = (char) a;
        int color = repository.playedCardList.getLast().getColor();
        int number = repository.playedCardList.getLast().getNumber();
        int sign[] = new int[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 8635, 10005, 9112, (int) ' '};
        for (int i = 0; i < width - 12; ++i)
            System.out.print("\t\t");
        System.out.print(BLUE_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + " " + b + " " + b + " " + b + " " + b + " " + b + " " + BLUE_BACKGROUND + "   " + RESET);
        System.out.print("\t");
        if (repository.playedCardList.getLast() instanceof WildCard) {
            if (color == 1)
                System.out.print(BLUE_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + WHITE_BOLD_BRIGHT + " " + (char) sign[number] + "\t\t  " + BLUE_BACKGROUND + "   " + RESET);
            if (color == 2)
                System.out.print(RED_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + WHITE_BOLD_BRIGHT + " " + (char) sign[number] + "\t\t  " + RED_BACKGROUND + "   " + RESET);
            if (color == 3)
                System.out.print(YELLOW_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + WHITE_BOLD_BRIGHT + " " + (char) sign[number] + "\t\t  " + YELLOW_BACKGROUND + "   " + RESET);
            if (color == 4)
                System.out.print(GREEN_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + WHITE_BOLD_BRIGHT + " " + (char) sign[number] + "\t\t  " + GREEN_BACKGROUND + "   " + RESET);
        } else if (color == 1)
            System.out.print(BLUE_BACKGROUND + "   " + WHITE_BACKGROUND_BRIGHT + BLACK_BOLD_BRIGHT + " " + (char) sign[number] + "\t\t  " + BLUE_BACKGROUND + "   " + RESET);
        else if (color == 2)
            System.out.print(RED_BACKGROUND + "   " + WHITE_BACKGROUND_BRIGHT + BLACK_BOLD_BRIGHT + " " + (char) sign[number] + "\t\t  " + RED_BACKGROUND + "   " + RESET);
        else if (color == 3)
            System.out.print(YELLOW_BACKGROUND + "   " + WHITE_BACKGROUND_BRIGHT + BLACK_BOLD_BRIGHT + " " + (char) sign[number] + "\t\t  " + YELLOW_BACKGROUND + "   " + RESET);
        else if (color == 4)
            System.out.print(GREEN_BACKGROUND + "   " + WHITE_BACKGROUND_BRIGHT + BLACK_BOLD_BRIGHT + " " + (char) sign[number] + "\t\t  " + GREEN_BACKGROUND + "   " + RESET);

        for (int i = 0; i < width - 12; ++i)
            System.out.print("\t\t ");
        System.out.print("\t\t\t");
    }

}

