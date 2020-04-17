package com.company;

public class Printing {
    public static void printChangeColor()
    {
        // hashie ye bala
        final char  c = '\u2573' ;
        for (int i = 0; i < 4; ++i) {
            System.out.print("\t\u001b[47m\t\t\t\t\t\t\t\t \u001b[0m");
            System.out.print("\t");
        }

        System.out.println();
        // badane balayi
        for (int i = 1; i < 7; ++i) {
            System.out.print("\t\u001b[47m  \u001b[44m\u001b[37m\t\t\t   \u001b[0m   \u001b[42m\u001b[37m"+c+c+c+c+c+c+c+c+c+c+c+c+c+"\u001b[0m\u001b[47m  \u001b[0m\t");
            System.out.print("\t\u001b[47m  \u001b[44m\u001b[37m"+c+c+c+c+c+c+c+c+c+c+c+c+c+"\u001b[0m   \u001b[42m\u001b[37m\t\t\t   \u001b[0m\u001b[47m  \u001b[0m\t");
            System.out.print("\t\u001b[47m  \u001b[44m\u001b[37m"+c+c+c+c+c+c+c+c+c+c+c+c+c+"\u001b[0m   \u001b[42m\u001b[37m"+c+c+c+c+c+c+c+c+c+c+c+c+c+"\u001b[0m\u001b[47m  \u001b[0m\t");
            System.out.print("\t\u001b[47m  \u001b[44m\u001b[37m"+c+c+c+c+c+c+c+c+c+c+c+c+c+"\u001b[0m   \u001b[42m\u001b[37m"+c+c+c+c+c+c+c+c+c+c+c+c+c+"\u001b[0m\u001b[47m  \u001b[0m\t");
            // hashie beyn e do ta
            System.out.println();
        }
        // hashie ye bein
        for (int i = 0; i < 4; ++i)
            System.out.print("\t\u001b[47m  \u001b[0m\t\t\t\t\t\t\t   \u001b[47m  \u001b[0m\t");
        System.out.println();
        //badaneye dovvom
        for (int i = 1; i < 7; ++i) {
            System.out.print("\t\u001b[47m  \u001b[43m\u001b[37m"+c+c+c+c+c+c+c+c+c+c+c+c+c+"\u001b[0m   \u001b[41m\u001b[37m"+c+c+c+c+c+c+c+c+c+c+c+c+c+"\u001b[0m\u001b[47m  \u001b[0m\t");
            System.out.print("\t\u001b[47m  \u001b[43m\u001b[37m"+c+c+c+c+c+c+c+c+c+c+c+c+c+"\u001b[0m   \u001b[41m\u001b[37m"+c+c+c+c+c+c+c+c+c+c+c+c+c+"\u001b[0m\u001b[47m  \u001b[0m\t");
            System.out.print("\t\u001b[47m  \u001b[43m\u001b[37m"+c+c+c+c+c+c+c+c+c+c+c+c+c+"\u001b[0m   \u001b[41m\u001b[37m\t\t\t   \u001b[0m\u001b[47m  \u001b[0m\t");
            System.out.print("\t\u001b[47m  \u001b[43m\u001b[37m\t\t\t   \u001b[0m   \u001b[41m\u001b[37m"+c+c+c+c+c+c+c+c+c+c+c+c+c+"\u001b[0m\u001b[47m  \u001b[0m\t");
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
}
