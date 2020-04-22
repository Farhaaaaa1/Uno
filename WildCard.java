package com.company;

import java.util.Scanner;

public class WildCard extends Card {
    public WildCard(int color, int number) {
        super(color, number);
    }

    public void setTheColor() {
        int color;
        System.out.println();
        Scanner Input = new Scanner(System.in);
        do {
            Printing.printChangeColor();
            color = Input.nextInt();
            if(color < 0 || color > 5)
                System.out.println("out of range try again ... ");
        } while (color < 0 && color > 5);
        super.setColor(color);
    }
}
