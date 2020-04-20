package com.company;

import static com.company.Color.*;

public class Main {

    public static void main(String[] args) {

        // Printing.printChangeColor();
        upperSide2(10);
        edge2(10);
        upperSide2(10);

    }

    public static void upperSide2(int n) {
        int color;
        boolean flag = true;
        System.out.print("\t\t ");
        for (int i = 0; i < n; ++i) {
            color = (i + 14) % 4 + 1;
            System.out.print(CYAN_BACKGROUND + "\t      " + RESET);
            if (i + 1 == n && flag) {
                flag = false;
                System.out.print(CYAN_BACKGROUND + "\t       " + RESET);
            } else
                System.out.print(" ");
        }
        System.out.println();

    }
    public static void edge2(int n) {
        boolean flag = true;
        int a = 9617 ;
        char b = (char) a ;
        int height = 5;
        for (int j = 0; j < height; ++j) {
            for (int i = 0; i < n; ++i) {
                int color = (i + 14) % 4 + 1;
                if (i == 0) {
                    System.out.print("\t\t ");

                    System.out.print(CYAN_BACKGROUND+"\t" + WHITE_BACKGROUND_BRIGHT + "\t  " + RESET + " ");

                } else {
                    System.out.print(CYAN_BACKGROUND+"   "+ WHITE_BACKGROUND_BRIGHT+PURPLE_BOLD_BRIGHT  + b+b+b+b + RESET);
                    if (i + 1 == n) {
                        lastCardEdge2(color);
                    } else
                        System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void lastCardEdge2(int color) {
            System.out.print(WHITE_BACKGROUND_BRIGHT + "\t\t" + RESET + CYAN_BACKGROUND + "   " + RESET + " ");
    }

}
