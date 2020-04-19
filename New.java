package com.company;

import java.util.LinkedList;

import static com.company.Color.*;

public class New {

    public static void main(String[] args) {
        int n = 16;
        for (int i = 0; i < 7; ++i)
            System.out.println();
        upperSide1(n);
        edgeNumber(n);
        edge1(n);
        upperSide1(n);
        for (int i = 0; i < 20; ++i)
            System.out.println();

        upperSide1(n);
        edge1(n);
        upperSide1(n);
    }

    public static void upperSide1(int n) {
        int color;
        boolean flag = true;
        System.out.print("\t\t ");
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



    public static void edge1(int n) {
        boolean flag = true;
        int height = 4;
        for (int j = 0; j < height; ++j) {
            for (int i = 0; i < n; ++i) {
                int color = (i + 14) % 4 + 1;
                if (i == 0) {
                    System.out.print("\t\t ");
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

    public static void edgeNumber(int n) {
        boolean flag = true;
        for (int i = 0; i < n; ++i) {
            int color = (i + 14) % 4 + 1;
            if (i == 0) {
                System.out.print("\t\t ");
                if (color == 1) {
                    System.out.print(BLUE_BACKGROUND);
                } else if (color == 2) {
                    System.out.print(RED_BACKGROUND);
                } else if (color == 3) {
                    System.out.print(YELLOW_BACKGROUND);
                } else if (color == 4) {
                    System.out.print(GREEN_BACKGROUND);
                }
                System.out.print("   " + WHITE_BACKGROUND_BRIGHT + BLACK_BOLD_BRIGHT + " " + i % 10 + "\t  " + RESET+" ");
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
                System.out.print( "   " + WHITE_BACKGROUND_BRIGHT + BLACK_BOLD_BRIGHT + " " + i % 10 + "  " + RESET);

                if (i + 1 == n && flag) {
                    flag = false;
                    lastCardEdge(color);
                } else
                    System.out.print(" ");
            }
        }
        System.out.println();


    }

    public static void lastCardEdge(int color) {
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
}
