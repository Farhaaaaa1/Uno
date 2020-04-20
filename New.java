package com.company;

import java.util.LinkedList;

import static com.company.Color.*;

public class New {
    public static void main(String[] args) {
        Printing printer = new Printing();
        printer.createPc(12);
        System.out.println();
        sides(1, 4);
        System.out.println();
        printer.createMine(14);

    }

    public static void sides(int number1, int number2) {
        int fakeNumber1 = number1;
        int fakeNumber2 = number2;
        if (number1 > 5)
            fakeNumber1 = 5;
        if (number2 > 5)
            fakeNumber2 = 5;
        // top of the complete card
        upperSide3(fakeNumber1, fakeNumber2);
        //just block
        usualPrint();
        // print number of the card
        middleSide3Number(number1, number2);
        //just block
        usualPrint();
        // down of the complete card
        upperSide3(fakeNumber1, fakeNumber2);
        System.out.println();
        middleSide3(fakeNumber1, fakeNumber2);
        System.out.println();
        fakeNumber1--;
        fakeNumber2--;
    }


    public static void upperSide3(int number1, int number2) {
        int width = 16;
        if (number1 > 0) {
            System.out.print(BLUE_BACKGROUND + "\t\t\t\t\t\t" + RESET);
        } else
            System.out.print("\t\t\t\t\t\t");
        for (int i = 0; i < width; ++i) {
            System.out.print("\t\t");
        }
        if (number2 >= 1) {
            System.out.println(BLUE_BACKGROUND + "\t\t\t\t\t\t" + RESET);
        } else
            System.out.print("\t\t\t\t\t\t");
    }

    public static void middleSide3(int number1, int number2) {
        // pattern of the cards
        int a = 3664;
        char b = (char) a;
        // width of the cards
        int width = 16;
        //k = row of the cards may be height of the card
        for (int k = 0; k < 4; ++k) {
            if (number1 > 1) {
                System.out.print(BLUE_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + BLUE_BACKGROUND + "   " + RESET);
                number1--;
            } else {
                System.out.print("\t\t\t\t\t\t ");
                number1--;
            }

            for (int i = 0; i < width; ++i) {
                System.out.print("\t\t");
            }
            if (number2 > 1) {
                System.out.println(BLUE_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + BLUE_BACKGROUND + "   " + RESET);
                number2--;
            } else {
                System.out.println("\t\t\t\t\t\t ");
                number2--;
            }
            upperSide3(number1, number2);

            System.out.println();
        }
    }

    public static void middleSide3Number(int number1, int number2) {
        int a = 3664;
        char b = (char) a;
        int width = 16;

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

    public static void usualPrint() {
        int a = 3664;
        char b = (char) a;
        int width = 16;
        System.out.print(BLUE_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + BLUE_BACKGROUND + "   " + RESET);
        for (int i = 0; i < width; ++i)
            System.out.print("\t\t");
        System.out.println(BLUE_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + BLUE_BACKGROUND + "   " + RESET);
    }
}