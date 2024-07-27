package com.techelevator.vend;

public class Cashier {


    public static final int NICKEL_VALUE_IN_CENTS = 5;
    public static final int DIME_VALUE_IN_CENTS = 10;
    public static final int QUARTER_VALUE_IN_CENTS = 25;

    public static int[] getChange(double moneyRemaining){
        int nickels = 0;
        int dimes = 0;
        int quarters = 0;

        int money = (int) (moneyRemaining * 100);

        quarters = money / QUARTER_VALUE_IN_CENTS;
        money = money % QUARTER_VALUE_IN_CENTS;
        dimes = money / DIME_VALUE_IN_CENTS;
        money = money % DIME_VALUE_IN_CENTS;
        nickels = money / NICKEL_VALUE_IN_CENTS;

        return new int[]{nickels, dimes, quarters};
    }

    public static String getChangeMessage(int[] coins){
        String message = "Dispensing";
        int nickels = coins[0];
        int dimes = coins[1];
        int quarters = coins[2];

        if (nickels > 0) message += " " + nickels + " nickels";
        if (dimes > 0) message += " " + dimes + " dimes";
        if (quarters > 0) message += " " + quarters + " quarters";

        if(nickels == 0 && dimes == 0 && quarters == 0) message = "No change";

        return message;
    }

}
