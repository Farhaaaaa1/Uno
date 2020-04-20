package com.company;

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

    public void createMine(int n) {
        upperSide1(n);
        edgeNumber(n);
        edge1(n);
        upperSide1(n);

    }

    public void createPc(int n) {
        upperSide2(n);
        edge2(n);
        upperSide2(n);

    }


    public void upperSide1(int n) {
        int color;
        boolean flag = true;
        System.out.print("\t\t\t\t\t\t ");
        for (int i = 0; i < n; ++i) {
            color = (i + 14) % 4 + 1;

            if (color == 1) {
                System.out.print(BLUE_BACKGROUND);
            } else if (color == 2) {
                System.out.print(RED_BACKGROUND);
            } else if (color == 3) {
                System.out.print(YELLOW_BACKGROUND);
            } else if (color == 4) {
                System.out.print(GREEN_BACKGROUND);
            }
            System.out.print("\t      " + RESET);


            if (i + 1 == n && flag) {
                flag = false;
                if (color == 1) {
                    System.out.print(BLUE_BACKGROUND + "\t\t   " + RESET);
                } else if (color == 2) {
                    System.out.print(RED_BACKGROUND + "\t\t   " + RESET);
                } else if (color == 3) {
                    System.out.print(YELLOW_BACKGROUND + "\t\t   " + RESET);
                } else if (color == 4) {
                    System.out.print(GREEN_BACKGROUND + "\t\t   " + RESET);
                }
            } else
                System.out.print(" ");
        }
        System.out.println();

    }


    public void edge1(int n) {
        boolean flag = true;
        int height = 4;
        for (int j = 0; j < height; ++j) {
            for (int i = 0; i < n; ++i) {
                int color = (i + 14) % 4 + 1;
                if (i == 0) {
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
                    System.out.print("\t" + WHITE_BACKGROUND_BRIGHT + "\t  " + RESET + " ");

                } else {
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
                    if (i + 1 == n) {
                        lastCardEdge(color);
                    } else
                        System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void edgeNumber(int n) {
        int sign[] = new int[]{48, 49, 8635, 51, 52, 53, 54, 55, 56, 57, 8635, 9314, 9314, 9314, 9314,};
        boolean flag = true;
        for (int i = 0; i < n; ++i) {
            int color = (i + 14) % 4 + 1;
            if (i == 0) {
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
                System.out.print("   " + WHITE_BACKGROUND_BRIGHT + BLACK_BOLD_BRIGHT + "" + (char) sign[i % 10] + "\t  " + RESET + " ");
            } else {

                if (color == 1) {
                    System.out.print(BLUE_BACKGROUND);
                } else if (color == 2) {
                    System.out.print(RED_BACKGROUND);
                } else if (color == 3) {
                    System.out.print(YELLOW_BACKGROUND);
                } else if (color == 4) {
                    System.out.print(GREEN_BACKGROUND);
                }
                System.out.print("   " + WHITE_BACKGROUND_BRIGHT + BLACK_BOLD_BRIGHT + " " + (char) sign[i % 10] + "  " + RESET);

                if (i + 1 == n && flag) {
                    flag = false;
                    lastCardEdge(color);
                } else
                    System.out.print(" ");
            }
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
        }
    }

    public static void upperSide2(int n) {
        int color;
        int N = n;
        if (n > 11)
            N = 11;
        System.out.print("\t\t\t\t\t\t\t\t ");
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

    public static void edge2(int n) {
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
                    System.out.print("\t\t\t\t\t\t\t\t ");
                    if(j==1 && n!=N)
                        flag = true ;
                    else
                        flag = false ;
                    lastCardEdge2(color,flag);
                    if (j ==1 && n!=N) {
                        System.out.print(BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + "" + n + "  "  + BLUE_BACKGROUND + "\t  " + RESET + " ");
                    }
                   else System.out.print(BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + " " + b + " " + b + BLUE_BACKGROUND + "\t  " + RESET + " ");

                } else {
                    System.out.print(BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + b + " " + b + " " + BLUE_BACKGROUND + "   " + RESET);

                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void lastCardEdge2(int color,boolean flag) {
        int a = 3664;
        char b = (char) a;
        if(flag)
            System.out.print(RESET + BLUE_BACKGROUND_BRIGHT + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT  + "  NO."  + " " + RESET + "");
        else
            System.out.print(RESET + BLUE_BACKGROUND_BRIGHT + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + b + " " + b + " " + b + " " + RESET + "");
    }
}

