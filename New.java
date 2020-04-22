package com.company;

import java.util.LinkedList;

import static com.company.Color.*;

public class New {
    public static void main(String[] args) {



    }




    public  void upDown3(int number1, int number2 , int row , int color) {
        int width = 18;
        if (number1 > 0) {
            System.out.print(BLUE_BACKGROUND + "\t\t\t\t\t\t" + RESET);
        } else
            System.out.print("\t\t\t\t\t\t");
        if(row<2)
            colorInMiddle(color);
        else
        for (int i = 0; i < width; ++i) {
            System.out.print("\t\t");
        }

        if (number2 >= 1) {
            System.out.println(BLUE_BACKGROUND + "\t\t\t\t\t\t" + RESET);
        } else
            System.out.println("\t\t\t\t\t\t");
    }


    public  void edge3(int number1, int number2) {
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

            if(k==0)
                colorInMiddleNumber(3,4);
            else if(k==1)
            colorInMiddle(3);
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
            upDown3(number1, number2 , k,3);
            if(k<1) {
                System.out.print("\t\t\t\t\t\t");
                colorInMiddle(3);
                System.out.println();
            }
           else if(k==1)
            {
                colorInTheSide(3);
            }
        else
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

    public  void block() {
        int a = 3664;
        char b = (char) a;
        int width = 18;
        System.out.print(BLUE_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + BLUE_BACKGROUND + "   " + RESET);
        for (int i = 0; i < width; ++i)
            System.out.print("\t\t");
        System.out.println(BLUE_BACKGROUND + "   " + BLACK_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + " " + b + BLUE_BACKGROUND + "   " + RESET);
    }


    public void sides(int number1, int number2) {
        int width = 18 ;
        int fakeNumber1 = number1;
        int fakeNumber2 = number2;
        if (number1 > 5)
            fakeNumber1 = 5;
        if (number2 > 5)
            fakeNumber2 = 5;
        // top of the complete card
        upDown3(fakeNumber1, fakeNumber2,10,3);
        //just block
        block();

        // print number of the card
        edge3Number(number1, number2);
        //just block
        block();
        // down of the complete card
        upDown3(fakeNumber1, fakeNumber2,10,3);
        colorInTheSide(3);
        edge3(fakeNumber1, fakeNumber2);
        System.out.println();
    }

    public void colorInTheSide(int color)
    {   int width = 18 ;

        for (int i = 0; i < width - 9; ++i)
            System.out.print("\t\t");
        System.out.print(BLUE_BACKGROUND + "   \t\t\t     " +RESET);
        System.out.print("\t");
        if(color == 1)
            System.out.print(BLUE_BACKGROUND + "   \t\t\t     " +RESET);
        if(color == 2)
            System.out.print(RED_BACKGROUND + "   \t\t\t     " +RESET);
        if(color == 3)
            System.out.print(YELLOW_BACKGROUND + "   \t\t\t     " +RESET);
        if(color == 4)
            System.out.print(GREEN_BACKGROUND + "   \t\t\t     " +RESET);
        for (int i = 0; i < width - 12; ++i)
            System.out.print("\t\t");
        System.out.println();
    }


    public void colorInMiddle(int color)
    {   int width = 18 ;
        int a = 3664;
        char b = (char) a;
        for (int i = 0; i < width - 12; ++i)
            System.out.print("\t\t");
        System.out.print(BLUE_BACKGROUND + "   " +BLACK_BACKGROUND_BRIGHT+BLUE_BOLD_BRIGHT+" "+b+ " "+b+ " "+b+ " "+b+ " "+b+" "+BLUE_BACKGROUND + "   " +RESET);
        System.out.print("\t");
        if(color == 1)
            System.out.print(BLUE_BACKGROUND + "   " +WHITE_BACKGROUND_BRIGHT+"\t\t\t   "+BLUE_BACKGROUND + "   " +RESET);
        if(color == 2)
            System.out.print(RED_BACKGROUND + "   " +WHITE_BACKGROUND_BRIGHT+"\t\t\t  "+RED_BACKGROUND + "   " +RESET);
        if(color == 3)
            System.out.print(YELLOW_BACKGROUND + "   " +WHITE_BACKGROUND_BRIGHT+"\t\t\t  "+YELLOW_BACKGROUND + "   " +RESET);
        if(color == 4)
            System.out.print(GREEN_BACKGROUND + "   " +WHITE_BACKGROUND_BRIGHT+"\t\t\t  "+GREEN_BACKGROUND + "   " +RESET);
        for (int i = 0; i < width - 12; ++i)
            System.out.print("\t\t ");
            System.out.print("\t\t\t");
    }
    public void colorInMiddleNumber(int color,int number)
    {   int width = 18 ;
        int a = 3664;
        char b = (char) a;
        int sign[] = new int[]{48, 49, 8635, 51, 52, 53, 54, 55, 56, 57, 8635, 9314, 9314, 9314, 9314,};
        for (int i = 0; i < width - 12; ++i)
            System.out.print("\t\t");
        System.out.print(BLUE_BACKGROUND + "   " +BLACK_BACKGROUND_BRIGHT+BLUE_BOLD_BRIGHT+" "+b+ " "+b+ " "+b+ " "+b+ " "+b+" "+BLUE_BACKGROUND + "   " +RESET);
        System.out.print("\t");
        if(color == 1)
            System.out.print(BLUE_BACKGROUND + "   " +WHITE_BACKGROUND_BRIGHT+BLACK_BOLD_BRIGHT+" "+(char)sign[number]+"\t\t  "+BLUE_BACKGROUND + "   " +RESET);
        if(color == 2)
            System.out.print(RED_BACKGROUND + "   " +WHITE_BACKGROUND_BRIGHT+BLACK_BOLD_BRIGHT+" "+(char)sign[number]+"\t\t  "+RED_BACKGROUND + "   " +RESET);
        if(color == 3)
            System.out.print(YELLOW_BACKGROUND + "   " +WHITE_BACKGROUND_BRIGHT+BLACK_BOLD_BRIGHT+" "+(char)sign[number]+"\t\t  "+YELLOW_BACKGROUND + "   " +RESET);
        if(color == 4)
            System.out.print(GREEN_BACKGROUND + "   " +WHITE_BACKGROUND_BRIGHT+BLACK_BOLD_BRIGHT+" "+(char)sign[number]+"\t\t  "+GREEN_BACKGROUND + "   " +RESET);
        for (int i = 0; i < width - 12; ++i)
            System.out.print("\t\t ");
            System.out.print("\t\t\t");
    }



}